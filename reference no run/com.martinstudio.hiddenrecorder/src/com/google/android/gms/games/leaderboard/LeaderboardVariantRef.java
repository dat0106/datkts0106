package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class LeaderboardVariantRef
  extends d
  implements LeaderboardVariant
{
  LeaderboardVariantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardVariantEntity.a(this, paramObject);
  }
  
  public int getCollection()
  {
    return getInteger("collection");
  }
  
  public String getDisplayPlayerRank()
  {
    return getString("player_display_rank");
  }
  
  public String getDisplayPlayerScore()
  {
    return getString("player_display_score");
  }
  
  public long getNumScores()
  {
    long l;
    if (!ax("total_scores")) {
      l = getLong("total_scores");
    } else {
      l = -1L;
    }
    return l;
  }
  
  public long getPlayerRank()
  {
    long l;
    if (!ax("player_rank")) {
      l = getLong("player_rank");
    } else {
      l = -1L;
    }
    return l;
  }
  
  public String getPlayerScoreTag()
  {
    return getString("player_score_tag");
  }
  
  public long getRawPlayerScore()
  {
    long l;
    if (!ax("player_raw_score")) {
      l = getLong("player_raw_score");
    } else {
      l = -1L;
    }
    return l;
  }
  
  public int getTimeSpan()
  {
    return getInteger("timespan");
  }
  
  public boolean hasPlayerInfo()
  {
    boolean bool;
    if (ax("player_raw_score")) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return LeaderboardVariantEntity.a(this);
  }
  
  public String iA()
  {
    return getString("window_page_token_next");
  }
  
  public LeaderboardVariant iB()
  {
    return new LeaderboardVariantEntity(this);
  }
  
  public String iy()
  {
    return getString("top_page_token_next");
  }
  
  public String iz()
  {
    return getString("window_page_token_prev");
  }
  
  public String toString()
  {
    return LeaderboardVariantEntity.b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardVariantRef
 * JD-Core Version:    0.7.0.1
 */