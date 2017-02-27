package com.example.vtarantik.popularmovies_mosby.interactor;

import com.example.vtarantik.popularmovies_mosby.entity.MovieResponse;

import rx.Observable;


/**
 * Created by vtarantik on 10.1.2017.
 */

public interface IApiInteractor {
    public Observable<MovieResponse> getMovies(int page);

}
