package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;
import com.google.android.gms.panorama.PanoramaApi.a;

public class kg
  implements PanoramaApi
{
  private static void a(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void a(Context paramContext, kf paramkf, final ke paramke, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    ke.a local4 = new ke.a()
    {
      public void a(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        kg.b(kg.this, paramUri);
        paramke.a(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramkf.a(local4, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a(paramContext, paramUri);
      throw localRemoteException;
    }
    catch (RuntimeException localRuntimeException)
    {
      a(paramContext, paramUri);
      throw localRuntimeException;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, kf paramAnonymouskf)
        throws RemoteException
      {
        paramAnonymouskf.a(new kg.c(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.a(new b(paramUri)
    {
      protected void a(Context paramAnonymousContext, kf paramAnonymouskf)
        throws RemoteException
      {
        kg.b(paramAnonymousContext, paramAnonymouskf, new kg.c(this), paramUri, null);
      }
    });
  }
  
  private static final class c
    extends ke.a
  {
    private final a.d<PanoramaApi.PanoramaResult> yO;
    
    public c(a.d<PanoramaApi.PanoramaResult> paramd)
    {
      this.yO = paramd;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle == null) {
        localObject = null;
      } else {
        localObject = (PendingIntent)paramBundle.getParcelable("pendingIntent");
      }
      Object localObject = new Status(paramInt1, null, (PendingIntent)localObject);
      this.yO.a(new ki((Status)localObject, paramIntent));
    }
  }
  
  private static final class a
    extends ke.a
  {
    private final a.d<PanoramaApi.a> yO;
    
    public a(a.d<PanoramaApi.a> paramd)
    {
      this.yO = paramd;
    }
    
    public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle == null) {
        localObject = null;
      } else {
        localObject = (PendingIntent)paramBundle.getParcelable("pendingIntent");
      }
      Object localObject = new Status(paramInt1, null, (PendingIntent)localObject);
      this.yO.a(new kd((Status)localObject, paramIntent, paramInt2));
    }
  }
  
  private static abstract class b
    extends kg.d<PanoramaApi.PanoramaResult>
  {
    protected PanoramaApi.PanoramaResult ak(Status paramStatus)
    {
      return new ki(paramStatus, null);
    }
  }
  
  private static abstract class d<R extends Result>
    extends a.b<R, kh>
  {
    protected d()
    {
      super();
    }
    
    protected abstract void a(Context paramContext, kf paramkf)
      throws RemoteException;
    
    protected final void a(kh paramkh)
      throws RemoteException
    {
      a(paramkh.getContext(), (kf)paramkh.fo());
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kg
 * JD-Core Version:    0.7.0.1
 */