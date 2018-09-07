package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.UpcomingDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class UpcomingRemoteDataSourceImpl implements UpcomingDataSource.UpcomingRemoteDataSource {
    private static UpcomingRemoteDataSourceImpl sUpcomingRemoteDataSource;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    public UpcomingRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static UpcomingRemoteDataSourceImpl getInstance(Context context) {
        if (sUpcomingRemoteDataSource == null) {
            sUpcomingRemoteDataSource = new UpcomingRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sUpcomingRemoteDataSource;
    }

    @Override
    public Observable<FilmResponse> getUpcoming(int page) {
        return mNameAPI.getFilmUpcoming(API_KEY, page);
    }
}
