package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class GameRef
  extends d
  implements Game
{
  public GameRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public boolean areSnapshotsEnabled()
  {
    boolean bool;
    if (getInteger("snapshots_enabled") <= 0) {
      bool = false;
    } else {
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
    return GameEntity.a(this, paramObject);
  }
  
  public Game freeze()
  {
    return new GameEntity(this);
  }
  
  public boolean gH()
  {
    return getBoolean("play_enabled_game");
  }
  
  public boolean gI()
  {
    return getBoolean("identity_sharing_confirmed");
  }
  
  public boolean gJ()
  {
    boolean bool;
    if (getInteger("installed") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String gK()
  {
    return getString("package_name");
  }
  
  public int gL()
  {
    return getInteger("gameplay_acl_status");
  }
  
  public int getAchievementTotalCount()
  {
    return getInteger("achievement_total_count");
  }
  
  public String getApplicationId()
  {
    return getString("external_game_id");
  }
  
  public String getDescription()
  {
    return getString("game_description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("game_description", paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return getString("developer_name");
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("developer_name", paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return getString("display_name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("display_name", paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return aw("featured_image_uri");
  }
  
  public String getFeaturedImageUrl()
  {
    return getString("featured_image_url");
  }
  
  public Uri getHiResImageUri()
  {
    return aw("game_hi_res_image_uri");
  }
  
  public String getHiResImageUrl()
  {
    return getString("game_hi_res_image_url");
  }
  
  public Uri getIconImageUri()
  {
    return aw("game_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("game_icon_image_url");
  }
  
  public int getLeaderboardCount()
  {
    return getInteger("leaderboard_count");
  }
  
  public String getPrimaryCategory()
  {
    return getString("primary_category");
  }
  
  public String getSecondaryCategory()
  {
    return getString("secondary_category");
  }
  
  public int hashCode()
  {
    return GameEntity.a(this);
  }
  
  public boolean isMuted()
  {
    return getBoolean("muted");
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    boolean bool;
    if (getInteger("real_time_support") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    boolean bool;
    if (getInteger("turn_based_support") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return GameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameRef
 * JD-Core Version:    0.7.0.1
 */