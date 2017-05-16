package com.example.pengi.robudget.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pengi.robudget.Entities.Transactions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pengi on 13/05/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "transactions.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRANSACTIONS_TABLE = "CREATE TABLE"+ DatabaseContract.TransactionList.TABLE_NAME + "(" +
                DatabaseContract.TransactionList._ID + " INTEGER PRIMARY KEY, " +
                DatabaseContract.TransactionList.COLUMN_CATEGORY + " TEXT, " +
                DatabaseContract.TransactionList.COLUMN_DESCRIPTION + " TEXT, " +
                DatabaseContract.TransactionList.COLUMN_AMOUNT + " TEXT, " +
                DatabaseContract.TransactionList.COLUMN_TIMESTAMP + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_TRANSACTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TransactionList.TABLE_NAME);
        onCreate(db);
    }

    //Returns arraylist of all transactions in the DB
    public List<Transactions> getAllTransactions() {
        List<Transactions> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM" + DatabaseContract.TransactionList.TABLE_NAME, null);
        res.moveToFirst();

        if (res.moveToFirst()) {
            do {
                Transactions t = new Transactions();
                t.setCategory(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_CATEGORY)));
                t.setAmount(Double.parseDouble(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_AMOUNT))));
                t.setDescription(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_DESCRIPTION)));
                t.setDate(Long.parseLong(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_TIMESTAMP))));
                array_list.add(t);
            }  while (res.moveToNext());
        }
        return array_list;
    }

    public void insertTransaction (Transactions t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("category", t.getCategory());
        content.put("amount", t.getAmount());
        content.put("description", t.getDescription());
        content.put("date", t.getDate());
        db.insert("transactions", null, content);
        db.close();
    }
}
