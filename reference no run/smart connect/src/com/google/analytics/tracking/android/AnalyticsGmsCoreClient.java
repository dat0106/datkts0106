package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient
  implements AnalyticsClient
{
  private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
  public static final int BIND_FAILED = 1;
  public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
  public static final int REMOTE_EXECUTION_FAILED = 2;
  static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
  private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
  private ServiceConnection mConnection;
  private Context mContext;
  private OnConnectedListener mOnConnectedListener;
  private OnConnectionFailedListener mOnConnectionFailedListener;
  private IAnalyticsService mService;
  
  public AnalyticsGmsCoreClient(Context paramContext, OnConnectedListener paramOnConnectedListener, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.mContext = paramContext;
    if (paramOnConnectedListener != null)
    {
      this.mOnConnectedListener = paramOnConnectedListener;
      if (paramOnConnectionFailedListener != null)
      {
        this.mOnConnectionFailedListener = paramOnConnectionFailedListener;
        return;
      }
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    throw new IllegalArgumentException("onConnectedListener cannot be null");
  }
  
  private IAnalyticsService getService()
  {
    checkConnected();
    return this.mService;
  }
  
  private void onConnectionSuccess()
  {
    this.mOnConnectedListener.onConnected();
  }
  
  private void onServiceBound()
  {
    onConnectionSuccess();
  }
  
  protected void checkConnected()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void clearHits()
  {
    try
    {
      getService().clearHits();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("clear hits failed: " + localRemoteException);
      }
    }
  }
  
  public void connect()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.putExtra("app_package_name", this.mContext.getPackageName());
    if (this.mConnection == null)
    {
      this.mConnection = new AnalyticsServiceConnection();
      boolean bool = this.mContext.bindService(localIntent, this.mConnection, 129);
      Log.iDebug("connect: bindService returned " + bool + " for " + localIntent);
      if (!bool)
      {
        this.mConnection = null;
        this.mOnConnectionFailedListener.onConnectionFailed(1, null);
      }
    }
    else
    {
      Log.e("Calling connect() while still connected, missing disconnect().");
    }
  }
  
  public void disconnect()
  {
    this.mService = null;
    if (this.mConnection != null) {}
    try
    {
      this.mContext.unbindService(this.mConnection);
      label23:
      this.mConnection = null;
      this.mOnConnectedListener.onDisconnected();
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
    if (this.mService == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void sendHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      getService().sendHit(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("sendHit failed: " + localRemoteException);
      }
    }
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface OnConnectedListener
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  final class AnalyticsServiceConnection
    implements ServiceConnection
  {
    AnalyticsServiceConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.dDebug("service connected, binder: " + paramIBinder);
      try
      {
        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
        {
          Log.dDebug("bound to service");
          AnalyticsGmsCoreClient.access$002(AnalyticsGmsCoreClient.this, IAnalyticsService.Stub.asInterface(paramIBinder));
          AnalyticsGmsCoreClient.this.onServiceBound();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          AnalyticsGmsCoreClient.this.mContext.unbindService(this);
          AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
          AnalyticsGmsCoreClient.this.mOnConnectionFailedListener.onConnectionFailed(2, null);
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      Log.dDebug("service disconnected: " + paramComponentName);
      AnalyticsGmsCoreClient.access$302(AnalyticsGmsCoreClient.this, null);
      AnalyticsGmsCoreClient.this.mOnConnectedListener.onDisconnected();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AnalyticsGmsCoreClient
 * JD-Core Version:    0.7.0.1
 */