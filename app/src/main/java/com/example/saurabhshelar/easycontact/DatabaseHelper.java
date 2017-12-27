package com.example.saurabhshelar.easycontact;

/**
 * Created by Saurabh Shelar on 09-Sep-17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anand on 03-10-2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Upgrade table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String mobile_number, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Insert data in table
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", mobile_number);
        contentValues.put("EMAIL", email);

        long result = db.insert(TABLE_NAME, null, contentValues);

        db.close();
        if (result == -1)
            return false;
        else
            return true;


    }

    public Cursor getData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Get data from table
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE NAME = '" + name + "'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void deleteData(String name)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        //delete data from table
        int b=db.delete(TABLE_NAME, "NAME = '"+name+"'",null);
        db.close();


    }

    public void updateData(String number, String name, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME",name);

        contentValues.put("EMAIL",email);

        //updating values in database

        db.update(TABLE_NAME, contentValues, "MOBILE_NUMBER = '" + number+"'",null );

        db.close();
    }


}