package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.TrailerResponse;

public interface TrainerDataSource {
    interface TrainerRemoteDataSource{
        Observable<TrailerResponse> getData(int id);
    }
}
