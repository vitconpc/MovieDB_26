package vn.com.framgia.movie_db26.screen.search;

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

public class SearchFilmAdapter extends RecyclerView.Adapter<SearchFilmAdapter.SearchFilmViewHolder> {

    private List<Film> mFilms;
    private OnItemFilmClickListener mListener;

    public SearchFilmAdapter() {
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
    public SearchFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmSearchBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_film_search, parent, false);
        return new SearchFilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFilmViewHolder holder, int position) {
        holder.bindingData(mFilms.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilms == null ? 0 : mFilms.size();
    }

    public class SearchFilmViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmSearchBinding mBinding;
        public SearchFilmViewHolder(ItemFilmSearchBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindingData(Film film) {
            mBinding.setFilm(film);
            mBinding.setListener(mListener);
        }
    }
}
