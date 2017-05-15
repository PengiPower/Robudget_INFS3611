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
     Spinner NotificationSpinner;
     Spinner HomeScreenSpinner;
     Spinner BudgetSpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        HomeScreenSpinner = (Spinner) findViewById(R.id.HomeScreenSpinner);
        ArrayAdapter<CharSequence> homeAdapter = ArrayAdapter.createFromResource(this, R.array.options_home_screen, android.R.layout.simple_spinner_item);
        homeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HomeScreenSpinner.setAdapter(homeAdapter);

        NotificationSpinner = (Spinner) findViewById(R.id.NotificationSpinner);
        ArrayAdapter<CharSequence> notifAdapter = ArrayAdapter.createFromResource(this, R.array.options_notifications_settings, android.R.layout.simple_spinner_item);
        notifAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NotificationSpinner.setAdapter(notifAdapter);

        BudgetSpinner = (Spinner) findViewById(R.id.BudgetSpinner);
        ArrayAdapter<CharSequence> budgetAdapter = ArrayAdapter.createFromResource(this, R.array.options_budget_limit, android.R.layout.simple_spinner_item);
        budgetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BudgetSpinner.setAdapter(budgetAdapter);
    }

}
