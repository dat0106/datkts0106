package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.a;
import java.util.List;
import java.util.Map;

class c
  implements b
{
  private Context mContext;
  private ServiceConnection tu;
  private b tv;
  private c tw;
  private ff tx;
  
  public c(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    if (paramb != null)
    {
      this.tv = paramb;
      if (paramc != null)
      {
        this.tw = paramc;
        return;
      }
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    throw new IllegalArgumentException("onConnectedListener cannot be null");
  }
  
  private ff ch()
  {
    ci();
    return this.tx;
  }
  
  private void cj()
  {
    ck();
  }
  
  private void ck()
  {
    this.tv.onConnected();
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, List<fe> paramList)
  {
    try
    {
      ch().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        aa.A("sendHit failed: " + localRemoteException);
      }
    }
  }
  
  public void cg()
  {
    try
    {
      ch().cg();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        aa.A("clear hits failed: " + localRemoteException);
      }
    }
  }
  
  protected void ci()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.tu == null)
    {
      this.tu = new a();
      boolean bool = this.mContext.bindService(localIntent, this.tu, 129);
      aa.C("connect: bindService returned " + bool + " for " + localIntent);
      if (!bool)
      {
        this.tu = null;
        this.tw.a(1, null);
      }
    }
    else
    {
      aa.A("Calling connect() while still connected, missing disconnect().");
    }
  }
  
  public void disconnect()
  {
    this.tx = null;
    if (this.tu != null) {}
    try
    {
      this.mContext.unbindService(this.tu);
      label23:
      this.tu = null;
      this.tv.onDisconnected();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label23;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label23;
    }
  }
  
  public boolean isConnected()
  {
    boolean bool;
    if (this.tx == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  final class a
    implements ServiceConnection
  {
    a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      aa.C("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          aa.C("bound to service");
          c.a(c.this, ff.a.z(paramIBinder));
          c.a(c.this);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          c.b(c.this).unbindService(this);
          c.a(c.this, null);
          c.c(c.this).a(2, null);
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      aa.C("service disconnected: " + paramComponentName);
      c.a(c.this, null);
      c.d(c.this).onDisconnected();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.c
 * JD-Core Version:    0.7.0.1
 */