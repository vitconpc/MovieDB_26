package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.TrailerResponse;
import vn.com.framgia.movie_db26.data.source.TrainerDataSource;
import vn.com.framgia.movie_db26.data.source.remote.TrainerRemoteDataSourceImpl;

public class TrailerRepository {
    private static TrailerRepository sInstance;
    private TrainerDataSource.TrainerRemoteDataSource mSource;

    private TrailerRepository(TrainerDataSource.TrainerRemoteDataSource source) {
        mSource = source;
    }

    public static TrailerRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TrailerRepository(TrainerRemoteDataSourceImpl.getInstance(context));
        }
        return sInstance;
    }

    public Observable<TrailerResponse> getData(int id){
        return mSource.getData(id);
    }
}
