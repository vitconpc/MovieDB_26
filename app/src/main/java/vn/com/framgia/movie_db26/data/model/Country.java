package vn.com.framgia.movie_db26.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable{
    @SerializedName("iso_3166_1")
    @Expose
    private String mIso;
    @SerializedName("name")
    @Expose
    private String mName;

    protected Country(Parcel in) {
        mIso = in.readString();
        mName = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getIso() {
        return mIso;
    }

    public void setIso(String iso) {
        mIso = iso;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mIso);
        dest.writeString(mName);
    }
}
