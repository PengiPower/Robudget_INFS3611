package com.example.pengi.robudget.Activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pengi.robudget.Database.DBHelper;
import com.example.pengi.robudget.Entities.Transactions;
import com.example.pengi.robudget.R;

/**
 * Created by Pengi on 11/05/2017.
 */

public class AddTransactionActivity extends Activity implements AdapterView.OnItemSelectedListener,  View.OnClickListener {

    private SQLiteDatabase db;
    DBHelper dbHelper;
    private Spinner categoryChoices;
    private Spinner existingTransactions;
    private EditText amt;
    private EditText desc;
    private RadioButton newTrans;
    private RadioButton existTrans;
    private Button addTransaction;

    Transactions t;


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

        addTransaction = (Button) findViewById(R.id.AddButton);
        addTransaction.setOnClickListener(this);

        t = new Transactions();

    }

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int pos, long id) {
        String item = parent.getItemAtPosition(pos).toString();
        if(item.equals("Maccas") && existTrans.isChecked()==true) {
            amt.setText("10.95");
            desc.setText("Maccas");
            t.setCategory("Food/Consumables");
        }
        else if (item.equals("Opal top up") && existTrans.isChecked()==true) {
            amt.setText("20");
            desc.setText("Opal top up");
            t.setCategory("Transportation");
        }
        else if (item.equals("Rent") && existTrans.isChecked()==true) {
            amt.setText("600");
            desc.setText("Rent");
            t.setCategory("Bills");
        }
        else if (item.equals("Loan repayment") && existTrans.isChecked()==true) {
            amt.setText("150");
            desc.setText("Loan repayment");
            t.setCategory("Bills");
        }
        else if (item.equals("Phone bill") && existTrans.isChecked()==true) {
            amt.setText("30");
            desc.setText("Phone bill");
            t.setCategory("Bills");
        }
        else if (item.equals("Groceries") && existTrans.isChecked()==true) {
            amt.setText("36.42");
            desc.setText("Groceries");
            t.setCategory("Groceries");
        }
        //for new transactions
        else if (item.equals("Food/Consumables") && newTrans.isChecked()==true) {
            t.setCategory("Food/Consumables");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Entertainment") && newTrans.isChecked()==true) {
            t.setCategory("Entertainment");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Bills") && newTrans.isChecked()==true) {
            t.setCategory("Bills");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Groceries") && newTrans.isChecked()==true) {
            t.setCategory("Groceries");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Transportation") && newTrans.isChecked()==true) {
            t.setCategory("Transportation");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Personal Purchases") && newTrans.isChecked()==true) {
            t.setCategory("Personal Purchases");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
        else if (item.equals("Other") && newTrans.isChecked()==true) {
            t.setCategory("Other");
            Toast.makeText(parent.getContext(), "test toast", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //not used for now
    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.use_existing_trans_radio:
                //existingTransactions.setOnItemSelectedListener(this);
                break;
            case R.id.AddButton:
                t.setDate(System.currentTimeMillis());
                t.setAmount(Double.parseDouble(amt.getText().toString()));
                t.setDescription(desc.getText().toString());
                dbHelper.insertTransaction(t);
                break;
        }

    }

}
