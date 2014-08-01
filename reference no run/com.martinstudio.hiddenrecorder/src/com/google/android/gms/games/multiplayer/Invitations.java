package com.google.android.gms.games.multiplayer;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Invitations
{
  public abstract Intent getInvitationInboxIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract void registerInvitationListener(GoogleApiClient paramGoogleApiClient, OnInvitationReceivedListener paramOnInvitationReceivedListener);
  
  public abstract void unregisterInvitationListener(GoogleApiClient paramGoogleApiClient);
  
  public static abstract interface LoadInvitationsResult
    extends Releasable, Result
  {
    public abstract InvitationBuffer getInvitations();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Invitations
 * JD-Core Version:    0.7.0.1
 */