package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyProfile {
    @SerializedName("description")
    @Expose
    private String mDescription;
    @SerializedName("headquarters")
    @Expose
    private String mHeadquarters;
    @SerializedName("homepage")
    @Expose
    private String mHomepage;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("logo_path")
    @Expose
    private String mLogoPath;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("origin_country")
    @Expose
    private String mOriginCountry;
    @SerializedName("parent_company")
    @Expose
    private Company mCompany;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getHeadquarters() {
        return mHeadquarters;
    }

    public void setHeadquarters(String headquarters) {
        mHeadquarters = headquarters;
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

    public String getLogoPath() {
        return mLogoPath;
    }

    public void setLogoPath(String logoPath) {
        mLogoPath = logoPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        mOriginCountry = originCountry;
    }

    public Company getCompany() {
        return mCompany;
    }

    public void setCompany(Company company) {
        mCompany = company;
    }
}
