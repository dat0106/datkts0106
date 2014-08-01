package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameInstanceBuffer
  extends DataBuffer<GameInstance>
{
  public GameInstanceBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public GameInstance cr(int paramInt)
  {
    return new GameInstanceRef(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameInstanceBuffer
 * JD-Core Version:    0.7.0.1
 */