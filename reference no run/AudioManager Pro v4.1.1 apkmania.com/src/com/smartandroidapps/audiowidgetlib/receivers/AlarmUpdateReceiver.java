package com.smartandroidapps.audiowidgetlib.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;

public class AlarmUpdateReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext.startService(new Intent(paramContext, UpdateService.class));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.AlarmUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */