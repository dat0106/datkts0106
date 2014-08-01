package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Promotion
{
  public static final String ACTION_CLICK = "click";
  public static final String ACTION_VIEW = "view";
  Map<String, String> xC = new HashMap();
  
  public Map<String, String> X(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.xC.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(paramString + (String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  void put(String paramString1, String paramString2)
  {
    hn.b(paramString1, "Name should be non-null");
    this.xC.put(paramString1, paramString2);
  }
  
  public Promotion setCreative(String paramString)
  {
    put("cr", paramString);
    return this;
  }
  
  public Promotion setId(String paramString)
  {
    put("id", paramString);
    return this;
  }
  
  public Promotion setName(String paramString)
  {
    put("nm", paramString);
    return this;
  }
  
  public Promotion setPosition(String paramString)
  {
    put("ps", paramString);
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ecommerce.Promotion
 * JD-Core Version:    0.7.0.1
 */