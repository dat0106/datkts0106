package com.sonyericsson.extras.liveware.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Feature;

public class ApplicationData
{
  private Context mContext;
  private String mDescription;
  private String mFlatCompname;
  private String mName;
  private String mPackageName;
  
  public ApplicationData(Context paramContext, ComponentName paramComponentName)
  {
    this.mPackageName = paramComponentName.getPackageName();
    this.mFlatCompname = paramComponentName.flattenToString();
    this.mContext = paramContext;
  }
  
  public ApplicationData(Context paramContext, String paramString)
  {
    this.mPackageName = paramString;
    this.mContext = paramContext;
  }
  
  private String getStringFromCharSequence(CharSequence paramCharSequence)
  {
    String str;
    if (paramCharSequence != null) {
      str = paramCharSequence.toString();
    } else {
      str = "";
    }
    return str;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof ApplicationData))
    {
      ApplicationData localApplicationData = (ApplicationData)paramObject;
      if ((TextUtils.equals(this.mPackageName, localApplicationData.getPackageName())) && (TextUtils.equals(this.mFlatCompname, localApplicationData.getFlatComponentName()))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public boolean exists()
  {
    boolean bool;
    if (getApplicationInfo() == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public ActivityInfo getActivityInfo()
  {
    localActivityInfo = null;
    localPackageManager = this.mContext.getPackageManager();
    localComponentName = getComponentName();
    if (localComponentName != null) {}
    try
    {
      localActivityInfo = localPackageManager.getActivityInfo(localComponentName, 128);
      localActivityInfo = localActivityInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      for (;;)
      {
        try
        {
          localActivityInfo = localPackageManager.getReceiverInfo(localComponentName, 128);
          localActivityInfo = localActivityInfo;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      }
    }
    return localActivityInfo;
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    localObject = this.mContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo(this.mPackageName, 128);
      localObject = localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localObject = null;
      }
    }
    return localObject;
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName;
    if (this.mFlatCompname == null) {
      localComponentName = null;
    } else {
      localComponentName = ComponentName.unflattenFromString(this.mFlatCompname);
    }
    return localComponentName;
  }
  
  public String getDescription()
  {
    if ((this.mDescription == null) || ((this.mDescription != null) && (this.mDescription.length() == 0)))
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      ApplicationInfo localApplicationInfo = getApplicationInfo();
      if (localApplicationInfo == null) {
        this.mDescription = "";
      } else {
        this.mDescription = getStringFromCharSequence(localApplicationInfo.loadDescription(localPackageManager));
      }
    }
    return this.mDescription;
  }
  
  public String getFlatComponentName()
  {
    return this.mFlatCompname;
  }
  
  public Drawable getIcon()
  {
    Object localObject1 = this.mContext.getPackageManager();
    Object localObject2 = getActivityInfo();
    if (localObject2 == null)
    {
      localObject2 = getApplicationInfo();
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((ApplicationInfo)localObject2).loadIcon((PackageManager)localObject1);
      }
    }
    else
    {
      localObject1 = ((ActivityInfo)localObject2).loadIcon((PackageManager)localObject1);
    }
    return localObject1;
  }
  
  public String getName()
  {
    if (this.mName == null)
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      Object localObject = getActivityInfo();
      if (localObject == null)
      {
        localObject = getApplicationInfo();
        if (localObject != null) {
          this.mName = getStringFromCharSequence(((ApplicationInfo)localObject).loadLabel(localPackageManager));
        }
      }
      else
      {
        this.mName = getStringFromCharSequence(((ActivityInfo)localObject).loadLabel(localPackageManager));
      }
    }
    return this.mName;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public int hashCode()
  {
    int i = 0;
    if (this.mPackageName == null) {
      j = 0;
    } else {
      j = this.mPackageName.hashCode();
    }
    int j = 31 * (j + 31);
    if (this.mFlatCompname != null) {
      i = this.mFlatCompname.hashCode();
    }
    return j + i;
  }
  
  public boolean isDefault(Context paramContext, Device paramDevice, int paramInt)
  {
    Object localObject = paramDevice.getFeature(paramInt);
    if (localObject != null)
    {
      localObject = ((Feature)localObject).getComponentName();
      if ((localObject != null) && (((ComponentName)localObject).compareTo(getComponentName()) == 0)) {}
    }
    else
    {
      bool = false;
      break label45;
    }
    boolean bool = true;
    label45:
    return bool;
  }
  
  public boolean isDefaultLiveKey(Context paramContext, Device paramDevice)
  {
    return isDefault(paramContext, paramDevice, 2);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ApplicationData
 * JD-Core Version:    0.7.0.1
 */