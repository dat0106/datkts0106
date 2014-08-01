package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ce
  extends aj
{
  private static final String ID = a.O.toString();
  private static final String agC = b.da.toString();
  private static final String agD = b.cZ.toString();
  
  public ce()
  {
    super(ID, new String[0]);
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject2 = (d.a)paramMap.get(agC);
    Object localObject1 = (d.a)paramMap.get(agD);
    if ((localObject2 != null) && (localObject2 != dh.mY()) && (localObject1 != null) && (localObject1 != dh.mY()))
    {
      localObject2 = dh.k((d.a)localObject2);
      localObject1 = dh.k((d.a)localObject1);
      if ((localObject2 != dh.mW()) && (localObject1 != dh.mW()))
      {
        d2 = ((dg)localObject2).doubleValue();
        d1 = ((dg)localObject1).doubleValue();
        if (d2 <= d1) {
          break label102;
        }
      }
    }
    double d1 = 2147483647.0D;
    double d2 = 0.0D;
    break label106;
    label102:
    d2 = d2;
    label106:
    return dh.r(Long.valueOf(Math.round(d2 + Math.random() * (d1 - d2))));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ce
 * JD-Core Version:    0.7.0.1
 */