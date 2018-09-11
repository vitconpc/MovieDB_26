package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CastDetail;

public interface CastDetailDataSource {
    interface CastDetailRemoteDataSource {
        Observable<CastDetail> getCastDetail(int id);
    }
}
