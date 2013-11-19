package com.sonyericsson.extras.liveware.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.sonyericsson.extras.liveware.aef.service.DbMaintenanceService;
import com.sonyericsson.extras.liveware.asf.EventHandler;
import com.sonyericsson.extras.liveware.asf.EventReceiver;
import com.sonyericsson.extras.liveware.service.BtService;

public class AsfUtils
{
  private static final String SYSTEM_API = "com.sonyericsson.system";
  
  public static String getStringFromCharSequence(CharSequence paramCharSequence)
  {
    String str;
    if (paramCharSequence != null) {
      str = paramCharSequence.toString();
    } else {
      str = "";
    }
    return str;
  }
  
  public static int getWaterproofDialogTextId(Context paramContext)
  {
    int i;
    if (!hasHigherWaterResistanceLevel(paramContext)) {
      i = 2131100054;
    } else {
      i = 2131099966;
    }
    return i;
  }
  
  public static String getWaterproofDialogTitle(Context paramContext)
  {
    String str;
    if (!hasHigherWaterResistanceLevel(paramContext)) {
      str = paramContext.getString(2131100053);
    } else {
      str = paramContext.getString(2131099965);
    }
    return str;
  }
  
  private static boolean hasHigherWaterResistanceLevel(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131427334);
  }
  
  public static boolean hasSmcLib(Context paramContext)
  {
    boolean bool = false;
    try
    {
      if (isHoneycombOrHigher(paramContext))
      {
        LibraryManager.LibraryInfo localLibraryInfo = LibraryManager.getLibraryManager(paramContext).getLibrary("com.sonyericsson.system");
        Dbg.d("Found system api!");
        if (localLibraryInfo.isVersionSupported(0))
        {
          Dbg.d("Supported version...");
          bool = true;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label41:
      break label41;
    }
    return bool;
  }
  
  public static boolean hasWaterproofedAudioPlug(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131427335);
  }
  
  public static void initializeServices(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SERVICE_ACTION");
    localIntent.putExtra("SERVICE_COMMAND", "INITIALIZE_APPLICATION");
    localIntent.setComponent(new ComponentName(paramContext, EventHandler.class));
    paramContext.startService(localIntent);
    EventReceiver.checkAlreadyConnected(paramContext);
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, DbMaintenanceService.class));
    localIntent.putExtra("SERVICE_COMMAND", "ASF_STARTED");
    paramContext.startService(localIntent);
  }
  
  private static boolean isDogo()
  {
    boolean bool;
    if ((!Build.MANUFACTURER.startsWith("Sony")) || ((!Build.MODEL.equals("C5503")) && (!Build.MODEL.equals("C5502")) && (!Build.MODEL.equals("SO-04E")) && (!Build.MODEL.equals("M36h")) && (!Build.MODEL.equals("f29nh0l")) && (!Build.MODEL.equals("f2m8i7leaeu")) && (!Build.MODEL.equals("fm3h0oe4zeu")))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isHoneycombOrHigher(Context paramContext)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isMarketInstalled(Context paramContext)
  {
    boolean bool;
    if (paramContext.getPackageManager().getLaunchIntentForPackage("com.android.vending") == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isMintOrHayabusa()
  {
    boolean bool;
    if ((!Build.MANUFACTURER.startsWith("Sony")) || ((!Build.MODEL.startsWith("LT30")) && (!Build.MODEL.startsWith("LT29")))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNypon()
  {
    boolean bool;
    if ((!Build.MANUFACTURER.startsWith("Sony")) || (!Build.MODEL.startsWith("LT22"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSonyDevice()
  {
    return Build.MANUFACTURER.startsWith("Sony");
  }
  
  public static boolean isWaterproof(Context paramContext)
  {
    boolean bool;
    if ((paramContext.getResources().getBoolean(2131427333)) || (isDogo()) || (isYuga())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isYuga()
  {
    boolean bool;
    if ((!Build.MANUFACTURER.startsWith("Sony")) || ((!Build.MODEL.equals("C6603")) && (!Build.MODEL.equals("C6602")) && (!Build.MODEL.equals("SO-02E")) && (!Build.MODEL.equals("L36h")) && (!Build.MODEL.equals("C6606")) && (!Build.MODEL.equals("4a2g66")) && (!Build.MODEL.equals("0a0g44")) && (!Build.MODEL.equals("9a0g86")) && (!Build.MODEL.equals("3a5g14")))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean shouldShowWaterproofTextOnly(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131427337);
  }
  
  public static boolean shouldShowWaterproofWarningForSDcard(Context paramContext)
  {
    boolean bool;
    if ((!isWaterproof(paramContext)) || (!paramContext.getResources().getBoolean(2131427336))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void startBtService(Context paramContext)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter != null) && (localBluetoothAdapter.getState() == 12)) {
      paramContext.startService(new Intent(paramContext, BtService.class));
    }
  }
  
  public static void stopBtService(Context paramContext)
  {
    paramContext.stopService(new Intent(paramContext, BtService.class));
  }
  
  public static void updateConfiguration(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SERVICE_ACTION");
    localIntent.putExtra("SERVICE_COMMAND", "UPDATE_CONFIGURATION");
    localIntent.setComponent(new ComponentName(paramContext, EventHandler.class));
    paramContext.startService(localIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.AsfUtils
 * JD-Core Version:    0.7.0.1
 */