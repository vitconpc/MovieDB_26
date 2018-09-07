package vn.com.framgia.movie_db26.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Company;
import vn.com.framgia.movie_db26.databinding.ItemProductionBinding;

public class CompanyInDetailAdapter extends RecyclerView.Adapter<
        CompanyInDetailAdapter.CompanyInDetailViewHolder> {

    private List<Company> mCompanies;
    private OnItemCompanyClickListener mListener;

    public CompanyInDetailAdapter() {
        mCompanies = new ArrayList<>();
    }

    public void setCompanies(List<Company> companies) {
        mCompanies.clear();
        mCompanies.addAll(companies);
    }

    public void setListener(OnItemCompanyClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public CompanyInDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_production, parent, false);
        return new CompanyInDetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyInDetailViewHolder holder, int position) {
        holder.setData(mCompanies.get(position));
    }

    @Override
    public int getItemCount() {
        return mCompanies == null ? 0 : mCompanies.size();
    }

    public class CompanyInDetailViewHolder extends RecyclerView.ViewHolder {

        private ItemProductionBinding mBinding;

        public CompanyInDetailViewHolder(ItemProductionBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void setData(Company data) {
            mBinding.setCompany(data);
            mBinding.setListener(mListener);
        }
    }

}
