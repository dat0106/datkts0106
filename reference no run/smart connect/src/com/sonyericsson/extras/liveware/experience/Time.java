package com.sonyericsson.extras.liveware.experience;

import android.content.ContentValues;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class Time
  extends Trigger
{
  public static final int ALL_DAYS = 254;
  private long mId;
  private long mStartTime;
  private long mStopTime;
  private boolean mUpdateConnected = false;
  private boolean mUpdateStartTime = false;
  private boolean mUpdateStopTime = false;
  private boolean mUpdateWeekdays = false;
  private int mWeekdays;
  
  public Time(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramBoolean);
    this.mStartTime = paramLong1;
    this.mStopTime = paramLong2;
    this.mWeekdays = 254;
  }
  
  public Time(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    super(paramBoolean);
    this.mStartTime = paramLong1;
    this.mStopTime = paramLong2;
    this.mWeekdays = paramInt;
  }
  
  public static int getDayMask(int paramInt)
  {
    return 1 << paramInt;
  }
  
  public static boolean isDayInBitField(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt2 & getDayMask(paramInt1)) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean getDayState(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 1) && (paramInt <= 7))
    {
      bool = isDayInBitField(paramInt, this.mWeekdays);
    }
    else
    {
      Dbg.e("Time: Day out of bounds");
      bool = false;
    }
    return bool;
  }
  
  public int getDaysRaw()
  {
    return this.mWeekdays;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentValues getInsertContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("start_time", Long.valueOf(this.mStartTime));
    localContentValues.put("end_time", Long.valueOf(this.mStopTime));
    localContentValues.put("trigger_status", Boolean.valueOf(this.mConnected));
    localContentValues.put("weekdays", Integer.valueOf(this.mWeekdays));
    return localContentValues;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public long getStopTime()
  {
    return this.mStopTime;
  }
  
  ContentValues getUpdateContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.mUpdateStartTime) {
      localContentValues.put("start_time", Long.valueOf(this.mStartTime));
    }
    if (this.mUpdateStopTime) {
      localContentValues.put("end_time", Long.valueOf(this.mStopTime));
    }
    if (this.mUpdateConnected) {
      localContentValues.put("trigger_status", Boolean.valueOf(this.mConnected));
    }
    if (this.mUpdateWeekdays) {
      localContentValues.put("weekdays", Integer.valueOf(this.mWeekdays));
    }
    return localContentValues;
  }
  
  public boolean isActiveAt(long paramLong, int paramInt)
  {
    boolean bool = false;
    if (this.mStopTime - this.mStartTime >= 0L)
    {
      if ((getDayState(paramInt)) && (paramLong >= this.mStartTime) && (paramLong <= this.mStopTime)) {
        bool = true;
      }
    }
    else if (((paramLong >= this.mStartTime) && (getDayState(paramInt))) || ((paramLong <= this.mStopTime) && (getDayState(AsfTimeUtils.getPreviousDay(paramInt))))) {
      bool = true;
    }
    return bool;
  }
  
  public void resetChangedFlags()
  {
    this.mUpdateStartTime = false;
    this.mUpdateStopTime = false;
    this.mUpdateConnected = false;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.mConnected = paramBoolean;
    this.mUpdateConnected = true;
  }
  
  public void setDayState(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 1) && (paramInt > 7))
    {
      Dbg.e("Time: day out of bounds in set.");
    }
    else
    {
      if (!paramBoolean) {
        this.mWeekdays &= (0xFFFFFFFF ^ getDayMask(paramInt));
      } else {
        this.mWeekdays |= getDayMask(paramInt);
      }
      this.mUpdateWeekdays = true;
    }
  }
  
  public void setDaysRaw(int paramInt)
  {
    this.mWeekdays = paramInt;
    this.mUpdateWeekdays = true;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    this.mUpdateStartTime = true;
  }
  
  public void setStopTime(long paramLong)
  {
    this.mStopTime = paramLong;
    this.mUpdateStopTime = true;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Time
 * JD-Core Version:    0.7.0.1
 */