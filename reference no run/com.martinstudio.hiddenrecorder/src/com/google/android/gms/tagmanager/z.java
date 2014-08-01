package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class z
  extends aj
{
  private static final String ID = a.X.toString();
  private final Context mContext;
  
  public z(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  protected String L(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = L(this.mContext);
    if (localObject != null) {
      localObject = dh.r(localObject);
    } else {
      localObject = dh.mY();
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.z
 * JD-Core Version:    0.7.0.1
 */