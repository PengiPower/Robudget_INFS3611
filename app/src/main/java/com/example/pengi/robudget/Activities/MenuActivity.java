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

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addTransaction;
    private Button viewTransaction;
    private Button analytics;
    private Button menu;
    private Button account;
    private Button options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
                Intent addTransactionActivity = new Intent (MenuActivity.this, AddTransactionActivity.class);
                MenuActivity.this.startActivity(addTransactionActivity);
                break;
            case R.id.viewTransactionButton:
                Intent viewTransactionActivity = new Intent (MenuActivity.this, ViewTransactionActivity.class);
                MenuActivity.this.startActivity(viewTransactionActivity);
                break;
            case R.id.dataAnalyticsButton:
                Intent dataAnalyticsActivity = new Intent (MenuActivity.this, DataAnalyticsActivity.class);
                MenuActivity.this.startActivity(dataAnalyticsActivity);
                break;
            case R.id.menuButton:
                Intent menuActivity = new Intent (MenuActivity.this, HomeActivity.class);
                MenuActivity.this.startActivity(menuActivity);
                break;
            case R.id.accountButton:
                Intent accountActivity = new Intent (MenuActivity.this, AccountActivity.class);
                MenuActivity.this.startActivity(accountActivity);
                break;
            case R.id.optionsButton:
                Intent optionsActivity = new Intent (MenuActivity.this, OptionsActivity.class);
                MenuActivity.this.startActivity(optionsActivity);
                break;
        }
    }
}
