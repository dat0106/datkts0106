package android.support.v4.util;

class ContainerHelpers
{
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 0;
    int m = paramInt1 - 1;
    for (;;)
    {
      int i;
      if (j > m)
      {
        i = j ^ 0xFFFFFFFF;
      }
      else
      {
        i = j + m >>> 1;
        int k = paramArrayOfInt[i];
        if (k < paramInt2) {
          break label59;
        }
        if (k > paramInt2) {
          break label51;
        }
      }
      return i;
      label51:
      m = i - 1;
      continue;
      label59:
      j = i + 1;
    }
  }
  
  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int j = 0;
    int i = paramInt - 1;
    for (;;)
    {
      int k;
      if (j > i)
      {
        k = j ^ 0xFFFFFFFF;
      }
      else
      {
        k = j + i >>> 1;
        long l = paramArrayOfLong[k];
        if (l < paramLong) {
          break label66;
        }
        if (l > paramLong) {
          break label57;
        }
      }
      return k;
      label57:
      i = k - 1;
      continue;
      label66:
      j = k + 1;
    }
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (i < 32) {
      if (paramInt > -12 + (1 << i)) {
        i++;
      } else {
        paramInt = -12 + (1 << i);
      }
    }
    return paramInt;
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.ContainerHelpers
 * JD-Core Version:    0.7.0.1
 */