package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.source.GenresDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class GenresRemoteDataSourceImpl implements GenresDataSource.GenresRemoteDataSource {

    private static GenresRemoteDataSourceImpl sGenresRemoteDataSource;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    public static GenresRemoteDataSourceImpl getInstance(Context context) {
        if (sGenresRemoteDataSource == null) {
            sGenresRemoteDataSource = new GenresRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sGenresRemoteDataSource;
    }

    private GenresRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    @Override
    public Observable<GenresRespone> getAllGenres() {
        return mNameAPI.getAllGenres(API_KEY);
    }
}
