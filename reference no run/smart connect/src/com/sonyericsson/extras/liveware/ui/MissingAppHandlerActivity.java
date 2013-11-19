package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public abstract class MissingAppHandlerActivity
  extends Activity
{
  protected ActionSet mActionSet;
  private boolean mMarketStarted = false;
  protected String mRawSetting;
  protected String mUuid;
  
  protected abstract String getAppLabelFromRawSetting(String paramString);
  
  protected abstract String getDialogTitle();
  
  protected abstract String getPackageNameFromRawSetting(String paramString);
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    if (localIntent.getExtras() == null)
    {
      Dbg.e("No data in the intent");
      finish();
    }
    else
    {
      this.mRawSetting = localIntent.getExtras().getString("setting_raw");
      this.mUuid = localIntent.getExtras().getString("id");
      this.mActionSet = ExperienceManager.getInstance(this).getActionSetByUuid(this.mUuid);
      if (!TextUtils.isEmpty(this.mRawSetting))
      {
        if ((PackageUtils.existsPackage(this, getPackageNameFromRawSetting(this.mRawSetting))) || (!MarketUtils.isGooglePlayInstalled(this))) {
          showAppSelectionActivity();
        } else {
          showMissingAppDialog(getDialogTitle(), getAppLabelFromRawSetting(this.mRawSetting));
        }
      }
      else {
        showAppSelectionActivity();
      }
    }
  }
  
  protected void onMissingAppSelection(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        finish();
      } else {
        showAppSelectionActivity();
      }
    }
    else {
      showMarketPage();
    }
  }
  
  protected void onStart()
  {
    if (this.mMarketStarted) {
      finish();
    }
    super.onStart();
  }
  
  protected abstract void showAppSelectionActivity();
  
  protected void showMarketPage()
  {
    this.mMarketStarted = true;
    MarketUtils.launchInfo(this, getPackageNameFromRawSetting(this.mRawSetting));
  }
  
  protected void showMissingAppDialog(String paramString1, String paramString2)
  {
    MissingAppDialog localMissingAppDialog = MissingAppDialog.newInstance(paramString1, paramString2);
    UIUtils.showDialogFragment(getFragmentManager(), localMissingAppDialog, MissingAppDialog.class.getSimpleName());
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.MissingAppHandlerActivity
 * JD-Core Version:    0.7.0.1
 */