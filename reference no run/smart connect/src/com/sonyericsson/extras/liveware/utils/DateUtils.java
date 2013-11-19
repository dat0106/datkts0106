package com.sonyericsson.extras.liveware.utils;

public class DateUtils
{
  public static String getOnlyAmpm(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((paramInt1 == 0) && (!paramBoolean))
    {
      paramInt1 = 12;
      i = 1;
    }
    if (!paramBoolean) {
      if (paramInt1 != 12)
      {
        if (paramInt1 <= 12) {
          localStringBuilder.append(android.text.format.DateUtils.getAMPMString(0));
        } else {
          localStringBuilder.append(android.text.format.DateUtils.getAMPMString(1));
        }
      }
      else if (i == 0) {
        localStringBuilder.append(android.text.format.DateUtils.getAMPMString(1));
      } else {
        localStringBuilder.append(android.text.format.DateUtils.getAMPMString(0));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String getOnlyTime(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) && (!paramBoolean)) {
      paramInt1 = 12;
    }
    if (!paramBoolean)
    {
      if (paramInt1 == 12)
      {
        localStringBuilder.append(12).append(":");
      }
      else
      {
        if (paramInt1 % 12 < 10) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(paramInt1 % 12).append(":");
      }
    }
    else
    {
      if (paramInt1 < 10) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(paramInt1).append(":");
    }
    if (paramInt2 < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */