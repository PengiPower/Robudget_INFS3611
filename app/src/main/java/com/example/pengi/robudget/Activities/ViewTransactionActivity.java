package com.example.pengi.robudget.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.pengi.robudget.Adapters.TransactionAdapter;
import com.example.pengi.robudget.Database.DBHelper;
import com.example.pengi.robudget.Entities.Transactions;
import com.example.pengi.robudget.R;

import java.util.List;

public class ViewTransactionActivity extends AppCompatActivity {

    //private SQLiteDatabase db;
    DBHelper dbHelper;
    private TransactionAdapter adapter;
    //private List<Transactions> transactionsList;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        dbHelper = new DBHelper(this);
        List<Transactions> transactionsList = dbHelper.getAllTransactions(); //causes crashing
        adapter = new TransactionAdapter(ViewTransactionActivity.this, R.layout.list_item_transactions, transactionsList);

        list = (ListView)findViewById(R.id.transaction_list);
        list.setAdapter(adapter);

    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }*/

}
