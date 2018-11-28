package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.constantingeorgiu.loginapplication.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUserName;
    private EditText etPassword;
    private String registeredUser = "Constantin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameFromForm = etUserName.getText().toString();

                Toast.makeText(LoginActivity.this,
                        "You have succesfully logged in", Toast.LENGTH_SHORT).show();

                Log.d("LoginActivity", "Login pressed");
                // This is used to navigate from one activity to another
                startActivity(new Intent(LoginActivity.this, MoviesActivity.class));
            }
        });

        etUserName = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);


    }
}
