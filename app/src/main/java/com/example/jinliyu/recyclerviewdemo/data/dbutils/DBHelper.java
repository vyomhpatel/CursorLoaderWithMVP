package com.example.jinliyu.recyclerviewdemo.data.dbutils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jinliyu.recyclerviewdemo.data.local.DemoSQLiteHelper;

public class DBHelper {



    DemoSQLiteHelper demoSQLiteHelper;

    SQLiteDatabase db;

   public DBHelper(Context context){

       this.demoSQLiteHelper = new DemoSQLiteHelper(context);
       db = demoSQLiteHelper.getWritableDatabase();


   }



   public void insertUser(String firstname, String lastname, String email, String mobile, String appapikey){

       ContentValues contentValues = new ContentValues();
       contentValues.put("firstname",firstname);
       contentValues.put("lastname",lastname);
       contentValues.put("email",email);
       contentValues.put("mobile",mobile);
       contentValues.put("appapikey",appapikey);
       db.insert(DemoSQLiteHelper.TABLE_NAME,null,contentValues);
   }

   public Cursor selectAllUsers(){

       Cursor cursor;
       String query = "SELECT * FROM "+DemoSQLiteHelper.TABLE_NAME;
       cursor = db.rawQuery(query,null);


       return cursor;
   }


}
