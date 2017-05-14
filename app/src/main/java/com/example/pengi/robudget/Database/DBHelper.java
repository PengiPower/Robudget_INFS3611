package com.example.pengi.robudget.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                DatabaseContract.TransactionList.COLUMN_TITLE + "TEXT NOT NULL, " +
                DatabaseContract.TransactionList.COLUMN_DESCRIPTION + "TEXT NOT NULL, " +
                DatabaseContract.TransactionList.COLUMN_AMOUNT + "REAL NOT NULL" +
                DatabaseContract.TransactionList.COLUMN_TIMESTAMP + "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_TRANSACTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TransactionList.TABLE_NAME);
        onCreate(db);
    }
}
