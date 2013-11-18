package com.google.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class ah
{
  public static boolean a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
    return a(localIntent, paramContext);
  }
  
  public static boolean a(Intent paramIntent, Context paramContext)
  {
    boolean bool;
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.ah
 * JD-Core Version:    0.7.0.1
 */