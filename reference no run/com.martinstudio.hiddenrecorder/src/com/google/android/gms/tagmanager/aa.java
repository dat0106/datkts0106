package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class aa
  extends aj
{
  private static final String ID = a.F.toString();
  
  public aa()
  {
    super(ID, new String[0]);
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    if ((!str1.startsWith(str2)) && (!str2.equals("unknown"))) {
      str1 = str2 + " " + str1;
    }
    return dh.r(str1);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.aa
 * JD-Core Version:    0.7.0.1
 */