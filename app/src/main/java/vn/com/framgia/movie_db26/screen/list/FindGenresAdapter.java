package vn.com.framgia.movie_db26.screen.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.databinding.ItemFilmSearchBinding;
import vn.com.framgia.movie_db26.screen.home.OnItemFilmClickListener;

public class FindGenresAdapter extends RecyclerView.Adapter<FindGenresAdapter.FindGenresViewHolder> {

    private List<Film> mFilms;
    private OnItemFilmClickListener mListener;

    public FindGenresAdapter() {
        mFilms = new ArrayList<>();
    }

    public void setFilms(List<Film> films) {
        mFilms.clear();
        mFilms.addAll(films);
    }

    public void setListener(OnItemFilmClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public FindGenresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmSearchBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_film_search, parent, false);
        return new FindGenresViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FindGenresViewHolder holder, int position) {
        holder.bindDingData(mFilms.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilms == null ? 0 : mFilms.size();
    }

    public class FindGenresViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmSearchBinding mBinding;

        public FindGenresViewHolder(ItemFilmSearchBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindDingData(Film film) {
            mBinding.setFilm(film);
            mBinding.setListener(mListener);
        }
    }
}
