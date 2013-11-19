package com.sonyericsson.extras.liveware.asf;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TimeService
  extends IntentService
{
  public static final String ACTION_TIME_CHANGED = "com.sonyericsson.extras.TIME_CHANGED";
  private static final String ACTION_TIME_EVENT = "com.sonyericsson.extras.TIME_INITIATOR";
  private static final int ALARM_CODE = 101;
  private static final String EXTRA_ALARM_DAY = "com.sonyericsson.extras.ALARM_DATE";
  private static final String EXTRA_ALARM_TIME = "com.sonyericsson.extras.ALARM_TIME";
  private static final long WAKE_LOCK_TIME_OUT = 2000L;
  private PowerManager.WakeLock mWakeLock;
  
  public TimeService()
  {
    super(TimeService.class.getName());
  }
  
  private void executeInitiators(long[] paramArrayOfLong, boolean paramBoolean)
  {
    Dbg.d("TimeService.executeInitiators");
    if (paramArrayOfLong != null)
    {
      updateInitiators(paramArrayOfLong, paramBoolean);
      Intent localIntent = ExperienceService.getTriggersIntentForTime(this, paramBoolean, paramArrayOfLong);
      if (localIntent != null) {
        startService(localIntent);
      }
    }
  }
  
  public static long getNextAlarm(Context paramContext, long paramLong, List<Long> paramList)
  {
    long l = 86400000L;
    if (paramList.size() > 0)
    {
      Collections.sort(paramList, makeSorter(1L + paramLong));
      l = ((Long)paramList.get(0)).longValue() - paramLong;
      if (l < 0L) {
        l += 86400000L;
      }
    }
    return l + paramLong;
  }
  
  private static Intent getTimeIntent(Context paramContext, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.TIME_INITIATOR");
    localIntent.setComponent(new ComponentName(paramContext, TimeService.class));
    localIntent.putExtra("com.sonyericsson.extras.ALARM_TIME", paramLong);
    localIntent.putExtra("com.sonyericsson.extras.ALARM_DATE", paramInt);
    return localIntent;
  }
  
  private void handleTimeChanged(long paramLong, int paramInt)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    Object localObject1 = localExperienceManager.getTimeInitiatorTimes(paramLong, AsfTimeUtils.getPreviousDay(paramInt));
    Collections.sort((List)localObject1, makeSorter(paramLong));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Long)((Iterator)localObject1).next();
      int i;
      if (((Long)localObject2).longValue() >= paramLong) {
        i = AsfTimeUtils.getPreviousDay(paramInt);
      } else {
        i = paramInt;
      }
      List localList = localExperienceManager.getInitiatorsAt(((Long)localObject2).longValue(), i, true);
      localObject2 = localExperienceManager.getInitiatorsAt(((Long)localObject2).longValue(), i, false);
      runTriggeredActions(paramLong, paramInt, localList, true);
      runTriggeredActions(paramLong, paramInt, (List)localObject2, false);
    }
  }
  
  public static void initializeInitiators(Context paramContext)
  {
    long l = AsfTimeUtils.millisSinceMidnight();
    int i = AsfTimeUtils.getDayOfWeek();
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Object localObject = localExperienceManager.getAllExperiences();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Experience localExperience = (Experience)((Iterator)localObject).next();
        Time localTime = localExperience.getTime();
        if (localTime != null) {
          if ((!localTime.isConnected()) || (localTime.isActiveAt(l, i)))
          {
            if ((!localTime.isConnected()) && (localTime.isActiveAt(l, i)))
            {
              localTime.setConnected(true);
              localExperience.setTime(localTime);
              localExperienceManager.updateExperience(localExperience);
            }
          }
          else
          {
            localTime.setConnected(false);
            localExperience.setTime(localTime);
            localExperienceManager.updateExperience(localExperience);
          }
        }
      }
    }
    setNextAlarm(paramContext, l, i);
  }
  
  private static Comparator<Long> makeSorter(long paramLong)
  {
    new Comparator()
    {
      public int compare(Long paramAnonymousLong1, Long paramAnonymousLong2)
      {
        if (paramAnonymousLong1.longValue() < this.val$now) {
          paramAnonymousLong1 = Long.valueOf(86400000L + paramAnonymousLong1.longValue());
        }
        if (paramAnonymousLong2.longValue() < this.val$now) {
          paramAnonymousLong2 = Long.valueOf(86400000L + paramAnonymousLong2.longValue());
        }
        return paramAnonymousLong1.compareTo(paramAnonymousLong2);
      }
    };
  }
  
  private static long[] makeTimeIdArray(List<Time> paramList)
  {
    long[] arrayOfLong;
    int i;
    if ((paramList != null) && (paramList.size() != 0))
    {
      arrayOfLong = new long[paramList.size()];
      i = 0;
    }
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Time)paramList.get(i)).getId();
      i++;
      continue;
      arrayOfLong = null;
    }
    return arrayOfLong;
  }
  
  private static void setNextAlarm(Context paramContext, long paramLong, int paramInt)
  {
    long l2 = getNextAlarm(paramContext, paramLong, ExperienceManager.getInstance(paramContext).getTimeInitiatorTimes(paramLong, paramInt));
    long l1 = l2 % 86400000L;
    if (l2 > 86400000L) {
      paramInt = AsfTimeUtils.getNextDay(paramInt);
    }
    long l3 = l2 + AsfTimeUtils.getMidnight(true);
    l2 = System.currentTimeMillis();
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (Dbg.d()) {
      Dbg.d("setNextAlarm fullTime:   " + l3 / 1000L + " " + (l3 - System.currentTimeMillis()) / 1000L);
    }
    if (l3 - l2 >= 1000L) {
      localAlarmManager.set(0, l3, wrapAlarmIntent(paramContext, l1, paramInt));
    } else {
      paramContext.startService(getTimeIntent(paramContext, l1, paramInt));
    }
  }
  
  public static void timeTriggerUpdated(Context paramContext, long paramLong, int paramInt)
  {
    setNextAlarm(paramContext, paramLong, paramInt);
  }
  
  public static void timeUpdated(Context paramContext)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.TIME_CHANGED");
    localIntent.setComponent(new ComponentName(paramContext, TimeService.class));
    paramContext.startService(localIntent);
  }
  
  private void updateInitiators(long[] paramArrayOfLong, boolean paramBoolean)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    int j = paramArrayOfLong.length;
    for (int i = 0; i < j; i++) {
      localExperienceManager.updateTime(paramArrayOfLong[i], paramBoolean);
    }
  }
  
  private static PendingIntent wrapAlarmIntent(Context paramContext, long paramLong, int paramInt)
  {
    return PendingIntent.getService(paramContext, 101, getTimeIntent(paramContext, paramLong, paramInt), 134217728);
  }
  
  public void onCreate()
  {
    super.onCreate();
    Dbg.d("TimeService.onCreate");
    this.mWakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, TimeService.class.getName());
    this.mWakeLock.acquire(2000L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Dbg.d("TimeService.onDestroy");
    if (this.mWakeLock.isHeld()) {
      this.mWakeLock.release();
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Dbg.d("TimeService.onHandleIntent");
    if ((paramIntent != null) && (paramIntent.getAction() != null))
    {
      long l2 = AsfTimeUtils.millisSinceMidnight();
      int j = AsfTimeUtils.getDayOfWeek();
      String str = paramIntent.getAction();
      Object localObject = ExperienceManager.getInstance(this);
      if (!str.equals("com.sonyericsson.extras.TIME_INITIATOR"))
      {
        if (!str.equals("com.sonyericsson.extras.TIME_CHANGED"))
        {
          Dbg.e("TimeService unknown action: " + str);
        }
        else
        {
          handleTimeChanged(l2, j);
          setNextAlarm(this, l2, j);
        }
      }
      else
      {
        long l1 = paramIntent.getLongExtra("com.sonyericsson.extras.ALARM_TIME", -1L);
        int i = paramIntent.getIntExtra("com.sonyericsson.extras.ALARM_DATE", -1);
        long[] arrayOfLong;
        if (((l2 >= l1) || (i != j)) && (i != AsfTimeUtils.getNextDay(j)))
        {
          arrayOfLong = makeTimeIdArray(((ExperienceManager)localObject).getInitiatorsAt(l1, i, true));
          localObject = makeTimeIdArray(((ExperienceManager)localObject).getInitiatorsAt(l1, i, false));
          executeInitiators(arrayOfLong, false);
          executeInitiators((long[])localObject, true);
          setNextAlarm(this, l1, i);
        }
        else
        {
          setNextAlarm(this, arrayOfLong, i);
        }
      }
    }
  }
  
  public void runTriggeredActions(long paramLong, int paramInt, List<Time> paramList, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Time localTime = (Time)localIterator.next();
      if (localTime.isActiveAt(paramLong, paramInt) != paramBoolean)
      {
        long[] arrayOfLong = new long[1];
        arrayOfLong[0] = localTime.getId();
        boolean bool;
        if (!paramBoolean) {
          bool = true;
        } else {
          bool = false;
        }
        executeInitiators(arrayOfLong, bool);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.TimeService
 * JD-Core Version:    0.7.0.1
 */