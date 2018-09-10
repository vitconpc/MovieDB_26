package vn.com.framgia.movie_db26.utils.service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.com.framgia.movie_db26.data.model.CastResponse;
import vn.com.framgia.movie_db26.data.model.CompanyProfile;
import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.model.TrailerResponse;

public interface NameAPI {
    @GET("/3/genre/movie/list")
    Observable<GenresRespone> getAllGenres(@Query("api_key") String apiKey);

    @GET("/3/movie/popular")
    Observable<FilmResponse> getFilmMostPopular(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/upcoming")
    Observable<FilmResponse> getFilmUpcoming(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/top_rated")
    Observable<FilmResponse> getFilmTopRate(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/{movie_id}")
    Observable<FilmDetail> getFilm(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}/credits")
    Observable<CastResponse> getListCast(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}/videos")
    Observable<TrailerResponse> getLisTrainer(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("/3/discover/movie")
    Observable<FilmResponse> getListByGenre(@Query("api_key") String apiKey, @Query("with_genres") int genre
            , @Query("page") int page);

    @GET("/3/search/movie")
    Observable<FilmResponse> getListByName(@Query("api_key") String apiKey, @Query("query") String query
            , @Query("page") int page);

    @GET("/3/company/{company_id}")
    Observable<CompanyProfile> getCompany(@Path("company_id") int id, @Query("api_key") String apiKey);
}
