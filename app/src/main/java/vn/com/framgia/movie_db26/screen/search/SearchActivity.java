package vn.com.framgia.movie_db26.screen.search;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    private SearchViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding binding = DataBindingUtil.setContentView(this
                ,R.layout.activity_search);
        mViewModel = new SearchViewModel(this);
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
