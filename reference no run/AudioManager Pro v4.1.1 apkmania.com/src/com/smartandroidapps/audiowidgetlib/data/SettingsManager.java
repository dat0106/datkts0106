package com.smartandroidapps.audiowidgetlib.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsManager
{
  public static final String DEFAULT_PREF_WIDGET_SKIN = "Original";
  private static final String OLDPREFERENCE_SETTINGS = "Preferences";
  private static final String PREFC_CURRENT_PROFILE_ID = "currProfileId";
  private static final String PREFC_CURRENT_PROFILE_TIME_LONG = "currProfileTimeLong";
  private static final String PREFC_CURRENT_PROF_WIDGET = "curprofwidg";
  private static final String PREFC_FLAG_DISABLE_VOLUME_LOCK = "disableVolumeLock";
  public static final String PREFC_IS_NEW = "isNew";
  public static final String PREFC_IS_NEW_SKIN = "isNewSkin";
  public static final String PREFC_IS_SMALL = "isSmall";
  public static final String PREFC_PROFILE_WIDGET_MODE_PREFIX = "profileWidgetMode-";
  private static final String PREFC_RINGER_RESTORE_HOUR = "ringerRestoreHour";
  private static final String PREFC_RINGER_RESTORE_MINUTE = "ringerRestoreMinute";
  private static final String PREFC_RINGER_RESTORE_PROFILE_ID = "ringerRestoreProfileID";
  private static final String PREFC_RINGER_RESTORE_VIBRATE = "ringerRestoreVibrate";
  public static final String PREFC_VERSION_CODE = "versionCode";
  private static final String PREFC_VOLUME_LOCK_WIDGET = "volumeLockWidget";
  public static final String PREFC_WIDGET_ID = "widgetId";
  public static final String PREFERENCE_CACHE = "PreferencesCache";
  public static final String PREF_AUDIOMANAGER_THEME = "theme";
  public static final String PREF_ENABLE_SWIPE = "enableSwipe";
  public static final String PREF_REFRESH_RATE = "refreshRate";
  private static final String PREF_RINGER_RESTORE = "showDialog";
  public static final String PREF_SHOW_VOLUME_LOCK_DIALOG = "showVolumeLockDialog";
  public static final String PREF_SORT_MODE = "sortMode";
  public static final String PREF_STAT_BAR = "statBar";
  public static final String PREF_UNLINK = "unLink";
  public static final String PREF_VIBRATE_PROFILE = "vibrateProfile";
  public static final String PREF_VOLUME_LOCK = "volumeLockKey";
  public static final String PREF_VOLUMIZER = "volumizer";
  public static final String PREF_WIDGET_SKIN = "widgetSkin";
  public static final String PREF_WIDGET_TRANSPARENT = "widgetTransparent";
  private Context context;
  private SharedPreferences defPreferences = null;
  private SharedPreferences oldpreferences = null;
  private SharedPreferences tempPreferences = null;
  
  public SettingsManager(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private SharedPreferences getCorrectSharedPreferences(String paramString)
  {
    SharedPreferences localSharedPreferences;
    if ((!paramString.equals("widgetSkin")) && (!paramString.equals("refreshRate")))
    {
      if ((!paramString.equals("widgetId")) && (!paramString.equals("isNewSkin")) && (!paramString.equals("isNew")) && (!paramString.equals("isSmall")) && (!paramString.equals("currProfileId")) && (!paramString.equals("currProfileTimeLong")) && (!paramString.equals("versionCode")) && (!paramString.startsWith("profileWidgetMode-")) && (!paramString.equals("curprofwidg")) && (!paramString.equals("disableVolumeLock")) && (!paramString.equals("volumeLockWidget")) && (!paramString.equals("ringerRestoreHour")) && (!paramString.equals("ringerRestoreMinute")) && (!paramString.equals("ringerRestoreProfileID")) && (!paramString.equals("ringerRestoreVibrate"))) {
        localSharedPreferences = getDefaultPreferences();
      } else {
        localSharedPreferences = getTempPreferences();
      }
    }
    else
    {
      localSharedPreferences = getDefaultPreferences();
      if (getOldPreferences().contains(paramString))
      {
        if (!paramString.equals("widgetSkin")) {
          localSharedPreferences.edit().putInt("refreshRate", getOldPreferences().getInt("refreshRate", 0)).commit();
        } else {
          localSharedPreferences.edit().putString("widgetSkin", getOldPreferences().getString("widgetSkin", "Original")).commit();
        }
        getOldPreferences().edit().clear().commit();
      }
    }
    return localSharedPreferences;
  }
  
  private SharedPreferences getDefaultPreferences()
  {
    if (this.defPreferences == null) {
      this.defPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    }
    return this.defPreferences;
  }
  
  private SharedPreferences getOldPreferences()
  {
    if (this.oldpreferences == null) {
      this.oldpreferences = this.context.getSharedPreferences("Preferences", 0);
    }
    return this.oldpreferences;
  }
  
  private SharedPreferences getTempPreferences()
  {
    if (this.tempPreferences == null) {
      this.tempPreferences = this.context.getSharedPreferences("PreferencesCache", 0);
    }
    return this.tempPreferences;
  }
  
  public SharedPreferences.Editor edit()
  {
    return getDefaultPreferences().edit();
  }
  
  public SharedPreferences.Editor editTemp()
  {
    return getTempPreferences().edit();
  }
  
  public Editor editnew()
  {
    return new Editor(this);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return getCorrectSharedPreferences(paramString).getBoolean(paramString, paramBoolean);
  }
  
  public int getCurrentProfileID()
  {
    return getTempPreferences().getInt("currProfileId", -1);
  }
  
  public long getCurrentProfileTime()
  {
    return getTempPreferences().getLong("currProfileTimeLong", -1L);
  }
  
  public boolean getEnableSwipeNavigation()
  {
    return getDefaultPreferences().getBoolean("enableSwipe", true);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return getCorrectSharedPreferences(paramString).getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, int paramInt)
  {
    return getCorrectSharedPreferences(paramString).getLong(paramString, paramInt);
  }
  
  public boolean getProfileWidgetEnabled()
  {
    return getTempPreferences().getBoolean("curprofwidg", false);
  }
  
  public int getProfileWidgetMode(int paramInt)
  {
    return getTempPreferences().getInt("profileWidgetMode-" + paramInt, -1);
  }
  
  public int getRingerRestoreHour()
  {
    return getTempPreferences().getInt("ringerRestoreHour", 0);
  }
  
  public int getRingerRestoreMinute()
  {
    return getTempPreferences().getInt("ringerRestoreMinute", 0);
  }
  
  public int getRingerRestoreProfileID()
  {
    return getTempPreferences().getInt("ringerRestoreProfileID", -1);
  }
  
  public boolean getRingerRestoreVibrate()
  {
    return getTempPreferences().getBoolean("ringerRestoreVibrate", false);
  }
  
  public boolean getShowRingerRestoreDialog()
  {
    return getDefaultPreferences().getBoolean("showDialog", true);
  }
  
  public boolean getShowVolumeLockDialog()
  {
    return getDefaultPreferences().getBoolean("showVolumeLockDialog", true);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return getCorrectSharedPreferences(paramString1).getString(paramString1, paramString2);
  }
  
  public boolean getTempDisableVolumeLock()
  {
    return getTempPreferences().getBoolean("disableVolumeLock", false);
  }
  
  public String getTheme()
  {
    return getDefaultPreferences().getString("theme", "normal");
  }
  
  public boolean getVolumeLockWidgetEnabled()
  {
    return getTempPreferences().getBoolean("volumeLockWidget", false);
  }
  
  public boolean getVolumeLocked()
  {
    return getDefaultPreferences().getBoolean("volumeLockKey", false);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    getDefaultPreferences().registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    getTempPreferences().registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public class Editor
  {
    private SharedPreferences.Editor defaultEditor = null;
    private SettingsManager settings;
    private SharedPreferences.Editor tempEditor = null;
    
    public Editor(SettingsManager paramSettingsManager)
    {
      this.settings = paramSettingsManager;
    }
    
    private SharedPreferences.Editor getDefaultEditor()
    {
      if (this.defaultEditor == null) {
        this.defaultEditor = this.settings.getDefaultPreferences().edit();
      }
      return this.defaultEditor;
    }
    
    private SharedPreferences.Editor getTempEditor()
    {
      if (this.tempEditor == null) {
        this.tempEditor = this.settings.getTempPreferences().edit();
      }
      return this.tempEditor;
    }
    
    public boolean commit()
    {
      boolean bool = true;
      if (this.defaultEditor != null) {
        bool &= this.defaultEditor.commit();
      }
      if (this.tempEditor != null) {
        bool &= this.tempEditor.commit();
      }
      return bool;
    }
    
    public Editor putCurrentProfile(int paramInt)
    {
      getTempEditor().putInt("currProfileId", paramInt);
      getTempEditor().putLong("currProfileTimeLong", System.currentTimeMillis());
      return this;
    }
    
    public Editor putEnableSwipeNavigation(boolean paramBoolean)
    {
      getDefaultEditor().putBoolean("enableSwipe", paramBoolean);
      return this;
    }
    
    public Editor putProfileWidgetEnabled(boolean paramBoolean)
    {
      getTempEditor().putBoolean("curprofwidg", paramBoolean);
      return this;
    }
    
    public Editor putProfileWidgetMode(int paramInt1, int paramInt2)
    {
      getTempEditor().putInt("profileWidgetMode-" + paramInt1, paramInt2);
      return this;
    }
    
    public Editor putRingerRestoreHour(int paramInt)
    {
      getTempEditor().putInt("ringerRestoreHour", paramInt);
      return this;
    }
    
    public Editor putRingerRestoreMinute(int paramInt)
    {
      getTempEditor().putInt("ringerRestoreMinute", paramInt);
      return this;
    }
    
    public Editor putRingerRestoreProfileID(int paramInt)
    {
      getTempEditor().putInt("ringerRestoreProfileID", paramInt);
      return this;
    }
    
    public Editor putRingerRestoreVibrate(boolean paramBoolean)
    {
      getTempEditor().putBoolean("ringerRestoreVibrate", paramBoolean);
      return this;
    }
    
    public Editor putShowRingerRestoreDialog(boolean paramBoolean)
    {
      getDefaultEditor().putBoolean("showDialog", paramBoolean);
      return this;
    }
    
    public Editor putShowVolumeLockDialog(boolean paramBoolean)
    {
      getDefaultEditor().putBoolean("showVolumeLockDialog", paramBoolean);
      return this;
    }
    
    public Editor putTempDisableVolumeLock(boolean paramBoolean)
    {
      getTempEditor().putBoolean("disableVolumeLock", paramBoolean);
      return this;
    }
    
    public Editor putTheme(String paramString)
    {
      getDefaultEditor().putString("theme", paramString);
      return this;
    }
    
    public Editor putVolumeLockWidgetEnabled(boolean paramBoolean)
    {
      getTempEditor().putBoolean("volumeLockWidget", paramBoolean);
      return this;
    }
    
    public Editor putVolumeLocked(boolean paramBoolean)
    {
      getDefaultEditor().putBoolean("volumeLockKey", paramBoolean);
      return this;
    }
    
    public Editor removeAllProfileWidgetsMode()
    {
      Iterator localIterator = this.settings.getTempPreferences().getAll().entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return this;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getKey()).startsWith("profileWidgetMode-")) {
          getTempEditor().remove((String)localEntry.getKey());
        }
      }
    }
    
    public Editor removeCurrentProfile()
    {
      if (this.settings.getTempPreferences().contains("currProfileId")) {
        getTempEditor().remove("currProfileId");
      }
      return this;
    }
    
    public Editor removeProfileWidgetMode(int paramInt)
    {
      String str = "profileWidgetMode-" + paramInt;
      if (this.settings.getTempPreferences().contains(str)) {
        getTempEditor().remove(str);
      }
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.data.SettingsManager
 * JD-Core Version:    0.7.0.1
 */