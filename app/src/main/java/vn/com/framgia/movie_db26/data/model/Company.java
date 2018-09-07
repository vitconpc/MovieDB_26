package vn.com.framgia.movie_db26.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable {
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

    protected Company(Parcel in) {
        mId = in.readInt();
        mLogoPath = in.readString();
        mName = in.readString();
        mOriginCountry = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mLogoPath);
        dest.writeString(mName);
        dest.writeString(mOriginCountry);
    }
}
