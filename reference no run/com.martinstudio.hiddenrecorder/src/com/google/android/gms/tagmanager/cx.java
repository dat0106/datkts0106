package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx
  extends cw
{
  private static cx ahR;
  private static final Object tQ = new Object();
  private Context ahH;
  private at ahI;
  private volatile ar ahJ;
  private int ahK = 1800000;
  private boolean ahL = true;
  private boolean ahM = false;
  private boolean ahN = true;
  private au ahO = new au()
  {
    public void s(boolean paramAnonymousBoolean)
    {
      cx.this.a(paramAnonymousBoolean, cx.a(cx.this));
    }
  };
  private bn ahP;
  private boolean ahQ = false;
  private boolean connected = true;
  private Handler handler;
  
  private void cA()
  {
    this.ahP = new bn(this);
    this.ahP.s(this.ahH);
  }
  
  private void cB()
  {
    this.handler = new Handler(this.ahH.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (cx.cE().equals(paramAnonymousMessage.obj)))
        {
          cx.this.cl();
          if ((cx.b(cx.this) > 0) && (!cx.c(cx.this))) {
            cx.d(cx.this).sendMessageDelayed(cx.d(cx.this).obtainMessage(1, cx.cE()), cx.b(cx.this));
          }
        }
        return true;
      }
    });
    if (this.ahK > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tQ), this.ahK);
    }
  }
  
  public static cx mL()
  {
    if (ahR == null) {
      ahR = new cx();
    }
    return ahR;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void a(Context paramContext, ar paramar)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/tagmanager/cx:ahH	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 122	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 77	com/google/android/gms/tagmanager/cx:ahH	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 124	com/google/android/gms/tagmanager/cx:ahJ	Lcom/google/android/gms/tagmanager/ar;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 124	com/google/android/gms/tagmanager/cx:ahJ	Lcom/google/android/gms/tagmanager/ar;
    //   34: goto -23 -> 11
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	cx
    //   0	42	1	paramContext	Context
    //   0	42	2	paramar	ar
    //   6	2	3	localContext	Context
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  /**
   * @deprecated
   */
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      try
      {
        if (this.ahQ == paramBoolean1)
        {
          bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.ahK > 0)) {
          this.handler.removeMessages(1, tQ);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.ahK > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tQ), this.ahK);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label149;
        }
        if (paramBoolean2) {
          break label143;
        }
      }
      finally {}
      bh.C(bool);
      this.ahQ = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label143:
      String str = "terminated.";
      continue;
      label149:
      str = "initiated.";
    }
  }
  
  /**
   * @deprecated
   */
  void cD()
  {
    try
    {
      if ((!this.ahQ) && (this.connected) && (this.ahK > 0))
      {
        this.handler.removeMessages(1, tQ);
        this.handler.sendMessage(this.handler.obtainMessage(1, tQ));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void cl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/google/android/gms/tagmanager/cx:ahM	Z
    //   6: ifne +16 -> 22
    //   9: ldc 160
    //   11: invokestatic 148	com/google/android/gms/tagmanager/bh:C	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 49	com/google/android/gms/tagmanager/cx:ahL	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 124	com/google/android/gms/tagmanager/cx:ahJ	Lcom/google/android/gms/tagmanager/ar;
    //   26: new 10	com/google/android/gms/tagmanager/cx$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 161	com/google/android/gms/tagmanager/cx$3:<init>	(Lcom/google/android/gms/tagmanager/cx;)V
    //   34: invokeinterface 166 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	cx
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  /**
   * @deprecated
   */
  at mM()
  {
    try
    {
      if (this.ahI != null) {
        break label50;
      }
      if (this.ahH == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.ahI = new ca(this.ahO, this.ahH);
    label50:
    if (this.handler == null) {
      cB();
    }
    this.ahM = true;
    if (this.ahL)
    {
      cl();
      this.ahL = false;
    }
    if ((this.ahP == null) && (this.ahN)) {
      cA();
    }
    at localat = this.ahI;
    return localat;
  }
  
  /**
   * @deprecated
   */
  void t(boolean paramBoolean)
  {
    try
    {
      a(this.ahQ, paramBoolean);
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
 * Qualified Name:     com.google.android.gms.tagmanager.cx
 * JD-Core Version:    0.7.0.1
 */