package com.example.vtarantik.popularmovies_mosby.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vtarantik.popularmovies_mosby.R;
import com.example.vtarantik.popularmovies_mosby.entity.Movie;
import com.example.vtarantik.popularmovies_mosby.presenter.MovieDetailPresenter;
import com.example.vtarantik.popularmovies_mosby.view.IMovieDetailView;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by strv on 28/02/2017.
 */

public class MovieDetailFragment extends MvpLceViewStateFragment<LinearLayout,Movie,IMovieDetailView,MovieDetailPresenter> implements IMovieDetailView {
	private static final String POSTER_PATH = "http://image.tmdb.org/t/p/w300";

	@BindView(R.id.moviedetailfragment_imageview)
	ImageView mImageView;

	@BindView(R.id.moviedetailfragment_textview_description)
	TextView mTextViewDescription;

	@BindView(R.id.moviedetailfragment_textview_rating)
	TextView mTextViewRating;

	@BindView(R.id.moviedetailfragment_textview_release_date)
	TextView mTextViewReleaseDate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_movie_detail,container,false);
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ButterKnife.bind(this,view);

		loadData(false);
	}


	@Override
	public Bundle getExtras() {
		return getActivity().getIntent().getExtras();
	}


	@Override
	public LceViewState<Movie, IMovieDetailView> createViewState() {
		return new RetainingLceViewState<>();
	}


	@Override
	public Movie getData() {
		return getPresenter().getMovie();
	}


	@Override
	protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
		return "Error while loading movie details";
	}


	@Override
	public MovieDetailPresenter createPresenter() {
		return new MovieDetailPresenter();
	}


	@Override
	public void setData(Movie data) {
		Picasso.with(getActivity())
				.load(POSTER_PATH+data.getBackdrop())
				.fit().centerCrop()
				.into(mImageView);

		mTextViewReleaseDate.setText(" "+data.getReleaseDate().substring(0,data.getReleaseDate().indexOf("-")));

		mTextViewRating.setText(" "+Double.toString(data.getRating())+" ("+data.getVoteCount()+"x)");

		mTextViewDescription.setText(data.getOverview());

	}


	@Override
	public void loadData(boolean pullToRefresh) {
		getPresenter().loadMovie();
	}


	@Override
	public void showError(Throwable e, boolean pullToRefresh) {
		super.showError(e, pullToRefresh);
	}
}
