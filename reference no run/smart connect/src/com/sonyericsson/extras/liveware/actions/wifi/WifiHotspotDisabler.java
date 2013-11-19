package com.sonyericsson.extras.liveware.actions.wifi;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class WifiHotspotDisabler
  extends Service
{
  WifiAction mBoundService = null;
  private Runnable mGiveUpStopSelfRunner = new Runnable()
  {
    public void run()
    {
      Dbg.d("Timeout, shut down.");
      WifiHotspotDisabler.this.stopSelf();
    }
  };
  private Handler mHandler = new Handler();
  private Receiver mReceiver = null;
  private ServiceConnection mServiceConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Dbg.d("Service CONNECTED");
      WifiHotspotDisabler.this.mBoundService = ((WifiAction.LocalBinder)paramAnonymousIBinder).getService();
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Dbg.d("Service DISCONNECTED");
    }
  };
  
  private void onStateChange(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("wifi_state", -1);
    Dbg.d("onStateChange hotspotState: " + i + " " + paramIntent.getAction());
    if ((i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLING) && (i != WifiHotspot.TEMP_WIFI_AP_STATE_DISABLING))
    {
      if (i == WifiHotspot.TEMP_WIFI_AP_STATE_DISABLED)
      {
        Dbg.d("Now disabled, will stop self.");
        if (this.mBoundService == null) {
          Dbg.e("onStateChange mBoundService != null");
        } else {
          this.mBoundService.externalWifiEnable();
        }
        stopSelf();
      }
    }
    else {
      Dbg.d("ING-state, no answer yet.");
    }
  }
  
  private void waitForStateChange(String paramString)
  {
    IntentFilter localIntentFilter = new IntentFilter(paramString);
    this.mReceiver = new Receiver(null);
    registerReceiver(this.mReceiver, localIntentFilter);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mServiceConnection != null) {}
    try
    {
      unbindService(this.mServiceConnection);
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacks(this.mGiveUpStopSelfRunner);
        this.mHandler = null;
      }
      Dbg.d("WifiHotspotDisabler onDestroy.");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.d("Whatever.");
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      stopSelf();
      Dbg.d("startCommand, null intent");
    }
    else
    {
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      int i = WifiHotspot.getWifiHotspotState(this);
      Dbg.d("hotSpotState: " + i);
      if ((i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLED) && (i != WifiHotspot.TEMP_WIFI_AP_STATE_ENABLING))
      {
        stopSelf();
      }
      else
      {
        bindService(new Intent(this, WifiAction.class), this.mServiceConnection, 0);
        WifiHotspot.enableAp(localWifiManager, WifiHotspot.getWifiConfiguration(this), false);
        waitForStateChange("android.net.wifi.WIFI_AP_STATE_CHANGED");
        this.mHandler.postDelayed(this.mGiveUpStopSelfRunner, 10000L);
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  private class Receiver
    extends BroadcastReceiver
  {
    private Receiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      WifiHotspotDisabler.this.onStateChange(paramIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.WifiHotspotDisabler
 * JD-Core Version:    0.7.0.1
 */