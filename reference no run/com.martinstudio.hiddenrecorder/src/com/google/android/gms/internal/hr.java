package com.google.android.gms.internal;

import java.util.LinkedHashMap;

public class hr<K, V>
{
  private final LinkedHashMap<K, V> GJ;
  private int GK;
  private int GL;
  private int GM;
  private int GN;
  private int GO;
  private int GP;
  private int size;
  
  public hr(int paramInt)
  {
    if (paramInt > 0)
    {
      this.GK = paramInt;
      this.GJ = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int c(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject6;
    try
    {
      Object localObject1 = this.GJ.get(paramK);
      if (localObject1 != null)
      {
        this.GO = (1 + this.GO);
      }
      else
      {
        this.GP = (1 + this.GP);
        localObject6 = create(paramK);
        if (localObject6 == null) {
          localObject1 = null;
        }
      }
    }
    finally {}
    try
    {
      this.GM = (1 + this.GM);
      Object localObject3 = this.GJ.put(paramK, localObject6);
      if (localObject3 != null) {
        this.GJ.put(paramK, localObject3);
      }
      for (;;)
      {
        if (localObject3 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject6, localObject3);
        return ???;
        this.size += c(paramK, localObject6);
      }
      trimToSize(this.GK);
    }
    finally {}
    Object localObject5 = localObject6;
    return localObject5;
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.GL = (1 + this.GL);
      this.size += c(paramK, paramV);
      Object localObject1 = this.GJ.put(paramK, paramV);
      if (localObject1 != null) {
        this.size -= c(paramK, localObject1);
      }
      if (localObject1 != null) {
        entryRemoved(false, paramK, localObject1, paramV);
      }
      trimToSize(this.GK);
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
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.GO + this.GP;
      if (j != 0) {
        i = 100 * this.GO / j;
      }
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.GK);
      arrayOfObject[1] = Integer.valueOf(this.GO);
      arrayOfObject[2] = Integer.valueOf(this.GP);
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
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 96	com/google/android/gms/internal/hr:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 31	com/google/android/gms/internal/hr:GJ	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 121	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 96	com/google/android/gms/internal/hr:size	I
    //   23: ifeq +41 -> 64
    //   26: new 45	java/lang/IllegalStateException
    //   29: dup
    //   30: new 47	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 130	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 132
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
    //   65: getfield 96	com/google/android/gms/internal/hr:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 31	com/google/android/gms/internal/hr:GJ	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 121	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 31	com/google/android/gms/internal/hr:GJ	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 136	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 142 1 0
    //   97: invokeinterface 148 1 0
    //   102: checkcast 150	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 153 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 156 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 31	com/google/android/gms/internal/hr:GJ	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 159	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 96	com/google/android/gms/internal/hr:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 98	com/google/android/gms/internal/hr:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 96	com/google/android/gms/internal/hr:size	I
    //   144: aload_0
    //   145: iconst_1
    //   146: aload_0
    //   147: getfield 161	com/google/android/gms/internal/hr:GN	I
    //   150: iadd
    //   151: putfield 161	com/google/android/gms/internal/hr:GN	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 94	com/google/android/gms/internal/hr:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	hr
    //   0	167	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	47	2	localObject2	Object
    //   105	55	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	62	59	finally
    //   64	156	59	finally
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hr
 * JD-Core Version:    0.7.0.1
 */