package vn.com.framgia.movie_db26.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mViewModel = new MainViewModel(mFragmentManager);
        binding.setViewModel(mViewModel);
    }
}
