package com.example.pengi.robudget.Database;

import android.provider.BaseColumns;

/**
 * Created by Pengi on 13/05/2017.
 */

public final class DatabaseContract {
    private DatabaseContract() {}

    public static class TransactionList implements BaseColumns {
        public static final String TABLE_NAME = "transactions";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
