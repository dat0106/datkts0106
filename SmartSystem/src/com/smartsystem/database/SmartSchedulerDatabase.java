package com.smartsystem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SmartSchedulerDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SMART_SCHEDULER";
    public static final String TABLE_EVENT = "EVENT";
    public static final String COLUMN_EVENT_ID = "_id";
    public static final String COLUMN_EVENT_NAME = "name";
    public static final String COLUMN_EVENT_IMAGE = "image";
    public static final String COLUMN_EVENT_TIMESTART = "time_start";
    public static final String COLUMN_EVENT_TIMEEND = "time_end";
    public static final String COLUMN_EVENT_SCHEDULE = "schedule";
    public static final String COLUMN_EVENT_CATEGORY = "category";
    public static final String COLUMN_EVENT_ACTIONSTART = "action_start";
    public static final String COLUMN_EVENT_ACTIONEND = "action_end";
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
    public static final String COLUMN_ACTION_STATE = "state";
    public static final String COLUMN_ACTION_NAME = "name";

    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;
    public SmartSchedulerDatabase(Context c) {
        SmartSchedulerDatabase.context = c;
    }


    //---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_EVENT + " ("
                    + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_EVENT_NAME + " TEXT, "
                    + COLUMN_EVENT_IMAGE + " TEXT, "
                    + COLUMN_EVENT_TIMESTART + " UNSIGNER BIG INT NOT NULL DEFAULT 0, "
                    + COLUMN_EVENT_TIMEEND + " UNSIGNER BIG INT NOT NULL DEFAULT 0, "
                    + COLUMN_EVENT_SCHEDULE + " INT NOT NULL UNIQUE, "
                    + COLUMN_EVENT_CATEGORY + " INT NOT NULL UNIQUE, "
                    + COLUMN_EVENT_ACTIONSTART + " INT NOT NULL, "
                    + COLUMN_EVENT_ACTIONEND + " INT NOT NULL, "
                    + COLUMN_EVENT_STATE + " INT NOT NULL "
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
