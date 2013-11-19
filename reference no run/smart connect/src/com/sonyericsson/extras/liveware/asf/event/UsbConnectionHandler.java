package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.asf.DeviceServiceHandler;
import com.sonyericsson.extras.liveware.ui.FlapActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UsbConnectionHandler
  extends ConnectionHandler
{
  private static final int PROTOCOL_KEYBOARD = 1;
  private static final int PROTOCOL_MOUSE = 2;
  private static LinkedList<OtgJitterHandler> sOtgJitterQueue = new LinkedList();
  
  private String getClassBasedProductId(UsbDevice paramUsbDevice)
  {
    String str = null;
    for (int i = 0;; i++) {
      if (i < paramUsbDevice.getInterfaceCount())
      {
        str = getClassProductId(paramUsbDevice.getInterface(i));
        if (str == null) {}
      }
      else
      {
        return str;
      }
    }
  }
  
  private String getClassProductId(UsbInterface paramUsbInterface)
  {
    String str = null;
    int i = paramUsbInterface.getInterfaceClass();
    switch (i)
    {
    case 1: 
      str = "usb_class:Audio";
      break;
    case 3: 
      switch (paramUsbInterface.getInterfaceProtocol())
      {
      default: 
        str = "usb_class:Gamepad";
        break;
      case 1: 
        str = "usb_class:Keyboard";
        break;
      case 2: 
        str = "usb_class:Mouse";
      }
      break;
    case 8: 
      str = "usb_class:MassStorage";
    }
    if (Dbg.d()) {
      Dbg.d("USB class: " + i);
    }
    return str;
  }
  
  public static UsbConnectionHandler getNewHandler()
  {
    return new UsbConnectionHandler();
  }
  
  public static String getProductId(int paramInt1, int paramInt2)
  {
    return paramInt1 + ":" + paramInt2;
  }
  
  private List<Intent> handleUsbConnection(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    Dbg.d("UsbConnectionHandler.handleUsbConnection");
    Object localObject1 = (UsbDevice)paramIntent.getParcelableExtra("device");
    if (localObject1 != null)
    {
      Dbg.d("UsbConnectionHandler.handleUsbConnection " + ((UsbDevice)localObject1).getDeviceName());
      for (Object localObject2 = (OtgJitterHandler)sOtgJitterQueue.poll(); localObject2 != null; localObject2 = (OtgJitterHandler)sOtgJitterQueue.poll()) {
        if (((OtgJitterHandler)localObject2).isWaitingOnJitter()) {
          break label226;
        }
      }
      localObject2 = getProductId(((UsbDevice)localObject1).getVendorId(), ((UsbDevice)localObject1).getProductId());
      Dbg.d("productId " + (String)localObject2);
      if (!DeviceServiceHandler.hasConfig(paramContext, (String)localObject2, 6))
      {
        localObject1 = getClassBasedProductId((UsbDevice)localObject1);
        Dbg.d("devClassName " + (String)localObject1);
        if (localObject1 != null) {
          localObject2 = localObject1;
        }
      }
      else
      {
        Dbg.d("productId " + (String)localObject2);
        localArrayList = new ArrayList();
        localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, (String)localObject2, true, 10, 6, null));
        localArrayList = localArrayList;
      }
    }
    label226:
    return localArrayList;
  }
  
  private void handleUsbDisconnection(Context paramContext, Intent paramIntent)
  {
    Object localObject2 = (UsbDevice)paramIntent.getParcelableExtra("device");
    if (localObject2 != null)
    {
      Dbg.d("UsbConnectionHandler.handleUsbDisconnection " + ((UsbDevice)localObject2).getDeviceName());
      Object localObject1 = getProductId(((UsbDevice)localObject2).getVendorId(), ((UsbDevice)localObject2).getProductId());
      Dbg.d("productId " + (String)localObject1);
      if (!DeviceServiceHandler.hasConfig(paramContext, (String)localObject1, 6))
      {
        localObject2 = getClassBasedProductId((UsbDevice)localObject2);
        Dbg.d("devClassName " + (String)localObject1);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      else
      {
        Dbg.d("productId " + (String)localObject1);
        sOtgJitterQueue.add(new OtgJitterHandler(paramContext, (String)localObject1));
      }
    }
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("UsbConnectionHandler onConnectionEvent");
    return handleUsbConnection(paramContext, paramIntent, true);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("UsbConnectionHandler onDisconnectionEvent");
    handleUsbDisconnection(paramContext, paramIntent);
    return null;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    Dbg.d("UsbConnectionHandler onStartup");
    handleUsbConnection(paramContext, paramIntent, false);
  }
  
  public static class OtgJitterHandler
  {
    private Timer mOtgJitterTimer;
    private boolean mWaitingOnJitter;
    
    OtgJitterHandler(final Context paramContext, final String paramString)
    {
      TimerTask local1 = new TimerTask()
      {
        public void run()
        {
          Intent localIntent = DeviceService.getDeviceConnectionIntent(paramContext, paramString, false, 10, 6, null);
          if (!AsfUtils.isWaterproof(paramContext))
          {
            paramContext.startService(localIntent);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localIntent);
            FlapActivity.show(paramContext, localArrayList);
          }
          UsbConnectionHandler.OtgJitterHandler.this.mWaitingOnJitter = false;
        }
      };
      this.mWaitingOnJitter = true;
      this.mOtgJitterTimer = new Timer();
      this.mOtgJitterTimer.schedule(local1, 3000L);
    }
    
    boolean isWaitingOnJitter()
    {
      boolean bool = false;
      if ((this.mOtgJitterTimer != null) && (this.mWaitingOnJitter))
      {
        this.mOtgJitterTimer.cancel();
        this.mOtgJitterTimer = null;
        this.mWaitingOnJitter = false;
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.UsbConnectionHandler
 * JD-Core Version:    0.7.0.1
 */