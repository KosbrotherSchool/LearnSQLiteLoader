package com.example.learnsqliteusingloader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ProductDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "productDB2.db";
    private static final int DATABASE_VERSION = 2;

    ProductDBHelper(Context context) {

        // calls the super constructor, requesting the default cursor factory.
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ProductTable.TABLE_NAME + " ("
                + ProductTable._ID + " INTEGER PRIMARY KEY,"
                + ProductTable.COLUMN_NAME_DATA + " TEXT"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Kills the table and existing data
        db.execSQL("DROP TABLE IF EXISTS notes");

        // Recreates the database with a new version
        onCreate(db);
    }
}
