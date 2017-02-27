package com.example.vtarantik.popularmovies_mosby.di;


import com.example.vtarantik.popularmovies_mosby.presenter.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by vtarantik on 10.1.2017.
 * Application component responsible for the dependency injection of the application singletons,
 * such as network client, etc.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MovieListPresenter movieListPresenter);
}
