package vn.com.framgia.movie_db26.data.reponsitory;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.source.GenresDataSource;

public class GenresRepository {
    private static GenresRepository sInstance;

    private GenresDataSource.GenresRemoteDataSource mGenresRemoteDataSource;

    private GenresRepository(GenresDataSource.GenresRemoteDataSource dataSource) {
        this.mGenresRemoteDataSource = dataSource;
    }

    public static synchronized GenresRepository getInstance(
            GenresDataSource.GenresRemoteDataSource dataSource) {
        if (sInstance == null) {
            sInstance = new GenresRepository(dataSource);
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    public Observable<GenresRespone> getListGenres() {
        return mGenresRemoteDataSource.getAllGenres();
    }
}
