package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.constantingeorgiu.loginapplication.Constants;
import com.constantingeorgiu.loginapplication.R;
import com.constantingeorgiu.loginapplication.utils.ImageUtils;

import java.util.Locale;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailActivity.class.getSimpleName();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            try {
                movieName = bundle.getString(Constants.MOVIE_NAME);
                movieGenre = bundle.getString(Constants.MOVIE_GENRE);
                moviePhotoBase64 = bundle.getString(Constants.MOVIE_PHOTO);
                movieRating = bundle.getFloat(Constants.MOVIE_RATING);
                movieDescription = bundle.getString(Constants.MOVIE_DESCRIPTION);
                movieYear = bundle.getInt(Constants.MOVIE_YEAR);
                movieActors = bundle.getString(Constants.MOVIE_ACTORS);
                movieIMDBLink = bundle.getString(Constants.MOVIE_IMDB_LINK);
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(this, "Crashed and burned", Toast.LENGTH_LONG).show();
            }
        }

        tvDescription = findViewById(R.id.tvDescription);
        tvMovieName = findViewById(R.id.tvMovieName);
        tvGenre = findViewById(R.id.tvGenre);
        tvActors = findViewById(R.id.tvActors);
        tvYear = findViewById(R.id.tvYear);
        tvMovieLink = findViewById(R.id.tvMovieLink);
        ivMoviePoster = findViewById(R.id.ivMoviePoster);
        rbMovieRating = findViewById(R.id.rbMovieRating);

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
                startActivity(new Intent(MovieDetailActivity.this, WebViewActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
