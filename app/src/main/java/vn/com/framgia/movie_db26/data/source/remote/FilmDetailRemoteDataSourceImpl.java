package vn.com.framgia.movie_db26.data.source.remote;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.BuildConfig;
import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.data.source.FilmDetailDataSource;
import vn.com.framgia.movie_db26.utils.service.ApiUtils;
import vn.com.framgia.movie_db26.utils.service.NameAPI;

public class FilmDetailRemoteDataSourceImpl implements
        FilmDetailDataSource.FilmDetailRemoteDataSource {

    private static FilmDetailRemoteDataSourceImpl sInstance;
    private static final String API_KEY = BuildConfig.API_KEY;
    private NameAPI mNameAPI;

    private FilmDetailRemoteDataSourceImpl(NameAPI nameAPI) {
        mNameAPI = nameAPI;
    }

    public static FilmDetailRemoteDataSourceImpl getInstance(Context context) {
        if (sInstance == null){
            sInstance = new FilmDetailRemoteDataSourceImpl(ApiUtils.getInstance(context));
        }
        return sInstance;
    }

    @Override
    public Observable<FilmDetail> getFilmDetail(int id) {
        return mNameAPI.getFilm(id,API_KEY);
    }
}
