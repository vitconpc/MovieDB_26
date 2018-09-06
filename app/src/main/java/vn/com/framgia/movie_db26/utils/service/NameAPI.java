package vn.com.framgia.movie_db26.utils.service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.com.framgia.movie_db26.data.model.GenresRespone;

public interface NameAPI {
    @GET("/3/genre/movie/list")
    Observable<GenresRespone> getAllGenres(@Query("api_key") String apiKey);
}
