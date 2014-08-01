package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import java.util.Map;

public final class bt
  extends bu.a
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> nO;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bv n(String paramString)
    throws RemoteException
  {
    try
    {
      Object localObject = Class.forName(paramString, false, bt.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = (com.google.ads.mediation.MediationAdapter)((Class)localObject).newInstance();
        localObject = new ca((com.google.ads.mediation.MediationAdapter)localObject, (com.google.ads.mediation.NetworkExtras)this.nO.get(((com.google.ads.mediation.MediationAdapter)localObject).getAdditionalParametersType()));
      }
      else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = new by((com.google.android.gms.ads.mediation.MediationAdapter)((Class)localObject).newInstance());
      }
      else
      {
        ev.D("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
        throw new RemoteException();
      }
    }
    catch (Throwable localThrowable)
    {
      ev.D("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
    return localThrowable;
  }
  
  public void c(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.nO = paramMap;
  }
  
  public bv m(String paramString)
    throws RemoteException
  {
    return n(paramString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bt
 * JD-Core Version:    0.7.0.1
 */