package com.all;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLite_Adpter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME_VNSGU = "VNSGU";
    private static final String DATABASE_TABLE_STUDNET = "student";
    private static final int DATABSE_VERSION = 1;
    Context context;
    SQLiteDatabase database;

    public SQLite_Adpter(Context context2) {
        super(context2, DATABASE_NAME_VNSGU, null, DATABSE_VERSION);
        this.context = context2;
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student (id integer primary key autoincrement,collage_name text,student_name text,class_name text);");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);
    }

    public void insertData(String collage_name, String student_name, String class_name) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.database = writableDatabase;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into student (collage_name,student_name,class_name) values ('");
        sb.append(collage_name);
        String str = "','";
        sb.append(str);
        sb.append(student_name);
        sb.append(str);
        sb.append(class_name);
        sb.append("');");
        writableDatabase.execSQL(sb.toString());
        Toast.makeText(this.context, "Data Saved Succesfully", Toast.LENGTH_SHORT).show();
    }

    public void showData() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.database = readableDatabase;
        Cursor cursor = readableDatabase.rawQuery("select * from student", null);
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {
            String c_name = cursor.getString(1);
            String s_name = cursor.getString(2);
            String cl_name = cursor.getString(3);
            StringBuilder sb = new StringBuilder();
            sb.append("Collage Name -");
            sb.append(c_name);
            sb.append("\n Student Name -");
            sb.append(s_name);
            sb.append("\n Class Name -");
            sb.append(cl_name);
            sb.append("\n\n\n");
            stringBuilder.append(sb.toString());
        }
        Toast.makeText(this.context, stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }
}
