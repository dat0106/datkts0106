package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
  implements Events
{
  public void increment(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    GamesClientImpl localGamesClientImpl = Games.d(paramGoogleApiClient);
    if (!localGamesClientImpl.isConnected()) {
      paramGoogleApiClient.b(new UpdateImpl(paramString)
      {
        public void a(GamesClientImpl paramAnonymousGamesClientImpl)
        {
          paramAnonymousGamesClientImpl.l(paramString, paramInt);
        }
      });
    } else {
      localGamesClientImpl.l(paramString, paramInt);
    }
  }
  
  public PendingResult<Events.LoadEventsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadImpl(paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.d(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final String... paramVarArgs)
  {
    paramGoogleApiClient.a(new LoadImpl(paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramBoolean, paramVarArgs);
      }
    });
  }
  
  private static abstract class UpdateImpl
    extends Games.BaseGamesApiMethodImpl<Result>
  {
    public Result c(final Status paramStatus)
    {
      new Result()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadImpl
    extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult>
  {
    public Events.LoadEventsResult A(final Status paramStatus)
    {
      new Events.LoadEventsResult()
      {
        public EventBuffer getEvents()
        {
          return new EventBuffer(DataHolder.af(14));
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
 * Qualified Name:     com.google.android.gms.games.internal.api.EventsImpl
 * JD-Core Version:    0.7.0.1
 */