package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
  }
  
  /* Error */
  private void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	android/support/v4/util/LruCache:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 31	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 71	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 67	android/support/v4/util/LruCache:size	I
    //   23: ifeq +41 -> 64
    //   26: new 45	java/lang/IllegalStateException
    //   29: dup
    //   30: new 47	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 80	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 82
    //   49: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 64	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 67	android/support/v4/util/LruCache:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 31	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 71	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 31	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 86	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 92 1 0
    //   97: invokeinterface 98 1 0
    //   102: checkcast 100	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 103 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 106 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 31	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 110	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 67	android/support/v4/util/LruCache:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 112	android/support/v4/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 67	android/support/v4/util/LruCache:size	I
    //   144: aload_0
    //   145: iconst_1
    //   146: aload_0
    //   147: getfield 114	android/support/v4/util/LruCache:evictionCount	I
    //   150: iadd
    //   151: putfield 114	android/support/v4/util/LruCache:evictionCount	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 118	android/support/v4/util/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	LruCache
    //   0	167	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	47	2	localObject2	Object
    //   105	55	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	62	59	finally
    //   64	156	59	finally
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  /**
   * @deprecated
   */
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  /**
   * @deprecated
   */
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject5;
    try
    {
      Object localObject1 = this.map.get(paramK);
      if (localObject1 != null)
      {
        this.hitCount = (1 + this.hitCount);
        localObject5 = localObject1;
      }
      else
      {
        this.missCount = (1 + this.missCount);
        localObject5 = create(paramK);
        if (localObject5 == null) {
          localObject5 = null;
        }
      }
    }
    finally {}
    try
    {
      this.createCount = (1 + this.createCount);
      Object localObject3 = this.map.put(paramK, localObject5);
      if (localObject3 != null) {
        this.map.put(paramK, localObject3);
      }
      for (;;)
      {
        if (localObject3 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject5, localObject3);
        return localObject3;
        this.size += safeSizeOf(paramK, localObject5);
      }
      trimToSize(this.maxSize);
    }
    finally {}
    return localObject5;
  }
  
  /**
   * @deprecated
   */
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.putCount = (1 + this.putCount);
      this.size += safeSizeOf(paramK, paramV);
      Object localObject1 = this.map.put(paramK, paramV);
      if (localObject1 != null) {
        this.size -= safeSizeOf(paramK, localObject1);
      }
      if (localObject1 != null) {
        entryRemoved(false, paramK, localObject1, paramV);
      }
      trimToSize(this.maxSize);
      return localObject1;
    }
    finally {}
  }
  
  /**
   * @deprecated
   */
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject1 = this.map.remove(paramK);
      if (localObject1 != null) {
        this.size -= safeSizeOf(paramK, localObject1);
      }
      if (localObject1 != null) {
        entryRemoved(false, paramK, localObject1, null);
      }
      return localObject1;
    }
    finally {}
  }
  
  /**
   * @deprecated
   */
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  /**
   * @deprecated
   */
  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = 100 * this.hitCount / j;
      }
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.maxSize);
      arrayOfObject[1] = Integer.valueOf(this.hitCount);
      arrayOfObject[2] = Integer.valueOf(this.missCount);
      arrayOfObject[3] = Integer.valueOf(i);
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arrayOfObject);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.LruCache
 * JD-Core Version:    0.7.0.1
 */