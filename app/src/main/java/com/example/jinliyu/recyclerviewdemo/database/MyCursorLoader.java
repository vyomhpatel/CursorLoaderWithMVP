package com.example.jinliyu.recyclerviewdemo.database;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

public class MyCursorLoader extends CursorLoader {

    DBHelper dbHelper;
    public MyCursorLoader(Context context) {
        super(context);
        dbHelper = new DBHelper(context);
    }

    @Override
    protected Cursor onLoadInBackground() {

        return dbHelper.selectAllUsers();
    }
}
