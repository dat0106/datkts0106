package com.sonyericsson.extras.liveware.ui;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionSetTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ExperienceTable;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class ExperienceLoader
  extends AsyncTaskLoader<Experience>
{
  private final long mId;
  private final ExperienceManager mManager;
  private final Loader<Experience>.ForceLoadContentObserver mObserver;
  private final ContentResolver mResolver;
  
  public ExperienceLoader(Context paramContext, long paramLong)
  {
    super(paramContext);
    Dbg.d("ExperienceLoader: create");
    this.mId = paramLong;
    this.mManager = ExperienceManager.getInstance(paramContext);
    this.mResolver = paramContext.getContentResolver();
    this.mObserver = new Loader.ForceLoadContentObserver(this);
  }
  
  public void deliverResult(Experience paramExperience)
  {
    Dbg.d("ExperienceLoader: deliverResult");
    if (isStarted()) {
      super.deliverResult(paramExperience);
    }
  }
  
  public Experience loadInBackground()
  {
    Dbg.d("ExperienceLoader: loadInBackground");
    Experience localExperience = this.mManager.getExperience(this.mId);
    this.mResolver.registerContentObserver(ExperienceDef.ExperienceTable.URI, true, this.mObserver);
    this.mResolver.registerContentObserver(ExperienceDef.ActionSetTable.URI, true, this.mObserver);
    return localExperience;
  }
  
  protected void onReset()
  {
    super.onReset();
    Dbg.d("ExperienceLoader: onReset");
    onStopLoading();
    this.mResolver.unregisterContentObserver(this.mObserver);
  }
  
  protected void onStartLoading()
  {
    Dbg.d("ExperienceLoader: onStartLoading");
    forceLoad();
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ExperienceLoader
 * JD-Core Version:    0.7.0.1
 */