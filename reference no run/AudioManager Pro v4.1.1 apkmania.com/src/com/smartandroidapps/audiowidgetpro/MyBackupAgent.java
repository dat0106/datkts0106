package com.smartandroidapps.audiowidgetpro;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupManager;
import android.app.backup.FileBackupHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.ParcelFileDescriptor;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.data.DatabaseHelper;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import java.io.IOException;

public class MyBackupAgent
  extends BackupAgentHelper
{
  private static final String FILES_BACKUP_KEY = "myfiles";
  private static final String SHARED_PREFERENCES_DEFAULT_DATA_KEY = "sharedpreferencesdefaultdata";
  private static final String SQLITE_DATA_DB = ;
  private String PREFS_DEFAULT;
  
  public static void dataChanged(Context paramContext)
  {
    new BackupManager(paramContext).dataChanged();
  }
  
  public void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2)
    throws IOException
  {
    synchronized (MainActivity.sSqliteDataLock)
    {
      super.onBackup(paramParcelFileDescriptor1, paramBackupDataOutput, paramParcelFileDescriptor2);
      return;
    }
  }
  
  public void onCreate()
  {
    this.PREFS_DEFAULT = (getPackageName() + "_preferences");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.PREFS_DEFAULT;
    addHelper("sharedpreferencesdefaultdata", new SharedPreferencesBackupHelper(this, arrayOfString));
    arrayOfString = new String[1];
    arrayOfString[0] = SQLITE_DATA_DB;
    addHelper("myfiles", new FileBackupHelper(this, arrayOfString));
  }
  
  public void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    synchronized (MainActivity.sSqliteDataLock)
    {
      super.onRestore(paramBackupDataInput, paramInt, paramParcelFileDescriptor);
      new DatabaseHelper(this).getWritableDatabase().close();
      Schedule.SetUpAlarmManagerForNextSchedule(this);
      return;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetpro.MyBackupAgent
 * JD-Core Version:    0.7.0.1
 */