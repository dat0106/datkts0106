package com.sonyericsson.extras.liveware.actions.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class BluetoothAction
  extends ActionForResultService
{
  protected void disable()
  {
    Dbg.d("Bluetooth - disable");
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    int i = localBluetoothAdapter.getState();
    if ((i != 12) && (i != 11))
    {
      replyAndStop(0);
    }
    else
    {
      localBluetoothAdapter.disable();
      waitForStateChange("android.bluetooth.adapter.action.STATE_CHANGED");
    }
  }
  
  protected void enable()
  {
    Dbg.d("Bluetooth - enable");
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    int i = localBluetoothAdapter.getState();
    if ((i != 10) && (i != 13))
    {
      replyAndStop(0);
    }
    else
    {
      localBluetoothAdapter.enable();
      waitForStateChange("android.bluetooth.adapter.action.STATE_CHANGED");
    }
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
    if ((i != 13) && (i != 11)) {
      replyAndStop(0);
    } else {
      Dbg.d("ING-state, no answer yet.");
    }
  }
  
  protected void toggle()
  {
    Dbg.d("Bluetooth - toggle");
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter.getState() != 12) {
      localBluetoothAdapter.enable();
    } else {
      localBluetoothAdapter.disable();
    }
    waitForStateChange("android.bluetooth.adapter.action.STATE_CHANGED");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.BluetoothAction
 * JD-Core Version:    0.7.0.1
 */