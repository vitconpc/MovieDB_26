package vn.com.framgia.movie_db26.screen.youtube;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityYoutubeBinding;

public class YoutubeActivity extends YouTubeBaseActivity {

    private YoutubeViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityYoutubeBinding binding = DataBindingUtil.setContentView(this
                ,R.layout.activity_youtube);
        mViewModel = new YoutubeViewModel(getIntent());
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
