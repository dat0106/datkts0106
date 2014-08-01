package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public abstract interface SnapshotMetadata
  extends Parcelable, Freezable<SnapshotMetadata>
{
  public static final long PLAYED_TIME_UNKNOWN = -1L;
  
  public abstract float getCoverImageAspectRatio();
  
  public abstract Uri getCoverImageUri();
  
  @Deprecated
  public abstract String getCoverImageUrl();
  
  public abstract String getDescription();
  
  public abstract void getDescription(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Game getGame();
  
  public abstract long getLastModifiedTimestamp();
  
  public abstract Player getOwner();
  
  public abstract long getPlayedTime();
  
  public abstract String getSnapshotId();
  
  public abstract String getTitle();
  
  public abstract String getUniqueName();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadata
 * JD-Core Version:    0.7.0.1
 */