package vn.com.framgia.movie_db26.screen.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.data.model.Film;
import vn.com.framgia.movie_db26.databinding.ItemFilmBinding;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    public List<Film> mFilms;
    private OnItemFilmClickListener mListener;

    public FilmAdapter(List<Film> films) {
        this.mFilms = films;
    }

    public void setmListener(OnItemFilmClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_film, parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.bindingData(mFilms.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilms == null ? 0 : mFilms.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmBinding mBinding;
        public FilmViewHolder(ItemFilmBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bindingData(Film film) {
            mBinding.setFilm(film);
            mBinding.setListener(mListener);
        }
    }
}
