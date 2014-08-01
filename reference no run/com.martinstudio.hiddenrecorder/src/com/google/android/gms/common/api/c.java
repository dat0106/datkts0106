package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hd.b;
import com.google.android.gms.internal.hn;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
  implements GoogleApiClient
{
  private final Looper DC;
  private final Lock DN = new ReentrantLock();
  private final Condition DO = this.DN.newCondition();
  private final hd DP = new hd(paramContext, paramLooper, this.Eg);
  private final Fragment DQ;
  final Queue<c<?>> DR = new LinkedList();
  private ConnectionResult DS;
  private int DT;
  private int DU = 4;
  private int DV = 0;
  private boolean DW = false;
  private int DX;
  private long DY = 5000L;
  final Handler DZ;
  private final a Dv = new a()
  {
    public void b(c.c<?> paramAnonymousc)
    {
      c.this.Ee.remove(paramAnonymousc);
    }
  };
  private final Bundle Ea = new Bundle();
  private final Map<Api.c<?>, Api.a> Eb = new HashMap();
  private final List<String> Ec;
  private boolean Ed;
  final Set<c<?>> Ee = Collections.newSetFromMap(new ConcurrentHashMap());
  final GoogleApiClient.ConnectionCallbacks Ef = new GoogleApiClient.ConnectionCallbacks()
  {
    public void onConnected(Bundle paramAnonymousBundle)
    {
      c.a(c.this).lock();
      try
      {
        if (c.b(c.this) == 1)
        {
          if (paramAnonymousBundle != null) {
            c.c(c.this).putAll(paramAnonymousBundle);
          }
          c.d(c.this);
        }
        return;
      }
      finally
      {
        c.a(c.this).unlock();
      }
    }
    
    public void onConnectionSuspended(int paramAnonymousInt)
    {
      c.a(c.this).lock();
      for (;;)
      {
        try
        {
          c.a(c.this, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          default: 
            return;
          }
        }
        finally
        {
          c.a(c.this).unlock();
        }
        c.this.connect();
        continue;
        boolean bool = c.e(c.this);
        if (bool)
        {
          c.a(c.this).unlock();
        }
        else
        {
          c.b(c.this, 2);
          c.this.DZ.sendMessageDelayed(c.this.DZ.obtainMessage(1), c.f(c.this));
        }
      }
    }
  };
  private final hd.b Eg = new hd.b()
  {
    public boolean eJ()
    {
      return c.g(c.this);
    }
    
    public Bundle ea()
    {
      return null;
    }
    
    public boolean isConnected()
    {
      return c.this.isConnected();
    }
  };
  
  public c(Context paramContext, Looper paramLooper, gz paramgz, Map<Api<?>, Api.ApiOptions> paramMap, Fragment paramFragment, Set<GoogleApiClient.ConnectionCallbacks> paramSet, Set<GoogleApiClient.OnConnectionFailedListener> paramSet1)
  {
    this.DQ = paramFragment;
    this.DC = paramLooper;
    this.DZ = new b(paramLooper);
    Object localObject1 = paramSet.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        localObject2 = paramSet1.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext())
          {
            localObject2 = paramMap.keySet().iterator();
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext())
              {
                this.Ec = Collections.unmodifiableList(paramgz.fg());
                return;
              }
              Api localApi = (Api)((Iterator)localObject2).next();
              localObject1 = localApi.eu();
              Object localObject3 = paramMap.get(localApi);
              this.Eb.put(localApi.ew(), a((Api.b)localObject1, localObject3, paramContext, paramLooper, paramgz, this.Ef, new GoogleApiClient.OnConnectionFailedListener()
              {
                public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
                {
                  c.a(c.this).lock();
                  try
                  {
                    if ((c.h(c.this) == null) || (this.Ei.getPriority() < c.i(c.this)))
                    {
                      c.a(c.this, paramAnonymousConnectionResult);
                      c.c(c.this, this.Ei.getPriority());
                    }
                    c.d(c.this);
                    return;
                  }
                  finally
                  {
                    c.a(c.this).unlock();
                  }
                }
              }));
            }
          }
          localObject1 = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          this.DP.registerConnectionFailedListener((GooglePlayServicesClient.OnConnectionFailedListener)localObject1);
        }
      }
      Object localObject2 = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject1).next();
      this.DP.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject2);
    }
  }
  
  private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, gz paramgz, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramb.a(paramContext, paramLooper, paramgz, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private <A extends Api.a> void a(c<A> paramc)
    throws DeadObjectException
  {
    boolean bool1 = true;
    this.DN.lock();
    label152:
    for (;;)
    {
      try
      {
        if (!isConnected())
        {
          if (eH())
          {
            break label152;
            hn.a(bool2, "GoogleApiClient is not connected yet.");
            if (paramc.ew() != null)
            {
              hn.b(bool1, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
              this.Ee.add(paramc);
              paramc.a(this.Dv);
              if (!eH()) {
                continue;
              }
              paramc.m(new Status(8));
            }
          }
          else
          {
            bool2 = false;
            continue;
          }
          bool1 = false;
          continue;
          paramc.b(a(paramc.ew()));
          this.DN.unlock();
          continue;
        }
        boolean bool2 = localObject;
      }
      finally
      {
        this.DN.unlock();
      }
    }
  }
  
  private void aa(int paramInt)
  {
    this.DN.lock();
    try
    {
      if (this.DU == 3) {
        break label316;
      }
      if (paramInt != -1) {
        break label184;
      }
      if (isConnecting())
      {
        Iterator localIterator2 = this.DR.iterator();
        while (localIterator2.hasNext())
        {
          c localc = (c)localIterator2.next();
          if (localc.eB() != 1)
          {
            localc.cancel();
            localIterator2.remove();
          }
        }
      }
      this.DR.clear();
    }
    finally
    {
      this.DN.unlock();
    }
    Iterator localIterator1 = this.Ee.iterator();
    while (localIterator1.hasNext()) {
      ((c)localIterator1.next()).cancel();
    }
    this.Ee.clear();
    if ((this.DS == null) && (!this.DR.isEmpty()))
    {
      this.DW = true;
      this.DN.unlock();
    }
    for (;;)
    {
      return;
      label184:
      boolean bool2 = isConnecting();
      boolean bool1 = isConnected();
      this.DU = 3;
      if (bool2)
      {
        if (paramInt == -1) {
          this.DS = null;
        }
        this.DO.signalAll();
      }
      this.Ed = false;
      Iterator localIterator3 = this.Eb.values().iterator();
      while (localIterator3.hasNext())
      {
        Api.a locala = (Api.a)localIterator3.next();
        if (locala.isConnected()) {
          locala.disconnect();
        }
      }
      this.Ed = true;
      this.DU = 4;
      if (bool1)
      {
        if (paramInt != -1) {
          this.DP.ao(paramInt);
        }
        this.Ed = false;
      }
      label316:
      this.DN.unlock();
    }
  }
  
  private void eF()
  {
    this.DN.lock();
    for (;;)
    {
      try
      {
        this.DX = (-1 + this.DX);
        if (this.DX == 0)
        {
          if (this.DS == null) {
            break label130;
          }
          this.DW = false;
          aa(3);
          if (eH()) {
            this.DV = (-1 + this.DV);
          }
          if (eH())
          {
            this.DZ.sendMessageDelayed(this.DZ.obtainMessage(1), this.DY);
            this.Ed = false;
          }
        }
        else
        {
          return;
        }
        this.DP.a(this.DS);
        continue;
        this.DU = 2;
      }
      finally
      {
        this.DN.unlock();
      }
      label130:
      eI();
      this.DO.signalAll();
      eG();
      if (!this.DW) {
        break;
      }
      this.DW = false;
      aa(-1);
    }
    if (this.Ea.isEmpty()) {}
    for (Bundle localBundle = null;; localBundle = this.Ea)
    {
      this.DP.c(localBundle);
      break;
    }
  }
  
  private void eG()
  {
    boolean bool;
    if ((isConnected()) || (eH())) {
      bool = true;
    }
    for (;;)
    {
      hn.a(bool, "GoogleApiClient is not connected yet.");
      this.DN.lock();
      try
      {
        for (;;)
        {
          bool = this.DR.isEmpty();
          if (bool) {
            break;
          }
          try
          {
            a((c)this.DR.remove());
          }
          catch (DeadObjectException localDeadObjectException)
          {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
          }
        }
        int i = 0;
      }
      finally
      {
        this.DN.unlock();
      }
    }
    this.DN.unlock();
  }
  
  /* Error */
  private boolean eH()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 233 1 0
    //   9: aload_0
    //   10: getfield 94	com/google/android/gms/common/api/c:DV	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +16 -> 31
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 270 1 0
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 270 1 0
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	c
    //   13	17	1	i	int
    //   32	1	1	j	int
    //   36	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	36	finally
  }
  
  private void eI()
  {
    this.DN.lock();
    try
    {
      this.DV = 0;
      this.DZ.removeMessages(1);
      return;
    }
    finally
    {
      this.DN.unlock();
    }
  }
  
  public <C extends Api.a> C a(Api.c<C> paramc)
  {
    Api.a locala = (Api.a)this.Eb.get(paramc);
    hn.b(locala, "Appropriate Api was not requested.");
    return locala;
  }
  
  /* Error */
  public <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 233 1 0
    //   9: aload_0
    //   10: invokevirtual 236	com/google/android/gms/common/api/c:isConnected	()Z
    //   13: ifeq +20 -> 33
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 392	com/google/android/gms/common/api/c:b	(Lcom/google/android/gms/common/api/a$b;)Lcom/google/android/gms/common/api/a$b;
    //   21: pop
    //   22: aload_0
    //   23: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 270 1 0
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: getfield 90	com/google/android/gms/common/api/c:DR	Ljava/util/Queue;
    //   37: aload_1
    //   38: invokeinterface 393 2 0
    //   43: pop
    //   44: goto -22 -> 22
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 270 1 0
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   0	59	1	paramT	T
    //   47	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	47	finally
    //   33	44	47	finally
  }
  
  public <A extends Api.a, T extends a.b<? extends Result, A>> T b(T paramT)
  {
    boolean bool;
    if ((isConnected()) || (eH())) {
      bool = true;
    }
    for (;;)
    {
      hn.a(bool, "GoogleApiClient is not connected yet.");
      eG();
      try
      {
        a(paramT);
        return paramT;
        bool = false;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;)
        {
          aa(1);
        }
      }
    }
  }
  
  /* Error */
  public ConnectionResult blockingConnect()
  {
    // Byte code:
    //   0: invokestatic 403	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 406	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +75 -> 81
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: ldc_w 408
    //   15: invokestatic 246	com/google/android/gms/internal/hn:a	(ZLjava/lang/Object;)V
    //   18: aload_0
    //   19: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 233 1 0
    //   27: aload_0
    //   28: invokevirtual 411	com/google/android/gms/common/api/c:connect	()V
    //   31: aload_0
    //   32: invokevirtual 283	com/google/android/gms/common/api/c:isConnecting	()Z
    //   35: istore_1
    //   36: iload_1
    //   37: ifeq +49 -> 86
    //   40: aload_0
    //   41: getfield 85	com/google/android/gms/common/api/c:DO	Ljava/util/concurrent/locks/Condition;
    //   44: invokeinterface 414 1 0
    //   49: goto -18 -> 31
    //   52: pop
    //   53: invokestatic 420	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: invokevirtual 423	java/lang/Thread:interrupt	()V
    //   59: new 425	com/google/android/gms/common/ConnectionResult
    //   62: dup
    //   63: bipush 15
    //   65: aconst_null
    //   66: invokespecial 428	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   74: invokeinterface 270 1 0
    //   79: aload_1
    //   80: areturn
    //   81: iconst_0
    //   82: istore_1
    //   83: goto -72 -> 11
    //   86: aload_0
    //   87: invokevirtual 236	com/google/android/gms/common/api/c:isConnected	()Z
    //   90: ifeq +19 -> 109
    //   93: getstatic 431	com/google/android/gms/common/ConnectionResult:CP	Lcom/google/android/gms/common/ConnectionResult;
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   101: invokeinterface 270 1 0
    //   106: goto -27 -> 79
    //   109: aload_0
    //   110: getfield 221	com/google/android/gms/common/api/c:DS	Lcom/google/android/gms/common/ConnectionResult;
    //   113: ifnull +20 -> 133
    //   116: aload_0
    //   117: getfield 221	com/google/android/gms/common/api/c:DS	Lcom/google/android/gms/common/ConnectionResult;
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   125: invokeinterface 270 1 0
    //   130: goto -51 -> 79
    //   133: new 425	com/google/android/gms/common/ConnectionResult
    //   136: dup
    //   137: bipush 13
    //   139: aconst_null
    //   140: invokespecial 428	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   143: astore_1
    //   144: aload_0
    //   145: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   148: invokeinterface 270 1 0
    //   153: goto -74 -> 79
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   161: invokeinterface 270 1 0
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	c
    //   10	27	1	bool	boolean
    //   69	11	1	localConnectionResult1	ConnectionResult
    //   82	1	1	i	int
    //   96	48	1	localConnectionResult2	ConnectionResult
    //   156	11	1	localObject	Object
    //   52	1	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   40	49	52	java/lang/InterruptedException
    //   27	36	156	finally
    //   40	49	156	finally
    //   53	70	156	finally
    //   86	97	156	finally
    //   109	121	156	finally
    //   133	144	156	finally
  }
  
  /* Error */
  public ConnectionResult blockingConnect(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: invokestatic 403	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 406	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +91 -> 97
    //   9: iconst_1
    //   10: istore 4
    //   12: iload 4
    //   14: ldc_w 408
    //   17: invokestatic 246	com/google/android/gms/internal/hn:a	(ZLjava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 233 1 0
    //   29: aload_0
    //   30: invokevirtual 411	com/google/android/gms/common/api/c:connect	()V
    //   33: aload_3
    //   34: lload_1
    //   35: invokevirtual 438	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   38: lstore 4
    //   40: aload_0
    //   41: invokevirtual 283	com/google/android/gms/common/api/c:isConnecting	()Z
    //   44: istore 6
    //   46: iload 6
    //   48: ifeq +86 -> 134
    //   51: aload_0
    //   52: getfield 85	com/google/android/gms/common/api/c:DO	Ljava/util/concurrent/locks/Condition;
    //   55: lload 4
    //   57: invokeinterface 441 3 0
    //   62: lstore 4
    //   64: lload 4
    //   66: ldc2_w 442
    //   69: lcmp
    //   70: ifgt -30 -> 40
    //   73: new 425	com/google/android/gms/common/ConnectionResult
    //   76: dup
    //   77: bipush 14
    //   79: aconst_null
    //   80: invokespecial 428	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   83: astore 4
    //   85: aload_0
    //   86: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   89: invokeinterface 270 1 0
    //   94: aload 4
    //   96: areturn
    //   97: iconst_0
    //   98: istore 4
    //   100: goto -88 -> 12
    //   103: pop
    //   104: invokestatic 420	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   107: invokevirtual 423	java/lang/Thread:interrupt	()V
    //   110: new 425	com/google/android/gms/common/ConnectionResult
    //   113: dup
    //   114: bipush 15
    //   116: aconst_null
    //   117: invokespecial 428	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   120: astore 4
    //   122: aload_0
    //   123: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   126: invokeinterface 270 1 0
    //   131: goto -37 -> 94
    //   134: aload_0
    //   135: invokevirtual 236	com/google/android/gms/common/api/c:isConnected	()Z
    //   138: ifeq +20 -> 158
    //   141: getstatic 431	com/google/android/gms/common/ConnectionResult:CP	Lcom/google/android/gms/common/ConnectionResult;
    //   144: astore 4
    //   146: aload_0
    //   147: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   150: invokeinterface 270 1 0
    //   155: goto -61 -> 94
    //   158: aload_0
    //   159: getfield 221	com/google/android/gms/common/api/c:DS	Lcom/google/android/gms/common/ConnectionResult;
    //   162: ifnull +21 -> 183
    //   165: aload_0
    //   166: getfield 221	com/google/android/gms/common/api/c:DS	Lcom/google/android/gms/common/ConnectionResult;
    //   169: astore 4
    //   171: aload_0
    //   172: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   175: invokeinterface 270 1 0
    //   180: goto -86 -> 94
    //   183: new 425	com/google/android/gms/common/ConnectionResult
    //   186: dup
    //   187: bipush 13
    //   189: aconst_null
    //   190: invokespecial 428	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;)V
    //   193: astore 4
    //   195: aload_0
    //   196: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 270 1 0
    //   204: goto -110 -> 94
    //   207: astore 4
    //   209: aload_0
    //   210: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   213: invokeinterface 270 1 0
    //   218: aload 4
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	c
    //   0	221	1	paramLong	long
    //   0	221	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   10	3	4	bool1	boolean
    //   38	27	4	l	long
    //   83	12	4	localConnectionResult1	ConnectionResult
    //   98	1	4	i	int
    //   120	74	4	localConnectionResult2	ConnectionResult
    //   207	12	4	localObject	Object
    //   44	3	6	bool2	boolean
    //   103	1	10	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   51	85	103	java/lang/InterruptedException
    //   29	46	207	finally
    //   51	85	207	finally
    //   104	122	207	finally
    //   134	146	207	finally
    //   158	171	207	finally
    //   183	195	207	finally
  }
  
  public void connect()
  {
    this.DN.lock();
    for (;;)
    {
      try
      {
        this.DW = false;
        if (!isConnected())
        {
          boolean bool = isConnecting();
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.Ed = true;
        this.DS = null;
        this.DU = 1;
        this.Ea.clear();
        this.DX = this.Eb.size();
        Iterator localIterator = this.Eb.values().iterator();
        if (localIterator.hasNext()) {
          ((Api.a)localIterator.next()).connect();
        }
      }
      finally
      {
        this.DN.unlock();
      }
    }
  }
  
  public void disconnect()
  {
    eI();
    aa(-1);
  }
  
  public Looper getLooper()
  {
    return this.DC;
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 233 1 0
    //   9: aload_0
    //   10: getfield 92	com/google/android/gms/common/api/c:DU	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 270 1 0
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: goto -13 -> 21
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 270 1 0
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   13	18	1	i	int
    //   33	1	1	j	int
    //   37	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 233 1 0
    //   11: aload_0
    //   12: getfield 92	com/google/android/gms/common/api/c:DU	I
    //   15: istore_2
    //   16: iload_2
    //   17: iload_1
    //   18: if_icmpne +14 -> 32
    //   21: aload_0
    //   22: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 270 1 0
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: goto -13 -> 21
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 77	com/google/android/gms/common/api/c:DN	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 270 1 0
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   1	33	1	i	int
    //   37	11	1	localObject	Object
    //   15	4	2	j	int
    // Exception table:
    //   from	to	target	type
    //   11	16	37	finally
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.DP.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.DP.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage()
  {
    boolean bool;
    if (this.DQ == null) {
      bool = false;
    } else {
      bool = true;
    }
    hn.a(bool, "Called stopAutoManage but automatic lifecycle management is not enabled.");
    if (this.DQ.getActivity() != null)
    {
      this.DQ.getActivity().getSupportFragmentManager().beginTransaction().remove(this.DQ).commit();
      disconnect();
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        c.a(c.this).lock();
      }
      for (;;)
      {
        try
        {
          if ((!c.this.isConnected()) && (!c.this.isConnecting())) {
            c.this.connect();
          }
          return;
        }
        finally
        {
          c.a(c.this).unlock();
        }
        Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
      }
    }
  }
  
  static abstract interface c<A extends Api.a>
  {
    public abstract void a(c.a parama);
    
    public abstract void b(A paramA)
      throws DeadObjectException;
    
    public abstract void cancel();
    
    public abstract int eB();
    
    public abstract Api.c<A> ew();
    
    public abstract void m(Status paramStatus);
  }
  
  static abstract interface a
  {
    public abstract void b(c.c<?> paramc);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.c
 * JD-Core Version:    0.7.0.1
 */