package vn.com.framgia.movie_db26.screen.cast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.data.model.CastDetail;
import vn.com.framgia.movie_db26.data.reponsitory.CastDetailRepository;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class CastDetailViewModel implements BaseViewModel{

    private Context mContext;
    public ObservableField<CastDetail> castDetail = new ObservableField<>();
    private CompositeDisposable mCompositeDisposable;
    private SchedulerProvider mProvider;
    private CastDetailRepository mRepository;

    public CastDetailViewModel(Context context, Intent intent) {
        mContext = context;
        int idPerson = intent.getIntExtra(Constants.ID_CAST, 0);
        setData(idPerson);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void onBack(View view){
        ((Activity) mContext).finish();
    }

    public void setData(int data) {
        mRepository = CastDetailRepository.getInstance(mContext);
        mProvider = SchedulerProvider.getInstance();
        mCompositeDisposable = new CompositeDisposable();
        getDetailCast(data);
    }

    private void getDetailCast(int data) {
        Disposable disposable = mRepository.getCastDetailByID(data)
                .subscribeOn(mProvider.io())
                .observeOn(mProvider.ui())
                .subscribe(new Consumer<CastDetail>() {
                    @Override
                    public void accept(CastDetail a) throws Exception {
                        castDetail.set(a);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
