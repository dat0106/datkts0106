package com.google.ads;

import com.google.ads.internal.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final Map<String, AdSize> a = Collections.unmodifiableMap(new HashMap() {});
  private final String b;
  private final String c;
  private final List<a> d;
  private final Integer e;
  private final Integer f;
  private final List<String> g;
  private final List<String> h;
  private final List<String> i;
  
  private c(String paramString1, String paramString2, List<a> paramList, Integer paramInteger1, Integer paramInteger2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    com.google.ads.util.a.a(paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramList;
    this.e = paramInteger1;
    this.f = paramInteger2;
    this.g = paramList1;
    this.h = paramList2;
    this.i = paramList3;
  }
  
  private static a a(JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("id");
    String str2 = paramJSONObject.optString("allocation_id", null);
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    List localList;
    for (int j = 0;; localList++)
    {
      if (j >= ((JSONArray)localObject1).length())
      {
        localList = a(paramJSONObject, "imp_urls");
        localObject1 = paramJSONObject.optJSONObject("data");
        Object localObject2 = new HashMap(0);
        Object localObject3;
        Iterator localIterator;
        if (localObject1 == null)
        {
          localObject3 = localObject2;
        }
        else
        {
          localObject3 = new HashMap(((JSONObject)localObject1).length());
          localIterator = ((JSONObject)localObject1).keys();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            return new a(str2, str1, localArrayList, localList, (HashMap)localObject3);
          }
          localObject2 = (String)localIterator.next();
          ((HashMap)localObject3).put(localObject2, ((JSONObject)localObject1).getString((String)localObject2));
        }
      }
      localArrayList.add(((JSONArray)localObject1).getString(localList));
    }
  }
  
  public static c a(String paramString)
    throws JSONException
  {
    Integer localInteger = null;
    Object localObject1 = new JSONObject(paramString);
    String str2 = ((JSONObject)localObject1).getString("qdata");
    String str1;
    if (!((JSONObject)localObject1).has("ad_type")) {
      str1 = null;
    } else {
      str1 = ((JSONObject)localObject1).getString("ad_type");
    }
    Object localObject2 = ((JSONObject)localObject1).getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject2).length());
    List localList;
    for (int j = 0;; localList++)
    {
      if (j >= ((JSONArray)localObject2).length())
      {
        Object localObject3 = ((JSONObject)localObject1).optJSONObject("settings");
        if (localObject3 == null)
        {
          localObject3 = null;
          localList = null;
          localObject2 = null;
          localInteger = null;
          localObject1 = null;
        }
        else
        {
          if (!((JSONObject)localObject3).has("refresh")) {
            localObject1 = null;
          } else {
            localObject1 = Integer.valueOf(((JSONObject)localObject3).getInt("refresh"));
          }
          if (((JSONObject)localObject3).has("ad_network_timeout_millis")) {
            localInteger = Integer.valueOf(((JSONObject)localObject3).getInt("ad_network_timeout_millis"));
          }
          localList = a((JSONObject)localObject3, "imp_urls");
          localObject2 = a((JSONObject)localObject3, "click_urls");
          localObject3 = a((JSONObject)localObject3, "nofill_urls");
          localInteger = localInteger;
        }
        return new c(str2, str1, localArrayList, (Integer)localObject1, localInteger, localList, (List)localObject2, (List)localObject3);
      }
      localArrayList.add(a(((JSONArray)localObject2).getJSONObject(localList)));
    }
  }
  
  private static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    Object localObject = paramJSONObject.optJSONArray(paramString);
    ArrayList localArrayList;
    if (localObject == null) {
      localObject = null;
    } else {
      localArrayList = new ArrayList(((JSONArray)localObject).length());
    }
    for (int j = 0;; j++)
    {
      if (j >= ((JSONArray)localObject).length())
      {
        localObject = localArrayList;
        return localObject;
      }
      localArrayList.add(((JSONArray)localObject).getString(j));
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.f == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int b()
  {
    return this.f.intValue();
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.e == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int e()
  {
    return this.e.intValue();
  }
  
  public List<a> f()
  {
    return this.d;
  }
  
  public List<String> g()
  {
    return this.g;
  }
  
  public List<String> h()
  {
    return this.h;
  }
  
  public List<String> i()
  {
    return this.i;
  }
  
  public h j()
  {
    Object localObject;
    if (this.c != null)
    {
      if (!"interstitial".equals(this.c))
      {
        localObject = (AdSize)a.get(this.c);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = h.a((AdSize)localObject);
        }
      }
      else
      {
        localObject = h.a;
      }
    }
    else {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.c
 * JD-Core Version:    0.7.0.1
 */