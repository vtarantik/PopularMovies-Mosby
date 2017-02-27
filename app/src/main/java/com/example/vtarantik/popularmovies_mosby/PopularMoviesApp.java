package com.example.vtarantik.popularmovies_mosby;

import android.app.Application;

import com.example.vtarantik.popularmovies_mosby.di.AppComponent;
import com.example.vtarantik.popularmovies_mosby.di.AppModule;
import com.example.vtarantik.popularmovies_mosby.di.DaggerAppComponent;


/**
 * Created by strv on 24/02/2017.
 */

public class PopularMoviesApp extends Application {
    public static final String TAG = PopularMoviesApp.class.getName();

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Dagger
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
