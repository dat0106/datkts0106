package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.asf.DeviceServiceHandler;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SemcUsbConnectionHandler
  extends ConnectionHandler
{
  private static final int PROTOCOL_KEYBOARD = 1;
  private static final int PROTOCOL_MOUSE = 2;
  private static final String TEST_USBDEVICE_CLASSNAME = "com.sonyericsson.extras.test.UsbDevice";
  private static final String USBDEVICE_CLASSNAME = "com.sonyericsson.hardware.UsbDevice";
  private static final int USB_CLASS_AUDIO = 1;
  private static final int USB_CLASS_HID = 3;
  private static final int USB_CLASS_STORAGE = 8;
  private static LinkedList<OtgJitterHandler> sOtgJitterQueue = new LinkedList();
  
  private String getClassProductId(ReflectedUsbDevice paramReflectedUsbDevice)
  {
    String str = null;
    switch (paramReflectedUsbDevice.getDeviceClass())
    {
    case 1: 
      str = "usb_class:Audio";
      break;
    case 3: 
      switch (paramReflectedUsbDevice.getDeviceProtocol())
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
    return str;
  }
  
  public static SemcUsbConnectionHandler getNewHandler()
  {
    return new SemcUsbConnectionHandler();
  }
  
  private static ReflectedUsbDevice getReflectedDevice(Intent paramIntent)
  {
    try
    {
      localReflectedUsbDevice = new ReflectedUsbDevice(paramIntent, Class.forName("com.sonyericsson.hardware.UsbDevice"));
      return localReflectedUsbDevice;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Dbg.d("The system doesn't support UsbDevice");
        localReflectedUsbDevice = tryWithTestDeviceClass(paramIntent);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ReflectedUsbDevice localReflectedUsbDevice = tryWithTestDeviceClass(paramIntent);
      }
    }
  }
  
  private List<Intent> handleDeviceConnection(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = getReflectedDevice(paramIntent);
    if (localObject2 != null)
    {
      for (OtgJitterHandler localOtgJitterHandler = (OtgJitterHandler)sOtgJitterQueue.poll(); localOtgJitterHandler != null; localOtgJitterHandler = (OtgJitterHandler)sOtgJitterQueue.poll()) {
        if (localOtgJitterHandler.isWaitingOnJitter()) {
          break label128;
        }
      }
      localObject1 = UsbConnectionHandler.getProductId(((ReflectedUsbDevice)localObject2).getVendorId(), ((ReflectedUsbDevice)localObject2).getProductId());
      if (!DeviceServiceHandler.hasConfig(paramContext, (String)localObject1, 6))
      {
        localObject2 = getClassProductId((ReflectedUsbDevice)localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      localObject2 = new ArrayList();
      ((List)localObject2).add(DeviceService.getDeviceConnectionIntent(paramContext, (String)localObject1, true, 10, 6, null));
      localObject1 = localObject2;
    }
    label128:
    return localObject1;
  }
  
  private void handleDeviceIdDisconnection(Context paramContext, Intent paramIntent)
  {
    Object localObject2 = getReflectedDevice(paramIntent);
    if (localObject2 != null)
    {
      Object localObject1 = UsbConnectionHandler.getProductId(((ReflectedUsbDevice)localObject2).getVendorId(), ((ReflectedUsbDevice)localObject2).getProductId());
      if (!DeviceServiceHandler.hasConfig(paramContext, (String)localObject1, 6))
      {
        localObject2 = getClassProductId((ReflectedUsbDevice)localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      sOtgJitterQueue.add(new OtgJitterHandler(paramContext, (String)localObject1));
    }
  }
  
  private static ReflectedUsbDevice tryWithTestDeviceClass(Intent paramIntent)
  {
    try
    {
      Dbg.v("Usb test device");
      localReflectedUsbDevice = new ReflectedUsbDevice(paramIntent, Class.forName("com.sonyericsson.extras.test.UsbDevice"));
      return localReflectedUsbDevice;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Dbg.e("The system doesn't support UsbDevice");
        ReflectedUsbDevice localReflectedUsbDevice = null;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Dbg.e("Test program and LWM have unsynced UsbDevice classes.");
      }
    }
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return handleDeviceConnection(paramContext, paramIntent, true);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    handleDeviceIdDisconnection(paramContext, paramIntent);
    return null;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    handleDeviceConnection(paramContext, paramIntent, true);
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
          paramContext.startService(localIntent);
          SemcUsbConnectionHandler.OtgJitterHandler.this.mWaitingOnJitter = false;
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
  
  private static class ReflectedUsbDevice
  {
    Object mDevice;
    Class<?> mDeviceClass;
    
    public ReflectedUsbDevice(Intent paramIntent, Class<?> paramClass)
    {
      this.mDeviceClass = paramClass;
      this.mDevice = this.mDeviceClass.cast(paramIntent.getParcelableExtra("com.sonyericsson.hardware.usb_otg_device"));
      Dbg.v("Got a: " + this.mDeviceClass.getName());
    }
    
    public int getDeviceClass()
    {
      int j = 0;
      try
      {
        int i = ((Integer)this.mDeviceClass.getMethod("getDeviceClass", new Class[0]).invoke(this.mDevice, new Object[0])).intValue();
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
        }
      }
      return j;
    }
    
    public int getDeviceProtocol()
    {
      int i = 0;
      try
      {
        i = ((Integer)this.mDeviceClass.getMethod("getDeviceProtocol", new Class[0]).invoke(this.mDevice, new Object[0])).intValue();
        i = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
        }
      }
      return i;
    }
    
    public int getDeviceSubclass()
    {
      int i = 0;
      try
      {
        i = ((Integer)this.mDeviceClass.getMethod("getDeviceSubclass", new Class[0]).invoke(this.mDevice, new Object[0])).intValue();
        i = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
        }
      }
      return i;
    }
    
    public int getProductId()
    {
      int j = 0;
      try
      {
        int i = ((Integer)this.mDeviceClass.getMethod("getProductId", new Class[0]).invoke(this.mDevice, new Object[0])).intValue();
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
        }
      }
      return j;
    }
    
    public String getSerialNumber()
    {
      try
      {
        String str1 = (String)this.mDeviceClass.getMethod("getSerialNumber", new Class[0]).invoke(this.mDevice, new Object[0]);
        return str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
          String str2 = "";
        }
      }
    }
    
    public int getVendorId()
    {
      int j = 0;
      try
      {
        int i = ((Integer)this.mDeviceClass.getMethod("getVendorId", new Class[0]).invoke(this.mDevice, new Object[0])).intValue();
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("No such method", localException);
        }
      }
      return j;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.SemcUsbConnectionHandler
 * JD-Core Version:    0.7.0.1
 */