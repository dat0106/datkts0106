package com.smartandroidapps.audiowidgetlib.receivers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.AApplication;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.activities.ProfilesActivity;
import com.smartandroidapps.audiowidgetlib.activities.RingerModeDialog;
import com.smartandroidapps.audiowidgetlib.activities.SettingsActivity;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.services.VolumeLockService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.Iterator;
import java.util.List;

public class RingerModeReceiver
  extends BroadcastReceiver
  implements Constants
{
  private static final String[] CONFLICTING_APPS;
  static final String EXTRA_PREV_VOLUME_STREAM_VALUE = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
  static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
  static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
  static final String RINGER_ACTION = "android.media.RINGER_MODE_CHANGED";
  static final String VOLUME_ACTION = "android.media.VOLUME_CHANGED_ACTION";
  
  static
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "com.idelata.MuteButtonFree";
    arrayOfString[1] = "com.littlephoto";
    arrayOfString[2] = "com.motorola.Camera";
    arrayOfString[3] = "com.noimjosh.profile";
    arrayOfString[4] = "com.urbandroid.sleep";
    arrayOfString[5] = "vStudio.Android.Camera360";
    CONFLICTING_APPS = arrayOfString;
  }
  
  private boolean isRingerRestoreMutedByConflictingApp(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      Object localObject = (ActivityManager.RunningAppProcessInfo)bool.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
      {
        String str = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        localObject = CONFLICTING_APPS;
        int j = localObject.length;
        for (int i = 0; i < j; i++) {
          if (str.equals(localObject[i])) {
            break label93;
          }
        }
      }
    }
    label93:
    boolean bool = true;
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "RingerModeReceiver onReceive(): " + paramIntent.getAction().toString());
    }
    if ((!AApplication.isBooting) && (!AApplication.isDoingLinkedCheck))
    {
      Object localObject = new SettingsManager(paramContext);
      boolean bool4 = paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION");
      boolean bool5 = paramIntent.getAction().equals("android.media.RINGER_MODE_CHANGED");
      int i = paramIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
      if ((MiscUtils.isDebug()) && (i != -1)) {
        Log.d("AudioManager", "RingerModeReceiver EXTRA_RINGER_MODE: " + i);
      }
      boolean bool2 = ((SettingsManager)localObject).getVolumeLocked();
      boolean bool3 = ((SettingsManager)localObject).getTempDisableVolumeLock();
      if ((!bool2) || (bool3)) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      if ((!bool4) || (!AApplication.samsungHackBypass))
      {
        if ((bool5) && ((i == 0) || (i == 1)) && (!bool3))
        {
          AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
          if (localAudioManager.getStreamVolume(5) != 0)
          {
            localAudioManager.setStreamVolume(5, 0, 0);
            AApplication.samsungHackBypass = true;
          }
        }
        if ((!MainActivity.isActive) && (!ProfilesActivity.isActive) && (!ProfilesFragment.isProfilesActive) && (!AApplication.isShortcutApplied) && (!AApplication.isScheduleApplied))
        {
          Intent localIntent3;
          Intent localIntent4;
          Intent localIntent2;
          if (!bool5)
          {
            if (bool4)
            {
              i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
              localIntent3 = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
              int k = paramIntent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);
              if (MiscUtils.isDebug())
              {
                Log.d("AudioManager", "Stream: " + i);
                Log.d("AudioManager", "New Value: " + localIntent3);
                Log.d("AudioManager", "Old Value: " + k);
              }
              if (localIntent3 == k) {
                return;
              }
              if (!bool3)
              {
                ProfilesFragment.checkProfileStreams(paramContext, false, (AudioManager)paramContext.getSystemService("audio"));
              }
              else
              {
                localIntent4 = VolumeLockService.getLockedVolumeStream(VolumeLockService.getStreamByValue(i), (SettingsManager)localObject);
                if ((localIntent4 != -1) && (localIntent4 != localIntent3))
                {
                  localObject = new Intent(paramContext, VolumeLockService.class);
                  ((Intent)localObject).putExtra("job", "volumeChanged");
                  ((Intent)localObject).putExtra("volumeStream", i);
                  paramContext.startService((Intent)localObject);
                  return;
                }
              }
            }
          }
          else
          {
            if (MiscUtils.isDebug()) {
              Log.d("AudioManager", "Mode: " + i);
            }
            if (localIntent4 == 0)
            {
              if (localIntent3 == 0)
              {
                int j = ((SettingsManager)localObject).getCurrentProfileID();
                if (j != -1)
                {
                  Profile localProfile = Profile.getProfile(j, paramContext);
                  if ((localProfile == null) || (localProfile.getRingerMode() != i)) {
                    ProfilesFragment.checkProfileStreams(paramContext, false, (AudioManager)paramContext.getSystemService("audio"));
                  }
                }
                if ((RunTimeConfig.isFullVersion(paramContext)) && ((i == 0) || (i == 1)) && (!isRingerRestoreMutedByConflictingApp(paramContext)) && (((SettingsManager)localObject).getShowRingerRestoreDialog()) && (localIntent3 == 0))
                {
                  localIntent2 = new Intent(paramContext, RingerModeDialog.class);
                  localIntent2.setFlags(276824064);
                  paramContext.startActivity(localIntent2);
                }
              }
            }
            else
            {
              localIntent3 = ((SettingsManager)localObject).getInt("ringerMode", -1);
              if ((localIntent3 != -1) && (localIntent3 != localIntent2)) {
                break label720;
              }
            }
          }
          if (1 != 0)
          {
            localIntent2 = new Intent(paramContext, UpdateService.class);
            paramContext.startService(localIntent2);
          }
          boolean bool1 = ((SettingsManager)localObject).getBoolean("statBar", false);
          if ((bool1) || (1 != 0))
          {
            SettingsActivity.updateProfileStatusAndNotification(paramContext);
            if (bool1)
            {
              SettingsActivity.nm.notify(1, SettingsActivity.console);
              return;
              label720:
              Intent localIntent1 = new Intent(paramContext, VolumeLockService.class);
              localIntent1.putExtra("job", "ringerChanged");
              paramContext.startService(localIntent1);
            }
          }
        }
        else if (MiscUtils.isDebug())
        {
          Log.d("AudioManager", "RingerModeReceiver exit due to activity: " + MainActivity.isActive + ProfilesActivity.isActive + ProfilesFragment.isProfilesActive + AApplication.isShortcutApplied + AApplication.isScheduleApplied);
        }
      }
      else
      {
        AApplication.samsungHackBypass = false;
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.RingerModeReceiver
 * JD-Core Version:    0.7.0.1
 */