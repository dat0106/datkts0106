package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatGingerbread
{
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    boolean bool = true;
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo != null) {
      switch (localNetworkInfo.getType())
      {
      default: 
        break;
      case 1: 
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompatGingerbread
 * JD-Core Version:    0.7.0.1
 */