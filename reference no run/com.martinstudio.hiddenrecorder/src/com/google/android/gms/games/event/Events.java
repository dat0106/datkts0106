package com.google.android.gms.games.event;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Events
{
  public abstract void increment(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<LoadEventsResult> load(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult<LoadEventsResult> loadByIds(GoogleApiClient paramGoogleApiClient, boolean paramBoolean, String... paramVarArgs);
  
  public static abstract interface LoadEventsResult
    extends Releasable, Result
  {
    public abstract EventBuffer getEvents();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.Events
 * JD-Core Version:    0.7.0.1
 */