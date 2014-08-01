package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class fy
  extends hc<fv>
{
  public fy(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
  }
  
  protected fv C(IBinder paramIBinder)
  {
    return fv.a.A(paramIBinder);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.b(parame, 5077000, getContext().getPackageName());
  }
  
  protected String bp()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }
  
  public fv dM()
  {
    return (fv)fo();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fy
 * JD-Core Version:    0.7.0.1
 */