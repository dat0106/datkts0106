package com.sonyericsson.extras.liveware.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.actions.bluetooth.Bluetooth;
import com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.BluetoothA2dp;
import com.sonyericsson.extras.liveware.actions.datatraffic.DataTraffic;
import com.sonyericsson.extras.liveware.actions.directcall.DirectCallAction;
import com.sonyericsson.extras.liveware.actions.facebook.FacebookAction;
import com.sonyericsson.extras.liveware.actions.launchapp.LaunchApp;
import com.sonyericsson.extras.liveware.actions.music.MusicSettings;
import com.sonyericsson.extras.liveware.actions.music.PlayAction;
import com.sonyericsson.extras.liveware.actions.sms.SmsAction;
import com.sonyericsson.extras.liveware.actions.soundmode.SoundMode;
import com.sonyericsson.extras.liveware.actions.ttssms.TtsSms;
import com.sonyericsson.extras.liveware.actions.ttstime.TtsTime;
import com.sonyericsson.extras.liveware.actions.urllaunch.UrlLauncher;
import com.sonyericsson.extras.liveware.actions.volume.VolumeAction;
import com.sonyericsson.extras.liveware.actions.wifi.Wifi;
import com.sonyericsson.extras.liveware.actions.wifi.WifiHotspot;
import com.sonyericsson.extras.liveware.actions.wifidisplay.WifiDisplay;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PhoneUtils.PhoneNumber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyActionSetsFromPrefsUpgrader
{
  public static void migrateAll(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("finalized", Integer.valueOf(0));
    ((ContentValues)localObject).put("rawSetting", "TO_BE_MIGRATED");
    ((ContentValues)localObject).put("label", "TO_BE_TRANSLATED");
    paramSQLiteDatabase.update("action_set", (ContentValues)localObject, null, null);
    new LaunchAppMigrator(paramContext, paramSQLiteDatabase).migrate();
    new SoundModeMigrator(paramContext, paramSQLiteDatabase).migrate();
    new PlayActionMigrator(paramContext, paramSQLiteDatabase).migrate();
    new UrlLauncherMigrator(paramContext, paramSQLiteDatabase).migrate();
    new DirectCallMigrator(paramContext, paramSQLiteDatabase).migrate();
    new TtsTimeMigrator(paramContext, paramSQLiteDatabase).migrate();
    new FacebookMigrator(paramContext, paramSQLiteDatabase).migrate();
    new VolumeActionMigrator(paramContext, paramSQLiteDatabase).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "bluetooth_setting", Bluetooth.class.getCanonicalName()).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "data_traffic", DataTraffic.class.getCanonicalName()).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "tts_sms_setting", TtsSms.class.getCanonicalName()).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "wifi_setting", Wifi.class.getCanonicalName()).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "wifidisplay_setting", WifiDisplay.class.getCanonicalName()).migrate();
    new OnOffToggleMigrator(paramContext, paramSQLiteDatabase, "wifihotspot_setting", WifiHotspot.class.getCanonicalName()).migrate();
    new BluetoothA2dpMigrator(paramContext, paramSQLiteDatabase).migrate();
    new SmsActionMigrator(paramContext, paramSQLiteDatabase).migrate();
    localObject = new String[1];
    localObject[0] = "0";
    paramSQLiteDatabase.delete("action_set", "finalized=?", (String[])localObject);
  }
  
  public static abstract class ActionSetMigrator
  {
    protected Context mMigratorCtx;
    private SQLiteDatabase mMigratorDb;
    
    public ActionSetMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      this.mMigratorCtx = paramContext;
      this.mMigratorDb = paramSQLiteDatabase;
    }
    
    private long getActionId(String paramString)
    {
      Cursor localCursor = null;
      long l = 0L;
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase = this.mMigratorDb;
          String[] arrayOfString = new String[1];
          arrayOfString[0] = String.valueOf(paramString);
          localCursor = localSQLiteDatabase.query("action", null, "class =? ", arrayOfString, null, null, null);
          if ((localCursor == null) || (!localCursor.moveToNext())) {
            break label118;
          }
          l = localCursor.getLong(localCursor.getColumnIndex("_id"));
          l = l;
        }
        catch (SQLException localSQLException)
        {
          Dbg.e(localSQLException);
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
          continue;
        }
        finally
        {
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        return l;
        label118:
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    
    private List<String> getActionSetUuids()
    {
      String str = getActionClassName();
      long l = getActionId(str);
      localCursor = null;
      ArrayList localArrayList = new ArrayList();
      if (l == 0L)
      {
        Dbg.e("COULD NOT FIND ACTION: " + str);
        return localArrayList;
      }
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase = this.mMigratorDb;
          String[] arrayOfString = new String[1];
          arrayOfString[0] = String.valueOf(l);
          localCursor = localSQLiteDatabase.query("action_set", null, "actionId =? ", arrayOfString, null, null, null);
          if (localCursor != null)
          {
            boolean bool = localCursor.moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        catch (SQLException localSQLException)
        {
          Dbg.e(localSQLException);
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
          continue;
        }
        finally
        {
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        Dbg.d("Found " + localArrayList.size() + " for " + str);
        break;
        localArrayList.add(localCursor.getString(localCursor.getColumnIndex("UUID")));
      }
    }
    
    private void migrateActionSet(String paramString1, String paramString2, String paramString3)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("finalized", Integer.valueOf(1));
        localContentValues.put("rawSetting", paramString2);
        localContentValues.put("label", paramString3);
        SQLiteDatabase localSQLiteDatabase = this.mMigratorDb;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramString1;
        localSQLiteDatabase.update("action_set", localContentValues, "UUID=?", arrayOfString);
        return;
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          Dbg.e(localSQLException);
        }
      }
    }
    
    public abstract String getActionClassName();
    
    public abstract String getLabel(String paramString);
    
    public abstract String getRawSetting(String paramString);
    
    public boolean isValid(String paramString1, String paramString2)
    {
      boolean bool;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    protected void migrate()
    {
      Iterator localIterator = getActionSetUuids().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str3 = getRawSetting(str1);
        if (str3 != null)
        {
          String str2 = getLabel(str3);
          if (isValid(str3, str2)) {
            migrateActionSet(str1, str3, str2);
          }
        }
      }
    }
    
    protected int readIntSetting(String paramString1, String paramString2)
    {
      return this.mMigratorCtx.getSharedPreferences(paramString2, 0).getInt(paramString1, -1);
    }
    
    protected String readSetting(String paramString1, String paramString2)
    {
      return this.mMigratorCtx.getSharedPreferences(paramString2, 0).getString(paramString1, null);
    }
  }
  
  public static class BluetoothA2dpMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public BluetoothA2dpMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return BluetoothA2dp.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return BluetoothA2dp.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      try
      {
        str = BluetoothA2dp.buildRawSetting(this.mMigratorCtx, readSetting(this.mMigratorCtx.getString(2131099651), paramString), readSetting(this.mMigratorCtx.getString(2131099652), paramString));
        str = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str;
          Dbg.e(localJSONException);
          Object localObject = null;
        }
      }
      return str;
    }
  }
  
  public static class DirectCallMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public DirectCallMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return DirectCallAction.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return DirectCallAction.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      String str1;
      try
      {
        String str2 = readSetting(this.mMigratorCtx.getString(2131099657), paramString);
        Object localObject = new PhoneUtils.PhoneNumber();
        ((PhoneUtils.PhoneNumber)localObject).number = readSetting(this.mMigratorCtx.getString(2131099655), paramString);
        ((PhoneUtils.PhoneNumber)localObject).label = readSetting(this.mMigratorCtx.getString(2131099656), paramString);
        if ((!TextUtils.isEmpty(((PhoneUtils.PhoneNumber)localObject).label)) && (!TextUtils.isEmpty(str2)))
        {
          localObject = DirectCallAction.getRawSetting(this.mMigratorCtx, str2, (PhoneUtils.PhoneNumber)localObject).toString();
        }
        else
        {
          localObject = DirectCallAction.getRawSetting(this.mMigratorCtx, ((PhoneUtils.PhoneNumber)localObject).number).toString();
          localObject = localObject;
        }
      }
      catch (JSONException localJSONException)
      {
        Dbg.e(localJSONException);
        str1 = null;
      }
      return str1;
    }
  }
  
  public static class FacebookMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public FacebookMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return FacebookAction.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return FacebookAction.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return FacebookAction.getRawSetting(readIntSetting("facebook_audience", paramString), readSetting("facebook_message", paramString));
    }
  }
  
  public static class LaunchAppMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public LaunchAppMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return LaunchApp.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return LaunchApp.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return readSetting("launch_app_setting", paramString);
    }
  }
  
  public static class OnOffToggleMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    private String mClassName;
    private String mPrefKey;
    
    public OnOffToggleMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
    {
      super(paramSQLiteDatabase);
      this.mPrefKey = paramString1;
      this.mClassName = paramString2;
    }
    
    public String getActionClassName()
    {
      return this.mClassName;
    }
    
    public String getLabel(String paramString)
    {
      return OnOffToggleActivity.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return readSetting(this.mPrefKey, paramString);
    }
  }
  
  public static class PlayActionMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public PlayActionMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return PlayAction.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return PlayAction.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return MusicSettings.buildRawSetting(readSetting("music_settings", paramString), readSetting("music_path", paramString), readSetting("music_track", paramString));
    }
  }
  
  public static class SmsActionMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public SmsActionMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return SmsAction.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return SmsAction.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      try
      {
        str = SmsAction.buildRawSetting(readSetting("sms_contact", paramString), readSetting("sms_number", paramString), readSetting("sms_message", paramString)).toString();
        str = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str;
          Dbg.e(localJSONException);
          Object localObject = null;
        }
      }
      return str;
    }
  }
  
  public static class SoundModeMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public SoundModeMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return SoundMode.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return SoundMode.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return readSetting("sound_mode_setting", paramString);
    }
  }
  
  public static class TtsTimeMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public TtsTimeMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return TtsTime.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return "";
    }
    
    public String getRawSetting(String paramString)
    {
      return "";
    }
    
    public boolean isValid(String paramString1, String paramString2)
    {
      return true;
    }
  }
  
  public static class UrlLauncherMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public static final String URL = "URL";
    
    public UrlLauncherMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return UrlLauncher.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return UrlLauncher.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      return readSetting("URL", paramString);
    }
  }
  
  public static class VolumeActionMigrator
    extends LegacyActionSetsFromPrefsUpgrader.ActionSetMigrator
  {
    public VolumeActionMigrator(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
    {
      super(paramSQLiteDatabase);
    }
    
    public String getActionClassName()
    {
      return VolumeAction.class.getCanonicalName();
    }
    
    public String getLabel(String paramString)
    {
      return VolumeAction.getLabelByRawSetting(this.mMigratorCtx, paramString);
    }
    
    public String getRawSetting(String paramString)
    {
      try
      {
        str = VolumeAction.buildRawSetting(readIntSetting("ring", paramString), readIntSetting("media", paramString), readIntSetting("alarm", paramString)).toString();
        str = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str;
          Dbg.e(localJSONException);
          Object localObject = null;
        }
      }
      return str;
    }
    
    public boolean isValid(String paramString1, String paramString2)
    {
      boolean bool;
      if (!TextUtils.isEmpty(paramString1)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.db.LegacyActionSetsFromPrefsUpgrader
 * JD-Core Version:    0.7.0.1
 */