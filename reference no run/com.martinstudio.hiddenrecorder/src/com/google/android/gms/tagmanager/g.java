package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class g
  extends aj
{
  private static final String ID = a.x.toString();
  private final Context mContext;
  
  public g(Context paramContext)
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
      localObject = this.mContext.getPackageManager();
      localObject = dh.r(((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
      localObject = localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject;
        bh.b("App name is not found.", localNameNotFoundException);
        d.a locala = dh.mY();
      }
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.g
 * JD-Core Version:    0.7.0.1
 */