package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmDetail;

public interface FilmDetailDataSource {
    interface FilmDetailRemoteDataSource {
        Observable<FilmDetail> getFilmDetail(int id);
    }
}
