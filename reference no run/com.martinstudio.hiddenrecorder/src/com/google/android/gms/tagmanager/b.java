package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class b
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.u.toString();
  private final a aeg;
  
  public b(Context paramContext)
  {
    this(a.J(paramContext));
  }
  
  b(a parama)
  {
    super(ID, new String[0]);
    this.aeg = parama;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = this.aeg.kY();
    if (localObject != null) {
      localObject = dh.r(localObject);
    } else {
      localObject = dh.mY();
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.b
 * JD-Core Version:    0.7.0.1
 */