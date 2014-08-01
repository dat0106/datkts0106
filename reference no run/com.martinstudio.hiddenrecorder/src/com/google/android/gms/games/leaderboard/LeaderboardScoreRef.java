package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef
  extends d
  implements LeaderboardScore
{
  private final PlayerRef SD;
  
  LeaderboardScoreRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.SD = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardScoreEntity.a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return getString("display_rank");
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    a("display_rank", paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return getString("display_score");
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    a("display_score", paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return getLong("rank");
  }
  
  public long getRawScore()
  {
    return getLong("raw_score");
  }
  
  public Player getScoreHolder()
  {
    PlayerRef localPlayerRef;
    if (!ax("external_player_id")) {
      localPlayerRef = this.SD;
    } else {
      localPlayerRef = null;
    }
    return localPlayerRef;
  }
  
  public String getScoreHolderDisplayName()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.SD.getDisplayName();
    } else {
      str = getString("default_display_name");
    }
    return str;
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (!ax("external_player_id")) {
      this.SD.getDisplayName(paramCharArrayBuffer);
    } else {
      a("default_display_name", paramCharArrayBuffer);
    }
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    Uri localUri;
    if (!ax("external_player_id")) {
      localUri = this.SD.getHiResImageUri();
    } else {
      localUri = null;
    }
    return localUri;
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.SD.getHiResImageUrl();
    } else {
      str = null;
    }
    return str;
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    Uri localUri;
    if (!ax("external_player_id")) {
      localUri = this.SD.getIconImageUri();
    } else {
      localUri = aw("default_display_image_uri");
    }
    return localUri;
  }
  
  public String getScoreHolderIconImageUrl()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.SD.getIconImageUrl();
    } else {
      str = getString("default_display_image_url");
    }
    return str;
  }
  
  public String getScoreTag()
  {
    return getString("score_tag");
  }
  
  public long getTimestampMillis()
  {
    return getLong("achieved_timestamp");
  }
  
  public int hashCode()
  {
    return LeaderboardScoreEntity.a(this);
  }
  
  public LeaderboardScore ix()
  {
    return new LeaderboardScoreEntity(this);
  }
  
  public String toString()
  {
    return LeaderboardScoreEntity.b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardScoreRef
 * JD-Core Version:    0.7.0.1
 */