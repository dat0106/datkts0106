package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba
{
  public static cq.c bY(String paramString)
    throws JSONException
  {
    d.a locala = k(new JSONObject(paramString));
    cq.d locald = cq.c.mm();
    for (int i = 0;; i++)
    {
      if (i >= locala.fP.length) {
        return locald.mp();
      }
      locald.a(cq.a.mi().b(b.cI.toString(), locala.fP[i]).b(b.cx.toString(), dh.cp(m.lf())).b(m.lg(), locala.fQ[i]).ml());
    }
  }
  
  private static d.a k(Object paramObject)
    throws JSONException
  {
    return dh.r(l(paramObject));
  }
  
  static Object l(Object paramObject)
    throws JSONException
  {
    if (!(paramObject instanceof JSONArray))
    {
      if (!JSONObject.NULL.equals(paramObject))
      {
        JSONObject localJSONObject;
        HashMap localHashMap;
        Iterator localIterator;
        if ((paramObject instanceof JSONObject))
        {
          localJSONObject = (JSONObject)paramObject;
          localHashMap = new HashMap();
          localIterator = localJSONObject.keys();
        }
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            paramObject = localHashMap;
            return paramObject;
          }
          String str = (String)localIterator.next();
          localHashMap.put(str, l(localJSONObject.get(str)));
        }
      }
      throw new RuntimeException("JSON nulls are not supported");
    }
    throw new RuntimeException("JSONArrays are not supported");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ba
 * JD-Core Version:    0.7.0.1
 */