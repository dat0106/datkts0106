package com.smartandroidapps.audiowidgetlib;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

public class RunTimeConfig
{
  public static final String[] MARKETS;
  private static final String TStoreUpgradeLink = "http://www.tstore.co.kr/userpoc/game/viewProduct.omp?insDpCatNo=DP04003&insProdId=0000041552&prodGrdCd=PD004401&t_top=DP000504";
  private static final String proPackage = "com.smartandroidapps.audiowidgetpro";
  private static final String upgradeLink = "https://play.google.com/store/apps/details?id=com.smartandroidapps.audiowidgetpro&referrer=utm_source%3Daudiomanager%26utm_medium%3Dupgrade";
  
  static
  {
    String[] arrayOfString = new String[11];
    arrayOfString[0] = "Unknown";
    arrayOfString[1] = "Google";
    arrayOfString[2] = "SHOP4APPS";
    arrayOfString[3] = "SlideME";
    arrayOfString[4] = "AndAppStore";
    arrayOfString[5] = "HandNSoft";
    arrayOfString[6] = "Android.pdassi.de";
    arrayOfString[7] = "SK.TStore";
    arrayOfString[8] = "AppsLib";
    arrayOfString[9] = "Amazon";
    arrayOfString[10] = "CHIPMagazine";
    MARKETS = arrayOfString;
  }
  
  public static int GetMarketTypeCode(Context paramContext)
  {
    return Integer.parseInt(paramContext.getString(R.string.market_type_code));
  }
  
  public static String getUpdateLink(Context paramContext)
  {
    String str;
    switch (GetMarketTypeCode(paramContext))
    {
    default: 
      str = "https://play.google.com/store/apps/details?id=com.smartandroidapps.audiowidgetpro&referrer=utm_source%3Daudiomanager%26utm_medium%3Dupgrade";
      break;
    case 7: 
      str = "http://www.tstore.co.kr/userpoc/game/viewProduct.omp?insDpCatNo=DP04003&insProdId=0000041552&prodGrdCd=PD004401&t_top=DP000504";
    }
    return str;
  }
  
  public static String getUpgradeLink(Context paramContext)
  {
    String str;
    switch (GetMarketTypeCode(paramContext))
    {
    default: 
      str = "https://play.google.com/store/apps/details?id=com.smartandroidapps.audiowidgetpro&referrer=utm_source%3Daudiomanager%26utm_medium%3Dupgrade";
      break;
    case 7: 
      str = "http://www.tstore.co.kr/userpoc/game/viewProduct.omp?insDpCatNo=DP04003&insProdId=0000041552&prodGrdCd=PD004401&t_top=DP000504";
    }
    return str;
  }
  
  public static boolean isFullVersion(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.smartandroidapps.audiowidgetpro");
  }
  
  public static AlertDialog showBuyDialog(final Activity paramActivity, final boolean paramBoolean, int paramInt)
  {
    new AlertDialog.Builder(paramActivity).setIcon(R.drawable.market_ico).setTitle(R.string.upgrade_to_full_version).setMessage(paramInt).setPositiveButton(R.string.buy, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Uri localUri = Uri.parse(RunTimeConfig.getUpgradeLink(RunTimeConfig.this));
        if (localUri != null)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("android.intent.action.VIEW").setData(localUri);
          RunTimeConfig.this.startActivity(localIntent);
          if (paramBoolean) {
            RunTimeConfig.this.finish();
          }
        }
        else if (paramBoolean)
        {
          RunTimeConfig.this.finish();
        }
      }
    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if (this.val$kill) {
          paramActivity.finish();
        }
      }
    }).show();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.RunTimeConfig
 * JD-Core Version:    0.7.0.1
 */