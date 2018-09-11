package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CastDetail;
import vn.com.framgia.movie_db26.data.source.CastDetailDataSource;
import vn.com.framgia.movie_db26.data.source.remote.CastDetailRemoteDataSourceImpl;

public class CastDetailRepository {
    private static CastDetailRepository sInstance;
    private CastDetailDataSource.CastDetailRemoteDataSource mSource;

    private CastDetailRepository(CastDetailDataSource.CastDetailRemoteDataSource source) {
        mSource = source;
    }

    public static CastDetailRepository getInstance(Context context) {
        if (sInstance == null){
            sInstance = new CastDetailRepository(CastDetailRemoteDataSourceImpl
                    .getInstance(context));
        }
        return sInstance;
    }

    public Observable<CastDetail> getCastDetailByID(int id){
        return mSource.getCastDetail(id);
    }
}
