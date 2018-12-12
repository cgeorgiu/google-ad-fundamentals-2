package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.constantingeorgiu.loginapplication.Constants;
import com.constantingeorgiu.loginapplication.R;

import com.constantingeorgiu.loginapplication.model.Movie;
import com.constantingeorgiu.loginapplication.dummy.DummyContent;
import com.constantingeorgiu.loginapplication.ui.adapters.AdapterItemClickListener;
import com.constantingeorgiu.loginapplication.ui.adapters.MoviesAdapter;
import com.constantingeorgiu.loginapplication.ui.fragments.MovieDetailFragment;
import com.constantingeorgiu.loginapplication.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Main. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link MovieDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class MovieListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    private ArrayList<Movie> moviesArrayList;
    private MoviesAdapter moviesAdapter;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DummyContent dummyContent = new DummyContent();
        moviesArrayList = dummyContent.getMoviesList();

        if (findViewById(R.id.movie_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        moviesAdapter = new MoviesAdapter(moviesArrayList, new AdapterItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Movie item = moviesArrayList.get(position);
                Bundle arguments = new Bundle();
                arguments.putString(Constants.MOVIE_NAME, item.getName());
                arguments.putString(Constants.MOVIE_DESCRIPTION, item.getShortDescription());
                arguments.putFloat(Constants.MOVIE_RATING, item.getRating());
                arguments.putString(Constants.MOVIE_GENRE, item.getGenre());
                arguments.putInt(Constants.MOVIE_YEAR, item.getYear());
                arguments.putString(Constants.MOVIE_ACTORS, item.getActors());
                arguments.putString(Constants.MOVIE_IMDB_LINK, item.getImdbURL());
                arguments.putString(Constants.MOVIE_PHOTO, item.getPhotoBase64());

                if (mTwoPane) {
                    MovieDetailFragment fragment = new MovieDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.movie_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MovieDetailActivity.class);
                    intent.putExtras(arguments);
                    context.startActivity(intent);
                }
            }
        });
        View recyclerView = findViewById(R.id.movie_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(moviesAdapter);
    }
}
