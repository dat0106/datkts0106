package com.smartandroidapps.audiowidgetlib.receivers;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.Log;
import android.widget.RemoteViews;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.activities.ProfilesActivity;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.services.ToggleService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class CurrentProfileWidget
  extends AppWidgetProvider
  implements Constants
{
  public static final String EXTRA_MODE = "mode";
  public static final String EXTRA_PROFILE = "profname";
  private static final String INTERNAL_OPEN_ACTION = "com.smartandroidapps.audiowidgetlib.INT_OPEN";
  public static final int PROFILE_MODE = 1;
  public static final String SETUP_ACTION = "com.smartandroidapps.audiowidgetlib.SETUP";
  public static final int TOGGLE_MODE = 2;
  public static final String UPDATE_ACTION = "com.smartandroidapps.audiowidgetlib.PROF_WIDG_UPDATE";
  
  private static String getCurrentProfileName(Context paramContext)
  {
    Object localObject = Profile.getProfile(new SettingsManager(paramContext).getCurrentProfileID(), paramContext);
    if (localObject == null) {
      localObject = paramContext.getResources().getString(R.string.profile_none_applied);
    } else {
      localObject = ((Profile)localObject).getName();
    }
    return localObject;
  }
  
  private void updateCurProfWidg(Context paramContext, String paramString)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    ComponentName localComponentName = new ComponentName(paramContext, getClass());
    SettingsManager localSettingsManager = new SettingsManager(paramContext);
    boolean bool = localSettingsManager.getProfileWidgetEnabled();
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "CurrentProfileWidget updateCurProfWidg profWidgetExists: " + bool + " profName: " + paramString);
    }
    int[] arrayOfInt;
    String str1;
    int m;
    if (bool)
    {
      arrayOfInt = localAppWidgetManager.getAppWidgetIds(localComponentName);
      if (MiscUtils.isDebug())
      {
        str1 = "";
        m = arrayOfInt.length;
      }
    }
    for (int i = 0;; i++)
    {
      int k;
      if (i >= m)
      {
        Log.d("AudioManager", "CurrentProfileWidget updateCurProfWidg appWidgetIds.count: " + arrayOfInt.length + " ids: " + str1);
        i = arrayOfInt.length;
        for (j = 0;; j++)
        {
          if (j >= i) {
            return;
          }
          k = arrayOfInt[j];
          RemoteViews localRemoteViews;
          Object localObject;
          switch (localSettingsManager.getProfileWidgetMode(k))
          {
          default: 
            if (MiscUtils.isDebug()) {
              Log.d("AudioManager", "no mode for id " + k);
            }
            break;
          case 1: 
            localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.cur_prof_widg);
            localRemoteViews.setTextViewText(R.id.curprof, paramString);
            localObject = new Intent(paramContext, getClass());
            ((Intent)localObject).setAction("com.smartandroidapps.audiowidgetlib.INT_OPEN");
            ((Intent)localObject).putExtra("mode", 1);
            localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 134217728);
            localRemoteViews.setOnClickPendingIntent(R.id.cur_prof_layout, (PendingIntent)localObject);
            localAppWidgetManager.updateAppWidget(k, localRemoteViews);
            if (MiscUtils.isDebug()) {
              Log.d("AudioManager", "PROF for id " + k);
            }
            break;
          case 2: 
            localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.cur_prof_widg);
            localRemoteViews.setTextViewText(R.id.curprof, paramString);
            localObject = new Intent(paramContext, getClass());
            ((Intent)localObject).setAction("com.smartandroidapps.audiowidgetlib.INT_OPEN");
            ((Intent)localObject).putExtra("mode", 2);
            localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 134217728);
            localRemoteViews.setOnClickPendingIntent(R.id.cur_prof_layout, (PendingIntent)localObject);
            localAppWidgetManager.updateAppWidget(k, localRemoteViews);
            if (MiscUtils.isDebug()) {
              Log.d("AudioManager", "TOGG for id " + k);
            }
            break;
          }
        }
      }
      int j = arrayOfInt[i];
      String str2 = k + j + ",";
    }
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    String str1;
    int m;
    if (MiscUtils.isDebug())
    {
      str1 = "";
      m = paramArrayOfInt.length;
    }
    SettingsManager.Editor localEditor;
    for (int j = 0;; localEditor++)
    {
      int k;
      if (j >= m)
      {
        Log.d("AudioManager", "CurrentProfileWidget onDeleted appWidgetIds.count: " + paramArrayOfInt.length + " ids: " + str1);
        localEditor = new SettingsManager(paramContext).editnew();
        i = paramArrayOfInt.length;
        for (k = 0;; k++)
        {
          if (k >= i)
          {
            localEditor.commit();
            return;
          }
          localEditor.removeProfileWidgetMode(paramArrayOfInt[k]);
        }
      }
      int i = paramArrayOfInt[localEditor];
      String str2 = k + i + ",";
    }
  }
  
  public void onDisabled(Context paramContext)
  {
    super.onDisabled(paramContext);
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "CurrentProfileWidget onDisabled");
    }
    SettingsManager.Editor localEditor = new SettingsManager(paramContext).editnew();
    localEditor.putProfileWidgetEnabled(false);
    localEditor.removeAllProfileWidgetsMode();
    localEditor.commit();
  }
  
  public void onEnabled(Context paramContext)
  {
    super.onEnabled(paramContext);
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "CurrentProfileWidget onEnabled");
    }
    new SettingsManager(paramContext).editnew().putProfileWidgetEnabled(true).commit();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    String str = paramIntent.getAction();
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "CurrentProfileWidget OnReceive action: " + str);
    }
    if (!"com.smartandroidapps.audiowidgetlib.PROF_WIDG_UPDATE".equals(str))
    {
      if (!"com.smartandroidapps.audiowidgetlib.INT_OPEN".equals(str))
      {
        if ("com.smartandroidapps.audiowidgetlib.SETUP".equals(str))
        {
          int i = paramIntent.getIntExtra("appWidgetId", -1);
          int j = paramIntent.getIntExtra("mode", -1);
          new SettingsManager(paramContext).editnew().putProfileWidgetMode(i, j).commit();
          ProfilesFragment.checkProfileStreams(paramContext, true, (AudioManager)paramContext.getSystemService("audio"));
          Log.d("AudioManager", "Current Profile Widget created in mode " + j + " with id " + i);
        }
      }
      else {
        switch (paramIntent.getIntExtra("mode", -1))
        {
        default: 
          break;
        case 1: 
          Intent localIntent = new Intent(paramContext, ProfilesActivity.class);
          localIntent.setFlags(411041792);
          localIntent.putExtra("homeShortcut", true);
          paramContext.startActivity(localIntent);
          break;
        case 2: 
          paramContext.startService(new Intent(paramContext, ToggleService.class));
          break;
        }
      }
    }
    else {
      updateCurProfWidg(paramContext, paramIntent.getStringExtra("profname"));
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    String str;
    int j;
    if (MiscUtils.isDebug())
    {
      str = "";
      j = paramArrayOfInt.length;
    }
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        Log.d("AudioManager", "CurrentProfileWidget onUpdate appWidgetIds.count: " + paramArrayOfInt.length + " ids: " + str);
        updateCurProfWidg(paramContext, getCurrentProfileName(paramContext));
        return;
      }
      int i = paramArrayOfInt[k];
      str = str + i + ",";
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.CurrentProfileWidget
 * JD-Core Version:    0.7.0.1
 */