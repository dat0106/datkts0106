package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  public static void a(c paramc)
  {
    try
    {
      CameraUpdateFactory.a(paramc.jC());
      BitmapDescriptorFactory.a(paramc.jD());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static int initialize(Context paramContext)
  {
    hn.f(paramContext);
    try
    {
      c localc = u.E(paramContext);
      a(localc);
      i = 0;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        int i;
        int j = localGooglePlayServicesNotAvailableException.errorCode;
      }
    }
    return i;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapsInitializer
 * JD-Core Version:    0.7.0.1
 */