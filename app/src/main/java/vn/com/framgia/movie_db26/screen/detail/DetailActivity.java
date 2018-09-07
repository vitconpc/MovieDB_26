package vn.com.framgia.movie_db26.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private DetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(
                DetailActivity.this,R.layout.activity_detail);
        mViewModel = new DetailViewModel(this,getIntent());
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.onStop();
    }
}
