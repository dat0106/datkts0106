package com.smartandroidapps.audiowidgetlib.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.activities.ProfilesActivity;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.services.VolumeLockService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class VolumeLockReceiver
  extends BroadcastReceiver
  implements Constants
{
  public static final String EXTRA_PREV_VOLUME_STREAM_VALUE = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
  public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
  public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
  private final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
  private SettingsManager mSettings;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.mSettings = new SettingsManager(paramContext);
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "VolumeLockReceiver onReceive(): " + paramIntent.getAction().toString());
    }
    boolean bool2 = this.mSettings.getVolumeLocked();
    boolean bool1 = this.mSettings.getTempDisableVolumeLock();
    if ((bool2) && (!MainActivity.isActive) && (!ProfilesActivity.isActive) && (!ProfilesFragment.isProfilesActive) && (!bool1))
    {
      int i;
      if (!paramIntent.getAction().equals("android.media.RINGER_MODE_CHANGED"))
      {
        if (paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
        {
          i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
          int j = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
          int m = paramIntent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);
          if (MiscUtils.isDebug())
          {
            Log.d("AudioManager", "Stream: " + i);
            Log.d("AudioManager", "New Value: " + j);
            Log.d("AudioManager", "Old Value: " + m);
          }
          m = VolumeLockService.getLockedVolumeStream(VolumeLockService.getStreamByValue(i), this.mSettings);
          if ((m != -1) && (m != j))
          {
            Intent localIntent2 = new Intent(paramContext, VolumeLockService.class);
            localIntent2.putExtra("job", "volumeChanged");
            localIntent2.putExtra("volumeStream", i);
            paramContext.startService(localIntent2);
          }
        }
      }
      else
      {
        i = paramIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "Mode: " + i);
        }
        int k = this.mSettings.getInt("ringerMode", -1);
        if ((k != -1) && (k != i))
        {
          Intent localIntent1 = new Intent(paramContext, VolumeLockService.class);
          localIntent1.putExtra("job", "ringerChanged");
          paramContext.startService(localIntent1);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.VolumeLockReceiver
 * JD-Core Version:    0.7.0.1
 */