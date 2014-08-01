package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer Ts;
  private final TurnBasedMatchBuffer Tt;
  private final TurnBasedMatchBuffer Tu;
  private final TurnBasedMatchBuffer Tv;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = a(paramBundle, 0);
    if (localDataHolder == null) {
      this.Ts = null;
    } else {
      this.Ts = new InvitationBuffer(localDataHolder);
    }
    localDataHolder = a(paramBundle, 1);
    if (localDataHolder == null) {
      this.Tt = null;
    } else {
      this.Tt = new TurnBasedMatchBuffer(localDataHolder);
    }
    localDataHolder = a(paramBundle, 2);
    if (localDataHolder == null) {
      this.Tu = null;
    } else {
      this.Tu = new TurnBasedMatchBuffer(localDataHolder);
    }
    localDataHolder = a(paramBundle, 3);
    if (localDataHolder == null) {
      this.Tv = null;
    } else {
      this.Tv = new TurnBasedMatchBuffer(localDataHolder);
    }
  }
  
  private static DataHolder a(Bundle paramBundle, int paramInt)
  {
    Object localObject = TurnBasedMatchTurnStatus.cm(paramInt);
    if (paramBundle.containsKey((String)localObject)) {
      localObject = (DataHolder)paramBundle.getParcelable((String)localObject);
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  public void close()
  {
    if (this.Ts != null) {
      this.Ts.close();
    }
    if (this.Tt != null) {
      this.Tt.close();
    }
    if (this.Tu != null) {
      this.Tu.close();
    }
    if (this.Tv != null) {
      this.Tv.close();
    }
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.Tv;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.Ts;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.Tt;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.Tu;
  }
  
  public boolean hasData()
  {
    boolean bool = true;
    if (((this.Ts == null) || (this.Ts.getCount() <= 0)) && ((this.Tt == null) || (this.Tt.getCount() <= 0)) && ((this.Tu == null) || (this.Tu.getCount() <= 0)) && ((this.Tv == null) || (this.Tv.getCount() <= 0))) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse
 * JD-Core Version:    0.7.0.1
 */