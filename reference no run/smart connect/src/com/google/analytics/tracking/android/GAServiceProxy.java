package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class GAServiceProxy
  implements ServiceProxy, AnalyticsGmsCoreClient.OnConnectedListener, AnalyticsGmsCoreClient.OnConnectionFailedListener
{
  private static final long FAILED_CONNECT_WAIT_TIME = 3000L;
  private static final int MAX_TRIES = 2;
  private static final long RECONNECT_WAIT_TIME = 5000L;
  private static final long SERVICE_CONNECTION_TIMEOUT = 300000L;
  private volatile AnalyticsClient client;
  private Clock clock;
  private volatile int connectTries;
  private final Context ctx;
  private volatile Timer disconnectCheckTimer;
  private volatile Timer failedConnectTimer;
  private long idleTimeout = 300000L;
  private volatile long lastRequestTime;
  private boolean pendingClearHits;
  private boolean pendingDispatch;
  private final Queue<HitParams> queue = new ConcurrentLinkedQueue();
  private volatile Timer reConnectTimer;
  private volatile ConnectState state;
  private AnalyticsStore store;
  private AnalyticsStore testStore;
  private final AnalyticsThread thread;
  
  GAServiceProxy(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    this(paramContext, paramAnalyticsThread, null);
  }
  
  GAServiceProxy(Context paramContext, AnalyticsThread paramAnalyticsThread, AnalyticsStore paramAnalyticsStore)
  {
    this.testStore = paramAnalyticsStore;
    this.ctx = paramContext;
    this.thread = paramAnalyticsThread;
    this.clock = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.connectTries = 0;
    this.state = ConnectState.DISCONNECTED;
  }
  
  private Timer cancelTimer(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private void clearAllTimers()
  {
    this.reConnectTimer = cancelTimer(this.reConnectTimer);
    this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
    this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
  }
  
  /**
   * @deprecated
   */
  private void connectToService()
  {
    for (;;)
    {
      try
      {
        if (this.client != null)
        {
          ConnectState localConnectState2 = this.state;
          ConnectState localConnectState1 = ConnectState.CONNECTED_LOCAL;
          if (localConnectState2 != localConnectState1) {
            try
            {
              this.connectTries = (1 + this.connectTries);
              cancelTimer(this.failedConnectTimer);
              this.state = ConnectState.CONNECTING;
              this.failedConnectTimer = new Timer("Failed Connect");
              this.failedConnectTimer.schedule(new FailedConnectTask(null), 3000L);
              Log.iDebug("connecting to Analytics service");
              this.client.connect();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              Log.w("security exception on connectToService");
              useStore();
              continue;
            }
          }
        }
        Log.w("client not initialized.");
      }
      finally {}
      useStore();
    }
  }
  
  /**
   * @deprecated
   */
  private void disconnectFromService()
  {
    try
    {
      if ((this.client != null) && (this.state == ConnectState.CONNECTED_SERVICE))
      {
        this.state = ConnectState.PENDING_DISCONNECT;
        this.client.disconnect();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dispatchToStore()
  {
    this.store.dispatch();
    this.pendingDispatch = false;
  }
  
  private void fireReconnectAttempt()
  {
    this.reConnectTimer = cancelTimer(this.reConnectTimer);
    this.reConnectTimer = new Timer("Service Reconnect");
    this.reConnectTimer.schedule(new ReconnectTask(null), 5000L);
  }
  
  /**
   * @deprecated
   */
  private void sendQueue()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(this.thread.getThread()))
        {
          this.thread.getQueue().add(new Runnable()
          {
            public void run()
            {
              GAServiceProxy.this.sendQueue();
            }
          });
          return;
        }
        if (this.pendingClearHits) {
          clearHits();
        }
        switch (3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()])
        {
        case 1: 
          if (!this.queue.isEmpty())
          {
            HitParams localHitParams1 = (HitParams)this.queue.poll();
            Log.iDebug("Sending hit to store");
            this.store.putHit(localHitParams1.getWireFormatParams(), localHitParams1.getHitTimeInMilliseconds(), localHitParams1.getPath(), localHitParams1.getCommands());
            continue;
          }
          if (!this.pendingDispatch) {
            continue;
          }
        }
      }
      finally {}
      dispatchToStore();
      continue;
      while (!this.queue.isEmpty())
      {
        HitParams localHitParams2 = (HitParams)this.queue.peek();
        Log.iDebug("Sending hit to service");
        this.client.sendHit(localHitParams2.getWireFormatParams(), localHitParams2.getHitTimeInMilliseconds(), localHitParams2.getPath(), localHitParams2.getCommands());
        this.queue.poll();
      }
      this.lastRequestTime = this.clock.currentTimeMillis();
      continue;
      Log.iDebug("Need to reconnect");
      if (!this.queue.isEmpty()) {
        connectToService();
      }
    }
  }
  
  /**
   * @deprecated
   */
  private void useStore()
  {
    for (;;)
    {
      try
      {
        ConnectState localConnectState1 = this.state;
        ConnectState localConnectState2 = ConnectState.CONNECTED_LOCAL;
        if (localConnectState1 == localConnectState2) {
          return;
        }
        clearAllTimers();
        Log.iDebug("falling back to local store");
        if (this.testStore != null)
        {
          this.store = this.testStore;
          this.state = ConnectState.CONNECTED_LOCAL;
          sendQueue();
          continue;
        }
        localGAServiceManager = GAServiceManager.getInstance();
      }
      finally {}
      GAServiceManager localGAServiceManager;
      localGAServiceManager.initialize(this.ctx, this.thread);
      this.store = localGAServiceManager.getStore();
    }
  }
  
  public void clearHits()
  {
    Log.iDebug("clearHits called");
    this.queue.clear();
    switch (3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()])
    {
    default: 
      this.pendingClearHits = true;
      break;
    case 1: 
      this.store.clearHits(0L);
      this.pendingClearHits = false;
      break;
    case 2: 
      this.client.clearHits();
      this.pendingClearHits = false;
    }
  }
  
  public void createService()
  {
    if (this.client == null)
    {
      this.client = new AnalyticsGmsCoreClient(this.ctx, this, this);
      connectToService();
    }
  }
  
  void createService(AnalyticsClient paramAnalyticsClient)
  {
    if (this.client == null)
    {
      this.client = paramAnalyticsClient;
      connectToService();
    }
  }
  
  public void dispatch()
  {
    switch (3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()])
    {
    default: 
      this.pendingDispatch = true;
      break;
    case 1: 
      dispatchToStore();
    }
  }
  
  /**
   * @deprecated
   */
  public void onConnected()
  {
    try
    {
      this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
      this.connectTries = 0;
      Log.iDebug("Connected to service");
      this.state = ConnectState.CONNECTED_SERVICE;
      sendQueue();
      this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
      this.disconnectCheckTimer = new Timer("disconnect check");
      this.disconnectCheckTimer.schedule(new DisconnectCheckTask(null), this.idleTimeout);
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
  public void onConnectionFailed(int paramInt, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 347	com/google/analytics/tracking/android/GAServiceProxy$ConnectState:PENDING_CONNECTION	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   6: putfield 103	com/google/analytics/tracking/android/GAServiceProxy:state	Lcom/google/analytics/tracking/android/GAServiceProxy$ConnectState;
    //   9: aload_0
    //   10: getfield 98	com/google/analytics/tracking/android/GAServiceProxy:connectTries	I
    //   13: iconst_2
    //   14: if_icmpge +40 -> 54
    //   17: new 349	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 352
    //   27: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 361
    //   37: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 188	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: invokespecial 366	com/google/analytics/tracking/android/GAServiceProxy:fireReconnectAttempt	()V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: new 349	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 352
    //   64: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 368
    //   74: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 188	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: invokespecial 123	com/google/analytics/tracking/android/GAServiceProxy:useStore	()V
    //   88: goto -37 -> 51
    //   91: astore_3
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	GAServiceProxy
    //   0	96	1	paramInt	int
    //   0	96	2	paramIntent	android.content.Intent
    //   91	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	51	91	finally
    //   54	88	91	finally
  }
  
  /**
   * @deprecated
   */
  public void onDisconnected()
  {
    for (;;)
    {
      try
      {
        if (this.state == ConnectState.PENDING_DISCONNECT)
        {
          Log.iDebug("Disconnected from service");
          clearAllTimers();
          this.state = ConnectState.DISCONNECTED;
          return;
        }
        Log.iDebug("Unexpected disconnect.");
        this.state = ConnectState.PENDING_CONNECTION;
        if (this.connectTries < 2) {
          fireReconnectAttempt();
        } else {
          useStore();
        }
      }
      finally {}
    }
  }
  
  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    Log.iDebug("putHit called");
    this.queue.add(new HitParams(paramMap, paramLong, paramString, paramList));
    sendQueue();
  }
  
  void setClock(Clock paramClock)
  {
    this.clock = paramClock;
  }
  
  public void setIdleTimeout(long paramLong)
  {
    this.idleTimeout = paramLong;
  }
  
  private static class HitParams
  {
    private final List<Command> commands;
    private final long hitTimeInMilliseconds;
    private final String path;
    private final Map<String, String> wireFormatParams;
    
    public HitParams(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
    {
      this.wireFormatParams = paramMap;
      this.hitTimeInMilliseconds = paramLong;
      this.path = paramString;
      this.commands = paramList;
    }
    
    public List<Command> getCommands()
    {
      return this.commands;
    }
    
    public long getHitTimeInMilliseconds()
    {
      return this.hitTimeInMilliseconds;
    }
    
    public String getPath()
    {
      return this.path;
    }
    
    public Map<String, String> getWireFormatParams()
    {
      return this.wireFormatParams;
    }
  }
  
  private class DisconnectCheckTask
    extends TimerTask
  {
    private DisconnectCheckTask() {}
    
    public void run()
    {
      if ((GAServiceProxy.this.state != GAServiceProxy.ConnectState.CONNECTED_SERVICE) || (!GAServiceProxy.this.queue.isEmpty()) || (GAServiceProxy.this.lastRequestTime + GAServiceProxy.this.idleTimeout >= GAServiceProxy.this.clock.currentTimeMillis()))
      {
        GAServiceProxy.this.disconnectCheckTimer.schedule(new DisconnectCheckTask(GAServiceProxy.this), GAServiceProxy.this.idleTimeout);
      }
      else
      {
        Log.iDebug("Disconnecting due to inactivity");
        GAServiceProxy.this.disconnectFromService();
      }
    }
  }
  
  private class ReconnectTask
    extends TimerTask
  {
    private ReconnectTask() {}
    
    public void run()
    {
      GAServiceProxy.this.connectToService();
    }
  }
  
  private class FailedConnectTask
    extends TimerTask
  {
    private FailedConnectTask() {}
    
    public void run()
    {
      if (GAServiceProxy.this.state == GAServiceProxy.ConnectState.CONNECTING) {
        GAServiceProxy.this.useStore();
      }
    }
  }
  
  private static enum ConnectState
  {
    static
    {
      CONNECTED_SERVICE = new ConnectState("CONNECTED_SERVICE", 1);
      CONNECTED_LOCAL = new ConnectState("CONNECTED_LOCAL", 2);
      BLOCKED = new ConnectState("BLOCKED", 3);
      PENDING_CONNECTION = new ConnectState("PENDING_CONNECTION", 4);
      PENDING_DISCONNECT = new ConnectState("PENDING_DISCONNECT", 5);
      DISCONNECTED = new ConnectState("DISCONNECTED", 6);
      ConnectState[] arrayOfConnectState = new ConnectState[7];
      arrayOfConnectState[0] = CONNECTING;
      arrayOfConnectState[1] = CONNECTED_SERVICE;
      arrayOfConnectState[2] = CONNECTED_LOCAL;
      arrayOfConnectState[3] = BLOCKED;
      arrayOfConnectState[4] = PENDING_CONNECTION;
      arrayOfConnectState[5] = PENDING_DISCONNECT;
      arrayOfConnectState[6] = DISCONNECTED;
      $VALUES = arrayOfConnectState;
    }
    
    private ConnectState() {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAServiceProxy
 * JD-Core Version:    0.7.0.1
 */