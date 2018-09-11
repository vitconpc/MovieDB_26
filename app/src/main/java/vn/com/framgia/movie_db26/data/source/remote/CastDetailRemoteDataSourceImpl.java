package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.CastDetail;
import vn.com.framgia.movie_db26.data.source.CastDetailDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class CastDetailRemoteDataSourceImpl implements CastDetailDataSource.CastDetailRemoteDataSource {
    private static CastDetailRemoteDataSourceImpl sInstance;
    private String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private CastDetailRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static synchronized CastDetailRemoteDataSourceImpl getInstance(Context context) {
        if (sInstance == null){
            sInstance = new CastDetailRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sInstance;
    }

    @Override
    public Observable<CastDetail> getCastDetail(int id) {
        return mNameAPI.getCastDetail(id,API_KEY);
    }
}
