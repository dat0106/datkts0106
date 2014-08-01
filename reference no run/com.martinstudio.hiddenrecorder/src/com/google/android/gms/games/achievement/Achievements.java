package com.google.android.gms.games.achievement;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Achievements
{
  public abstract Intent getAchievementsIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract void increment(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<LoadAchievementsResult> load(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract void reveal(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract void setSteps(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt);
  
  public abstract void unlock(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public static abstract interface UpdateAchievementResult
    extends Result
  {
    public abstract String getAchievementId();
  }
  
  public static abstract interface LoadAchievementsResult
    extends Releasable, Result
  {
    public abstract AchievementBuffer getAchievements();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.Achievements
 * JD-Core Version:    0.7.0.1
 */