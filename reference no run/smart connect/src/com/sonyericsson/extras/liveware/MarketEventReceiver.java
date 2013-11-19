package com.sonyericsson.extras.liveware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.MarketUtils;

public class MarketEventReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str;
      if (!paramIntent.getAction().equals("com.sonyericsson.extras.liveware.MARKET_EXTENSION_INFO"))
      {
        if (paramIntent.getAction().equals("com.sonyericsson.extras.liveware.MARKET_EXTENSIONS_SEARCH"))
        {
          str = paramIntent.getStringExtra("com.sonyericsson.extras.liveware.extra.ACCESSORY_PRODUCT_NAME");
          if (str != null) {
            MarketUtils.launchFindExtensions(paramContext, str);
          }
        }
      }
      else
      {
        str = paramIntent.getStringExtra("com.sonyericsson.extras.liveware.extra.AEA_PACKAGE_NAME");
        if (str != null) {
          MarketUtils.launchInfo(paramContext, str);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.MarketEventReceiver
 * JD-Core Version:    0.7.0.1
 */