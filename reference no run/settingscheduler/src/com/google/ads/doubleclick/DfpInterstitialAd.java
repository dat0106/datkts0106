package com.google.ads.doubleclick;

import android.app.Activity;
import com.google.ads.AppEventListener;
import com.google.ads.InterstitialAd;

public class DfpInterstitialAd
  extends InterstitialAd
{
  public DfpInterstitialAd(Activity paramActivity, String paramString)
  {
    super(paramActivity, paramString);
  }
  
  public DfpInterstitialAd(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    super(paramActivity, paramString, paramBoolean);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    super.setAppEventListener(paramAppEventListener);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.doubleclick.DfpInterstitialAd
 * JD-Core Version:    0.7.0.1
 */