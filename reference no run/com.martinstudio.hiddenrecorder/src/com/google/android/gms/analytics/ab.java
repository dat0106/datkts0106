package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ab
{
  private final Map<String, Integer> wI = new HashMap();
  private final Map<String, String> wJ = new HashMap();
  private final boolean wK;
  private final String wL;
  
  ab(String paramString, boolean paramBoolean)
  {
    this.wK = paramBoolean;
    this.wL = paramString;
  }
  
  void c(String paramString, int paramInt)
  {
    if (this.wK)
    {
      Integer localInteger = (Integer)this.wI.get(paramString);
      if (localInteger == null) {
        localInteger = Integer.valueOf(0);
      }
      this.wI.put(paramString, Integer.valueOf(paramInt + localInteger.intValue()));
    }
  }
  
  String dl()
  {
    if (this.wK)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.wL);
      Iterator localIterator = this.wI.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          localIterator = this.wJ.keySet().iterator();
          for (;;)
          {
            if (!localIterator.hasNext())
            {
              localObject = ((StringBuilder)localObject).toString();
              break;
            }
            str = (String)localIterator.next();
            ((StringBuilder)localObject).append("&").append(str).append("=").append((String)this.wJ.get(str));
          }
        }
        String str = (String)localIterator.next();
        ((StringBuilder)localObject).append("&").append(str).append("=").append(this.wI.get(str));
      }
    }
    Object localObject = "";
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ab
 * JD-Core Version:    0.7.0.1
 */