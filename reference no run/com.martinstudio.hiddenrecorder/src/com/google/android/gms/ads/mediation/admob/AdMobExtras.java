package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras
  implements NetworkExtras
{
  private final Bundle mExtras;
  
  public AdMobExtras(Bundle paramBundle)
  {
    Bundle localBundle;
    if (paramBundle == null) {
      localBundle = null;
    } else {
      localBundle = new Bundle(paramBundle);
    }
    this.mExtras = localBundle;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.admob.AdMobExtras
 * JD-Core Version:    0.7.0.1
 */