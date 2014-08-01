package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef
  extends d
  implements Player
{
  private final PlayerLevelInfo MU;
  private final PlayerColumnNames Nd;
  private final MostRecentGameInfoRef Ne;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.Nd = new PlayerColumnNames(paramString);
    this.Ne = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.Nd);
    if (!gQ())
    {
      this.MU = null;
    }
    else
    {
      int i = getInteger(this.Nd.RV);
      int j = getInteger(this.Nd.RY);
      PlayerLevel localPlayerLevel = new PlayerLevel(i, getLong(this.Nd.RW), getLong(this.Nd.RX));
      Object localObject;
      if (i == j) {
        localObject = localPlayerLevel;
      } else {
        localObject = new PlayerLevel(j, getLong(this.Nd.RX), getLong(this.Nd.RZ));
      }
      this.MU = new PlayerLevelInfo(getLong(this.Nd.RU), getLong(this.Nd.Sa), localPlayerLevel, (PlayerLevel)localObject);
    }
  }
  
  private boolean gQ()
  {
    boolean bool = false;
    if ((!ax(this.Nd.RU)) && (getLong(this.Nd.RU) != -1L)) {
      bool = true;
    }
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public int gN()
  {
    return getInteger(this.Nd.RS);
  }
  
  public boolean gO()
  {
    return getBoolean(this.Nd.Sc);
  }
  
  public MostRecentGameInfo gP()
  {
    MostRecentGameInfoRef localMostRecentGameInfoRef;
    if (!ax(this.Nd.Sd)) {
      localMostRecentGameInfoRef = this.Ne;
    } else {
      localMostRecentGameInfoRef = null;
    }
    return localMostRecentGameInfoRef;
  }
  
  public String getDisplayName()
  {
    return getString(this.Nd.RM);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Nd.RM, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return aw(this.Nd.RP);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.Nd.RQ);
  }
  
  public Uri getIconImageUri()
  {
    return aw(this.Nd.RN);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.Nd.RO);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    long l;
    if ((av(this.Nd.RT)) && (!ax(this.Nd.RT))) {
      l = getLong(this.Nd.RT);
    } else {
      l = -1L;
    }
    return l;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MU;
  }
  
  public String getPlayerId()
  {
    return getString(this.Nd.RL);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.Nd.RR);
  }
  
  public String getTitle()
  {
    return getString(this.Nd.Sb);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    a(this.Nd.Sb, paramCharArrayBuffer);
  }
  
  public boolean hasHiResImage()
  {
    boolean bool;
    if (getHiResImageUri() == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean hasIconImage()
  {
    boolean bool;
    if (getIconImageUri() == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return PlayerEntity.a(this);
  }
  
  public String toString()
  {
    return PlayerEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerRef
 * JD-Core Version:    0.7.0.1
 */