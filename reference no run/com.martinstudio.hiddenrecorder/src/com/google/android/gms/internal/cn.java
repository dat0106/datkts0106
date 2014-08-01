package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class cn
  extends g<cp>
{
  private static final cn oQ = new cn();
  
  private cn()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static co a(Activity paramActivity)
  {
    co localco;
    try
    {
      Object localObject;
      if (b(paramActivity))
      {
        ev.z("Using AdOverlay from the client jar.");
        localObject = new cg(paramActivity);
      }
      else
      {
        localObject = oQ.c(paramActivity);
        localObject = localObject;
      }
    }
    catch (a locala)
    {
      ev.D(locala.getMessage());
      localco = null;
    }
    return localco;
  }
  
  private static boolean b(Activity paramActivity)
    throws cn.a
  {
    Intent localIntent = paramActivity.getIntent();
    if (localIntent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
    }
    throw new a("Ad overlay requires the useClientJar flag in intent extras.");
  }
  
  private co c(Activity paramActivity)
  {
    try
    {
      localObject1 = e.h(paramActivity);
      localObject1 = co.a.m(((cp)D(paramActivity)).a((d)localObject1));
      localObject1 = localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Object localObject1;
        ev.c("Could not create remote AdOverlay.", localRemoteException);
        Object localObject2 = null;
      }
    }
    catch (g.a locala)
    {
      for (;;)
      {
        ev.c("Could not create remote AdOverlay.", locala);
        Object localObject3 = null;
      }
    }
    return localObject1;
  }
  
  protected cp l(IBinder paramIBinder)
  {
    return cp.a.n(paramIBinder);
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
 * Qualified Name:     com.google.android.gms.internal.cn
 * JD-Core Version:    0.7.0.1
 */