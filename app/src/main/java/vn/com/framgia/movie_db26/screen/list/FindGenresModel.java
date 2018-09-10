package vn.com.framgia.movie_db26.screen.list;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.widget.Toast;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.model.Genre;
import vn.com.framgia.movie_db26.data.reponsitory.ListGenresRepository;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.screen.detail.DetailActivity;
import vn.com.framgia.movie_db26.screen.home.OnItemFilmClickListener;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class FindGenresModel implements OnItemFilmClickListener, BaseViewModel {

    private Context mContext;
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<FindGenresAdapter> findGenresAdapter = new ObservableField<>();
    private FindGenresAdapter mGenresAdapter;
    private SchedulerProvider mProvider;
    private ListGenresRepository mRepository;
    private CompositeDisposable mCompositeDisposable;

    public FindGenresModel(Context context, Intent intent) {
        mContext = context;
        getData(intent);
    }

    private void getData(Intent intent) {
        mProvider = SchedulerProvider.getInstance();
        mRepository = ListGenresRepository.getIntance(mContext);
        mCompositeDisposable = new CompositeDisposable();
        mGenresAdapter = new FindGenresAdapter();
        findGenresAdapter.set(mGenresAdapter);
        Genre genre = intent.getParcelableExtra(Constants.GENRE);
        title.set(genre.getName());
        getList(genre.getId());
        mGenresAdapter.setListener(this);
    }

    private void getList(int genre) {
        Disposable disposable = mRepository.getFilmByGenres(genre)
                .subscribeOn(mProvider.io())
                .observeOn(mProvider.ui())
                .subscribe(new Consumer<FilmResponse>() {
                    @Override
                    public void accept(FilmResponse filmResponse) throws Exception {
                        mGenresAdapter.setFilms(filmResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
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
}
