package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class LeaderboardBuffer
  extends g<Leaderboard>
{
  public LeaderboardBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String eU()
  {
    return "external_leaderboard_id";
  }
  
  protected Leaderboard f(int paramInt1, int paramInt2)
  {
    return new LeaderboardRef(this.DD, paramInt1, paramInt2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardBuffer
 * JD-Core Version:    0.7.0.1
 */