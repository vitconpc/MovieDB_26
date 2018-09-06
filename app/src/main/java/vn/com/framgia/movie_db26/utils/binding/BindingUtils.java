package vn.com.framgia.movie_db26.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import vn.com.framgia.movie_db26.R;
import vn.com.framgia.movie_db26.screen.main.MainViewModel;
import vn.com.framgia.movie_db26.utils.common.StringUtil;

public class BindingUtils {
    @BindingAdapter({"onNavigationItemClick"})
    public static void setBottomNavigationClick(BottomNavigationView view
            , BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter("pagerAdapter")
    public static void setPagerAdapter(ViewPager viewPager, PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("recyclerAdapter")
    public static void setRecyclerAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
    }

    @BindingAdapter("setAvatar")
    public static void setAvatarForImage(ImageView imageView,String url){
        Glide.with(imageView.getContext())
                .load(StringUtil.genUrlImage(url))
                .apply(new RequestOptions().placeholder(R.drawable.not_load))
                .into(imageView);
    }
}
