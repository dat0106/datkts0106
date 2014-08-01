package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationServices.a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class jd
  implements GeofencingApi
{
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, final PendingIntent paramPendingIntent)
  {
    Object localObject;
    ArrayList localArrayList;
    Iterator localIterator;
    if (paramList == null)
    {
      localObject = null;
    }
    else
    {
      localArrayList = new ArrayList(paramList.size());
      localIterator = paramList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localObject = localArrayList;
        paramGoogleApiClient.b(new a((List)localObject)
        {
          protected void a(jh paramAnonymousjh)
            throws RemoteException
          {
            LocationClient.OnAddGeofencesResultListener local1 = new LocationClient.OnAddGeofencesResultListener()
            {
              public void onAddGeofencesResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
              {
                jd.1.this.b(LocationStatusCodes.cK(paramAnonymous2Int));
              }
            };
            paramAnonymousjh.addGeofences(this.Vz, paramPendingIntent, local1);
          }
        });
      }
      localObject = (Geofence)localIterator.next();
      hn.b(localObject instanceof ji, "Geofence must be created using Geofence.Builder.");
      localArrayList.add((ji)localObject);
    }
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.b(new a(paramPendingIntent)
    {
      protected void a(jh paramAnonymousjh)
        throws RemoteException
      {
        LocationClient.OnRemoveGeofencesResultListener local1 = new LocationClient.OnRemoveGeofencesResultListener()
        {
          public void onRemoveGeofencesByPendingIntentResult(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            jd.2.this.b(LocationStatusCodes.cK(paramAnonymous2Int));
          }
          
          public void onRemoveGeofencesByRequestIdsResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
          }
        };
        paramAnonymousjh.removeGeofences(paramPendingIntent, local1);
      }
    });
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    paramGoogleApiClient.b(new a(paramList)
    {
      protected void a(jh paramAnonymousjh)
        throws RemoteException
      {
        LocationClient.OnRemoveGeofencesResultListener local1 = new LocationClient.OnRemoveGeofencesResultListener()
        {
          public void onRemoveGeofencesByPendingIntentResult(int paramAnonymous2Int, PendingIntent paramAnonymous2PendingIntent)
          {
            Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
          }
          
          public void onRemoveGeofencesByRequestIdsResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString)
          {
            jd.3.this.b(LocationStatusCodes.cK(paramAnonymous2Int));
          }
        };
        paramAnonymousjh.removeGeofences(paramList, local1);
      }
    });
  }
  
  private static abstract class a
    extends LocationServices.a<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jd
 * JD-Core Version:    0.7.0.1
 */