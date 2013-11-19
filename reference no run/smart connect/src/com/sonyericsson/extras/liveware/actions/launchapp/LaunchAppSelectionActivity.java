package com.sonyericsson.extras.liveware.actions.launchapp;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.ui.ApplicationDataAdapter;
import com.sonyericsson.extras.liveware.ui.ApplicationDataLoader;
import com.sonyericsson.extras.liveware.ui.ApplicationDataLoader.ApplicationFilter;
import com.sonyericsson.extras.liveware.ui.BaseActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import java.util.List;

public class LaunchAppSelectionActivity
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks<List<ApplicationData>>
{
  private ApplicationDataAdapter mAdapter;
  private ApplicationData mCurrentAppData;
  private ListView mListView;
  private String mRawSetting;
  
  public static void launchApplicationSelection(Context paramContext, Device paramDevice, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.liveware.START_APPLICATION_VIEW");
    localIntent.putExtra("com.sonyericsson.extras.liveware.extra.smartdevice", paramDevice.getId());
    localIntent.putExtra("com.sonyericsson.extras.liveware.extra.apptype", paramInt);
    if (paramBoolean) {
      localIntent.addFlags(1350565888);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void renderApplicationView()
  {
    this.mAdapter.refresh();
  }
  
  private void updateSettingAndFinish(String paramString)
  {
    ActionUtils.finishActivityWithSetting(this, paramString, LaunchApp.getLabelByRawSetting(this, paramString));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    setContentView(View.inflate(this, 2130903079, null));
    setTitle(2131099848);
    Object localObject = this.mRawSetting;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ComponentName.unflattenFromString((String)localObject);
      if (localObject != null) {
        this.mCurrentAppData = new ApplicationData(this, (ComponentName)localObject);
      }
    }
    this.mAdapter = new ApplicationDataAdapter(this);
    this.mListView = ((ListView)findViewById(16908298));
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setChoiceMode(1);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        LaunchAppSelectionActivity.this.onItemClicker(paramAnonymousView);
      }
    });
    getLoaderManager().initLoader(0, null, this);
    getActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  public Loader<List<ApplicationData>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    new ApplicationDataLoader(this, new ApplicationDataLoader.ApplicationFilter()
    {
      public List<ResolveInfo> getApplications(Context paramAnonymousContext)
      {
        PackageManager localPackageManager = paramAnonymousContext.getPackageManager();
        Object localObject = new Intent("android.intent.action.MAIN");
        ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
        localObject = localPackageManager.queryIntentActivities((Intent)localObject, 0);
        Intent localIntent = new Intent();
        localIntent.setComponent(ComponentName.unflattenFromString("com.sonymobile.photoanalyzer/com.sonymobile.musicslideshow.MusicSlideShowActivity"));
        ((List)localObject).addAll(localPackageManager.queryIntentActivities(localIntent, 0));
        localIntent = new Intent();
        localIntent.setComponent(ComponentName.unflattenFromString("com.sonymobile.musicslideshow/com.sonymobile.musicslideshow.MusicSlideShowActivity"));
        ((List)localObject).addAll(localPackageManager.queryIntentActivities(localIntent, 0));
        return localObject;
      }
    });
  }
  
  public void onItemClicker(View paramView)
  {
    ApplicationData localApplicationData = (ApplicationData)paramView.getTag();
    if (localApplicationData == null) {
      finish();
    } else {
      updateSettingAndFinish(localApplicationData.getFlatComponentName());
    }
  }
  
  public void onLoadFinished(Loader<List<ApplicationData>> paramLoader, List<ApplicationData> paramList)
  {
    this.mAdapter.setData(paramList);
    if (this.mCurrentAppData != null)
    {
      int i = this.mAdapter.getPosition(this.mCurrentAppData);
      this.mListView.setSelection(i);
      this.mListView.setItemChecked(i, true);
    }
  }
  
  public void onLoaderReset(Loader<List<ApplicationData>> paramLoader)
  {
    this.mAdapter.setData(null);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
  
  protected void onResume()
  {
    super.onResume();
    renderApplicationView();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.launchapp.LaunchAppSelectionActivity
 * JD-Core Version:    0.7.0.1
 */