package com.sonyericsson.extras.liveware.ui;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ExperienceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureTable;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SmartDeviceListLoader
  extends AsyncTaskLoader<List<Device>>
{
  private static final Comparator<Device> TIME_COMPARATOR = new Comparator()
  {
    public int compare(Device paramAnonymousDevice1, Device paramAnonymousDevice2)
    {
      return Long.valueOf(paramAnonymousDevice2.getTimestamp()).compareTo(Long.valueOf(paramAnonymousDevice1.getTimestamp()));
    }
  };
  private final ExperienceManager mManager;
  private final Loader<List<Device>>.ForceLoadContentObserver mObserver;
  private final ContentResolver mResolver;
  
  public SmartDeviceListLoader(Context paramContext)
  {
    super(paramContext);
    this.mManager = ExperienceManager.getInstance(paramContext);
    this.mResolver = paramContext.getContentResolver();
    this.mObserver = new Loader.ForceLoadContentObserver(this);
  }
  
  public void deliverResult(List<Device> paramList)
  {
    if (isStarted()) {
      super.deliverResult(paramList);
    }
  }
  
  public List<Device> loadInBackground()
  {
    this.mResolver.registerContentObserver(ExperienceDef.DeviceTable.URI, true, this.mObserver);
    this.mResolver.registerContentObserver(ExperienceDef.FeatureTable.URI, true, this.mObserver);
    this.mResolver.registerContentObserver(ExperienceDef.ExperienceTable.URI, true, this.mObserver);
    Object localObject = this.mManager.getAllDevices();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (Device)localIterator.next();
      if (((Device)localObject).isConfigured()) {
        localArrayList.add(localObject);
      }
    }
    Collections.sort(localArrayList, TIME_COMPARATOR);
    return localArrayList;
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    this.mResolver.unregisterContentObserver(this.mObserver);
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
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SmartDeviceListLoader
 * JD-Core Version:    0.7.0.1
 */