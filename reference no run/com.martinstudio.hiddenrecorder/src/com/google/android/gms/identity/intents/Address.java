package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.ix;

public final class Address
{
  public static final Api<AddressOptions> API = new Api(yF, yE, new Scope[0]);
  static final Api.c<ix> yE = new Api.c();
  private static final Api.b<ix, AddressOptions> yF = new Api.b()
  {
    public ix a(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      hn.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      if (paramAnonymousAddressOptions == null) {
        paramAnonymousAddressOptions = new Address.AddressOptions();
      }
      return new ix((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousgz.getAccountName(), paramAnonymousAddressOptions.theme);
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  
  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(ix paramAnonymousix)
        throws RemoteException
      {
        paramAnonymousix.a(Address.this, paramInt);
        b(Status.Ek);
      }
    });
  }
  
  private static abstract class a
    extends a.b<Status, ix>
  {
    public a()
    {
      super();
    }
    
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  public static final class AddressOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int theme;
    
    public AddressOptions()
    {
      this.theme = 0;
    }
    
    public AddressOptions(int paramInt)
    {
      this.theme = paramInt;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.Address
 * JD-Core Version:    0.7.0.1
 */