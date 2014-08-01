package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class hd
{
  private final b Gm;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Gn = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Go = new ArrayList();
  private boolean Gp = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> Gq = new ArrayList();
  private final Handler mHandler;
  
  public hd(Context paramContext, Looper paramLooper, b paramb)
  {
    this.Gm = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  /* Error */
  public void a(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/google/android/gms/internal/hd:mHandler	Landroid/os/Handler;
    //   4: iconst_1
    //   5: invokevirtual 54	android/os/Handler:removeMessages	(I)V
    //   8: aload_0
    //   9: getfield 38	com/google/android/gms/internal/hd:Gq	Ljava/util/ArrayList;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: new 29	java/util/ArrayList
    //   18: dup
    //   19: aload_0
    //   20: getfield 38	com/google/android/gms/internal/hd:Gq	Ljava/util/ArrayList;
    //   23: invokespecial 57	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   26: invokevirtual 61	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore 4
    //   31: aload 4
    //   33: invokeinterface 67 1 0
    //   38: ifeq +57 -> 95
    //   41: aload 4
    //   43: invokeinterface 71 1 0
    //   48: checkcast 73	com/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 40	com/google/android/gms/internal/hd:Gm	Lcom/google/android/gms/internal/hd$b;
    //   56: invokeinterface 76 1 0
    //   61: ifne +8 -> 69
    //   64: aload_2
    //   65: monitorexit
    //   66: goto +31 -> 97
    //   69: aload_0
    //   70: getfield 38	com/google/android/gms/internal/hd:Gq	Ljava/util/ArrayList;
    //   73: aload_3
    //   74: invokevirtual 80	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   77: ifeq -46 -> 31
    //   80: aload_3
    //   81: aload_1
    //   82: invokeinterface 83 2 0
    //   87: goto -56 -> 31
    //   90: astore_3
    //   91: aload_2
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    //   95: aload_2
    //   96: monitorexit
    //   97: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	hd
    //   0	98	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    //   12	84	2	localArrayList	ArrayList
    //   51	30	3	localOnConnectionFailedListener	GooglePlayServicesClient.OnConnectionFailedListener
    //   90	4	3	localObject	Object
    //   29	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   15	93	90	finally
    //   95	97	90	finally
  }
  
  public void ao(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Gn)
    {
      this.Gp = true;
      Iterator localIterator = new ArrayList(this.Gn).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.Gm.eJ()) {}
        }
        else
        {
          this.Gp = false;
          return;
        }
      } while (!this.Gn.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    boolean bool1 = true;
    for (;;)
    {
      int j;
      synchronized (this.Gn)
      {
        if (!this.Gp)
        {
          boolean bool2 = bool1;
          hn.A(bool2);
          this.mHandler.removeMessages(1);
          this.Gp = true;
          if (this.Go.size() != 0) {
            break label159;
          }
          hn.A(bool1);
          Iterator localIterator = new ArrayList(this.Gn).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.Gm.eJ()) && (this.Gm.isConnected())) {}
          }
          else
          {
            this.Go.clear();
            this.Gp = false;
            return;
          }
          if (this.Go.contains(localConnectionCallbacks)) {
            continue;
          }
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      continue;
      label159:
      int i = 0;
    }
  }
  
  protected void ck()
  {
    synchronized (this.Gn)
    {
      c(this.Gm.ea());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      boolean bool = this.Gn.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      boolean bool = this.Gq.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      if (this.Gn.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.Gm.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.Gn.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      if (this.Gq.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Gq.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      if (this.Gn != null)
      {
        if (this.Gn.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.Gp) {
        return;
      }
      this.Go.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      if ((this.Gq != null) && (!this.Gq.remove(paramOnConnectionFailedListener))) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean eJ();
    
    public abstract Bundle ea();
    
    public abstract boolean isConnected();
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        synchronized (hd.a(hd.this))
        {
          if ((hd.b(hd.this).eJ()) && (hd.b(hd.this).isConnected()) && (hd.a(hd.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = hd.b(hd.this).ea();
            ((GoogleApiClient.ConnectionCallbacks)paramMessage.obj).onConnected(localBundle);
          }
        }
      }
      Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hd
 * JD-Core Version:    0.7.0.1
 */