package com.constantingeorgiu.loginapplication.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.constantingeorgiu.loginapplication.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView wvImdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wvImdb = findViewById(R.id.wvImdb);
        wvImdb.loadUrl("https://www.imdb.com/title/tt0816692/");
    }
}
