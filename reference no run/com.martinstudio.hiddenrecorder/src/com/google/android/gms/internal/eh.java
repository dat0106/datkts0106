package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.LinkedList;

public class eh
{
  private final Object lq = new Object();
  private boolean qL = false;
  private final ei rA;
  private final LinkedList<a> rB;
  private final String rC;
  private final String rD;
  private long rE = -1L;
  private long rF = -1L;
  private long rG = -1L;
  private long rH = 0L;
  private long rI = -1L;
  private long rJ = -1L;
  
  public eh(ei paramei, String paramString1, String paramString2)
  {
    this.rA = paramei;
    this.rC = paramString1;
    this.rD = paramString2;
    this.rB = new LinkedList();
  }
  
  public eh(String paramString1, String paramString2)
  {
    this(ei.bC(), paramString1, paramString2);
  }
  
  public void bw()
  {
    synchronized (this.lq)
    {
      if ((this.rJ != -1L) && (this.rF == -1L))
      {
        this.rF = SystemClock.elapsedRealtime();
        this.rA.a(this);
      }
      ei.bF().bw();
      return;
    }
  }
  
  public void bx()
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        a locala = new a();
        locala.bB();
        this.rB.add(locala);
        this.rH = (1L + this.rH);
        ei.bF().bx();
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void by()
  {
    synchronized (this.lq)
    {
      if ((this.rJ != -1L) && (!this.rB.isEmpty()))
      {
        a locala = (a)this.rB.getLast();
        if (locala.bz() == -1L)
        {
          locala.bA();
          this.rA.a(this);
        }
      }
      return;
    }
  }
  
  public void f(aj paramaj)
  {
    synchronized (this.lq)
    {
      this.rI = SystemClock.elapsedRealtime();
      ei.bF().b(paramaj, this.rI);
      return;
    }
  }
  
  public void j(long paramLong)
  {
    synchronized (this.lq)
    {
      this.rJ = paramLong;
      if (this.rJ != -1L) {
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void k(long paramLong)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.rE = paramLong;
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void n(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.rG = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.rF = this.rG;
          this.rA.a(this);
        }
      }
      return;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.qL = paramBoolean;
        this.rA.a(this);
      }
      return;
    }
  }
  
  /* Error */
  public Bundle toBundle()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/google/android/gms/internal/eh:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: new 133	android/os/Bundle
    //   10: dup
    //   11: invokespecial 134	android/os/Bundle:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: ldc 136
    //   20: aload_0
    //   21: getfield 55	com/google/android/gms/internal/eh:rC	Ljava/lang/String;
    //   24: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload 4
    //   29: ldc 141
    //   31: aload_0
    //   32: getfield 57	com/google/android/gms/internal/eh:rD	Ljava/lang/String;
    //   35: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload 4
    //   40: ldc 143
    //   42: aload_0
    //   43: getfield 41	com/google/android/gms/internal/eh:qL	Z
    //   46: invokevirtual 147	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   49: aload 4
    //   51: ldc 149
    //   53: aload_0
    //   54: getfield 49	com/google/android/gms/internal/eh:rI	J
    //   57: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   60: aload 4
    //   62: ldc 155
    //   64: aload_0
    //   65: getfield 51	com/google/android/gms/internal/eh:rJ	J
    //   68: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   71: aload 4
    //   73: ldc 157
    //   75: aload_0
    //   76: getfield 39	com/google/android/gms/internal/eh:rF	J
    //   79: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   82: aload 4
    //   84: ldc 159
    //   86: aload_0
    //   87: getfield 43	com/google/android/gms/internal/eh:rG	J
    //   90: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   93: aload 4
    //   95: ldc 161
    //   97: aload_0
    //   98: getfield 47	com/google/android/gms/internal/eh:rH	J
    //   101: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   104: aload 4
    //   106: ldc 163
    //   108: aload_0
    //   109: getfield 37	com/google/android/gms/internal/eh:rE	J
    //   112: invokevirtual 153	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   115: new 165	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 166	java/util/ArrayList:<init>	()V
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 62	com/google/android/gms/internal/eh:rB	Ljava/util/LinkedList;
    //   127: invokevirtual 170	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   130: astore_2
    //   131: aload_2
    //   132: invokeinterface 175 1 0
    //   137: ifeq +28 -> 165
    //   140: aload_3
    //   141: aload_2
    //   142: invokeinterface 178 1 0
    //   147: checkcast 6	com/google/android/gms/internal/eh$a
    //   150: invokevirtual 180	com/google/android/gms/internal/eh$a:toBundle	()Landroid/os/Bundle;
    //   153: invokevirtual 181	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: goto -26 -> 131
    //   160: astore_2
    //   161: aload_1
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    //   165: aload 4
    //   167: ldc 183
    //   169: aload_3
    //   170: invokevirtual 187	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   173: aload_1
    //   174: monitorexit
    //   175: aload 4
    //   177: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	eh
    //   4	170	1	localObject1	Object
    //   130	12	2	localIterator	java.util.Iterator
    //   160	4	2	localObject2	Object
    //   122	48	3	localArrayList	java.util.ArrayList
    //   14	162	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   7	163	160	finally
    //   165	175	160	finally
  }
  
  private static final class a
  {
    private long rK = -1L;
    private long rL = -1L;
    
    public void bA()
    {
      this.rL = SystemClock.elapsedRealtime();
    }
    
    public void bB()
    {
      this.rK = SystemClock.elapsedRealtime();
    }
    
    public long bz()
    {
      return this.rL;
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.rK);
      localBundle.putLong("tclose", this.rL);
      return localBundle;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eh
 * JD-Core Version:    0.7.0.1
 */