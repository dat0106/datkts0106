package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;

public class SmartKeyAdminActivity
  extends BaseActivity
  implements View.OnClickListener, LoaderManager.LoaderCallbacks<Device>
{
  protected static final String ACTION_START_SMART_KEY_VIEW = "com.sonyericsson.extras.liveware.START_SMART_KEY_VIEW";
  ApplicationData mAppData;
  Device mDevice;
  long mDeviceID;
  ExperienceManager mExperienceManager;
  
  private void addDownloadApp(Feature paramFeature)
  {
    String str = paramFeature.getCompanionPkg();
    if ((str != null) && (!PackageUtils.existsPackage(this, str))) {
      this.mAppData = new ApplicationData(this, str);
    }
  }
  
  private void goUp()
  {
    SCGenericDevicePages.show(this, this.mDeviceID);
    finish();
  }
  
  private void setApplicationData()
  {
    this.mAppData = PackageUtils.getLiveKeyDefault(this, this.mDevice);
    if (this.mAppData == null) {
      addDownloadApp(this.mDevice.getFeature(2));
    }
  }
  
  private void tryLaunch(ApplicationData paramApplicationData)
  {
    if (paramApplicationData != null) {
      trySendStartActivity("android.intent.action.MAIN", "android.intent.category.LAUNCHER", paramApplicationData.getComponentName());
    }
  }
  
  private boolean trySendStartActivity(String paramString1, String paramString2, ComponentName paramComponentName)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.setComponent(paramComponentName);
    localIntent.addFlags(268435456);
    localIntent.addCategory(paramString2);
    if (PackageUtils.canHandleIntent(this, paramComponentName, localIntent)) {
      try
      {
        startActivity(localIntent);
        boolean bool = true;
        return bool;
      }
      catch (Exception localException)
      {
        if (Dbg.e()) {
          Dbg.e("Cannot launch activity " + localException.getMessage());
        }
      }
    }
    for (;;)
    {
      int i = 0;
      break;
      if (Dbg.e()) {
        Dbg.e("Cannot launch activity, it does not handle " + i);
      }
    }
  }
  
  private void updateView()
  {
    Button localButton = (Button)findViewById(2131558520);
    localButton.setOnClickListener(this);
    setApplicationData();
    View localView2 = findViewById(2131558513);
    localView2.setOnClickListener(this);
    View localView1 = findViewById(2131558516);
    localView1.setOnClickListener(this);
    if (this.mAppData != null)
    {
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      localButton.setVisibility(0);
      ((TextView)findViewById(2131558519)).setText(this.mAppData.getName());
      ((ImageView)findViewById(2131558517)).setImageDrawable(this.mAppData.getIcon());
    }
    else
    {
      localView1.setVisibility(8);
      localButton.setVisibility(8);
      localView2.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131558513: 
    case 2131558520: 
      if (this.mDevice != null) {
        ApplicationSelectionActivity.launchApplicationSelection(this, this.mDevice, false);
      }
      break;
    case 2131558516: 
      tryLaunch(this.mAppData);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if ((((Intent)localObject).getAction() == null) || (((Intent)localObject).getAction().equals("com.sonyericsson.extras.liveware.START_SMART_KEY_VIEW")))
    {
      setContentView(2130903083);
      this.mDeviceID = ((Intent)localObject).getLongExtra("com.sonyericsson.extras.liveware.extra.smartdevice", -1L);
      this.mExperienceManager = ExperienceManager.getInstance(this);
      getLoaderManager().initLoader(0, null, this);
      localObject = getActionBar();
      ((ActionBar)localObject).setDisplayHomeAsUpEnabled(true);
      ((ActionBar)localObject).setDisplayOptions(16, 16);
    }
    else
    {
      finish();
    }
  }
  
  public Loader<Device> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new DeviceLoader(this, this.mDeviceID, true);
  }
  
  public void onLoadFinished(Loader<Device> paramLoader, Device paramDevice)
  {
    this.mDevice = paramDevice;
    updateView();
  }
  
  public void onLoaderReset(Loader<Device> paramLoader) {}
  
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
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SmartKeyAdminActivity
 * JD-Core Version:    0.7.0.1
 */