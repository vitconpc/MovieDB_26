package vn.com.framgia.movie_db26.screen.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Genre;
import vn.com.framgia.movie_db26.databinding.ItemGenresBinding;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenresViewHolder> {

    private List<Genre> mGenres;
    private OnItemClickListener mListener;

    public void setGenres(List<Genre> genres) {
        mGenres.clear();
        mGenres.addAll(genres);
    }

    public GenresAdapter() {
    }

    public void setListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public GenresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGenresBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_genres, parent, false);
        return new GenresViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresViewHolder holder, int position) {
        holder.bindingData(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public class GenresViewHolder extends RecyclerView.ViewHolder {

        private ItemGenresBinding mBinding;

        public GenresViewHolder(ItemGenresBinding itemGenresBinding) {
            super(itemGenresBinding.getRoot());
            this.mBinding = itemGenresBinding;
        }

        public void bindingData(Genre genre) {
            if (genre != null) {
                mBinding.setGenre(genre);
                mBinding.setListener(mListener);
            }
        }
    }
}
