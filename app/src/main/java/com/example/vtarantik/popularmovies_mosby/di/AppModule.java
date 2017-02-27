package com.example.vtarantik.popularmovies_mosby.di;

import android.app.Application;
import android.view.LayoutInflater;

import com.example.vtarantik.popularmovies_mosby.PopularMoviesApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by vtarantik on 10.1.2017.
 * Dagger module providing application class
 */

@Module(
        includes = {
                InteractorsModule.class
        }
)
public class AppModule {
    public static final String TAG = AppModule.class.getName();

    private final PopularMoviesApp app;

    public AppModule(PopularMoviesApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(app);
    }

}
