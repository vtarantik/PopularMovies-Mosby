package com.example.vtarantik.popularmovies_mosby.view;

import android.os.Bundle;

import com.example.vtarantik.popularmovies_mosby.entity.Movie;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;


/**
 * Created by strv on 28/02/2017.
 */

public interface IMovieDetailView extends MvpLceView<Movie> {

	Bundle getExtras();
}
