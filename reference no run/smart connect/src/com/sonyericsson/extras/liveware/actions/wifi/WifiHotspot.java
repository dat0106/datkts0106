package com.sonyericsson.extras.liveware.actions.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.NetworkUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WifiHotspot
  extends AbstractAction
{
  public static final String TEMP_EXTRA_WIFI_AP_STATE = "wifi_state";
  public static final String TEMP_WIFI_AP_STATE_CHANGED = "android.net.wifi.WIFI_AP_STATE_CHANGED";
  public static final int TEMP_WIFI_AP_STATE_DISABLED = 0;
  public static final int TEMP_WIFI_AP_STATE_DISABLING = 0;
  public static final int TEMP_WIFI_AP_STATE_ENABLED = 0;
  public static final int TEMP_WIFI_AP_STATE_ENABLING = 0;
  public static final int TEMP_WIFI_AP_STATE_UNKNOWN = -1;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT < 14) {
      i = 0;
    } else {
      i = 10;
    }
    TEMP_WIFI_AP_STATE_DISABLING = i;
    if (Build.VERSION.SDK_INT < 14) {
      i = 1;
    } else {
      i = 11;
    }
    TEMP_WIFI_AP_STATE_DISABLED = i;
    if (Build.VERSION.SDK_INT < 14) {
      i = 2;
    } else {
      i = 12;
    }
    TEMP_WIFI_AP_STATE_ENABLING = i;
    if (Build.VERSION.SDK_INT < 14) {
      i = 3;
    } else {
      i = 13;
    }
    TEMP_WIFI_AP_STATE_ENABLED = i;
  }
  
  public WifiHotspot()
  {
    super(WifiHotspot.class.getSimpleName());
  }
  
  public static boolean enableAp(WifiManager paramWifiManager, WifiConfiguration paramWifiConfiguration, boolean paramBoolean)
  {
    int i = 0;
    boolean bool = false;
    StringBuilder localStringBuilder = new StringBuilder("Changing AP state: ");
    Object localObject1;
    int j;
    if (paramBoolean)
    {
      localObject1 = "ON";
      Dbg.d((String)localObject1);
      localObject1 = paramWifiManager.getClass().getDeclaredMethods();
      j = localObject1.length;
    }
    for (;;)
    {
      if (i >= j)
      {
        return bool;
        localObject1 = "OFF";
        break;
      }
      Object localObject2 = localObject1[i];
      if (localObject2.getName().equals("setWifiApEnabled")) {}
      try
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramWifiConfiguration;
        arrayOfObject[1] = Boolean.valueOf(paramBoolean);
        bool = ((Boolean)localObject2.invoke(paramWifiManager, arrayOfObject)).booleanValue();
        bool = bool;
        i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          localInvocationTargetException.printStackTrace();
        }
      }
    }
  }
  
  public static WifiConfiguration getWifiConfiguration(Context paramContext)
  {
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    Method[] arrayOfMethod = localWifiManager.getClass().getDeclaredMethods();
    WifiConfiguration localWifiConfiguration = null;
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localWifiConfiguration;
      }
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("getWifiApConfiguration")) {}
      try
      {
        localWifiConfiguration = (WifiConfiguration)localMethod.invoke(localWifiManager, new Object[0]);
        i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          localInvocationTargetException.printStackTrace();
        }
      }
    }
  }
  
  public static int getWifiHotspotState(Context paramContext)
  {
    int k = -1;
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    Method[] arrayOfMethod;
    int i;
    int j;
    if (localWifiManager != null)
    {
      arrayOfMethod = localWifiManager.getClass().getDeclaredMethods();
      i = arrayOfMethod.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i)
      {
        Dbg.d("getWifiHotspotState state: " + k);
        return k;
      }
      Method localMethod = arrayOfMethod[j];
      if (localMethod.getName().equals("getWifiApState")) {}
      try
      {
        k = ((Integer)localMethod.invoke(localWifiManager, new Object[0])).intValue();
        k = k;
        j++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean isWifiHotspotEnabled(Context paramContext)
  {
    boolean bool = false;
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    Method[] arrayOfMethod = localWifiManager.getClass().getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    for (;;)
    {
      if (j >= i) {
        return bool;
      }
      Method localMethod = arrayOfMethod[j];
      if (localMethod.getName().equals("isWifiApEnabled")) {}
      try
      {
        bool = ((Boolean)localMethod.invoke(localWifiManager, new Object[0])).booleanValue();
        bool = bool;
        j++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, WifiHotspotAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return ActionUtils.getSettingsHandlerIntent(paramContext, paramIntent);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return OnOffToggleActivity.getLabelByRawSetting(paramContext, paramIntent.getExtras().getString("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, WifiHotspotActivity.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool;
    if ((!NetworkUtils.deviceHasMobileNetwork(paramContext)) || (getWifiHotspotState(paramContext) == -1)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.WifiHotspot
 * JD-Core Version:    0.7.0.1
 */