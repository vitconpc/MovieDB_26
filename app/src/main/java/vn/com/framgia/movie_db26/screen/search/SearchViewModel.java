package vn.com.framgia.movie_db26.screen.search;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import io.reactivex.disposables.CompositeDisposable;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.screen.detail.DetailActivity;
import vn.com.framgia.movie_db26.screen.home.OnItemFilmClickListener;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class SearchViewModel implements TextView.OnEditorActionListener
        , OnItemFilmClickListener, BaseViewModel {

    private Context mContext;
    public ObservableField<Integer> gone = new ObservableField<>();
    public ObservableField<SearchFilmAdapter> searchAdapter = new ObservableField<>();
    private SearchFilmAdapter mSearchFilmAdapter;
    private CompositeDisposable mCompositeDisposable;
    private SchedulerProvider mProvider;

    public SearchViewModel(Context context) {
        mContext = context;
        gone.set(View.VISIBLE);
        setData();
    }

    private void setData() {
        mCompositeDisposable = new CompositeDisposable();
        mProvider = SchedulerProvider.getInstance();
        mSearchFilmAdapter = new SearchFilmAdapter();
        searchAdapter.set(mSearchFilmAdapter);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    @Override
    public void onClickItem(Film film) {
        mContext.startActivity(getIntent(mContext, film));
    }

    public static Intent getIntent(Context context, Film film) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constants.ID_FILM, film.getId());
        return intent;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
