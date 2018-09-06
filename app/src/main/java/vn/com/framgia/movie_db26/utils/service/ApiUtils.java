package vn.com.framgia.movie_db26.utils.service;

import android.content.Context;

public class ApiUtils {
    private static final String BASE_URL = "https://api.themoviedb.org";
    private static NameAPI sInstance;

    public static NameAPI getInstance(Context context){
        if (sInstance == null){
            sInstance = RetrofitClient.createService(context,BASE_URL,NameAPI.class);
        }
        return sInstance;
    }
}
