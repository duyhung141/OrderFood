package com.example.orderfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "OrderFood";
    private static final String TABLE_NAME = "Users";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_EMAIL + " TEXT PRIMARY KEY," +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean checkLogin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COL_EMAIL + " = ? AND " + COL_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        boolean loginSuccess = cursor.getCount() > 0;
        cursor.close();
        return loginSuccess;
    }
    public String getPasswordFromDatabase(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String password = null;

        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_PASSWORD}, COL_EMAIL + "=?", new String[]{email}, null, null, null);

        if (cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        }

        cursor.close();
        db.close();

        return password;
    }

}