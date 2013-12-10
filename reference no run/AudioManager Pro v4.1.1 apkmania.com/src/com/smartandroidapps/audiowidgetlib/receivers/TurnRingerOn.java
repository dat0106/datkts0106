package com.smartandroidapps.audiowidgetlib.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;

public final class TurnRingerOn
  extends BroadcastReceiver
  implements Constants
{
  public static final String EXTRA_ID = "profileId";
  public static final String EXTRA_VIBRATE = "vibrate";
  
  public static void cancelScheduled(Context paramContext)
  {
    getAlarmService(paramContext).cancel(createPendingIntent(paramContext, 0, false));
  }
  
  public static PendingIntent createPendingIntent(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, TurnRingerOn.class);
    localIntent.putExtra("profileId", paramInt);
    localIntent.putExtra("vibrate", paramBoolean);
    return PendingIntent.getBroadcast(paramContext, 0, localIntent, 268435456);
  }
  
  private static AlarmManager getAlarmService(Context paramContext)
  {
    return (AlarmManager)paramContext.getSystemService("alarm");
  }
  
  private AudioManager getAudioManager(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public static void schedule(Context paramContext, PendingIntent paramPendingIntent, long paramLong)
  {
    getAlarmService(paramContext).set(2, paramLong, paramPendingIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = getAudioManager(paramContext);
    if ((((AudioManager)localObject).getRingerMode() == 0) || (((AudioManager)localObject).getRingerMode() == 1))
    {
      int i = paramIntent.getExtras().getInt("profileId", 0);
      localObject = paramContext.getString(R.string.profile_notfound);
      Log.d("AudioManager", "restoring profile: " + i);
      if (Profile.getProfile(i, paramContext) != null)
      {
        Profile localProfile = Profile.getProfile(i, paramContext);
        localProfile.changeStreamsToProfile();
        paramContext.startService(new Intent(paramContext, UpdateService.class));
        if (paramIntent.getExtras().getBoolean("vibrate", false)) {
          ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(125L);
        }
        localObject = paramContext.getString(R.string.profile_applied);
        if (!((String)localObject).contains("{0}")) {
          localObject = localProfile.getName() + " " + (String)localObject;
        } else {
          localObject = ((String)localObject).replace("{0}", localProfile.getName());
        }
      }
      Toast.makeText(paramContext, (CharSequence)localObject, 0).show();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.TurnRingerOn
 * JD-Core Version:    0.7.0.1
 */