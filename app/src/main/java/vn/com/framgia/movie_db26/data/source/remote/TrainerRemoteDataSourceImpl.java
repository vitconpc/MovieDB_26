package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.TrailerResponse;
import vn.com.framgia.movie_db26.data.source.TrainerDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class TrainerRemoteDataSourceImpl implements TrainerDataSource.TrainerRemoteDataSource {
    private static TrainerRemoteDataSourceImpl sInstance;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private TrainerRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static TrainerRemoteDataSourceImpl getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TrainerRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sInstance;
    }

    @Override
    public Observable<TrailerResponse> getData(int id) {
        return mNameAPI.getLisTrainer(id, API_KEY);
    }
}
