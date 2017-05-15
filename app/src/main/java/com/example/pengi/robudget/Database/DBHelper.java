package com.example.pengi.robudget.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pengi.robudget.Entities.Transactions;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        final String SQL_CREATE_TRANSACTIONS_TABLE = "CREATE TABLE"+ DatabaseContract.TransactionList.TABLE_NAME + "(" +
                DatabaseContract.TransactionList._ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                DatabaseContract.TransactionList.COLUMN_CATEGORY + "TEXT NOT NULL, " +
                DatabaseContract.TransactionList.COLUMN_DESCRIPTION + "TEXT NOT NULL, " +
                DatabaseContract.TransactionList.COLUMN_AMOUNT + "REAL NOT NULL" +
                DatabaseContract.TransactionList.COLUMN_TIMESTAMP + "INTEGER NOT NULL" +
                ");";

        db.execSQL(SQL_CREATE_TRANSACTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TransactionList.TABLE_NAME);
        onCreate(db);
    }

    //Returns arraylist of all transactions in the DB
    public ArrayList<Transactions> getAllTransactions() {
        ArrayList<Transactions> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM transactions", null);
        res.moveToFirst();

        if (res.moveToFirst()) {
            do {
                Transactions t = new Transactions();
                t.setCategory(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_CATEGORY)));
                t.setAmount(res.getDouble(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_AMOUNT)));
                t.setDescription(res.getString(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_DESCRIPTION)));
                t.setDate(res.getColumnIndex(DatabaseContract.TransactionList.COLUMN_TIMESTAMP));
                array_list.add(t);
            }  while (res.moveToNext());
        }
        return array_list;
    }

    public boolean insertTransaction (String category, Double amount, String description, int date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("category", category);
        content.put("amount", amount);
        content.put("description", description);
        content.put("date", date);
        db.insert("transactions", null, content);
        return true;
    }
}
