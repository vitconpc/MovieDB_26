package vn.com.framgia.movie_db26.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.data.model.Genre;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.reponsitory.GenresRepository;
import vn.com.framgia.movie_db26.data.source.remote.GenresRemoteDataSource;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.utils.rx.BaseSchedulerProvider;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class HomeFragmentViewModel extends BaseObservable implements OnItemClickListener, View.OnClickListener
        , OnItemFilmClickListener, BaseViewModel {

    private CompositeDisposable mCompositeDisposable;
    private ViewPager mViewPager;
    private Context mContext;
    private GenresAdapter mGenresAdapter;
    private FilmAdapter mMostPuparAdapter;
    private FilmAdapter mUpComingAdapter;
    private FilmAdapter mTopRateAdapter;
    private GenresRepository mGenresRepository;
    private BaseSchedulerProvider mSchedulerProvider;

    public HomeFragmentViewModel(Context context) {
        this.mContext = context;
        setData();
    }

    private void setData() {
        //todo get data from remote
        mCompositeDisposable = new CompositeDisposable();
        mGenresRepository = GenresRepository.getInstace(GenresRemoteDataSource.getInstance(mContext));
        mSchedulerProvider = SchedulerProvider.getInstance();
        initAdapter();
        setListener();
        getData();
    }

    private void initAdapter() {
        mGenresAdapter = new GenresAdapter();
        List<Film> films = new ArrayList<>();
        mTopRateAdapter = new FilmAdapter(films);
        mUpComingAdapter = new FilmAdapter(films);
        mMostPuparAdapter = new FilmAdapter(films);
    }

    private void setListener() {
        mGenresAdapter.setListener(this);
        mMostPuparAdapter.setmListener(this);
        mTopRateAdapter.setmListener(this);
        mUpComingAdapter.setmListener(this);
    }

    @Bindable
    public FilmAdapter getMostPuparAdapter() {
        return mMostPuparAdapter;
    }

    @Bindable
    public FilmAdapter getUpComingAdapter() {
        return mUpComingAdapter;
    }

    @Bindable
    public FilmAdapter getTopRateAdapter() {
        return mTopRateAdapter;
    }

    @Bindable
    public GenresAdapter getGenresAdapter() {
        return mGenresAdapter;
    }

    @Override
    public void onClickItem(Genre genre) {
        //todo go to list screen
    }

    @Override
    public void onClick(View v) {
        //todo go to search screen
    }

    @Override
    public void onClickItem(Film film) {
        //todo go to detail screen
    }

    public void getData() {
        GetAllGenres();
    }

    private void GetAllGenres() {
        Disposable disposable = mGenresRepository.getListGenres()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<GenresRespone>() {
                    @Override
                    public void accept(GenresRespone genresRespone) throws Exception {
                        mGenresAdapter.setGenres(genresRespone.getGenres());
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
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
