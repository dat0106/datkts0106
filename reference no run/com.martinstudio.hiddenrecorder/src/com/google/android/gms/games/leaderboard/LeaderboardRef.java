package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef
  extends d
  implements Leaderboard
{
  private final int RD;
  private final Game Sp;
  
  LeaderboardRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RD = paramInt2;
    this.Sp = new GameRef(paramDataHolder, paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardEntity.a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString("name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("name", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public Uri getIconImageUri()
  {
    return aw("board_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("board_icon_image_url");
  }
  
  public String getLeaderboardId()
  {
    return getString("external_leaderboard_id");
  }
  
  public int getScoreOrder()
  {
    return getInteger("score_order");
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    ArrayList localArrayList = new ArrayList(this.RD);
    for (int i = 0;; i++)
    {
      if (i >= this.RD) {
        return localArrayList;
      }
      localArrayList.add(new LeaderboardVariantRef(this.DD, i + this.Ez));
    }
  }
  
  public int hashCode()
  {
    return LeaderboardEntity.a(this);
  }
  
  public Leaderboard iu()
  {
    return new LeaderboardEntity(this);
  }
  
  public String toString()
  {
    return LeaderboardEntity.b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.LeaderboardRef
 * JD-Core Version:    0.7.0.1
 */