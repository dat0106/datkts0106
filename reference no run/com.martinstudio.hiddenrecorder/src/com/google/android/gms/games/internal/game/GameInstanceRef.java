package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class GameInstanceRef
  extends d
  implements GameInstance
{
  GameInstanceRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getApplicationId()
  {
    return getString("external_game_id");
  }
  
  public String getDisplayName()
  {
    return getString("instance_display_name");
  }
  
  public String getPackageName()
  {
    return getString("package_name");
  }
  
  public boolean hY()
  {
    boolean bool;
    if (getInteger("real_time_support") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean hZ()
  {
    boolean bool;
    if (getInteger("turn_based_support") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int ia()
  {
    return getInteger("platform_type");
  }
  
  public boolean ib()
  {
    boolean bool;
    if (getInteger("piracy_check") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean ic()
  {
    boolean bool;
    if (getInteger("installed") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return hl.e(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(hY())).a("SupportsTurnBased", Boolean.valueOf(hZ())).a("PlatformType", PlatformType.cm(ia())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(ib())).a("Installed", Boolean.valueOf(ic())).toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameInstanceRef
 * JD-Core Version:    0.7.0.1
 */