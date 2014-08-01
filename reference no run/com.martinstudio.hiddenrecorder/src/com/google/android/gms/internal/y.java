package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class y
  implements aa
{
  private ey lc;
  
  public y(ey paramey)
  {
    this.lc = paramey;
  }
  
  public void a(ad paramad, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (!paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    localHashMap.put("isVisible", str);
    this.lc.a("onAdVisibilityChanged", localHashMap);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.y
 * JD-Core Version:    0.7.0.1
 */