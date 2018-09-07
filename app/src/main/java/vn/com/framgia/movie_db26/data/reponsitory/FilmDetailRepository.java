package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.data.source.FilmDetailDataSource;
import vn.com.framgia.movie_db26.data.source.remote.FilmDetailRemoteDataSourceImpl;

public class FilmDetailRepository {
    private static FilmDetailRepository sInstance;
    private FilmDetailDataSource.FilmDetailRemoteDataSource mSource;

    private FilmDetailRepository(FilmDetailDataSource.FilmDetailRemoteDataSource source) {
        mSource = source;
    }

    public static synchronized FilmDetailRepository getInstance(Context context) {
        if (sInstance == null){
            sInstance = new FilmDetailRepository(
                    FilmDetailRemoteDataSourceImpl.getInstance(context));
        }
        return sInstance;
    }

    public Observable<FilmDetail> getFilmDetail(int id){
        return mSource.getFilmDetail(id);
    }
}
