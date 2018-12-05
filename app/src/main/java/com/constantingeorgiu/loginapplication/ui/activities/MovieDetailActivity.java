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

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailActivity.class.getSimpleName();
    private TextView tvMovieLink, tvMovieName, tvGenre, tvActors, tvDescription;
    private ImageView ivMoviePoster;
    private RatingBar rbMovieRating;

    private String movieName = "";
    private String movieGenre = "";
    private String moviePhotoBase64 = "";
    private float movieRating = 0;
    private String movieDescription = "";

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
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(this, "Crashed and burned", Toast.LENGTH_LONG).show();
            }
        }

        tvDescription = findViewById(R.id.tvDescription);
        tvMovieName = findViewById(R.id.tvMovieName);
        tvGenre = findViewById(R.id.tvGenre);
        tvActors = findViewById(R.id.tvActors);
        ivMoviePoster = findViewById(R.id.ivMoviePoster);


        tvDescription.setText(movieDescription);
        tvMovieName.setText(movieName);
        tvGenre.setText(movieGenre);
        ivMoviePoster.setImageBitmap(decodeImageFromString(moviePhotoBase64));

        tvMovieLink = findViewById(R.id.tvMovieLink);
        tvMovieLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieDetailActivity.this, WebViewActivity.class));
            }
        });
    }

    private Bitmap decodeImageFromString(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
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
