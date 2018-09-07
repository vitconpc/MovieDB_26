package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.TopRateDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class TopRateRemoteDataSourceImpl implements TopRateDataSource.TopRateRemoteDataSource {
    private static TopRateRemoteDataSourceImpl sTopRateRemoteDataSource;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    public TopRateRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static TopRateRemoteDataSourceImpl getInstance(Context context) {
        if (sTopRateRemoteDataSource == null) {
            sTopRateRemoteDataSource = new TopRateRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sTopRateRemoteDataSource;
    }

    @Override
    public Observable<FilmResponse> getTopRate(int page) {
        return mNameAPI.getFilmTopRate(API_KEY, page);
    }
}
