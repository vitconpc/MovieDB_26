package vn.com.framgia.movie_db26.screen.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Cast;
import vn.com.framgia.movie_db26.data.model.CastResponse;
import vn.com.framgia.movie_db26.data.model.Company;
import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.data.model.Trailer;
import vn.com.framgia.movie_db26.data.model.TrailerResponse;
import vn.com.framgia.movie_db26.data.reponsitory.FilmDetailRepository;
import vn.com.framgia.movie_db26.data.reponsitory.ListCastRepository;
import vn.com.framgia.movie_db26.data.reponsitory.TrailerRepository;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.screen.cast.CastDetailActivity;
import vn.com.framgia.movie_db26.screen.company.CompanyActivity;
import vn.com.framgia.movie_db26.screen.youtube.YoutubeActivity;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.BaseSchedulerProvider;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

import static android.support.constraint.Constraints.TAG;

public class DetailViewModel implements OnClickCastItemListener
        , OnItemCompanyClickListener, BaseViewModel {

    private static final int ZERO = 0;
    private Context mContext;
    private CompositeDisposable mCompositeDisposable;
    private FilmDetailRepository mFilmDetailRepository;
    private ListCastRepository mListCastRepository;
    private TrailerRepository mTrailerRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    public ObservableField<FilmDetail> filmDetail = new ObservableField<>();
    public ObservableField<CastInDetailAdapter> castAdapter = new ObservableField<>();
    public ObservableField<CompanyInDetailAdapter> companyAdapter = new ObservableField<>();
    private ArrayList<Trailer> mTrailers = new ArrayList<>();
    private CastInDetailAdapter mCastInDetailAdapter;
    private CompanyInDetailAdapter mCompanyInDetailAdapter;

    public DetailViewModel(Context context, Intent intent) {
        mContext = context;
        int id = intent.getIntExtra(Constants.ID_FILM, ZERO);
        setData(id);
    }

    private void setData(int id) {
        mCompositeDisposable = new CompositeDisposable();
        mSchedulerProvider = SchedulerProvider.getInstance();
        setAdapter();
        setRepo();
        setListener();
        getData(id);
    }

    private void setListener() {
        mCompanyInDetailAdapter.setListener(this);
        mCastInDetailAdapter.setListener(this);
    }

    private void setRepo() {
        mFilmDetailRepository = FilmDetailRepository.getInstance(mContext);
        mListCastRepository = ListCastRepository.getInstance(mContext);
        mTrailerRepository = TrailerRepository.getInstance(mContext);
    }


    private void setAdapter() {
        mCastInDetailAdapter = new CastInDetailAdapter();
        mCompanyInDetailAdapter = new CompanyInDetailAdapter();
    }

    @Override
    public void onClickItem(Cast cast) {
        Intent intent = new Intent(mContext, CastDetailActivity.class);
        intent.putExtra(Constants.ID_CAST, cast.getId());
        mContext.startActivity(intent);
    }

    @Override
    public void onClickItem(Company company) {
        Intent intent = new Intent(mContext, CompanyActivity.class);
        intent.putExtra(Constants.ID_COMPANY, company.getId());
        mContext.startActivity(intent);
    }

    public void goToPlay(View view) {
        ArrayList<String> videoKeys = new ArrayList<>();
        for (Trailer trailer : mTrailers) {
            videoKeys.add(trailer.getKey());
        }
        Intent intent = new Intent(mContext, YoutubeActivity.class);
        intent.putParcelableArrayListExtra(Constants.LIST, mTrailers);
        intent.putExtra(Constants.FILM_DETTAIL, filmDetail.get());
        intent.putStringArrayListExtra(Constants.LISt_KEY, videoKeys);
        mContext.startActivity(intent);
    }

    public void onBack(View view) {
        ((Activity) mContext).finish();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public void getData(int id) {
        getFilmDetailById(id);
        getListCastById(id);
        getTrailersById(id);
    }

    private void getTrailersById(int id) {
        Disposable disposable = mTrailerRepository.getData(id)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<TrailerResponse>() {
                    @Override
                    public void accept(TrailerResponse trailerResponse) throws Exception {
                        mTrailers.clear();
                        mTrailers.addAll(trailerResponse.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void getListCastById(int id) {
        Disposable disposable = mListCastRepository.getListCast(id)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<CastResponse>() {
                    @Override
                    public void accept(CastResponse castResponse) throws Exception {
                        mCastInDetailAdapter.setCasts(castResponse.getCasts());
                        castAdapter.set(mCastInDetailAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void getFilmDetailById(int id) {
        Disposable disposable = mFilmDetailRepository.getFilmDetail(id)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<FilmDetail>() {
                    @Override
                    public void accept(FilmDetail film) throws Exception {
                        filmDetail.set(film);
                        mCompanyInDetailAdapter.setCompanies(film.getCompanies());
                        companyAdapter.set(mCompanyInDetailAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, R.string.error_network, Toast.LENGTH_SHORT).show();
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
