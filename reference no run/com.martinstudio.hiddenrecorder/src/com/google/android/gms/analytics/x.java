package com.google.android.gms.analytics;

import android.text.TextUtils;

class x
{
  private String ws;
  private final long wt;
  private final long wu;
  private String wv = "https:";
  
  x(String paramString, long paramLong1, long paramLong2)
  {
    this.ws = paramString;
    this.wt = paramLong1;
    this.wu = paramLong2;
  }
  
  void Q(String paramString)
  {
    this.ws = paramString;
  }
  
  void R(String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.trim())) && (paramString.toLowerCase().startsWith("http:"))) {
      this.wv = "http:";
    }
  }
  
  String df()
  {
    return this.ws;
  }
  
  long dg()
  {
    return this.wt;
  }
  
  long dh()
  {
    return this.wu;
  }
  
  String di()
  {
    return this.wv;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.x
 * JD-Core Version:    0.7.0.1
 */