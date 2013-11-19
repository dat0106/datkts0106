package com.sonyericsson.extras.liveware;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;

public class BootCompleteReceiver2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Dbg.d("BootCompleteReceiver.onReceive");
    PackageUtils.disableAppIfNotOwner(paramContext);
    PackageUtils.updateLauncherActivity(paramContext);
    paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, BootCompleteReceiver2.class), 2, 1);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.BootCompleteReceiver2
 * JD-Core Version:    0.7.0.1
 */