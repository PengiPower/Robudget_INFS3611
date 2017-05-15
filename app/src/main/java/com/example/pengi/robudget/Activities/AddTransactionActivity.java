package com.example.pengi.robudget.Activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.pengi.robudget.Database.DBHelper;
import com.example.pengi.robudget.R;

/**
 * Created by Pengi on 11/05/2017.
 */

public class AddTransactionActivity extends Activity implements AdapterView.OnItemSelectedListener,  View.OnClickListener {

    private SQLiteDatabase db;
    DBHelper dbHelper;
    Spinner categoryChoices;
    Spinner existingTransactions;
    EditText amt;
    EditText desc;
    private RadioButton newTrans;
    private RadioButton existTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        categoryChoices = (Spinner) findViewById(R.id.categoryChoices);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryChoices.setAdapter(adapter);
        categoryChoices.setOnItemSelectedListener(this);

        existingTransactions = (Spinner) findViewById(R.id.existingTransactions);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.existing_transactions, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        existingTransactions.setAdapter(adapter2);
        existingTransactions.setOnItemSelectedListener(this);

        amt = (EditText) findViewById(R.id.AmountTextBox);
        desc = (EditText) findViewById(R.id.DescriptionTextBox);
        newTrans = (RadioButton) findViewById(R.id.add_new_transaction_radio);
        existTrans = (RadioButton) findViewById(R.id.use_existing_trans_radio);
        //newTrans.setOnClickListener(this);
        //existTrans.setOnClickListener(this);

    }

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int pos, long id) {
        String item = parent.getItemAtPosition(pos).toString();
        if(item.equals("Maccas") && existTrans.isChecked()==true) {
            amt.setText("10.95");
            desc.setText("Maccas");
        }
        else if (item.equals("Opal top up") && existTrans.isChecked()==true) {
            amt.setText("20");
            desc.setText("Opal top up");
        }
        else if (item.equals("Rent") && existTrans.isChecked()==true) {
            amt.setText("600");
            desc.setText("Rent");
        }
        else if (item.equals("Loan repayment") && existTrans.isChecked()==true) {
            amt.setText("150");
            desc.setText("Loan repayment");
        }
        else if (item.equals("Phone bill") && existTrans.isChecked()==true) {
            amt.setText("30");
            desc.setText("Phone bill");
        }
        else if (item.equals("Groceries") && existTrans.isChecked()==true) {
            amt.setText("36.42");
            desc.setText("Groceries");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.use_existing_trans_radio:
                //existingTransactions.setOnItemSelectedListener(this);
                break;
        }

    }

}
