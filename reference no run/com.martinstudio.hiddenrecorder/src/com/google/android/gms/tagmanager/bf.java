package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ik;

class bf
  implements cf
{
  private final ik aec;
  private final long agc;
  private final long wB;
  private final int wC;
  private double wD;
  private long wE;
  private final Object wF = new Object();
  private final String wG;
  
  public bf(int paramInt, long paramLong1, long paramLong2, String paramString, ik paramik)
  {
    this.wC = paramInt;
    this.wD = this.wC;
    this.wB = paramLong1;
    this.agc = paramLong2;
    this.wG = paramString;
    this.aec = paramik;
  }
  
  /* Error */
  public boolean dj()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 27	com/google/android/gms/tagmanager/bf:wF	Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 39	com/google/android/gms/tagmanager/bf:aec	Lcom/google/android/gms/internal/ik;
    //   14: invokeinterface 47 1 0
    //   19: lstore_2
    //   20: lload_2
    //   21: aload_0
    //   22: getfield 49	com/google/android/gms/tagmanager/bf:wE	J
    //   25: lsub
    //   26: aload_0
    //   27: getfield 35	com/google/android/gms/tagmanager/bf:agc	J
    //   30: lcmp
    //   31: ifge +38 -> 69
    //   34: new 51	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   41: ldc 54
    //   43: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 37	com/google/android/gms/tagmanager/bf:wG	Ljava/lang/String;
    //   50: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 60
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: monitorexit
    //   66: goto +132 -> 198
    //   69: aload_0
    //   70: getfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   73: aload_0
    //   74: getfield 29	com/google/android/gms/tagmanager/bf:wC	I
    //   77: i2d
    //   78: dcmpg
    //   79: ifge +46 -> 125
    //   82: lload_2
    //   83: aload_0
    //   84: getfield 49	com/google/android/gms/tagmanager/bf:wE	J
    //   87: lsub
    //   88: l2d
    //   89: aload_0
    //   90: getfield 33	com/google/android/gms/tagmanager/bf:wB	J
    //   93: l2d
    //   94: ddiv
    //   95: dstore 4
    //   97: dload 4
    //   99: ldc2_w 70
    //   102: dcmpl
    //   103: ifle +22 -> 125
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 29	com/google/android/gms/tagmanager/bf:wC	I
    //   111: i2d
    //   112: dload 4
    //   114: aload_0
    //   115: getfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   118: dadd
    //   119: invokestatic 77	java/lang/Math:min	(DD)D
    //   122: putfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   125: aload_0
    //   126: lload_2
    //   127: putfield 49	com/google/android/gms/tagmanager/bf:wE	J
    //   130: aload_0
    //   131: getfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   134: ldc2_w 78
    //   137: dcmpl
    //   138: iflt +28 -> 166
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   146: ldc2_w 78
    //   149: dsub
    //   150: putfield 31	com/google/android/gms/tagmanager/bf:wD	D
    //   153: iconst_1
    //   154: istore 6
    //   156: aload_1
    //   157: monitorexit
    //   158: goto +40 -> 198
    //   161: astore_2
    //   162: aload_1
    //   163: monitorexit
    //   164: aload_2
    //   165: athrow
    //   166: new 51	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   173: ldc 54
    //   175: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: getfield 37	com/google/android/gms/tagmanager/bf:wG	Ljava/lang/String;
    //   182: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 60
    //   187: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   196: aload_1
    //   197: monitorexit
    //   198: iload 6
    //   200: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	bf
    //   7	190	1	localObject1	Object
    //   19	108	2	l	long
    //   161	4	2	localObject2	Object
    //   95	18	4	d	double
    //   1	198	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	164	161	finally
    //   166	198	161	finally
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bf
 * JD-Core Version:    0.7.0.1
 */