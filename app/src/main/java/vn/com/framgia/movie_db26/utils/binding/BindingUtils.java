package vn.com.framgia.movie_db26.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;

public class BindingUtils {
    @BindingAdapter({"onNavigationItemClick"})
    public static void setBottomNavigationClick(BottomNavigationView view
            , BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }
}
