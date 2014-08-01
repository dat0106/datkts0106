package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class u
  extends aj
{
  private static final String ID = a.C.toString();
  private static final String NAME = b.dc.toString();
  private static final String aff = b.cb.toString();
  private final DataLayer aer;
  
  public u(DataLayer paramDataLayer)
  {
    super(str, arrayOfString);
    this.aer = paramDataLayer;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = this.aer.get(dh.j((d.a)paramMap.get(NAME)));
    if (localObject != null)
    {
      localObject = dh.r(localObject);
    }
    else
    {
      localObject = (d.a)paramMap.get(aff);
      if (localObject == null) {
        localObject = dh.mY();
      }
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.u
 * JD-Core Version:    0.7.0.1
 */