package com.smartschedule.database;

import java.util.ArrayList;

import com.smartschedule.util.Constant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.sax.StartElementListener;
import android.util.Log;

public class SmartSchedulerDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SMART_SCHEDULER";
    public static final String TABLE_EVENT = "EVENT";
    public static final String COLUMN_EVENT_ID = "_id";
    public static final String COLUMN_EVENT_NAME = "name";
    public static final String COLUMN_EVENT_IMAGE = "image";
    public static final String COLUMN_EVENT_TIME_START_HOUR = "time_start_hour";
    public static final String COLUMN_EVENT_TIME_START_MINUTE = "time_start_minute";
    public static final String COLUMN_EVENT_TIME_END_HOUR = "time_end_hour";
    public static final String COLUMN_EVENT_TIME_END_MINUTE = "time_end_minute";
    public static final String COLUMN_EVENT_SCHEDULE = "schedule";
    public static final String COLUMN_EVENT_CATEGORY = "category";
    public static final String COLUMN_EVENT_ACTION_START = "action_start";
    public static final String COLUMN_EVENT_ACTION_END = "action_end";
    public static final String COLUMN_EVENT_STATE = "state";

    public static final String TABLE_SCHEDULE = "SCHEDULE";
    public static final String COLUMN_SCHEDULE_ID = "_id";
    public static final String COLUMN_SCHEDULE_EVENT_ID = "event_id";
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
    public static final String COLUMN_ACTION_SOUND_MODE = "sound_mode";
    public static final String COLUMN_ACTION_SOUND_ALARM = "sound_alarm";
    public static final String COLUMN_ACTION_SOUND_RINGER = "sound_ring";
    public static final String COLUMN_ACTION_SOUND_MUSIC = "sound_music";
    public static final String COLUMN_ACTION_SOUND_NOTIFICATION = "sound_notification";
    public static final String COLUMN_ACTION_SOUND_SYSTEM = "sound_system";
    public static final String COLUMN_ACTION_SOUND_VOICE_CALL = "sound_voice_call";
    public static final String COLUMN_ACTION_SOUND_RINGTONE_ALARM = "ringtone_alarm";
    public static final String COLUMN_ACTION_SOUND_RINGTONE_RINGER = "rimgtome_ringer";
    public static final String COLUMN_ACTION_SOUND_RINGTONE_NOTIFICATION = "ringtone_notification";

    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;

    public SmartSchedulerDatabase(Context c) {
        SmartSchedulerDatabase.context = c;
    }

    public SmartSchedulerDatabase open() throws SQLException {
        openHelper = new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;
    }

    public SmartSchedulerDatabase openRead() throws SQLException {
        openHelper = new OpenHelper(context);
        db = openHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        openHelper.close();
    }

    public long createData(String name, String image, int category, int state) {
        ContentValues event = new ContentValues();
        event.put(COLUMN_EVENT_NAME, name);
        event.put(COLUMN_EVENT_IMAGE, image);
        event.put(COLUMN_EVENT_CATEGORY, category);
        event.put(COLUMN_EVENT_STATE, state);

        // Cursor mCount = db
        // .rawQuery("select max("+ COLUMN_EVENT_ID + ") from " + TABLE_EVENT,
        // null);
        // mCount.moveToFirst();
        // int count = mCount.getInt(0);
        // mCount.close();

        long event_id = 0;
        try {
            event_id = db.insert(TABLE_EVENT, null, event);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        ContentValues update = new ContentValues();
        update.put(COLUMN_EVENT_SCHEDULE, event_id);
        update.put(COLUMN_EVENT_ACTION_START, event_id);
        update.put(COLUMN_EVENT_ACTION_END, event_id);

        update_event(update, event_id);

        ContentValues schedule = new ContentValues();
        schedule.put(COLUMN_SCHEDULE_EVENT_ID, event_id);

        long schedule_id = 0;
        try {
            schedule_id = db.insert(TABLE_SCHEDULE, null, schedule);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        ContentValues action1 = new ContentValues();
        action1.put(COLUMN_ACTION_START_ID, event_id);

        long action_id1 = 0;
        try {
            action_id1 = db.insert(TABLE_ACTION, null, action1);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        ContentValues action2 = new ContentValues();
        action2.put(COLUMN_ACTION_END_ID, event_id);

        long action_id2 = 0;
        try {
            action_id2 = db.insert(TABLE_ACTION, null, action2);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        return event_id;

    }

    public String getAllData() {
        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_ACTION_START,
                COLUMN_EVENT_ACTION_END, COLUMN_EVENT_STATE };
        Cursor c = db.query(TABLE_EVENT, columns, null, null, null, null, null);

        String result = "";

        int iId = c.getColumnIndex(COLUMN_EVENT_ID);
        int iName = c.getColumnIndex(COLUMN_EVENT_NAME);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + " - _id:" + c.getString(iId) + " - name:"
                    + c.getString(iName) + "\n";
        }
        // String[] total = new String[]{"count: " + count, " value:" + result};
        return result;
    }

    public ArrayList<ContentValues> getData() {

        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_ACTION_START,
                COLUMN_EVENT_ACTION_END, COLUMN_EVENT_STATE };
        Cursor c = null;

        try {
            c = db.query(TABLE_EVENT, columns, null, null, null, null,
                    COLUMN_EVENT_ID + " DESC");
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        ArrayList<ContentValues> result = new ArrayList<ContentValues>();

        // int iId = c.getColumnIndex(COLUMN_EVENT_ID);
        // int iName = c.getColumnIndex(COLUMN_EVENT_NAME);
        // int iTimeStart = c.getColumnIndex(COLUMN_EVENT_TIME_START);
        // int iTimeEnd = c.getColumnIndex(COLUMN_EVENT_TIME_END);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            ContentValues cv = new ContentValues();

            DatabaseUtils.cursorRowToContentValues(c, cv);

            result.add(cv);
        }
        return result;
    }

    public ContentValues getData(int id) {
        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_ACTION_START,
                COLUMN_EVENT_ACTION_END, COLUMN_EVENT_STATE };
        Cursor c = null;

        try {
            c = db.query(TABLE_EVENT, columns, COLUMN_EVENT_ID + "=" + id,
                    null, null, null, COLUMN_EVENT_ID + " DESC");
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        ContentValues result = new ContentValues();

        if (c.getCount() == 1) {
            c.moveToFirst();
            DatabaseUtils.cursorRowToContentValues(c, result);
        } else {
            Log.e(SmartSchedulerDatabase.this.toString(),
                    "error when getdata follow id can not get event or more 2 event");
            throw new Error(
                    "error when getdata follow id can not get event or more 2 event");
        }

        // get action
        String[] columnsAction = new String[] { COLUMN_ACTION_ID,
                COLUMN_ACTION_START_ID, COLUMN_ACTION_END_ID,

                COLUMN_ACTION_SOUND_MODE, COLUMN_ACTION_SOUND_RINGTONE_ALARM,
                COLUMN_ACTION_SOUND_RINGTONE_NOTIFICATION,
                COLUMN_ACTION_SOUND_RINGTONE_RINGER, COLUMN_ACTION_SOUND_ALARM,
                COLUMN_ACTION_SOUND_MUSIC, COLUMN_ACTION_SOUND_RINGER,
                COLUMN_ACTION_SOUND_SYSTEM, COLUMN_ACTION_SOUND_NOTIFICATION,
                COLUMN_ACTION_SOUND_VOICE_CALL };

        // get start action
        Cursor cActionStart = null;
        try {
            cActionStart = db.query(TABLE_ACTION, columnsAction,
                    COLUMN_ACTION_START_ID + "=" + id, null, null, null, null);
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        ContentValues actionStart = new ContentValues();

        if (cActionStart.getCount() == 1) {
            cActionStart.moveToFirst();
            DatabaseUtils.cursorRowToContentValues(cActionStart, actionStart);
        } else {
            Log.e(SmartSchedulerDatabase.this.toString(),
                    "error when getdata follow id action Start error");
            throw new Error("error when getdata follow id action Start error");
        }

        // get end action
        Cursor cActionEnd = null;

        try {
            cActionEnd = db.query(TABLE_ACTION, columnsAction,
                    COLUMN_ACTION_END_ID + "=" + id, null, null, null, null);
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        ContentValues actionEnd = new ContentValues();

        if (cActionEnd.getCount() == 1) {
            cActionEnd.moveToFirst();
            DatabaseUtils.cursorRowToContentValues(cActionEnd, actionEnd);
        } else {
            Log.e(SmartSchedulerDatabase.this.toString(),
                    "error when getdata follow id action end error");
            throw new Error("error when getdata follow id action end error");
        }

        return result;
    }

    public ContentValues getDataAction(int id, String key) {

        // get action
        String[] columnsAction = new String[] { COLUMN_ACTION_ID,
                COLUMN_ACTION_START_ID, COLUMN_ACTION_END_ID,

                COLUMN_ACTION_SOUND_MODE, COLUMN_ACTION_SOUND_RINGTONE_ALARM,
                COLUMN_ACTION_SOUND_RINGTONE_NOTIFICATION,
                COLUMN_ACTION_SOUND_RINGTONE_RINGER, COLUMN_ACTION_SOUND_ALARM,
                COLUMN_ACTION_SOUND_MUSIC, COLUMN_ACTION_SOUND_RINGER,
                COLUMN_ACTION_SOUND_SYSTEM, COLUMN_ACTION_SOUND_NOTIFICATION,
                COLUMN_ACTION_SOUND_VOICE_CALL };

        ContentValues action = new ContentValues();

        if (key == Constant.ACTION_START_ID_KEY) {
            // get start action
            Cursor cActionStart = null;
            try {
                cActionStart = db.query(TABLE_ACTION, columnsAction,
                        COLUMN_ACTION_START_ID + "=" + id, null, null, null,
                        null);
            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }
            if (cActionStart.getCount() == 1) {
                cActionStart.moveToFirst();
                DatabaseUtils.cursorRowToContentValues(cActionStart, action);
            } else {
                Log.e(SmartSchedulerDatabase.this.toString(),
                        "error when getdata follow id action Start error");
                throw new Error(
                        "error when getdata follow id action Start error");
            }
        } else if (key == Constant.ACTION_END_ID_KEY) {
            // get end action
            Cursor cActionEnd = null;

            try {
                cActionEnd = db
                        .query(TABLE_ACTION, columnsAction,
                                COLUMN_ACTION_END_ID + "=" + id, null, null,
                                null, null);
            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }

            if (cActionEnd.getCount() == 1) {
                cActionEnd.moveToFirst();
                DatabaseUtils.cursorRowToContentValues(cActionEnd, action);
            } else {
                Log.e(SmartSchedulerDatabase.this.toString(),
                        "error when getdata follow id action end error");
                throw new Error("error when getdata follow id action end error");
            }
        }

        return action;
    }

    public int update_event(ContentValues contentValues, long event_id) {
        return db.update(TABLE_EVENT, contentValues, COLUMN_EVENT_ID + "="
                + event_id, null);
    }

    public int update_action(ContentValues contentValues, long event_id,
            String start_or_end) {
        int result = 0;
        if (start_or_end == COLUMN_ACTION_START_ID) {
            try {
                result = db.update(TABLE_ACTION, contentValues,
                        COLUMN_ACTION_START_ID + "=" + event_id, null);

            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }
        }
        if (start_or_end == COLUMN_ACTION_END_ID) {
            try {
                result = db.update(TABLE_ACTION, contentValues,
                        COLUMN_ACTION_END_ID + "=" + event_id, null);

            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }
        }

        if (result != 1) {
            throw new Error("error update 2 row in database");
        }
        return result;
    }

    public int delete(int id) {
        return db.delete(TABLE_EVENT, COLUMN_EVENT_ID + "=" + id, null);
    }

    // ---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE " + TABLE_EVENT + " (" + COLUMN_EVENT_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_EVENT_NAME + " TEXT, " + COLUMN_EVENT_IMAGE
                    + " TEXT, " + COLUMN_EVENT_TIME_START_HOUR
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_START_MINUTE
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_END_HOUR
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_END_MINUTE
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_SCHEDULE
                    + " INT DEFAULT NULL UNIQUE, " + COLUMN_EVENT_CATEGORY
                    + " INT NOT NULL NULL, " + COLUMN_EVENT_ACTION_START
                    + " INT DEFAULT NULL UNIQUE, " + COLUMN_EVENT_ACTION_END
                    + " INT DEFAULT NULL UNIQUE, " + COLUMN_EVENT_STATE
                    + " INT NOT NULL" + ");");
            arg0.execSQL("CREATE TABLE " + TABLE_SCHEDULE + " ("
                    + COLUMN_SCHEDULE_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_SCHEDULE_EVENT_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_SCHEDULE_MON + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_TUE + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_WED + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_THU + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_FRI + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SAT + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SUN + " BOOLEAN DEFAULT FALSE " + ");");
            arg0.execSQL("CREATE TABLE " + TABLE_ACTION + " ("
                    + COLUMN_ACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_ACTION_START_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_END_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_STATE + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_DRAW + " TEXT DEFAULT NULL, "
                    + COLUMN_ACTION_NAME + " TEXT "
                    + ");");
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
