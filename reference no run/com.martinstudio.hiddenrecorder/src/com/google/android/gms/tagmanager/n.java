package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;

class n
  implements ContainerHolder
{
  private final Looper DC;
  private boolean Im;
  private b aeA;
  private a aeB;
  private TagManager aeC;
  private Container aey;
  private Container aez;
  private Status yw;
  
  public n(Status paramStatus)
  {
    this.yw = paramStatus;
    this.DC = null;
  }
  
  public n(TagManager paramTagManager, Looper paramLooper, Container paramContainer, a parama)
  {
    this.aeC = paramTagManager;
    if (paramLooper == null) {
      paramLooper = Looper.getMainLooper();
    }
    this.DC = paramLooper;
    this.aey = paramContainer;
    this.aeB = parama;
    this.yw = Status.Ek;
    paramTagManager.a(this);
  }
  
  private void lk()
  {
    if (this.aeA != null) {
      this.aeA.bK(this.aez.lh());
    }
  }
  
  /**
   * @deprecated
   */
  public void a(Container paramContainer)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.Im;
        if (bool) {
          return;
        }
        if (paramContainer == null)
        {
          bh.A("Unexpected null container.");
          continue;
        }
        this.aez = paramContainer;
      }
      finally {}
      lk();
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void bH(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/tagmanager/n:Im	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 47	com/google/android/gms/tagmanager/n:aey	Lcom/google/android/gms/tagmanager/Container;
    //   18: aload_1
    //   19: invokevirtual 89	com/google/android/gms/tagmanager/Container:bH	(Ljava/lang/String;)V
    //   22: goto -11 -> 11
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	n
    //   0	30	1	paramString	String
    //   6	2	2	bool	boolean
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  void bJ(String paramString)
  {
    if (!this.Im) {
      this.aeB.bJ(paramString);
    } else {
      bh.A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Container getContainer()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 77	com/google/android/gms/tagmanager/n:Im	Z
    //   8: ifeq +12 -> 20
    //   11: ldc 98
    //   13: invokestatic 84	com/google/android/gms/tagmanager/bh:A	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 64	com/google/android/gms/tagmanager/n:aez	Lcom/google/android/gms/tagmanager/Container;
    //   24: ifnull +16 -> 40
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 64	com/google/android/gms/tagmanager/n:aez	Lcom/google/android/gms/tagmanager/Container;
    //   32: putfield 47	com/google/android/gms/tagmanager/n:aey	Lcom/google/android/gms/tagmanager/Container;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 64	com/google/android/gms/tagmanager/n:aez	Lcom/google/android/gms/tagmanager/Container;
    //   40: aload_0
    //   41: getfield 47	com/google/android/gms/tagmanager/n:aey	Lcom/google/android/gms/tagmanager/Container;
    //   44: astore_1
    //   45: goto -29 -> 16
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	n
    //   1	44	1	localContainer	Container
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	48	finally
    //   20	45	48	finally
  }
  
  String getContainerId()
  {
    String str;
    if (!this.Im)
    {
      str = this.aey.getContainerId();
    }
    else
    {
      bh.A("getContainerId called on a released ContainerHolder.");
      str = "";
    }
    return str;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  String lj()
  {
    String str;
    if (!this.Im)
    {
      str = this.aeB.lj();
    }
    else
    {
      bh.A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      str = "";
    }
    return str;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/tagmanager/n:Im	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 113
    //   11: invokestatic 84	com/google/android/gms/tagmanager/bh:A	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 49	com/google/android/gms/tagmanager/n:aeB	Lcom/google/android/gms/tagmanager/n$a;
    //   21: invokeinterface 116 1 0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	n
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/tagmanager/n:Im	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 119
    //   11: invokestatic 84	com/google/android/gms/tagmanager/bh:A	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 77	com/google/android/gms/tagmanager/n:Im	Z
    //   22: aload_0
    //   23: getfield 39	com/google/android/gms/tagmanager/n:aeC	Lcom/google/android/gms/tagmanager/TagManager;
    //   26: aload_0
    //   27: invokevirtual 122	com/google/android/gms/tagmanager/TagManager:b	(Lcom/google/android/gms/tagmanager/n;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 47	com/google/android/gms/tagmanager/n:aey	Lcom/google/android/gms/tagmanager/Container;
    //   35: invokevirtual 124	com/google/android/gms/tagmanager/Container:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 47	com/google/android/gms/tagmanager/n:aey	Lcom/google/android/gms/tagmanager/Container;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 64	com/google/android/gms/tagmanager/n:aez	Lcom/google/android/gms/tagmanager/Container;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 49	com/google/android/gms/tagmanager/n:aeB	Lcom/google/android/gms/tagmanager/n$a;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 62	com/google/android/gms/tagmanager/n:aeA	Lcom/google/android/gms/tagmanager/n$b;
    //   58: goto -44 -> 14
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	n
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   17	58	61	finally
  }
  
  /**
   * @deprecated
   */
  public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener)
  {
    for (;;)
    {
      try
      {
        if (this.Im)
        {
          bh.A("ContainerHolder is released.");
          return;
        }
        if (paramContainerAvailableListener == null)
        {
          this.aeA = null;
          continue;
        }
        this.aeA = new b(paramContainerAvailableListener, this.DC);
      }
      finally {}
      if (this.aez != null) {
        lk();
      }
    }
  }
  
  private class b
    extends Handler
  {
    private final ContainerHolder.ContainerAvailableListener aeD;
    
    public b(ContainerHolder.ContainerAvailableListener paramContainerAvailableListener, Looper paramLooper)
    {
      super();
      this.aeD = paramContainerAvailableListener;
    }
    
    public void bK(String paramString)
    {
      sendMessage(obtainMessage(1, paramString));
    }
    
    protected void bL(String paramString)
    {
      this.aeD.onContainerAvailable(n.this, paramString);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        bh.A("Don't know how to handle this message.");
        break;
      case 1: 
        bL((String)paramMessage.obj);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bJ(String paramString);
    
    public abstract String lj();
    
    public abstract void ll();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.n
 * JD-Core Version:    0.7.0.1
 */