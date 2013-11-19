package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkUtils
{
  public static boolean deviceHasMobileNetwork(Context paramContext)
  {
    boolean bool = false;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if ((localConnectivityManager != null) && (localConnectivityManager.getNetworkInfo(0) != null)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */