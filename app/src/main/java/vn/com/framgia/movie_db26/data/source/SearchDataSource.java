package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;

public interface SearchDataSource {
    interface SearchRemoteDataSource{
        Observable<FilmResponse> getListByName(String name);
    }
}
