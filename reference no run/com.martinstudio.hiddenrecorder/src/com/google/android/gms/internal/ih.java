package com.google.android.gms.internal;

import java.util.ArrayList;

public final class ih
{
  public static void a(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
    }
  }
  
  public static <T> void a(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[i].toString());
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"").append(paramArrayOfString[j]).append("\"");
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
    }
  }
  
  public static <T> ArrayList<T> fV()
  {
    return new ArrayList();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ih
 * JD-Core Version:    0.7.0.1
 */