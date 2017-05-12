package com.example.pengi.robudget.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pengi.robudget.R;


public class MainActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(createLoginButtonListener());
    }

    public View.OnClickListener createLoginButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.emailField);
                EditText password = (EditText) findViewById(R.id.passwordField);
                CharSequence userEmail = email.getText();
                CharSequence userPassword = password.getText();

                if (isLoginValid(userEmail,userPassword)) {
                    Intent HomeActivity = new Intent (MainActivity.this, HomeActivity.class);
                    MainActivity.this.startActivity(HomeActivity);
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
