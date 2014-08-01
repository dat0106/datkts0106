package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ai
  extends g<as>
{
  private static final ai lP = new ai();
  
  private ai()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static ar a(Context paramContext, am paramam, String paramString, bt parambt)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      localObject = lP.b(paramContext, paramam, paramString, parambt);
      if (localObject != null) {}
    }
    else
    {
      ev.z("Using AdManager from the client jar.");
      localObject = new v(paramContext, paramam, paramString, parambt, new ew(5077000, 5077000, true));
    }
    return localObject;
  }
  
  private ar b(Context paramContext, am paramam, String paramString, bt parambt)
  {
    try
    {
      localObject1 = e.h(paramContext);
      localObject1 = ar.a.f(((as)D(paramContext)).a((d)localObject1, paramam, paramString, parambt, 5077000));
      localObject1 = localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Object localObject1;
        ev.c("Could not create remote AdManager.", localRemoteException);
        Object localObject2 = null;
      }
    }
    catch (g.a locala)
    {
      for (;;)
      {
        ev.c("Could not create remote AdManager.", locala);
        Object localObject3 = null;
      }
    }
    return localObject1;
  }
  
  protected as c(IBinder paramIBinder)
  {
    return as.a.g(paramIBinder);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.7.0.1
 */