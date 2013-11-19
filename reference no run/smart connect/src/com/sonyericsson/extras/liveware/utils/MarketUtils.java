package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;

public final class MarketUtils
{
  private static final String ARBITRARY_SEARCH = "market://search?q=";
  private static final String GOOGLE_PLAY_PACKAGE_NAME = "com.android.vending";
  private static final String PACKAGE_DETAILS = "market://details?id=";
  private static final String PACKAGE_SEARCH = "market://search?q=pname:";
  private static HashMap<String, String> sUrlMap = new HashMap();
  
  static
  {
    sUrlMap.put("com.sonyericsson.extras.liveware", "http://mob.cn-playnow.com.cn/sc/c/1");
    sUrlMap.put("com.sonyericsson.extras.smartwatch", "http://mob.cn-playnow.com.cn/sc/c/2");
    sUrlMap.put("com.sonyericsson.extras.smartwirelessheadsetpro", "http://mob.cn-playnow.com.cn/sc/c/3");
    sUrlMap.put("com.sonymobile.smartconnect.collins", "http://mob.cn-playnow.com.cn/sc/c/17");
  }
  
  public static boolean isGooglePlayInstalled(Context paramContext)
  {
    return PackageUtils.existsPackage(paramContext, "com.android.vending");
  }
  
  private static void launch(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    Uri localUri = Uri.parse(paramString1 + paramString2);
    localIntent.setData(localUri);
    if (Dbg.v()) {
      Dbg.v("MarketUtils launching " + localUri);
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (Dbg.v()) {
          Dbg.v("MarketUtils couldn't launch Market");
        }
      }
    }
  }
  
  public static void launchExactFind(Context paramContext, String paramString)
  {
    launch(paramContext, "market://search?q=pname:", paramString);
  }
  
  public static void launchFind(Context paramContext, String paramString)
  {
    launch(paramContext, "market://search?q=", paramString);
  }
  
  public static void launchFindExtensions(Context paramContext, String paramString)
  {
    launch(paramContext, "market://search?q=", "LiveWare™ extension for " + paramString);
  }
  
  public static void launchFindLiveKey(Context paramContext)
  {
    launch(paramContext, "market://search?q=", "com.sonyericsson.extras.livekey");
  }
  
  public static void launchFindTagKey(Context paramContext)
  {
    launch(paramContext, "market://search?q=", "com.sonyericsson.extras.APPTAG");
  }
  
  public static void launchInfo(Context paramContext, String paramString)
  {
    if (!isGooglePlayInstalled(paramContext))
    {
      String str = (String)sUrlMap.get(paramString);
      if (str != null) {
        openUrl(paramContext, str);
      } else if (Dbg.e()) {
        Dbg.e("lanuchInfo no url mapping for: " + paramString);
      }
    }
    else
    {
      launch(paramContext, "market://details?id=", paramString);
    }
  }
  
  public static void launchLegacyFindPlugins(Context paramContext, String paramString)
  {
    launch(paramContext, "market://search?q=", "Extends:" + paramString);
  }
  
  private static void openUrl(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("MarketUtils couldn't launch: " + paramString);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.MarketUtils
 * JD-Core Version:    0.7.0.1
 */