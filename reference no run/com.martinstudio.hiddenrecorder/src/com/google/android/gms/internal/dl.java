package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

public class dl
  implements InAppPurchase
{
  private final dc pg;
  
  public dl(dc paramdc)
  {
    this.pg = paramdc;
  }
  
  public String getProductId()
  {
    try
    {
      str = this.pg.getProductId();
      str = str;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String str;
        ev.c("Could not forward getProductId to InAppPurchase", localRemoteException);
        Object localObject = null;
      }
    }
    return str;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      this.pg.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
      }
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      this.pg.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward recordResolution to InAppPurchase", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.7.0.1
 */