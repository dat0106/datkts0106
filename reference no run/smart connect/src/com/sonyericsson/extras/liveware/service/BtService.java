package com.sonyericsson.extras.liveware.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.aas.AasProtocolHandler;
import com.sonyericsson.extras.liveware.asf.AsfPacketProtocolHandler;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.UUID;

public class BtService
  extends Service
{
  private static final int AAS_INDEX = 0;
  private static final UUID AAS_UUID = UUID.fromString("8E780202-0000-1000-8000-00805f9b34fb");
  private static final int NBR_SERVERS = 1;
  private final IBinder mBinder = new BtBinder();
  private final BroadcastReceiver mBtReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent != null)
      {
        BtService.this.mState = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        if (BtService.this.mState == 13) {
          for (BtServer localBtServer : BtService.this.mServers)
          {
            Dbg.d("Btservice: Bluetooth service is turning off, closing server");
            localBtServer.terminate();
          }
        }
      }
    }
  };
  private BtServer[] mServers = new BtServer[1];
  private int mState = 12;
  
  private BtServer getNewBtServer(int paramInt)
  {
    BtServer localBtServer;
    switch (paramInt)
    {
    default: 
      localBtServer = null;
      break;
    case 0: 
      localBtServer = new BtServer("AAS", AAS_UUID, new AsfPacketProtocolHandler(), new AasProtocolHandler(this));
    }
    return localBtServer;
  }
  
  private void startServers()
  {
    for (int i = 0; i < 1; i++)
    {
      Thread.State localState = this.mServers[i].getState();
      switch (localState)
      {
      case NEW: 
        this.mServers[i].start();
        break;
      case TERMINATED: 
        this.mServers[i] = getNewBtServer(i);
        this.mServers[i].start();
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
    registerReceiver(this.mBtReceiver, localIntentFilter);
    for (int i = 0; i < 1; i++) {
      this.mServers[i] = getNewBtServer(i);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Dbg.d("Btservice: onDestroy()");
    if (this.mBtReceiver != null) {
      unregisterReceiver(this.mBtReceiver);
    }
    for (BtServer localBtServer : this.mServers) {
      if (this.mState == 12) {
        localBtServer.terminate();
      }
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    startServers();
    Dbg.d("Btservice: onStart()");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    startServers();
    return 0;
  }
  
  public void sendAsyncEvent(int paramInt1, int paramInt2)
  {
    this.mServers[0].getProtocolHandler().onAsyncEvent(paramInt1, paramInt2);
  }
  
  public class BtBinder
    extends Binder
  {
    public BtBinder() {}
    
    public BtService getService()
    {
      return BtService.this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.BtService
 * JD-Core Version:    0.7.0.1
 */