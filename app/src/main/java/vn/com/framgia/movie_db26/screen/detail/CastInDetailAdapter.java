package vn.com.framgia.movie_db26.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Cast;
import vn.com.framgia.movie_db26.databinding.ItemCastBinding;

public class CastInDetailAdapter extends RecyclerView.Adapter<CastInDetailAdapter.CastInDetailViewHolder> {

    private List<Cast> mCasts;
    private OnClickCastItemListener mListener;

    public CastInDetailAdapter() {
    }

    public void setCasts(List<Cast> casts) {
        mCasts.clear();
        mCasts.addAll(casts);
    }

    public void setListener(OnClickCastItemListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public CastInDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCastBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_cast, parent, false);
        return new CastInDetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CastInDetailViewHolder holder, int position) {
        holder.bindingData(mCasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mCasts == null ? 0 : mCasts.size();
    }

    public class CastInDetailViewHolder extends RecyclerView.ViewHolder {

        private ItemCastBinding mBinding;

        public CastInDetailViewHolder(ItemCastBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindingData(Cast cast) {
            mBinding.setCast(cast);
            mBinding.setListener(mListener);
        }
    }
}
