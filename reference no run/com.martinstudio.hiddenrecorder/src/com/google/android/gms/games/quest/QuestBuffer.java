package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class QuestBuffer
  extends g<Quest>
{
  public QuestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String eU()
  {
    return "external_quest_id";
  }
  
  protected Quest j(int paramInt1, int paramInt2)
  {
    return new QuestRef(this.DD, paramInt1, paramInt2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestBuffer
 * JD-Core Version:    0.7.0.1
 */