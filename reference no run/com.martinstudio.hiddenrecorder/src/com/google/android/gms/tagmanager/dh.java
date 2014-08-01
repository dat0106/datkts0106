package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh
{
  private static final Object aik = null;
  private static Long ail = new Long(0L);
  private static Double aim = new Double(0.0D);
  private static dg ain = dg.z(0L);
  private static String aio = new String("");
  private static Boolean aip = new Boolean(false);
  private static List<Object> aiq = new ArrayList(0);
  private static Map<Object, Object> air = new HashMap();
  private static d.a ais = r(aio);
  
  public static d.a cp(String paramString)
  {
    d.a locala = new d.a();
    locala.type = 5;
    locala.fS = paramString;
    return locala;
  }
  
  private static dg cq(String paramString)
  {
    try
    {
      localdg = dg.co(paramString);
      localdg = localdg;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bh.A("Failed to convert '" + paramString + "' to a number.");
        dg localdg = ain;
      }
    }
    return localdg;
  }
  
  private static Long cr(String paramString)
  {
    Object localObject = cq(paramString);
    if (localObject != ain) {
      localObject = Long.valueOf(((dg)localObject).longValue());
    } else {
      localObject = ail;
    }
    return localObject;
  }
  
  private static Double cs(String paramString)
  {
    Object localObject = cq(paramString);
    if (localObject != ain) {
      localObject = Double.valueOf(((dg)localObject).doubleValue());
    } else {
      localObject = aim;
    }
    return localObject;
  }
  
  private static Boolean ct(String paramString)
  {
    Boolean localBoolean;
    if (!"true".equalsIgnoreCase(paramString))
    {
      if (!"false".equalsIgnoreCase(paramString)) {
        localBoolean = aip;
      } else {
        localBoolean = Boolean.FALSE;
      }
    }
    else {
      localBoolean = Boolean.TRUE;
    }
    return localBoolean;
  }
  
  private static double getDouble(Object paramObject)
  {
    double d;
    if (!(paramObject instanceof Number))
    {
      bh.A("getDouble received non-Number");
      d = 0.0D;
    }
    else
    {
      d = ((Number)paramObject).doubleValue();
    }
    return d;
  }
  
  public static String j(d.a parama)
  {
    return m(o(parama));
  }
  
  public static dg k(d.a parama)
  {
    return n(o(parama));
  }
  
  public static Long l(d.a parama)
  {
    return o(o(parama));
  }
  
  public static Double m(d.a parama)
  {
    return p(o(parama));
  }
  
  public static String m(Object paramObject)
  {
    String str;
    if (paramObject != null) {
      str = paramObject.toString();
    } else {
      str = aio;
    }
    return str;
  }
  
  public static Object mS()
  {
    return aik;
  }
  
  public static Long mT()
  {
    return ail;
  }
  
  public static Double mU()
  {
    return aim;
  }
  
  public static Boolean mV()
  {
    return aip;
  }
  
  public static dg mW()
  {
    return ain;
  }
  
  public static String mX()
  {
    return aio;
  }
  
  public static d.a mY()
  {
    return ais;
  }
  
  public static dg n(Object paramObject)
  {
    dg localdg;
    if (!(paramObject instanceof dg))
    {
      if (!t(paramObject))
      {
        if (!s(paramObject)) {
          localdg = cq(m(paramObject));
        } else {
          localdg = dg.a(Double.valueOf(getDouble(paramObject)));
        }
      }
      else {
        localdg = dg.z(u(paramObject));
      }
    }
    else {
      localdg = (dg)paramObject;
    }
    return localdg;
  }
  
  public static Boolean n(d.a parama)
  {
    return q(o(parama));
  }
  
  public static Long o(Object paramObject)
  {
    Long localLong;
    if (!t(paramObject)) {
      localLong = cr(m(paramObject));
    } else {
      localLong = Long.valueOf(u(paramObject));
    }
    return localLong;
  }
  
  public static Object o(d.a parama)
  {
    int i = 0;
    Object localObject1;
    if (parama != null)
    {
      Object localObject4;
      Object localObject2;
      Object localObject5;
      Object localObject6;
      switch (parama.type)
      {
      default: 
        bh.A("Failed to convert a value of type: " + parama.type);
        localObject1 = aik;
        break;
      case 1: 
        localObject1 = parama.fN;
        break;
      case 2: 
        localObject4 = new ArrayList(parama.fO.length);
        localObject2 = parama.fO;
        localObject5 = localObject2.length;
        for (;;)
        {
          if (localObject1 >= localObject5) {
            return localObject4;
          }
          localObject6 = o(localObject2[localObject1]);
          if (localObject6 == aik) {
            break;
          }
          ((ArrayList)localObject4).add(localObject6);
          localObject1++;
        }
        localObject1 = aik;
        break;
      case 3: 
        if (parama.fP.length == parama.fQ.length)
        {
          localObject5 = new HashMap(parama.fQ.length);
          for (;;)
          {
            if (localObject1 >= parama.fP.length) {
              return localObject5;
            }
            localObject2 = o(parama.fP[localObject1]);
            localObject4 = o(parama.fQ[localObject1]);
            if ((localObject2 == aik) || (localObject4 == aik)) {
              break;
            }
            ((Map)localObject5).put(localObject2, localObject4);
            localObject1++;
          }
          localObject1 = aik;
        }
        else
        {
          bh.A("Converting an invalid value to object: " + parama.toString());
          localObject1 = aik;
        }
        break;
      case 4: 
        bh.A("Trying to convert a macro reference to object");
        localObject1 = aik;
        break;
      case 5: 
        bh.A("Trying to convert a function id to object");
        localObject1 = aik;
        break;
      case 6: 
        localObject1 = Long.valueOf(parama.fT);
        break;
      case 7: 
        localObject5 = new StringBuffer();
        localObject4 = parama.fV;
        Object localObject3 = localObject4.length;
        for (;;)
        {
          if (localObject1 >= localObject3) {
            return ((StringBuffer)localObject5).toString();
          }
          localObject6 = j(localObject4[localObject1]);
          if (localObject6 == aio) {
            break;
          }
          ((StringBuffer)localObject5).append((String)localObject6);
          localObject1++;
        }
        localObject1 = aik;
        break;
      case 8: 
        localObject1 = Boolean.valueOf(parama.fU);
        break;
      }
    }
    else
    {
      localObject1 = aik;
    }
    return localObject1;
  }
  
  public static Double p(Object paramObject)
  {
    Double localDouble;
    if (!s(paramObject)) {
      localDouble = cs(m(paramObject));
    } else {
      localDouble = Double.valueOf(getDouble(paramObject));
    }
    return localDouble;
  }
  
  public static Boolean q(Object paramObject)
  {
    Boolean localBoolean;
    if (!(paramObject instanceof Boolean)) {
      localBoolean = ct(m(paramObject));
    } else {
      localBoolean = (Boolean)paramObject;
    }
    return localBoolean;
  }
  
  public static d.a r(Object paramObject)
  {
    int i = 0;
    Object localObject1 = new d.a();
    if (!(paramObject instanceof d.a))
    {
      Object localObject2;
      if (!(paramObject instanceof String))
      {
        Object localObject4;
        Object localObject3;
        if (!(paramObject instanceof List))
        {
          if (!(paramObject instanceof Map))
          {
            if (!s(paramObject))
            {
              if (!t(paramObject))
              {
                if (!(paramObject instanceof Boolean))
                {
                  localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
                  if (paramObject != null) {
                    localObject2 = paramObject.getClass().toString();
                  } else {
                    localObject2 = "null";
                  }
                  bh.A((String)localObject2);
                  return ais;
                }
                ((d.a)localObject1).type = 8;
                ((d.a)localObject1).fU = ((Boolean)paramObject).booleanValue();
              }
              else
              {
                ((d.a)localObject1).type = 6;
                ((d.a)localObject1).fT = u(paramObject);
              }
            }
            else
            {
              ((d.a)localObject1).type = 1;
              ((d.a)localObject1).fN = paramObject.toString();
            }
          }
          else
          {
            ((d.a)localObject1).type = 3;
            localObject4 = ((Map)paramObject).entrySet();
            localObject2 = new ArrayList(((Set)localObject4).size());
            localObject3 = new ArrayList(((Set)localObject4).size());
            Iterator localIterator = ((Set)localObject4).iterator();
            for (Object localObject6 = 0;; localObject6 = localObject6)
            {
              if (!localIterator.hasNext())
              {
                ((d.a)localObject1).fP = ((d.a[])((List)localObject2).toArray(new d.a[0]));
                ((d.a)localObject1).fQ = ((d.a[])((List)localObject3).toArray(new d.a[0]));
                localObject2 = localObject6;
                break label527;
              }
              Object localObject7 = (Map.Entry)localIterator.next();
              localObject4 = r(((Map.Entry)localObject7).getKey());
              localObject7 = r(((Map.Entry)localObject7).getValue());
              if ((localObject4 == ais) || (localObject7 == ais)) {
                break;
              }
              if ((localObject6 == 0) && (!((d.a)localObject4).fX) && (!((d.a)localObject7).fX)) {
                localObject6 = 0;
              } else {
                localObject6 = 1;
              }
              ((List)localObject2).add(localObject4);
              ((List)localObject3).add(localObject7);
            }
            return ais;
          }
        }
        else
        {
          ((d.a)localObject1).type = 2;
          localObject3 = (List)paramObject;
          localObject2 = new ArrayList(((List)localObject3).size());
          localObject4 = ((List)localObject3).iterator();
          for (Object localObject5 = 0;; localObject5 = localObject5)
          {
            if (!((Iterator)localObject4).hasNext())
            {
              ((d.a)localObject1).fO = ((d.a[])((List)localObject2).toArray(new d.a[0]));
              localObject2 = localObject5;
              break label527;
            }
            localObject3 = r(((Iterator)localObject4).next());
            if (localObject3 == ais) {
              break;
            }
            if ((localObject5 == 0) && (!((d.a)localObject3).fX)) {
              localObject5 = 0;
            } else {
              localObject5 = 1;
            }
            ((List)localObject2).add(localObject3);
          }
          return ais;
        }
      }
      else
      {
        ((d.a)localObject1).type = 1;
        ((d.a)localObject1).fN = ((String)paramObject);
      }
      label527:
      ((d.a)localObject1).fX = localObject2;
      localObject1 = localObject1;
    }
    else
    {
      localObject1 = (d.a)paramObject;
    }
    return localObject1;
  }
  
  private static boolean s(Object paramObject)
  {
    boolean bool;
    if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float)) && ((!(paramObject instanceof dg)) || (!((dg)paramObject).mN()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean t(Object paramObject)
  {
    boolean bool;
    if ((!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && ((!(paramObject instanceof dg)) || (!((dg)paramObject).mO()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static long u(Object paramObject)
  {
    long l;
    if (!(paramObject instanceof Number))
    {
      bh.A("getInt64 received non-Number");
      l = 0L;
    }
    else
    {
      l = ((Number)paramObject).longValue();
    }
    return l;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dh
 * JD-Core Version:    0.7.0.1
 */