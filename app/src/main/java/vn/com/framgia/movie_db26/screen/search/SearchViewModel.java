package vn.com.framgia.movie_db26.screen.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.reponsitory.SearchRepository;
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
    private SearchRepository mRepository;

    public SearchViewModel(Context context) {
        mContext = context;
        gone.set(View.VISIBLE);
        setData();
    }

    private void setData() {
        mRepository = SearchRepository.getInstance(mContext);
        mCompositeDisposable = new CompositeDisposable();
        mProvider = SchedulerProvider.getInstance();
        mSearchFilmAdapter = new SearchFilmAdapter();
        mSearchFilmAdapter.setListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (!v.getText().toString().isEmpty()){
            SearchData(v.getText().toString());
        }
        return false;
    }

    private void SearchData(String key) {
        Disposable disposable = mRepository.getListByName(key)
                .subscribeOn(mProvider.io())
                .observeOn(mProvider.io())
                .subscribe(new Consumer<FilmResponse>() {
                    @Override
                    public void accept(FilmResponse filmResponse) throws Exception {
                        if (filmResponse.getResults().size() != 0){
                            mSearchFilmAdapter.setFilms(filmResponse.getResults());
                            searchAdapter.set(mSearchFilmAdapter);
                            gone.set(View.GONE);
                        }else {
                            gone.set(View.VISIBLE);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
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

    public void onBack(View view){
        ((Activity) mContext).finish();
    }
}
