package com.example.vtarantik.popularmovies_mosby.di;


import com.example.vtarantik.popularmovies_mosby.interactor.ApiInteractorFactory;
import com.example.vtarantik.popularmovies_mosby.interactor.IApiInteractor;
import com.example.vtarantik.popularmovies_mosby.rest.ApiDescription;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by vtarantik on 10.1.2017.
 * Interactor modules providing the needs necessary for interaction with the API
 */

@Module(
        includes = {ServiceModule.class}
)
public class InteractorsModule {
    public static final String TAG = InteractorsModule.class.getName();

    @Provides
    @Singleton
    public IApiInteractor provideApiInteractor(ApiDescription apiDescription) {
        return ApiInteractorFactory.provideApiInteractor(apiDescription);
    }
}
