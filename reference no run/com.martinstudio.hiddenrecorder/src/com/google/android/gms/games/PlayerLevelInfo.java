package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
  private final long MZ;
  private final long Na;
  private final PlayerLevel Nb;
  private final PlayerLevel Nc;
  private final int xJ;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    boolean bool;
    if (paramLong1 == -1L) {
      bool = false;
    } else {
      bool = true;
    }
    hn.A(bool);
    hn.f(paramPlayerLevel1);
    hn.f(paramPlayerLevel2);
    this.xJ = paramInt;
    this.MZ = paramLong1;
    this.Na = paramLong2;
    this.Nb = paramPlayerLevel1;
    this.Nc = paramPlayerLevel2;
  }
  
  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof PlayerLevelInfo))
    {
      if (paramObject != this)
      {
        PlayerLevelInfo localPlayerLevelInfo = (PlayerLevelInfo)paramObject;
        if ((!hl.equal(Long.valueOf(this.MZ), Long.valueOf(localPlayerLevelInfo.MZ))) || (!hl.equal(Long.valueOf(this.Na), Long.valueOf(localPlayerLevelInfo.Na))) || (!hl.equal(this.Nb, localPlayerLevelInfo.Nb)) || (!hl.equal(this.Nc, localPlayerLevelInfo.Nc))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.Nb;
  }
  
  public long getCurrentXpTotal()
  {
    return this.MZ;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.Na;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.Nc;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.MZ);
    arrayOfObject[1] = Long.valueOf(this.Na);
    arrayOfObject[2] = this.Nb;
    arrayOfObject[3] = this.Nc;
    return hl.hashCode(arrayOfObject);
  }
  
  public boolean isMaxLevel()
  {
    return this.Nb.equals(this.Nc);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfo
 * JD-Core Version:    0.7.0.1
 */