package vn.com.framgia.movie_db26.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language implements Parcelable{
    @SerializedName("iso_639_1")
    @Expose
    private String mIso;
    @SerializedName("name")
    @Expose
    private String mName;

    protected Language(Parcel in) {
        mIso = in.readString();
        mName = in.readString();
    }

    public static final Creator<Language> CREATOR = new Creator<Language>() {
        @Override
        public Language createFromParcel(Parcel in) {
            return new Language(in);
        }

        @Override
        public Language[] newArray(int size) {
            return new Language[size];
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
