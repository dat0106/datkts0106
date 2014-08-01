package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class dj
  extends g<df>
{
  private static final dj pt = new dj();
  
  private dj()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  private static boolean b(Activity paramActivity)
    throws dj.a
  {
    Intent localIntent = paramActivity.getIntent();
    if (localIntent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
      return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
    }
    throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
  }
  
  public static de d(Activity paramActivity)
  {
    de localde;
    try
    {
      Object localObject;
      if (b(paramActivity))
      {
        ev.z("Using AdOverlay from the client jar.");
        localObject = new cv(paramActivity);
      }
      else
      {
        localObject = pt.e(paramActivity);
        localObject = localObject;
      }
    }
    catch (a locala)
    {
      ev.D(locala.getMessage());
      localde = null;
    }
    return localde;
  }
  
  private de e(Activity paramActivity)
  {
    try
    {
      localObject1 = e.h(paramActivity);
      localObject1 = de.a.r(((df)D(paramActivity)).b((d)localObject1));
      localObject1 = localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Object localObject1;
        ev.c("Could not create remote InAppPurchaseManager.", localRemoteException);
        Object localObject2 = null;
      }
    }
    catch (g.a locala)
    {
      for (;;)
      {
        ev.c("Could not create remote InAppPurchaseManager.", locala);
        Object localObject3 = null;
      }
    }
    return localObject1;
  }
  
  protected df v(IBinder paramIBinder)
  {
    return df.a.s(paramIBinder);
  }
  
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dj
 * JD-Core Version:    0.7.0.1
 */