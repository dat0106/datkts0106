package com.sonyericsson.extras.liveware.ui;

import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;

public class PreferenceLaunchActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startActivity(new Intent(this, StartActivity.class));
    finish();
    SmartConnectAnalytics.trackEvent(this, "Launch", "Settings");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.PreferenceLaunchActivity
 * JD-Core Version:    0.7.0.1
 */