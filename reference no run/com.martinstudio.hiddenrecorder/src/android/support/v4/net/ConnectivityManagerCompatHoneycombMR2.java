package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatHoneycombMR2
{
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    boolean bool = true;
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo != null) {
      switch (localNetworkInfo.getType())
      {
      case 8: 
      default: 
        break;
      case 1: 
      case 7: 
      case 9: 
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompatHoneycombMR2
 * JD-Core Version:    0.7.0.1
 */