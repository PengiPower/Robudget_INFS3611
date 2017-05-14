package com.example.pengi.robudget.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pengi.robudget.R;

public class ViewTransactionActivity extends AppCompatActivity {

        private SQLiteDatabase db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_transactions);
        }

        public void sendMessage(View view) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
