package com.sonyericsson.extras.liveware.ui;

import android.content.AsyncTaskLoader;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApplicationDataLoader
  extends AsyncTaskLoader<List<ApplicationData>>
{
  private final ApplicationFilter mFilter;
  private PackageIntentReceiver mPackageObserver;
  
  public ApplicationDataLoader(Context paramContext, ApplicationFilter paramApplicationFilter)
  {
    super(paramContext);
    this.mFilter = paramApplicationFilter;
  }
  
  public void deliverResult(List<ApplicationData> paramList)
  {
    if (isStarted()) {
      super.deliverResult(paramList);
    }
  }
  
  public List<ApplicationData> loadInBackground()
  {
    PackageManager localPackageManager = getContext().getPackageManager();
    List localList = this.mFilter.getApplications(getContext());
    Collections.sort(localList, new AppNameComparator(localPackageManager));
    return PackageUtils.createAppData(getContext(), localList);
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if (this.mPackageObserver != null)
    {
      getContext().unregisterReceiver(this.mPackageObserver);
      this.mPackageObserver = null;
    }
  }
  
  protected void onStartLoading()
  {
    if (this.mPackageObserver == null) {
      this.mPackageObserver = new PackageIntentReceiver(this);
    }
    forceLoad();
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
  
  private static class AppNameComparator
    implements Comparator<ResolveInfo>
  {
    PackageManager mPm;
    
    public AppNameComparator(PackageManager paramPackageManager)
    {
      this.mPm = paramPackageManager;
    }
    
    public int compare(ResolveInfo paramResolveInfo1, ResolveInfo paramResolveInfo2)
    {
      CharSequence localCharSequence2 = paramResolveInfo1.activityInfo.loadLabel(this.mPm);
      CharSequence localCharSequence1 = paramResolveInfo2.activityInfo.loadLabel(this.mPm);
      return localCharSequence2.toString().compareTo(localCharSequence1.toString());
    }
  }
  
  public static abstract interface ApplicationFilter
  {
    public abstract List<ResolveInfo> getApplications(Context paramContext);
  }
  
  private static class PackageIntentReceiver
    extends BroadcastReceiver
  {
    final ApplicationDataLoader mLoader;
    
    public PackageIntentReceiver(ApplicationDataLoader paramApplicationDataLoader)
    {
      this.mLoader = paramApplicationDataLoader;
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
      localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
      localIntentFilter.addDataScheme("package");
      this.mLoader.getContext().registerReceiver(this, localIntentFilter);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
      localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
      this.mLoader.getContext().registerReceiver(this, localIntentFilter);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.mLoader.onContentChanged();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ApplicationDataLoader
 * JD-Core Version:    0.7.0.1
 */