package com.example.vtarantik.popularmovies_mosby.rest;

import com.example.vtarantik.popularmovies_mosby.entity.MovieResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by strv on 24/02/2017.
 */

public interface ApiDescription {
	String ENDPOINT_URL = "https://api.themoviedb.org/";

	@GET("3/movie/popular")
	Observable<MovieResponse> getMovies(
			@Query("api_key") String apiKey
	);

}