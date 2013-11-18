package com.hitek.settingsscheduler;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public abstract class WakeSchedulerIntentService
  extends IntentService
{
  public static final String LOCK_NAME_STATIC = "com.hitek.settingsscheduler.Static";
  private static Context context;
  private static PowerManager.WakeLock lockStatic = null;
  
  public WakeSchedulerIntentService(String paramString)
  {
    super(paramString);
  }
  
  public static void acquireStaticLock(Context paramContext)
  {
    getLock(paramContext).acquire();
    context = paramContext;
  }
  
  /**
   * @deprecated
   */
  private static PowerManager.WakeLock getLock(Context paramContext)
  {
    try
    {
      if (lockStatic == null)
      {
        lockStatic = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "com.hitek.settingsscheduler.Static");
        lockStatic.setReferenceCounted(true);
      }
      PowerManager.WakeLock localWakeLock = lockStatic;
      return localWakeLock;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  abstract void doSchedulerWork(Intent paramIntent, Context paramContext);
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    try
    {
      doSchedulerWork(paramIntent, context);
      return;
    }
    finally
    {
      getLock(this).release();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.WakeSchedulerIntentService
 * JD-Core Version:    0.7.0.1
 */