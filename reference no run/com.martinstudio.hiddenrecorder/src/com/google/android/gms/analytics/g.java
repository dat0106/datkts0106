package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g
  implements m
{
  private static g tD;
  private static Object tn = new Object();
  protected String tA;
  protected String tB;
  protected String tC;
  protected String tz;
  
  protected g() {}
  
  private g(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.tB = paramContext.getPackageName();
    this.tC = localPackageManager.getInstallerPackageName(this.tB);
    String str2 = this.tB;
    String str1 = null;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      if (localPackageInfo != null)
      {
        str2 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str1 = localPackageInfo.versionName;
      }
      this.tz = str2;
      this.tA = str1;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        aa.A("Error retrieving package info: appName set to " + str2);
      }
    }
  }
  
  public static g cp()
  {
    return tD;
  }
  
  public static void r(Context paramContext)
  {
    synchronized (tn)
    {
      if (tD == null) {
        tD = new g(paramContext);
      }
      return;
    }
  }
  
  public boolean J(String paramString)
  {
    boolean bool;
    if ((!"&an".equals(paramString)) && (!"&av".equals(paramString)) && (!"&aid".equals(paramString)) && (!"&aiid".equals(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String getValue(String paramString)
  {
    String str = null;
    if (paramString != null) {
      if (!paramString.equals("&an"))
      {
        if (!paramString.equals("&av"))
        {
          if (!paramString.equals("&aid"))
          {
            if (paramString.equals("&aiid")) {
              str = this.tC;
            }
          }
          else {
            str = this.tB;
          }
        }
        else {
          str = this.tA;
        }
      }
      else {
        str = this.tz;
      }
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.g
 * JD-Core Version:    0.7.0.1
 */