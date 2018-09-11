package vn.com.framgia.movie_db26.data.reponsitory;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.UpcomingDataSource;

public class UpcomingRepository {
    private static UpcomingRepository sInstance;
    private UpcomingDataSource.UpcomingRemoteDataSource mDataSource;

    private UpcomingRepository(UpcomingDataSource.UpcomingRemoteDataSource dataSource) {
        mDataSource = dataSource;
    }

    public static synchronized UpcomingRepository getInstance(
            UpcomingDataSource.UpcomingRemoteDataSource dataSource) {
        if (sInstance == null) {
            sInstance = new UpcomingRepository(dataSource);
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    public Observable<FilmResponse> getUpcomming(int page) {
        return mDataSource.getUpcoming(page);
    }
}
