package com.google.android.gms.analytics;

class w
  implements j
{
  String tA;
  String tz;
  String wg;
  int wh = -1;
  int wi = -1;
  
  public boolean cT()
  {
    boolean bool;
    if (this.tz == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String cU()
  {
    return this.tz;
  }
  
  public boolean cV()
  {
    boolean bool;
    if (this.tA == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String cW()
  {
    return this.tA;
  }
  
  public boolean cX()
  {
    boolean bool;
    if (this.wg == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String cY()
  {
    return this.wg;
  }
  
  public boolean cZ()
  {
    boolean bool;
    if (this.wh < 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int da()
  {
    return this.wh;
  }
  
  public boolean db()
  {
    boolean bool;
    if (this.wi == -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dc()
  {
    int i = 1;
    if (this.wi != i) {
      i = 0;
    }
    return i;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.w
 * JD-Core Version:    0.7.0.1
 */