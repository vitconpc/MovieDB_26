package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.ListGenresDataSource;
import vn.com.framgia.movie_db26.data.source.remote.ListGenresRemoteDataSourceImpl;

public class ListGenresRepository {
    private static ListGenresRepository sIntance;
    private ListGenresDataSource.ListGenresRemoteDataSource mSource;

    public ListGenresRepository(ListGenresRemoteDataSourceImpl source) {
        mSource = source;
    }

    public static synchronized ListGenresRepository getIntance(Context context) {
        if (sIntance == null){
            sIntance = new ListGenresRepository(
                    ListGenresRemoteDataSourceImpl.getIntance(context));
        }
        return sIntance;
    }

    public Observable<FilmResponse> getFilmByGenres(int key){
        return mSource.getList(key);
    }
}
