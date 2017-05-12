package com.example.pengi.robudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, AddTransaction.class);
        startActivity(intent);
    }

    public void viewTransactionsButton(View view) {
        Intent intent = new Intent(this, ViewTransactions.class);
        startActivity(intent);
    }
}