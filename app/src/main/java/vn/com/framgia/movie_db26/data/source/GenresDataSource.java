package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.GenresRespone;

public interface GenresDataSource {
    interface GenresRemoteDataSource {
        Observable<GenresRespone> getAllGenres();
    }
}
