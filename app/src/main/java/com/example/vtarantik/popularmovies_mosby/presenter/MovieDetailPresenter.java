package com.example.vtarantik.popularmovies_mosby.presenter;

import android.os.Bundle;

import com.example.vtarantik.popularmovies_mosby.activity.MovieDetailActivity;
import com.example.vtarantik.popularmovies_mosby.entity.Movie;
import com.example.vtarantik.popularmovies_mosby.view.IMovieDetailView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;


/**
 * Created by strv on 28/02/2017.
 */

public class MovieDetailPresenter extends MvpBasePresenter<IMovieDetailView> {
	private Movie mMovie;


	@Override
	public void attachView(IMovieDetailView view) {
		super.attachView(view);

		handleExtras(getView().getExtras());
	}


	private void handleExtras(Bundle extras) {
		if(extras != null) {
			mMovie = extras.getParcelable(MovieDetailActivity.EXTRA_MOVIE);
		}
	}


	public void loadMovie() {
		if(mMovie == null) {
			getView().showError(new Throwable("Movie is null"),false);
		} else {
			getView().setData(mMovie);
			getView().showContent();
		}

	}

	public Movie getMovie(){
		return mMovie;
	}
}
