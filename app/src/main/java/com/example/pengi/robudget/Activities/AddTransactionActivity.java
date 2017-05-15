package com.example.pengi.robudget.Activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pengi.robudget.Database.DBHelper;
import com.example.pengi.robudget.R;

/**
 * Created by Pengi on 11/05/2017.
 */

public class AddTransactionActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private SQLiteDatabase db;
    DBHelper dbHelper;
    Spinner categoryChoices;
    Spinner existingTransactions;
    EditText amt;
    EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        categoryChoices = (Spinner) findViewById(R.id.categoryChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryChoices.setAdapter(adapter);
        categoryChoices.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        existingTransactions = (Spinner) findViewById(R.id.existingTransactions);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        existingTransactions.setAdapter(adapter2);
        existingTransactions.setOnItemClickListener((AdapterView.OnItemClickListener) this);

    }

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getItemAtPosition(pos).toString()) {
            case "Maccas":
                amt.setText("10.95");
                desc.setText("Maccas");
                break;
            case "Train ticket":
                amt.setText("5.50");
                desc.setText("Train ticket");
                break;
            case "Bus ticket":
                amt.setText("1.95");
                desc.setText("Bus ticket");
                break;
            case "Rent":
                amt.setText("600");
                desc.setText("Rent");
                break;
            case "Loan Payment":
                amt.setText("500");
                desc.setText("Loan Payment");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
