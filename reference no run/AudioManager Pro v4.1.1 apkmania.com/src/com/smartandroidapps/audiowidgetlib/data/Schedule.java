package com.smartandroidapps.audiowidgetlib.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Vibrator;
import android.util.Log;
import android.util.SparseBooleanArray;
import com.smartandroidapps.audiowidgetlib.AApplication;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class Schedule
{
  public static final String APPLY_SCHEDULE_ACTION = "com.smartandroidapps.audiowidgetpro.APPLY_SCHEDULE";
  public static final byte Friday = 32;
  public static final byte Monday = 2;
  public static byte SMTWRFS = 63;
  public static final byte Saturday = 64;
  public static final byte Sunday = 1;
  public static final byte Thursday = 16;
  public static final byte Tuesday = 4;
  public static final byte Wednesday = 8;
  private int _id;
  private boolean active;
  private Context context;
  private DatabaseHelper dbh;
  private int profile_id;
  private byte repeatdays;
  private int timezoneoffset;
  private long triggertime;
  private boolean vibrate;
  
  private Schedule() {}
  
  public Schedule(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    setUpObject(paramContext);
    this.profile_id = paramInt1;
    this.triggertime = GetTimeForDay(paramInt2, paramInt3);
    this.timezoneoffset = TimeZone.getDefault().getOffset(this.triggertime);
    this.repeatdays = 0;
    this.vibrate = paramBoolean2;
    this.active = paramBoolean1;
    setUpProfileDB();
  }
  
  public Schedule(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    setUpObject(paramContext);
    this.profile_id = paramInt;
    this.active = paramBoolean1;
    this.vibrate = paramBoolean2;
    this.repeatdays = 0;
    this.triggertime = paramLong1;
    this.timezoneoffset = TimeZone.getDefault().getOffset(this.triggertime);
    setUpProfileDB();
  }
  
  public Schedule(int paramInt, Context paramContext)
  {
    setUpObject(paramContext);
    this.profile_id = paramInt;
    this.active = false;
    this.vibrate = false;
    this.repeatdays = 0;
    this.triggertime = Calendar.getInstance().getTimeInMillis();
    this.timezoneoffset = TimeZone.getDefault().getOffset(this.triggertime);
    setUpProfileDB();
  }
  
  private static long GetTimeForDay(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), paramInt1, paramInt2, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static long GetTimeForNext(long paramLong, boolean[] paramArrayOfBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    int n = localCalendar.get(1);
    int j = localCalendar.get(2);
    int i2 = localCalendar.get(5);
    int i1 = localCalendar.get(11);
    int i = localCalendar.get(12);
    localCalendar.setTimeInMillis(paramLong);
    int m = localCalendar.get(11);
    int k = localCalendar.get(12);
    localCalendar.set(n, j, i2, 0, 0, 0);
    if ((m < i1) || ((m == i1) && (k <= i))) {
      localCalendar.add(6, 1);
    }
    localCalendar.set(11, m);
    localCalendar.set(12, k);
    i = getNextDay(localCalendar.get(7), paramArrayOfBoolean);
    if (i > 0) {
      localCalendar.add(7, i);
    }
    return localCalendar.getTimeInMillis();
  }
  
  public static Schedule SetUpAlarmManagerForNextSchedule(Context paramContext)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = new String[1];
    localObject2[0] = "1";
    Object localObject3 = localSQLiteDatabase.rawQuery("SELECT _id, triggertime, repeatdays, active, profile_id, vibrate, timezoneoffset from schedule where active = ?;", (String[])localObject2);
    for (;;)
    {
      long l;
      int i;
      int j;
      if (!((Cursor)localObject3).moveToNext())
      {
        ((Cursor)localObject3).close();
        localSQLiteDatabase.close();
        localObject3 = localArrayList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext())
          {
            l = setUpAlarm(paramContext, (Schedule)localObject1);
            Log.d("AMProSchedule", "nextAlarm:" + l);
            if (localObject1 != null) {
              Log.d("AMProSchedule", "nextScheduleId:" + ((Schedule)localObject1).getId());
            }
            return localObject1;
          }
          localObject2 = (Schedule)((Iterator)localObject3).next();
          i = TimeZone.getDefault().getOffset(((Schedule)localObject2).triggertime);
          if (i != ((Schedule)localObject2).timezoneoffset)
          {
            l = ((Schedule)localObject2).timezoneoffset - i + ((Schedule)localObject2).triggertime;
            j = TimeZone.getDefault().getOffset(l);
            if (j != i) {
              l += i - j;
            }
            ((Schedule)localObject2).setTimeAndOffset(l, j);
          }
          if ((localObject1 == null) || (GetTimeForNext(((Schedule)localObject1).triggertime, ((Schedule)localObject1).getRepeatDaysBooleanArray()) > GetTimeForNext(((Schedule)localObject2).triggertime, ((Schedule)localObject2).getRepeatDaysBooleanArray()))) {
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = new Schedule();
      ((Schedule)localObject2).dbh = l;
      ((Schedule)localObject2).context = paramContext;
      ((Schedule)localObject2).profile_id = ((Cursor)localObject3).getInt(4);
      ((Schedule)localObject2)._id = ((Cursor)localObject3).getInt(0);
      ((Schedule)localObject2).triggertime = ((Cursor)localObject3).getLong(1);
      ((Schedule)localObject2).repeatdays = ((byte)((Cursor)localObject3).getInt(2));
      if (((Cursor)localObject3).getInt(3) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      ((Schedule)localObject2).active = j;
      if (((Cursor)localObject3).getInt(5) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      ((Schedule)localObject2).vibrate = j;
      ((Schedule)localObject2).timezoneoffset = ((Cursor)localObject3).getInt(6);
      i.add(localObject2);
    }
  }
  
  private byte boolArrayToByte(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    for (int k = 0;; k++)
    {
      if (k >= 7) {
        return i;
      }
      if (paramArrayOfBoolean[k] != 0) {
        int j = (byte)(i | 1 << -1 + (7 - k));
      }
    }
  }
  
  public static void deleteSchedulesForProfile(int paramInt, Context paramContext)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Object localObject = new String[1];
    localObject[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT _id, triggertime, repeatdays, active, vibrate from schedule where profile_id = ?;", (String[])localObject);
    for (;;)
    {
      if (!localCursor.moveToNext())
      {
        localCursor.close();
        localSQLiteDatabase.close();
        return;
      }
      localObject = new Schedule();
      ((Schedule)localObject).dbh = localDatabaseHelper;
      ((Schedule)localObject).context = paramContext;
      ((Schedule)localObject).profile_id = paramInt;
      ((Schedule)localObject)._id = localCursor.getInt(0);
      ((Schedule)localObject).triggertime = localCursor.getLong(1);
      ((Schedule)localObject).repeatdays = ((byte)localCursor.getInt(2));
      boolean bool;
      if (localCursor.getInt(3) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((Schedule)localObject).active = bool;
      if (localCursor.getInt(4) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((Schedule)localObject).vibrate = bool;
      ((Schedule)localObject).Delete();
    }
  }
  
  private void doactivate(boolean paramBoolean)
  {
    this.active = paramBoolean;
    SetUpAlarmManagerForNextSchedule(this.context);
  }
  
  private void dotimechange(long paramLong, int paramInt)
  {
    this.timezoneoffset = paramInt;
    if (this.triggertime != paramLong)
    {
      this.triggertime = paramLong;
      SetUpAlarmManagerForNextSchedule(this.context);
    }
  }
  
  private static int getNextDay(int paramInt, boolean[] paramArrayOfBoolean)
  {
    int i = paramInt - 1;
    int k = i;
    int j = 0;
    while (paramArrayOfBoolean[k] == 0)
    {
      k = (k + 1) % 7;
      j++;
      if (k == i) {
        return 0;
      }
    }
    i = j;
    return i;
  }
  
  public static Schedule getOrCreateScheduleForProfile(int paramInt, Context paramContext)
  {
    Object localObject = getSchedulesForProfile(paramInt, paramContext);
    if (((List)localObject).size() <= 0) {
      localObject = new Schedule(paramInt, paramContext);
    } else {
      localObject = (Schedule)((List)localObject).get(0);
    }
    return localObject;
  }
  
  public static Schedule getSchedule(int paramInt, Context paramContext)
  {
    int i = 1;
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Object localObject = new String[i];
    localObject[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT profile_id, triggertime, repeatdays, active, vibrate, timezoneoffset from schedule where _id = ?;", (String[])localObject);
    if (localCursor.moveToFirst())
    {
      localObject = new Schedule();
      ((Schedule)localObject).dbh = localDatabaseHelper;
      ((Schedule)localObject).context = paramContext;
      ((Schedule)localObject)._id = paramInt;
      ((Schedule)localObject).profile_id = localCursor.getInt(0);
      ((Schedule)localObject).triggertime = localCursor.getLong(i);
      ((Schedule)localObject).repeatdays = ((byte)localCursor.getInt(2));
      boolean bool;
      if (localCursor.getInt(3) == 0) {
        bool = false;
      } else {
        bool = i;
      }
      ((Schedule)localObject).active = bool;
      if (localCursor.getInt(4) == 0) {
        i = 0;
      }
      ((Schedule)localObject).vibrate = i;
      ((Schedule)localObject).timezoneoffset = localCursor.getInt(5);
      localCursor.close();
      localSQLiteDatabase.close();
    }
    else
    {
      localCursor.close();
      localSQLiteDatabase.close();
      localObject = null;
    }
    return localObject;
  }
  
  public static List<Schedule> getSchedulesForProfile(int paramInt, Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Object localObject = new String[1];
    localObject[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT _id, triggertime, repeatdays, active, vibrate, timezoneoffset from schedule where profile_id = ?;", (String[])localObject);
    for (;;)
    {
      if (!localCursor.moveToNext())
      {
        localCursor.close();
        localSQLiteDatabase.close();
        return localArrayList;
      }
      localObject = new Schedule();
      ((Schedule)localObject).dbh = localDatabaseHelper;
      ((Schedule)localObject).context = paramContext;
      ((Schedule)localObject).profile_id = paramInt;
      ((Schedule)localObject)._id = localCursor.getInt(0);
      ((Schedule)localObject).triggertime = localCursor.getLong(1);
      ((Schedule)localObject).repeatdays = ((byte)localCursor.getInt(2));
      boolean bool;
      if (localCursor.getInt(3) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((Schedule)localObject).active = bool;
      if (localCursor.getInt(4) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((Schedule)localObject).vibrate = bool;
      ((Schedule)localObject).timezoneoffset = localCursor.getInt(5);
      localArrayList.add(localObject);
    }
  }
  
  public static SparseBooleanArray hasSchedules(Context paramContext)
  {
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT profile_id, active FROM schedule", null);
    for (;;)
    {
      if (!localCursor.moveToNext())
      {
        localCursor.close();
        localSQLiteDatabase.close();
        return localSparseBooleanArray;
      }
      int i = localCursor.getInt(0);
      boolean bool;
      if (localCursor.getInt(1) != 1) {
        bool = false;
      } else {
        bool = true;
      }
      localSparseBooleanArray.append(i, bool);
    }
  }
  
  private void setTimeAndOffset(long paramLong, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set triggertime = ?, timezoneoffset = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    this.triggertime = paramLong;
    this.timezoneoffset = paramInt;
  }
  
  private static long setUpAlarm(Context paramContext, Schedule paramSchedule)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent("com.smartandroidapps.audiowidgetpro.APPLY_SCHEDULE");
    if (paramSchedule != null) {
      localIntent.putExtra("scheduleId", paramSchedule.getId());
    }
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 268435456);
    if (localPendingIntent != null)
    {
      localAlarmManager.cancel(localPendingIntent);
      if (paramSchedule != null) {}
    }
    else
    {
      l = -1L;
      return l;
    }
    long l = GetTimeForNext(paramSchedule.getTriggerTime(), paramSchedule.getRepeatDaysBooleanArray());
    localAlarmManager.set(0, l, localPendingIntent);
    return l;
  }
  
  private void setUpObject(Context paramContext)
  {
    this.context = paramContext;
    this.dbh = new DatabaseHelper(paramContext);
    this.dbh.getWritableDatabase().close();
  }
  
  private void setUpProfileDB()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    localSQLiteDatabase.execSQL("PRAGMA synchronous=OFF");
    localSQLiteDatabase.execSQL("BEGIN");
    String str = "1";
    Object localObject = "1";
    if (!this.active) {
      str = "0";
    }
    if (!this.vibrate) {
      localObject = "0";
    }
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.profile_id);
    arrayOfObject[1] = Long.valueOf(this.triggertime);
    arrayOfObject[2] = Byte.valueOf(this.repeatdays);
    arrayOfObject[3] = str;
    arrayOfObject[4] = localObject;
    arrayOfObject[5] = Integer.valueOf(this.timezoneoffset);
    localSQLiteDatabase.execSQL("Insert into schedule (profile_id,triggertime,repeatdays,active,vibrate,timezoneoffset) VALUES (?,?,?,?,?,?);", arrayOfObject);
    localObject = localSQLiteDatabase.rawQuery("SELECT last_insert_rowid();", null);
    ((Cursor)localObject).moveToFirst();
    this._id = ((Cursor)localObject).getInt(0);
    ((Cursor)localObject).close();
    localSQLiteDatabase.execSQL("COMMIT");
    localSQLiteDatabase.close();
    SetUpAlarmManagerForNextSchedule(this.context);
  }
  
  public void Delete()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Delete from schedule where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    SetUpAlarmManagerForNextSchedule(this.context);
    Dispose();
  }
  
  public void Dispose()
  {
    this.dbh = null;
    this.context = null;
    this._id = -1;
  }
  
  public void activate()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "1";
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set active = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    doactivate(true);
  }
  
  public void activateVibrate()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "1";
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set vibrate = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    this.vibrate = true;
  }
  
  public boolean applyProfileForSchedule(int paramInt)
  {
    boolean bool = true;
    if (paramInt == getProfileId())
    {
      bool = false;
    }
    else
    {
      Object localObject = Calendar.getInstance();
      if (getRepeatDaysBooleanArray()[(-1 + localObject.get(7))] == 0)
      {
        bool = false;
      }
      else
      {
        localObject = getProfile();
        if (localObject == null)
        {
          bool = false;
        }
        else
        {
          if (MiscUtils.isDebug())
          {
            Log.d("AudioManager", "Schedule applyProfileForSchedule() prior ProfileId: " + paramInt);
            Log.d("AudioManager", "Schedule applyProfileForSchedule() new ProfileId: " + getProfileId() + "," + ((Profile)localObject).getId());
          }
          AApplication.isScheduleApplied = bool;
          ((Profile)localObject).changeStreamsToProfile();
          AApplication.ScheduleDoneBeingApplied();
          if (isVibrate())
          {
            if (MiscUtils.isDebug()) {
              Log.d("AudioManager", "Schedule applyProfileForSchedule() do vibe");
            }
            ((Vibrator)this.context.getSystemService("vibrator")).vibrate(125L);
          }
        }
      }
    }
    return bool;
  }
  
  public void changeSettings(long paramLong, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    String str1 = "1";
    if (!paramBoolean1) {
      str1 = "0";
    }
    String str2 = "1";
    if (!paramBoolean2) {
      str2 = "0";
    }
    int i = TimeZone.getDefault().getOffset(paramLong);
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = Byte.valueOf(paramByte);
    arrayOfObject[2] = str1;
    arrayOfObject[3] = str2;
    arrayOfObject[4] = Integer.valueOf(i);
    arrayOfObject[5] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set triggertime = ? , repeatdays = ? , active = ?, vibrate = ?, timezoneoffset = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    doactivate(paramBoolean1);
    this.repeatdays = paramByte;
    this.vibrate = paramBoolean2;
    SetUpAlarmManagerForNextSchedule(this.context);
  }
  
  public void changeSettings(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    byte b = boolArrayToByte(paramArrayOfBoolean);
    changeSettings(GetTimeForDay(paramInt1, paramInt2), b, paramBoolean1, paramBoolean2);
  }
  
  public void deactivate()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "0";
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set active = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    doactivate(false);
  }
  
  public void deactivateVibrate()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "0";
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set vibrate = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    this.vibrate = false;
  }
  
  public int getId()
  {
    return this._id;
  }
  
  public Profile getProfile()
  {
    return Profile.getProfile(this.profile_id, this.context);
  }
  
  public int getProfileId()
  {
    return this.profile_id;
  }
  
  public byte getRepeatDays()
  {
    return this.repeatdays;
  }
  
  public boolean[] getRepeatDaysBooleanArray()
  {
    boolean[] arrayOfBoolean = new boolean[7];
    for (int i = 0;; i++)
    {
      if (i >= 7) {
        return arrayOfBoolean;
      }
      int j;
      if ((1 << -1 + (7 - i) & this.repeatdays) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      arrayOfBoolean[i] = j;
    }
  }
  
  public int getTimeZoneOffset()
  {
    return this.timezoneoffset;
  }
  
  public long getTriggerTime()
  {
    return this.triggertime;
  }
  
  public boolean isActive()
  {
    return this.active;
  }
  
  public boolean isFridayEnabled()
  {
    boolean bool;
    if ((0x20 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isMondayEnabled()
  {
    boolean bool;
    if ((0x2 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSaturdayEnabled()
  {
    boolean bool;
    if ((0x40 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSundayEnabled()
  {
    boolean bool;
    if ((0x1 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isThursdayEnabled()
  {
    boolean bool;
    if ((0x10 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isTuesdayEnabled()
  {
    boolean bool;
    if ((0x4 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isVibrate()
  {
    return this.vibrate;
  }
  
  public boolean isWednesdayEnabled()
  {
    boolean bool;
    if ((0x8 & this.repeatdays) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setDays(byte paramByte)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Byte.valueOf(paramByte);
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set repeatdays = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    this.repeatdays = paramByte;
    SetUpAlarmManagerForNextSchedule(this.context);
  }
  
  public void setDays(boolean[] paramArrayOfBoolean)
  {
    setDays(boolArrayToByte(paramArrayOfBoolean));
  }
  
  public void setTime(int paramInt1, int paramInt2)
  {
    setTime(GetTimeForDay(paramInt1, paramInt2));
  }
  
  public void setTime(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    int i = TimeZone.getDefault().getOffset(paramLong);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = Integer.valueOf(i);
    arrayOfObject[2] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update schedule set triggertime = ?, timezoneoffset = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    dotimechange(paramLong, i);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.data.Schedule
 * JD-Core Version:    0.7.0.1
 */