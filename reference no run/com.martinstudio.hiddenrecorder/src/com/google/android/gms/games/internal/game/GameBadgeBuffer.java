package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer
  extends DataBuffer<GameBadge>
{
  public GameBadge cp(int paramInt)
  {
    return new GameBadgeRef(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeBuffer
 * JD-Core Version:    0.7.0.1
 */