package com.google.android.gms.games.quest;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Quests
{
  public static final String EXTRA_QUEST = "quest";
  public static final int SELECT_ACCEPTED = 3;
  public static final int SELECT_COMPLETED = 4;
  public static final int SELECT_COMPLETED_UNCLAIMED = 101;
  public static final int SELECT_ENDING_SOON = 102;
  public static final int SELECT_EXPIRED = 5;
  public static final int SELECT_FAILED = 6;
  public static final int SELECT_OPEN = 2;
  public static final int SELECT_UPCOMING = 1;
  public static final int SORT_ORDER_ENDING_SOON_FIRST = 1;
  public static final int SORT_ORDER_RECENTLY_UPDATED_FIRST;
  public static final int[] TW;
  
  static
  {
    int[] arrayOfInt = new int[8];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    arrayOfInt[2] = 3;
    arrayOfInt[3] = 4;
    arrayOfInt[4] = 101;
    arrayOfInt[5] = 5;
    arrayOfInt[6] = 102;
    arrayOfInt[7] = 6;
    TW = arrayOfInt;
  }
  
  public abstract PendingResult<AcceptQuestResult> accept(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<ClaimMilestoneResult> claim(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
  
  public abstract Intent getQuestIntent(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract Intent getQuestsIntent(GoogleApiClient paramGoogleApiClient, int[] paramArrayOfInt);
  
  public abstract PendingResult<LoadQuestsResult> load(GoogleApiClient paramGoogleApiClient, int[] paramArrayOfInt, int paramInt, boolean paramBoolean);
  
  public abstract PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient paramGoogleApiClient, boolean paramBoolean, String... paramVarArgs);
  
  public abstract void registerQuestUpdateListener(GoogleApiClient paramGoogleApiClient, QuestUpdateListener paramQuestUpdateListener);
  
  public abstract void unregisterQuestUpdateListener(GoogleApiClient paramGoogleApiClient);
  
  public static abstract interface LoadQuestsResult
    extends Releasable, Result
  {
    public abstract QuestBuffer getQuests();
  }
  
  public static abstract interface ClaimMilestoneResult
    extends Result
  {
    public abstract Milestone getMilestone();
    
    public abstract Quest getQuest();
  }
  
  public static abstract interface AcceptQuestResult
    extends Result
  {
    public abstract Quest getQuest();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.Quests
 * JD-Core Version:    0.7.0.1
 */