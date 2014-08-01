package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class dc
  extends cc
{
  public dc(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    String str2 = dh.j(parama1);
    String str1 = dh.j(parama2);
    boolean bool;
    if ((str2 != dh.mX()) && (str1 != dh.mX())) {
      bool = a(str2, str1, paramMap);
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract boolean a(String paramString1, String paramString2, Map<String, d.a> paramMap);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dc
 * JD-Core Version:    0.7.0.1
 */