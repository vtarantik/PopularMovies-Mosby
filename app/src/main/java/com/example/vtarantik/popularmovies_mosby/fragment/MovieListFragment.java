package com.example.vtarantik.popularmovies_mosby.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vtarantik.popularmovies_mosby.R;
import com.example.vtarantik.popularmovies_mosby.activity.MovieDetailActivity;
import com.example.vtarantik.popularmovies_mosby.adapter.MovieListAdapter;
import com.example.vtarantik.popularmovies_mosby.entity.Movie;
import com.example.vtarantik.popularmovies_mosby.presenter.MovieListPresenter;
import com.example.vtarantik.popularmovies_mosby.utility.ItemClickSupport;
import com.example.vtarantik.popularmovies_mosby.view.IMovieListView;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by strv on 24/02/2017.
 */

public class MovieListFragment extends MvpLceViewStateFragment<SwipeRefreshLayout,List<Movie>,IMovieListView,MovieListPresenter> implements IMovieListView,SwipeRefreshLayout.OnRefreshListener {

	@BindView(R.id.recyclerView)
	RecyclerView mRecyclerView;

	private MovieListAdapter mMovieListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_movie_list,container,false);
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ButterKnife.bind(this,view);
		// contentView is SwipeRefreshLayout
		contentView.setOnRefreshListener(this);

		// Setup recycler view
		mMovieListAdapter = new MovieListAdapter(getActivity());
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
		mRecyclerView.setAdapter(mMovieListAdapter);
		ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener((recyclerView, position, v) -> {
			Intent intent = MovieDetailActivity.newIntent(getActivity(),mMovieListAdapter.getItem(position));
			startActivity(intent);

		});

		loadData(false);
	}

	@Override
	protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
		return "Error while loading the list of movies";
	}


	@Override
	public void onRefresh() {
		loadData(true);
	}


	@Override
	public LceViewState<List<Movie>, IMovieListView> createViewState() {
		return new RetainingLceViewState<>();
	}


	@Override
	public List<Movie> getData() {
		return mMovieListAdapter.getMovies();
	}


	@Override
	public MovieListPresenter createPresenter() {
		return new MovieListPresenter();
	}


	@Override
	public void setData(List<Movie> data) {
		mMovieListAdapter.setMovies(data);
		mMovieListAdapter.notifyDataSetChanged();
	}


	@Override
	public void showContent() {
		super.showContent();
		contentView.setRefreshing(false);
	}


	@Override
	public void showError(Throwable e, boolean pullToRefresh) {
		super.showError(e, pullToRefresh);
		contentView.setRefreshing(false);
	}


	@Override
	public void loadData(boolean pullToRefresh) {
		presenter.getPopularMoviesList(pullToRefresh);
	}

}
