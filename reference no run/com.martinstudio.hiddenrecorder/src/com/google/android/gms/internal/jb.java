package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class jb
  implements ActivityRecognitionApi
{
  public PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(jh paramAnonymousjh)
        throws RemoteException
      {
        paramAnonymousjh.removeActivityUpdates(paramPendingIntent);
        b(Status.Ek);
      }
    });
  }
  
  public PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, final long paramLong, PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramLong)
    {
      protected void a(jh paramAnonymousjh)
        throws RemoteException
      {
        paramAnonymousjh.requestActivityUpdates(paramLong, this.Vr);
        b(Status.Ek);
      }
    });
  }
  
  private static abstract class a
    extends ActivityRecognition.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jb
 * JD-Core Version:    0.7.0.1
 */