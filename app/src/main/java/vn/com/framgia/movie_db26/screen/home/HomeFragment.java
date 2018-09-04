package vn.com.framgia.movie_db26.screen.home;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private static HomeFragment mHomeFragment;
    private HomeFragmentViewModel mViewModel;

    public HomeFragment() {
    }

    public static HomeFragment getInstance() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_home, container, false);
        mViewModel = new HomeFragmentViewModel();
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
