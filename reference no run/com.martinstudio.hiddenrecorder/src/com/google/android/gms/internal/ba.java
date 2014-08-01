package com.google.android.gms.internal;

import java.util.Map;

public final class ba
  implements bd
{
  private final bb mQ;
  
  public ba(bb parambb)
  {
    this.mQ = parambb;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str != null) {
      this.mQ.onAppEvent(str, (String)paramMap.get("info"));
    } else {
      ev.D("App event with no name parameter.");
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ba
 * JD-Core Version:    0.7.0.1
 */