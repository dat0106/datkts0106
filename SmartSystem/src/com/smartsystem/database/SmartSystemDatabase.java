package com.smartsystem.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SmartSystemDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DB_TEST";
    public static final String TABLE_COUNT = "COUNT";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COUNT = "countname";
    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;
    public SmartSystemDatabase(Context c) {
        SmartSystemDatabase.context = c;
    }

    public SmartSystemDatabase open(){
        openHelper =  new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        openHelper.close();
    }

    public long createData(int count){
        ContentValues cv =  new ContentValues();
        cv.put(COLUMN_COUNT, String.valueOf(count));
        return db.insert(TABLE_COUNT, null, cv);
    }

    public String getCountData() {
        String[] columns = new String[]{COLUMN_ID, COLUMN_COUNT};
        Cursor c =  db.query(TABLE_COUNT, columns, null, null, null, null, null);


        int result = c.getColumnCount();
        c.moveToLast();
        int iCount = c.getColumnIndex(COLUMN_COUNT);

        return "count: " + result  + " value:" + iCount;
    }

    public int deleteAll() {
        return db.delete(TABLE_COUNT, null, null);
    }

    //---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE " + TABLE_COUNT + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_COUNT + " TEXT NOT NULLL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNT);
            onCreate(arg0);
        }
    }
}
