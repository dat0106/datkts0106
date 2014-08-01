package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl
  implements Requests
{
  public PendingResult<Requests.UpdateRequestsResult> acceptRequest(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return acceptRequests(paramGoogleApiClient, localArrayList);
  }
  
  public PendingResult<Requests.UpdateRequestsResult> acceptRequests(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    final String[] arrayOfString;
    if (paramList != null) {
      arrayOfString = (String[])paramList.toArray(new String[paramList.size()]);
    } else {
      arrayOfString = null;
    }
    paramGoogleApiClient.b(new UpdateRequestsImpl(arrayOfString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.b(this, arrayOfString);
      }
    });
  }
  
  public PendingResult<Requests.UpdateRequestsResult> dismissRequest(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return dismissRequests(paramGoogleApiClient, localArrayList);
  }
  
  public PendingResult<Requests.UpdateRequestsResult> dismissRequests(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    final String[] arrayOfString;
    if (paramList != null) {
      arrayOfString = (String[])paramList.toArray(new String[paramList.size()]);
    } else {
      arrayOfString = null;
    }
    paramGoogleApiClient.b(new UpdateRequestsImpl(arrayOfString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.c(this, arrayOfString);
      }
    });
  }
  
  public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("requests")))
    {
      ArrayList localArrayList3 = (ArrayList)paramBundle.get("requests");
      ArrayList localArrayList2 = new ArrayList();
      int j = localArrayList3.size();
      for (int i = 0;; localArrayList1++)
      {
        if (i >= j)
        {
          localArrayList1 = localArrayList2;
          break;
        }
        localArrayList2.add((GameRequest)localArrayList3.get(localArrayList1));
      }
    }
    ArrayList localArrayList1 = new ArrayList();
    return localArrayList1;
  }
  
  public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent paramIntent)
  {
    ArrayList localArrayList;
    if (paramIntent != null) {
      localArrayList = getGameRequestsFromBundle(paramIntent.getExtras());
    } else {
      localArrayList = new ArrayList();
    }
    return localArrayList;
  }
  
  public Intent getInboxIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hl();
  }
  
  public int getMaxLifetimeDays(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hn();
  }
  
  public int getMaxPayloadSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hm();
  }
  
  public Intent getSendIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    return Games.c(paramGoogleApiClient).a(paramInt1, paramArrayOfByte, paramInt2, paramBitmap, paramString);
  }
  
  public PendingResult<Requests.LoadRequestsResult> loadRequests(GoogleApiClient paramGoogleApiClient, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    paramGoogleApiClient.a(new LoadRequestsImpl(paramInt1)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramInt1, paramInt2, paramInt3);
      }
    });
  }
  
  public void registerRequestListener(GoogleApiClient paramGoogleApiClient, OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    Games.c(paramGoogleApiClient).a(paramOnRequestReceivedListener);
  }
  
  public void unregisterRequestListener(GoogleApiClient paramGoogleApiClient)
  {
    Games.c(paramGoogleApiClient).hf();
  }
  
  private static abstract class LoadRequestSummariesImpl
    extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestSummariesResult>
  {
    public Requests.LoadRequestSummariesResult V(final Status paramStatus)
    {
      new Requests.LoadRequestSummariesResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class SendRequestImpl
    extends Games.BaseGamesApiMethodImpl<Requests.SendRequestResult>
  {
    public Requests.SendRequestResult X(final Status paramStatus)
    {
      new Requests.SendRequestResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class UpdateRequestsImpl
    extends Games.BaseGamesApiMethodImpl<Requests.UpdateRequestsResult>
  {
    public Requests.UpdateRequestsResult Y(final Status paramStatus)
    {
      new Requests.UpdateRequestsResult()
      {
        public Set<String> getRequestIds()
        {
          return null;
        }
        
        public int getRequestOutcome(String paramAnonymousString)
        {
          throw new IllegalArgumentException("Unknown request ID " + paramAnonymousString);
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class LoadRequestsImpl
    extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestsResult>
  {
    public Requests.LoadRequestsResult W(final Status paramStatus)
    {
      new Requests.LoadRequestsResult()
      {
        public GameRequestBuffer getRequests(int paramAnonymousInt)
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.RequestsImpl
 * JD-Core Version:    0.7.0.1
 */