package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.ListGenresDataSource;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class ListGenresRemoteDataSourceImpl implements ListGenresDataSource.ListGenresRemoteDataSource {
    private static ListGenresRemoteDataSourceImpl sIntance;
    private String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private ListGenresRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static ListGenresRemoteDataSourceImpl getIntance(Context context) {
        if (sIntance == null){
            sIntance = new ListGenresRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sIntance;
    }

    @Override
    public Observable<FilmResponse> getList(int key) {
        return mNameAPI.getListByGenre(API_KEY,key, Constants.PAGE_1);
    }
}
