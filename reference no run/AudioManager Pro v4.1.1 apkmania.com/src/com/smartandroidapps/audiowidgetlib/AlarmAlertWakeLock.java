package com.smartandroidapps.audiowidgetlib;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class AlarmAlertWakeLock
{
  private static PowerManager.WakeLock sCpuWakeLock;
  
  public static void acquireCpuWakeLock(Context paramContext)
  {
    if (sCpuWakeLock == null)
    {
      sCpuWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "com.smartandroidapps.audiowidgetlib");
      sCpuWakeLock.acquire();
    }
  }
  
  public static void releaseCpuLock()
  {
    if (sCpuWakeLock != null)
    {
      sCpuWakeLock.release();
      sCpuWakeLock = null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.AlarmAlertWakeLock
 * JD-Core Version:    0.7.0.1
 */