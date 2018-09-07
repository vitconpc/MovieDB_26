package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CastResponse;
import vn.com.framgia.movie_db26.data.source.ListCastDataSource;
import vn.com.framgia.movie_db26.data.source.remote.ListCastRemoteDataSourceImpl;

public class ListCastRepository {
    private static ListCastRepository sInstance;
    private ListCastDataSource.ListCastRemoteDataSource mDataSource;

    public ListCastRepository(Context context) {
        mDataSource = ListCastRemoteDataSourceImpl.getInstance(context);
    }

    public static synchronized ListCastRepository getInstance(Context context) {
        if(sInstance == null){
            sInstance = new ListCastRepository(context);
        }
        return sInstance;
    }

    public Observable<CastResponse> getListCast(int id){
        return mDataSource.getListDataById(id);
    }
}
