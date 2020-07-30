package me.pacasian.abinsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLDataException;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "todo";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "matter";
    public static final String CONTACTS_COLUMN_EMAIL = "date";
    private HashMap hp;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + CONTACTS_TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT,matter TEXT,date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData (String matter, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("matter", matter);
        contentValues.put("date", date);
        db.insert("todo", null, contentValues);
        return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+CONTACTS_TABLE_NAME,null);
        return res;
    }
    public String[] getYourData() {

        final String TABLE_NAME = "todo";

        String selectQuery = "SELECT  * FROM " + CONTACTS_TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String[] data      = null;
        int i=0;
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()){

               data[i]=cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_NAME));
               i++;
            }
        }
        cursor.close();
        return data;
    }

}
