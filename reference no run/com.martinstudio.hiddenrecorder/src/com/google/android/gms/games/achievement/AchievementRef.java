package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class AchievementRef
  extends d
  implements Achievement
{
  AchievementRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getAchievementId()
  {
    return getString("external_achievement_id");
  }
  
  public int getCurrentSteps()
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    return getInteger("current_steps");
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("description", paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    return getString("formatted_current_steps");
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    a("formatted_current_steps", paramCharArrayBuffer);
  }
  
  public String getFormattedTotalSteps()
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    return getString("formatted_total_steps");
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    a("formatted_total_steps", paramCharArrayBuffer);
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("last_updated_timestamp");
  }
  
  public String getName()
  {
    return getString("name");
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    a("name", paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return new PlayerRef(this.DD, this.Ez);
  }
  
  public Uri getRevealedImageUri()
  {
    return aw("revealed_icon_image_uri");
  }
  
  public String getRevealedImageUrl()
  {
    return getString("revealed_icon_image_url");
  }
  
  public int getState()
  {
    return getInteger("state");
  }
  
  public int getTotalSteps()
  {
    int i = 1;
    if (getType() != i) {
      i = 0;
    }
    gy.A(i);
    return getInteger("total_steps");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public Uri getUnlockedImageUri()
  {
    return aw("unlocked_icon_image_uri");
  }
  
  public String getUnlockedImageUrl()
  {
    return getString("unlocked_icon_image_url");
  }
  
  public long getXpValue()
  {
    long l;
    if ((av("instance_xp_value")) && (!ax("instance_xp_value"))) {
      l = getLong("instance_xp_value");
    } else {
      l = getLong("definition_xp_value");
    }
    return l;
  }
  
  public String toString()
  {
    hl.a locala = hl.e(this).a("AchievementId", getAchievementId()).a("Type", Integer.valueOf(getType())).a("Name", getName()).a("Description", getDescription()).a("UnlockedImageUri", getUnlockedImageUri()).a("UnlockedImageUrl", getUnlockedImageUrl()).a("RevealedImageUri", getRevealedImageUri()).a("RevealedImageUrl", getRevealedImageUrl()).a("Player", getPlayer()).a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
    if (getType() == 1)
    {
      locala.a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
      locala.a("TotalSteps", Integer.valueOf(getTotalSteps()));
    }
    return locala.toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.AchievementRef
 * JD-Core Version:    0.7.0.1
 */