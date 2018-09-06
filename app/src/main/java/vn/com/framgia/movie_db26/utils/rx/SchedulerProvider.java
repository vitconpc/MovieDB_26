package vn.com.framgia.movie_db26.utils.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements BaseSchedulerProvider {

    @Nullable
    private static SchedulerProvider sInstance;

    public SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (sInstance == null){
            sInstance = new SchedulerProvider();
        }
            return sInstance;
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
