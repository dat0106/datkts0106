package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.config.ConfigReader;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Device.DeviceEditor;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ExperienceUtils
{
  private static String getLocalizedName(Context paramContext, String paramString)
  {
    Object localObject = null;
    String str = paramContext.getString(paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName()));
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    return localObject;
  }
  
  public static int getUserDefNameResourceId(Context paramContext, Resources paramResources, String paramString)
  {
    int i = paramResources.getIdentifier("name_" + paramString.toLowerCase(Locale.ENGLISH).replace(" ", "_").replace("-", "_"), "string", paramContext.getPackageName());
    if (i == 0)
    {
      String str = handleSpecificDeviceNames(paramString);
      if (str != null) {
        i = paramResources.getIdentifier(str, "string", paramContext.getPackageName());
      }
    }
    return i;
  }
  
  public static void handleExperienceConfigData(Context paramContext, ExperienceManager paramExperienceManager, Experience paramExperience, int paramInt)
  {
    Object localObject3 = paramExperience.getDevice();
    if (localObject3 != null)
    {
      Object localObject2 = paramExperience.getStartActions();
      Object localObject1 = paramExperience.getStopActions();
      ((Device)localObject3).setConfigured(paramInt);
      if ((paramExperienceManager.addDevice((Device)localObject3) != null) && (paramInt == 1) && (((localObject2 != null) && (((List)localObject2).size() > 0)) || ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramExperienceManager.addExperience(paramExperience) != null))))
      {
        if (localObject2 != null)
        {
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (ActionSet)((Iterator)localObject3).next();
            if (!((ActionSet)localObject2).getAction().isDisabled()) {
              ((ActionSet)localObject2).settingsInject(paramContext);
            }
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActionSet)((Iterator)localObject1).next();
            if (!((ActionSet)localObject2).getAction().isDisabled()) {
              ((ActionSet)localObject2).settingsInject(paramContext);
            }
          }
        }
      }
    }
  }
  
  private static String handleSpecificDeviceNames(String paramString)
  {
    String str;
    if (!paramString.equals("usb_class:Audio"))
    {
      if (!paramString.equals("usb_class:Mouse"))
      {
        if (!paramString.equals("usb_class:Keyboard"))
        {
          if (!paramString.equals("usb_class:GameController"))
          {
            if (!paramString.equals("usb_class:MassStorage"))
            {
              if (!paramString.equals("usb_class:USBGeneric"))
              {
                if (!paramString.equals("Bluetooth gamecontroller"))
                {
                  if (!paramString.equals("Bluetooth headphones"))
                  {
                    if (!paramString.equals("Bluetooth headset"))
                    {
                      if (!paramString.equals("Bluetooth keyboard"))
                      {
                        if (!paramString.equals("Bluetooth mouse"))
                        {
                          if (!paramString.equals("Bluetooth speaker"))
                          {
                            if (!paramString.equals("4046:53610"))
                            {
                              if (!paramString.equals("4046:53626"))
                              {
                                if (!paramString.equals("4046:65535")) {
                                  str = null;
                                } else {
                                  str = "name_smartdock";
                                }
                              }
                              else {
                                str = "name_smartdock";
                              }
                            }
                            else {
                              str = "name_itchy";
                            }
                          }
                          else {
                            str = "name_bt_speakers";
                          }
                        }
                        else {
                          str = "name_bt_mouse";
                        }
                      }
                      else {
                        str = "name_bt_keyboard";
                      }
                    }
                    else {
                      str = "name_bt_headset";
                    }
                  }
                  else {
                    str = "name_bt_headset";
                  }
                }
                else {
                  str = "name_bt_gamepad";
                }
              }
              else {
                str = "name_usb_device";
              }
            }
            else {
              str = "name_usb_disk";
            }
          }
          else {
            str = "name_usb_gamepad";
          }
        }
        else {
          str = "name_usb_keyboard";
        }
      }
      else {
        str = "name_usb_mouse";
      }
    }
    else {
      str = "name_usb_speakers";
    }
    return str;
  }
  
  public static void importPredefinedExperiencesAndDevices(Context paramContext, int paramInt)
  {
    Object localObject2 = new ConfigReader();
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = ((ConfigReader)localObject2).readPreConfiguredExperinces(paramContext);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          handleExperienceConfigData(paramContext, localExperienceManager, (Experience)((Iterator)localObject1).next(), 1);
        }
      }
    }
    if (paramInt < 6)
    {
      localObject1 = localExperienceManager.getNotConfiguredDevices();
      localObject2 = ((ConfigReader)localObject2).readPreConfiguredDevices(paramContext);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        Iterator localIterator2 = ((ArrayList)localObject2).iterator();
        while (localIterator2.hasNext())
        {
          Experience localExperience = (Experience)localIterator2.next();
          int i = 0;
          localObject2 = localExperience.getDevice();
          if (localObject2 != null)
          {
            Iterator localIterator1 = ((ArrayList)localObject1).iterator();
            while (localIterator1.hasNext()) {
              if (TextUtils.equals(((Device)localIterator1.next()).getProductId(), ((Device)localObject2).getProductId())) {
                i = 1;
              }
            }
          }
          if (i == 0)
          {
            handleExperienceConfigData(paramContext, localExperienceManager, localExperience, 0);
            updateExistingDevicesFromPreconfig(localExperienceManager, (Device)localObject2);
          }
        }
      }
    }
  }
  
  public static boolean isAnyDeviceWithNotifyExternalConnected(Context paramContext)
  {
    boolean bool = false;
    Object localObject = ExperienceManager.getInstance(paramContext).getAllDevices();
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (Device)localIterator.next();
        if ((((Device)localObject).getNotifyExternal()) && (((Device)localObject).isConnected())) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  public static void migrateHdmiToHdmiMhl(Context paramContext)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Object localObject1 = localExperienceManager.getDeviceByProductId("HDMI");
    if (localObject1 != null)
    {
      Object localObject2 = ((Device)localObject1).edit();
      if (!((Device)localObject1).isUserDefNameChanged()) {
        ((Device.DeviceEditor)localObject2).setProductNameBySystem(paramContext.getString(2131099781));
      }
      ((Device.DeviceEditor)localObject2).setProductId("MHL");
      localExperienceManager.updateDevice((Device.DeviceEditor)localObject2);
      localObject2 = localExperienceManager.getExperiencesByDeviceId(((Device)localObject1).getId()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Experience)((Iterator)localObject2).next();
        if ("event_name_hdmi".equals(((Experience)localObject1).getResourceName()))
        {
          ((Experience)localObject1).setResourcename(paramContext.getResources().getResourceName(2131099897));
          if (!((Experience)localObject1).getNameChangedByUser()) {
            ((Experience)localObject1).setName(paramContext.getString(2131099897));
          }
          localExperienceManager.updateExperience((Experience)localObject1);
        }
      }
    }
  }
  
  public static void updateActionSetLabels(Context paramContext)
  {
    Iterator localIterator = ExperienceManager.getInstance(paramContext).getAllExperiences().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Experience)localIterator.next();
      Object localObject2 = ((Experience)localObject1).getAvailableStartActions();
      localObject1 = ((Experience)localObject1).getAvailableStopActions();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ActionSet)((Iterator)localObject2).next()).requestUpdate(paramContext);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((ActionSet)((Iterator)localObject1).next()).requestUpdate(paramContext);
        }
      }
    }
  }
  
  public static void updateExistingDevicesFromPreconfig(ExperienceManager paramExperienceManager, Device paramDevice)
  {
    Iterator localIterator = paramExperienceManager.getDevicesByProductIdAndBearer(paramDevice.getProductId(), paramDevice.getBearerType()).iterator();
    while (localIterator.hasNext())
    {
      Device.DeviceEditor localDeviceEditor = ((Device)localIterator.next()).edit();
      localDeviceEditor.setIconName(paramDevice.getIconName());
      localDeviceEditor.setManufacturer(paramDevice.getManufacturer());
      localDeviceEditor.setDevicePageActivity(paramDevice.getDevicePageActivity());
      paramExperienceManager.updateDevice(localDeviceEditor);
    }
  }
  
  public static void updateUnfinalizedPreconfigActionSets(Context paramContext)
  {
    Iterator localIterator = ExperienceManager.getInstance(paramContext).getUnfinalizedPreconfigActionSets().iterator();
    while (localIterator.hasNext())
    {
      ActionSet localActionSet = (ActionSet)localIterator.next();
      if (Dbg.d()) {
        Dbg.d("updateUnfinalizedPreconfigActionSets: " + localActionSet.getFormattedString());
      }
      localActionSet.settingsInject(paramContext);
    }
  }
  
  public static void updateUnmodifiedExperienceNames(Context paramContext)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    ArrayList localArrayList = localExperienceManager.getUnmodifiedExperienceNames();
    Iterator localIterator = localArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localExperienceManager.updateUnmodifiedExperienceNames(localArrayList);
        return;
      }
      Experience localExperience = (Experience)localIterator.next();
      String str = localExperience.getName();
      try
      {
        str = getLocalizedName(paramContext, localExperience.getResourceName());
        str = str;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        label65:
        break label65;
      }
      localExperience.setName(str);
    }
  }
  
  public static void updateUnmodifiedUserdefinedDeviceNames(Context paramContext, Resources paramResources)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Iterator localIterator = localExperienceManager.getDevicesWithUnmodifiedUserDefNames().iterator();
    while (localIterator.hasNext())
    {
      Device localDevice = (Device)localIterator.next();
      int i = getUserDefNameResourceId(paramContext, paramResources, localDevice.getProductId());
      if (i != 0)
      {
        String str = paramResources.getString(i);
        if ((localDevice.getProductName() != null) && (!localDevice.getProductName().equals(str))) {
          localExperienceManager.updateDevice(localDevice.edit().setProductNameBySystem(str));
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ExperienceUtils
 * JD-Core Version:    0.7.0.1
 */