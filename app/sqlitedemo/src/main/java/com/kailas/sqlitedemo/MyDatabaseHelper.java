package com.kailas.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_db";
    private static final String TABLE_USER = "user_details";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";


    //Create Tables
    String CREATE_USER_TABLE = "CREATE TABLE "
            + TABLE_USER
            + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + FIRST_NAME
            + " TEXT,"
            + LAST_NAME
            + " TEXT,"
            + EMAIL
            + " TEXT,"
            + PASSWORD
            + " TEXT"
            + ")";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void saveIntoDatabase(UserDataModel userDataModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, userDataModel.getFirstName());
        values.put(LAST_NAME, userDataModel.getLastName());
        values.put(EMAIL, userDataModel.getEmail());
        values.put(PASSWORD, userDataModel.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean isValidUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[]{EMAIL,
                        PASSWORD}, EMAIL + "=?",
                new String[]{String.valueOf(email)}, null, null, null, null);
        if (cursor != null) {
            return cursor.getCount() > 0;
        }
        return false;
    }
}
