package vn.com.framgia.movie_db26.utils.service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.model.GenresRespone;

public interface NameAPI {
    @GET("/3/genre/movie/list")
    Observable<GenresRespone> getAllGenres(@Query("api_key") String apiKey);

    @GET("/3/movie/popular")
    Observable<FilmResponse> getFilmMostPopular(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/upcoming")
    Observable<FilmResponse> getFilmUpcoming(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/top_rated")
    Observable<FilmResponse> getFilmTopRate(@Query("api_key") String apiKey, @Query("page") int page);
}
