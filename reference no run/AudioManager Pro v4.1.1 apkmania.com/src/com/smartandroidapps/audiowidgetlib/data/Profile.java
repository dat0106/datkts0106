package com.smartandroidapps.audiowidgetlib.data;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.activities.SettingsActivity;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Profile
  implements Constants
{
  public static final int SORT_MODE_ID = 0;
  public static final int SORT_MODE_NAME = 1;
  private static int defaultProfile_id = 1;
  private int _id;
  private Uri alarmRingtone;
  private Context context;
  private DatabaseHelper dbh;
  private int index;
  private String name;
  private Uri notificationRingtone;
  private Uri phoneRingtone;
  private int ringermode;
  private Map<Integer, Integer> streams;
  private int vibeinsilent;
  private int vibratealarm;
  private int vibrateringer;
  
  private Profile()
  {
    this.streams = new Hashtable();
  }
  
  public Profile(String paramString, Context paramContext)
  {
    setUpObject(paramContext);
    this.name = paramString;
    setUpProfileDB();
  }
  
  public static void CreateDefaultProfile(SQLiteDatabase paramSQLiteDatabase)
  {
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(defaultProfile_id);
    arrayOfObject1[1] = "";
    arrayOfObject1[2] = Integer.valueOf(1);
    paramSQLiteDatabase.execSQL("Insert into profile (_id, name,type) VALUES (?,?,?);", arrayOfObject1);
    for (int i = 0;; i++)
    {
      if (i >= 6) {
        return;
      }
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Integer.valueOf(0);
      arrayOfObject2[1] = Integer.valueOf(defaultProfile_id);
      arrayOfObject2[2] = Integer.valueOf(i);
      paramSQLiteDatabase.execSQL("Insert into profilestreamvalue (value, profile_id, stream_id) VALUES (?,?,?);", arrayOfObject2);
    }
  }
  
  private static void CreateInitialProfile(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, Context paramContext)
  {
    Object localObject1 = paramContext.getString(R.string.mute_button);
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if (paramBoolean)
    {
      localObject1 = paramContext.getString(R.string.loud_button);
      j = 2;
      k = 1;
      m = 1;
      i = 1;
    }
    Object localObject2 = new String[1];
    localObject2[0] = localObject1;
    localObject2 = paramSQLiteDatabase.rawQuery("SELECT * FROM profile where name = ?", (String[])localObject2);
    int n;
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      localObject2 = new Object[8];
      localObject2[0] = localObject1;
      localObject2[1] = Integer.valueOf(j);
      localObject2[2] = Integer.valueOf(k);
      localObject2[3] = Integer.valueOf(m);
      localObject2[4] = Integer.valueOf(i);
      localObject2[5] = Settings.System.DEFAULT_ALARM_ALERT_URI.toString();
      localObject2[6] = Settings.System.DEFAULT_RINGTONE_URI.toString();
      localObject2[7] = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
      paramSQLiteDatabase.execSQL("Insert into profile (name,ringermode, vibratealarm, vibrateringer, vibeinsilent, alarmringtone, phoneringtone, notificationringtone) VALUES (?,?,?,?,?,?,?,?);", (Object[])localObject2);
      j = DatabaseHelper.getLastInsertID(paramSQLiteDatabase);
      AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      localObject1 = getStreams().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        n = 0;
        if (paramBoolean) {
          n = localAudioManager.getStreamMaxVolume(i);
        }
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(n);
        arrayOfObject[1] = Integer.valueOf(j);
        arrayOfObject[2] = Integer.valueOf(i);
        paramSQLiteDatabase.execSQL("Insert into profilestreamvalue (value, profile_id, stream_id) VALUES (?,?,?);", arrayOfObject);
      }
    }
    n.close();
  }
  
  public static void CreateInitialProfiles(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    CreateInitialProfile(paramSQLiteDatabase, false, paramContext);
    CreateInitialProfile(paramSQLiteDatabase, true, paramContext);
  }
  
  private static void amSetRingerMode(AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != -1) && (paramInt1 != 2)) {
      if (paramInt2 != 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    paramAudioManager.setRingerMode(paramInt1);
  }
  
  public static void changeStreamsToMax(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    setVibeInSilentSetting(paramContext, true);
    updateVibrateSettting(localAudioManager, 1, 1, paramContext);
    updateVibrateSettting(localAudioManager, 0, 1, paramContext);
    amSetRingerMode(localAudioManager, 2, -1);
    Iterator localIterator = getStreams().keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      int i = ((Integer)localIterator.next()).intValue();
      localAudioManager.setStreamVolume(i, localAudioManager.getStreamMaxVolume(i), 0);
    }
  }
  
  public static void changeStreamsToZero(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    setVibeInSilentSetting(paramContext, false);
    updateVibrateSettting(localAudioManager, 1, 0, paramContext);
    updateVibrateSettting(localAudioManager, 0, 0, paramContext);
    amSetRingerMode(localAudioManager, 0, -1);
    Iterator localIterator = getStreams().keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localAudioManager.setStreamVolume(((Integer)localIterator.next()).intValue(), 0, 0);
    }
  }
  
  public static Profile getDefaultProfile(Context paramContext)
  {
    return getProfile(defaultProfile_id, paramContext);
  }
  
  public static Profile getProfile(int paramInt, Context paramContext)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Object localObject = new String[1];
    localObject[0] = String.valueOf(paramInt);
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT name, ringermode, vibratealarm, vibrateringer, vibeinsilent, alarmringtone, phoneringtone, notificationringtone from Profile where _id = ?;", (String[])localObject);
    if (localCursor.moveToFirst())
    {
      localProfile = new Profile();
      localProfile.dbh = localDatabaseHelper;
      localProfile._id = paramInt;
      localProfile.context = paramContext;
      localProfile.name = localCursor.getString(0);
      localProfile.ringermode = localCursor.getInt(1);
      localProfile.vibratealarm = localCursor.getInt(2);
      localProfile.vibrateringer = localCursor.getInt(3);
      localProfile.vibeinsilent = localCursor.getInt(4);
      if (!localCursor.isNull(5)) {
        localProfile.alarmRingtone = Uri.parse(localCursor.getString(5));
      } else {
        localProfile.alarmRingtone = null;
      }
      if (!localCursor.isNull(6)) {
        localProfile.phoneRingtone = Uri.parse(localCursor.getString(6));
      } else {
        localProfile.phoneRingtone = null;
      }
      if (!localCursor.isNull(7)) {
        localProfile.notificationRingtone = Uri.parse(localCursor.getString(7));
      } else {
        localProfile.notificationRingtone = null;
      }
      localCursor.close();
      localObject = localSQLiteDatabase.rawQuery("SELECT stream_id,value FROM profilestreamvalue where profile_id = ?", (String[])localObject);
      for (;;)
      {
        if (!((Cursor)localObject).moveToNext())
        {
          ((Cursor)localObject).close();
          localSQLiteDatabase.close();
          break;
        }
        localProfile.streams.put(Integer.valueOf(((Cursor)localObject).getInt(0)), Integer.valueOf(((Cursor)localObject).getInt(1)));
      }
    }
    localCursor.close();
    localSQLiteDatabase.close();
    Profile localProfile = null;
    return localProfile;
  }
  
  public static List<Profile> getProfiles(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT name, _id, ringermode, vibratealarm, vibrateringer, vibeinsilent from Profile where type = 0;", null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      localSQLiteDatabase.close();
      return localArrayList;
    }
    Profile localProfile = new Profile();
    localProfile.dbh = localDatabaseHelper;
    localProfile._id = localCursor.getInt(1);
    localProfile.context = paramContext;
    localProfile.name = localCursor.getString(0);
    localProfile.ringermode = localCursor.getInt(2);
    localProfile.vibratealarm = localCursor.getInt(3);
    localProfile.vibrateringer = localCursor.getInt(4);
    localProfile.vibeinsilent = localCursor.getInt(5);
    Object localObject = new String[1];
    localObject[0] = String.valueOf(localProfile._id);
    localObject = localSQLiteDatabase.rawQuery("SELECT stream_id,value FROM profilestreamvalue where profile_id = ?", (String[])localObject);
    for (;;)
    {
      if (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        localArrayList.add(localProfile);
        break;
      }
      localProfile.streams.put(Integer.valueOf(((Cursor)localObject).getInt(0)), Integer.valueOf(((Cursor)localObject).getInt(1)));
    }
  }
  
  public static List<Profile> getProfiles(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(paramContext);
    localDatabaseHelper.getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = localDatabaseHelper.getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT name, _id, ringermode, vibratealarm, vibrateringer, vibeinsilent, profile_index, alarmringtone, phoneringtone, notificationringtone from Profile where type = 0 ORDER BY " + "profile_index ASC" + ";", null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      localSQLiteDatabase.close();
      return localArrayList;
    }
    Profile localProfile = new Profile();
    localProfile.dbh = localDatabaseHelper;
    localProfile._id = localCursor.getInt(1);
    localProfile.context = paramContext;
    localProfile.name = localCursor.getString(0);
    localProfile.ringermode = localCursor.getInt(2);
    localProfile.vibratealarm = localCursor.getInt(3);
    localProfile.vibrateringer = localCursor.getInt(4);
    localProfile.vibeinsilent = localCursor.getInt(5);
    localProfile.index = localCursor.getInt(6);
    if (!localCursor.isNull(7)) {
      localProfile.alarmRingtone = Uri.parse(localCursor.getString(7));
    } else {
      localProfile.alarmRingtone = null;
    }
    if (!localCursor.isNull(8)) {
      localProfile.phoneRingtone = Uri.parse(localCursor.getString(8));
    } else {
      localProfile.phoneRingtone = null;
    }
    if (!localCursor.isNull(9)) {
      localProfile.notificationRingtone = Uri.parse(localCursor.getString(9));
    } else {
      localProfile.notificationRingtone = null;
    }
    Object localObject = new String[1];
    localObject[0] = String.valueOf(localProfile._id);
    localObject = localSQLiteDatabase.rawQuery("SELECT stream_id,value FROM profilestreamvalue where profile_id = ?", (String[])localObject);
    for (;;)
    {
      if (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        localArrayList.add(localProfile);
        break;
      }
      localProfile.streams.put(Integer.valueOf(((Cursor)localObject).getInt(0)), Integer.valueOf(((Cursor)localObject).getInt(1)));
    }
  }
  
  public static ArrayList<String> getProfilesMap(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new DatabaseHelper(paramContext);
    ((DatabaseHelper)localObject).getWritableDatabase().close();
    SQLiteDatabase localSQLiteDatabase = ((DatabaseHelper)localObject).getReadableDatabase();
    localObject = localSQLiteDatabase.rawQuery("SELECT name, _id from Profile where type = 0;", null);
    for (;;)
    {
      if (!((Cursor)localObject).moveToNext())
      {
        localSQLiteDatabase.close();
        return localArrayList;
      }
      localArrayList.add(((Cursor)localObject).getInt(1) + "," + ((Cursor)localObject).getString(0));
    }
  }
  
  public static Map<Integer, Integer> getStreams()
  {
    Hashtable localHashtable = new Hashtable();
    localHashtable.put(Integer.valueOf(0), Integer.valueOf(0));
    localHashtable.put(Integer.valueOf(1), Integer.valueOf(0));
    localHashtable.put(Integer.valueOf(2), Integer.valueOf(0));
    localHashtable.put(Integer.valueOf(3), Integer.valueOf(0));
    localHashtable.put(Integer.valueOf(4), Integer.valueOf(0));
    localHashtable.put(Integer.valueOf(5), Integer.valueOf(0));
    return localHashtable;
  }
  
  public static boolean getVibeInSilentSetting(Context paramContext)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      Log.e("AudioManager", "no vibe in silent setting in jellybean+");
      return i;
    }
    for (int j = 0;; k = 0)
    {
      try
      {
        j = Settings.System.getInt(paramContext.getContentResolver(), "vibrate_in_silent");
        if (j != i) {
          continue;
        }
        j = i;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          int k;
          localSettingNotFoundException.printStackTrace();
        }
      }
      i = j;
      break;
    }
  }
  
  public static boolean getVibeWhenRingingSetting(Context paramContext)
  {
    for (boolean bool = false;; bool = false)
    {
      try
      {
        int i = Settings.System.getInt(paramContext.getContentResolver(), "vibrate_when_ringing");
        if (i != 1) {
          continue;
        }
        bool = true;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          localSettingNotFoundException.printStackTrace();
        }
      }
      return bool;
    }
  }
  
  private void saveVolumeConfiguration(AudioManager paramAudioManager, SharedPreferences.Editor paramEditor)
  {
    paramEditor.putInt("stream_voice", paramAudioManager.getStreamVolume(0));
    paramEditor.putInt("stream_system", paramAudioManager.getStreamVolume(1));
    paramEditor.putInt("stream_ring", paramAudioManager.getStreamVolume(2));
    paramEditor.putInt("stream_music", paramAudioManager.getStreamVolume(3));
    paramEditor.putInt("stream_alarm", paramAudioManager.getStreamVolume(4));
    paramEditor.putInt("stream_notification", paramAudioManager.getStreamVolume(5));
    paramEditor.putInt("ringerMode", paramAudioManager.getRingerMode());
    paramEditor.commit();
  }
  
  private void setAllStreamsToCurrent(boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase)
  {
    AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
    int m = localAudioManager.getRingerMode();
    boolean bool;
    int k;
    int i;
    if (Build.VERSION.SDK_INT < 16)
    {
      bool = getVibeInSilentSetting(this.context);
      k = localAudioManager.getVibrateSetting(1);
      i = localAudioManager.getVibrateSetting(0);
    }
    else
    {
      if (!getVibeWhenRingingSetting(this.context))
      {
        i = 0;
        bool = false;
      }
      else
      {
        i = 1;
        bool = true;
      }
      k = i;
    }
    Hashtable localHashtable = new Hashtable();
    Iterator localIterator = this.streams.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        setAllValues(m, k, i, bool, localHashtable, paramBoolean, paramSQLiteDatabase);
        return;
      }
      int j = ((Integer)localIterator.next()).intValue();
      localHashtable.put(Integer.valueOf(j), Integer.valueOf(localAudioManager.getStreamVolume(j)));
    }
  }
  
  private void setAllValues(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, Map<Integer, Integer> paramMap, boolean paramBoolean2, SQLiteDatabase paramSQLiteDatabase)
  {
    setRingerMode(paramInt1, paramSQLiteDatabase);
    setVibrateAlarm(paramInt2, paramSQLiteDatabase);
    setVibrateRinger(paramInt3, paramSQLiteDatabase);
    int i;
    if (!paramBoolean1) {
      i = 0;
    } else {
      i = 1;
    }
    setVibeInSilent(i, paramSQLiteDatabase);
    setRingtones(paramSQLiteDatabase);
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      int j = ((Integer)localIterator.next()).intValue();
      setStreamValue(j, ((Integer)paramMap.get(Integer.valueOf(j))).intValue(), paramSQLiteDatabase, paramBoolean2);
    }
  }
  
  private void setRingerMode(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    this.ringermode = paramInt;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(this._id);
    paramSQLiteDatabase.execSQL("Update profile set ringermode = ? where _id = ?;", arrayOfObject);
  }
  
  private void setRingtones(SQLiteDatabase paramSQLiteDatabase)
  {
    this.phoneRingtone = RingtoneManager.getActualDefaultRingtoneUri(this.context, 1);
    this.notificationRingtone = RingtoneManager.getActualDefaultRingtoneUri(this.context, 2);
    this.alarmRingtone = RingtoneManager.getActualDefaultRingtoneUri(this.context, 4);
    ContentValues localContentValues = new ContentValues();
    if (this.phoneRingtone != null) {
      localContentValues.put("phoneringtone", this.phoneRingtone.toString());
    } else {
      localContentValues.putNull("phoneringtone");
    }
    if (this.alarmRingtone != null) {
      localContentValues.put("alarmringtone", this.alarmRingtone.toString());
    } else {
      localContentValues.putNull("alarmringtone");
    }
    if (this.notificationRingtone != null) {
      localContentValues.put("notificationringtone", this.notificationRingtone.toString());
    } else {
      localContentValues.putNull("notificationringtone");
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this._id);
    paramSQLiteDatabase.update("profile", localContentValues, "_id=?", arrayOfString);
  }
  
  private void setUpObject(Context paramContext)
  {
    this.context = paramContext;
    this.dbh = new DatabaseHelper(paramContext);
    this.dbh.getWritableDatabase().close();
    this.streams = getStreams();
  }
  
  private void setUpProfileDB()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    localSQLiteDatabase.execSQL("PRAGMA synchronous=OFF");
    localSQLiteDatabase.execSQL("BEGIN");
    Object localObject = new Object[2];
    localObject[0] = this.name;
    localObject[1] = Integer.valueOf(0);
    localSQLiteDatabase.execSQL("Insert into profile (name,type) VALUES (?,?);", (Object[])localObject);
    localObject = localSQLiteDatabase.rawQuery("SELECT last_insert_rowid();", null);
    ((Cursor)localObject).moveToFirst();
    this._id = ((Cursor)localObject).getInt(0);
    ((Cursor)localObject).close();
    setAllStreamsToCurrent(true, localSQLiteDatabase);
    localSQLiteDatabase.execSQL("COMMIT");
    localSQLiteDatabase.close();
  }
  
  private void setVibeInSilent(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    this.vibeinsilent = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.vibratealarm = -1;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(this._id);
    paramSQLiteDatabase.execSQL("Update profile set vibeinsilent = ? where _id = ?;", arrayOfObject);
  }
  
  private static void setVibeInSilentSetting(Context paramContext, int paramInt)
  {
    if (paramInt != -1)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = false;
      } else {
        bool = true;
      }
      setVibeInSilentSetting(paramContext, bool);
    }
  }
  
  public static void setVibeInSilentSetting(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      int i;
      if (!paramBoolean) {
        i = 0;
      } else {
        i = 1;
      }
      Settings.System.putInt(localContentResolver, "vibrate_in_silent", i);
    }
  }
  
  public static void setVibeWhenRingingSetting(Context paramContext, boolean paramBoolean, AudioManager paramAudioManager)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    Settings.System.putInt(localContentResolver, "vibrate_when_ringing", i);
    if (paramAudioManager.getRingerMode() != 2) {
      if (!paramBoolean) {
        paramAudioManager.setRingerMode(0);
      } else {
        paramAudioManager.setRingerMode(1);
      }
    }
  }
  
  private void setVibrateAlarm(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    this.vibratealarm = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.vibratealarm = -1;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(this._id);
    paramSQLiteDatabase.execSQL("Update profile set vibratealarm = ? where _id = ?;", arrayOfObject);
  }
  
  private void setVibrateRinger(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    this.vibrateringer = paramInt;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(this._id);
    paramSQLiteDatabase.execSQL("Update profile set vibrateringer = ? where _id = ?;", arrayOfObject);
  }
  
  private void updateRingtones(Context paramContext)
  {
    if ((this.phoneRingtone == null) || (!this.phoneRingtone.equals(Settings.System.DEFAULT_RINGTONE_URI))) {
      RingtoneManager.setActualDefaultRingtoneUri(paramContext, 1, this.phoneRingtone);
    }
    if ((this.notificationRingtone == null) || (!this.notificationRingtone.equals(Settings.System.DEFAULT_NOTIFICATION_URI))) {
      RingtoneManager.setActualDefaultRingtoneUri(paramContext, 2, this.notificationRingtone);
    }
    if ((this.alarmRingtone == null) || (!this.alarmRingtone.equals(Settings.System.DEFAULT_ALARM_ALERT_URI))) {
      RingtoneManager.setActualDefaultRingtoneUri(paramContext, 4, this.alarmRingtone);
    }
  }
  
  private static void updateVibrateSettting(AudioManager paramAudioManager, int paramInt1, int paramInt2, Context paramContext)
  {
    if (paramInt2 != -1) {
      if (Build.VERSION.SDK_INT < 16)
      {
        if (!getVibeInSilentSetting(paramContext))
        {
          if (paramInt2 == 2) {
            paramInt2 = 0;
          }
        }
        else if (paramInt2 == 0) {
          paramInt2 = 2;
        }
        paramAudioManager.setVibrateSetting(paramInt1, paramInt2);
      }
      else if (paramInt1 == 0)
      {
        boolean bool;
        if (paramInt2 == 0) {
          bool = false;
        } else {
          bool = true;
        }
        setVibeWhenRingingSetting(paramContext, bool, paramAudioManager);
      }
    }
  }
  
  public void Delete()
  {
    Schedule.deleteSchedulesForProfile(this._id, this.context);
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Delete from profile where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
    Dispose();
  }
  
  public void Dispose()
  {
    this.streams = null;
    this.dbh = null;
    this.context = null;
    this._id = -1;
    this.name = null;
  }
  
  public void changeStreamsToProfile()
  {
    final SettingsManager localSettingsManager = new SettingsManager(this.context);
    if (RunTimeConfig.isFullVersion(this.context)) {
      localSettingsManager.editnew().putTempDisableVolumeLock(true).commit();
    }
    AudioManager localAudioManager = (AudioManager)this.context.getSystemService("audio");
    setVibeInSilentSetting(this.context, getVibrateInSilent());
    updateVibrateSettting(localAudioManager, 1, getVibrateAlarm(), this.context);
    updateVibrateSettting(localAudioManager, 0, getVibrateRinger(), this.context);
    amSetRingerMode(localAudioManager, getRingerMode(), getVibrateInSilent());
    int k;
    if (getRingerMode() != 2) {
      k = 0;
    } else {
      k = 1;
    }
    Iterator localIterator = this.streams.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        updateRingtones(this.context);
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "Profile changeStreamsToProfile() ProfileId: " + getId());
        }
        SettingsManager.Editor localEditor = localSettingsManager.editnew();
        localEditor.putCurrentProfile(getId());
        localEditor.commit();
        if (localSettingsManager.getVolumeLocked()) {
          saveVolumeConfiguration(localAudioManager, localSettingsManager.edit());
        }
        SettingsActivity.updateProfileStatusAndNotification(this.context);
        if (localSettingsManager.getBoolean("statBar", false)) {
          SettingsActivity.nm.notify(1, SettingsActivity.console);
        }
        if (RunTimeConfig.isFullVersion(this.context)) {
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              localSettingsManager.editnew().putTempDisableVolumeLock(false).commit();
            }
          }, 500L);
        }
        return;
      }
      int j = ((Integer)localIterator.next()).intValue();
      int i;
      if ((j != 2) && (j != 5) && (j != 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((k != 0) || (i == 0)) {
        localAudioManager.setStreamVolume(j, ((Integer)this.streams.get(Integer.valueOf(j))).intValue(), 0);
      }
    }
  }
  
  public Uri getAlarmRingtoneUri()
  {
    return this.alarmRingtone;
  }
  
  public int getId()
  {
    return this._id;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Uri getNotificationRingtoneUri()
  {
    return this.notificationRingtone;
  }
  
  public Uri getPhoneRingtoneUri()
  {
    return this.phoneRingtone;
  }
  
  public int getRingerMode()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (getVibrateRinger() != 0) && (this.ringermode == 0)) {
      this.ringermode = 1;
    }
    return this.ringermode;
  }
  
  public int getStreamValue(int paramInt)
  {
    return ((Integer)this.streams.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public int getVibrateAlarm()
  {
    if ((Build.VERSION.SDK_INT >= 16) || (this.vibratealarm != -1))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.vibratealarm = -1;
      }
    }
    else {
      this.vibratealarm = this.vibrateringer;
    }
    return this.vibratealarm;
  }
  
  public int getVibrateInSilent()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.vibrateringer = -1;
    }
    return this.vibeinsilent;
  }
  
  public boolean getVibrateInSilentBoolean()
  {
    boolean bool;
    if (this.vibeinsilent == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int getVibrateRinger()
  {
    return this.vibrateringer;
  }
  
  public void setAllStreamsToCurrent()
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    localSQLiteDatabase.execSQL("PRAGMA synchronous=OFF");
    localSQLiteDatabase.execSQL("BEGIN");
    setAllStreamsToCurrent(false, localSQLiteDatabase);
    localSQLiteDatabase.execSQL("COMMIT");
    localSQLiteDatabase.close();
  }
  
  public void setAllValues(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Map<Integer, Integer> paramMap)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    localSQLiteDatabase.execSQL("PRAGMA synchronous=OFF");
    localSQLiteDatabase.execSQL("BEGIN");
    setAllValues(paramInt1, paramInt2, paramInt3, paramBoolean, paramMap, false, localSQLiteDatabase);
    localSQLiteDatabase.execSQL("COMMIT");
    localSQLiteDatabase.close();
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update profile set profile_index = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Integer.valueOf(this._id);
    localSQLiteDatabase.execSQL("Update profile set name = ? where _id = ?;", arrayOfObject);
    localSQLiteDatabase.close();
  }
  
  public void setRingtones(Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    SQLiteDatabase localSQLiteDatabase = this.dbh.getWritableDatabase();
    this.phoneRingtone = paramUri1;
    this.notificationRingtone = paramUri2;
    this.alarmRingtone = paramUri3;
    ContentValues localContentValues = new ContentValues();
    if (paramUri1 != null) {
      localContentValues.put("phoneringtone", paramUri1.toString());
    } else {
      localContentValues.putNull("phoneringtone");
    }
    if (paramUri3 != null) {
      localContentValues.put("alarmringtone", paramUri3.toString());
    } else {
      localContentValues.putNull("alarmringtone");
    }
    if (paramUri2 != null) {
      localContentValues.put("notificationringtone", paramUri2.toString());
    } else {
      localContentValues.putNull("notificationringtone");
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this._id);
    localSQLiteDatabase.update("profile", localContentValues, "_id=?", arrayOfString);
  }
  
  public void setStreamValue(int paramInt1, int paramInt2, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt2);
    arrayOfObject[1] = Integer.valueOf(this._id);
    arrayOfObject[2] = Integer.valueOf(paramInt1);
    if (paramBoolean) {
      paramSQLiteDatabase.execSQL("Insert into profilestreamvalue (value, profile_id, stream_id) VALUES (?,?,?);", arrayOfObject);
    } else {
      paramSQLiteDatabase.execSQL("Update profilestreamvalue set value = ? where profile_id = ? and stream_id = ?;", arrayOfObject);
    }
    this.streams.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.data.Profile
 * JD-Core Version:    0.7.0.1
 */