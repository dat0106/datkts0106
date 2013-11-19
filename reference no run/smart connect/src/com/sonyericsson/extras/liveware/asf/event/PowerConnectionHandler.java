package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.ui.FlapActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ExperienceUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import java.util.ArrayList;
import java.util.List;

public class PowerConnectionHandler
  extends ConnectionHandler
{
  private static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
  private static final String CHARGER_NAME = "Charger";
  private static final String USB_CONNECTED = "connected";
  
  public static PowerConnectionHandler getNewHandler()
  {
    return new PowerConnectionHandler();
  }
  
  private List<Intent> handlePower(Context paramContext, boolean paramBoolean)
  {
    Dbg.d("PowerConnectionHandler handlePower");
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean)
    {
      localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, "Charger", false, 12, 8, null));
      if (!ExperienceUtils.isAnyDeviceWithNotifyExternalConnected(paramContext)) {
        PackageUtils.notifyExternalApps(paramContext, false);
      }
    }
    else
    {
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.BATTERY_CHANGED");
      localObject = paramContext.registerReceiver(null, (IntentFilter)localObject);
      if (localObject == null)
      {
        if (Dbg.e()) {
          Dbg.e("We were supposed to get a sticky Intent from registerReveiver but didn't");
        }
      }
      else
      {
        int i = ((Intent)localObject).getIntExtra("plugged", 0);
        if (i != 1)
        {
          if (i == 2) {
            handleUsbCharger(paramContext, localArrayList);
          }
        }
        else {
          handleAcCharger(paramContext, localArrayList);
        }
      }
    }
    return localArrayList;
  }
  
  private static boolean isUsbConnected(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("connected", false);
    }
    return bool;
  }
  
  public void disconnect(Context paramContext)
  {
    paramContext.startService(DeviceService.getDeviceConnectionIntent(paramContext, "Charger", false, 12, 8, null));
    if (!ExperienceUtils.isAnyDeviceWithNotifyExternalConnected(paramContext)) {
      PackageUtils.notifyExternalApps(paramContext, false);
    }
  }
  
  public void handleAcCharger(Context paramContext, List<Intent> paramList)
  {
    if (!DockHandler.isChargingDockConnected(paramContext, null)) {
      paramList.add(DeviceService.getDeviceConnectionIntent(paramContext, "Charger", true, 12, 8, null));
    }
    if ((!ExperienceUtils.isAnyDeviceWithNotifyExternalConnected(paramContext)) && (AsfUtils.isNypon())) {
      PackageUtils.notifyExternalApps(paramContext, true);
    }
  }
  
  public void handleUsbCharger(Context paramContext, List<Intent> paramList)
  {
    if (!ExperienceUtils.isAnyDeviceWithNotifyExternalConnected(paramContext)) {
      if (!isUsbConnected(paramContext))
      {
        paramList.add(DeviceService.getDeviceConnectionIntent(paramContext, "Charger", true, 12, 8, null));
        if (AsfUtils.isMintOrHayabusa()) {
          PackageUtils.notifyExternalApps(paramContext, true);
        }
      }
      else
      {
        PackageUtils.notifyExternalApps(paramContext, false);
      }
    }
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    if (AsfUtils.isWaterproof(paramContext)) {
      FlapActivity.cancel(paramContext);
    }
    return handlePower(paramContext, true);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    List localList = handlePower(paramContext, false);
    if ((AsfUtils.isWaterproof(paramContext)) && (!DockHandler.isChargingDockConnected(paramContext, null)) && (!DockHandler.wasChargingDockConnected(paramContext, null)))
    {
      FlapActivity.show(paramContext, localList);
      localList = null;
    }
    return localList;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    Dbg.d("PowerConnectionHandler onStartup");
    int i = paramIntent.getIntExtra("plugged", 0);
    boolean bool;
    if (i != 1) {
      bool = false;
    } else {
      bool = true;
    }
    if (!DockHandler.isChargingDockConnected(paramContext, null)) {
      paramContext.startService(DeviceService.getDeviceConnectionIntent(paramContext, "Charger", bool, 12, 8, null));
    }
    if (!bool) {
      if (i != 2) {
        bool = false;
      } else {
        bool = true;
      }
    }
    if (!ExperienceUtils.isAnyDeviceWithNotifyExternalConnected(paramContext)) {
      if (!isUsbConnected(paramContext))
      {
        if (((i == 2) && (AsfUtils.isMintOrHayabusa())) || ((i == 1) && (AsfUtils.isNypon()))) {
          PackageUtils.notifyExternalApps(paramContext, bool);
        }
      }
      else {
        PackageUtils.notifyExternalApps(paramContext, false);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.PowerConnectionHandler
 * JD-Core Version:    0.7.0.1
 */