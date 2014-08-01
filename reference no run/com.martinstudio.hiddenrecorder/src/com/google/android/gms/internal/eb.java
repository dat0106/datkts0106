package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class eb
{
  private int mOrientation = -1;
  private String qD;
  private String qE;
  private String qF;
  private List<String> qG;
  private String qH;
  private String qI;
  private List<String> qJ;
  private long qK = -1L;
  private boolean qL = false;
  private final long qM = -1L;
  private List<String> qN;
  private long qO = -1L;
  
  private static String a(Map<String, List<String>> paramMap, String paramString)
  {
    Object localObject = (List)paramMap.get(paramString);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      localObject = null;
    } else {
      localObject = (String)((List)localObject).get(0);
    }
    return localObject;
  }
  
  private static long b(Map<String, List<String>> paramMap, String paramString)
  {
    Object localObject = (List)paramMap.get(paramString);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {}
    long l;
    for (localObject = (String)((List)localObject).get(0);; l = -1L) {
      try
      {
        float f = Float.parseFloat((String)localObject);
        l = (f * 1000.0F);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ev.D("Could not parse float from " + paramString + " header: " + l);
      }
    }
  }
  
  private static List<String> c(Map<String, List<String>> paramMap, String paramString)
  {
    Object localObject = (List)paramMap.get(paramString);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (String)((List)localObject).get(0);
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    localObject = Arrays.asList(((String)localObject).trim().split("\\s+"));
    return localObject;
  }
  
  private void e(Map<String, List<String>> paramMap)
  {
    this.qD = a(paramMap, "X-Afma-Ad-Size");
  }
  
  private void f(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (localList != null) {
      this.qG = localList;
    }
  }
  
  private void g(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((localList != null) && (!localList.isEmpty())) {
      this.qH = ((String)localList.get(0));
    }
  }
  
  private void h(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Tracking-Urls");
    if (localList != null) {
      this.qJ = localList;
    }
  }
  
  private void i(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.qK = l;
    }
  }
  
  private void j(Map<String, List<String>> paramMap)
  {
    this.qI = a(paramMap, "X-Afma-ActiveView");
  }
  
  private void k(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("X-Afma-Mediation");
    if ((localList != null) && (!localList.isEmpty())) {
      this.qL = Boolean.valueOf((String)localList.get(0)).booleanValue();
    }
  }
  
  private void l(Map<String, List<String>> paramMap)
  {
    List localList = c(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (localList != null) {
      this.qN = localList;
    }
  }
  
  private void m(Map<String, List<String>> paramMap)
  {
    long l = b(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.qO = l;
    }
  }
  
  private void n(Map<String, List<String>> paramMap)
  {
    Object localObject = (List)paramMap.get("X-Afma-Orientation");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (String)((List)localObject).get(0);
      if (!"portrait".equalsIgnoreCase((String)localObject))
      {
        if ("landscape".equalsIgnoreCase((String)localObject)) {
          this.mOrientation = ep.bM();
        }
      }
      else {
        this.mOrientation = ep.bN();
      }
    }
  }
  
  public void a(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.qE = paramString1;
    this.qF = paramString2;
    d(paramMap);
  }
  
  public void d(Map<String, List<String>> paramMap)
  {
    e(paramMap);
    f(paramMap);
    g(paramMap);
    h(paramMap);
    i(paramMap);
    k(paramMap);
    l(paramMap);
    m(paramMap);
    n(paramMap);
    j(paramMap);
  }
  
  public dv i(long paramLong)
  {
    return new dv(this.qE, this.qF, this.qG, this.qJ, this.qK, this.qL, -1L, this.qN, this.qO, this.mOrientation, this.qD, paramLong, this.qH, this.qI);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eb
 * JD-Core Version:    0.7.0.1
 */