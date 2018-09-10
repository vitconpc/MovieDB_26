package vn.com.framgia.movie_db26.screen.youtube;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;
import java.util.List;

import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.data.model.Trailer;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.utils.common.Constants;

public class YoutubeViewModel extends BaseObservable implements BaseViewModel, OnItemTrailerClickListener {

    private List<Trailer> mTrailers;
    private List<String> mVideoKeys;
    public ObservableField<FilmDetail> filmDetail = new ObservableField<>();
    private YouTubePlayer mTubePlayer;
    private YouTubePlayer.OnInitializedListener mListener;
    private MoreTrailerAdapter mMoreTrailerAdapter;

    public YoutubeViewModel(Intent intent) {
        FilmDetail film = intent.getParcelableExtra(Constants.FILM_DETTAIL);
        mTrailers = intent.getParcelableArrayListExtra(Constants.LIST);
        mVideoKeys = intent.getStringArrayListExtra(Constants.LISt_KEY);
        setData(film);
    }

    private void setData(FilmDetail film) {
        filmDetail.set(film);
        mListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider
                    , YouTubePlayer youTubePlayer, boolean b) {
                mTubePlayer = youTubePlayer;
                mTubePlayer.loadVideos(mVideoKeys, 0, 0);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider
                    , YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        mMoreTrailerAdapter = new MoreTrailerAdapter();
        mMoreTrailerAdapter.setTrailers(mTrailers);
        mMoreTrailerAdapter.setListener(this);
    }


    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    @Bindable
    public YouTubePlayer.OnInitializedListener getListener() {
        return mListener;
    }

    @Override
    public void onClick(Trailer trailer) {
        mTubePlayer.loadVideo(trailer.getKey(),0);
    }

    @Bindable
    public MoreTrailerAdapter getMoreTrailerAdapter() {
        return mMoreTrailerAdapter;
    }
}
