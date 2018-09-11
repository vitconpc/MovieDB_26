package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastDetail {
    @SerializedName("birthday")
    @Expose
    private String mBirthday;
    @SerializedName("known_for_department")
    @Expose
    private String mKnownForDepartment;
    @SerializedName("deathday")
    @Expose
    private String mDeathday;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("also_known_as")
    @Expose
    private List<String> mAlsoKnownAs = null;
    @SerializedName("gender")
    @Expose
    private int mGender;
    @SerializedName("biography")
    @Expose
    private String mBiography;
    @SerializedName("popularity")
    @Expose
    private double mPopularity;
    @SerializedName("place_of_birth")
    @Expose
    private String mPlaceOfBirth;
    @SerializedName("profile_path")
    @Expose
    private String mProfilePath;
    @SerializedName("adult")
    @Expose
    private Boolean mAdult;
    @SerializedName("imdb_id")
    @Expose
    private String mImdbId;
    @SerializedName("homepage")
    @Expose
    private String mHomepage;

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public String getKnownForDepartment() {
        return mKnownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        mKnownForDepartment = knownForDepartment;
    }

    public String getDeathday() {
        return mDeathday;
    }

    public void setDeathday(String deathday) {
        mDeathday = deathday;
    }

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

    public List<String> getAlsoKnownAs() {
        return mAlsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        mAlsoKnownAs = alsoKnownAs;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int gender) {
        mGender = gender;
    }

    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(double popularity) {
        mPopularity = popularity;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        mPlaceOfBirth = placeOfBirth;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String imdbId) {
        mImdbId = imdbId;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }
}
