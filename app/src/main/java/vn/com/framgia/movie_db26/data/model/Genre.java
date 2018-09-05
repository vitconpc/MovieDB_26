package vn.com.framgia.movie_db26.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.com.framgia.movie_db26.BR;

public class Genre extends BaseObservable {

    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("name")
    @Expose
    private String mName;


    public Genre() {
    }

    public Genre(String name) {
        this.mName = name;
    }

    @Bindable
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }
}
