package com.example.vtarantik.popularmovies_mosby.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.vtarantik.popularmovies_mosby.R;


/**
 * Created by strv on 24/02/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		if(savedInstanceState == null){
			replaceFragment(com.example.vtarantik.popularmovies_mosby.fragment.MovieListFragment.class.getName());
		}
	}

	private void replaceFragment(String fragmentName) {
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentByTag(fragmentName);
		if (fragment == null) {
			fragment = Fragment.instantiate(this, fragmentName);
		}
		fm.beginTransaction().replace(R.id.activity_main_container, fragment, fragmentName).commit();
	}
}
