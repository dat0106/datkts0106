package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataBuffer;

public final class MilestoneBuffer
  extends DataBuffer<Milestone>
{
  public Milestone get(int paramInt)
  {
    return new MilestoneRef(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneBuffer
 * JD-Core Version:    0.7.0.1
 */