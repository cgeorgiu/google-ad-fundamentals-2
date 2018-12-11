package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.constantingeorgiu.loginapplication.Constants;
import com.constantingeorgiu.loginapplication.R;
import com.constantingeorgiu.loginapplication.model.Movie;
import com.constantingeorgiu.loginapplication.dummy.DummyContent;
import com.constantingeorgiu.loginapplication.ui.adapters.AdapterItemClickListener;
import com.constantingeorgiu.loginapplication.ui.adapters.MoviesAdapter;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Movie> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movies);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DummyContent dummyContent = new DummyContent();
        moviesList = dummyContent.getMoviesList();

        mAdapter = new MoviesAdapter(moviesList, new AdapterItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Movie clickedMovie = moviesList.get(position);
                Intent intent = new Intent(MoviesActivity.this, MovieDetailActivity.class);
                intent.putExtra(Constants.MOVIE_NAME, clickedMovie.getName());
                intent.putExtra(Constants.MOVIE_DESCRIPTION, clickedMovie.getShortDescription());
                intent.putExtra(Constants.MOVIE_RATING, clickedMovie.getRating());
                intent.putExtra(Constants.MOVIE_PHOTO, clickedMovie.getPhotoBase64());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}

