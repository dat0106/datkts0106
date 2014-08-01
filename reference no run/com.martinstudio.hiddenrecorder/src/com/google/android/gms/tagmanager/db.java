package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class db
  extends dc
{
  private static final String ID = a.ah.toString();
  
  public db()
  {
    super(ID);
  }
  
  protected boolean a(String paramString1, String paramString2, Map<String, d.a> paramMap)
  {
    return paramString1.startsWith(paramString2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.db
 * JD-Core Version:    0.7.0.1
 */