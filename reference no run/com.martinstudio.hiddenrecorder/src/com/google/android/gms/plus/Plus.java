package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.km;
import com.google.android.gms.internal.kn;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.HashSet;
import java.util.Set;

public final class Plus
{
  public static final Api<PlusOptions> API;
  public static final Account AccountApi = new kj();
  public static final Moments MomentsApi;
  public static final People PeopleApi;
  public static final Scope SCOPE_PLUS_LOGIN;
  public static final Scope SCOPE_PLUS_PROFILE;
  public static final b abm = new kl();
  public static final a abn = new kk();
  public static final Api.c<e> yE = new Api.c();
  static final Api.b<e, PlusOptions> yF = new Api.b()
  {
    public e a(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Plus.PlusOptions paramAnonymousPlusOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      if (paramAnonymousPlusOptions == null) {
        paramAnonymousPlusOptions = new Plus.PlusOptions(null);
      }
      e locale = new e(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, new h(paramAnonymousgz.fe(), paramAnonymousgz.fh(), (String[])paramAnonymousPlusOptions.abp.toArray(new String[0]), new String[0], paramAnonymousContext.getPackageName(), paramAnonymousContext.getPackageName(), null, new PlusCommonExtras()));
      return locale;
    }
    
    public int getPriority()
    {
      return 2;
    }
  };
  
  static
  {
    API = new Api(yF, yE, new Scope[0]);
    SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    MomentsApi = new km();
    PeopleApi = new kn();
  }
  
  public static e a(GoogleApiClient paramGoogleApiClient, Api.c<e> paramc)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramGoogleApiClient == null) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.b(bool2, "GoogleApiClient parameter is required.");
    hn.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
    e locale = (e)paramGoogleApiClient.a(paramc);
    if (locale == null) {
      bool1 = false;
    }
    hn.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
    return locale;
  }
  
  public static abstract class a<R extends Result>
    extends a.b<R, e>
  {
    public a()
    {
      super();
    }
  }
  
  public static final class PlusOptions
    implements Api.ApiOptions.Optional
  {
    final String abo;
    final Set<String> abp;
    
    private PlusOptions()
    {
      this.abo = null;
      this.abp = new HashSet();
    }
    
    private PlusOptions(Builder paramBuilder)
    {
      this.abo = paramBuilder.abo;
      this.abp = paramBuilder.abp;
    }
    
    public static Builder builder()
    {
      return new Builder();
    }
    
    public static final class Builder
    {
      String abo;
      final Set<String> abp = new HashSet();
      
      public Builder addActivityTypes(String... paramVarArgs)
      {
        hn.b(paramVarArgs, "activityTypes may not be null.");
        for (int i = 0;; i++)
        {
          if (i >= paramVarArgs.length) {
            return this;
          }
          this.abp.add(paramVarArgs[i]);
        }
      }
      
      public Plus.PlusOptions build()
      {
        return new Plus.PlusOptions(this, null);
      }
      
      public Builder setServerClientId(String paramString)
      {
        this.abo = paramString;
        return this;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.Plus
 * JD-Core Version:    0.7.0.1
 */