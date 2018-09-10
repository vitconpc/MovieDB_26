package vn.com.framgia.movie_db26.screen.youtube;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Trailer;
import vn.com.framgia.movie_db26.databinding.ItemMoreTrailerBinding;

public class MoreTrailerAdapter extends RecyclerView.Adapter<MoreTrailerAdapter.MoreTrailerViewHolder> {
    private List<Trailer> mTrailers;
    private OnItemTrailerClickListener mListener;

    public MoreTrailerAdapter() {
        mTrailers = new ArrayList<>();
    }

    public void setListener(OnItemTrailerClickListener listener) {
        mListener = listener;
    }

    public void setTrailers(List<Trailer> trailers) {
        mTrailers = trailers;
    }

    @NonNull
    @Override
    public MoreTrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMoreTrailerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_more_trailer, parent, false);
        return new MoreTrailerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreTrailerViewHolder holder, int position) {
        holder.fetchData(mTrailers.get(position));
    }

    @Override
    public int getItemCount() {
        return mTrailers == null ? 0 : mTrailers.size();
    }

    public class MoreTrailerViewHolder extends RecyclerView.ViewHolder {
        private ItemMoreTrailerBinding mBinding;

        public MoreTrailerViewHolder(ItemMoreTrailerBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void fetchData(Trailer trailer) {
            mBinding.setTrailer(trailer);
            mBinding.setListener(mListener);
        }
    }
}
