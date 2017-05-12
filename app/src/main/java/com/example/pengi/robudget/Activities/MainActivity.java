package com.example.pengi.robudget.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pengi.robudget.R;


public class MainActivity extends AppCompatActivity {

    Button login = (Button) findViewById(R.id.loginButton);
    EditText email = (EditText) findViewById(R.id.emailField);
    EditText password = (EditText) findViewById(R.id.passwordField);
    int validLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int validLogin = 0;
        login.setOnClickListener(createLoginButtonListener());
    }

    public View.OnClickListener createLoginButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence userEmail = email.getText();
                CharSequence userPassword = password.getText();

                if (isLoginValid(userEmail,userPassword) == true) {
                    setContentView(R.layout.activity_home_screen);
                }
                else {
                    Toast.makeText(MainActivity.this, String.format("Username/password incorrect. Try again"), Toast.LENGTH_SHORT);
                }
            }
        };
    }


    public boolean isLoginValid (CharSequence email, CharSequence password) {
        if (email.toString().equals("exmaple@email.com") && password.toString().equals("password")) {
            return true;
        }
        else {
            return false;
        }
    }
}
