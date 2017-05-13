package com.example.pengi.robudget.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pengi.robudget.R;

/**
 * Created by Pengi on 12/05/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addTransaction;
    private Button viewTransaction;
    private Button analytics;
    private Button menu;
    private Button account;
    private Button options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        addTransaction = (Button) findViewById(R.id.addTransactionButton);
        viewTransaction = (Button) findViewById(R.id.viewTransactionButton);
        analytics = (Button) findViewById(R.id.dataAnalyticsButton);
        menu = (Button) findViewById(R.id.menuButton);
        account = (Button) findViewById(R.id.accountButton);
        options = (Button) findViewById(R.id.optionsButton);

        addTransaction.setOnClickListener(this);
        viewTransaction.setOnClickListener(this);
        analytics.setOnClickListener(this);
        menu.setOnClickListener(this);
        account.setOnClickListener(this);
        options.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.addTransactionButton:
                Intent addTransactionAcitivity = new Intent (HomeActivity.this, AddTransactionActivity.class);
                HomeActivity.this.startActivity(addTransactionAcitivity);
                break;
            case R.id.viewTransactionButton:
                Intent viewTransactionActivity = new Intent (HomeActivity.this, ViewTransactionActivity.class);
                HomeActivity.this.startActivity(viewTransactionActivity);
                break;
            case R.id.dataAnalyticsButton:
                Intent dataAnalyticsActivity = new Intent (HomeActivity.this, DataAnalyticsActivity.class);
                HomeActivity.this.startActivity(dataAnalyticsActivity);
                break;
            case R.id.menuButton:
                Intent menuActivity = new Intent (HomeActivity.this, MenuActivity.class);
                HomeActivity.this.startActivity(menuActivity);
                break;
            case R.id.accountButton:
                Intent accountActivity = new Intent (HomeActivity.this, AccountActivity.class);
                HomeActivity.this.startActivity(accountActivity);
                break;
            case R.id.optionsButton:
                Intent optionsAcitivty = new Intent (HomeActivity.this, OptionsActivity.class);
                HomeActivity.this.startActivity(optionsAcitivty);
                break;
        }
    }
}
