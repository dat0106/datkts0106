package com.sonyericsson.extras.liveware.ui;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureTable;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;

public class DeviceLoader
  extends AsyncTaskLoader<Device>
{
  private final long mDeviceId;
  private final ExperienceManager mManager;
  private boolean mObserve;
  private final Loader<Device>.ForceLoadContentObserver mObserver;
  private final ContentResolver mResolver;
  
  public DeviceLoader(Context paramContext, long paramLong, boolean paramBoolean)
  {
    super(paramContext);
    this.mDeviceId = paramLong;
    this.mManager = ExperienceManager.getInstance(paramContext);
    this.mObserve = paramBoolean;
    if (!this.mObserve)
    {
      this.mResolver = null;
      this.mObserver = null;
    }
    else
    {
      this.mResolver = paramContext.getContentResolver();
      this.mObserver = new Loader.ForceLoadContentObserver(this);
    }
  }
  
  public void deliverResult(Device paramDevice)
  {
    if (isStarted()) {
      super.deliverResult(paramDevice);
    }
  }
  
  public Device loadInBackground()
  {
    if (this.mObserve)
    {
      this.mResolver.registerContentObserver(ExperienceDef.DeviceTable.URI, true, this.mObserver);
      this.mResolver.registerContentObserver(ExperienceDef.FeatureTable.URI, true, this.mObserver);
    }
    return this.mManager.getDeviceById(this.mDeviceId);
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if (this.mObserve) {
      this.mResolver.unregisterContentObserver(this.mObserver);
    }
  }
  
  protected void onStartLoading()
  {
    forceLoad();
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeviceLoader
 * JD-Core Version:    0.7.0.1
 */