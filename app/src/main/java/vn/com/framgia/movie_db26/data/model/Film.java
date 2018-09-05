package vn.com.framgia.movie_db26.data.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Film {
    @SerializedName("vote_count")
    @Expose
    private int mVoteCount;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("video")
    @Expose
    private boolean mVideo;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("popularity")
    @Expose
    private double mPopularity;
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("original_language")
    @Expose
    private String mOriginalLanguage;
    @SerializedName("original_title")
    @Expose
    private String mOriginalTitle;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> mGenreIds = null;
    @SerializedName("backdrop_path")
    @Expose
    private String mBackdropPath;
    @SerializedName("adult")
    @Expose
    private boolean mAdult;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("release_date")
    @Expose
    private String mReleaseDate;

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(int voteCount) {
        mVoteCount = voteCount;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public boolean isVideo() {
        return mVideo;
    }

    public void setVideo(boolean video) {
        mVideo = video;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(double popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        mGenreIds = genreIds;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public boolean isAdult() {
        return mAdult;
    }

    public void setAdult(boolean adult) {
        mAdult = adult;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }
}
