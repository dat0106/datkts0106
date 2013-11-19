package com.sonyericsson.extras.liveware.actions.bluetooth.a2dp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Intent;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothA2dpAction
  extends ActionForResultService
{
  private ReflectedBluetoothProfile mService;
  
  private void closeProxy(int paramInt)
  {
    BluetoothAdapter.getDefaultAdapter().closeProfileProxy(paramInt, this.mService.getProxy());
  }
  
  private void connect(int paramInt)
  {
    String str2 = getRawSetting();
    str1 = null;
    if (!TextUtils.isEmpty(str2)) {}
    try
    {
      str1 = new JSONObject(getRawSetting()).getString(getString(2131099651));
      str1 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
        continue;
        Object localObject = BluetoothAdapter.getDefaultAdapter();
        if (!((BluetoothAdapter)localObject).isEnabled()) {
          ((BluetoothAdapter)localObject).enable();
        }
        boolean bool = true;
        localObject = ((BluetoothAdapter)localObject).getRemoteDevice(str1);
        List localList = getConnectedDevices();
        Iterator localIterator;
        if ((localList != null) && (localList.size() != 0)) {
          localIterator = localList.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            if (paramInt != 2) {
              break label200;
            }
            tryConnectA2dp((BluetoothDevice)localObject, bool);
            break;
          }
          BluetoothDevice localBluetoothDevice = (BluetoothDevice)localIterator.next();
          int i = this.mService.getConnectionState(localBluetoothDevice);
          if (((i == 2) || (i == 1)) && (str1.equalsIgnoreCase(localBluetoothDevice.getAddress()))) {
            bool = false;
          }
        }
        if (paramInt == 1) {
          tryConnectHeadset((BluetoothDevice)localObject, bool);
        }
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      closeProxy(paramInt);
      replyAndStop(1);
      return;
    }
  }
  
  private List<BluetoothDevice> getConnectedDevices()
  {
    return this.mService.getNonDisconnectedSinks();
  }
  
  private void startListenerForHeadset()
  {
    if (!BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, new BluetoothProfileServiceListener(null), 1))
    {
      closeProxy(1);
      replyAndStop(1);
    }
  }
  
  private void tryConnectA2dp(BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      closeProxy(2);
      startListenerForHeadset();
    }
    else if (!this.mService.connect(paramBluetoothDevice))
    {
      closeProxy(2);
      startListenerForHeadset();
    }
    else
    {
      waitForStateChange("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
  }
  
  private void tryConnectHeadset(BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      closeProxy(1);
      replyAndStop(0);
    }
    else if (!this.mService.connect(paramBluetoothDevice))
    {
      closeProxy(1);
      replyAndStop(0);
    }
    else
    {
      waitForStateChange("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    }
  }
  
  protected void disable() {}
  
  protected void enable() {}
  
  protected void onStateChange(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    int j;
    int i;
    if (!str.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"))
    {
      if (str.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"))
      {
        j = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        i = paramIntent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
        if ((j != 0) || (i != 1))
        {
          if (j == 2)
          {
            Dbg.d("Successful bluetooth headset connect.");
            closeProxy(1);
            replyAndStop(0);
          }
        }
        else
        {
          Dbg.d("Failed to connect bluetooth headset");
          closeProxy(1);
          replyAndStop(1);
        }
      }
    }
    else
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
      j = paramIntent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
      if ((i != 0) || (j != 1))
      {
        if (i == 2)
        {
          Dbg.d("Successful A2DP connect.");
          closeProxy(2);
          startListenerForHeadset();
        }
      }
      else
      {
        Dbg.d("Failed to connect A2DP");
        closeProxy(2);
        replyAndStop(1);
      }
    }
  }
  
  protected void start(Intent paramIntent)
  {
    if (!BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, new BluetoothProfileServiceListener(null), 2))
    {
      closeProxy(2);
      replyAndStop(1);
    }
  }
  
  protected void toggle() {}
  
  private final class BluetoothProfileServiceListener
    implements BluetoothProfile.ServiceListener
  {
    private BluetoothProfileServiceListener() {}
    
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      BluetoothA2dpAction.this.mService = new ReflectedBluetoothProfile(paramBluetoothProfile);
      BluetoothA2dpAction.this.connect(paramInt);
    }
    
    public void onServiceDisconnected(int paramInt)
    {
      BluetoothA2dpAction.this.mService = null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.BluetoothA2dpAction
 * JD-Core Version:    0.7.0.1
 */