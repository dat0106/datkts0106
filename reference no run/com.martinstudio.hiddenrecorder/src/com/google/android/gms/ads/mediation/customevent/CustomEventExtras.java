package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> sX = new HashMap();
  
  public Object getExtra(String paramString)
  {
    return this.sX.get(paramString);
  }
  
  public void setExtra(String paramString, Object paramObject)
  {
    this.sX.put(paramString, paramObject);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 * JD-Core Version:    0.7.0.1
 */