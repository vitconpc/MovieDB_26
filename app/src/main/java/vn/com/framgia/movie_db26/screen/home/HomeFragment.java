package vn.com.framgia.movie_db26.screen.home;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.FragmentHomeBinding;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

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
        mViewModel = new HomeFragmentViewModel(getContext());
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModel.onStop();
    }
}
