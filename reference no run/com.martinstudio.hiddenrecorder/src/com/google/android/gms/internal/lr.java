package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.b;

public class lr
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ls paramAnonymousls)
      {
        paramAnonymousls.d(paramString1, paramString2, paramInt);
        b(Status.Ek);
      }
    });
  }
  
  public void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ls paramAnonymousls)
      {
        paramAnonymousls.dQ(paramInt);
        b(Status.Ek);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ls paramAnonymousls)
      {
        paramAnonymousls.a(paramFullWalletRequest, paramInt);
        b(Status.Ek);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ls paramAnonymousls)
      {
        paramAnonymousls.a(paramMaskedWalletRequest, paramInt);
        b(Status.Ek);
      }
    });
  }
  
  public void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, final NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ls paramAnonymousls)
      {
        paramAnonymousls.a(paramNotifyTransactionStatusRequest);
        b(Status.Ek);
      }
    });
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lr
 * JD-Core Version:    0.7.0.1
 */