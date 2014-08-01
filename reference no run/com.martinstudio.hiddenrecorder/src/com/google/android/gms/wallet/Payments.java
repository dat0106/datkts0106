package com.google.android.gms.wallet;

import com.google.android.gms.common.api.GoogleApiClient;

public abstract interface Payments
{
  public abstract void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt);
  
  public abstract void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract void loadFullWallet(GoogleApiClient paramGoogleApiClient, FullWalletRequest paramFullWalletRequest, int paramInt);
  
  public abstract void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, MaskedWalletRequest paramMaskedWalletRequest, int paramInt);
  
  public abstract void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.Payments
 * JD-Core Version:    0.7.0.1
 */