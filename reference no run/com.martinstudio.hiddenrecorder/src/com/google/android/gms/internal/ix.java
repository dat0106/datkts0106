package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
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
import com.google.android.gms.identity.intents.UserAddressRequest;

public class ix
  extends hc<iz>
{
  private a UD;
  private final int mTheme;
  private Activity oe;
  private final String yN;
  
  public ix(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, int paramInt)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.yN = paramString;
    this.oe = paramActivity;
    this.mTheme = paramInt;
  }
  
  public void a(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    iP();
    this.UD = new a(paramInt, this.oe);
    try
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(this.yN)) {
        localBundle1.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.yN, "com.google"));
      }
      localBundle1.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
      iO().a(this.UD, paramUserAddressRequest, localBundle1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("AddressClientImpl", "Exception requesting user address", localRemoteException);
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
        this.UD.g(1, localBundle2);
      }
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.d(parame, 5077000, getContext().getPackageName());
  }
  
  protected iz an(IBinder paramIBinder)
  {
    return iz.a.ap(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.identity.service.BIND";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }
  
  public void disconnect()
  {
    super.disconnect();
    if (this.UD != null)
    {
      a.a(this.UD, null);
      this.UD = null;
    }
  }
  
  protected iz iO()
  {
    return (iz)super.fo();
  }
  
  protected void iP()
  {
    super.ci();
  }
  
  public static final class a
    extends iy.a
  {
    private final int FT;
    private Activity oe;
    
    public a(int paramInt, Activity paramActivity)
    {
      this.FT = paramInt;
      this.oe = paramActivity;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.oe = paramActivity;
    }
    
    public void g(int paramInt, Bundle paramBundle)
    {
      Object localObject1;
      if (paramInt == 1)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramBundle);
        localObject1 = this.oe.createPendingResult(this.FT, (Intent)localObject1, 1073741824);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        return;
        try
        {
          ((PendingIntent)localObject1).send(1);
        }
        catch (PendingIntent.CanceledException localCanceledException1)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", localCanceledException1);
        }
        continue;
        Object localObject2 = null;
        if (paramBundle != null) {
          localObject2 = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        }
        localObject2 = new ConnectionResult(paramInt, (PendingIntent)localObject2);
        if (((ConnectionResult)localObject2).hasResolution()) {
          try
          {
            ((ConnectionResult)localObject2).startResolutionForResult(this.oe, this.FT);
          }
          catch (IntentSender.SendIntentException localSendIntentException)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", localSendIntentException);
          }
        } else {
          try
          {
            PendingIntent localPendingIntent = this.oe.createPendingResult(this.FT, new Intent(), 1073741824);
            if (localPendingIntent != null) {
              localPendingIntent.send(1);
            }
          }
          catch (PendingIntent.CanceledException localCanceledException2)
          {
            Log.w("AddressClientImpl", "Exception setting pending result", localCanceledException2);
          }
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ix
 * JD-Core Version:    0.7.0.1
 */