package com.smartandroidapps.audiowidgetlib.services;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class VolumeLockService
  extends IntentService
  implements Constants
{
  public static final String EXTRA_JOB = "job";
  public static final String EXTRA_RINGER_MODE_CHANGED = "ringerChanged";
  public static final String EXTRA_STREAM = "volumeStream";
  public static final String EXTRA_VOLUME_CHANGED = "volumeChanged";
  public static final String RINGER_MODE = "ringerMode";
  public static final String STREAM_ALARM = "stream_alarm";
  public static final String STREAM_MUSIC = "stream_music";
  public static final String STREAM_NOTIFICATION = "stream_notification";
  public static final String STREAM_RING = "stream_ring";
  public static final String STREAM_SYSTEM = "stream_system";
  public static final String STREAM_VOICE_CALL = "stream_voice";
  private AudioManager mAudioManager;
  private SettingsManager mSettings;
  
  public VolumeLockService()
  {
    super("VolumeLockService");
  }
  
  public static int getLockedVolumeStream(String paramString, SettingsManager paramSettingsManager)
  {
    return paramSettingsManager.getInt(paramString, -1);
  }
  
  public static String getStreamByValue(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
      break;
    case 0: 
      str = "stream_voice";
      break;
    case 1: 
      str = "stream_system";
      break;
    case 2: 
      str = "stream_ring";
      break;
    case 3: 
      str = "stream_music";
      break;
    case 4: 
      str = "stream_alarm";
      break;
    case 5: 
      str = "stream_notification";
    }
    return str;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mAudioManager = ((AudioManager)getSystemService("audio"));
    this.mSettings = new SettingsManager(this);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("job");
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "VolumeLockService onHandleIntent(): " + str);
    }
    if (RunTimeConfig.isFullVersion(this)) {
      this.mSettings.editnew().putTempDisableVolumeLock(true).commit();
    }
    if (!str.equals("ringerChanged"))
    {
      if (str.equals("volumeChanged"))
      {
        int k = paramIntent.getIntExtra("volumeStream", -1);
        str = getStreamByValue(k);
        int j = getLockedVolumeStream(str, this.mSettings);
        if (j != -1)
        {
          this.mAudioManager.setStreamVolume(k, j, 1);
          if (MiscUtils.isDebug()) {
            Log.d("AudioManager", "VolumeLockService reverting stream: " + str + " to value: " + j);
          }
        }
      }
    }
    else
    {
      int i = this.mSettings.getInt("ringerMode", -1);
      if (i != -1)
      {
        this.mAudioManager.setRingerMode(i);
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "VolumeLockService reverting to ringer mode: " + i);
        }
      }
    }
    this.mSettings.editnew().putTempDisableVolumeLock(false).commit();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.services.VolumeLockService
 * JD-Core Version:    0.7.0.1
 */