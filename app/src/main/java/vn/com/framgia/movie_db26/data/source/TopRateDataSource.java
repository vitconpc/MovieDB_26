package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;

public interface TopRateDataSource {
    interface TopRateRemoteDataSource {
        Observable<FilmResponse> getTopRate(int page);
    }
}
