package vn.com.framgia.movie_db26.data.reponsitory;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.TopRateDataSource;

public class TopRateRepository {
    private static TopRateRepository sInstance;
    private TopRateDataSource.TopRateRemoteDataSource mDataSource;

    private TopRateRepository(TopRateDataSource.TopRateRemoteDataSource dataSource) {
        mDataSource = dataSource;
    }

    public static synchronized TopRateRepository getInstance(TopRateDataSource.TopRateRemoteDataSource dataSource) {
        if (sInstance == null) {
            sInstance = new TopRateRepository(dataSource);
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    public Observable<FilmResponse> getTopRate(int page) {
        return mDataSource.getTopRate(page);
    }
}
