package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di
  extends df
{
  private static final String ID = a.aF.toString();
  private static Map<String, String> aiA;
  private static final String ait = b.aV.toString();
  private static final String aiu = b.be.toString();
  private static final String aiv = b.bd.toString();
  private static final String aiw = b.eg.toString();
  private static final String aix = b.ei.toString();
  private static final String aiy = b.ek.toString();
  private static Map<String, String> aiz;
  private final DataLayer aer;
  private final Set<String> aiB;
  private final de aiC;
  
  public di(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new de(paramContext));
  }
  
  di(Context paramContext, DataLayer paramDataLayer, de paramde)
  {
    super(ID, new String[0]);
    this.aer = paramDataLayer;
    this.aiC = paramde;
    this.aiB = new HashSet();
    this.aiB.add("");
    this.aiB.add("0");
    this.aiB.add("false");
  }
  
  private Map<String, String> G(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(aix);
    if (localObject == null)
    {
      if (aiz == null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("transactionId", "&ti");
        ((HashMap)localObject).put("transactionAffiliation", "&ta");
        ((HashMap)localObject).put("transactionTax", "&tt");
        ((HashMap)localObject).put("transactionShipping", "&ts");
        ((HashMap)localObject).put("transactionTotal", "&tr");
        ((HashMap)localObject).put("transactionCurrency", "&cu");
        aiz = (Map)localObject;
      }
      localObject = aiz;
    }
    else
    {
      localObject = c((d.a)localObject);
    }
    return localObject;
  }
  
  private Map<String, String> H(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(aiy);
    if (localObject == null)
    {
      if (aiA == null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("name", "&in");
        ((HashMap)localObject).put("sku", "&ic");
        ((HashMap)localObject).put("category", "&iv");
        ((HashMap)localObject).put("price", "&ip");
        ((HashMap)localObject).put("quantity", "&iq");
        ((HashMap)localObject).put("currency", "&cu");
        aiA = (Map)localObject;
      }
      localObject = aiA;
    }
    else
    {
      localObject = c((d.a)localObject);
    }
    return localObject;
  }
  
  private void a(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    String str = cu("transactionId");
    if (str == null) {
      bh.A("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject2 = p((d.a)paramMap.get(aiv));
        ((Map)localObject2).put("&t", "transaction");
        localObject3 = G(paramMap).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject3).next();
          b((Map)localObject2, (String)((Map.Entry)localObject1).getValue(), cu((String)((Map.Entry)localObject1).getKey()));
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        bh.b("Unable to send transaction", localIllegalArgumentException);
      }
      localIllegalArgumentException.add(localObject2);
      Object localObject1 = mZ();
      if (localObject1 != null)
      {
        Iterator localIterator2 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!localIterator2.hasNext()) {
            break label340;
          }
          Map localMap = (Map)localIterator2.next();
          if (localMap.get("name") == null)
          {
            bh.A("Unable to send transaction item hit due to missing 'name' field.");
            break;
          }
          localObject3 = p((d.a)paramMap.get(aiv));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          localObject1 = H(paramMap).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            b((Map)localObject3, (String)((Map.Entry)localObject2).getValue(), (String)localMap.get(((Map.Entry)localObject2).getKey()));
          }
          localIllegalArgumentException.add(localObject3);
        }
      }
      label340:
      Iterator localIterator1 = localIllegalArgumentException.iterator();
      while (localIterator1.hasNext()) {
        paramTracker.send((Map)localIterator1.next());
      }
    }
  }
  
  private void b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private Map<String, String> c(d.a parama)
  {
    Object localObject1 = dh.o(parama);
    if ((localObject1 instanceof Map))
    {
      Object localObject2 = (Map)localObject1;
      localObject1 = new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext())
        {
          localObject1 = localObject1;
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put(localEntry.getKey().toString(), localEntry.getValue().toString());
      }
    }
    localObject1 = null;
    return localObject1;
  }
  
  private String cu(String paramString)
  {
    Object localObject = this.aer.get(paramString);
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  private boolean e(Map<String, d.a> paramMap, String paramString)
  {
    d.a locala = (d.a)paramMap.get(paramString);
    boolean bool;
    if (locala != null) {
      bool = dh.n(locala).booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  private List<Map<String, String>> mZ()
  {
    Object localObject = this.aer.get("transactionProducts");
    if (localObject != null)
    {
      if ((localObject instanceof List))
      {
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext())
          {
            localObject = (List)localObject;
            break;
          }
        } while ((localIterator.next() instanceof Map));
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    localObject = null;
    return localObject;
  }
  
  private Map<String, String> p(d.a parama)
  {
    Object localObject;
    if (parama != null)
    {
      Map localMap = c(parama);
      if (localMap != null)
      {
        localObject = (String)localMap.get("&aip");
        if ((localObject != null) && (this.aiB.contains(((String)localObject).toLowerCase()))) {
          localMap.remove("&aip");
        }
        localObject = localMap;
      }
      else
      {
        localObject = new HashMap();
      }
    }
    else
    {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    Tracker localTracker = this.aiC.cm("_GTM_DEFAULT_TRACKER_");
    if (!e(paramMap, aiu))
    {
      if (!e(paramMap, aiw)) {
        bh.D("Ignoring unknown tag.");
      } else {
        a(localTracker, paramMap);
      }
    }
    else {
      localTracker.send(p((d.a)paramMap.get(aiv)));
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.di
 * JD-Core Version:    0.7.0.1
 */