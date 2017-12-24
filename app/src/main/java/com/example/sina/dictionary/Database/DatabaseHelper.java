package com.example.sina.dictionary.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TABLE_NAME = "Dictionary";
    private static final String COL1 = "ID";
    private static final String COL2 = "ENGLISH";
    private static final String COL3 = "PERSIAN";
    private static final String COL4 = "FRENCH";
    private static final String COL5 = "TURKISH";


    public DatabaseHelper(Context context) {
        super(context, "DB1", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, COL2, COL3, COL4, COL5);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public boolean addData(String english, String persian, String french, String turkish) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, english);
        contentValues.put(COL3, persian);
        contentValues.put(COL4, french);
        contentValues.put(COL5, turkish);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor translate(String item1) {

        Cursor data;

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String query = String.format("SELECT * FROM Dictionary WHERE English LIKE '%s' OR PERSIAN LIKE '%s' OR FRENCH LIKE '%s' OR TURKISH LIKE '%s'", item1, item1, item1, item1);

            data = db.rawQuery(query, null);
            return data;

        } finally {


        }


    }


    public Cursor getItemID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateWord(String newName, String oldName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = String.format("UPDATE Dictionary SET English = '%s' where English = '%s'", newName, oldName);
        String query2 = String.format("UPDATE Dictionary SET Persian = '%s' where Persian = '%s'", newName, oldName);
        String query3 = String.format("UPDATE Dictionary SET French = '%s' where French = '%s'", newName, oldName);
        String query4 = String.format("UPDATE Dictionary SET Turkish = '%s' where Turkish = '%s'", newName, oldName);

        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
    }

    public void deleteWord(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("Delete from Dictionary Where English = '%s' or Persian = '%s' or french = '%s' or turkish = '%s'", name, name, name, name);
        db.execSQL(query);
    }
}
























