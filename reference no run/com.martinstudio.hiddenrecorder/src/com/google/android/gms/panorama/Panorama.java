package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.kh;

public final class Panorama
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(yF, yE, new Scope[0]);
  public static final PanoramaApi PanoramaApi = new kg();
  public static final Api.c<kh> yE = new Api.c();
  static final Api.b<kh, Api.ApiOptions.NoOptions> yF = new Api.b()
  {
    public kh d(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new kh(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.panorama.Panorama
 * JD-Core Version:    0.7.0.1
 */