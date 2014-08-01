package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class kh
  extends hc<kf>
{
  public kh(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramhj.a(parame, 5077000, getContext().getPackageName(), localBundle);
  }
  
  public kf bj(IBinder paramIBinder)
  {
    return kf.a.bi(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kh
 * JD-Core Version:    0.7.0.1
 */