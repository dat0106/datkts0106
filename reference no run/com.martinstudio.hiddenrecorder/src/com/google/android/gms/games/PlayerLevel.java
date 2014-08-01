package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;

public final class PlayerLevel
  implements SafeParcelable
{
  public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
  private final int MW;
  private final long MX;
  private final long MY;
  private final int xJ;
  
  PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool1;
    if (paramLong1 < 0L) {
      bool1 = false;
    } else {
      bool1 = bool2;
    }
    hn.a(bool1, "Min XP must be positive!");
    if (paramLong2 <= paramLong1) {
      bool2 = false;
    }
    hn.a(bool2, "Max XP must be more than min XP!");
    this.xJ = paramInt1;
    this.MW = paramInt2;
    this.MX = paramLong1;
    this.MY = paramLong2;
  }
  
  public PlayerLevel(int paramInt, long paramLong1, long paramLong2)
  {
    this(1, paramInt, paramLong1, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof PlayerLevel))
    {
      if (this != paramObject)
      {
        PlayerLevel localPlayerLevel = (PlayerLevel)paramObject;
        if ((!hl.equal(Integer.valueOf(localPlayerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber()))) || (!hl.equal(Long.valueOf(localPlayerLevel.getMinXp()), Long.valueOf(getMinXp()))) || (!hl.equal(Long.valueOf(localPlayerLevel.getMaxXp()), Long.valueOf(getMaxXp())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public int getLevelNumber()
  {
    return this.MW;
  }
  
  public long getMaxXp()
  {
    return this.MY;
  }
  
  public long getMinXp()
  {
    return this.MX;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.MW);
    arrayOfObject[1] = Long.valueOf(this.MX);
    arrayOfObject[2] = Long.valueOf(this.MY);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("LevelNumber", Integer.valueOf(getLevelNumber())).a("MinXp", Long.valueOf(getMinXp())).a("MaxXp", Long.valueOf(getMaxXp())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevel
 * JD-Core Version:    0.7.0.1
 */