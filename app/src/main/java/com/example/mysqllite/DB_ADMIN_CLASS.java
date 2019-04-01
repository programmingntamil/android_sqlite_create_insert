package com.example.mysqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_ADMIN_CLASS extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "Contacts";
    public static final int DATABASE_VERSION = 1;
    public DB_ADMIN_CLASS(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table names(sno INT,name VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table names");
        db.execSQL("create table names(sno INT,name VARCHAR(50))");
    }

    public void insert_names(SQLiteDatabase db,int sno,String name)
    {
        ContentValues values = new ContentValues();
        values.put("sno",sno);
        values.put("name",name);
        db.insert("names",null,values);
    }
}
