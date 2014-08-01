package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class s
  extends aj
{
  private static final String ID = a.J.toString();
  private static final String aeT = b.cy.toString();
  private static final String aej = b.aX.toString();
  private final a aeU;
  
  public s(a parama)
  {
    super(str, arrayOfString);
    this.aeU = parama;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject1 = dh.j((d.a)paramMap.get(aeT));
    HashMap localHashMap = new HashMap();
    Object localObject2 = (d.a)paramMap.get(aej);
    if (localObject2 != null)
    {
      localObject2 = dh.o((d.a)localObject2);
      if (!(localObject2 instanceof Map))
      {
        bh.D("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        localObject1 = dh.mY();
      }
    }
    for (;;)
    {
      return localObject1;
      Iterator localIterator = ((Map)localObject2).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        localHashMap.put(((Map.Entry)localObject2).getKey().toString(), ((Map.Entry)localObject2).getValue());
      }
      try
      {
        localObject1 = dh.r(this.aeU.b((String)localObject1, localHashMap));
        localObject1 = localObject1;
      }
      catch (Exception localException)
      {
        bh.D("Custom macro/tag " + (String)localObject1 + " threw exception " + localException.getMessage());
        localObject1 = dh.mY();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract Object b(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.s
 * JD-Core Version:    0.7.0.1
 */