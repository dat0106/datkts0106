package com.martinstudio.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.martinstudio.secretvideorecorder.RecorderService;
import com.martinstudio.secretvideorecorder.UserSettingActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WidgetStartStopRecorder
  extends AppWidgetProvider
{
  public static String TOGGLE_WINET = "ToggleWiNetService";
  public static String UPDATE_WIDGET = "UpdateWidget";
  private static Intent serviceIntent;
  private static boolean serviceRunning = false;
  Handler mHandler = new Handler();
  
  private boolean isMyServiceRunning(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (RecorderService.class.getName().equals(localRunningServiceInfo.service.getClassName())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void onReceive(final Context paramContext, Intent paramIntent)
  {
    final RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903042);
    serviceIntent = new Intent(paramContext, RecorderService.class);
    serviceIntent.addFlags(268435456);
    serviceIntent.putExtra("use_camera_front", UserSettingActivity.getInfoWhichCameraForRecorder(paramContext));
    serviceIntent.putExtra("video_quality", UserSettingActivity.getInfoQualityVideo(paramContext));
    serviceIntent.putExtra("use_notification", UserSettingActivity.getInfoEnableNotification(paramContext));
    ComponentName localComponentName;
    if (paramIntent.getAction().equals(TOGGLE_WINET))
    {
      localRemoteViews.setBoolean(2131296281, "setEnabled", false);
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          localRemoteViews.setBoolean(2131296281, "setEnabled", true);
          ComponentName localComponentName = new ComponentName(paramContext, WidgetStartStopRecorder.class);
          AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
        }
      }, 2500L);
      if (!isMyServiceRunning(paramContext))
      {
        paramContext.startService(serviceIntent);
        localRemoteViews.setViewVisibility(2131296282, 0);
        localRemoteViews.setImageViewResource(2131296281, 2130837540);
        Toast.makeText(paramContext, "Service Started", 0).show();
      }
      else
      {
        paramContext.stopService(serviceIntent);
        localRemoteViews.setViewVisibility(2131296282, 4);
        localRemoteViews.setImageViewResource(2131296281, 2130837539);
        Toast.makeText(paramContext, "Service Stopped", 0).show();
      }
      localComponentName = new ComponentName(paramContext, WidgetStartStopRecorder.class);
      AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
    }
    if (paramIntent.getAction().equals(UPDATE_WIDGET))
    {
      if (!isMyServiceRunning(paramContext))
      {
        localRemoteViews.setViewVisibility(2131296282, 4);
        localRemoteViews.setImageViewResource(2131296281, 2130837539);
      }
      else
      {
        localRemoteViews.setViewVisibility(2131296282, 0);
        localRemoteViews.setImageViewResource(2131296281, 2130837540);
      }
      localComponentName = new ComponentName(paramContext, WidgetStartStopRecorder.class);
      AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
    }
    super.onReceive(paramContext, paramIntent);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    for (int j : paramAppWidgetManager.getAppWidgetIds(new ComponentName(paramContext, WidgetStartStopRecorder.class)))
    {
      int m = new Random().nextInt(100);
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903042);
      Log.w("WidgetExample", String.valueOf(m));
      if (!isMyServiceRunning(paramContext))
      {
        localRemoteViews.setViewVisibility(2131296282, 4);
        localRemoteViews.setImageViewResource(2131296281, 2130837539);
      }
      else
      {
        localRemoteViews.setViewVisibility(2131296282, 0);
        localRemoteViews.setImageViewResource(2131296281, 2130837540);
      }
      Intent localIntent = new Intent(paramContext, WidgetStartStopRecorder.class);
      localIntent.setAction(TOGGLE_WINET);
      localIntent.putExtra("appWidgetIds", paramArrayOfInt);
      localRemoteViews.setOnClickPendingIntent(2131296281, PendingIntent.getBroadcast(paramContext, 0, localIntent, 0));
      paramAppWidgetManager.updateAppWidget(j, localRemoteViews);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.martinstudio.widget.WidgetStartStopRecorder
 * JD-Core Version:    0.7.0.1
 */