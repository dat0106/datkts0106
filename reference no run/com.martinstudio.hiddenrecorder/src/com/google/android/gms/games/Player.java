package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public abstract interface Player
  extends Parcelable, Freezable<Player>
{
  public static final long CURRENT_XP_UNKNOWN = -1L;
  public static final long TIMESTAMP_UNKNOWN = -1L;
  
  public abstract int gN();
  
  public abstract boolean gO();
  
  public abstract MostRecentGameInfo gP();
  
  public abstract String getDisplayName();
  
  public abstract void getDisplayName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Uri getHiResImageUri();
  
  @Deprecated
  public abstract String getHiResImageUrl();
  
  public abstract Uri getIconImageUri();
  
  @Deprecated
  public abstract String getIconImageUrl();
  
  public abstract long getLastPlayedWithTimestamp();
  
  public abstract PlayerLevelInfo getLevelInfo();
  
  public abstract String getPlayerId();
  
  public abstract long getRetrievedTimestamp();
  
  public abstract String getTitle();
  
  public abstract void getTitle(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract boolean hasHiResImage();
  
  public abstract boolean hasIconImage();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.Player
 * JD-Core Version:    0.7.0.1
 */