package com.smartschedule.database;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SmartSystemDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DB_TEST";
    public static final String TABLE_COUNT = "COUNTTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COUNT = "countname";
    private static final String COLUMN_TIME = "time";
    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;
    public SmartSystemDatabase(Context c) {
        SmartSystemDatabase.context = c;
    }

    public SmartSystemDatabase open() throws SQLException{
        openHelper =  new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        openHelper.close();
    }

    public long createData(int count){
        ContentValues cv =  new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentDateandTime = sdf.format(new Date());
        cv.put(COLUMN_COUNT, String.valueOf(count));
        cv.put(COLUMN_TIME, currentDateandTime);
        return db.insert(TABLE_COUNT, null, cv);
    }

    public String[] getCountData() {
        String[] columns = new String[]{COLUMN_ID, COLUMN_COUNT, COLUMN_TIME};
        Cursor c =  db.query(TABLE_COUNT, columns, null, null, null, null, null);


        int count = c.getCount();
        String result = "";

        int iCount = c.getColumnIndex(COLUMN_COUNT);
        int iTime = c.getColumnIndex(COLUMN_TIME);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result = result
                    + " - countname:" + c.getString(iCount)
                    + " - time:" + c.getString(iTime) + "\n";
        }
        String[]  total =  new String[]{"count: " + count, " value:" + result};
        return total;
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
                    + COLUMN_COUNT + " TEXT NOT NULL, "
                    + COLUMN_TIME + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNT);
            onCreate(arg0);
        }
    }
}
