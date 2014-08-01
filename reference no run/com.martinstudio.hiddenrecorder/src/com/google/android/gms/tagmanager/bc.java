package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Locale;
import java.util.Map;

class bc
  extends aj
{
  private static final String ID = a.L.toString();
  
  public bc()
  {
    super(ID, new String[0]);
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = Locale.getDefault();
    if (localObject != null)
    {
      localObject = ((Locale)localObject).getLanguage();
      if (localObject != null) {
        localObject = dh.r(((String)localObject).toLowerCase());
      } else {
        localObject = dh.mY();
      }
    }
    else
    {
      localObject = dh.mY();
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bc
 * JD-Core Version:    0.7.0.1
 */