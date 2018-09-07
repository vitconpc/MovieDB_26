package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crew {
    @SerializedName("credit_id")
    @Expose
    private String mCreditId;
    @SerializedName("department")
    @Expose
    private String mDepartment;
    @SerializedName("gender")
    @Expose
    private int mGender;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("job")
    @Expose
    private String mJob;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("profile_path")
    @Expose
    private String mProfilePath;

    public String getCreditId() {
        return mCreditId;
    }

    public void setCreditId(String creditId) {
        mCreditId = creditId;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setDepartment(String department) {
        mDepartment = department;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int gender) {
        mGender = gender;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }
}
