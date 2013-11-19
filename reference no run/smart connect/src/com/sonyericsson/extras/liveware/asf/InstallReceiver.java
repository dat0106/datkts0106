package com.sonyericsson.extras.liveware.asf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.experience.Feature.FeatureEditor;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.ToastMaster;

public class InstallReceiver
{
  private static final String ACCID = "accessory_id";
  private static final String FEATURE = "feature";
  public static final String PENDING = "pending";
  public static final String PENDING_INSTALL = "installed";
  private static final String PKG = "package";
  private static final String START_APP = "start_app";
  private static final String TIMESTAMP = "timestamp";
  
  public static void onReceive(Context paramContext, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("installed", 0);
    String str = localSharedPreferences.getString("package", null);
    int i = localSharedPreferences.getInt("feature", 0);
    try
    {
      long l1 = localSharedPreferences.getLong("accessory_id", -1L);
      l2 = l1;
    }
    catch (ClassCastException localClassCastException)
    {
      boolean bool;
      do
      {
        do
        {
          long l2;
          do
          {
            for (;;)
            {
              l2 = localSharedPreferences.getInt("accessory_id", -1);
            }
            localObject = paramContext.getPackageManager();
            localExperienceManager = ExperienceManager.getInstance(paramContext);
            localObject = ((PackageManager)localObject).getPackagesForUid(paramInt);
          } while ((localObject == null) || (!str.equals(localObject[0])));
          localDevice = localExperienceManager.getDeviceById(l2);
        } while (localDevice == null);
        localFeature = localDevice.getFeature(i);
      } while (localFeature == null);
      localSharedPreferences.edit().putBoolean("pending", false).commit();
      PackageUtils.findAndSetDefaultApp(paramContext, localDevice, new Intent(localFeature.getIntent()), str, i);
      if (localFeature.getType() != 2) {
        break label215;
      }
      localExperienceManager.updateFeature(localFeature.edit().setAppSelection(0));
      label215:
      if (!bool) {
        break label226;
      }
    }
    bool = localSharedPreferences.getBoolean("start_app", false);
    if (!localSharedPreferences.getBoolean("pending", false)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject;
        ExperienceManager localExperienceManager;
        Device localDevice;
        Feature localFeature;
        PackageUtils.startSmartLaunchApplication(paramContext, localDevice);
        label226:
        showToast(paramContext, localDevice.getProductName(), str);
      }
      catch (Exception localException)
      {
        break label226;
      }
    }
  }
  
  public static void runInstallReceiver(Context paramContext, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    paramContext.getSharedPreferences("installed", 0).edit().putBoolean("pending", true).putString("package", paramString).putInt("feature", paramInt).putLong("accessory_id", paramLong).putLong("timestamp", l).putBoolean("start_app", paramBoolean).commit();
  }
  
  private static void showToast(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      CharSequence localCharSequence = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramString2, 128));
      localObject = paramContext.getString(2131099746);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localCharSequence;
      localObject = String.format((String)localObject, arrayOfObject) + " " + paramString1;
      ToastMaster.makeLWToast(paramContext, paramContext.getString(2131099648), (String)localObject);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Could find appInfo");
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.InstallReceiver
 * JD-Core Version:    0.7.0.1
 */