package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class ca<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends bv.a
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nS;
  private final NETWORK_EXTRAS nT;
  
  public ca(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.nS = paramMediationAdapter;
    this.nT = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS b(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    if (paramString1 != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        HashMap localHashMap1 = new HashMap(localJSONObject.length());
        localObject2 = localJSONObject.keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          localHashMap1.put(localObject1, localJSONObject.getString((String)localObject1));
          continue;
          localHashMap2 = new HashMap(0);
        }
      }
      catch (Throwable localThrowable)
      {
        ev.c("Could not get MediationServerParameters.", localThrowable);
        throw new RemoteException();
      }
    }
    HashMap localHashMap2;
    Object localObject1 = this.nS.getServerParametersType();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = (MediationServerParameters)((Class)localObject1).newInstance();
      ((MediationServerParameters)localObject2).load(localHashMap2);
    }
    return localObject2;
  }
  
  public void a(d paramd, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramaj, paramString, null, parambw);
  }
  
  public void a(d paramd, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    if (!(this.nS instanceof MediationInterstitialAdapter))
    {
      ev.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ev.z("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nS).requestInterstitialAd(new cb(parambw), (Activity)e.e(paramd), b(paramString1, paramaj.lU, paramString2), cc.e(paramaj), this.nT);
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not request interstitial ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void a(d paramd, am paramam, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramam, paramaj, paramString, null, parambw);
  }
  
  public void a(d paramd, am paramam, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    if (!(this.nS instanceof MediationBannerAdapter))
    {
      ev.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ev.z("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.nS).requestBannerAd(new cb(parambw), (Activity)e.e(paramd), b(paramString1, paramaj.lU, paramString2), cc.b(paramam), cc.e(paramaj), this.nT);
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not request banner ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.nS.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.nS instanceof MediationBannerAdapter))
    {
      ev.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nS).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.nS instanceof MediationInterstitialAdapter))
    {
      ev.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ev.z("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nS).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ca
 * JD-Core Version:    0.7.0.1
 */