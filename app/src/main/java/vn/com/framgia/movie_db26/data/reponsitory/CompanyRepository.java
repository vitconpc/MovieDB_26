package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CompanyProfile;
import vn.com.framgia.movie_db26.data.source.CompanyDataSource;
import vn.com.framgia.movie_db26.data.source.remote.CompanyRemoteDataSourceImpl;

public class CompanyRepository {
    private static CompanyRepository sInstance;
    private CompanyDataSource.CompanyRemoteDataSource mSource;

    private CompanyRepository(CompanyDataSource.CompanyRemoteDataSource source) {
        mSource = source;
    }

    public static synchronized CompanyRepository getInstance(Context context) {
        if (sInstance == null){
            sInstance = new CompanyRepository(CompanyRemoteDataSourceImpl
                    .getIntance(context));
        }
        return sInstance;
    }

    public Observable<CompanyProfile> getCompany(int id){
        return mSource.getCompany(id);
    }
}
