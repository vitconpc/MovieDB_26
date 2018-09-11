package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.source.MostPopularDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class MostPopularRemoteDataSourceImpl implements MostPopularDataSource.MostPopularRemoteDataSource {
    private static MostPopularRemoteDataSourceImpl sMostPopularRemoteDataSource;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private MostPopularRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static MostPopularRemoteDataSourceImpl getInstance(Context context) {
        if (sMostPopularRemoteDataSource == null) {
            sMostPopularRemoteDataSource = new MostPopularRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sMostPopularRemoteDataSource;
    }

    @Override
    public Observable<FilmResponse> getMostPopular(int page) {
        return mNameAPI.getFilmMostPopular(API_KEY,page);
    }
}
