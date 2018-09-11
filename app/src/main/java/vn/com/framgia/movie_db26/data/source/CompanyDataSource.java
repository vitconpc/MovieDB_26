package vn.com.framgia.movie_db26.data.source;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.CompanyProfile;

public interface CompanyDataSource {
    interface CompanyRemoteDataSource{
        Observable<CompanyProfile> getCompany(int id);
    }
}
