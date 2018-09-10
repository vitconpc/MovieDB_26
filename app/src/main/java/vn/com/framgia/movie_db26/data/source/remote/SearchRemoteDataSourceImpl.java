package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.SearchDataSource;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class SearchRemoteDataSourceImpl implements SearchDataSource.SearchRemoteDataSource {
    private static SearchRemoteDataSourceImpl sInstance;
    private String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private SearchRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static SearchRemoteDataSourceImpl getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SearchRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sInstance;
    }

    @Override
    public Observable<FilmResponse> getListByName(String name) {
        return mNameAPI.getListByName(API_KEY,name, Constants.PAGE_1);
    }
}
