package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final String HV;
  private final String Lk;
  private final String MA;
  private final String MP;
  private final long MQ;
  private final int MR;
  private final long MS;
  private final MostRecentGameInfoEntity MT;
  private final PlayerLevelInfo MU;
  private final boolean MV;
  private final Uri Mo;
  private final Uri Mp;
  private final String Mz;
  private final int xJ;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.MP = paramString1;
    this.Lk = paramString2;
    this.Mo = paramUri1;
    this.Mz = paramString3;
    this.Mp = paramUri2;
    this.MA = paramString4;
    this.MQ = paramLong1;
    this.MR = paramInt2;
    this.MS = paramLong2;
    this.HV = paramString5;
    this.MV = paramBoolean;
    this.MT = paramMostRecentGameInfoEntity;
    this.MU = paramPlayerLevelInfo;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.xJ = 10;
    this.MP = paramPlayer.getPlayerId();
    this.Lk = paramPlayer.getDisplayName();
    this.Mo = paramPlayer.getIconImageUri();
    this.Mz = paramPlayer.getIconImageUrl();
    this.Mp = paramPlayer.getHiResImageUri();
    this.MA = paramPlayer.getHiResImageUrl();
    this.MQ = paramPlayer.getRetrievedTimestamp();
    this.MR = paramPlayer.gN();
    this.MS = paramPlayer.getLastPlayedWithTimestamp();
    this.HV = paramPlayer.getTitle();
    this.MV = paramPlayer.gO();
    Object localObject = paramPlayer.gP();
    if (localObject != null) {
      localObject = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject);
    } else {
      localObject = null;
    }
    this.MT = ((MostRecentGameInfoEntity)localObject);
    this.MU = paramPlayer.getLevelInfo();
    gy.c(this.MP);
    gy.c(this.Lk);
    boolean bool;
    if (this.MQ <= 0L) {
      bool = false;
    } else {
      bool = true;
    }
    gy.A(bool);
  }
  
  static int a(Player paramPlayer)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = paramPlayer.getPlayerId();
    arrayOfObject[1] = paramPlayer.getDisplayName();
    arrayOfObject[2] = paramPlayer.getIconImageUri();
    arrayOfObject[3] = paramPlayer.getHiResImageUri();
    arrayOfObject[4] = Long.valueOf(paramPlayer.getRetrievedTimestamp());
    arrayOfObject[5] = paramPlayer.getTitle();
    arrayOfObject[6] = paramPlayer.getLevelInfo();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Player paramPlayer, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Player))
    {
      if (paramPlayer != paramObject)
      {
        Player localPlayer = (Player)paramObject;
        if ((!hl.equal(localPlayer.getPlayerId(), paramPlayer.getPlayerId())) || (!hl.equal(localPlayer.getDisplayName(), paramPlayer.getDisplayName())) || (!hl.equal(localPlayer.getIconImageUri(), paramPlayer.getIconImageUri())) || (!hl.equal(localPlayer.getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!hl.equal(Long.valueOf(localPlayer.getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!hl.equal(localPlayer.getTitle(), paramPlayer.getTitle())) || (!hl.equal(localPlayer.getLevelInfo(), paramPlayer.getLevelInfo()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Player paramPlayer)
  {
    return hl.e(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).a("Title", paramPlayer.getTitle()).a("LevelInfo", paramPlayer.getLevelInfo()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public int gN()
  {
    return this.MR;
  }
  
  public boolean gO()
  {
    return this.MV;
  }
  
  public MostRecentGameInfo gP()
  {
    return this.MT;
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Lk, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.Mp;
  }
  
  public String getHiResImageUrl()
  {
    return this.MA;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getIconImageUrl()
  {
    return this.Mz;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.MS;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.MU;
  }
  
  public String getPlayerId()
  {
    return this.MP;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.MQ;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.HV, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.xJ;
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
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str2 = null;
    if (fm())
    {
      paramParcel.writeString(this.MP);
      paramParcel.writeString(this.Lk);
      String str1;
      if (this.Mo != null) {
        str1 = this.Mo.toString();
      } else {
        str1 = null;
      }
      paramParcel.writeString(str1);
      if (this.Mp != null) {
        str2 = this.Mp.toString();
      }
      paramParcel.writeString(str2);
      paramParcel.writeLong(this.MQ);
    }
    else
    {
      PlayerEntityCreator.a(this, paramParcel, paramInt);
    }
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity be(Parcel paramParcel)
    {
      Object localObject1;
      if ((!PlayerEntity.b(PlayerEntity.gM())) && (!PlayerEntity.aQ(PlayerEntity.class.getCanonicalName())))
      {
        localObject1 = paramParcel.readString();
        String str = paramParcel.readString();
        Object localObject3 = paramParcel.readString();
        Object localObject2 = paramParcel.readString();
        if (localObject3 != null) {
          localObject3 = Uri.parse((String)localObject3);
        } else {
          localObject3 = null;
        }
        if (localObject2 != null) {
          localObject2 = Uri.parse((String)localObject2);
        } else {
          localObject2 = null;
        }
        localObject1 = new PlayerEntity(10, (String)localObject1, str, (Uri)localObject3, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
      }
      else
      {
        localObject1 = super.be(paramParcel);
      }
      return localObject1;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntity
 * JD-Core Version:    0.7.0.1
 */