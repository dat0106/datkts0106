package com.google.android.gms.internal;

import java.util.Arrays;

public final class md
{
  public static final Object amX = new Object();
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    boolean bool;
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.length != 0)) {
      bool = Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
    } else if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat2.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool;
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt1.length != 0)) {
      bool = Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    } else if ((paramArrayOfInt2 != null) && (paramArrayOfInt2.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    boolean bool;
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
      bool = Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    } else if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool = false;
    int i;
    if (paramArrayOfObject1 != null) {
      i = paramArrayOfObject1.length;
    } else {
      i = 0;
    }
    int j;
    if (paramArrayOfObject2 != null) {
      j = paramArrayOfObject2.length;
    } else {
      j = 0;
    }
    int k = 0;
    int m = 0;
    for (;;)
    {
      if ((m >= i) || (paramArrayOfObject1[m] != null)) {
        for (k = k;; k++) {
          if ((k >= j) || (paramArrayOfObject2[k] != null))
          {
            int n;
            if (m < i) {
              n = 0;
            } else {
              n = 1;
            }
            int i1;
            if (k < j) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            if ((n == 0) || (i1 == 0))
            {
              if ((n != i1) || (!paramArrayOfObject1[m].equals(paramArrayOfObject2[k]))) {
                break label148;
              }
              m += 1;
              k += 1;
              m = m;
              break;
            }
            bool = true;
            label148:
            return bool;
          }
        }
      }
      m++;
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    int i;
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0)) {
      i = Arrays.hashCode(paramArrayOfFloat);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0)) {
      i = Arrays.hashCode(paramArrayOfInt);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    int i;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
      i = Arrays.hashCode(paramArrayOfLong);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int j = 0;
    int k;
    if (paramArrayOfObject != null) {
      k = paramArrayOfObject.length;
    } else {
      k = 0;
    }
    for (int i = 0;; i++)
    {
      if (i >= k) {
        return j;
      }
      Object localObject = paramArrayOfObject[i];
      if (localObject != null) {
        j = j * 31 + localObject.hashCode();
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.md
 * JD-Core Version:    0.7.0.1
 */