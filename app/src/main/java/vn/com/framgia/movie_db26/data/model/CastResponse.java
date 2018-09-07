package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastResponse {
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("cast")
    @Expose
    private List<Cast> mCasts = null;
    @SerializedName("crew")
    @Expose
    private List<Crew> mCrews = null;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<Cast> getCasts() {
        return mCasts;
    }

    public void setCasts(List<Cast> casts) {
        mCasts = casts;
    }

    public List<Crew> getCrews() {
        return mCrews;
    }

    public void setCrews(List<Crew> crews) {
        mCrews = crews;
    }
}
