package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final String Lk;
  private final String MA;
  private final String MB;
  private final boolean MC;
  private final boolean MD;
  private final boolean ME;
  private final String Mk;
  private final String Ml;
  private final String Mm;
  private final String Mn;
  private final Uri Mo;
  private final Uri Mp;
  private final Uri Mq;
  private final boolean Mr;
  private final boolean Ms;
  private final String Mt;
  private final int Mu;
  private final int Mv;
  private final int Mw;
  private final boolean Mx;
  private final boolean My;
  private final String Mz;
  private final int xJ;
  private final String zM;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.xJ = paramInt1;
    this.zM = paramString1;
    this.Lk = paramString2;
    this.Mk = paramString3;
    this.Ml = paramString4;
    this.Mm = paramString5;
    this.Mn = paramString6;
    this.Mo = paramUri1;
    this.Mz = paramString8;
    this.Mp = paramUri2;
    this.MA = paramString9;
    this.Mq = paramUri3;
    this.MB = paramString10;
    this.Mr = paramBoolean1;
    this.Ms = paramBoolean2;
    this.Mt = paramString7;
    this.Mu = paramInt2;
    this.Mv = paramInt3;
    this.Mw = paramInt4;
    this.Mx = paramBoolean3;
    this.My = paramBoolean4;
    this.MC = paramBoolean5;
    this.MD = paramBoolean6;
    this.ME = paramBoolean7;
  }
  
  public GameEntity(Game paramGame)
  {
    this.xJ = 4;
    this.zM = paramGame.getApplicationId();
    this.Mk = paramGame.getPrimaryCategory();
    this.Ml = paramGame.getSecondaryCategory();
    this.Mm = paramGame.getDescription();
    this.Mn = paramGame.getDeveloperName();
    this.Lk = paramGame.getDisplayName();
    this.Mo = paramGame.getIconImageUri();
    this.Mz = paramGame.getIconImageUrl();
    this.Mp = paramGame.getHiResImageUri();
    this.MA = paramGame.getHiResImageUrl();
    this.Mq = paramGame.getFeaturedImageUri();
    this.MB = paramGame.getFeaturedImageUrl();
    this.Mr = paramGame.gH();
    this.Ms = paramGame.gJ();
    this.Mt = paramGame.gK();
    this.Mu = paramGame.gL();
    this.Mv = paramGame.getAchievementTotalCount();
    this.Mw = paramGame.getLeaderboardCount();
    this.Mx = paramGame.isRealTimeMultiplayerEnabled();
    this.My = paramGame.isTurnBasedMultiplayerEnabled();
    this.MC = paramGame.isMuted();
    this.MD = paramGame.gI();
    this.ME = paramGame.areSnapshotsEnabled();
  }
  
  static int a(Game paramGame)
  {
    Object[] arrayOfObject = new Object[20];
    arrayOfObject[0] = paramGame.getApplicationId();
    arrayOfObject[1] = paramGame.getDisplayName();
    arrayOfObject[2] = paramGame.getPrimaryCategory();
    arrayOfObject[3] = paramGame.getSecondaryCategory();
    arrayOfObject[4] = paramGame.getDescription();
    arrayOfObject[5] = paramGame.getDeveloperName();
    arrayOfObject[6] = paramGame.getIconImageUri();
    arrayOfObject[7] = paramGame.getHiResImageUri();
    arrayOfObject[8] = paramGame.getFeaturedImageUri();
    arrayOfObject[9] = Boolean.valueOf(paramGame.gH());
    arrayOfObject[10] = Boolean.valueOf(paramGame.gJ());
    arrayOfObject[11] = paramGame.gK();
    arrayOfObject[12] = Integer.valueOf(paramGame.gL());
    arrayOfObject[13] = Integer.valueOf(paramGame.getAchievementTotalCount());
    arrayOfObject[14] = Integer.valueOf(paramGame.getLeaderboardCount());
    arrayOfObject[15] = Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled());
    arrayOfObject[16] = Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled());
    arrayOfObject[17] = Boolean.valueOf(paramGame.isMuted());
    arrayOfObject[18] = Boolean.valueOf(paramGame.gI());
    arrayOfObject[19] = Boolean.valueOf(paramGame.areSnapshotsEnabled());
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof Game))
    {
      if (paramGame != paramObject)
      {
        Game localGame = (Game)paramObject;
        if ((hl.equal(localGame.getApplicationId(), paramGame.getApplicationId())) && (hl.equal(localGame.getDisplayName(), paramGame.getDisplayName())) && (hl.equal(localGame.getPrimaryCategory(), paramGame.getPrimaryCategory())) && (hl.equal(localGame.getSecondaryCategory(), paramGame.getSecondaryCategory())) && (hl.equal(localGame.getDescription(), paramGame.getDescription())) && (hl.equal(localGame.getDeveloperName(), paramGame.getDeveloperName())) && (hl.equal(localGame.getIconImageUri(), paramGame.getIconImageUri())) && (hl.equal(localGame.getHiResImageUri(), paramGame.getHiResImageUri())) && (hl.equal(localGame.getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (hl.equal(Boolean.valueOf(localGame.gH()), Boolean.valueOf(paramGame.gH()))) && (hl.equal(Boolean.valueOf(localGame.gJ()), Boolean.valueOf(paramGame.gJ()))) && (hl.equal(localGame.gK(), paramGame.gK())) && (hl.equal(Integer.valueOf(localGame.gL()), Integer.valueOf(paramGame.gL()))) && (hl.equal(Integer.valueOf(localGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (hl.equal(Integer.valueOf(localGame.getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (hl.equal(Boolean.valueOf(localGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
        {
          Boolean localBoolean = Boolean.valueOf(localGame.isTurnBasedMultiplayerEnabled());
          boolean bool1;
          if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!hl.equal(Boolean.valueOf(localGame.isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!hl.equal(Boolean.valueOf(localGame.gI()), Boolean.valueOf(paramGame.gI())))) {
            bool1 = false;
          } else {
            bool1 = bool2;
          }
          if ((hl.equal(localBoolean, Boolean.valueOf(bool1))) && (hl.equal(Boolean.valueOf(localGame.areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled())))) {}
        }
        else
        {
          bool2 = false;
        }
      }
    }
    else {
      bool2 = false;
    }
    return bool2;
  }
  
  static String b(Game paramGame)
  {
    return hl.e(paramGame).a("ApplicationId", paramGame.getApplicationId()).a("DisplayName", paramGame.getDisplayName()).a("PrimaryCategory", paramGame.getPrimaryCategory()).a("SecondaryCategory", paramGame.getSecondaryCategory()).a("Description", paramGame.getDescription()).a("DeveloperName", paramGame.getDeveloperName()).a("IconImageUri", paramGame.getIconImageUri()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.getHiResImageUri()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.getFeaturedImageUri()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.gH())).a("InstanceInstalled", Boolean.valueOf(paramGame.gJ())).a("InstancePackageName", paramGame.gK()).a("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.ME;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Game freeze()
  {
    return this;
  }
  
  public boolean gH()
  {
    return this.Mr;
  }
  
  public boolean gI()
  {
    return this.MD;
  }
  
  public boolean gJ()
  {
    return this.Ms;
  }
  
  public String gK()
  {
    return this.Mt;
  }
  
  public int gL()
  {
    return this.Mu;
  }
  
  public int getAchievementTotalCount()
  {
    return this.Mv;
  }
  
  public String getApplicationId()
  {
    return this.zM;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.Mn;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mn, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Lk, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.Mq;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.MB;
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
  
  public int getLeaderboardCount()
  {
    return this.Mw;
  }
  
  public String getPrimaryCategory()
  {
    return this.Mk;
  }
  
  public String getSecondaryCategory()
  {
    return this.Ml;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isMuted()
  {
    return this.MC;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.Mx;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.My;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    String str1 = null;
    if (fm())
    {
      paramParcel.writeString(this.zM);
      paramParcel.writeString(this.Lk);
      paramParcel.writeString(this.Mk);
      paramParcel.writeString(this.Ml);
      paramParcel.writeString(this.Mm);
      paramParcel.writeString(this.Mn);
      String str2;
      if (this.Mo != null) {
        str2 = this.Mo.toString();
      } else {
        str2 = null;
      }
      paramParcel.writeString(str2);
      if (this.Mp != null) {
        str2 = this.Mp.toString();
      } else {
        str2 = null;
      }
      paramParcel.writeString(str2);
      if (this.Mq != null) {
        str1 = this.Mq.toString();
      }
      paramParcel.writeString(str1);
      int j;
      if (!this.Mr) {
        j = 0;
      } else {
        j = i;
      }
      paramParcel.writeInt(j);
      if (!this.Ms) {
        i = 0;
      }
      paramParcel.writeInt(i);
      paramParcel.writeString(this.Mt);
      paramParcel.writeInt(this.Mu);
      paramParcel.writeInt(this.Mv);
      paramParcel.writeInt(this.Mw);
    }
    else
    {
      GameEntityCreator.a(this, paramParcel, paramInt);
    }
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity bd(Parcel paramParcel)
    {
      Object localObject1;
      if ((!GameEntity.b(GameEntity.gM())) && (!GameEntity.aQ(GameEntity.class.getCanonicalName())))
      {
        String str1 = paramParcel.readString();
        String str5 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        String str4 = paramParcel.readString();
        localObject1 = paramParcel.readString();
        Object localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          localObject2 = Uri.parse((String)localObject2);
        } else {
          localObject2 = null;
        }
        Object localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          localObject3 = Uri.parse((String)localObject3);
        } else {
          localObject3 = null;
        }
        String str6 = paramParcel.readString();
        Uri localUri;
        if (str6 != null) {
          localUri = Uri.parse(str6);
        } else {
          localUri = null;
        }
        boolean bool2;
        if (paramParcel.readInt() <= 0) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        boolean bool1;
        if (paramParcel.readInt() <= 0) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        localObject1 = new GameEntity(4, str1, str5, str2, str3, str4, (String)localObject1, (Uri)localObject2, (Uri)localObject3, localUri, bool2, bool1, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false);
      }
      else
      {
        localObject1 = super.bd(paramParcel);
      }
      return localObject1;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameEntity
 * JD-Core Version:    0.7.0.1
 */