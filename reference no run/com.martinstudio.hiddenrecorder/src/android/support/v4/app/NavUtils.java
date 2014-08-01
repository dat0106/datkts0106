package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.util.Log;

public class NavUtils
{
  private static final NavUtilsImpl IMPL;
  public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
  private static final String TAG = "NavUtils";
  
  static
  {
    if (Build.VERSION.SDK_INT < 16) {
      IMPL = new NavUtilsImplBase();
    } else {
      IMPL = new NavUtilsImplJB();
    }
  }
  
  public static Intent getParentActivityIntent(Activity paramActivity)
  {
    return IMPL.getParentActivityIntent(paramActivity);
  }
  
  public static Intent getParentActivityIntent(Context paramContext, ComponentName paramComponentName)
    throws PackageManager.NameNotFoundException
  {
    Object localObject = getParentActivityName(paramContext, paramComponentName);
    if (localObject != null)
    {
      localObject = new ComponentName(paramComponentName.getPackageName(), (String)localObject);
      if (getParentActivityName(paramContext, (ComponentName)localObject) != null) {
        localObject = new Intent().setComponent((ComponentName)localObject);
      } else {
        localObject = IntentCompat.makeMainActivity((ComponentName)localObject);
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static Intent getParentActivityIntent(Context paramContext, Class<?> paramClass)
    throws PackageManager.NameNotFoundException
  {
    Object localObject = getParentActivityName(paramContext, new ComponentName(paramContext, paramClass));
    if (localObject != null)
    {
      localObject = new ComponentName(paramContext, (String)localObject);
      if (getParentActivityName(paramContext, (ComponentName)localObject) != null) {
        localObject = new Intent().setComponent((ComponentName)localObject);
      } else {
        localObject = IntentCompat.makeMainActivity((ComponentName)localObject);
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static String getParentActivityName(Activity paramActivity)
  {
    try
    {
      String str = getParentActivityName(paramActivity, paramActivity.getComponentName());
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new IllegalArgumentException(localNameNotFoundException);
    }
  }
  
  public static String getParentActivityName(Context paramContext, ComponentName paramComponentName)
    throws PackageManager.NameNotFoundException
  {
    ActivityInfo localActivityInfo = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    return IMPL.getParentActivityName(paramContext, localActivityInfo);
  }
  
  public static void navigateUpFromSameTask(Activity paramActivity)
  {
    Intent localIntent = getParentActivityIntent(paramActivity);
    if (localIntent != null)
    {
      navigateUpTo(paramActivity, localIntent);
      return;
    }
    throw new IllegalArgumentException("Activity " + paramActivity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
  }
  
  public static void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    IMPL.navigateUpTo(paramActivity, paramIntent);
  }
  
  public static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return IMPL.shouldUpRecreateTask(paramActivity, paramIntent);
  }
  
  static class NavUtilsImplJB
    extends NavUtils.NavUtilsImplBase
  {
    public Intent getParentActivityIntent(Activity paramActivity)
    {
      Intent localIntent = NavUtilsJB.getParentActivityIntent(paramActivity);
      if (localIntent == null) {
        localIntent = superGetParentActivityIntent(paramActivity);
      }
      return localIntent;
    }
    
    public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
    {
      String str = NavUtilsJB.getParentActivityName(paramActivityInfo);
      if (str == null) {
        str = super.getParentActivityName(paramContext, paramActivityInfo);
      }
      return str;
    }
    
    public void navigateUpTo(Activity paramActivity, Intent paramIntent)
    {
      NavUtilsJB.navigateUpTo(paramActivity, paramIntent);
    }
    
    public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
    {
      return NavUtilsJB.shouldUpRecreateTask(paramActivity, paramIntent);
    }
    
    Intent superGetParentActivityIntent(Activity paramActivity)
    {
      return super.getParentActivityIntent(paramActivity);
    }
  }
  
  static class NavUtilsImplBase
    implements NavUtils.NavUtilsImpl
  {
    public Intent getParentActivityIntent(Activity paramActivity)
    {
      Object localObject2 = null;
      Object localObject1 = NavUtils.getParentActivityName(paramActivity);
      if (localObject1 == null) {}
      for (;;)
      {
        return localObject2;
        ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject1);
        try
        {
          if (NavUtils.getParentActivityName(paramActivity, localComponentName) == null)
          {
            localObject2 = IntentCompat.makeMainActivity(localComponentName);
          }
          else
          {
            localObject1 = new Intent().setComponent(localComponentName);
            localObject2 = localObject1;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + (String)localObject1 + "' in manifest");
        }
      }
    }
    
    public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
    {
      String str;
      if (paramActivityInfo.metaData != null)
      {
        str = paramActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (str != null)
        {
          if (str.charAt(0) == '.') {
            str = paramContext.getPackageName() + str;
          }
        }
        else {
          str = null;
        }
      }
      else
      {
        str = null;
      }
      return str;
    }
    
    public void navigateUpTo(Activity paramActivity, Intent paramIntent)
    {
      paramIntent.addFlags(67108864);
      paramActivity.startActivity(paramIntent);
      paramActivity.finish();
    }
    
    public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
    {
      String str = paramActivity.getIntent().getAction();
      boolean bool;
      if ((str == null) || (str.equals("android.intent.action.MAIN"))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  static abstract interface NavUtilsImpl
  {
    public abstract Intent getParentActivityIntent(Activity paramActivity);
    
    public abstract String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo);
    
    public abstract void navigateUpTo(Activity paramActivity, Intent paramIntent);
    
    public abstract boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NavUtils
 * JD-Core Version:    0.7.0.1
 */