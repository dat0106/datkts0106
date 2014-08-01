package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj
  implements j
{
  Map<String, String> xA = new HashMap();
  String xu;
  double xv = -1.0D;
  int xw = -1;
  int xx = -1;
  int xy = -1;
  int xz = -1;
  
  public String T(String paramString)
  {
    String str = (String)this.xA.get(paramString);
    if (str == null) {
      str = paramString;
    }
    return str;
  }
  
  public String dA()
  {
    return this.xu;
  }
  
  public boolean dB()
  {
    boolean bool;
    if (this.xv < 0.0D) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public double dC()
  {
    return this.xv;
  }
  
  public boolean dD()
  {
    boolean bool;
    if (this.xw < 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dE()
  {
    boolean bool;
    if (this.xx == -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dF()
  {
    int i = 1;
    if (this.xx != i) {
      i = 0;
    }
    return i;
  }
  
  public boolean dG()
  {
    boolean bool;
    if (this.xy == -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dH()
  {
    int i = 1;
    if (this.xy != i) {
      i = 0;
    }
    return i;
  }
  
  public boolean dI()
  {
    int i = 1;
    if (this.xz != i) {
      i = 0;
    }
    return i;
  }
  
  public boolean dz()
  {
    boolean bool;
    if (this.xu == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int getSessionTimeout()
  {
    return this.xw;
  }
  
  public String j(Activity paramActivity)
  {
    return T(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.aj
 * JD-Core Version:    0.7.0.1
 */