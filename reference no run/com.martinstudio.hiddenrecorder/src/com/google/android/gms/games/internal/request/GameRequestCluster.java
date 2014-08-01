package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
  private final ArrayList<GameRequestEntity> Sj;
  private final int xJ;
  
  GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.xJ = paramInt;
    this.Sj = paramArrayList;
    id();
  }
  
  private void id()
  {
    boolean bool1;
    if (this.Sj.isEmpty()) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    gy.A(bool1);
    GameRequest localGameRequest1 = (GameRequest)this.Sj.get(0);
    int i = this.Sj.size();
    int j = 1;
    for (;;)
    {
      if (j >= i) {
        return;
      }
      GameRequest localGameRequest2 = (GameRequest)this.Sj.get(j);
      boolean bool2;
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      gy.a(bool2, "All the requests must be of the same type");
      gy.a(localGameRequest1.getSender().equals(localGameRequest2.getSender()), "All the requests must be from the same sender");
      j += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    int i;
    if ((paramObject instanceof GameRequestCluster))
    {
      if (this != paramObject)
      {
        GameRequestCluster localGameRequestCluster = (GameRequestCluster)paramObject;
        if (localGameRequestCluster.Sj.size() == this.Sj.size())
        {
          int j = this.Sj.size();
          for (i = 0;; i++)
          {
            if (i >= j) {
              return 1;
            }
            if (!((GameRequest)this.Sj.get(i)).equals((GameRequest)localGameRequestCluster.Sj.get(i))) {
              break;
            }
          }
          i = 0;
        }
        else
        {
          i = 0;
        }
      }
      else
      {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public byte[] getData()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getExpirationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getRecipientStatus(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getRequestId()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getRequestId();
  }
  
  public Player getSender()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getSender();
  }
  
  public int getStatus()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.Sj.get(0)).getType();
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(this.Sj.toArray());
  }
  
  public ArrayList<GameRequest> ir()
  {
    return new ArrayList(this.Sj);
  }
  
  public ArrayList<Player> is()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isConsumed(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestCluster
 * JD-Core Version:    0.7.0.1
 */