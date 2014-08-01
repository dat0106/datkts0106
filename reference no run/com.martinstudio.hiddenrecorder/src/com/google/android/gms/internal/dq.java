package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class dq
{
  public static en a(Context paramContext, dt paramdt, a parama)
  {
    en localen;
    if (!paramdt.kO.sw) {
      localen = c(paramContext, paramdt, parama);
    } else {
      localen = b(paramContext, paramdt, parama);
    }
    return localen;
  }
  
  private static en b(Context paramContext, dt paramdt, a parama)
  {
    ev.z("Fetching ad response from local ad request service.");
    dr.a locala = new dr.a(paramContext, paramdt, parama);
    locala.start();
    return locala;
  }
  
  private static en c(Context paramContext, dt paramdt, a parama)
  {
    ev.z("Fetching ad response from remote ad request service.");
    dr.b localb;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      localb = new dr.b(paramContext, paramdt, parama);
    }
    else
    {
      ev.D("Failed to connect to remote ad request service.");
      localb = null;
    }
    return localb;
  }
  
  public static abstract interface a
  {
    public abstract void a(dv paramdv);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dq
 * JD-Core Version:    0.7.0.1
 */