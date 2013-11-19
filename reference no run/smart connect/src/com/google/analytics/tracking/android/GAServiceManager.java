package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.util.VisibleForTesting;

public class GAServiceManager
  implements ServiceManager
{
  private static final int MSG_KEY = 1;
  private static final Object MSG_OBJECT = new Object();
  private static GAServiceManager instance;
  private boolean connected = true;
  private Context ctx;
  private int dispatchPeriodInSeconds = 1800;
  private Handler handler;
  private boolean listenForNetwork = true;
  private AnalyticsStoreStateListener listener = new AnalyticsStoreStateListener()
  {
    public void reportStoreIsEmpty(boolean paramAnonymousBoolean)
    {
      GAServiceManager.this.updatePowerSaveMode(paramAnonymousBoolean, GAServiceManager.this.connected);
    }
  };
  private GANetworkReceiver networkReceiver;
  private boolean pendingDispatch = true;
  private AnalyticsStore store;
  private boolean storeIsEmpty = false;
  private volatile AnalyticsThread thread;
  
  private GAServiceManager() {}
  
  @VisibleForTesting
  GAServiceManager(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore, boolean paramBoolean)
  {
    this.store = paramAnalyticsStore;
    this.thread = paramAnalyticsThread;
    this.listenForNetwork = paramBoolean;
    initialize(paramContext, paramAnalyticsThread);
  }
  
  public static GAServiceManager getInstance()
  {
    if (instance == null) {
      instance = new GAServiceManager();
    }
    return instance;
  }
  
  private void initializeHandler()
  {
    this.handler = new Handler(this.ctx.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (GAServiceManager.MSG_OBJECT.equals(paramAnonymousMessage.obj)))
        {
          GAUsage.getInstance().setDisableUsage(true);
          GAServiceManager.this.dispatch();
          GAUsage.getInstance().setDisableUsage(false);
          if ((GAServiceManager.this.dispatchPeriodInSeconds > 0) && (!GAServiceManager.this.storeIsEmpty)) {
            GAServiceManager.this.handler.sendMessageDelayed(GAServiceManager.this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), 1000 * GAServiceManager.this.dispatchPeriodInSeconds);
          }
        }
        return true;
      }
    });
    if (this.dispatchPeriodInSeconds > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), 1000 * this.dispatchPeriodInSeconds);
    }
  }
  
  private void initializeNetworkReceiver()
  {
    this.networkReceiver = new GANetworkReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.ctx.registerReceiver(this.networkReceiver, localIntentFilter);
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   6: ifnonnull +17 -> 23
    //   9: ldc 130
    //   11: invokestatic 136	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 46	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 141	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   26: getstatic 147	com/google/analytics/tracking/android/GAUsage$Field:DISPATCH	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   29: invokevirtual 151	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   32: aload_0
    //   33: getfield 63	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   36: invokeinterface 155 1 0
    //   41: goto -21 -> 20
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	GAServiceManager
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	41	44	finally
  }
  
  @VisibleForTesting
  AnalyticsStoreStateListener getListener()
  {
    return this.listener;
  }
  
  /**
   * @deprecated
   */
  AnalyticsStore getStore()
  {
    try
    {
      if (this.store != null) {
        break label50;
      }
      if (this.ctx == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
    label50:
    if (this.handler == null) {
      initializeHandler();
    }
    if ((this.networkReceiver == null) && (this.listenForNetwork)) {
      initializeNetworkReceiver();
    }
    AnalyticsStore localAnalyticsStore = this.store;
    return localAnalyticsStore;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void initialize(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 178	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 88	com/google/analytics/tracking/android/GAServiceManager:ctx	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 63	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 63	com/google/analytics/tracking/android/GAServiceManager:thread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   34: aload_0
    //   35: getfield 46	com/google/analytics/tracking/android/GAServiceManager:pendingDispatch	Z
    //   38: ifeq -27 -> 11
    //   41: aload_2
    //   42: invokeinterface 155 1 0
    //   47: goto -36 -> 11
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	GAServiceManager
    //   0	55	1	paramContext	Context
    //   0	55	2	paramAnalyticsThread	AnalyticsThread
    //   6	2	3	localContext	Context
    //   50	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	47	50	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void setDispatchPeriod(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   6: ifnonnull +17 -> 23
    //   9: ldc 182
    //   11: invokestatic 136	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iload_1
    //   17: putfield 44	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 141	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   26: getstatic 185	com/google/analytics/tracking/android/GAUsage$Field:SET_DISPATCH_PERIOD	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   29: invokevirtual 151	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   32: aload_0
    //   33: getfield 57	com/google/analytics/tracking/android/GAServiceManager:storeIsEmpty	Z
    //   36: ifne +28 -> 64
    //   39: aload_0
    //   40: getfield 48	com/google/analytics/tracking/android/GAServiceManager:connected	Z
    //   43: ifeq +21 -> 64
    //   46: aload_0
    //   47: getfield 44	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   50: ifle +14 -> 64
    //   53: aload_0
    //   54: getfield 78	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   57: iconst_1
    //   58: getstatic 42	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   61: invokevirtual 189	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   64: aload_0
    //   65: iload_1
    //   66: putfield 44	com/google/analytics/tracking/android/GAServiceManager:dispatchPeriodInSeconds	I
    //   69: iload_1
    //   70: ifle -50 -> 20
    //   73: aload_0
    //   74: getfield 57	com/google/analytics/tracking/android/GAServiceManager:storeIsEmpty	Z
    //   77: ifne -57 -> 20
    //   80: aload_0
    //   81: getfield 48	com/google/analytics/tracking/android/GAServiceManager:connected	Z
    //   84: ifeq -64 -> 20
    //   87: aload_0
    //   88: getfield 78	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   91: aload_0
    //   92: getfield 78	com/google/analytics/tracking/android/GAServiceManager:handler	Landroid/os/Handler;
    //   95: iconst_1
    //   96: getstatic 42	com/google/analytics/tracking/android/GAServiceManager:MSG_OBJECT	Ljava/lang/Object;
    //   99: invokevirtual 102	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   102: iload_1
    //   103: sipush 1000
    //   106: imul
    //   107: i2l
    //   108: invokevirtual 106	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   111: pop
    //   112: goto -92 -> 20
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	GAServiceManager
    //   0	120	1	paramInt	int
    //   115	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	115	finally
    //   23	112	115	finally
  }
  
  /**
   * @deprecated
   */
  public void updateConnectivityStatus(boolean paramBoolean)
  {
    try
    {
      updatePowerSaveMode(this.storeIsEmpty, paramBoolean);
      return;
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
  @VisibleForTesting
  void updatePowerSaveMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      try
      {
        if (this.storeIsEmpty == paramBoolean1)
        {
          bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.removeMessages(1, MSG_OBJECT);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.dispatchPeriodInSeconds > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), 1000 * this.dispatchPeriodInSeconds);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label154;
        }
        if (paramBoolean2) {
          break label148;
        }
      }
      finally {}
      Log.iDebug(bool);
      this.storeIsEmpty = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label148:
      String str = "terminated.";
      continue;
      label154:
      str = "initiated.";
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAServiceManager
 * JD-Core Version:    0.7.0.1
 */