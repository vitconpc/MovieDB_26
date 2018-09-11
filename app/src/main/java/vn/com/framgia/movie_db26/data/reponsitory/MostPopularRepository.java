package vn.com.framgia.movie_db26.data.reponsitory;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.MostPopularDataSource;

public class MostPopularRepository {
    private static MostPopularRepository sInstance;
    private MostPopularDataSource.MostPopularRemoteDataSource mMostPopularRemoteDataSource;

    private MostPopularRepository(MostPopularDataSource.MostPopularRemoteDataSource mostPopularRemoteDataSource) {
        mMostPopularRemoteDataSource = mostPopularRemoteDataSource;
    }

    public static synchronized MostPopularRepository getInstance(
            MostPopularDataSource.MostPopularRemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new MostPopularRepository(remoteDataSource);
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    public Observable<FilmResponse> getListMostPopular(int page) {
        return mMostPopularRemoteDataSource.getMostPopular(page);
    }
}
