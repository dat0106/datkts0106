package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class ds
  extends hc<dx>
{
  final int pT;
  
  public ds(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.pT = paramInt;
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramhj.g(parame, this.pT, getContext().getPackageName(), localBundle);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public dx br()
  {
    return (dx)super.fo();
  }
  
  protected dx w(IBinder paramIBinder)
  {
    return dx.a.y(paramIBinder);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ds
 * JD-Core Version:    0.7.0.1
 */