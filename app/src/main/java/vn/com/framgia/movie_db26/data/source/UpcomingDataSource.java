package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;

public interface UpcomingDataSource {
    interface UpcomingRemoteDataSource {
        Observable<FilmResponse> getUpcoming(int page);
    }
}
