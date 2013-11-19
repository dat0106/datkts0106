package com.sonyericsson.extras.liveware.asf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.config.ExperienceParser;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Device.DeviceEditor;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.ui.FirstTimeActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ExperienceUtils;
import com.sonyericsson.extras.liveware.utils.MillerSmartTagsParser;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.PhoneUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class DeviceServiceHandler
{
  public static int getConfiguredByTypeAndBearer(int paramInt1, int paramInt2)
  {
    int i = 2;
    switch (paramInt2)
    {
    case 4: 
    default: 
      switch (paramInt1)
      {
      default: 
        i = 1;
      }
      break;
    }
    return i;
  }
  
  public static String getExperienceName(String paramString, int paramInt)
  {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    if (str.matches("\\d+:\\d+")) {
      str = "usb_product_" + str;
    }
    str = str.replace(":", "_").replace(".", "_").replace(" ", "_").replace("-", "_");
    if (str.contentEquals("bluetooth_speaker")) {
      str = str + "s";
    }
    if (("pc".equals(str)) || ("phone".equals(str)) || ("tv".equals(str))) {
      switch (paramInt)
      {
      default: 
        Dbg.e("getExperienceName: add prefix for bearer: " + paramInt);
        break;
      case 4: 
        str = "bluetooth_" + str;
        break;
      case 5: 
        str = "wfd_" + str;
      }
    }
    return str;
  }
  
  public static String getExperienceNameByTypeAndBearer(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      if (Dbg.e()) {
        Dbg.e("getExperienceNameByTypeAndBearer: not supported for bearer: " + paramInt2);
      }
      str = null;
      break;
    case 1: 
      str = "ps3";
      break;
    case 2: 
      str = "dmr";
      break;
    case 3: 
      str = "dms";
      break;
    case 4: 
      str = "bluetooth";
      break;
    case 5: 
      str = "wfd";
      break;
    case 10: 
      str = "nfc";
    }
    switch (paramInt1)
    {
    case 1: 
      str = str + "_tv";
      break;
    case 3: 
      str = str + "_pc";
      break;
    case 5: 
      str = str + "_headset";
      break;
    case 6: 
      str = str + "_headphones";
      break;
    case 7: 
      str = str + "_speakers";
      break;
    case 8: 
      str = str + "_mouse";
      break;
    case 9: 
      str = str + "_keyboard";
      break;
    case 18: 
      str = str + "_phone";
    }
    String str = str;
    return str;
  }
  
  public static DeviceServiceHandler getNewHandler()
  {
    return new DeviceServiceHandler();
  }
  
  public static Device getPreconfigDevice(Context paramContext, String paramString, int paramInt)
  {
    Experience localExperience = getPreconfigExperience(paramContext, paramString, paramInt);
    Device localDevice = null;
    if (localExperience != null) {
      localDevice = localExperience.getDevice();
    }
    return localDevice;
  }
  
  public static Experience getPreconfigExperience(Context paramContext, String paramString, int paramInt)
  {
    return new ExperienceParser(paramContext).parse(getExperienceName(paramString, paramInt));
  }
  
  public static boolean hasConfig(Context paramContext, String paramString, int paramInt)
  {
    boolean bool;
    if (getPreconfigDevice(paramContext, paramString, paramInt) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onConnectionInfo(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras().getString("EXTRA_DEVICE_PRODUCT_ID");
    int j = paramIntent.getExtras().getInt("EXTRA_DEVICE_BEARER");
    int k = paramIntent.getExtras().getInt("EXTRA_DEVICE_TYPE");
    boolean bool = paramIntent.getExtras().getBoolean("EXTRA_DEVICE_CONNECTION_STATUS");
    int i = 0;
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Device localDevice = null;
    Object localObject2 = paramIntent.getExtras().getString("EXTRA_DEVICE_KEY_ID");
    if (localObject2 != null) {
      localDevice = localExperienceManager.getDeviceByKeyId((String)localObject2);
    }
    if (localDevice == null)
    {
      localDevice = localExperienceManager.getDeviceByProductIdAndBearer((String)localObject1, j);
      if ((localObject2 != null) && (localDevice != null)) {
        if (localDevice.getFeature(4) != null)
        {
          if (bool) {
            localExperienceManager.updateDevice(localDevice.edit().setKeyId((String)localObject2));
          }
        }
        else {
          localDevice = null;
        }
      }
    }
    if ((localDevice != null) && (localDevice.isNfc()))
    {
      ArrayList localArrayList2 = localExperienceManager.getExperiencesByDeviceId(localDevice.getId());
      if ((localArrayList2 == null) || (localArrayList2.size() == 0))
      {
        localExperienceManager.removeDevice(localDevice);
        localDevice = null;
        i = 1;
      }
    }
    if (localDevice == null)
    {
      if (Dbg.e()) {
        Dbg.e("DeviceService, productId: " + (String)localObject1 + " not found for bearer: " + j);
      }
      if (bool)
      {
        if (Dbg.d())
        {
          Dbg.d("DeviceService, Adding in database:");
          Dbg.d("PRODUCT_ID " + (String)localObject1);
          Dbg.d("STATUS " + bool);
          Dbg.d("TYPE " + k);
          Dbg.d("KEY_ID " + (String)localObject2);
          Dbg.d("BEARER " + j);
        }
        ExperienceParser localExperienceParser = new ExperienceParser(paramContext);
        String str = getExperienceName((String)localObject1, j);
        Experience localExperience2 = localExperienceParser.parse(str);
        int m = MillerSmartTagsParser.getTagIdFromName(str);
        if ((m > 0) && (m < 5) && (localExperience2 != null)) {
          MillerSmartTagsParser.parseSmartTagVersionOneTag(paramContext, m, localExperience2, null);
        }
        if (localExperience2 == null)
        {
          str = getExperienceNameByTypeAndBearer(k, j);
          if (str != null) {
            localExperience2 = localExperienceParser.parse(str);
          }
        }
        if (localExperience2 != null)
        {
          if (Dbg.d()) {
            Dbg.d("DeviceService, Found preconfigured experience: " + str);
          }
          localDevice = localExperience2.getDevice();
          if (localDevice == null)
          {
            if (Dbg.e()) {
              Dbg.e("DeviceService, No preconfigured device for experience with name: " + str);
            }
          }
          else
          {
            localDevice.setKeyId((String)localObject2);
            if (j == 10) {
              localDevice.setProductId((String)localObject1);
            }
            if (j == 4)
            {
              localDevice.setProductId((String)localObject1);
              localDevice.setUserDefinedName((String)localObject1);
              localDevice.setUserDefinedNameChanged(false);
            }
            if (TextUtils.isEmpty(localDevice.getProductName())) {
              localDevice.setUserDefinedName((String)localObject1);
            }
            localDevice.setTimestamp(System.currentTimeMillis());
            localExperience2.setDevice(localDevice);
            ExperienceUtils.handleExperienceConfigData(paramContext, localExperienceManager, localExperience2, getConfiguredByTypeAndBearer(k, j));
          }
        }
        if (i == 0) {
          SmartConnectAnalytics.trackDeviceFirstConnect(paramContext, localDevice);
        }
      }
    }
    if (localDevice == null)
    {
      if (Dbg.e()) {
        Dbg.e("Failed finding or adding device: " + (String)localObject1);
      }
    }
    else
    {
      localObject2 = null;
      if (bool)
      {
        ArrayList localArrayList1 = localExperienceManager.getExperiencesByDeviceId(localDevice.getId());
        if (localArrayList1 != null)
        {
          Iterator localIterator = localArrayList1.iterator();
          while (localIterator.hasNext())
          {
            Experience localExperience1 = (Experience)localIterator.next();
            if (localExperience1.getEnabledState() == 1) {
              localObject2 = localExperience1;
            }
          }
          if ((localObject2 != null) && (localArrayList1.size() > 1))
          {
            ((Experience)localObject2).setEnabledState(0);
            localExperienceManager.updateExperience((Experience)localObject2);
            localObject2 = null;
          }
        }
      }
      if (localObject2 == null)
      {
        if ((localDevice.isConnected() != bool) || (localDevice.isNfc()))
        {
          if ((localDevice.isNfc()) || (localExperienceManager.updateDevice(localDevice.edit().setConnected(bool))))
          {
            paramContext.startService(ExperienceService.getTriggerIntent(paramContext, 0, bool, localDevice.getId()));
            if (Dbg.d()) {
              Dbg.e("DeviceService: " + (String)localObject1 + " " + localDevice.getProductId() + " c: " + bool);
            }
          }
          else if (Dbg.e())
          {
            Dbg.e("DeviceService failed updating connected");
          }
        }
        else if (Dbg.e()) {
          Dbg.e("DeviceService, productId: " + (String)localObject1 + " still connected : " + bool);
        }
      }
      else if (!PhoneUtils.hasOngoingCall(paramContext))
      {
        FirstTimeActivity.showDialog(paramContext, (Experience)localObject2);
        if (localDevice.getTimestamp() == 0L)
        {
          localObject1 = localDevice.edit();
          ((Device.DeviceEditor)localObject1).setTimestamp(System.currentTimeMillis());
          localExperienceManager.updateDevice((Device.DeviceEditor)localObject1);
        }
      }
      if ((localDevice.getNotifyExternal()) && (AsfUtils.isMintOrHayabusa())) {
        PackageUtils.notifyExternalApps(paramContext, bool);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.DeviceServiceHandler
 * JD-Core Version:    0.7.0.1
 */