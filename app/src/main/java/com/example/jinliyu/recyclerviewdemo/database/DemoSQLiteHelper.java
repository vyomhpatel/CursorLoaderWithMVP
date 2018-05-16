package com.example.jinliyu.recyclerviewdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DemoSQLiteHelper extends SQLiteOpenHelper {

    public static String TABLE_NAME="user_tb";

    public static String CREATE_TABLE = "CREATE TABLE user_tb(_id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT," +
            "email TEXT, mobile TEXT, appapikey TEXT)";

    public DemoSQLiteHelper(Context context) {
        super(context, "testdb", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_tb");
        onCreate(sqLiteDatabase);
    }
}
