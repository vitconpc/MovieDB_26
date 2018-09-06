package vn.com.framgia.movie_db26.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmResponse {
    @SerializedName("page")
    @Expose
    private int mPage;
    @SerializedName("total_results")
    @Expose
    private int mTotalResults;
    @SerializedName("total_pages")
    @Expose
    private int mTotalPages;
    @SerializedName("results")
    @Expose
    private List<Film> mResults = null;

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public int getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(int totalResults) {
        mTotalResults = totalResults;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(int totalPages) {
        mTotalPages = totalPages;
    }

    public List<Film> getResults() {
        return mResults;
    }

    public void setResults(List<Film> results) {
        mResults = results;
    }
}
