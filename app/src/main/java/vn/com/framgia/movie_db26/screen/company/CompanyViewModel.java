package vn.com.framgia.movie_db26.screen.company;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import vn.com.framgia.movie_db26.data.model.CompanyProfile;
import vn.com.framgia.movie_db26.data.reponsitory.CompanyRepository;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;
import vn.com.framgia.movie_db26.utils.common.Constants;
import vn.com.framgia.movie_db26.utils.rx.SchedulerProvider;

public class CompanyViewModel implements BaseViewModel{

    private Context mContext;
    private CompositeDisposable mCompositeDisposable;
    public ObservableField<CompanyProfile> company = new ObservableField<>();
    private SchedulerProvider mProvider;
    private CompanyRepository mRepository;

    public CompanyViewModel(Context context, Intent intent) {
        mContext = context;
        int id = intent.getIntExtra(Constants.ID_COMPANY, 0);
        mCompositeDisposable = new CompositeDisposable();
        mProvider = SchedulerProvider.getInstance();
        mRepository = CompanyRepository.getInstance(context);
        getDataById(id);

    }

    private void getDataById(int id) {
        Disposable disposable = mRepository.getCompany(id)
                .subscribeOn(mProvider.io())
                .observeOn(mProvider.ui())
                .subscribe(new Consumer<CompanyProfile>() {
                    @Override
                    public void accept(CompanyProfile companyProfile) throws Exception {
                        company.set(companyProfile);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
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
}
