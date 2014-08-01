package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final String TAG = "ArrayMap";
  static Object[] mBaseCache;
  static int mBaseCacheSize;
  static Object[] mTwiceBaseCache;
  static int mTwiceBaseCacheSize;
  Object[] mArray;
  int[] mHashes;
  int mSize;
  
  public SimpleArrayMap()
  {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt)
  {
    if (paramInt != 0)
    {
      allocArrays(paramInt);
    }
    else
    {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    this.mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  /* Error */
  private void allocArrays(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 8
    //   3: if_icmpne +98 -> 101
    //   6: ldc 55
    //   8: monitorenter
    //   9: getstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   12: ifnull +60 -> 72
    //   15: getstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast 58	[Ljava/lang/Object;
    //   30: checkcast 58	[Ljava/lang/Object;
    //   33: putstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   36: aload_0
    //   37: aload_2
    //   38: iconst_1
    //   39: aaload
    //   40: checkcast 59	[I
    //   43: checkcast 59	[I
    //   46: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   49: aload_2
    //   50: iconst_1
    //   51: aconst_null
    //   52: aastore
    //   53: aload_2
    //   54: iconst_0
    //   55: aconst_null
    //   56: aastore
    //   57: bipush 255
    //   59: getstatic 61	android/support/v4/util/SimpleArrayMap:mTwiceBaseCacheSize	I
    //   62: iadd
    //   63: putstatic 61	android/support/v4/util/SimpleArrayMap:mTwiceBaseCacheSize	I
    //   66: ldc 55
    //   68: monitorexit
    //   69: goto +115 -> 184
    //   72: ldc 55
    //   74: monitorexit
    //   75: aload_0
    //   76: iload_1
    //   77: newarray int
    //   79: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   82: aload_0
    //   83: iload_1
    //   84: iconst_1
    //   85: ishl
    //   86: anewarray 5	java/lang/Object
    //   89: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   92: goto +92 -> 184
    //   95: astore_2
    //   96: ldc 55
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: iload_1
    //   102: iconst_4
    //   103: if_icmpne -28 -> 75
    //   106: ldc 55
    //   108: monitorenter
    //   109: getstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   112: ifnull +66 -> 178
    //   115: getstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   118: astore_2
    //   119: aload_0
    //   120: aload_2
    //   121: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   124: aload_2
    //   125: iconst_0
    //   126: aaload
    //   127: checkcast 58	[Ljava/lang/Object;
    //   130: checkcast 58	[Ljava/lang/Object;
    //   133: putstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   136: aload_0
    //   137: aload_2
    //   138: iconst_1
    //   139: aaload
    //   140: checkcast 59	[I
    //   143: checkcast 59	[I
    //   146: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   149: aload_2
    //   150: iconst_1
    //   151: aconst_null
    //   152: aastore
    //   153: aload_2
    //   154: iconst_0
    //   155: aconst_null
    //   156: aastore
    //   157: bipush 255
    //   159: getstatic 65	android/support/v4/util/SimpleArrayMap:mBaseCacheSize	I
    //   162: iadd
    //   163: putstatic 65	android/support/v4/util/SimpleArrayMap:mBaseCacheSize	I
    //   166: ldc 55
    //   168: monitorexit
    //   169: goto +15 -> 184
    //   172: astore_2
    //   173: ldc 55
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: ldc 55
    //   180: monitorexit
    //   181: goto -106 -> 75
    //   184: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	SimpleArrayMap
    //   0	185	1	paramInt	int
    //   18	36	2	arrayOfObject1	Object[]
    //   95	5	2	localObject1	Object
    //   118	36	2	arrayOfObject2	Object[]
    //   172	5	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	75	95	finally
    //   96	99	95	finally
    //   109	176	172	finally
    //   178	181	172	finally
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (int i = -1 + (paramInt << 1); i >= 2; i--) {
            paramArrayOfObject[i] = null;
          }
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize = 1 + mTwiceBaseCacheSize;
        }
        return;
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    } else if (paramArrayOfInt.length == 4) {
      try
      {
        if (mBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (int j = -1 + (paramInt << 1); j >= 2; j--) {
            paramArrayOfObject[j] = null;
          }
          mBaseCache = paramArrayOfObject;
          mBaseCacheSize = 1 + mBaseCacheSize;
        }
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
    }
  }
  
  public void clear()
  {
    if (this.mSize != 0)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != null)
    {
      if (indexOf(paramObject, paramObject.hashCode()) < 0) {
        bool = false;
      }
    }
    else if (indexOfNull() < 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(Object paramObject)
  {
    boolean bool;
    if (indexOfValue(paramObject) < 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (this.mHashes.length < paramInt)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool1;
      if ((paramObject instanceof Map))
      {
        Map localMap = (Map)paramObject;
        if (size() != localMap.size())
        {
          bool1 = false;
        }
        else
        {
          int i = 0;
          try
          {
            while (i < this.mSize)
            {
              Object localObject1 = keyAt(i);
              Object localObject3 = valueAt(i);
              Object localObject2 = localMap.get(localObject1);
              if (localObject3 == null)
              {
                if (localObject2 != null) {
                  break label146;
                }
                if (!localMap.containsKey(localObject1)) {
                  break label146;
                }
              }
              else
              {
                boolean bool2 = localObject3.equals(localObject2);
                if (!bool2)
                {
                  bool1 = false;
                  break;
                }
              }
              i++;
            }
          }
          catch (NullPointerException localNullPointerException)
          {
            bool1 = false;
          }
          catch (ClassCastException localClassCastException)
          {
            bool1 = false;
          }
        }
      }
      else
      {
        bool1 = false;
        continue;
        label146:
        bool1 = false;
      }
    }
  }
  
  public V get(Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = indexOf(paramObject, paramObject.hashCode());
    } else {
      i = indexOfNull();
    }
    Object localObject;
    if (i < 0) {
      localObject = null;
    } else {
      localObject = this.mArray[(1 + (localObject << 1))];
    }
    return localObject;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int n = 0;
    int k = 0;
    int j = 1;
    int m = this.mSize;
    for (;;)
    {
      if (k >= m) {
        return n;
      }
      Object localObject = arrayOfObject[j];
      int i = arrayOfInt[k];
      int i1;
      if (localObject != null) {
        i1 = localObject.hashCode();
      } else {
        i1 = 0;
      }
      n += (i1 ^ i);
      k++;
      j += 2;
    }
  }
  
  int indexOf(Object paramObject, int paramInt)
  {
    int k = this.mSize;
    int j;
    if (k != 0)
    {
      j = ContainerHelpers.binarySearch(this.mHashes, k, paramInt);
      if ((j >= 0) && (!paramObject.equals(this.mArray[(j << 1)])))
      {
        for (int i = j + 1;; i++)
        {
          if ((i >= k) || (this.mHashes[i] != paramInt))
          {
            j -= 1;
            for (;;)
            {
              if ((j < 0) || (this.mHashes[j] != paramInt))
              {
                j = i ^ 0xFFFFFFFF;
                break label156;
              }
              if (paramObject.equals(this.mArray[(j << 1)])) {
                break;
              }
              j--;
            }
            j = j;
            break label156;
          }
          if (paramObject.equals(this.mArray[(i << 1)])) {
            break;
          }
        }
        j = i;
      }
    }
    else
    {
      j = -1;
    }
    label156:
    return j;
  }
  
  int indexOfNull()
  {
    int j = this.mSize;
    int k;
    if (j != 0)
    {
      k = ContainerHelpers.binarySearch(this.mHashes, j, 0);
      if ((k >= 0) && (this.mArray[(k << 1)] != null))
      {
        for (int i = k + 1;; i++)
        {
          if ((i >= j) || (this.mHashes[i] != 0))
          {
            for (j = k - 1;; j--)
            {
              if ((j < 0) || (this.mHashes[j] != 0)) {
                return i ^ 0xFFFFFFFF;
              }
              if (this.mArray[(j << 1)] == null) {
                break;
              }
            }
            return j;
          }
          if (this.mArray[(i << 1)] == null) {
            break;
          }
        }
        k = i;
      }
    }
    else
    {
      k = -1;
    }
    return k;
  }
  
  int indexOfValue(Object paramObject)
  {
    int i = 2 * this.mSize;
    Object[] arrayOfObject = this.mArray;
    if (paramObject != null)
    {
      j = 1;
      while (j < i) {
        if (!paramObject.equals(arrayOfObject[j])) {
          j += 2;
        } else {
          return j >> 1;
        }
      }
    }
    for (int j = 1;; j += 2)
    {
      if (j >= i) {
        return -1;
      }
      if (arrayOfObject[j] == null) {
        break;
      }
    }
    i = j >> 1;
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.mSize > 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public K keyAt(int paramInt)
  {
    return this.mArray[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int j = 8;
    int i;
    int k;
    if (paramK != null)
    {
      i = paramK.hashCode();
      k = indexOf(paramK, i);
    }
    else
    {
      i = 0;
      k = indexOfNull();
    }
    int[] arrayOfInt;
    Object localObject;
    if (k < 0)
    {
      int m = k ^ 0xFFFFFFFF;
      if (this.mSize >= this.mHashes.length)
      {
        if (this.mSize < j)
        {
          if (this.mSize < 4) {
            j = 4;
          }
        }
        else {
          j = this.mSize + (this.mSize >> 1);
        }
        arrayOfInt = this.mHashes;
        Object[] arrayOfObject = this.mArray;
        allocArrays(j);
        if (this.mHashes.length > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
          System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
        }
        freeArrays(arrayOfInt, arrayOfObject, this.mSize);
      }
      if (m < this.mSize)
      {
        System.arraycopy(this.mHashes, m, this.mHashes, m + 1, this.mSize - m);
        System.arraycopy(this.mArray, m << 1, this.mArray, m + 1 << 1, this.mSize - m << 1);
      }
      this.mHashes[m] = i;
      this.mArray[(m << 1)] = paramK;
      this.mArray[(1 + (m << 1))] = paramV;
      this.mSize = (1 + this.mSize);
      localObject = null;
    }
    else
    {
      i = 1 + (arrayOfInt << 1);
      localObject = this.mArray[i];
      this.mArray[i] = paramV;
    }
    return localObject;
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int j = paramSimpleArrayMap.mSize;
    ensureCapacity(j + this.mSize);
    if (this.mSize != 0) {
      for (int i = 0; i < j; i++) {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
      }
    }
    if (j > 0)
    {
      System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, j);
      System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, j << 1);
      this.mSize = j;
    }
  }
  
  public V remove(Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = indexOf(paramObject, paramObject.hashCode());
    } else {
      i = indexOfNull();
    }
    Object localObject;
    if (i < 0) {
      localObject = null;
    } else {
      localObject = removeAt(localObject);
    }
    return localObject;
  }
  
  public V removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.mArray[(1 + (paramInt << 1))];
    if (this.mSize > 1)
    {
      if ((this.mHashes.length <= i) || (this.mSize >= this.mHashes.length / 3))
      {
        this.mSize = (-1 + this.mSize);
        if (paramInt < this.mSize)
        {
          System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
          System.arraycopy(this.mArray, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
        }
        this.mArray[(this.mSize << 1)] = null;
        this.mArray[(1 + (this.mSize << 1))] = null;
      }
      else
      {
        if (this.mSize > i) {
          i = this.mSize + (this.mSize >> 1);
        }
        int[] arrayOfInt = this.mHashes;
        Object[] arrayOfObject = this.mArray;
        allocArrays(i);
        this.mSize = (-1 + this.mSize);
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt << 1);
        }
        if (paramInt < this.mSize)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
        }
      }
    }
    else
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
    return localObject;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    int i = 1 + (paramInt << 1);
    Object localObject = this.mArray[i];
    this.mArray[i] = paramV;
    return localObject;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    if (!isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder(28 * this.mSize);
      localStringBuilder.append('{');
      for (int i = 0;; str++)
      {
        if (i >= this.mSize)
        {
          localStringBuilder.append('}');
          str = localStringBuilder.toString();
          break;
        }
        if (str > 0) {
          localStringBuilder.append(", ");
        }
        Object localObject = keyAt(str);
        if (localObject == this) {
          localStringBuilder.append("(this Map)");
        } else {
          localStringBuilder.append(localObject);
        }
        localStringBuilder.append('=');
        localObject = valueAt(str);
        if (localObject == this) {
          localStringBuilder.append("(this Map)");
        } else {
          localStringBuilder.append(localObject);
        }
      }
    }
    String str = "{}";
    return str;
  }
  
  public V valueAt(int paramInt)
  {
    return this.mArray[(1 + (paramInt << 1))];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.SimpleArrayMap
 * JD-Core Version:    0.7.0.1
 */