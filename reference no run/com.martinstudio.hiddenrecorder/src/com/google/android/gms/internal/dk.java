package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public class dk
  implements InAppPurchaseResult
{
  private final dg pu;
  
  public dk(dg paramdg)
  {
    this.pu = paramdg;
  }
  
  public void finishPurchase()
  {
    try
    {
      this.pu.finishPurchase();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward finishPurchase to InAppPurchaseResult", localRemoteException);
      }
    }
  }
  
  public String getProductId()
  {
    try
    {
      str = this.pu.getProductId();
      str = str;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String str;
        ev.c("Could not forward getProductId to InAppPurchaseResult", localRemoteException);
        Object localObject = null;
      }
    }
    return str;
  }
  
  public Intent getPurchaseData()
  {
    try
    {
      localIntent = this.pu.getPurchaseData();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Intent localIntent;
        ev.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
        Object localObject = null;
      }
    }
    return localIntent;
  }
  
  public int getResultCode()
  {
    try
    {
      i = this.pu.getResultCode();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        int i;
        ev.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
        int j = 0;
      }
    }
    return i;
  }
  
  public boolean isVerified()
  {
    try
    {
      bool = this.pu.isVerified();
      bool = bool;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool;
        ev.c("Could not forward isVerified to InAppPurchaseResult", localRemoteException);
        int i = 0;
      }
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dk
 * JD-Core Version:    0.7.0.1
 */