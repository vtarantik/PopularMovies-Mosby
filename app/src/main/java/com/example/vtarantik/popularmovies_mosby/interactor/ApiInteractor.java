package com.example.vtarantik.popularmovies_mosby.interactor;


import com.example.vtarantik.popularmovies_mosby.BuildConfig;
import com.example.vtarantik.popularmovies_mosby.entity.MovieResponse;
import com.example.vtarantik.popularmovies_mosby.rest.ApiDescription;

import rx.Observable;


/**
 * Created by vtarantik on 10.1.2017.
 * Api interactor which provides the needs necessary to work with the real API
 */

public class ApiInteractor implements IApiInteractor{
    public static final String TAG = ApiInteractor.class.getName();
    private final ApiDescription apiDescription;

    public ApiInteractor(ApiDescription apiDescription) {
        this.apiDescription = apiDescription;
    }

    @Override
    public Observable<MovieResponse> getMovies(int page) {
        return this.apiDescription.getMovies(BuildConfig.API_KEY,page);
    }

}
