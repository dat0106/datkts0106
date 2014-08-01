package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class r
  extends af
{
  private static final Object tQ = new Object();
  private static r uc;
  private Context mContext;
  private Handler mHandler;
  private d tR;
  private volatile f tS;
  private int tT = 1800;
  private boolean tU = true;
  private boolean tV;
  private String tW;
  private boolean tX = true;
  private boolean tY = true;
  private e tZ = new e()
  {
    public void s(boolean paramAnonymousBoolean)
    {
      r.this.a(paramAnonymousBoolean, r.a(r.this));
    }
  };
  private q ua;
  private boolean ub = false;
  
  private void cA()
  {
    this.ua = new q(this);
    this.ua.s(this.mContext);
  }
  
  private void cB()
  {
    this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (r.cE().equals(paramAnonymousMessage.obj)))
        {
          u.cP().u(true);
          r.this.dispatchLocalHits();
          u.cP().u(false);
          if ((r.b(r.this) > 0) && (!r.c(r.this))) {
            r.d(r.this).sendMessageDelayed(r.d(r.this).obtainMessage(1, r.cE()), 1000 * r.b(r.this));
          }
        }
        return true;
      }
    });
    if (this.tT > 0) {
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tQ), 1000 * this.tT);
    }
  }
  
  public static r cz()
  {
    if (uc == null) {
      uc = new r();
    }
    return uc;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void a(Context paramContext, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 115	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 74	com/google/android/gms/analytics/r:mContext	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 117	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 117	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   34: aload_0
    //   35: getfield 48	com/google/android/gms/analytics/r:tU	Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 120	com/google/android/gms/analytics/r:dispatchLocalHits	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 48	com/google/android/gms/analytics/r:tU	Z
    //   50: aload_0
    //   51: getfield 122	com/google/android/gms/analytics/r:tV	Z
    //   54: ifeq -43 -> 11
    //   57: aload_0
    //   58: invokevirtual 125	com/google/android/gms/analytics/r:cn	()V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 122	com/google/android/gms/analytics/r:tV	Z
    //   66: goto -55 -> 11
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	r
    //   0	74	1	paramContext	Context
    //   0	74	2	paramf	f
    //   6	2	3	localContext	Context
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   14	66	69	finally
  }
  
  /**
   * @deprecated
   */
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.ub == paramBoolean1)
        {
          boolean bool = this.tX;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.tT > 0)) {
          this.mHandler.removeMessages(1, tQ);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.tT > 0)) {
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tQ), 1000 * this.tT);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label153;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      aa.C(str);
      this.ub = paramBoolean1;
      this.tX = paramBoolean2;
      continue;
      label146:
      String str = "terminated.";
      continue;
      label153:
      str = "initiated.";
    }
  }
  
  /**
   * @deprecated
   */
  d cC()
  {
    try
    {
      if (this.tR != null) {
        break label80;
      }
      if (this.mContext == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.tR = new ac(this.tZ, this.mContext);
    if (this.tW != null)
    {
      this.tR.cm().M(this.tW);
      this.tW = null;
    }
    label80:
    if (this.mHandler == null) {
      cB();
    }
    if ((this.ua == null) && (this.tY)) {
      cA();
    }
    d locald = this.tR;
    return locald;
  }
  
  /**
   * @deprecated
   */
  void cD()
  {
    try
    {
      if ((!this.ub) && (this.tX) && (this.tT > 0))
      {
        this.mHandler.removeMessages(1, tQ);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, tQ));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void cn()
  {
    if (this.tS != null)
    {
      u.cP().a(u.a.vY);
      this.tS.cn();
    }
    else
    {
      aa.C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
      this.tV = true;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void dispatchLocalHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 212
    //   11: invokestatic 149	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 48	com/google/android/gms/analytics/r:tU	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 196	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 215	com/google/android/gms/analytics/u$a:vL	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 205	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 117	com/google/android/gms/analytics/r:tS	Lcom/google/android/gms/analytics/f;
    //   35: invokeinterface 218 1 0
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	r
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void setLocalDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   6: ifnonnull +16 -> 22
    //   9: ldc 222
    //   11: invokestatic 149	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 46	com/google/android/gms/analytics/r:tT	I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 196	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   25: getstatic 225	com/google/android/gms/analytics/u$a:vM	Lcom/google/android/gms/analytics/u$a;
    //   28: invokevirtual 205	com/google/android/gms/analytics/u:a	(Lcom/google/android/gms/analytics/u$a;)V
    //   31: aload_0
    //   32: getfield 59	com/google/android/gms/analytics/r:ub	Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 50	com/google/android/gms/analytics/r:tX	Z
    //   42: ifeq +21 -> 63
    //   45: aload_0
    //   46: getfield 46	com/google/android/gms/analytics/r:tT	I
    //   49: ifle +14 -> 63
    //   52: aload_0
    //   53: getfield 93	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   56: iconst_1
    //   57: getstatic 43	com/google/android/gms/analytics/r:tQ	Ljava/lang/Object;
    //   60: invokevirtual 130	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 46	com/google/android/gms/analytics/r:tT	I
    //   68: iload_1
    //   69: ifle -50 -> 19
    //   72: aload_0
    //   73: getfield 59	com/google/android/gms/analytics/r:ub	Z
    //   76: ifne -57 -> 19
    //   79: aload_0
    //   80: getfield 50	com/google/android/gms/analytics/r:tX	Z
    //   83: ifeq -64 -> 19
    //   86: aload_0
    //   87: getfield 93	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield 93	com/google/android/gms/analytics/r:mHandler	Landroid/os/Handler;
    //   94: iconst_1
    //   95: getstatic 43	com/google/android/gms/analytics/r:tQ	Ljava/lang/Object;
    //   98: invokevirtual 97	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   101: iload_1
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: invokevirtual 101	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   110: pop
    //   111: goto -92 -> 19
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	r
    //   0	119	1	paramInt	int
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	114	finally
    //   22	111	114	finally
  }
  
  /**
   * @deprecated
   */
  void t(boolean paramBoolean)
  {
    try
    {
      a(this.ub, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.r
 * JD-Core Version:    0.7.0.1
 */