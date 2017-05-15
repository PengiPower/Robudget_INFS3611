package com.example.pengi.robudget.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pengi.robudget.R;

/**
 * Created by Pengi on 11/05/2017.
 */

public class OptionsActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Spinner HomeScreenSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> homeAdapter = ArrayAdapter.createFromResource(this, R.array.options_home_screen, android.R.layout.simple_spinner_item);
        homeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HomeScreenSpinner.setAdapter(homeAdapter);
    }

}
