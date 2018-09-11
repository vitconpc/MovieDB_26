package vn.com.framgia.movie_db26.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmDetail implements Parcelable {
    @SerializedName("adult")
    @Expose
    private boolean mAdult;
    @SerializedName("backdrop_path")
    @Expose
    private String mBackdropPath;
    @SerializedName("belongs_to_collection")
    @Expose
    private BelongsToCollection mBelongsToCollection;
    @SerializedName("budget")
    @Expose
    private int mBudget;
    @SerializedName("genres")
    @Expose
    private List<Genre> mGenres = null;
    @SerializedName("homepage")
    @Expose
    private String mHomepage;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("imdb_id")
    @Expose
    private String mImdbId;
    @SerializedName("original_language")
    @Expose
    private String mOriginalLanguage;
    @SerializedName("original_title")
    @Expose
    private String mOriginalTitle;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("popularity")
    @Expose
    private double mPopularity;
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("production_companies")
    @Expose
    private List<Company> mCompanies = null;
    @SerializedName("production_countries")
    @Expose
    private List<Country> mCountries = null;
    @SerializedName("release_date")
    @Expose
    private String mReleaseDate;
    @SerializedName("revenue")
    @Expose
    private int mRevenue;
    @SerializedName("runtime")
    @Expose
    private int mRuntime;
    @SerializedName("spoken_languages")
    @Expose
    private List<Language> mLanguages = null;
    @SerializedName("status")
    @Expose
    private String mStatus;
    @SerializedName("tagline")
    @Expose
    private String mTagline;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("video")
    @Expose
    private boolean mVideo;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("vote_count")
    @Expose
    private int mVoteCount;

    protected FilmDetail(Parcel in) {
        mAdult = in.readByte() != 0;
        mBackdropPath = in.readString();
        mBudget = in.readInt();
        mHomepage = in.readString();
        mId = in.readInt();
        mImdbId = in.readString();
        mOriginalLanguage = in.readString();
        mOriginalTitle = in.readString();
        mOverview = in.readString();
        mPopularity = in.readDouble();
        mPosterPath = in.readString();
        mReleaseDate = in.readString();
        mRevenue = in.readInt();
        mRuntime = in.readInt();
        mStatus = in.readString();
        mTagline = in.readString();
        mTitle = in.readString();
        mVideo = in.readByte() != 0;
        mVoteAverage = in.readFloat();
        mVoteCount = in.readInt();
    }

    public static final Creator<FilmDetail> CREATOR = new Creator<FilmDetail>() {
        @Override
        public FilmDetail createFromParcel(Parcel in) {
            return new FilmDetail(in);
        }

        @Override
        public FilmDetail[] newArray(int size) {
            return new FilmDetail[size];
        }
    };

    public boolean isAdult() {
        return mAdult;
    }

    public void setAdult(boolean adult) {
        mAdult = adult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        mBelongsToCollection = belongsToCollection;
    }

    public int getBudget() {
        return mBudget;
    }

    public void setBudget(int budget) {
        mBudget = budget;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String imdbId) {
        mImdbId = imdbId;
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

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
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

    public List<Company> getCompanies() {
        return mCompanies;
    }

    public void setCompanies(List<Company> companies) {
        mCompanies = companies;
    }

    public List<Country> getCountries() {
        return mCountries;
    }

    public void setCountries(List<Country> countries) {
        mCountries = countries;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public int getRevenue() {
        return mRevenue;
    }

    public void setRevenue(int revenue) {
        mRevenue = revenue;
    }

    public int getRuntime() {
        return mRuntime;
    }

    public void setRuntime(int runtime) {
        mRuntime = runtime;
    }

    public List<Language> getLanguages() {
        return mLanguages;
    }

    public void setLanguages(List<Language> languages) {
        mLanguages = languages;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTagline() {
        return mTagline;
    }

    public void setTagline(String tagline) {
        mTagline = tagline;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
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

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(int voteCount) {
        mVoteCount = voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (mAdult ? 1 : 0));
        dest.writeString(mBackdropPath);
        dest.writeInt(mBudget);
        dest.writeString(mHomepage);
        dest.writeInt(mId);
        dest.writeString(mImdbId);
        dest.writeString(mOriginalLanguage);
        dest.writeString(mOriginalTitle);
        dest.writeString(mOverview);
        dest.writeDouble(mPopularity);
        dest.writeString(mPosterPath);
        dest.writeString(mReleaseDate);
        dest.writeInt(mRevenue);
        dest.writeInt(mRuntime);
        dest.writeString(mStatus);
        dest.writeString(mTagline);
        dest.writeString(mTitle);
        dest.writeByte((byte) (mVideo ? 1 : 0));
        dest.writeFloat(mVoteAverage);
        dest.writeInt(mVoteCount);
    }
}
