package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.CompanyProfile;
import vn.com.framgia.movie_db26.data.source.CompanyDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class CompanyRemoteDataSourceImpl implements CompanyDataSource.CompanyRemoteDataSource {
    private static CompanyRemoteDataSourceImpl sIntance;
    private String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private CompanyRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static CompanyRemoteDataSourceImpl getIntance(Context context) {
        if (sIntance == null) {
            sIntance = new CompanyRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sIntance;
    }

    @Override
    public Observable<CompanyProfile> getCompany(int id) {
        return mNameAPI.getCompany(id, API_KEY);
    }
}
