package com.smartandroidapps.audiowidgetlib;

import android.app.Application;
import android.os.Handler;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class AApplication
  extends Application
{
  public static boolean isBooting = false;
  public static boolean isDoingLinkedCheck;
  public static boolean isScheduleApplied;
  public static boolean isShortcutApplied;
  public static boolean samsungHackBypass = false;
  
  static
  {
    isShortcutApplied = false;
    isScheduleApplied = false;
    isDoingLinkedCheck = false;
  }
  
  public static void BootingDone()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        AApplication.isBooting = false;
      }
    }, 5000L);
  }
  
  public static void LinkedCheckDone()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "LinkedCheckDone");
        }
        AApplication.isDoingLinkedCheck = false;
      }
    }, 5000L);
  }
  
  public static void ScheduleDoneBeingApplied()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        AApplication.isScheduleApplied = false;
      }
    }, 1000L);
  }
  
  public static void ShortCutDoneBeingApplied()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        AApplication.isShortcutApplied = false;
      }
    }, 1000L);
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.AApplication
 * JD-Core Version:    0.7.0.1
 */