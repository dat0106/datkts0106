package com.smartandroidapps.audiowidgetlib.util;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.LinearLayout;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;

public class OldAPIHelper
{
  public static void dataChanged(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 8) && (RunTimeConfig.isFullVersion(paramContext))) {
      OldAPIHelper8.dataChanged(paramContext);
    }
  }
  
  public static LinearLayout getLinearLayout_Holo_ButtonBar_AlertDialog(Context paramContext)
  {
    LinearLayout localLinearLayout;
    if (Build.VERSION.SDK_INT < 11) {
      localLinearLayout = new LinearLayout(paramContext);
    } else {
      localLinearLayout = OldAPIHelper11.getLinearLayout_Holo_ButtonBar_AlertDialog(paramContext);
    }
    return localLinearLayout;
  }
  
  public static boolean hasSystemTelephony(PackageManager paramPackageManager)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 7) {
      bool = true;
    } else {
      bool = OldAPIHelper7.hasSystemTelephony(paramPackageManager);
    }
    return bool;
  }
  
  public static boolean isAtLeastLargeHC(Context paramContext)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 13)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        int i = 0xF & paramContext.getResources().getConfiguration().screenLayout;
        if ((i == 3) || (i == 4)) {
          bool = true;
        }
      }
    }
    else {
      bool = OldAPIHelper13.isAtLeastSmallestScreenWidth(paramContext, 550);
    }
    return bool;
  }
  
  public static void setNotificationLowPriority(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      OldAPIHelper16.setNotificationLowPriority(paramNotification);
    }
  }
  
  public static void setupActionBar(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      OldAPIHelper11.setupActionBar(paramActivity);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.util.OldAPIHelper
 * JD-Core Version:    0.7.0.1
 */