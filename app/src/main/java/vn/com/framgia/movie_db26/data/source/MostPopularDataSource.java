package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;

public interface MostPopularDataSource {
    interface MostPopularRemoteDataSource {
        Observable<FilmResponse> getMostPopular(int page);
    }
}
