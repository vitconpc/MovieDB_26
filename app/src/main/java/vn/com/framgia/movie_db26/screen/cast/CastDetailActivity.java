package vn.com.framgia.movie_db26.screen.cast;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityCastDetailBinding;

public class CastDetailActivity extends AppCompatActivity {

    private CastDetailViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCastDetailBinding binding = DataBindingUtil.setContentView(this
                ,R.layout.activity_cast_detail);
        mViewModel = new CastDetailViewModel(this,getIntent());
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
