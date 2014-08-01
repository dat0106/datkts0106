package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int SE;
  private final int SF;
  private final boolean SG;
  private final long SH;
  private final String SI;
  private final long SJ;
  private final String SK;
  private final String SL;
  private final long SM;
  private final String SN;
  private final String SO;
  private final String SP;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.SE = paramLeaderboardVariant.getTimeSpan();
    this.SF = paramLeaderboardVariant.getCollection();
    this.SG = paramLeaderboardVariant.hasPlayerInfo();
    this.SH = paramLeaderboardVariant.getRawPlayerScore();
    this.SI = paramLeaderboardVariant.getDisplayPlayerScore();
    this.SJ = paramLeaderboardVariant.getPlayerRank();
    this.SK = paramLeaderboardVariant.getDisplayPlayerRank();
    this.SL = paramLeaderboardVariant.getPlayerScoreTag();
    this.SM = paramLeaderboardVariant.getNumScores();
    this.SN = paramLeaderboardVariant.iy();
    this.SO = paramLeaderboardVariant.iz();
    this.SP = paramLeaderboardVariant.iA();
  }
  
  static int a(LeaderboardVariant paramLeaderboardVariant)
  {
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = Integer.valueOf(paramLeaderboardVariant.getTimeSpan());
    arrayOfObject[1] = Integer.valueOf(paramLeaderboardVariant.getCollection());
    arrayOfObject[2] = Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo());
    arrayOfObject[3] = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
    arrayOfObject[4] = paramLeaderboardVariant.getDisplayPlayerScore();
    arrayOfObject[5] = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
    arrayOfObject[6] = paramLeaderboardVariant.getDisplayPlayerRank();
    arrayOfObject[7] = Long.valueOf(paramLeaderboardVariant.getNumScores());
    arrayOfObject[8] = paramLeaderboardVariant.iy();
    arrayOfObject[9] = paramLeaderboardVariant.iA();
    arrayOfObject[10] = paramLeaderboardVariant.iz();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(LeaderboardVariant paramLeaderboardVariant, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof LeaderboardVariant))
    {
      if (paramLeaderboardVariant != paramObject)
      {
        LeaderboardVariant localLeaderboardVariant = (LeaderboardVariant)paramObject;
        if ((!hl.equal(Integer.valueOf(localLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!hl.equal(Integer.valueOf(localLeaderboardVariant.getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!hl.equal(Boolean.valueOf(localLeaderboardVariant.hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!hl.equal(Long.valueOf(localLeaderboardVariant.getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!hl.equal(localLeaderboardVariant.getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!hl.equal(Long.valueOf(localLeaderboardVariant.getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!hl.equal(localLeaderboardVariant.getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!hl.equal(Long.valueOf(localLeaderboardVariant.getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!hl.equal(localLeaderboardVariant.iy(), paramLeaderboardVariant.iy())) || (!hl.equal(localLeaderboardVariant.iA(), paramLeaderboardVariant.iA())) || (!hl.equal(localLeaderboardVariant.iz(), paramLeaderboardVariant.iz()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(LeaderboardVariant paramLeaderboardVariant)
  {
    Object localObject1 = hl.e(paramLeaderboardVariant).a("TimeSpan", TimeSpan.cm(paramLeaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.cm(paramLeaderboardVariant.getCollection()));
    if (!paramLeaderboardVariant.hasPlayerInfo()) {
      localObject2 = "none";
    } else {
      localObject2 = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
    }
    Object localObject2 = ((hl.a)localObject1).a("RawPlayerScore", localObject2);
    if (!paramLeaderboardVariant.hasPlayerInfo()) {
      localObject1 = "none";
    } else {
      localObject1 = paramLeaderboardVariant.getDisplayPlayerScore();
    }
    localObject1 = ((hl.a)localObject2).a("DisplayPlayerScore", localObject1);
    if (!paramLeaderboardVariant.hasPlayerInfo()) {
      localObject2 = "none";
    } else {
      localObject2 = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
    }
    localObject1 = ((hl.a)localObject1).a("PlayerRank", localObject2);
    if (!paramLeaderboardVariant.hasPlayerInfo()) {
      localObject2 = "none";
    } else {
      localObject2 = paramLeaderboardVariant.getDisplayPlayerRank();
    }
    return ((hl.a)localObject1).a("DisplayPlayerRank", localObject2).a("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).a("TopPageNextToken", paramLeaderboardVariant.iy()).a("WindowPageNextToken", paramLeaderboardVariant.iA()).a("WindowPagePrevToken", paramLeaderboardVariant.iz()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.SF;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.SK;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.SI;
  }
  
  public long getNumScores()
  {
    return this.SM;
  }
  
  public long getPlayerRank()
  {
    return this.SJ;
  }
  
  public String getPlayerScoreTag()
  {
    return this.SL;
  }
  
  public long getRawPlayerScore()
  {
    return this.SH;
  }
  
  public int getTimeSpan()
  {
    return this.SE;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.SG;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String iA()
  {
    return this.SP;
  }
  
  public LeaderboardVariant iB()
  {
    return this;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String iy()
  {
    return this.SN;
  }
  
  public String iz()
  {
    return this.SO;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardVariantEntity
 * JD-Core Version:    0.7.0.1
 */