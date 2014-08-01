package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class ls
  extends hc<ln>
{
  private final int ajY;
  private final int mTheme;
  private final Activity oe;
  private final String yN;
  
  public ls(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.oe = paramActivity;
    this.ajY = paramInt1;
    this.yN = paramString;
    this.mTheme = paramInt2;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
    localBundle.putString("androidPackageName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
    return localBundle;
  }
  
  private Bundle nd()
  {
    return a(this.ajY, this.oe.getPackageName(), this.yN, this.mTheme);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.a(parame, 5077000);
  }
  
  public void a(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    b localb = new b(paramInt);
    Bundle localBundle = nd();
    try
    {
      ((ln)fo()).a(paramFullWalletRequest, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("WalletClientImpl", "RemoteException getting full wallet", localRemoteException);
        localb.a(8, null, Bundle.EMPTY);
      }
    }
  }
  
  public void a(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = nd();
    b localb = new b(paramInt);
    try
    {
      ((ln)fo()).a(paramMaskedWalletRequest, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("WalletClientImpl", "RemoteException getting masked wallet", localRemoteException);
        localb.a(8, null, Bundle.EMPTY);
      }
    }
  }
  
  public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = nd();
    try
    {
      ((ln)fo()).a(paramNotifyTransactionStatusRequest, localBundle);
      label19:
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label19;
    }
  }
  
  protected String bp()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  protected ln bu(IBinder paramIBinder)
  {
    return ln.a.bq(paramIBinder);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = nd();
    b localb = new b(paramInt);
    try
    {
      ((ln)fo()).a(paramString1, paramString2, localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("WalletClientImpl", "RemoteException changing masked wallet", localRemoteException);
        localb.a(8, null, Bundle.EMPTY);
      }
    }
  }
  
  public void dQ(int paramInt)
  {
    Bundle localBundle = nd();
    b localb = new b(paramInt);
    try
    {
      ((ln)fo()).a(localBundle, localb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
        localb.a(8, false, Bundle.EMPTY);
      }
    }
  }
  
  final class b
    extends ls.a
  {
    private final int FT;
    
    public b(int paramInt)
    {
      super();
      this.FT = paramInt;
    }
    
    public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent = null;
      if (paramBundle != null) {
        localPendingIntent = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent);
      if (localConnectionResult.hasResolution()) {}
      for (;;)
      {
        try
        {
          localConnectionResult.startResolutionForResult(ls.b(ls.this), this.FT);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          continue;
        }
        Object localObject = new Intent();
        int i;
        if (localConnectionResult.isSuccess())
        {
          i = -1;
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
          localObject = ls.b(ls.this).createPendingResult(this.FT, (Intent)localObject, 1073741824);
          if (localObject == null) {
            Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
          }
        }
        else
        {
          if (paramInt == 408) {}
          for (i = 0;; i = 1)
          {
            ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
            break;
          }
        }
        try
        {
          ((PendingIntent)localObject).send(i);
        }
        catch (PendingIntent.CanceledException localCanceledException)
        {
          Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
        }
      }
    }
    
    public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent = null;
      if (paramBundle != null) {
        localPendingIntent = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, localPendingIntent);
      if (localConnectionResult.hasResolution()) {}
      for (;;)
      {
        try
        {
          localConnectionResult.startResolutionForResult(ls.b(ls.this), this.FT);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          continue;
        }
        Object localObject = new Intent();
        int i;
        if (localConnectionResult.isSuccess())
        {
          i = -1;
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
          localObject = ls.b(ls.this).createPendingResult(this.FT, (Intent)localObject, 1073741824);
          if (localObject == null) {
            Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
          }
        }
        else
        {
          if (paramInt == 408) {}
          for (i = 0;; i = 1)
          {
            ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
            break;
          }
        }
        try
        {
          ((PendingIntent)localObject).send(i);
        }
        catch (PendingIntent.CanceledException localCanceledException)
        {
          Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
        }
      }
    }
    
    public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
      localObject = ls.b(ls.this).createPendingResult(this.FT, (Intent)localObject, 1073741824);
      if (localObject == null) {
        Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
      }
      for (;;)
      {
        return;
        try
        {
          ((PendingIntent)localObject).send(-1);
        }
        catch (PendingIntent.CanceledException localCanceledException)
        {
          Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
        }
      }
    }
    
    public void i(int paramInt, Bundle paramBundle)
    {
      hn.b(paramBundle, "Bundle should not be null");
      ConnectionResult localConnectionResult = new ConnectionResult(paramInt, (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
      if (localConnectionResult.hasResolution()) {}
      for (;;)
      {
        try
        {
          localConnectionResult.startResolutionForResult(ls.b(ls.this), this.FT);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", localSendIntentException);
          continue;
        }
        Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + localSendIntentException);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
        localObject = ls.b(ls.this).createPendingResult(this.FT, (Intent)localObject, 1073741824);
        if (localObject == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
        } else {
          try
          {
            ((PendingIntent)localObject).send(1);
          }
          catch (PendingIntent.CanceledException localCanceledException)
          {
            Log.w("WalletClientImpl", "Exception setting pending result", localCanceledException);
          }
        }
      }
    }
  }
  
  private static class a
    extends lq.a
  {
    public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {}
    
    public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {}
    
    public void a(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void a(Status paramStatus, lj paramlj, Bundle paramBundle) {}
    
    public void i(int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ls
 * JD-Core Version:    0.7.0.1
 */