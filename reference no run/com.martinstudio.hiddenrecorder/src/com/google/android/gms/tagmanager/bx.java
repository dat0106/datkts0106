package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class bx
  extends cc
{
  public bx(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    dg localdg1 = dh.k(parama1);
    dg localdg2 = dh.k(parama2);
    boolean bool;
    if ((localdg1 != dh.mW()) && (localdg2 != dh.mW())) {
      bool = a(localdg1, localdg2, paramMap);
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract boolean a(dg paramdg1, dg paramdg2, Map<String, d.a> paramMap);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bx
 * JD-Core Version:    0.7.0.1
 */