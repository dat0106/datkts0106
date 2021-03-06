package com.sonyericsson.extras.liveware.ui;

import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;

public class LaunchActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startActivity(new Intent(this, StartActivity.class));
    finish();
    SmartConnectAnalytics.trackEvent(this, "Launch", "Home");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.LaunchActivity
 * JD-Core Version:    0.7.0.1
 */