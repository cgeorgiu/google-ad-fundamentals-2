package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.constantingeorgiu.loginapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvMovieLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMovieLink = findViewById(R.id.tvMovieLink);
        tvMovieLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
            }
        });
    }
}
