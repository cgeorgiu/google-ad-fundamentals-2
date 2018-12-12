package com.constantingeorgiu.loginapplication.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.constantingeorgiu.loginapplication.R;
import com.constantingeorgiu.loginapplication.ui.fragments.MovieDetailFragment;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");
        //Get bundle from MovieListActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        } else {
            Toast.makeText(this, "No bundle was recieved", Toast.LENGTH_LONG).show();
        }
    }
}
