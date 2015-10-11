package com.gorrotowi.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gorro on 09/10/15.
 */
public class AccionesDB extends SQLiteOpenHelper {


    public AccionesDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE persona (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, telefono TEXT, correo TEXT, twitter TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
