package com.sonyericsson.extras.liveware.actions.bluetooth.a2dp;

import android.bluetooth.BluetoothClass;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ReflectionUtils;
import java.lang.reflect.Method;

public class ReflectedBluetoothClass
{
  private static String ACTUAL_CLASSNAME = "android.bluetooth.BluetoothClass";
  public static final int PROFILE_A2DP = ((Integer)ReflectionUtils.getStaticField(ACTUAL_CLASSNAME, "PROFILE_A2DP")).intValue();
  public static final int PROFILE_HEADSET = ((Integer)ReflectionUtils.getStaticField(ACTUAL_CLASSNAME, "PROFILE_HEADSET")).intValue();
  private BluetoothClass mInstance;
  
  ReflectedBluetoothClass(BluetoothClass paramBluetoothClass)
  {
    this.mInstance = paramBluetoothClass;
  }
  
  public boolean doesClassMatch(int paramInt)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = this.mInstance.getClass();
      Object localObject2 = new Class[1];
      localObject2[0] = Integer.TYPE;
      Method localMethod = ((Class)localObject1).getMethod("doesClassMatch", (Class[])localObject2);
      localObject2 = this.mInstance;
      localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(paramInt);
      bool = ((Boolean)localMethod.invoke(localObject2, (Object[])localObject1)).booleanValue();
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
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.ReflectedBluetoothClass
 * JD-Core Version:    0.7.0.1
 */