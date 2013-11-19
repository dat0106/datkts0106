package com.sonyericsson.extras.liveware.actions.wifi;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class WifiHotspotAction
  extends ActionForResultService
{
  private LocalBinder mBinder = new LocalBinder();
  private int mToBeState;
  private WifiManager mWifiManager = null;
  
  private WifiManager getWifiManager()
  {
    if (this.mWifiManager == null) {
      this.mWifiManager = ((WifiManager)getSystemService("wifi"));
    }
    return this.mWifiManager;
  }
  
  private void launchSettings()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(1342177280);
    localIntent.setClassName("com.android.settings", "com.android.settings.TetherSettings");
    startActivity(localIntent);
    replyAndStop(1);
  }
  
  private boolean setWifiHotspotState(boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject = WifiHotspot.getWifiConfiguration(this);
    WifiManager localWifiManager = getWifiManager();
    if (localObject != null)
    {
      if ((!paramBoolean) || (!localWifiManager.isWifiEnabled()))
      {
        if (!WifiHotspot.enableAp(localWifiManager, (WifiConfiguration)localObject, paramBoolean)) {
          launchSettings();
        } else {
          bool = true;
        }
      }
      else
      {
        bool = false;
        localObject = new Intent(this, WifiDisabler.class);
        ((Intent)localObject).putExtra("id", this.mUuid);
        startService((Intent)localObject);
      }
    }
    else
    {
      launchSettings();
      bool = false;
    }
    return bool;
  }
  
  protected void disable()
  {
    Dbg.d("WifiHotspot - disable");
    int i = WifiHotspot.getWifiHotspotState(this);
    this.mToBeState = WifiHotspot.TEMP_WIFI_AP_STATE_DISABLED;
    if (i != WifiHotspot.TEMP_WIFI_AP_STATE_DISABLED)
    {
      if (i != WifiHotspot.TEMP_WIFI_AP_STATE_DISABLING)
      {
        setWifiHotspotState(false);
        waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
      }
      else
      {
        waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
      }
    }
    else {
      replyAndStop(0);
    }
  }
  
  protected void enable()
  {
    int i = WifiHotspot.getWifiHotspotState(this);
    Dbg.d("WifiHotspot - enable initial hotspot state " + i);
    this.mToBeState = WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED;
    if (i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED)
    {
      if (i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLING)
      {
        setWifiHotspotState(true);
        waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
      }
      else
      {
        waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
      }
    }
    else {
      replyAndStop(0);
    }
  }
  
  public void externalApEnable()
  {
    WifiConfiguration localWifiConfiguration = WifiHotspot.getWifiConfiguration(this);
    if (!WifiHotspot.enableAp(getWifiManager(), localWifiConfiguration, true)) {
      launchSettings();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("wifi_state", -1);
    Dbg.d("onStateChange intent: " + paramIntent.getAction() + " hotspot state: " + i + " mToBeState: " + this.mToBeState);
    if (i != this.mToBeState) {
      Dbg.d("Keep waiting, hotspot state is " + i);
    } else {
      replyAndStop(0);
    }
  }
  
  protected void toggle()
  {
    Dbg.d("WifiHotspot - toggle");
    int i = WifiHotspot.getWifiHotspotState(this);
    boolean bool;
    if (i != WifiHotspot.TEMP_WIFI_AP_STATE_DISABLED)
    {
      if (i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED)
      {
        if (i != WifiHotspot.TEMP_WIFI_AP_STATE_DISABLING)
        {
          if (i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLING)
          {
            replyAndStop(1);
            return;
          }
          bool = true;
          i = 1;
        }
        else
        {
          bool = false;
          i = 1;
        }
      }
      else
      {
        bool = false;
        i = 0;
      }
    }
    else
    {
      bool = true;
      i = 0;
    }
    int j;
    if (!bool) {
      j = WifiHotspot.TEMP_WIFI_AP_STATE_DISABLED;
    } else {
      j = WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED;
    }
    this.mToBeState = j;
    if (i == 0) {
      setWifiHotspotState(bool);
    }
    waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
  }
  
  public class LocalBinder
    extends Binder
  {
    public LocalBinder() {}
    
    WifiHotspotAction getService()
    {
      return WifiHotspotAction.this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.WifiHotspotAction
 * JD-Core Version:    0.7.0.1
 */