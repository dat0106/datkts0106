package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class ij
{
  private static Pattern Hr = null;
  
  public static boolean C(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }
  
  public static int aB(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int aC(int paramInt)
  {
    return paramInt % 1000 / 100;
  }
  
  public static boolean aD(int paramInt)
  {
    boolean bool;
    if (aC(paramInt) != 3) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ij
 * JD-Core Version:    0.7.0.1
 */