package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

public class ej
{
  private final Object lq = new Object();
  private final String rO;
  private int rU = 0;
  private long rV = -1L;
  private long rW = -1L;
  private int rX = 0;
  private int rY = -1;
  
  public ej(String paramString)
  {
    this.rO = paramString;
  }
  
  public static boolean i(Context paramContext)
  {
    boolean bool = false;
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0) {
      ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    for (;;)
    {
      return bool;
      ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
      try
      {
        if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
          bool = true;
        } else {
          ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ev.D("Fail to fetch AdActivity theme");
        ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      }
    }
  }
  
  public Bundle b(Context paramContext, String paramString)
  {
    synchronized (this.lq)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.rO);
      localBundle.putLong("basets", this.rW);
      localBundle.putLong("currts", this.rV);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.rY);
      localBundle.putInt("pclick", this.rU);
      localBundle.putInt("pimp", this.rX);
      localBundle.putBoolean("support_transparent_background", i(paramContext));
      return localBundle;
    }
  }
  
  /* Error */
  public void b(aj paramaj, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/google/android/gms/internal/ej:lq	Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 30	com/google/android/gms/internal/ej:rW	J
    //   13: ldc2_w 25
    //   16: lcmp
    //   17: ifne +43 -> 60
    //   20: aload_0
    //   21: lload_2
    //   22: putfield 30	com/google/android/gms/internal/ej:rW	J
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 30	com/google/android/gms/internal/ej:rW	J
    //   30: putfield 28	com/google/android/gms/internal/ej:rV	J
    //   33: aload_1
    //   34: getfield 141	com/google/android/gms/internal/aj:extras	Landroid/os/Bundle;
    //   37: ifnull +39 -> 76
    //   40: aload_1
    //   41: getfield 141	com/google/android/gms/internal/aj:extras	Landroid/os/Bundle;
    //   44: ldc 143
    //   46: iconst_2
    //   47: invokevirtual 147	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   50: iconst_1
    //   51: if_icmpne +25 -> 76
    //   54: aload 5
    //   56: monitorexit
    //   57: goto +32 -> 89
    //   60: aload_0
    //   61: lload_2
    //   62: putfield 28	com/google/android/gms/internal/ej:rV	J
    //   65: goto -32 -> 33
    //   68: astore 4
    //   70: aload 5
    //   72: monitorexit
    //   73: aload 4
    //   75: athrow
    //   76: aload_0
    //   77: iconst_1
    //   78: aload_0
    //   79: getfield 34	com/google/android/gms/internal/ej:rY	I
    //   82: iadd
    //   83: putfield 34	com/google/android/gms/internal/ej:rY	I
    //   86: aload 5
    //   88: monitorexit
    //   89: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ej
    //   0	90	1	paramaj	aj
    //   0	90	2	paramLong	long
    //   68	6	4	localObject1	Object
    //   4	83	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	73	68	finally
    //   76	89	68	finally
  }
  
  public long bJ()
  {
    return this.rW;
  }
  
  public void bw()
  {
    synchronized (this.lq)
    {
      this.rX = (1 + this.rX);
      return;
    }
  }
  
  public void bx()
  {
    synchronized (this.lq)
    {
      this.rU = (1 + this.rU);
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ej
 * JD-Core Version:    0.7.0.1
 */