package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;

public final class LeaderboardEntity
  implements Leaderboard
{
  private final String Lk;
  private final Uri Mo;
  private final String Mz;
  private final String Sm;
  private final int Sn;
  private final ArrayList<LeaderboardVariantEntity> So;
  private final Game Sp;
  
  public LeaderboardEntity(Leaderboard paramLeaderboard)
  {
    this.Sm = paramLeaderboard.getLeaderboardId();
    this.Lk = paramLeaderboard.getDisplayName();
    this.Mo = paramLeaderboard.getIconImageUri();
    this.Mz = paramLeaderboard.getIconImageUrl();
    this.Sn = paramLeaderboard.getScoreOrder();
    Object localObject = paramLeaderboard.getGame();
    if (localObject != null) {
      localObject = new GameEntity((Game)localObject);
    } else {
      localObject = null;
    }
    this.Sp = ((Game)localObject);
    localObject = paramLeaderboard.getVariants();
    int j = ((ArrayList)localObject).size();
    this.So = new ArrayList(j);
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      this.So.add((LeaderboardVariantEntity)((LeaderboardVariant)((ArrayList)localObject).get(i)).freeze());
    }
  }
  
  static int a(Leaderboard paramLeaderboard)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramLeaderboard.getLeaderboardId();
    arrayOfObject[1] = paramLeaderboard.getDisplayName();
    arrayOfObject[2] = paramLeaderboard.getIconImageUri();
    arrayOfObject[3] = Integer.valueOf(paramLeaderboard.getScoreOrder());
    arrayOfObject[4] = paramLeaderboard.getVariants();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Leaderboard paramLeaderboard, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Leaderboard))
    {
      if (paramLeaderboard != paramObject)
      {
        Leaderboard localLeaderboard = (Leaderboard)paramObject;
        if ((!hl.equal(localLeaderboard.getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!hl.equal(localLeaderboard.getDisplayName(), paramLeaderboard.getDisplayName())) || (!hl.equal(localLeaderboard.getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!hl.equal(Integer.valueOf(localLeaderboard.getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder()))) || (!hl.equal(localLeaderboard.getVariants(), paramLeaderboard.getVariants()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Leaderboard paramLeaderboard)
  {
    return hl.e(paramLeaderboard).a("LeaderboardId", paramLeaderboard.getLeaderboardId()).a("DisplayName", paramLeaderboard.getDisplayName()).a("IconImageUri", paramLeaderboard.getIconImageUri()).a("IconImageUrl", paramLeaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).a("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Lk, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getIconImageUrl()
  {
    return this.Mz;
  }
  
  public String getLeaderboardId()
  {
    return this.Sm;
  }
  
  public int getScoreOrder()
  {
    return this.Sn;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.So);
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Leaderboard iu()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardEntity
 * JD-Core Version:    0.7.0.1
 */