package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.e;

public final class bq
  implements br.a
{
  private final bu kz;
  private final aj lf;
  private final Object lq = new Object();
  private final Context mContext;
  private final String nA;
  private final long nB;
  private final bm nC;
  private final am nD;
  private final ew nE;
  private bv nF;
  private int nG = -2;
  
  public bq(Context paramContext, String paramString, bu parambu, bn parambn, bm parambm, aj paramaj, am paramam, ew paramew)
  {
    this.mContext = paramContext;
    if (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {
      this.nA = paramString;
    } else {
      this.nA = b(parambm);
    }
    this.kz = parambu;
    long l;
    if (parambn.nq == -1L) {
      l = 10000L;
    } else {
      l = parambn.nq;
    }
    this.nB = l;
    this.nC = parambm;
    this.lf = paramaj;
    this.nD = paramam;
    this.nE = paramew;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    while (this.nG == -2) {
      b(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void a(bp parambp)
  {
    try
    {
      if (this.nE.sv < 4100000) {
        if (this.nD.md) {
          this.nF.a(e.h(this.mContext), this.lf, this.nC.no, parambp);
        } else {
          this.nF.a(e.h(this.mContext), this.nD, this.lf, this.nC.no, parambp);
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not request ad from mediation adapter.", localRemoteException);
      g(5);
    }
    if (this.nD.md) {
      this.nF.a(e.h(this.mContext), this.lf, this.nC.no, this.nC.ni, parambp);
    } else {
      this.nF.a(e.h(this.mContext), this.nD, this.lf, this.nC.no, this.nC.ni, parambp);
    }
  }
  
  private bv aK()
  {
    ev.B("Instantiating mediation adapter: " + this.nA);
    try
    {
      localbv = this.kz.m(this.nA);
      localbv = localbv;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        bv localbv;
        ev.a("Could not instantiate mediation adapter: " + this.nA, localRemoteException);
        Object localObject = null;
      }
    }
    return localbv;
  }
  
  private String b(bm parambm)
  {
    try
    {
      if ((!TextUtils.isEmpty(parambm.nm)) && (CustomEvent.class.isAssignableFrom(Class.forName(parambm.nm, false, bq.class.getClassLoader()))))
      {
        str = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        return str;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ev.D("Could not create custom event adapter.");
        String str = "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = paramLong2 - (l2 - paramLong1);
    l2 = paramLong4 - (l2 - paramLong3);
    if ((l1 <= 0L) || (l2 <= 0L))
    {
      ev.B("Timed out waiting for adapter.");
      this.nG = 3;
    }
    for (;;)
    {
      return;
      try
      {
        this.lq.wait(Math.min(l1, l2));
      }
      catch (InterruptedException localInterruptedException)
      {
        this.nG = -1;
      }
    }
  }
  
  public br b(long paramLong1, long paramLong2)
  {
    synchronized (this.lq)
    {
      long l = SystemClock.elapsedRealtime();
      final bp localbp = new bp();
      eu.ss.post(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   4: invokestatic 29	com/google/android/gms/internal/bq:a	(Lcom/google/android/gms/internal/bq;)Ljava/lang/Object;
          //   7: astore_2
          //   8: aload_2
          //   9: monitorenter
          //   10: aload_0
          //   11: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   14: invokestatic 32	com/google/android/gms/internal/bq:b	(Lcom/google/android/gms/internal/bq;)I
          //   17: bipush 254
          //   19: if_icmpeq +8 -> 27
          //   22: aload_2
          //   23: monitorexit
          //   24: goto +70 -> 94
          //   27: aload_0
          //   28: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   31: aload_0
          //   32: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   35: invokestatic 36	com/google/android/gms/internal/bq:c	(Lcom/google/android/gms/internal/bq;)Lcom/google/android/gms/internal/bv;
          //   38: invokestatic 39	com/google/android/gms/internal/bq:a	(Lcom/google/android/gms/internal/bq;Lcom/google/android/gms/internal/bv;)Lcom/google/android/gms/internal/bv;
          //   41: pop
          //   42: aload_0
          //   43: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   46: invokestatic 42	com/google/android/gms/internal/bq:d	(Lcom/google/android/gms/internal/bq;)Lcom/google/android/gms/internal/bv;
          //   49: ifnonnull +21 -> 70
          //   52: aload_0
          //   53: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   56: iconst_4
          //   57: invokevirtual 46	com/google/android/gms/internal/bq:g	(I)V
          //   60: aload_2
          //   61: monitorexit
          //   62: goto +32 -> 94
          //   65: astore_1
          //   66: aload_2
          //   67: monitorexit
          //   68: aload_1
          //   69: athrow
          //   70: aload_0
          //   71: getfield 21	com/google/android/gms/internal/bq$1:nH	Lcom/google/android/gms/internal/bp;
          //   74: aload_0
          //   75: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   78: invokevirtual 51	com/google/android/gms/internal/bp:a	(Lcom/google/android/gms/internal/br$a;)V
          //   81: aload_0
          //   82: getfield 19	com/google/android/gms/internal/bq$1:nI	Lcom/google/android/gms/internal/bq;
          //   85: aload_0
          //   86: getfield 21	com/google/android/gms/internal/bq$1:nH	Lcom/google/android/gms/internal/bp;
          //   89: invokestatic 53	com/google/android/gms/internal/bq:a	(Lcom/google/android/gms/internal/bq;Lcom/google/android/gms/internal/bp;)V
          //   92: aload_2
          //   93: monitorexit
          //   94: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	95	0	this	1
          //   65	4	1	localObject1	Object
          //   7	86	2	localObject2	Object
          // Exception table:
          //   from	to	target	type
          //   10	68	65	finally
          //   70	94	65	finally
        }
      });
      a(l, this.nB, paramLong1, paramLong2);
      br localbr = new br(this.nC, this.nF, this.nA, localbp, this.nG);
      return localbr;
    }
  }
  
  public void cancel()
  {
    synchronized (this.lq)
    {
      try
      {
        if (this.nF != null) {
          this.nF.destroy();
        }
        this.nG = -1;
        this.lq.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ev.c("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public void g(int paramInt)
  {
    synchronized (this.lq)
    {
      this.nG = paramInt;
      this.lq.notify();
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bq
 * JD-Core Version:    0.7.0.1
 */