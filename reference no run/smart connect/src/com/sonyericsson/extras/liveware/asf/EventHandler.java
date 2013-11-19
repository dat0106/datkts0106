package com.sonyericsson.extras.liveware.asf;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsUtils;
import com.sonyericsson.extras.liveware.asf.event.AudioConnectionHandler;
import com.sonyericsson.extras.liveware.asf.event.BluetoothHandler;
import com.sonyericsson.extras.liveware.asf.event.DockHandler;
import com.sonyericsson.extras.liveware.asf.event.HdmiConnectionHandler;
import com.sonyericsson.extras.liveware.asf.event.LivekeyHandler;
import com.sonyericsson.extras.liveware.asf.event.PowerConnectionHandler;
import com.sonyericsson.extras.liveware.asf.event.SDcardConnectionHandler;
import com.sonyericsson.extras.liveware.asf.event.SemcUsbConnectionHandler;
import com.sonyericsson.extras.liveware.asf.event.SmartTagsHandler;
import com.sonyericsson.extras.liveware.asf.event.UsbConnectionHandler;
import com.sonyericsson.extras.liveware.db.LegacyDbUpgrader;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ExperienceUtils;
import java.util.Iterator;
import java.util.List;

public class EventHandler
  extends IntentService
{
  public static final int KEY_SRC_3_5_MM = 1;
  public static final int KEY_SRC_BLUETOOTH = 2;
  public static final int KEY_SRC_UNDEFINED = -1;
  public static final int KEY_SRC_USB_OTG = 3;
  private static final int LIVEKEY_ACTION_RELEASE = 1;
  private static final String SERVICE_PREFS = "service";
  private static final String SMC_MODE = "smc_mode";
  public static final String SMC_PLUG_EVENT = "com.sonyericsson.system.intent.action.HEADSET_PLUG";
  private static Boolean sSmcMode = null;
  private String mPlugEvent = "android.intent.action.HEADSET_PLUG";
  
  public EventHandler()
  {
    super(EventHandler.class.getName());
  }
  
  private static void checkAlreadyConnected(Context paramContext)
  {
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    if (localIntent == null) {
      AudioConnectionHandler.getNewHandler().disconnect(paramContext);
    } else {
      AudioConnectionHandler.getNewHandler().onStartup(paramContext, localIntent);
    }
    localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent == null) {
      PowerConnectionHandler.getNewHandler().disconnect(paramContext);
    } else {
      PowerConnectionHandler.getNewHandler().onStartup(paramContext, localIntent);
    }
    localIntent = paramContext.registerReceiver(null, new IntentFilter("com.sonyericsson.hardware.action.USB_OTG_DEVICE_CONNECTED"));
    if (localIntent != null) {
      SemcUsbConnectionHandler.getNewHandler().onStartup(paramContext, localIntent);
    }
    localIntent = paramContext.registerReceiver(null, new IntentFilter("com.sonyericsson.hardware.action.USB_OTG_DEVICE_DISCONNECTED"));
    if (localIntent != null) {
      SemcUsbConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, localIntent);
    }
    localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.DOCK_EVENT"));
    if (localIntent == null) {
      DockHandler.getNewHandler().disconnect(paramContext);
    } else {
      DockHandler.getNewHandler().onStartup(paramContext, localIntent);
    }
    localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.HDMI_PLUGGED"));
    if (localIntent == null) {
      HdmiConnectionHandler.getNewHandler().disconnect(paramContext);
    } else {
      HdmiConnectionHandler.getNewHandler().onStartup(paramContext, localIntent);
    }
  }
  
  private boolean checkSystemApi()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("service", 0);
    boolean bool = AsfUtils.hasSmcLib(this);
    if (bool != localSharedPreferences.getBoolean("smc_mode", false)) {
      localSharedPreferences.edit().putBoolean("smc_mode", bool).commit();
    }
    return bool;
  }
  
  private int getSavedPreloadVersion()
  {
    return getSharedPreferences("preload_prefs", 0).getInt("preload_version", 0);
  }
  
  public static boolean inSmcMode(Context paramContext)
  {
    if (sSmcMode == null)
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("service", 0);
      if (!localSharedPreferences.contains("smc_mode"))
      {
        sSmcMode = Boolean.valueOf(AsfUtils.hasSmcLib(paramContext));
        localSharedPreferences.edit().putBoolean("smc_mode", sSmcMode.booleanValue()).commit();
      }
      else
      {
        sSmcMode = Boolean.valueOf(localSharedPreferences.getBoolean("smc_mode", false));
      }
    }
    return sSmcMode.booleanValue();
  }
  
  private void initializeApplication()
  {
    Dbg.d("EventHandler.initializeApplication");
    ExperienceUtils.updateUnfinalizedPreconfigActionSets(this);
    ExperienceManager.getInstance(this).purgeUnfinalizedUserActionSets();
    ActionUtils.updateActions(this);
    int i = getSavedPreloadVersion();
    if (i > 0) {
      new LegacyDbUpgrader(this).importOldDb();
    }
    if (i < 6) {
      preload(i);
    }
    ExperienceUtils.updateUnmodifiedExperienceNames(this);
    ExperienceUtils.updateUnmodifiedUserdefinedDeviceNames(this, getResources());
    ExperienceUtils.updateActionSetLabels(this);
    TimeService.initializeInitiators(this);
    if (!checkSystemApi())
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(this, EventService.class));
      startService(localIntent);
    }
    TtsSmsUtils.doStartupCheck(this);
  }
  
  private void preload(int paramInt)
  {
    ExperienceUtils.importPredefinedExperiencesAndDevices(this, paramInt);
    ExperienceUtils.migrateHdmiToHdmiMhl(this);
    getSharedPreferences("preload_prefs", 0).edit().putInt("preload_version", 6).commit();
  }
  
  public static void sendIntentsToDeviceService(Context paramContext, List<Intent> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        paramContext.startService((Intent)localIterator.next());
      }
    }
  }
  
  private void updateConfiguration()
  {
    Dbg.d("EventHandler.updateConfiguration");
    ExperienceManager.getInstance(this).purgeUnfinalizedUserActionSets();
    ActionUtils.updateActions(this);
    ExperienceUtils.updateUnmodifiedExperienceNames(this);
    ExperienceUtils.updateUnmodifiedUserdefinedDeviceNames(this, getResources());
    ExperienceUtils.updateActionSetLabels(this);
  }
  
  public void dispatchAction(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    List localList = null;
    if (Dbg.d()) {
      Dbg.d("dispatchAction " + str);
    }
    if (!str.equals(this.mPlugEvent))
    {
      if (!str.equals("android.intent.action.ACTION_POWER_CONNECTED"))
      {
        if (!str.equals("android.intent.action.ACTION_POWER_DISCONNECTED"))
        {
          if (!str.equals("com.sonyericsson.hardware.action.USB_OTG_DEVICE_CONNECTED"))
          {
            if (!str.equals("com.sonyericsson.hardware.action.USB_OTG_DEVICE_DISCONNECTED"))
            {
              if (!str.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED"))
              {
                if (!str.equals("android.hardware.usb.action.USB_DEVICE_DETACHED"))
                {
                  if ((!str.equals("com.sonyericsson.hardware.action.APPLICATION_BUTTON")) && (!str.equals("com.sonyericsson.intent.action.VENDOR_BUTTON")))
                  {
                    if ((!str.equals("android.intent.action.TIME_SET")) && (!str.equals("android.intent.action.DATE_CHANGED")))
                    {
                      if (!str.equals("android.intent.action.HDMI_PLUGGED"))
                      {
                        if (!str.equals("android.nfc.action.NDEF_DISCOVERED"))
                        {
                          if (!str.equals("android.bluetooth.device.action.BOND_STATE_CHANGED"))
                          {
                            if (!str.equals("android.bluetooth.device.action.ACL_CONNECTED"))
                            {
                              if (!str.equals("android.bluetooth.device.action.ACL_DISCONNECTED"))
                              {
                                if (!str.equals("android.bluetooth.adapter.action.STATE_CHANGED"))
                                {
                                  if ((!str.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) && (!str.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")))
                                  {
                                    if (!str.equals("android.intent.action.DOCK_EVENT"))
                                    {
                                      if ((!str.equals("android.intent.action.MEDIA_REMOVED")) && (!str.equals("android.intent.action.MEDIA_BAD_REMOVAL")))
                                      {
                                        if ((str.equals("android.intent.action.MEDIA_MOUNTED")) || (str.equals("android.intent.action.MEDIA_NOFS")) || (str.equals("android.intent.action.MEDIA_UNMOUNTABLE"))) {
                                          localList = SDcardConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                                        }
                                      }
                                      else {
                                        localList = SDcardConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
                                      }
                                    }
                                    else if (paramIntent.getIntExtra("android.intent.extra.DOCK_STATE", 0) == 0) {
                                      localList = DockHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
                                    } else {
                                      localList = DockHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                                    }
                                  }
                                  else if (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 2) {
                                    localList = BluetoothHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                                  }
                                }
                                else {
                                  localList = BluetoothHandler.getNewHandler().onAdapterStateChanged(paramContext, paramIntent);
                                }
                              }
                              else {
                                localList = BluetoothHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
                              }
                            }
                            else
                            {
                              AsfUtils.startBtService(paramContext);
                              localList = BluetoothHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                            }
                          }
                          else {
                            localList = BluetoothHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                          }
                        }
                        else {
                          localList = SmartTagsHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                        }
                      }
                      else {
                        localList = HdmiConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
                      }
                    }
                    else {
                      TimeService.timeUpdated(paramContext);
                    }
                  }
                  else {
                    localList = LivekeyHandler.getNewHandler().onKey(paramContext, paramIntent);
                  }
                }
                else {
                  localList = UsbConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
                }
              }
              else {
                localList = UsbConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
              }
            }
            else {
              localList = SemcUsbConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
            }
          }
          else {
            localList = SemcUsbConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
          }
        }
        else {
          localList = PowerConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
        }
      }
      else {
        localList = PowerConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
      }
    }
    else if (paramIntent.getIntExtra("state", 0) != 1) {
      localList = AudioConnectionHandler.getNewHandler().onDisconnectionEvent(paramContext, paramIntent);
    } else {
      localList = AudioConnectionHandler.getNewHandler().onConnectionEvent(paramContext, paramIntent);
    }
    sendIntentsToDeviceService(paramContext, localList);
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    if (Dbg.d()) {
      Dbg.d("EventHandler.onHandleIntent " + Thread.currentThread().getName());
    }
    String str = paramIntent.getAction();
    Dbg.d("EventHandler.onHandleIntent " + str);
    if (inSmcMode(this)) {
      this.mPlugEvent = "com.sonyericsson.system.intent.action.HEADSET_PLUG";
    }
    if (!str.equals("SERVICE_ACTION"))
    {
      dispatchAction(this, paramIntent);
    }
    else
    {
      if (Dbg.d()) {
        Dbg.d("ServiceIntentCmd " + paramIntent.getExtras().getString("SERVICE_COMMAND"));
      }
      if (!paramIntent.getExtras().getString("SERVICE_COMMAND").equals("ALREADY_CONNECTED"))
      {
        if (!paramIntent.getExtras().getString("SERVICE_COMMAND").equals("INITIALIZE_APPLICATION"))
        {
          if (paramIntent.getExtras().getString("SERVICE_COMMAND").equals("UPDATE_CONFIGURATION")) {
            updateConfiguration();
          }
        }
        else {
          initializeApplication();
        }
      }
      else {
        checkAlreadyConnected(this);
      }
    }
  }
  
  public static class ServiceIntentCmd
  {
    public static final String EVENT_CHECK_ALREADY_CONNECTED = "ALREADY_CONNECTED";
    public static final String EVENT_INITIALIZE_APPLICATION = "INITIALIZE_APPLICATION";
    public static final String EVENT_UPDATE_CONFIGURATION = "UPDATE_CONFIGURATION";
    public static final String SERVICE_COMMAND_ACTION = "SERVICE_ACTION";
    public static final String SERVICE_COMMAND_KEY = "SERVICE_COMMAND";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.EventHandler
 * JD-Core Version:    0.7.0.1
 */