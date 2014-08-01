package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class SnapshotMetadataRef
  extends d
  implements SnapshotMetadata
{
  private final Game Sp;
  private final Player Uo;
  
  public SnapshotMetadataRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.Sp = new GameRef(paramDataHolder, paramInt);
    this.Uo = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return SnapshotMetadataEntity.a(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return new SnapshotMetadataEntity(this);
  }
  
  public float getCoverImageAspectRatio()
  {
    float f1 = 0.0F;
    float f2 = getFloat("cover_icon_image_height");
    float f3 = getFloat("cover_icon_image_width");
    if (f2 != 0.0F) {
      f1 = f3 / f2;
    }
    return f1;
  }
  
  public Uri getCoverImageUri()
  {
    return aw("cover_icon_image_uri");
  }
  
  public String getCoverImageUrl()
  {
    return getString("cover_icon_image_url");
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("description", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public long getLastModifiedTimestamp()
  {
    return getLong("last_modified_timestamp");
  }
  
  public Player getOwner()
  {
    return this.Uo;
  }
  
  public long getPlayedTime()
  {
    return getLong("duration");
  }
  
  public String getSnapshotId()
  {
    return getString("external_snapshot_id");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public String getUniqueName()
  {
    return getString("unique_name");
  }
  
  public int hashCode()
  {
    return SnapshotMetadataEntity.a(this);
  }
  
  public String toString()
  {
    return SnapshotMetadataEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((SnapshotMetadataEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataRef
 * JD-Core Version:    0.7.0.1
 */