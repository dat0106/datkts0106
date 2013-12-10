package com.smartandroidapps.audiowidgetlib.services;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RemoteViews;
import com.smartandroidapps.audiowidgetlib.AlarmAlertWakeLock;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.data.Respair;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.receivers.AlarmUpdateReceiver;
import com.smartandroidapps.audiowidgetlib.widget.Main;
import com.smartandroidapps.audiowidgetlib.widget.Mainsmall;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class UpdateService
  extends IntentService
  implements Constants
{
  public UpdateService()
  {
    super("UPDATE_SERVICE");
  }
  
  private RemoteViews buildUpdate(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    boolean bool = new SettingsManager(paramContext).getBoolean("isNewSkin", true);
    RemoteViews localRemoteViews;
    if (!paramBoolean1) {
      localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.main_reg);
    } else {
      localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.main_reg_small);
    }
    if (paramBoolean2)
    {
      PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, MainActivity.class), 0);
      localRemoteViews.setOnClickPendingIntent(R.id.background, localPendingIntent);
    }
    if (paramBoolean3) {
      setAllBarsHere(paramBoolean1, paramContext, localRemoteViews, bool);
    }
    if (paramBoolean4) {
      setBG(localRemoteViews, paramBoolean1, paramContext, bool);
    }
    if (paramBoolean5) {
      setLabelsColor(localRemoteViews, paramBoolean1, paramContext);
    }
    return localRemoteViews;
  }
  
  private static Uri getBarBitmap(int paramInt, AudioManager paramAudioManager, boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    int i = paramAudioManager.getStreamVolume(paramInt);
    int j = paramAudioManager.getStreamMaxVolume(paramInt);
    String str;
    switch ((j + i * 10) / (j * 2))
    {
    default: 
      str = "zero_bars";
      break;
    case 1: 
      str = "one_bars";
      break;
    case 2: 
      str = "two_bars";
      break;
    case 3: 
      str = "three_bars";
      break;
    case 4: 
      str = "four_bars";
      break;
    case 5: 
      str = "five_bars";
    }
    return getBitmapResource(paramContext, str, paramBoolean1, paramBoolean2);
  }
  
  private static Uri getBitmapResource(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new SettingsManager(paramContext);
    Object localObject3 = getResourceWithID(paramContext, paramString, "drawable", paramBoolean1, ((SettingsManager)localObject1).getString("widgetSkin", "Original"));
    Object localObject5;
    if (((Respair)localObject3).resID == 0)
    {
      localObject3 = getResourceWithID(paramContext, paramString, "drawable", paramBoolean1, "Original");
      if (((Respair)localObject3).resID == 0)
      {
        localObject5 = null;
        return localObject5;
      }
    }
    localObject1 = paramContext.getCacheDir().getPath() + "/_widget/" + ((Respair)localObject3).widgetskin + "/" + ((Respair)localObject3).resID + "/cache";
    String str = "_widget_" + ((Respair)localObject3).widgetskin + "_" + ((Respair)localObject3).resID + "_";
    char[] arrayOfChar;
    if (!paramBoolean2)
    {
      localObject5 = new File((String)localObject1);
      if (((File)localObject5).exists()) {
        try
        {
          FileReader localFileReader = new FileReader((File)localObject5);
          localObject5 = new StringBuilder();
          arrayOfChar = new char[1024];
          for (;;)
          {
            int i1 = localFileReader.read(arrayOfChar);
            if (i1 == -1) {
              break;
            }
            ((StringBuilder)localObject5).append(arrayOfChar, 0, i1);
          }
          try
          {
            localObject6 = ((Respair)localObject3).res.openRawResource(((Respair)localObject3).resID);
            str = str + ((Respair)localObject3).res.getString(((Respair)localObject3).resID).replace('/', '_');
            str = str;
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            for (;;)
            {
              localObject3 = getResourceWithID(paramContext, paramString, "drawable", paramBoolean1, "Original");
              localObject1 = paramContext.getCacheDir().getPath() + "/_widget/" + ((Respair)localObject3).widgetskin + "/" + ((Respair)localObject3).resID + "/cache";
              str = "_widget_" + ((Respair)localObject3).widgetskin + "_" + ((Respair)localObject3).resID + "_";
              localObject6 = ((Respair)localObject3).res.openRawResource(((Respair)localObject3).resID);
              str = str + ((Respair)localObject3).res.getString(((Respair)localObject3).resID);
            }
            localObject6 = ((Respair)localObject3).res.getDisplayMetrics();
            i = ((Respair)localObject3).res.getConfiguration().orientation;
            if (!bool2) {
              break label868;
            }
          }
        }
        catch (IOException localIOException4)
        {
          Log.d("AudioManager", localIOException4.getLocalizedMessage(), localIOException4);
        }
      }
    }
    Object localObject6;
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (Build.VERSION.SDK_INT > 7) {
            break label913;
          }
          bool2 = paramString.equals("background");
          localObject1 = ((Respair)localObject3).res.getDrawable(((Respair)localObject3).resID);
          if (localObject1.getClass() == BitmapDrawable.class)
          {
            localObject1 = ((BitmapDrawable)localObject1).getBitmap();
            localObject3 = localObject1;
            label368:
            if (localObject3 == null) {
              continue;
            }
          }
        }
        catch (IOException localIOException1)
        {
          boolean bool2;
          int i;
          int j;
          Log.w("AudioManager", "Updating Widget", localIOException1);
          localObject6 = null;
        }
        try
        {
          localObject1 = paramContext.openFileOutput(str, 1);
          ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
          ((FileOutputStream)localObject1).flush();
          ((FileOutputStream)localObject1).close();
          localObject1 = new File(paramContext.getFilesDir().getAbsolutePath() + "/" + str);
          if (!((File)localObject1).exists()) {
            continue;
          }
          localObject1 = Uri.parse(((File)localObject1).toString());
          localObject6 = localObject1;
        }
        catch (IOException localIOException2)
        {
          Log.w("AudioManager", "Updating Widget", localIOException2);
        }
      }
      bool2.close();
      localObject6 = ((StringBuilder)localObject6).toString();
      localObject6 = new File((String)localObject6);
      if (((File)localObject6).exists())
      {
        if (Build.VERSION.SDK_INT > 7) {}
        for (localObject6 = Uri.fromFile((File)localObject6);; localObject6 = localObject6)
        {
          Log.d("AudioManager", "cache hit: " + ((Uri)localObject6).toString());
          break;
          localObject6 = Uri.parse(((File)localObject6).toString());
        }
        j = 320;
        if (!paramBoolean1) {
          break label1167;
        }
        j = 160;
        break label1167;
      }
    }
    for (;;)
    {
      label770:
      Object localObject4;
      for (;;)
      {
        j = (int)(j * ((DisplayMetrics)localObject6).density);
        int m = (int)(arrayOfChar * ((DisplayMetrics)localObject6).density);
        localObject4 = Bitmap.createBitmap(j, m, Bitmap.Config.ARGB_8888);
        localObject6 = new Canvas((Bitmap)localObject4);
        Rect localRect = new Rect(0, 0, j, m);
        ((Drawable)localObject1).setBounds(localRect);
        ((Drawable)localObject1).draw((Canvas)localObject6);
        break label368;
        label868:
        boolean bool1;
        label913:
        do
        {
          break;
          int k = 38;
          m = 49;
          if (paramBoolean1) {
            k = 12;
          }
          if (localObject4 != 2) {
            break label770;
          }
          m = 35;
          break label770;
          localObject4 = paramContext.openFileOutput(str, 1);
          byte[] arrayOfByte = new byte[16384];
          for (;;)
          {
            k = ((InputStream)localObject6).read(arrayOfByte);
            if (k == -1) {
              break;
            }
            ((FileOutputStream)localObject4).write(arrayOfByte, 0, k);
          }
          ((InputStream)localObject6).close();
          ((FileOutputStream)localObject4).flush();
          ((FileOutputStream)localObject4).close();
          localObject4 = new File(paramContext.getFilesDir().getPath() + "/" + str);
          bool1 = ((File)localObject4).exists();
        } while (!bool1);
        try
        {
          Object localObject2 = new File(localIOException2);
          ((File)localObject2).delete();
          ((File)localObject2).getParentFile().mkdirs();
          ((File)localObject2).createNewFile();
          localObject2 = new FileOutputStream((File)localObject2);
          OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter((OutputStream)localObject2);
          localOutputStreamWriter.append(((File)localObject4).getPath());
          localOutputStreamWriter.flush();
          ((FileOutputStream)localObject2).flush();
          localOutputStreamWriter.close();
          ((FileOutputStream)localObject2).close();
          localObject6 = Uri.fromFile((File)localObject4);
          Log.d("AudioManager", "cache miss: " + ((Uri)localObject6).toString());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.d("AudioManager", localIOException3.getLocalizedMessage(), localIOException3);
          }
        }
      }
      label1167:
      int n = 100;
      if (localObject4 == 2) {
        n = 75;
      }
    }
  }
  
  private static Respair getResourceWithID(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str2 = "_large";
    if (paramBoolean) {
      str2 = "_small";
    }
    String str1 = "";
    int j;
    if (paramString3.startsWith(paramContext.getPackageName() + "." + "themes" + "."))
    {
      j = paramString3.lastIndexOf('/');
      if ((j > -1) && (j + 1 < paramString3.length())) {
        str1 = paramString3.substring(j + 1) + "_";
      }
    }
    for (paramString3 = paramString3.substring(0, j);; paramString3 = paramContext.getPackageName())
    {
      try
      {
        localResources = paramContext.getPackageManager().getResourcesForApplication(paramString3);
        localResources = localResources;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          int i;
          localResources = paramContext.getResources();
          paramString3 = paramContext.getPackageName();
        }
      }
      i = localResources.getIdentifier(str1 + paramString1 + str2, paramString2, paramString3);
      if (i == 0) {
        i = localResources.getIdentifier(str1 + paramString1, paramString2, paramString3);
      }
      return new Respair(localResources, i, paramString3);
      Resources localResources = paramContext.getResources();
      if (!paramString3.equals("Original")) {
        str1 = paramString3.toLowerCase() + "_";
      }
    }
  }
  
  private static void setAllBars(AudioManager paramAudioManager, RemoteViews paramRemoteViews, boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    setBars(paramRemoteViews, R.id.alarm, 4, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    setBars(paramRemoteViews, R.id.music, 3, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    setBars(paramRemoteViews, R.id.alert, 5, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    setBars(paramRemoteViews, R.id.ringer, 2, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    setBars(paramRemoteViews, R.id.system, 1, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    setBars(paramRemoteViews, R.id.voice, 0, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
  }
  
  private void setAllBarsHere(boolean paramBoolean1, Context paramContext, RemoteViews paramRemoteViews, boolean paramBoolean2)
  {
    setAllBars((AudioManager)paramContext.getSystemService("audio"), paramRemoteViews, paramBoolean1, paramContext, paramBoolean2);
  }
  
  private static void setBG(RemoteViews paramRemoteViews, boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    boolean bool = new SettingsManager(paramContext).getBoolean("widgetTransparent", true);
    Object localObject = "background";
    if (bool) {
      localObject = "backgroundt";
    }
    localObject = getBitmapResource(paramContext, (String)localObject, paramBoolean1, paramBoolean2);
    if (localObject != null)
    {
      if (paramBoolean2) {
        paramRemoteViews.setUri(R.id.background, "setImageURI", Uri.parse(""));
      }
      paramRemoteViews.setUri(R.id.background, "setImageURI", (Uri)localObject);
    }
  }
  
  private static void setBars(RemoteViews paramRemoteViews, int paramInt1, int paramInt2, AudioManager paramAudioManager, boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    Uri localUri = getBarBitmap(paramInt2, paramAudioManager, paramBoolean1, paramContext, paramBoolean2);
    if (localUri != null) {
      paramRemoteViews.setUri(paramInt1, "setImageURI", localUri);
    }
  }
  
  private static void setColor(RemoteViews paramRemoteViews, int paramInt, boolean paramBoolean, Context paramContext)
  {
    Respair localRespair = getResourceWithID(paramContext, "labels", "color", paramBoolean, new SettingsManager(paramContext).getString("widgetSkin", "Original"));
    if (localRespair.resID != 0) {}
    try
    {
      i = localRespair.res.getColor(localRespair.resID);
      i = i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    paramRemoteViews.setTextColor(paramInt, i);
  }
  
  private static void setLabelsColor(RemoteViews paramRemoteViews, boolean paramBoolean, Context paramContext)
  {
    if (paramBoolean)
    {
      setColor(paramRemoteViews, R.id.widget_label_alarm_small, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_media_small, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_alert_small, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_ringer_small, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_system_small, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_voice_small, paramBoolean, paramContext);
    }
    else
    {
      setColor(paramRemoteViews, R.id.widget_label_alarm, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_media, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_alert, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_ringer, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_system, paramBoolean, paramContext);
      setColor(paramRemoteViews, R.id.widget_label_voice, paramBoolean, paramContext);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    AlarmAlertWakeLock.acquireCpuWakeLock(this);
  }
  
  public void onDestroy()
  {
    AlarmAlertWakeLock.releaseCpuLock();
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    SettingsManager localSettingsManager = new SettingsManager(this);
    int j = localSettingsManager.getInt("widgetId", 0);
    boolean bool = localSettingsManager.getBoolean("isSmall", false);
    int i = localSettingsManager.getInt("refreshRate", 0);
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
    if (localAppWidgetManager.getAppWidgetInfo(j) != null)
    {
      ComponentName localComponentName;
      if (!bool) {
        localComponentName = new ComponentName(this, Main.class);
      } else {
        localComponentName = new ComponentName(this, Mainsmall.class);
      }
      Object localObject = buildUpdate(this, bool, true, true, true, true);
      localAppWidgetManager.updateAppWidget(localComponentName, (RemoteViews)localObject);
      localSettingsManager.editTemp().putBoolean("isNewSkin", false).commit();
      if (i > 0)
      {
        long l = SystemClock.elapsedRealtime();
        localObject = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmUpdateReceiver.class), 0);
        ((AlarmManager)getSystemService("alarm")).set(3, l + 60 * (i * 1000), (PendingIntent)localObject);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.services.UpdateService
 * JD-Core Version:    0.7.0.1
 */