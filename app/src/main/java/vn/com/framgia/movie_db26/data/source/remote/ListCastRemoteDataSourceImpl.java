package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.CastResponse;
import vn.com.framgia.movie_db26.data.source.ListCastDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class ListCastRemoteDataSourceImpl implements
        ListCastDataSource.ListCastRemoteDataSource {

    private static ListCastRemoteDataSourceImpl sInstance;
    private String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private ListCastRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static synchronized ListCastRemoteDataSourceImpl getInstance(Context context) {
        if (sInstance == null){
            sInstance = new ListCastRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sInstance;
    }

    @Override
    public Observable<CastResponse> getListDataById(int id) {
        return mNameAPI.getListCast(id,API_KEY);
    }
}
