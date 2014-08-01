package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class e
  extends aj
{
  private static final String ID = a.W.toString();
  private static final String aeh = b.bH.toString();
  private static final String aei = b.bK.toString();
  private final Context kM;
  
  public e(Context paramContext)
  {
    super(str, arrayOfString);
    this.kM = paramContext;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject1 = (d.a)paramMap.get(aei);
    if (localObject1 != null)
    {
      localObject1 = dh.j((d.a)localObject1);
      Object localObject2 = (d.a)paramMap.get(aeh);
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = dh.j((d.a)localObject2);
      }
      localObject1 = ay.d(this.kM, (String)localObject1, (String)localObject2);
      if (localObject1 == null) {
        localObject1 = dh.mY();
      } else {
        localObject1 = dh.r(localObject1);
      }
    }
    else
    {
      localObject1 = dh.mY();
    }
    return localObject1;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.e
 * JD-Core Version:    0.7.0.1
 */