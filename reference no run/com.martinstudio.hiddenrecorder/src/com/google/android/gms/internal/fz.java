package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.d;
import java.util.List;

public final class fz
  implements AppIndexApi, fu
{
  static Uri a(String paramString, Uri paramUri)
  {
    if ("android-app".equals(paramUri.getScheme()))
    {
      if (paramString.equals(paramUri.getHost()))
      {
        List localList = paramUri.getPathSegments();
        if ((!localList.isEmpty()) && (!((String)localList.get(0)).isEmpty()))
        {
          String str = (String)localList.get(0);
          Uri.Builder localBuilder = new Uri.Builder();
          localBuilder.scheme(str);
          if (localList.size() > 1) {
            localBuilder.authority((String)localList.get(1));
          }
          for (int i = 2;; i++)
          {
            if (i >= localList.size())
            {
              localBuilder.encodedQuery(paramUri.getEncodedQuery());
              localBuilder.encodedFragment(paramUri.getEncodedFragment());
              return localBuilder.build();
            }
            localBuilder.appendPath((String)localList.get(i));
          }
        }
        throw new IllegalArgumentException("Uri path must exist: " + paramUri);
      }
      throw new IllegalArgumentException("Uri host must match package name: " + paramUri);
    }
    throw new IllegalArgumentException("Uri scheme must be android-app: " + paramUri);
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final fs... paramVarArgs)
  {
    paramGoogleApiClient.a(new d(((fy)paramGoogleApiClient.a(fg.xF)).getContext().getPackageName())
    {
      protected void a(fv paramAnonymousfv)
        throws RemoteException
      {
        paramAnonymousfv.a(new fz.e(this), this.yt, paramVarArgs);
      }
    });
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent, String paramString, Uri paramUri, List<AppIndexApi.AppIndexingLink> paramList)
  {
    String str = ((fy)paramGoogleApiClient.a(fg.xF)).getContext().getPackageName();
    fs[] arrayOffs = new fs[1];
    arrayOffs[0] = new fs(str, paramIntent, paramString, paramUri, null, paramList);
    return a(paramGoogleApiClient, arrayOffs);
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri1, String paramString, Uri paramUri2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    return view(paramGoogleApiClient, paramActivity, new Intent("android.intent.action.VIEW", a(((fy)paramGoogleApiClient.a(fg.xF)).getContext().getPackageName(), paramUri1)), paramString, paramUri2, paramList);
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent)
  {
    fs localfs = new fs(fs.a(((fy)paramGoogleApiClient.a(fg.xF)).getContext().getPackageName(), paramIntent), System.currentTimeMillis(), 3);
    fs[] arrayOffs = new fs[1];
    arrayOffs[0] = localfs;
    return a(paramGoogleApiClient, arrayOffs);
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri)
  {
    return viewEnd(paramGoogleApiClient, paramActivity, new Intent("android.intent.action.VIEW", a(((fy)paramGoogleApiClient.a(fg.xF)).getContext().getPackageName(), paramUri)));
  }
  
  static class b
    extends fz.a<ParcelFileDescriptor>
    implements fu.a
  {
    public b(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      super(paramParcelFileDescriptor);
    }
  }
  
  private static abstract class a<T>
    implements Result
  {
    private final Status yw;
    protected final T yx;
    
    public a(Status paramStatus, T paramT)
    {
      this.yw = paramStatus;
      this.yx = paramT;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class e
    extends fx<Status>
  {
    public e(a.d<Status> paramd)
    {
      super();
    }
    
    public void a(Status paramStatus)
    {
      this.yr.a(paramStatus);
    }
  }
  
  private static abstract class d<T extends Result>
    extends fz.c<Status>
  {
    protected Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static abstract class c<T extends Result>
    extends a.b<T, fy>
  {
    public c()
    {
      super();
    }
    
    protected abstract void a(fv paramfv)
      throws RemoteException;
    
    protected final void a(fy paramfy)
      throws RemoteException
    {
      a(paramfy.dM());
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fz
 * JD-Core Version:    0.7.0.1
 */