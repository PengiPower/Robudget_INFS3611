package com.example.pengi.robudget.Database;

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
    public static final String TRANSACTIONS_COLUMN_TITLE = "title";
    private static final int DATABASE_VERSION = 1;
    private static final String TRANSACTIONS_COLUMN_AMOUNT = "amount";
    private static final String TRANSACTIONS_COLUMN_DESC = "description";
    private static final String TRANSACTIONS_COLUMN_DATE = "date";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TRANSACTIONS_TABLE = "CREATE TABLE"+ DatabaseContract.TransactionList.TABLE_NAME + "(" +
                DatabaseContract.TransactionList._ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                DatabaseContract.TransactionList.COLUMN_TITLE + "TEXT NOT NULL, " +
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
        Cursor res = db.rawQuery("select * from transactions", null);
        res.moveToFirst();
        Transactions t = new Transactions();

        Date d = new Date(res.getInt(res.getColumnIndex(TRANSACTIONS_COLUMN_DATE)));

        while (res.isAfterLast() == false) {
            t.setTitle(res.getString(res.getColumnIndex(TRANSACTIONS_COLUMN_TITLE)));
            t.setAmount(res.getDouble(res.getColumnIndex(TRANSACTIONS_COLUMN_AMOUNT)));
            t.setDescription(res.getString(res.getColumnIndex(TRANSACTIONS_COLUMN_DESC)));
            t.setDate(d);
            array_list.add(t);
            res.moveToFirst();
        }
        return array_list;
    }
}
