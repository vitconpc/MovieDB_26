package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CastResponse;

public interface ListCastDataSource {
    interface ListCastRemoteDataSource {
        Observable<CastResponse> getListDataById(int id);
    }
}
