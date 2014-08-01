package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.il;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final String SA;
  private final String SB;
  private final String SC;
  private final long Sr;
  private final String Ss;
  private final String St;
  private final long Su;
  private final long Sv;
  private final String Sw;
  private final Uri Sx;
  private final Uri Sy;
  private final PlayerEntity Sz;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.Sr = paramLeaderboardScore.getRank();
    this.Ss = ((String)hn.f(paramLeaderboardScore.getDisplayRank()));
    this.St = ((String)hn.f(paramLeaderboardScore.getDisplayScore()));
    this.Su = paramLeaderboardScore.getRawScore();
    this.Sv = paramLeaderboardScore.getTimestampMillis();
    this.Sw = paramLeaderboardScore.getScoreHolderDisplayName();
    this.Sx = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.Sy = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject != null) {
      localObject = (PlayerEntity)((Player)localObject).freeze();
    } else {
      localObject = null;
    }
    this.Sz = ((PlayerEntity)localObject);
    this.SA = paramLeaderboardScore.getScoreTag();
    this.SB = paramLeaderboardScore.getScoreHolderIconImageUrl();
    this.SC = paramLeaderboardScore.getScoreHolderHiResImageUrl();
  }
  
  static int a(LeaderboardScore paramLeaderboardScore)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = Long.valueOf(paramLeaderboardScore.getRank());
    arrayOfObject[1] = paramLeaderboardScore.getDisplayRank();
    arrayOfObject[2] = Long.valueOf(paramLeaderboardScore.getRawScore());
    arrayOfObject[3] = paramLeaderboardScore.getDisplayScore();
    arrayOfObject[4] = Long.valueOf(paramLeaderboardScore.getTimestampMillis());
    arrayOfObject[5] = paramLeaderboardScore.getScoreHolderDisplayName();
    arrayOfObject[6] = paramLeaderboardScore.getScoreHolderIconImageUri();
    arrayOfObject[7] = paramLeaderboardScore.getScoreHolderHiResImageUri();
    arrayOfObject[8] = paramLeaderboardScore.getScoreHolder();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(LeaderboardScore paramLeaderboardScore, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof LeaderboardScore))
    {
      if (paramLeaderboardScore != paramObject)
      {
        LeaderboardScore localLeaderboardScore = (LeaderboardScore)paramObject;
        if ((!hl.equal(Long.valueOf(localLeaderboardScore.getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!hl.equal(localLeaderboardScore.getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!hl.equal(Long.valueOf(localLeaderboardScore.getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!hl.equal(localLeaderboardScore.getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!hl.equal(Long.valueOf(localLeaderboardScore.getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!hl.equal(localLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!hl.equal(localLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!hl.equal(localLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!hl.equal(localLeaderboardScore.getScoreHolder(), paramLeaderboardScore.getScoreHolder())) || (!hl.equal(localLeaderboardScore.getScoreTag(), paramLeaderboardScore.getScoreTag()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(LeaderboardScore paramLeaderboardScore)
  {
    hl.a locala = hl.e(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
    Player localPlayer;
    if (paramLeaderboardScore.getScoreHolder() != null) {
      localPlayer = paramLeaderboardScore.getScoreHolder();
    } else {
      localPlayer = null;
    }
    return locala.a("Player", localPlayer).a("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.Ss;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Ss, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.St;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.St, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.Sr;
  }
  
  public long getRawScore()
  {
    return this.Su;
  }
  
  public Player getScoreHolder()
  {
    return this.Sz;
  }
  
  public String getScoreHolderDisplayName()
  {
    String str;
    if (this.Sz != null) {
      str = this.Sz.getDisplayName();
    } else {
      str = this.Sw;
    }
    return str;
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.Sz != null) {
      this.Sz.getDisplayName(paramCharArrayBuffer);
    } else {
      il.b(this.Sw, paramCharArrayBuffer);
    }
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    Uri localUri;
    if (this.Sz != null) {
      localUri = this.Sz.getHiResImageUri();
    } else {
      localUri = this.Sy;
    }
    return localUri;
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    String str;
    if (this.Sz != null) {
      str = this.Sz.getHiResImageUrl();
    } else {
      str = this.SC;
    }
    return str;
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    Uri localUri;
    if (this.Sz != null) {
      localUri = this.Sz.getIconImageUri();
    } else {
      localUri = this.Sx;
    }
    return localUri;
  }
  
  public String getScoreHolderIconImageUrl()
  {
    String str;
    if (this.Sz != null) {
      str = this.Sz.getIconImageUrl();
    } else {
      str = this.SB;
    }
    return str;
  }
  
  public String getScoreTag()
  {
    return this.SA;
  }
  
  public long getTimestampMillis()
  {
    return this.Sv;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public LeaderboardScore ix()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardScoreEntity
 * JD-Core Version:    0.7.0.1
 */