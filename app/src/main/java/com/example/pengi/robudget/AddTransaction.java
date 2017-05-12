package com.example.pengi.robudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddTransaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        Spinner categoryChoices = (Spinner) findViewById(R.id.categoryChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryChoices.setAdapter(adapter);

        Spinner existingTransactions = (Spinner) findViewById(R.id.existingTransactions);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        existingTransactions.setAdapter(adapter2);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}
