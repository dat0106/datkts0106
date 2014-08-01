package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class m
  extends aj
{
  private static final String ID = a.A.toString();
  private static final String VALUE = b.ew.toString();
  
  public m()
  {
    super(str, arrayOfString);
  }
  
  public static String lf()
  {
    return ID;
  }
  
  public static String lg()
  {
    return VALUE;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    return (d.a)paramMap.get(VALUE);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.m
 * JD-Core Version:    0.7.0.1
 */