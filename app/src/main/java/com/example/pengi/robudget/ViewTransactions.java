package com.example.pengi.robudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by chenz on 12/05/2017.
 */

public class ViewTransactions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}
