package com.smartandroidapps.audiowidgetlib.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.Settings.System;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.TimeZone;

public class DatabaseHelper
  extends SQLiteOpenHelper
  implements Constants
{
  private static int currentVersion = 13;
  private static String dbFileName = "data.db";
  Context context;
  
  public DatabaseHelper(Context paramContext)
  {
    super(paramContext, dbFileName, null, currentVersion);
    this.context = paramContext;
  }
  
  public static void ClearDBandReInitProfiles(Context paramContext)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getWritableDatabase();
    localSQLiteDatabase.execSQL("Drop Table IF Exists schedule;");
    localSQLiteDatabase.execSQL("Drop Table IF Exists profilestreamvalue;");
    localSQLiteDatabase.execSQL("Drop Table IF Exists profile;");
    localDatabaseHelper.onCreate(localSQLiteDatabase);
    localSQLiteDatabase.close();
    localDatabaseHelper.close();
  }
  
  public static File ExportDatabase(Context paramContext, File paramFile)
  {
    return exportDatabaseFile(getDBFile(paramContext), paramFile);
  }
  
  public static String GetDbFileRelToFilesDir()
  {
    return "../databases/" + dbFileName;
  }
  
  public static boolean ImportDatabase(Context paramContext, File paramFile)
  {
    boolean bool;
    if (!importDatabaseFile(paramFile, getDBFile(paramContext)))
    {
      bool = false;
    }
    else
    {
      new DatabaseHelper(paramContext).getWritableDatabase().close();
      bool = true;
    }
    return bool;
  }
  
  private static void copyFile(File paramFile1, File paramFile2)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile1);
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
    FileChannel localFileChannel1 = localFileInputStream.getChannel();
    FileChannel localFileChannel2 = localFileOutputStream.getChannel();
    try
    {
      localFileChannel1.transferTo(0L, localFileChannel1.size(), localFileChannel2);
      if (localFileChannel1 != null) {
        localFileChannel1.close();
      }
      if (localFileChannel2 != null) {
        localFileChannel2.close();
      }
      localFileInputStream.close();
      localFileOutputStream.close();
      return;
    }
    finally
    {
      if (localFileChannel1 != null) {
        localFileChannel1.close();
      }
      if (localFileChannel2 != null) {
        localFileChannel2.close();
      }
    }
  }
  
  private void createScheduleTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE schedule (_id INTEGER PRIMARY KEY AUTOINCREMENT,profile_id INTEGER,triggertime INTEGER DEFAULT 0,repeatdays INTEGER DEFAULT 0,active INTEGER DEFAULT 0,vibrate INTEGER DEFAULT 0,timezoneoffset INTEGER DEFAULT 0);");
  }
  
  private void createTables(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE profile (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,type INTEGER DEFAULT 0,ringermode INTEGER DEFAULT 2,vibratealarm INTEGER DEFAULT -1,vibrateringer INTEGER DEFAULT -1,vibeinsilent INTEGER DEFAULT -1,profile_index INTEGER DEFAULT 99999,alarmringtone TEXT DEFAULT NULL,phoneringtone TEXT DEFAULT NULL,notificationringtone TEXT DEFAULT NULL);");
    paramSQLiteDatabase.execSQL("CREATE TABLE profilestreamvalue (_id INTEGER PRIMARY KEY AUTOINCREMENT,profile_id INTEGER,stream_id INTEGER,value INTEGER);");
    createScheduleTable(paramSQLiteDatabase);
  }
  
  private static File exportDatabaseFile(File paramFile1, File paramFile2)
  {
    paramFile2.getParentFile().mkdirs();
    try
    {
      paramFile2.createNewFile();
      copyFile(paramFile1, paramFile2);
      return paramFile2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("AudioManager", localIOException.getMessage(), localIOException);
        paramFile2 = null;
      }
    }
  }
  
  public static File getDBFile(Context paramContext)
  {
    return paramContext.getDatabasePath(dbFileName);
  }
  
  public static int getLastInsertID(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT last_insert_rowid();", null);
    localCursor.moveToFirst();
    int i = localCursor.getInt(0);
    localCursor.close();
    return i;
  }
  
  private static boolean importDatabaseFile(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile2.createNewFile();
      copyFile(paramFile1, paramFile2);
      bool = true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool;
        Log.e("AudioManager", localIOException.getMessage(), localIOException);
        int i = 0;
      }
    }
    return bool;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 187	com/smartandroidapps/audiowidgetlib/activities/MainActivity:sSqliteDataLock	[Ljava/lang/Object;
    //   5: astore_1
    //   6: aload_1
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 188	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_2
    //   13: aload_2
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 27	com/smartandroidapps/audiowidgetlib/data/DatabaseHelper:context	Landroid/content/Context;
    //   19: invokestatic 193	com/smartandroidapps/audiowidgetlib/util/OldAPIHelper:dataChanged	(Landroid/content/Context;)V
    //   22: aload_1
    //   23: monitorexit
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: astore_2
    //   29: ldc 144
    //   31: aload_2
    //   32: invokevirtual 194	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   35: aload_2
    //   36: invokestatic 197	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   39: pop
    //   40: ldc2_w 198
    //   43: invokestatic 205	java/lang/Thread:sleep	(J)V
    //   46: aload_0
    //   47: invokespecial 188	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: astore_2
    //   51: goto -36 -> 15
    //   54: astore_2
    //   55: ldc 144
    //   57: aload_2
    //   58: invokevirtual 206	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   61: aload_2
    //   62: invokestatic 197	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   65: pop
    //   66: goto -20 -> 46
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	DatabaseHelper
    //   74	4	1	localObject1	Object
    //   12	15	2	localSQLiteDatabase1	SQLiteDatabase
    //   28	8	2	localSQLiteException	SQLiteException
    //   50	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   54	8	2	localInterruptedException	java.lang.InterruptedException
    //   69	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	28	android/database/sqlite/SQLiteException
    //   40	46	54	java/lang/InterruptedException
    //   8	13	69	finally
    //   15	24	69	finally
    //   29	40	69	finally
    //   40	46	69	finally
    //   46	72	69	finally
    //   2	8	74	finally
    //   72	74	74	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTables(paramSQLiteDatabase);
    Profile.CreateDefaultProfile(paramSQLiteDatabase);
    Profile.CreateInitialProfiles(paramSQLiteDatabase, this.context);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 3) {
      paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD ringermode INTEGER DEFAULT 2;");
    }
    if (paramInt1 < 4)
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD vibratealarm INTEGER DEFAULT -1;");
      paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD vibrateringer INTEGER DEFAULT -1;");
    }
    if (paramInt1 < 6) {
      paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD vibeinsilent INTEGER DEFAULT -1;");
    }
    if (paramInt1 < 5) {
      createScheduleTable(paramSQLiteDatabase);
    }
    for (;;)
    {
      if (paramInt1 < 8) {
        Profile.CreateInitialProfiles(paramSQLiteDatabase, this.context);
      }
      if (paramInt1 < 9) {}
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD profile_index INTEGER DEFAULT 99999;");
        label76:
        if (paramInt1 < 10)
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD alarmringtone TEXT DEFAULT NULL;");
          paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD phoneringtone TEXT DEFAULT NULL;");
          paramSQLiteDatabase.execSQL("ALTER TABLE profile ADD notificationringtone TEXT DEFAULT NULL;");
        }
        Object[] arrayOfObject;
        if (paramInt1 < 11)
        {
          arrayOfObject = new Object[3];
          arrayOfObject[0] = Settings.System.DEFAULT_ALARM_ALERT_URI.toString();
          arrayOfObject[1] = Settings.System.DEFAULT_RINGTONE_URI.toString();
          arrayOfObject[2] = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
          paramSQLiteDatabase.execSQL("UPDATE profile SET alarmringtone=?, phoneringtone=?, notificationringtone=? WHERE phoneringtone is NULL;", arrayOfObject);
        }
        if (paramInt1 < 12)
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE schedule ADD timezoneoffset INTEGER DEFAULT 0;");
          int i = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis());
          arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(i);
          paramSQLiteDatabase.execSQL("UPDATE schedule SET timezoneoffset=?;", arrayOfObject);
        }
        if ((paramInt1 < 13) && (RunTimeConfig.isFullVersion(this.context)))
        {
          arrayOfObject = new Object[3];
          arrayOfObject[0] = Settings.System.DEFAULT_ALARM_ALERT_URI.toString();
          arrayOfObject[1] = Settings.System.DEFAULT_RINGTONE_URI.toString();
          arrayOfObject[2] = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
          paramSQLiteDatabase.execSQL("UPDATE profile SET alarmringtone=?, phoneringtone=?, notificationringtone=?;", arrayOfObject);
        }
        return;
        if (paramInt1 >= 7) {
          continue;
        }
        paramSQLiteDatabase.execSQL("ALTER TABLE schedule ADD vibrate INTEGER DEFAULT 0;");
      }
      catch (SQLiteException localSQLiteException)
      {
        break label76;
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.data.DatabaseHelper
 * JD-Core Version:    0.7.0.1
 */