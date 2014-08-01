package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class p
  extends aj
{
  private static final String ID = a.D.toString();
  private final String aeR;
  
  public p(String paramString)
  {
    super(ID, new String[0]);
    this.aeR = paramString;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    d.a locala;
    if (this.aeR != null) {
      locala = dh.r(this.aeR);
    } else {
      locala = dh.mY();
    }
    return locala;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.p
 * JD-Core Version:    0.7.0.1
 */