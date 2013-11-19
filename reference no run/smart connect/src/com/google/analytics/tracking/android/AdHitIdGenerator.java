package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

class AdHitIdGenerator
{
  private boolean mAdMobSdkInstalled;
  
  AdHitIdGenerator()
  {
    try
    {
      if (Class.forName("com.google.ads.AdRequest") != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.mAdMobSdkInstalled = bool;
        return;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        this.mAdMobSdkInstalled = false;
      }
    }
  }
  
  @VisibleForTesting
  AdHitIdGenerator(boolean paramBoolean)
  {
    this.mAdMobSdkInstalled = paramBoolean;
  }
  
  int getAdHitId()
  {
    int i;
    if (this.mAdMobSdkInstalled) {
      i = AdMobInfo.getInstance().generateAdHitId();
    } else {
      i = 0;
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AdHitIdGenerator
 * JD-Core Version:    0.7.0.1
 */