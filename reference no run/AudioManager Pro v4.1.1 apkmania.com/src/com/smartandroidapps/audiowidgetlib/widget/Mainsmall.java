package com.smartandroidapps.audiowidgetlib.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;

public class Mainsmall
  extends AppWidgetProvider
{
  public void onDisabled(Context paramContext) {}
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    Intent localIntent = new Intent();
    new SettingsManager(paramContext).editTemp().putInt("widgetId", paramArrayOfInt[0]).putBoolean("isNew", true).putBoolean("isNewSkin", true).commit();
    localIntent.setClass(paramContext, UpdateService.class);
    paramContext.startService(localIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.widget.Mainsmall
 * JD-Core Version:    0.7.0.1
 */