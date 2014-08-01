package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class ap
{
  private final long afC;
  private String afD;
  private final long wt;
  private final long wu;
  
  ap(long paramLong1, long paramLong2, long paramLong3)
  {
    this.wt = paramLong1;
    this.wu = paramLong2;
    this.afC = paramLong3;
  }
  
  void R(String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.trim()))) {
      this.afD = paramString;
    }
  }
  
  long dg()
  {
    return this.wt;
  }
  
  long lI()
  {
    return this.afC;
  }
  
  String lJ()
  {
    return this.afD;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ap
 * JD-Core Version:    0.7.0.1
 */