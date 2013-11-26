package com.smartschedule.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SmartSchedulerDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SMART_SCHEDULER";
    public static final String TABLE_EVENT = "EVENT";
    public static final String COLUMN_EVENT_ID = "_id";
    public static final String COLUMN_EVENT_NAME = "name";
    public static final String COLUMN_EVENT_IMAGE = "image";
    public static final String COLUMN_EVENT_TIME_START = "time_start";
    public static final String COLUMN_EVENT_TIME_END = "time_end";
    public static final String COLUMN_EVENT_SCHEDULE = "schedule";
    public static final String COLUMN_EVENT_CATEGORY = "category";
    public static final String COLUMN_EVENT_ACTION_START = "action_start";
    public static final String COLUMN_EVENT_ACTION_END = "action_end";
    public static final String COLUMN_EVENT_STATE = "state";

    public static final String TABLE_SCHEDULE = "SCHEDULE";
    public static final String COLUMN_SCHEDULE_ID = "_id";
    public static final String COLUMN_SCHEDULE_MON = "mon";
    public static final String COLUMN_SCHEDULE_TUE = "tue";
    public static final String COLUMN_SCHEDULE_WED = "wed";
    public static final String COLUMN_SCHEDULE_THU = "thu";
    public static final String COLUMN_SCHEDULE_FRI = "fri";
    public static final String COLUMN_SCHEDULE_SAT = "sat";
    public static final String COLUMN_SCHEDULE_SUN = "sun";

    public static final String TABLE_ACTION = "ACTION";
    public static final String COLUMN_ACTION_ID = "_id";
    public static final String COLUMN_ACTION_START_ID = "action_start_id";
    public static final String COLUMN_ACTION_END_ID = "action_end_id";
    public static final String COLUMN_ACTION_STATE = "state";
    public static final String COLUMN_ACTION_NAME = "name";

    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;
    public SmartSchedulerDatabase(Context c) {
        SmartSchedulerDatabase.context = c;
    }

    public SmartSchedulerDatabase open() throws  SQLException {
        openHelper = new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        openHelper.close();
    }

    public long createData(String name, String image, int time_start, int time_end, int category, int state){
        ContentValues event =  new ContentValues();
        event.put(COLUMN_EVENT_NAME, name);
        event.put(COLUMN_EVENT_IMAGE, image);
        event.put(COLUMN_EVENT_TIME_START, time_start);
        event.put(COLUMN_EVENT_TIME_END, time_end);

        Cursor mCount= db.rawQuery("select count(*) from " + TABLE_EVENT, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        event.put(COLUMN_EVENT_SCHEDULE, count + 1 );
        event.put(COLUMN_EVENT_CATEGORY, category);
        event.put(COLUMN_EVENT_ACTION_START, count + 1 );
        event.put(COLUMN_EVENT_ACTION_END, count + 1 );
        event.put(COLUMN_EVENT_STATE, state );
        return db.insert(TABLE_EVENT, null, event);

    }

    public String getAllData() {
        String[] columns = new String[]{COLUMN_EVENT_ID, COLUMN_EVENT_NAME, COLUMN_EVENT_IMAGE,
                COLUMN_EVENT_TIME_START, COLUMN_EVENT_TIME_END, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_ACTION_START, COLUMN_EVENT_ACTION_END,
                COLUMN_EVENT_STATE};
        Cursor c =  db.query(TABLE_EVENT, columns, null, null, null, null, null);



        String result = "";

        int iId = c.getColumnIndex(COLUMN_EVENT_ID);
        int iName = c.getColumnIndex(COLUMN_EVENT_NAME);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result = result
                    + " - _id:" + c.getString(iId)
                    + " - name:" + c.getString(iName) + "\n";
        }
//        String[]  total =  new String[]{"count: " + count, " value:" + result};
        return result;
    }

    public ArrayList getData() {
        String[] columns = new String[]{COLUMN_EVENT_ID, COLUMN_EVENT_NAME, COLUMN_EVENT_IMAGE,
                COLUMN_EVENT_TIME_START, COLUMN_EVENT_TIME_END, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_ACTION_START, COLUMN_EVENT_ACTION_END,
                COLUMN_EVENT_STATE};
        Cursor c =  db.query(TABLE_EVENT, columns, null, null, null, null, null);



        ArrayList<ContentValues> result = new ArrayList<ContentValues>();

        int iId = c.getColumnIndex(COLUMN_EVENT_ID);
        int iName = c.getColumnIndex(COLUMN_EVENT_NAME);
        int iTimeStart = c.getColumnIndex(COLUMN_EVENT_TIME_START);
        int iTimeEnd = c.getColumnIndex(COLUMN_EVENT_TIME_END);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            ContentValues cv = new ContentValues();

            DatabaseUtils.cursorRowToContentValues(c, cv);

            result.add(cv);
        }
        return result;
    }

    public ArrayList getData(int id) {
        // TODO
    }

    //---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE " + TABLE_EVENT + " ("
                    + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_EVENT_NAME + " TEXT, "
                    + COLUMN_EVENT_IMAGE + " TEXT, "
                    + COLUMN_EVENT_TIME_START + " UNSIGNER BIG INT NOT NULL DEFAULT 0, "
                    + COLUMN_EVENT_TIME_END + " UNSIGNER BIG INT NOT NULL DEFAULT 0, "
                    + COLUMN_EVENT_SCHEDULE + " INT NOT NULL UNIQUE, "
                    + COLUMN_EVENT_CATEGORY + " INT NOT NULL, "
                    + COLUMN_EVENT_ACTION_START + " INT NOT NULL UNIQUE, "
                    + COLUMN_EVENT_ACTION_END + " INT NOT NULL UNIQUE, "
                    + COLUMN_EVENT_STATE + " INT NOT NULL "
                    +	");");
            arg0.execSQL("CREATE TABLE " + TABLE_SCHEDULE + " ("
                    + COLUMN_SCHEDULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_SCHEDULE_MON + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_TUE + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_WED + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_THU + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_FRI + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SAT + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SUN + " BOOLEAN DEFAULT FALSE "
                    +	");");
            arg0.execSQL("CREATE TABLE " + TABLE_ACTION + " ("
                    + COLUMN_ACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_ACTION_START_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_END_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_STATE + " INTEGER NOT NULL, "
                    + COLUMN_ACTION_NAME + " TEXT "
                    +	");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTION);
            onCreate(arg0);
        }
    }
}
