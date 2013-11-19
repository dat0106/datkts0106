package com.sonyericsson.extras.liveware.asf;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class TelephonyBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Dbg.d("TelephonyBroadcastReceiver.onReceive");
    if ((paramIntent != null) && (paramIntent.getAction().equals("android.intent.action.PHONE_STATE")))
    {
      Object localObject = paramIntent.getStringExtra("state");
      if (TelephonyManager.EXTRA_STATE_IDLE.equals(localObject))
      {
        Dbg.d("TelephonyBroadcastReceiver: in idle state, sending EXTRA_TRIGGER_TYPE_CALL_ENDED intent...");
        Intent localIntent = ExperienceService.getTriggerIntent(paramContext, 4, false, 0L);
        localObject = new ComponentName(paramContext, TelephonyBroadcastReceiver.class);
        paramContext.getPackageManager().setComponentEnabledSetting((ComponentName)localObject, 2, 1);
        if (localIntent != null) {
          paramContext.startService(localIntent);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.TelephonyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */