package com.sonyericsson.extras.liveware.actions.bluetooth.a2dp;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectedBluetoothProfile
{
  private Object mInstance = null;
  
  public ReflectedBluetoothProfile(BluetoothProfile paramBluetoothProfile)
  {
    this.mInstance = paramBluetoothProfile;
  }
  
  private List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] paramArrayOfInt)
  {
    List localList = null;
    try
    {
      Object localObject1 = this.mInstance.getClass();
      Object localObject2 = new Class[1];
      localObject2[0] = [I.class;
      Method localMethod = ((Class)localObject1).getMethod("getDevicesMatchingConnectionStates", (Class[])localObject2);
      localObject1 = this.mInstance;
      localObject2 = new Object[1];
      localObject2[0] = paramArrayOfInt;
      localList = (List)localMethod.invoke(localObject1, (Object[])localObject2);
      return localList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Stuff went wrong.", localException);
      }
    }
  }
  
  private boolean internalConnect(BluetoothDevice paramBluetoothDevice)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = this.mInstance.getClass();
      Object localObject2 = new Class[1];
      localObject2[0] = BluetoothDevice.class;
      Method localMethod = ((Class)localObject1).getMethod("connect", (Class[])localObject2);
      localObject1 = this.mInstance;
      localObject2 = new Object[1];
      localObject2[0] = paramBluetoothDevice;
      bool = ((Boolean)localMethod.invoke(localObject1, (Object[])localObject2)).booleanValue();
      bool = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Stuff went wrong.", localException);
      }
    }
    return bool;
  }
  
  private boolean internalDisconnect(BluetoothDevice paramBluetoothDevice)
  {
    boolean bool = false;
    try
    {
      Object localObject2 = this.mInstance.getClass();
      Object localObject1 = new Class[1];
      localObject1[0] = BluetoothDevice.class;
      Method localMethod = ((Class)localObject2).getMethod("disconnect", (Class[])localObject1);
      localObject1 = this.mInstance;
      localObject2 = new Object[1];
      localObject2[0] = paramBluetoothDevice;
      bool = ((Boolean)localMethod.invoke(localObject1, (Object[])localObject2)).booleanValue();
      bool = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Stuff went wrong.", localException);
      }
    }
    return bool;
  }
  
  private int internalGetConnectionState(BluetoothDevice paramBluetoothDevice)
  {
    int i = 0;
    try
    {
      Object localObject1 = this.mInstance.getClass();
      Object localObject2 = new Class[1];
      localObject2[0] = BluetoothDevice.class;
      localObject2 = ((Class)localObject1).getMethod("getConnectionState", (Class[])localObject2);
      Object localObject3 = this.mInstance;
      localObject1 = new Object[1];
      localObject1[0] = paramBluetoothDevice;
      i = ((Integer)((Method)localObject2).invoke(localObject3, (Object[])localObject1)).intValue();
      i = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Stuff went wrong.", localException);
      }
    }
    return i;
  }
  
  public boolean connect(BluetoothDevice paramBluetoothDevice)
  {
    return internalConnect(paramBluetoothDevice);
  }
  
  public boolean disconnect(BluetoothDevice paramBluetoothDevice)
  {
    return internalDisconnect(paramBluetoothDevice);
  }
  
  public int getConnectionState(BluetoothDevice paramBluetoothDevice)
  {
    return internalGetConnectionState(paramBluetoothDevice);
  }
  
  public List<BluetoothDevice> getNonDisconnectedSinks()
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 2;
    arrayOfInt[1] = 1;
    arrayOfInt[2] = 3;
    return getDevicesMatchingConnectionStates(arrayOfInt);
  }
  
  public BluetoothProfile getProxy()
  {
    return (BluetoothProfile)this.mInstance;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.ReflectedBluetoothProfile
 * JD-Core Version:    0.7.0.1
 */