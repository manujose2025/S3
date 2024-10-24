package com.example.databaseconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyDatabase extends SQLiteOpenHelper
{
    public MyDatabase(Context context)
    {
        super(context, "login.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, MARK INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS USERS");
    }

    public boolean insert(String fname, String lname, double mark)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("FNAME", fname);
        cv.put("LNAME", lname);
        cv.put("MARK", mark);

        long result = db.insert("USERS", null, cv);
        db.close();

        if(result == -1)
            return false;
        else
            return true;
    }
}
