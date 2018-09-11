package vn.com.framgia.movie_db26.screen.company;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.databinding.ActivityCompanyBinding;

public class CompanyActivity extends AppCompatActivity {

    private CompanyViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ActivityCompanyBinding binding = DataBindingUtil.setContentView(this
                ,R.layout.activity_company);
        mViewModel = new CompanyViewModel(this,getIntent());
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.onStop();
    }
}
