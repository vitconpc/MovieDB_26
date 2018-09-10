package vn.com.framgia.movie_db26.data.reponsitory;

import android.content.Context;

import io.reactivex.Observable;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.source.SearchDataSource;
import vn.com.framgia.movie_db26.data.source.remote.SearchRemoteDataSourceImpl;

public class SearchRepository {
    private static SearchRepository sInstance;
    private SearchDataSource.SearchRemoteDataSource mSource;

    private SearchRepository(SearchDataSource.SearchRemoteDataSource source) {
        mSource = source;
    }

    public static SearchRepository getInstance(Context context) {
        if (sInstance == null){
            sInstance = new SearchRepository(SearchRemoteDataSourceImpl.getInstance(context));
        }
        return sInstance;
    }

    public Observable<FilmResponse> getListByName(String name){
        return mSource.getListByName(name);
    }
}
