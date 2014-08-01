package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface MostRecentGameInfo
  extends Parcelable, Freezable<MostRecentGameInfo>
{
  public abstract String ik();
  
  public abstract String il();
  
  public abstract long im();
  
  public abstract Uri in();
  
  public abstract Uri io();
  
  public abstract Uri ip();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfo
 * JD-Core Version:    0.7.0.1
 */