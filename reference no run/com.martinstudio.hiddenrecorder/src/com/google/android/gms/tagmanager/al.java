package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class al
  extends bx
{
  private static final String ID = a.ao.toString();
  
  public al()
  {
    super(ID);
  }
  
  protected boolean a(dg paramdg1, dg paramdg2, Map<String, d.a> paramMap)
  {
    boolean bool;
    if (paramdg1.a(paramdg2) < 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.al
 * JD-Core Version:    0.7.0.1
 */