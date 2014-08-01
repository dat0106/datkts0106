package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
  extends d
  implements Participant
{
  private final PlayerRef Tb;
  
  public ParticipantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.Tb = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return new ParticipantEntity(this);
  }
  
  public String gR()
  {
    return getString("client_address");
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.Tb.getDisplayName();
    } else {
      str = getString("default_display_name");
    }
    return str;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (!ax("external_player_id")) {
      this.Tb.getDisplayName(paramCharArrayBuffer);
    } else {
      a("default_display_name", paramCharArrayBuffer);
    }
  }
  
  public Uri getHiResImageUri()
  {
    Uri localUri;
    if (!ax("external_player_id")) {
      localUri = this.Tb.getHiResImageUri();
    } else {
      localUri = aw("default_display_hi_res_image_uri");
    }
    return localUri;
  }
  
  public String getHiResImageUrl()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.Tb.getHiResImageUrl();
    } else {
      str = getString("default_display_hi_res_image_url");
    }
    return str;
  }
  
  public Uri getIconImageUri()
  {
    Uri localUri;
    if (!ax("external_player_id")) {
      localUri = this.Tb.getIconImageUri();
    } else {
      localUri = aw("default_display_image_uri");
    }
    return localUri;
  }
  
  public String getIconImageUrl()
  {
    String str;
    if (!ax("external_player_id")) {
      str = this.Tb.getIconImageUrl();
    } else {
      str = getString("default_display_image_url");
    }
    return str;
  }
  
  public String getParticipantId()
  {
    return getString("external_participant_id");
  }
  
  public Player getPlayer()
  {
    PlayerRef localPlayerRef;
    if (!ax("external_player_id")) {
      localPlayerRef = this.Tb;
    } else {
      localPlayerRef = null;
    }
    return localPlayerRef;
  }
  
  public ParticipantResult getResult()
  {
    ParticipantResult localParticipantResult;
    if (!ax("result_type"))
    {
      int i = getInteger("result_type");
      int j = getInteger("placing");
      localParticipantResult = new ParticipantResult(getParticipantId(), i, j);
    }
    else
    {
      localParticipantResult = null;
    }
    return localParticipantResult;
  }
  
  public int getStatus()
  {
    return getInteger("player_status");
  }
  
  public int hashCode()
  {
    return ParticipantEntity.a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    boolean bool;
    if (getInteger("connected") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return ParticipantEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantRef
 * JD-Core Version:    0.7.0.1
 */