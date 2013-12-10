package com.smartandroidapps.audiowidgetlib.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;

public class VolumeLockWidget
  extends AppWidgetProvider
  implements Constants
{
  public static final String VOLUME_LOCK_INIT_ACTION = "com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_INIT";
  public static final String VOLUME_LOCK_UPDATE_ACTION = "com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_UPDATE";
  
  private void initVolumeLockWidg(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    ComponentName localComponentName = new ComponentName(paramContext, getClass());
    Object localObject1 = new SettingsManager(paramContext);
    boolean bool = ((SettingsManager)localObject1).getVolumeLocked();
    int[] arrayOfInt;
    int i;
    if (((SettingsManager)localObject1).getVolumeLockWidgetEnabled())
    {
      arrayOfInt = localAppWidgetManager.getAppWidgetIds(localComponentName);
      i = arrayOfInt.length;
    }
    for (int k = 0;; k++)
    {
      if (k >= i) {
        return;
      }
      int j = arrayOfInt[k];
      localObject1 = new RemoteViews(paramContext.getPackageName(), R.layout.volume_lock_widget_layout);
      if (!bool)
      {
        ((RemoteViews)localObject1).setTextViewText(R.id.widgetText, paramContext.getText(R.string.widget_volume_unlocked));
        ((RemoteViews)localObject1).setImageViewResource(R.id.widgetIcon, R.drawable.appwidget_unlocked);
      }
      else
      {
        ((RemoteViews)localObject1).setTextViewText(R.id.widgetText, paramContext.getText(R.string.widget_volume_locked));
        ((RemoteViews)localObject1).setImageViewResource(R.id.widgetIcon, R.drawable.appwidget_locked);
      }
      Object localObject2 = new Intent(paramContext, getClass());
      ((Intent)localObject2).setAction("com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_UPDATE");
      localObject2 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject2, 134217728);
      ((RemoteViews)localObject1).setOnClickPendingIntent(R.id.volume_lock_layout, (PendingIntent)localObject2);
      localAppWidgetManager.updateAppWidget(j, (RemoteViews)localObject1);
    }
  }
  
  private void updateVolumeLockWidg(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    ComponentName localComponentName = new ComponentName(paramContext, getClass());
    Object localObject1 = new SettingsManager(paramContext);
    boolean bool = ((SettingsManager)localObject1).getVolumeLocked();
    int[] arrayOfInt;
    int j;
    if (((SettingsManager)localObject1).getVolumeLockWidgetEnabled())
    {
      arrayOfInt = localAppWidgetManager.getAppWidgetIds(localComponentName);
      j = arrayOfInt.length;
    }
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        if (!bool) {
          localObject1 = paramContext.getText(R.string.volume_unlock_toast).toString();
        } else {
          localObject1 = paramContext.getText(R.string.volume_lock_toast).toString();
        }
        Toast.makeText(paramContext, (CharSequence)localObject1, 0).show();
        ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(50L);
        return;
      }
      int i = arrayOfInt[k];
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.volume_lock_widget_layout);
      if (bool)
      {
        localRemoteViews.setTextViewText(R.id.widgetText, paramContext.getText(R.string.widget_volume_unlocked));
        localRemoteViews.setImageViewResource(R.id.widgetIcon, R.drawable.appwidget_unlocked);
        ((SettingsManager)localObject1).editnew().putVolumeLocked(false).commit();
        bool = false;
      }
      else
      {
        localRemoteViews.setTextViewText(R.id.widgetText, paramContext.getText(R.string.widget_volume_locked));
        localRemoteViews.setImageViewResource(R.id.widgetIcon, R.drawable.appwidget_locked);
        ((SettingsManager)localObject1).editnew().putVolumeLocked(true).commit();
        bool = true;
      }
      Object localObject2 = new Intent(paramContext, getClass());
      ((Intent)localObject2).setAction("com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_UPDATE");
      localObject2 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject2, 134217728);
      localRemoteViews.setOnClickPendingIntent(R.id.volume_lock_layout, (PendingIntent)localObject2);
      localAppWidgetManager.updateAppWidget(i, localRemoteViews);
    }
  }
  
  private void updateWidgetStatus(Context paramContext, boolean paramBoolean)
  {
    new SettingsManager(paramContext).editnew().putVolumeLockWidgetEnabled(paramBoolean).commit();
  }
  
  public void onDisabled(Context paramContext)
  {
    super.onDisabled(paramContext);
    updateWidgetStatus(paramContext, false);
  }
  
  public void onEnabled(Context paramContext)
  {
    super.onEnabled(paramContext);
    updateWidgetStatus(paramContext, true);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    String str = paramIntent.getAction();
    if (!"com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_UPDATE".equals(str))
    {
      if ("com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_INIT".equals(str)) {
        initVolumeLockWidg(paramContext);
      }
    }
    else {
      updateVolumeLockWidg(paramContext);
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    initVolumeLockWidg(paramContext);
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.widget.VolumeLockWidget
 * JD-Core Version:    0.7.0.1
 */