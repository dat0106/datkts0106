package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ax
  extends aj
{
  private static final String ID = a.ab.toString();
  private static final String aeh = b.bH.toString();
  private final Context kM;
  
  public ax(Context paramContext)
  {
    super(ID, new String[0]);
    this.kM = paramContext;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    if ((d.a)paramMap.get(aeh) == null) {
      localObject = null;
    } else {
      localObject = dh.j((d.a)paramMap.get(aeh));
    }
    Object localObject = ay.e(this.kM, (String)localObject);
    if (localObject == null) {
      localObject = dh.mY();
    } else {
      localObject = dh.r(localObject);
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ax
 * JD-Core Version:    0.7.0.1
 */