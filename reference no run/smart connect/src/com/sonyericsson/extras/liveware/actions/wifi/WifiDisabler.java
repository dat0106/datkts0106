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

public class WifiDisabler
  extends Service
{
  WifiHotspotAction mBoundService = null;
  private Runnable mGiveUpStopSelfRunner = new Runnable()
  {
    public void run()
    {
      Dbg.d("Timeout, shut down.");
      WifiDisabler.this.stopSelf();
    }
  };
  private Handler mHandler = new Handler();
  private Receiver mReceiver = null;
  private ServiceConnection mServiceConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Dbg.d("Service CONNECTED");
      WifiDisabler.this.mBoundService = ((WifiHotspotAction.LocalBinder)paramAnonymousIBinder).getService();
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Dbg.d("Service DISCONNECTED");
    }
  };
  
  private void onStateChange(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("wifi_state", -1);
    if ((i != 2) && (i != 0))
    {
      if (i == 1)
      {
        Dbg.d("Now disabled, will stop self.");
        if (this.mBoundService == null) {
          Dbg.e("WifiDisabler. onStateChange mBoundService != null");
        } else {
          this.mBoundService.externalApEnable();
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
      Dbg.d("WifiDisabler onDestroy.");
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
      int i = localWifiManager.getWifiState();
      Dbg.d("WifiDisabler wifiState: " + i);
      if ((i != 3) && (i != 2))
      {
        stopSelf();
      }
      else
      {
        bindService(new Intent(this, WifiHotspotAction.class), this.mServiceConnection, 0);
        localWifiManager.setWifiEnabled(false);
        waitForStateChange("android.net.wifi.WIFI_STATE_CHANGED");
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
      WifiDisabler.this.onStateChange(paramIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.WifiDisabler
 * JD-Core Version:    0.7.0.1
 */