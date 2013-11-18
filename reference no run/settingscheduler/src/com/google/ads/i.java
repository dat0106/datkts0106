package com.google.ads;

import android.app.Activity;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.MappingException;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class i
  implements Runnable
{
  private final h a;
  private final String b;
  private final AdRequest c;
  private final HashMap<String, String> d;
  private final boolean e;
  private final WeakReference<Activity> f;
  
  public i(h paramh, Activity paramActivity, String paramString, AdRequest paramAdRequest, HashMap<String, String> paramHashMap)
  {
    this.a = paramh;
    this.b = paramString;
    this.f = new WeakReference(paramActivity);
    this.c = paramAdRequest;
    this.d = new HashMap(paramHashMap);
    this.e = a(this.d);
  }
  
  private <T extends NetworkExtras, U extends MediationServerParameters> void a(MediationAdapter<T, U> paramMediationAdapter)
    throws MediationServerParameters.MappingException, i.a, IllegalAccessException, InstantiationException
  {
    Activity localActivity = (Activity)this.f.get();
    if (localActivity != null)
    {
      this.a.a(paramMediationAdapter);
      Object localObject1 = paramMediationAdapter.getServerParametersType();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = (MediationServerParameters)((Class)localObject1).newInstance();
        ((MediationServerParameters)localObject1).load(this.d);
        localObject1 = localObject1;
      }
      Object localObject2 = paramMediationAdapter.getAdditionalParametersType();
      NetworkExtras localNetworkExtras;
      if (localObject2 == null) {
        localNetworkExtras = null;
      } else {
        localNetworkExtras = (NetworkExtras)this.c.getNetworkExtras((Class)localObject2);
      }
      localObject2 = new MediationAdRequest(this.c, localActivity, this.e);
      if (!this.a.a.a())
      {
        if ((paramMediationAdapter instanceof MediationBannerAdapter))
        {
          MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)paramMediationAdapter;
          j localj = new j(this.a);
          AdSize localAdSize = this.a.a.b();
          localMediationBannerAdapter.requestBannerAd(localj, localActivity, (MediationServerParameters)localObject1, localAdSize, (MediationAdRequest)localObject2, localNetworkExtras);
        }
        else
        {
          throw new a("Adapter " + this.b + " doesn't support the MediationBannerAdapter interface");
        }
      }
      else
      {
        if (!(paramMediationAdapter instanceof MediationInterstitialAdapter)) {
          break label255;
        }
        ((MediationInterstitialAdapter)paramMediationAdapter).requestInterstitialAd(new k(this.a), localActivity, (MediationServerParameters)localObject1, (MediationAdRequest)localObject2, localNetworkExtras);
      }
      this.a.k();
      return;
      label255:
      throw new a("Adapter " + this.b + " doesn't support the MediationInterstitialAdapter" + " interface.");
    }
    throw new a("Activity became null while trying to instantiate adapter.");
  }
  
  private void a(String paramString, Throwable paramThrowable, g.a parama)
  {
    b.b(paramString, paramThrowable);
    this.a.a(false, parama);
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    String str = (String)paramMap.remove("gwhirl_share_location");
    boolean bool;
    if (!"1".equals(str))
    {
      if ((str != null) && (!"0".equals(str))) {
        b.b("Received an illegal value, '" + str + "', for the special share location parameter from mediation server" + " (expected '0' or '1'). Will not share the location.");
      }
      bool = false;
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public void run()
  {
    try
    {
      b.a("Trying to instantiate: " + this.b);
      a((MediationAdapter)g.a(this.b, MediationAdapter.class));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        a("Cannot find adapter class '" + this.b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", localClassNotFoundException, g.a.e);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a("Error while creating adapter and loading ad from ad network. Skipping ad network.", localThrowable, g.a.f);
      }
    }
  }
  
  private static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.i
 * JD-Core Version:    0.7.0.1
 */