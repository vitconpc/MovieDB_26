package vn.com.framgia.movie_db26.screen.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.screen.favorite.FavoriteFragment;
import vn.com.framgia.movie_db26.screen.home.HomeFragment;

public class MainViewModel extends BaseViewModel implements BottomNavigationView.OnNavigationItemSelectedListener {


    private FragmentManager mFragmentManager;
    private Fragment mFragment;
    private HomeFragment mHomeFragment;
    private FavoriteFragment mFavoriteFragment;

    public MainViewModel(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        createFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                changeFragment(mFragment, mHomeFragment);
                mFragment = mHomeFragment;
                return true;
            case R.id.menu_favorite:
                changeFragment(mFragment, mFavoriteFragment);
                mFragment = mFavoriteFragment;
                return true;
        }
        return false;
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onStop() {

    }

    private void createFragment() {
        mHomeFragment = HomeFragment.getInstance();
        mFavoriteFragment = FavoriteFragment.getInstance();
        mFragmentManager.beginTransaction().add(R.id.frame_container, mFavoriteFragment).commit();
        mFragmentManager.beginTransaction().add(R.id.frame_container, mHomeFragment).commit();
        mFragmentManager.beginTransaction().hide(mFavoriteFragment).commit();
        mFragment = mHomeFragment;
    }

    private void changeFragment(Fragment one, Fragment two) {
        mFragmentManager.beginTransaction().hide(one).show(two).commit();
    }
}
