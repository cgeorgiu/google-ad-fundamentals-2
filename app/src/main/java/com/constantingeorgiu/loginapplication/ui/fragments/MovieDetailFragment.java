package com.constantingeorgiu.loginapplication.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.constantingeorgiu.loginapplication.Constants;
import com.constantingeorgiu.loginapplication.R;
import com.constantingeorgiu.loginapplication.ui.activities.MovieDetailActivity;
import com.constantingeorgiu.loginapplication.ui.activities.MovieListActivity;
import com.constantingeorgiu.loginapplication.ui.activities.WebViewActivity;
import com.constantingeorgiu.loginapplication.utils.ImageUtils;

import java.util.Locale;

/**
 * A fragment representing a single Movie detail screen.
 * This fragment is either contained in a {@link MovieListActivity}
 * in two-pane mode (on tablets) or a {@link MovieDetailActivity}
 * on handsets.
 */

public class MovieDetailFragment extends Fragment {

    private TextView tvMovieLink;
    private TextView tvMovieName;
    private TextView tvGenre;
    private TextView tvActors;
    private TextView tvYear;
    private TextView tvDescription;
    private ImageView ivMoviePoster;
    private RatingBar rbMovieRating;

    private String movieName = "";
    private String movieGenre = "";
    private String moviePhotoBase64 = "";
    private String movieActors = "";
    private float movieRating = 0;
    private String movieDescription = "";
    private int movieYear = 0;
    private String movieIMDBLink = "";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, null);
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            try {
                movieName = bundle.getString(Constants.MOVIE_NAME);
                movieGenre = bundle.getString(Constants.MOVIE_GENRE);
                moviePhotoBase64 = bundle.getString(Constants.MOVIE_PHOTO);
                movieRating = bundle.getFloat(Constants.MOVIE_RATING);
                movieDescription = bundle.getString(Constants.MOVIE_DESCRIPTION);
                movieActors = bundle.getString(Constants.MOVIE_ACTORS);
                movieYear = bundle.getInt(Constants.MOVIE_YEAR);
                movieIMDBLink = bundle.getString(Constants.MOVIE_IMDB_LINK);
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(getActivity(), "Crashed and burned", Toast.LENGTH_LONG).show();
            }
        }

        tvDescription = view.findViewById(R.id.tvDescription);
        tvMovieName = view.findViewById(R.id.tvMovieName);
        tvGenre = view.findViewById(R.id.tvGenre);
        tvActors = view.findViewById(R.id.tvActors);
        tvYear = view.findViewById(R.id.tvYear);
        tvMovieLink = view.findViewById(R.id.tvMovieLink);
        ivMoviePoster = view.findViewById(R.id.ivMoviePoster);
        rbMovieRating = view.findViewById(R.id.rbMovieRating);

        tvDescription.setText(movieDescription);
        tvMovieName.setText(movieName);
        tvGenre.setText(movieGenre);
        tvYear.setText(String.format(Locale.ENGLISH, "%d", movieYear));
        tvActors.setText(movieActors);
        tvMovieLink.setText(movieIMDBLink);
        rbMovieRating.setRating(movieRating);
        ivMoviePoster.setImageBitmap(ImageUtils.decodeImageFromString(moviePhotoBase64));

        tvMovieLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO pass intent with URL
                startActivity(new Intent(getActivity(), WebViewActivity.class));
            }
        });
    }
}
