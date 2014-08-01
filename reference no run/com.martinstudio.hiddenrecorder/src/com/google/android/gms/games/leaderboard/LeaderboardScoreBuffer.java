package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer
  extends DataBuffer<LeaderboardScore>
{
  private final LeaderboardScoreBufferHeader Sq;
  
  public LeaderboardScoreBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.Sq = new LeaderboardScoreBufferHeader(paramDataHolder.eP());
  }
  
  public LeaderboardScore get(int paramInt)
  {
    return new LeaderboardScoreRef(this.DD, paramInt);
  }
  
  public LeaderboardScoreBufferHeader iv()
  {
    return this.Sq;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
 * JD-Core Version:    0.7.0.1
 */