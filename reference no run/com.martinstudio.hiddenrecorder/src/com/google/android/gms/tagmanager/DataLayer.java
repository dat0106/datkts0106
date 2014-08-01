package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  static final String[] aeV = "gtm.lifetime".toString().split("\\.");
  private static final Pattern aeW = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<b, Integer> aeX;
  private final Map<String, Object> aeY;
  private final ReentrantLock aeZ;
  private final LinkedList<Map<String, Object>> afa;
  private final c afb;
  private final CountDownLatch afc;
  
  DataLayer()
  {
    this(new c()
    {
      public void a(DataLayer.c.a paramAnonymousa)
      {
        paramAnonymousa.d(new ArrayList());
      }
      
      public void a(List<DataLayer.a> paramAnonymousList, long paramAnonymousLong) {}
      
      public void bP(String paramAnonymousString) {}
    });
  }
  
  DataLayer(c paramc)
  {
    this.afb = paramc;
    this.aeX = new ConcurrentHashMap();
    this.aeY = new HashMap();
    this.aeZ = new ReentrantLock();
    this.afa = new LinkedList();
    this.afc = new CountDownLatch(1);
    lt();
  }
  
  private void A(Map<String, Object> paramMap)
  {
    Long localLong = B(paramMap);
    if (localLong != null)
    {
      List localList = D(paramMap);
      localList.remove("gtm.lifetime");
      this.afb.a(localList, localLong.longValue());
    }
  }
  
  private Long B(Map<String, Object> paramMap)
  {
    Object localObject = C(paramMap);
    if (localObject != null) {
      localObject = bO(localObject.toString());
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  private Object C(Map<String, Object> paramMap)
  {
    String[] arrayOfString = aeV;
    int i = arrayOfString.length;
    int j = 0;
    Object localObject2 = paramMap;
    while (j < i)
    {
      Object localObject1 = arrayOfString[j];
      if ((localObject2 instanceof Map))
      {
        localObject1 = ((Map)localObject2).get(localObject1);
        j++;
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = null;
      }
    }
    return localObject2;
  }
  
  private List<a> D(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  /* Error */
  private void E(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/google/android/gms/tagmanager/DataLayer:aeY	Ljava/util/Map;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: invokeinterface 164 1 0
    //   13: invokeinterface 170 1 0
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 176 1 0
    //   25: ifeq +44 -> 69
    //   28: aload_3
    //   29: invokeinterface 180 1 0
    //   34: checkcast 53	java/lang/String
    //   37: astore 4
    //   39: aload_0
    //   40: aload_0
    //   41: aload 4
    //   43: aload_1
    //   44: aload 4
    //   46: invokeinterface 151 2 0
    //   51: invokevirtual 183	com/google/android/gms/tagmanager/DataLayer:c	(Ljava/lang/String;Ljava/lang/Object;)Ljava/util/Map;
    //   54: aload_0
    //   55: getfield 91	com/google/android/gms/tagmanager/DataLayer:aeY	Ljava/util/Map;
    //   58: invokevirtual 186	com/google/android/gms/tagmanager/DataLayer:a	(Ljava/util/Map;Ljava/util/Map;)V
    //   61: goto -42 -> 19
    //   64: astore_3
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_3
    //   68: athrow
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial 189	com/google/android/gms/tagmanager/DataLayer:F	(Ljava/util/Map;)V
    //   76: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	DataLayer
    //   0	77	1	paramMap	Map<String, Object>
    //   4	66	2	localMap	Map
    //   18	11	3	localIterator	Iterator
    //   64	4	3	localObject	Object
    //   37	8	4	str	String
    // Exception table:
    //   from	to	target	type
    //   7	67	64	finally
    //   69	71	64	finally
  }
  
  private void F(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.aeX.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((b)localIterator.next()).x(paramMap);
    }
  }
  
  private void a(Map<String, Object> paramMap, String paramString, Collection<a> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = new StringBuilder().append(paramString);
      String str;
      if (paramString.length() != 0) {
        str = ".";
      } else {
        str = "";
      }
      localObject = str + (String)localEntry.getKey();
      if (!(localEntry.getValue() instanceof Map))
      {
        if (!((String)localObject).equals("gtm.lifetime")) {
          paramCollection.add(new a((String)localObject, localEntry.getValue()));
        }
      }
      else {
        a((Map)localEntry.getValue(), (String)localObject, paramCollection);
      }
    }
  }
  
  static Long bO(String paramString)
  {
    Long localLong = null;
    Object localObject = aeW.matcher(paramString);
    if (!((Matcher)localObject).matches()) {
      bh.B("unknown _lifetime: " + paramString);
    }
    for (;;)
    {
      return localLong;
      long l;
      try
      {
        l = Long.parseLong(((Matcher)localObject).group(1));
        l = l;
        if (l <= 0L) {
          bh.B("non-positive _lifetime: " + paramString);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          bh.D("illegal number in _lifetime value: " + paramString);
          l = 0L;
        }
        localObject = ((Matcher)localObject).group(2);
        if (((String)localObject).length() == 0)
        {
          localLong = Long.valueOf(l);
          continue;
        }
        switch (((String)localObject).charAt(0))
        {
        default: 
          bh.D("unknown units in _lifetime: " + paramString);
        }
      }
      continue;
      localLong = Long.valueOf(l * 1000L);
      continue;
      localLong = Long.valueOf(60L * (l * 1000L));
      continue;
      localLong = Long.valueOf(60L * (60L * (l * 1000L)));
      continue;
      localLong = Long.valueOf(24L * (60L * (60L * (l * 1000L))));
    }
  }
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0;; i++)
    {
      if (i >= paramVarArgs.length) {
        return localArrayList;
      }
      localArrayList.add(paramVarArgs[i]);
    }
  }
  
  private void lt()
  {
    this.afb.a(new DataLayer.c.a()
    {
      public void d(List<DataLayer.a> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            DataLayer.a(DataLayer.this).countDown();
            return;
          }
          DataLayer.a locala = (DataLayer.a)localIterator.next();
          DataLayer.a(DataLayer.this, DataLayer.this.c(locala.JI, locala.afe));
        }
      }
    });
  }
  
  private void lu()
  {
    for (int i = 0;; i = i)
    {
      Map localMap = (Map)this.afa.poll();
      if (localMap == null) {
        return;
      }
      E(localMap);
      i += 1;
      if (i > 500) {
        break;
      }
    }
    this.afa.clear();
    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
  }
  
  public static Map<String, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 == 0)
    {
      HashMap localHashMap = new HashMap();
      for (int i = 0;; i += 2)
      {
        if (i >= paramVarArgs.length) {
          return localHashMap;
        }
        if (!(paramVarArgs[i] instanceof String)) {
          break;
        }
        localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
      }
      throw new IllegalArgumentException("key is not a string: " + paramVarArgs[i]);
    }
    throw new IllegalArgumentException("expected even number of key-value pairs");
  }
  
  private void z(Map<String, Object> paramMap)
  {
    this.aeZ.lock();
    try
    {
      this.afa.offer(paramMap);
      if (this.aeZ.getHoldCount() == 1) {
        lu();
      }
      A(paramMap);
      return;
    }
    finally
    {
      this.aeZ.unlock();
    }
  }
  
  void a(b paramb)
  {
    this.aeX.put(paramb, Integer.valueOf(0));
  }
  
  void a(List<Object> paramList1, List<Object> paramList2)
  {
    for (;;)
    {
      if (paramList2.size() >= paramList1.size()) {
        for (int i = 0;; i++)
        {
          if (i >= paramList1.size()) {
            return;
          }
          Object localObject = paramList1.get(i);
          if (!(localObject instanceof List))
          {
            if (!(localObject instanceof Map))
            {
              if (localObject != OBJECT_NOT_PRESENT) {
                paramList2.set(i, localObject);
              }
            }
            else
            {
              if (!(paramList2.get(i) instanceof Map)) {
                paramList2.set(i, new HashMap());
              }
              a((Map)localObject, (Map)paramList2.get(i));
            }
          }
          else
          {
            if (!(paramList2.get(i) instanceof List)) {
              paramList2.set(i, new ArrayList());
            }
            a((List)localObject, (List)paramList2.get(i));
          }
        }
      }
      paramList2.add(null);
    }
  }
  
  void a(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if (!(localObject instanceof List))
      {
        if (!(localObject instanceof Map))
        {
          paramMap2.put(str, localObject);
        }
        else
        {
          if (!(paramMap2.get(str) instanceof Map)) {
            paramMap2.put(str, new HashMap());
          }
          a((Map)localObject, (Map)paramMap2.get(str));
        }
      }
      else
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        a((List)localObject, (List)paramMap2.get(str));
      }
    }
  }
  
  void bN(String paramString)
  {
    push(paramString, null);
    this.afb.bP(paramString);
  }
  
  Map<String, Object> c(String paramString, Object paramObject)
  {
    HashMap localHashMap2 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap1;
    for (Object localObject = localHashMap2;; localObject = localHashMap1)
    {
      if (i >= -1 + arrayOfString.length)
      {
        ((Map)localObject).put(arrayOfString[(-1 + arrayOfString.length)], paramObject);
        return localHashMap2;
      }
      localHashMap1 = new HashMap();
      ((Map)localObject).put(arrayOfString[i], localHashMap1);
      i++;
    }
  }
  
  public Object get(String paramString)
  {
    for (;;)
    {
      int j;
      synchronized (this.aeY)
      {
        Map localMap2 = this.aeY;
        String[] arrayOfString = paramString.split("\\.");
        int i = arrayOfString.length;
        localObject2 = localMap2;
        j = 0;
        if (j < i)
        {
          String str = arrayOfString[j];
          if (!(localObject2 instanceof Map))
          {
            localObject2 = null;
          }
          else
          {
            localObject2 = ((Map)localObject2).get(str);
            if (localObject2 != null) {
              break label101;
            }
            localObject2 = null;
          }
        }
      }
      return localObject2;
      label101:
      j++;
      Object localObject2 = localObject2;
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(c(paramString, paramObject));
  }
  
  public void push(Map<String, Object> paramMap)
  {
    try
    {
      this.afc.await();
      z(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bh.D("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  public void pushEvent(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    localHashMap.put("event", paramString);
    push(localHashMap);
  }
  
  static abstract interface c
  {
    public abstract void a(a parama);
    
    public abstract void a(List<DataLayer.a> paramList, long paramLong);
    
    public abstract void bP(String paramString);
    
    public static abstract interface a
    {
      public abstract void d(List<DataLayer.a> paramList);
    }
  }
  
  static final class a
  {
    public final String JI;
    public final Object afe;
    
    a(String paramString, Object paramObject)
    {
      this.JI = paramString;
      this.afe = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if ((paramObject instanceof a))
      {
        a locala = (a)paramObject;
        if ((this.JI.equals(locala.JI)) && (this.afe.equals(locala.afe))) {
          bool = true;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      Integer[] arrayOfInteger = new Integer[2];
      arrayOfInteger[0] = Integer.valueOf(this.JI.hashCode());
      arrayOfInteger[1] = Integer.valueOf(this.afe.hashCode());
      return Arrays.hashCode(arrayOfInteger);
    }
    
    public String toString()
    {
      return "Key: " + this.JI + " value: " + this.afe.toString();
    }
  }
  
  static abstract interface b
  {
    public abstract void x(Map<String, Object> paramMap);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.DataLayer
 * JD-Core Version:    0.7.0.1
 */