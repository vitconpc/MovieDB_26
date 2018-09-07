package vn.com.framgia.movie_db26.screen.detail;

import android.content.Context;
import android.databinding.ObservableField;

import vn.com.framgia.movie_db26.data.model.Cast;
import vn.com.framgia.movie_db26.data.model.Company;
import vn.com.framgia.movie_db26.data.model.FilmDetail;
import vn.com.framgia.movie_db26.screen.base.BaseViewModel;

public class DetailViewModel implements OnClickCastItemListener
        , OnItemCompanyClickListener, BaseViewModel {

    private Context mContext;
    public ObservableField<FilmDetail> filmDetail = new ObservableField<>();
    public ObservableField<CastInDetailAdapter> castAdapter = new ObservableField<>();
    public ObservableField<CompanyInDetailAdapter> companyAdapter = new ObservableField<>();

    private CastInDetailAdapter mCastInDetailAdapter;
    private CompanyInDetailAdapter mCompanyInDetailAdapter;
    public DetailViewModel(Context context) {
        mContext = context;
        setData();
    }

    private void setData() {
        mCastInDetailAdapter = new CastInDetailAdapter();
        mCompanyInDetailAdapter = new CompanyInDetailAdapter();
        castAdapter.set(mCastInDetailAdapter);
        companyAdapter.set(mCompanyInDetailAdapter);
        getData();
    }

    @Override
    public void onClickItem(Cast cast) {

    }

    @Override
    public void onClickItem(Company company) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void getData() {

    }
}
