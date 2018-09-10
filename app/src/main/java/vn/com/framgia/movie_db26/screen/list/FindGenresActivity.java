package vn.com.framgia.movie_db26.screen.list;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityFindGenresBinding;

public class FindGenresActivity extends AppCompatActivity {

    private FindGenresModel mFindGenresModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFindGenresBinding binding = DataBindingUtil.setContentView(this
                ,R.layout.activity_find_genres);
        mFindGenresModel = new FindGenresModel(this,getIntent());
        binding.setViewModel(mFindGenresModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFindGenresModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFindGenresModel.onStop();
    }
}
