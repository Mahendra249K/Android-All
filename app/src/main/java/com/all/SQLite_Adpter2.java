package com.all;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_Adpter2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "VNSGU_DATABASE";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Collage";
    private static final String col1 = "NAME";
    private static final String col2 = "COLLAGE_NAME";
    private static final String col3 = "MARKS";
    Context context;
    SQLiteDatabase database;

    public SQLite_Adpter2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Collage (ID integer primary key autoincrement,NAME text,COLLAGE_NAME text,MARKS text); ");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Collage");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String collage_name, String marks) {
        this.database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col1, name);
        values.put(col2, collage_name);
        values.put(col3, marks);
        if (this.database.insert(TABLE_NAME, null, values) == -1) {
            return false;
        }
        return true;
    }

    public Cursor readData() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.database = readableDatabase;
        return readableDatabase.rawQuery("select * from Collage", null);
    }

    public boolean updateData(String id, String name, String collage_name, String class_name) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put(col1, name);
        values.put(col2, collage_name);
        values.put(col3, class_name);
        database.update(TABLE_NAME, values, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        database = writableDatabase;
        return Integer.valueOf(writableDatabase.delete(TABLE_NAME, "ID = ?", new String[]{id}));
    }
}
