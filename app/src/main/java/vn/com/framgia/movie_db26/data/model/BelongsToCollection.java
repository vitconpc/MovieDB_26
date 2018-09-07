package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BelongsToCollection {
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("backdrop_path")
    @Expose
    private String mBackdropPath;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }
}
