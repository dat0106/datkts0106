package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jh;

@Deprecated
public class ActivityRecognitionClient
  implements GooglePlayServicesClient
{
  private final jh UR;
  
  public ActivityRecognitionClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR = new jh(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "activity_recognition");
  }
  
  public void connect()
  {
    this.UR.connect();
  }
  
  public void disconnect()
  {
    this.UR.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.UR.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.UR.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.UR.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.UR.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.UR.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    try
    {
      this.UR.removeActivityUpdates(paramPendingIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      this.UR.requestActivityUpdates(paramLong, paramPendingIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.UR.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionClient
 * JD-Core Version:    0.7.0.1
 */