package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ah
  extends aj
{
  private static final String ID = a.I.toString();
  private final cs aes;
  
  public ah(cs paramcs)
  {
    super(ID, new String[0]);
    this.aes = paramcs;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = this.aes.mC();
    if (localObject != null) {
      localObject = dh.r(localObject);
    } else {
      localObject = dh.mY();
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ah
 * JD-Core Version:    0.7.0.1
 */