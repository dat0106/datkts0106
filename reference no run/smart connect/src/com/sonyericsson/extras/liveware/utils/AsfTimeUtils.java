package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.text.format.DateUtils;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.experience.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AsfTimeUtils
{
  public static int getDayOfWeek()
  {
    Date localDate = new Date(System.currentTimeMillis());
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    return localCalendar.get(7);
  }
  
  public static String getFormattedTime(long paramLong, Context paramContext)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(11, getHours(paramLong));
    localGregorianCalendar.set(12, getMinutes(paramLong));
    return android.text.format.DateFormat.getTimeFormat(paramContext).format(Long.valueOf(localGregorianCalendar.getTime().getTime()));
  }
  
  public static String getFormattedTimeSpan(Time paramTime, Context paramContext)
  {
    String str;
    if (BidiUtils.isRtlAlphabet(paramContext)) {
      str = getFormattedTime(paramTime.getStopTime(), paramContext) + "-" + getFormattedTime(paramTime.getStartTime(), paramContext);
    } else {
      str = getFormattedTime(paramTime.getStartTime(), paramContext) + "-" + getFormattedTime(paramTime.getStopTime(), paramContext);
    }
    return str;
  }
  
  public static String getFormattedWeekDays(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[7];
    arrayOfInt[0] = 2;
    arrayOfInt[1] = 3;
    arrayOfInt[2] = 4;
    arrayOfInt[3] = 5;
    arrayOfInt[4] = 6;
    arrayOfInt[5] = 7;
    arrayOfInt[6] = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 1;
    int m = arrayOfInt.length;
    for (int j = 0; j < m; j++)
    {
      int i = arrayOfInt[j];
      if (Time.isDayInBitField(i, paramInt1))
      {
        if (k == 0) {
          localStringBuilder.append(", ");
        } else {
          k = 0;
        }
        localStringBuilder.append(DateUtils.getDayOfWeekString(i, paramInt2));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int getHours(long paramLong)
  {
    return (int)(paramLong / 3600000L);
  }
  
  public static long getMidnight(boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    if (!paramBoolean) {
      localCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static int getMinutes(long paramLong)
  {
    return (int)(paramLong % 3600000L / 60000L);
  }
  
  public static int getNextDay(int paramInt)
  {
    int i;
    if (paramInt != 7) {
      i = paramInt + 1;
    } else {
      i = 1;
    }
    return i;
  }
  
  public static int getPreviousDay(int paramInt)
  {
    int i;
    if (paramInt != 1) {
      i = paramInt - 1;
    } else {
      i = 7;
    }
    return i;
  }
  
  public static long millisSinceMidnight()
  {
    return System.currentTimeMillis() - getMidnight(true);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.AsfTimeUtils
 * JD-Core Version:    0.7.0.1
 */