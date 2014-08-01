package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ac.a;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ai;

public abstract class WearableListenerService
  extends Service
  implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private IBinder Gz;
  private volatile int aln = -1;
  private Handler alo;
  private Object alp = new Object();
  private boolean alq;
  private String xN;
  
  private boolean ed(int paramInt)
  {
    boolean bool = false;
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    if (arrayOfString != null)
    {
      int i = 0;
      while (i < arrayOfString.length) {
        if (!"com.google.android.gms".equals(arrayOfString[i])) {
          i++;
        } else {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  private void ni()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i != this.aln)
    {
      if ((!GooglePlayServicesUtil.b(getPackageManager(), "com.google.android.gms")) || (!ed(i))) {
        throw new SecurityException("Caller is not GooglePlayServices");
      }
      this.aln = i;
    }
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    IBinder localIBinder;
    if (!"com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      localIBinder = null;
    } else {
      localIBinder = this.Gz;
    }
    return localIBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onCreate: " + getPackageName());
    }
    this.xN = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    this.alo = new Handler(localHandlerThread.getLooper());
    this.Gz = new a(null);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    synchronized (this.alp)
    {
      this.alq = true;
      this.alo.getLooper().quit();
      super.onDestroy();
      return;
    }
  }
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
  
  private class a
    extends ac.a
  {
    private a() {}
    
    public void Y(final DataHolder paramDataHolder)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramDataHolder);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (WearableListenerService.d(WearableListenerService.this)) {
          paramDataHolder.close();
        } else {
          WearableListenerService.e(WearableListenerService.this).post(new Runnable()
          {
            public void run()
            {
              DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
              try
              {
                WearableListenerService.this.onDataChanged(localDataEventBuffer);
                return;
              }
              finally
              {
                localDataEventBuffer.release();
              }
            }
          });
        }
      }
    }
    
    public void a(final af paramaf)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onMessageReceived: " + paramaf);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (!WearableListenerService.d(WearableListenerService.this)) {
          WearableListenerService.e(WearableListenerService.this).post(new Runnable()
          {
            public void run()
            {
              WearableListenerService.this.onMessageReceived(paramaf);
            }
          });
        }
      }
    }
    
    public void a(final ai paramai)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramai);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (!WearableListenerService.d(WearableListenerService.this)) {
          WearableListenerService.e(WearableListenerService.this).post(new Runnable()
          {
            public void run()
            {
              WearableListenerService.this.onPeerConnected(paramai);
            }
          });
        }
      }
    }
    
    public void b(final ai paramai)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.a(WearableListenerService.this) + ": " + paramai);
      }
      WearableListenerService.b(WearableListenerService.this);
      synchronized (WearableListenerService.c(WearableListenerService.this))
      {
        if (!WearableListenerService.d(WearableListenerService.this)) {
          WearableListenerService.e(WearableListenerService.this).post(new Runnable()
          {
            public void run()
            {
              WearableListenerService.this.onPeerDisconnected(paramai);
            }
          });
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService
 * JD-Core Version:    0.7.0.1
 */