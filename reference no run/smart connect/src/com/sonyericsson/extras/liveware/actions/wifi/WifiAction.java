package com.sonyericsson.extras.liveware.actions.wifi;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class WifiAction
  extends ActionForResultService
{
  private LocalBinder mBinder = new LocalBinder();
  private int mToBeState;
  
  private boolean isWifiHotspotEnabled()
  {
    int i = WifiHotspot.getWifiHotspotState(this);
    boolean bool = false;
    if ((i == WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED) || (i == WifiHotspot.TEMP_WIFI_AP_STATE_ENABLING)) {
      bool = true;
    }
    Dbg.d("WifiAction - isWifiHotspotEnabled " + bool);
    return bool;
  }
  
  private boolean setWifiState(boolean paramBoolean)
  {
    Dbg.d("WifiAction - setWifiState " + paramBoolean);
    boolean bool;
    if ((!paramBoolean) || (!isWifiHotspotEnabled()))
    {
      bool = true;
      ((WifiManager)getSystemService("wifi")).setWifiEnabled(paramBoolean);
    }
    else
    {
      bool = false;
      Intent localIntent = new Intent(this, WifiHotspotDisabler.class);
      localIntent.putExtra("id", this.mUuid);
      startService(localIntent);
    }
    return bool;
  }
  
  protected void disable()
  {
    Dbg.d("Wifi - disable");
    this.mToBeState = 1;
    switch (((WifiManager)getSystemService("wifi")).getWifiState())
    {
    default: 
      setWifiState(false);
      waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
      break;
    case 0: 
      waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
      break;
    case 1: 
      replyAndStop(0);
    }
  }
  
  protected void enable()
  {
    this.mToBeState = 3;
    int i = ((WifiManager)getSystemService("wifi")).getWifiState();
    Dbg.d("WifiAction - enable initial wifi state " + i);
    switch (i)
    {
    default: 
      setWifiState(true);
      waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
      break;
    case 2: 
      waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
      break;
    case 3: 
      replyAndStop(0);
    }
  }
  
  public void externalWifiEnable()
  {
    Dbg.d("externalWifiEnable");
    setWifiState(true);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("wifi_state", -1);
    if (Dbg.d()) {
      Dbg.d("onStateChange  wifiState: " + i + " mToBeState: " + this.mToBeState);
    }
    if (i != this.mToBeState)
    {
      if (Dbg.d()) {
        Dbg.d("Keep waiting, state is " + i);
      }
    }
    else {
      replyAndStop(0);
    }
  }
  
  protected void toggle()
  {
    int i = 1;
    Dbg.d("Wifi - toggle");
    boolean bool;
    int j;
    switch (((WifiManager)getSystemService("wifi")).getWifiState())
    {
    default: 
      replyAndStop(i);
      break;
    case 0: 
      bool = false;
      j = 1;
      break;
    case 1: 
      bool = true;
      j = 0;
      break;
    case 2: 
      bool = true;
      j = 1;
      break;
    case 3: 
      bool = false;
      j = 0;
    }
    if (bool) {
      i = 3;
    }
    this.mToBeState = i;
    if (j == 0) {
      setWifiState(bool);
    }
    waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
  }
  
  public class LocalBinder
    extends Binder
  {
    public LocalBinder() {}
    
    WifiAction getService()
    {
      return WifiAction.this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.WifiAction
 * JD-Core Version:    0.7.0.1
 */