package com.sonyericsson.extras.liveware.asf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;

public class LiveKeyLauncher
{
  private static final String LIVEKEY_NAME = "Livekey";
  public static final int LIVEKEY_PRESSED = 0;
  public static final int LIVEKEY_RELEASED = 1;
  
  public static void lightUpScreen(Context paramContext)
  {
    ((PowerManager)paramContext.getSystemService("power")).newWakeLock(805306374, "LiveWare").acquire(5000L);
    if (Dbg.v()) {
      Dbg.v("waking up screen slightly");
    }
  }
  
  public static boolean sendLiveKeyEvent(Context paramContext, ComponentName paramComponentName, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435462, "Livekey");
    if (paramComponentName == null) {}
    for (;;)
    {
      return bool2;
      try
      {
        localWakeLock.acquire();
        Intent localIntent = new Intent("com.sonyericsson.extras.livekey");
        boolean bool1 = PackageUtils.checkReceiver(paramContext, paramComponentName);
        localIntent.setComponent(paramComponentName);
        localIntent.putExtra("com.sonyericsson.extras.livekey.id", paramInt1);
        localIntent.putExtra("com.sonyericsson.extras.livekey.state", paramInt2);
        localIntent.putExtra("com.sonyericsson.extras.livekey.timestamp", paramLong);
        localIntent.addFlags(268435456);
        if (!bool1) {}
        for (;;)
        {
          try
          {
            paramContext.startActivity(localIntent);
            localWakeLock.release();
            bool2 = true;
          }
          catch (Exception localException) {}
          paramContext.sendBroadcast(localIntent);
        }
      }
      finally
      {
        localWakeLock.release();
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.LiveKeyLauncher
 * JD-Core Version:    0.7.0.1
 */