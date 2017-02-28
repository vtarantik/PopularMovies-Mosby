package com.example.vtarantik.popularmovies_mosby.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vtarantik.popularmovies_mosby.R;
import com.example.vtarantik.popularmovies_mosby.entity.Movie;
import com.example.vtarantik.popularmovies_mosby.utility.CircleTransform;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by strv on 24/02/2017.
 */

public class MovieListAdapter extends SupportAnnotatedAdapter implements MovieListAdapterBinder{
	private static final String POSTER_PATH = "http://image.tmdb.org/t/p/w185";
	private static final String MAX_RATING = "/10";

	private Context mContext;

	@ViewType(
			layout = R.layout.list_item_movie,
			views = {
					@ViewField(
							id = R.id.list_item_textview_movie_title,
							name = "title",
							type = TextView.class
					),
					@ViewField(
							id = R.id.list_item_textview_movie_rating,
							name = "rating",
							type = TextView.class

					),
					@ViewField(
							id = R.id.list_item_movie_image,
							name = "poster",
							type = ImageView.class
					)
			}) public final int VIEWTYPE_MOVIE = 0;

	private List<Movie> mMovies;

	public MovieListAdapter(Context context) {
		super(context);
		this.mContext = context;
	}

	public void setMovies(List<Movie> movies) {
		this.mMovies = movies;
	}

	public List<Movie> getMovies() {
		return mMovies;
	}

	@Override public int getItemCount() {
		return mMovies == null ? 0 : mMovies.size();
	}


	@Override
	public void bindViewHolder(MovieListAdapterHolders.VIEWTYPE_MOVIEViewHolder vh, int position) {
		vh.title.setText(mMovies.get(position).getTitle());
		vh.rating.setText(mMovies.get(position).getRating()+MAX_RATING);

		Picasso.with(mContext)
				.load(POSTER_PATH+mMovies.get(position).getPoster())
				.transform(new CircleTransform())
				.into(vh.poster);
	}

	public Movie getItem(int position){
		return mMovies.get(position);
	}

}
