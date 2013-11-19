package com.sonyericsson.extras.liveware.asf.event;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.asf.DeviceServiceHandler;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BluetoothHandler
  extends ConnectionHandler
{
  public static final String LIVEVIEW_NAME = "LiveView";
  private Context mCtx;
  private BluetoothDevice mDevice;
  private HeadsetProxy mProxy = new HeadsetProxy(null);
  
  private static int getDeviceCategory(Context paramContext, BluetoothDevice paramBluetoothDevice)
  {
    int k = 10;
    int j = 0;
    int i = 0;
    BluetoothClass localBluetoothClass = paramBluetoothDevice.getBluetoothClass();
    if (localBluetoothClass == null)
    {
      Dbg.e("dev.getBluetoothClass() was null!");
    }
    else
    {
      j = localBluetoothClass.getMajorDeviceClass();
      i = localBluetoothClass.getDeviceClass();
      switch (i)
      {
      default: 
        if (j == 1280) {
          if ((i & 0x40) == 0)
          {
            if ((i & 0x80) != 0) {
              k = 8;
            }
          }
          else {
            k = 9;
          }
        }
        break;
      case 256: 
      case 260: 
      case 264: 
      case 268: 
      case 272: 
      case 276: 
      case 280: 
        k = 3;
        break;
      case 512: 
      case 516: 
      case 520: 
      case 524: 
      case 528: 
      case 532: 
        k = 18;
        break;
      case 1028: 
      case 1032: 
        k = 5;
        break;
      case 1044: 
      case 1064: 
        k = 7;
        break;
      case 1048: 
        k = 6;
        break;
      case 1284: 
      case 1288: 
        k = 13;
      }
    }
    if (Dbg.d()) {
      Dbg.d("bluetooth getDeviceType " + k + " selected for: " + paramBluetoothDevice.getName() + " majorClass: " + j + " devClass: " + i);
    }
    return k;
  }
  
  public static BluetoothHandler getNewHandler()
  {
    return new BluetoothHandler();
  }
  
  private List<Intent> handleBtLegacy(Context paramContext, BluetoothDevice paramBluetoothDevice)
  {
    String str = paramBluetoothDevice.getName();
    ArrayList localArrayList;
    if ((str != null) && (str.length() != 0))
    {
      if (paramBluetoothDevice.getBluetoothClass() == null)
      {
        if (!DeviceServiceHandler.hasConfig(paramContext, str, 4))
        {
          if (Dbg.e()) {
            Dbg.e("Igoring device " + str + " with getBluetoothClass() null!");
          }
          return null;
        }
        if (Dbg.d()) {
          Dbg.d("getBluetoothClass() null for wellknown device: " + str);
        }
      }
      int i = getDeviceCategory(paramContext, paramBluetoothDevice);
      if (!str.equals("LiveView"))
      {
        localArrayList = new ArrayList();
        if (paramBluetoothDevice.getBondState() != 12)
        {
          if (paramBluetoothDevice.getBondState() == 10) {
            localArrayList.add(setConnected(paramContext, null, paramBluetoothDevice.getAddress(), false, i));
          }
        }
        else if (ExperienceManager.getInstance(paramContext).getDeviceByKeyId(paramBluetoothDevice.getAddress()) != null)
        {
          localArrayList.add(setConnected(paramContext, null, paramBluetoothDevice.getAddress(), true, i));
        }
        else
        {
          if (Dbg.d()) {
            Dbg.d("Device category for bluetooth device: " + str + " is: " + i);
          }
          localArrayList.add(setConnected(paramContext, str, paramBluetoothDevice.getAddress(), true, i));
        }
      }
      else if ((ExperienceManager.getInstance(paramContext).getDeviceByProductIdAndBearer("LiveView", 4) == null) || (paramBluetoothDevice.getBondState() != 12))
      {
        localArrayList = null;
      }
      else
      {
        localArrayList = new ArrayList();
        localArrayList.add(setConnected(paramContext, "LiveView", paramBluetoothDevice.getAddress(), true, i));
      }
    }
    else
    {
      localArrayList = null;
    }
    return localArrayList;
  }
  
  private List<Intent> setAllBtDisconnected(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ExperienceManager.getInstance(paramContext).getDevicesByBearer(4).iterator();
    while (localIterator.hasNext())
    {
      Device localDevice = (Device)localIterator.next();
      if (localDevice.isConnected()) {
        localArrayList.add(setConnected(paramContext, localDevice.getProductId(), localDevice.getKeyId(), false, 10));
      }
    }
    return localArrayList;
  }
  
  private Intent setConnected(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    return DeviceService.getDeviceConnectionIntent(paramContext, paramString1, paramBoolean, paramInt, 4, paramString2);
  }
  
  public List<Intent> onAdapterStateChanged(Context paramContext, Intent paramIntent)
  {
    if (Dbg.v()) {
      Dbg.v("Recieved a change in the bluetooth adapter.");
    }
    int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
    if (i == 12)
    {
      if (Dbg.v()) {
        Dbg.v("Bluetooth adapter is now on.");
      }
      AsfUtils.startBtService(paramContext);
    }
    List localList;
    if (i != 10)
    {
      localList = null;
    }
    else
    {
      if (Dbg.v()) {
        Dbg.v("Bluetooth adapter is now off.");
      }
      AsfUtils.stopBtService(paramContext);
      localList = setAllBtDisconnected(paramContext);
    }
    return localList;
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    this.mDevice = localBluetoothDevice;
    this.mCtx = paramContext;
    if (Dbg.d()) {
      Dbg.d("onConnectionEvent " + paramIntent + " dev.getBondState(): " + localBluetoothDevice.getBondState());
    }
    int i = getDeviceCategory(paramContext, localBluetoothDevice);
    Object localObject;
    if ((!paramIntent.getAction().equals("android.bluetooth.device.action.ACL_CONNECTED")) || ((i != 6) && (i != 5) && (i != 7)))
    {
      localObject = handleBtLegacy(paramContext, localBluetoothDevice);
    }
    else
    {
      localObject = BluetoothAdapter.getDefaultAdapter();
      ((BluetoothAdapter)localObject).getProfileProxy(paramContext, this.mProxy, 1);
      ((BluetoothAdapter)localObject).getProfileProxy(paramContext, this.mProxy, 2);
      localObject = null;
    }
    return localObject;
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(setConnected(paramContext, null, localBluetoothDevice.getAddress(), false, 10));
    return localArrayList;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent) {}
  
  private class HeadsetProxy
    implements BluetoothProfile.ServiceListener
  {
    boolean mNoA2dp = false;
    boolean mNoHeadset = false;
    
    private HeadsetProxy() {}
    
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      if ((paramInt == 1) && (paramBluetoothProfile.getConnectionState(BluetoothHandler.this.mDevice) == 0)) {
        this.mNoHeadset = true;
      }
      if ((paramInt == 2) && (paramBluetoothProfile.getConnectionState(BluetoothHandler.this.mDevice) == 0)) {
        this.mNoA2dp = true;
      }
      if ((this.mNoA2dp) && (this.mNoHeadset))
      {
        Object localObject = BluetoothHandler.this.handleBtLegacy(BluetoothHandler.this.mCtx, BluetoothHandler.this.mDevice);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Intent localIntent = (Intent)((Iterator)localObject).next();
            BluetoothHandler.this.mCtx.startService(localIntent);
          }
        }
      }
    }
    
    public void onServiceDisconnected(int paramInt) {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.BluetoothHandler
 * JD-Core Version:    0.7.0.1
 */