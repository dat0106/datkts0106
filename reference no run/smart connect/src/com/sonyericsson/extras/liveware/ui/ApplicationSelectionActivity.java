package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;

public class ApplicationSelectionActivity
  extends BaseActivity
{
  static final int CONTEXT_MENU_APP_INFO = 1;
  static final int CONTEXT_MENU_APP_UNINSTALL = 2;
  private ApplicationAdapter mAdapter;
  private Device mCurrentDevice;
  private ExperienceManager mExperienceManager;
  private RefreshReceiver mRefreshReceiver = new RefreshReceiver(null);
  private ApplicationLoadingTask mTask;
  
  private void goUp()
  {
    Intent localIntent = new Intent(this, SmartKeyAdminActivity.class);
    localIntent.setAction("com.sonyericsson.extras.liveware.START_SMART_KEY_VIEW");
    localIntent.putExtra("com.sonyericsson.extras.liveware.extra.smartdevice", this.mCurrentDevice.getId());
    localIntent.addFlags(335544320);
    startActivity(localIntent);
    finish();
  }
  
  public static void launchApplicationSelection(Context paramContext, Device paramDevice, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ApplicationSelectionActivity.class);
    localIntent.putExtra("com.sonyericsson.extras.liveware.extra.smartdevice", paramDevice.getId());
    if (paramBoolean) {
      localIntent.addFlags(1350565888);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void refreshAdapter()
  {
    this.mTask = new ApplicationLoadingTask(null);
    this.mTask.execute(null);
  }
  
  private void registerPackageReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    registerReceiver(this.mRefreshReceiver, localIntentFilter);
  }
  
  private void renderApplicationView()
  {
    View localView = View.inflate(this, 2130903084, null);
    setContentView(localView);
    ((ListView)localView.findViewById(2131558522)).addHeaderView(renderHeader());
  }
  
  private View renderHeader()
  {
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(this, 2130903043, null);
    ((Button)localLinearLayout.findViewById(2131558406)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MarketUtils.launchFindLiveKey(ApplicationSelectionActivity.this);
      }
    });
    return localLinearLayout;
  }
  
  private void unCheckAll()
  {
    ListView localListView = (ListView)findViewById(2131558522);
    for (int i = 0; i < localListView.getChildCount(); i++)
    {
      RadioButton localRadioButton = (RadioButton)localListView.getChildAt(i).findViewById(2131558475);
      if (localRadioButton != null) {
        localRadioButton.setChecked(false);
      }
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    ApplicationData localApplicationData = this.mAdapter.getSelectedApp();
    if (localApplicationData != null) {
      switch (paramMenuItem.getItemId())
      {
      default: 
        if (Dbg.e()) {
          Dbg.e("Illegal menu item.");
        }
        break;
      case 1: 
        MarketUtils.launchInfo(this, localApplicationData.getApplicationInfo().packageName);
        break;
      case 2: 
        PackageUtils.uninstallApplication(this, localApplicationData);
      }
    }
    return super.onContextItemSelected(paramMenuItem);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mExperienceManager = ExperienceManager.getInstance(this);
    Object localObject = getIntent();
    this.mCurrentDevice = this.mExperienceManager.getDeviceById(((Intent)localObject).getLongExtra("com.sonyericsson.extras.liveware.extra.smartdevice", -1L));
    if (this.mCurrentDevice != null)
    {
      this.mAdapter = new ApplicationAdapter(this, this.mCurrentDevice);
      localObject = getActionBar();
      ((ActionBar)localObject).setDisplayHomeAsUpEnabled(true);
      ((ActionBar)localObject).setDisplayOptions(16, 16);
      renderApplicationView();
    }
    else
    {
      if (Dbg.e()) {
        Dbg.e("Trying to launch application selection without valid device");
      }
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mTask != null) {
      this.mTask.cancel(false);
    }
  }
  
  public void onItemClicker(View paramView)
  {
    RadioButton localRadioButton = (RadioButton)paramView.findViewById(2131558475);
    if (localRadioButton != null)
    {
      PackageUtils.setLiveKeyDefault(this, (ApplicationData)paramView.getTag(), this.mCurrentDevice);
      unCheckAll();
      localRadioButton.setChecked(true);
      finish();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      break;
    case 16908332: 
      goUp();
      bool = true;
    }
    return bool;
  }
  
  protected void onStart()
  {
    super.onStart();
    refreshAdapter();
    registerPackageReceiver();
  }
  
  protected void onStop()
  {
    super.onStop();
    unregisterReceiver(this.mRefreshReceiver);
  }
  
  private class ApplicationLoadingTask
    extends AsyncTask<Void, Void, Void>
  {
    private ApplicationLoadingTask() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      ApplicationSelectionActivity.this.mAdapter.loadDataSet();
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      ((ListView)ApplicationSelectionActivity.this.findViewById(2131558522)).setAdapter(ApplicationSelectionActivity.this.mAdapter);
    }
  }
  
  private class RefreshReceiver
    extends BroadcastReceiver
  {
    private RefreshReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      ApplicationSelectionActivity.this.refreshAdapter();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ApplicationSelectionActivity
 * JD-Core Version:    0.7.0.1
 */