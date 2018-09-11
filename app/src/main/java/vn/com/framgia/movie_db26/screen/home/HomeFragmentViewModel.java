package vn.com.framgia.movie_db26.screen.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.data.model.FilmResponse;
import vn.com.framgia.movie_db26.data.model.Genre;
import vn.com.framgia.movie_db26.data.model.GenresRespone;
import vn.com.framgia.movie_db26.data.reponsitory.GenresRepository;
import vn.com.framgia.movie_db26.data.reponsitory.MostPopularRepository;
import vn.com.framgia.movie_db26.data.reponsitory.TopRateRepository;
import vn.com.framgia.movie_db26.data.reponsitory.UpcomingRepository;
import vn.com.framgia.movie_db26.data.source.remote.GenresRemoteDataSourceImpl;
import vn.com.framgia.movie_db26.data.source.remote.MostPopularRemoteDataSourceImpl;
import vn.com.framgia.movie_db26.data.source.remote.TopRateRemoteDataSourceImpl;
import vn.com.framgia.movie_db26.data.source.remote.UpcomingRemoteDataSourceImpl;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.screen.detail.DetailActivity;
import vn.com.framgia.movie_db26.screen.list.FindGenresActivity;
import vn.com.framgia.movie_db26.screen.search.SearchActivity;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.BaseSchedulerProvider;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class HomeFragmentViewModel implements OnItemClickListener, View.OnClickListener
        , OnItemFilmClickListener, BaseViewModel {

    private static final int PAGE_1 = 1;
    private CompositeDisposable mCompositeDisposable;
    private ViewPager mViewPager;
    private Context mContext;
    public ObservableField<GenresAdapter> genresAdapter = new ObservableField<>();
    public ObservableField<FilmAdapter> mostPopularAdapter = new ObservableField<>();
    public ObservableField<FilmAdapter> upComingAdapter = new ObservableField<>();
    public ObservableField<FilmAdapter> topRateAdapter = new ObservableField<>();
    private GenresAdapter mGenresAdapter;
    private FilmAdapter mMostPuparAdapter;
    private FilmAdapter mUpComingAdapter;
    private FilmAdapter mTopRateAdapter;
    private GenresRepository mGenresRepository;
    private MostPopularRepository mMostPopularRepository;
    private TopRateRepository mTopRateRepository;
    private UpcomingRepository mUpcomingRepository;
    private BaseSchedulerProvider mSchedulerProvider;

    public HomeFragmentViewModel(Context context) {
        this.mContext = context;
        setData();
    }

    private void setData() {
        mCompositeDisposable = new CompositeDisposable();
        mGenresRepository = GenresRepository.getInstance(GenresRemoteDataSourceImpl.getInstance(mContext));
        mMostPopularRepository = MostPopularRepository.getInstance(MostPopularRemoteDataSourceImpl.getInstance(mContext));
        mTopRateRepository = TopRateRepository.getInstance(TopRateRemoteDataSourceImpl.getInstance(mContext));
        mUpcomingRepository = UpcomingRepository.getInstance(UpcomingRemoteDataSourceImpl.getInstance(mContext));
        mSchedulerProvider = SchedulerProvider.getInstance();
        initAdapter();
        setListener();
    }

    private void initAdapter() {
        mGenresAdapter = new GenresAdapter();
        mTopRateAdapter = new FilmAdapter();
        mUpComingAdapter = new FilmAdapter();
        mMostPuparAdapter = new FilmAdapter();
    }

    private void setListener() {
        mGenresAdapter.setListener(this);
        mMostPuparAdapter.setmListener(this);
        mTopRateAdapter.setmListener(this);
        mUpComingAdapter.setmListener(this);
    }

    @Override
    public void onClickItem(Genre genre) {
        Intent intent = new Intent(mContext, FindGenresActivity.class);
        intent.putExtra(Constants.GENRE, genre);
        mContext.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, SearchActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onClickItem(Film film) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Constants.ID_FILM, film.getId());
        mContext.startActivity(intent);
    }

    public void getData() {
        GetAllGenres();
        GetMostPopular();
        GetUpComing();
        GetTopRate();
    }

    private void GetTopRate() {
        Disposable disposable = mTopRateRepository.getTopRate(PAGE_1)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<FilmResponse>() {
                    @Override
                    public void accept(FilmResponse filmResponse) throws Exception {
                        mTopRateAdapter.setFilms(filmResponse.getResults());
                        topRateAdapter.set(mTopRateAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void GetUpComing() {
        Disposable disposable = mUpcomingRepository.getUpcomming(PAGE_1)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<FilmResponse>() {
                    @Override
                    public void accept(FilmResponse filmResponse) throws Exception {
                        mUpComingAdapter.setFilms(filmResponse.getResults());
                        upComingAdapter.set(mUpComingAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void GetMostPopular() {
        Disposable disposable = mMostPopularRepository.getListMostPopular(PAGE_1)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<FilmResponse>() {
                    @Override
                    public void accept(FilmResponse filmResponse) throws Exception {
                        mMostPuparAdapter.setFilms(filmResponse.getResults());
                        mostPopularAdapter.set(mMostPuparAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void GetAllGenres() {
        Disposable disposable = mGenresRepository.getListGenres()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<GenresRespone>() {
                    @Override
                    public void accept(GenresRespone genresRespone) throws Exception {
                        mGenresAdapter.setGenres(genresRespone.getGenres());
                        genresAdapter.set(mGenresAdapter);
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
        getData();
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
