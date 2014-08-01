package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class lt
  extends g<lo>
{
  private static lt akK;
  
  protected lt()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  public static ll a(Activity paramActivity, c paramc, WalletFragmentOptions paramWalletFragmentOptions, lm paramlm)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      ll localll = ((lo)ne().D(paramActivity)).a(e.h(paramActivity), paramc, paramWalletFragmentOptions, paramlm);
      return localll;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
    catch (g.a locala)
    {
      throw new RuntimeException(locala);
    }
  }
  
  private static lt ne()
  {
    if (akK == null) {
      akK = new lt();
    }
    return akK;
  }
  
  protected lo bv(IBinder paramIBinder)
  {
    return lo.a.br(paramIBinder);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lt
 * JD-Core Version:    0.7.0.1
 */