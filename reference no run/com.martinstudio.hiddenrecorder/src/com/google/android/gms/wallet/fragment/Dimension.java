package com.google.android.gms.wallet.fragment;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Dimension
{
  public static final int MATCH_PARENT = -1;
  public static final int UNIT_DIP = 1;
  public static final int UNIT_IN = 4;
  public static final int UNIT_MM = 5;
  public static final int UNIT_PT = 3;
  public static final int UNIT_PX = 0;
  public static final int UNIT_SP = 2;
  public static final int WRAP_CONTENT = -2;
  
  public static int a(long paramLong, DisplayMetrics paramDisplayMetrics)
  {
    int j = (int)(paramLong >>> 32);
    int i = (int)paramLong;
    switch (j)
    {
    default: 
      throw new IllegalStateException("Unexpected unit or type: " + j);
    case 0: 
      j = 0;
      break;
    case 1: 
      j = 1;
      break;
    case 2: 
      j = 2;
      break;
    case 3: 
      j = 3;
      break;
    case 4: 
      j = 4;
      break;
    case 5: 
      j = 5;
      i = Math.round(TypedValue.applyDimension(j, Float.intBitsToFloat(i), paramDisplayMetrics));
      break;
    case 128: 
      i = TypedValue.complexToDimensionPixelSize(i, paramDisplayMetrics);
      break;
    }
    i = i;
    return i;
  }
  
  public static long a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unrecognized unit: " + paramInt);
    }
    return l(paramInt, Float.floatToIntBits(paramFloat));
  }
  
  public static long a(TypedValue paramTypedValue)
  {
    long l;
    switch (paramTypedValue.type)
    {
    default: 
      throw new IllegalArgumentException("Unexpected dimension type: " + paramTypedValue.type);
    case 5: 
      l = l(128, paramTypedValue.data);
      break;
    case 16: 
      l = dM(paramTypedValue.data);
    }
    return l;
  }
  
  public static long dM(int paramInt)
  {
    long l;
    if (paramInt >= 0)
    {
      l = a(0, paramInt);
    }
    else
    {
      if ((paramInt != -1) && (paramInt != -2)) {
        throw new IllegalArgumentException("Unexpected dimension value: " + paramInt);
      }
      l = l(129, paramInt);
    }
    return l;
  }
  
  private static long l(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | 0xFFFFFFFF & paramInt2;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.Dimension
 * JD-Core Version:    0.7.0.1
 */