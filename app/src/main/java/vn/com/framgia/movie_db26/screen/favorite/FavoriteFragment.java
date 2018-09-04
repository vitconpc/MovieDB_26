package vn.com.framgia.movie_db26.screen.favorite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.framgia.movie_db26.R;

public class FavoriteFragment extends Fragment {
    private static FavoriteFragment sFavoriteFragment;

    public FavoriteFragment() {
    }

    public static FavoriteFragment getInstance() {
        if (sFavoriteFragment == null) {
            sFavoriteFragment = new FavoriteFragment();
        }
        return sFavoriteFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}
