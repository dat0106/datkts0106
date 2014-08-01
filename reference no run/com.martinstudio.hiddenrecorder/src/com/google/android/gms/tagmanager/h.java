package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class h
  extends aj
{
  private static final String ID = a.y.toString();
  private final Context mContext;
  
  public h(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    try
    {
      locala1 = dh.r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      locala1 = locala1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        d.a locala1;
        bh.A("Package name " + this.mContext.getPackageName() + " not found. " + localNameNotFoundException.getMessage());
        d.a locala2 = dh.mY();
      }
    }
    return locala1;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.h
 * JD-Core Version:    0.7.0.1
 */