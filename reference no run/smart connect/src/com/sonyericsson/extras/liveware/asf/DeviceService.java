package com.sonyericsson.extras.liveware.asf;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Device.DeviceEditor;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.ui.ApplicationSelectionActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class DeviceService
  extends IntentService
{
  public static final String ACTION_DEVICE_CONNECTION_INFO = "ACTION_DEVICE_CONNECTION_INFO";
  public static final String ACTION_SMART_KEY = "ACTION_SMART_KEY";
  public static final String EXTRA_DEVICE_BEARER = "EXTRA_DEVICE_BEARER";
  public static final String EXTRA_DEVICE_CONNECTION_STATUS = "EXTRA_DEVICE_CONNECTION_STATUS";
  public static final String EXTRA_DEVICE_KEY_ID = "EXTRA_DEVICE_KEY_ID";
  public static final String EXTRA_DEVICE_PRODUCT_ID = "EXTRA_DEVICE_PRODUCT_ID";
  private static final String EXTRA_DEVICE_SMART_KEY_STATUS = "EXTRA_DEVICE_SMART_KEY_STATUS";
  public static final String EXTRA_DEVICE_TYPE = "EXTRA_DEVICE_TYPE";
  
  public DeviceService()
  {
    super(DeviceService.class.getName());
  }
  
  public static Intent getDeviceConnectionIntent(Context paramContext, String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent("ACTION_DEVICE_CONNECTION_INFO");
    localIntent.setComponent(new ComponentName(paramContext, DeviceService.class));
    localIntent.putExtra("EXTRA_DEVICE_PRODUCT_ID", paramString1);
    localIntent.putExtra("EXTRA_DEVICE_CONNECTION_STATUS", paramBoolean);
    localIntent.putExtra("EXTRA_DEVICE_TYPE", paramInt1);
    localIntent.putExtra("EXTRA_DEVICE_BEARER", paramInt2);
    if (paramString2 != null) {
      localIntent.putExtra("EXTRA_DEVICE_KEY_ID", paramString2);
    }
    return localIntent;
  }
  
  public static Intent getSmartKeyIntent(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    Intent localIntent = new Intent("ACTION_SMART_KEY");
    localIntent.setComponent(new ComponentName(paramContext, DeviceService.class));
    localIntent.putExtra("EXTRA_DEVICE_PRODUCT_ID", paramString1);
    localIntent.putExtra("EXTRA_DEVICE_SMART_KEY_STATUS", paramInt1);
    localIntent.putExtra("EXTRA_DEVICE_TYPE", paramInt2);
    localIntent.putExtra("EXTRA_DEVICE_BEARER", paramInt3);
    if (paramString2 != null) {
      localIntent.putExtra("EXTRA_DEVICE_KEY_ID", paramString2);
    }
    return localIntent;
  }
  
  private void handleSmartKey(Intent paramIntent)
  {
    Object localObject1 = ExperienceManager.getInstance(this);
    Object localObject2 = paramIntent.getExtras().getString("EXTRA_DEVICE_PRODUCT_ID");
    int j = paramIntent.getExtras().getInt("EXTRA_DEVICE_BEARER");
    int i = paramIntent.getExtras().getInt("EXTRA_DEVICE_SMART_KEY_STATUS");
    localObject2 = ((ExperienceManager)localObject1).getDeviceByProductIdAndBearer((String)localObject2, j);
    if (localObject2 != null)
    {
      if (!((Device)localObject2).hasFeature(2))
      {
        Object localObject4 = getResources().getString(2131099698);
        Object localObject3 = null;
        String str = null;
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          if (!((String)localObject4).contains("/"))
          {
            localObject3 = localObject4;
          }
          else
          {
            localObject4 = ComponentName.unflattenFromString((String)localObject4);
            localObject3 = ((ComponentName)localObject4).getPackageName();
            str = ((ComponentName)localObject4).getClassName();
          }
        }
        localObject3 = new Feature((Device)localObject2, 2, (String)localObject3, str, "com.sonyericsson.extras.livekey", 1, null, null);
        ((ExperienceManager)localObject1).updateDevice(((Device)localObject2).edit().addFeature((Feature)localObject3));
        localObject2 = ((ExperienceManager)localObject1).getDeviceById(((Device)localObject2).getId());
      }
      localObject1 = ((Device)localObject2).getFeature(2);
      if ((localObject1 != null) && (((Feature)localObject1).getState() != 0)) {
        if (((Feature)localObject1).getComponentName() != null)
        {
          if (!LiveKeyLauncher.sendLiveKeyEvent(this, ((Feature)localObject1).getComponentName(), 0, i, SystemClock.elapsedRealtime())) {
            PackageUtils.setLiveKeyDefault(this, null, (Device)localObject2);
          }
        }
        else if ((i == 0) && (!UIUtils.attachUI(this, (Device)localObject2, 2, false))) {
          ApplicationSelectionActivity.launchApplicationSelection(this, (Device)localObject2, true);
        }
      }
    }
    else
    {
      Dbg.e("Can't proceed without Device");
    }
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    if (Dbg.d()) {
      Dbg.d("DeviceService.onHandleIntent " + Thread.currentThread().getName());
    }
    String str = paramIntent.getAction();
    if (Dbg.d()) {
      Dbg.d("DeviceService.onHandleIntent " + str);
    }
    if (!"ACTION_DEVICE_CONNECTION_INFO".equals(str))
    {
      if (!"ACTION_SMART_KEY".equals(str)) {
        Dbg.e("DeviceService, unknown action " + str);
      } else {
        handleSmartKey(paramIntent);
      }
    }
    else {
      DeviceServiceHandler.getNewHandler().onConnectionInfo(this, paramIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.DeviceService
 * JD-Core Version:    0.7.0.1
 */