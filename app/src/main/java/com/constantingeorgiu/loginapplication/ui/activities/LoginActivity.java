package com.constantingeorgiu.loginapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private String validPassword = "abcd1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameFromForm = etUserName.getText().toString();
                String passwordFromForm = etPassword.getText().toString();

                if (usernameFromForm.isEmpty()) {
                    etUserName.setError("Please enter a username");
                    etUserName.requestFocus();
                    return;
                }

                if (passwordFromForm.isEmpty()) {
                    etPassword.setError("Please enter a password");
                    etPassword.requestFocus();
                    return;
                }

                if (!usernameFromForm.equals(registeredUser)) {
                    etUserName.setError("Invalid username");
                    etUserName.requestFocus();
                    return;
                }

                if (!passwordFromForm.equals(validPassword)) {
                    etPassword.setError("Invalid password");
                    etPassword.requestFocus();
                    return;
                }

                Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MoviesActivity.class));
            }
        });

    }
}
