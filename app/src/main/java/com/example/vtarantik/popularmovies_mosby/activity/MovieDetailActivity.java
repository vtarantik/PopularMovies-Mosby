package com.example.vtarantik.popularmovies_mosby.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.vtarantik.popularmovies_mosby.R;
import com.example.vtarantik.popularmovies_mosby.entity.Movie;


/**
 * Created by strv on 24/02/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {
	public static final String EXTRA_MOVIE = "movie";

	public static Intent newIntent(Context context, Movie movie){
		Intent intent = new Intent(context,MovieDetailActivity.class);
		intent.putExtra(EXTRA_MOVIE,movie);

		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_detail);

		if(savedInstanceState == null){
			replaceFragment(com.example.vtarantik.popularmovies_mosby.fragment.MovieDetailFragment.class.getName());
		}
	}

	private void replaceFragment(String fragmentName) {
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentByTag(fragmentName);
		if (fragment == null) {
			fragment = Fragment.instantiate(this, fragmentName);
		}
		fm.beginTransaction().replace(R.id.activity_detail_container, fragment, fragmentName).commit();
	}
}
