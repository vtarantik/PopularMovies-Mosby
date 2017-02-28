package com.example.vtarantik.popularmovies_mosby.presenter;

import android.util.Log;

import com.example.vtarantik.popularmovies_mosby.PopularMoviesApp;
import com.example.vtarantik.popularmovies_mosby.interactor.IApiInteractor;
import com.example.vtarantik.popularmovies_mosby.view.IMovieListView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by strv on 24/02/2017.
 */

public class MovieListPresenter extends MvpBasePresenter<IMovieListView> {

    @Inject
    IApiInteractor apiInteractor;

    public MovieListPresenter(){
        super();
        PopularMoviesApp.getAppComponent().inject(this);

    }


    public void getPopularMoviesList(final boolean pullToRefresh) {
        getView().showLoading(pullToRefresh);

        apiInteractor.getMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieResponse -> {

                    if(movieResponse.getMovies() != null && !movieResponse.getMovies ().isEmpty()) {
                        getView().setData(movieResponse.getMovies());
                        getView().showContent();
                    }


                }, throwable -> {
                    getView().showError(throwable,pullToRefresh);
                });
    }

}
