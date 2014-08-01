package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jh;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(yF, yE, new Scope[0]);
  public static ActivityRecognitionApi ActivityRecognitionApi = new jb();
  public static final String CLIENT_NAME = "activity_recognition";
  private static final Api.c<jh> yE = new Api.c();
  private static final Api.b<jh, Api.ApiOptions.NoOptions> yF = new Api.b()
  {
    public jh c(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new jh(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "activity_recognition");
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  
  public static abstract class a<R extends Result>
    extends a.b<R, jh>
  {
    public a()
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognition
 * JD-Core Version:    0.7.0.1
 */