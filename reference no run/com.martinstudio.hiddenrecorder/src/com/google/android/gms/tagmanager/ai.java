package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.c;
import com.google.android.gms.internal.c.d;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ai
{
  private static void a(DataLayer paramDataLayer, c.d paramd)
  {
    d.a[] arrayOfa = paramd.eS;
    int j = arrayOfa.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      paramDataLayer.bN(dh.j(arrayOfa[i]));
    }
  }
  
  public static void a(DataLayer paramDataLayer, c.i parami)
  {
    if (parami.fI != null)
    {
      a(paramDataLayer, parami.fI);
      b(paramDataLayer, parami.fI);
      c(paramDataLayer, parami.fI);
    }
    else
    {
      bh.D("supplemental missing experimentSupplemental");
    }
  }
  
  private static void b(DataLayer paramDataLayer, c.d paramd)
  {
    d.a[] arrayOfa = paramd.eR;
    int i = arrayOfa.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      Map localMap = c(arrayOfa[j]);
      if (localMap != null) {
        paramDataLayer.push(localMap);
      }
    }
  }
  
  private static Map<String, Object> c(d.a parama)
  {
    Object localObject = dh.o(parama);
    if ((localObject instanceof Map))
    {
      localObject = (Map)localObject;
    }
    else
    {
      bh.D("value: " + localObject + " is not a map value, ignored.");
      localObject = null;
    }
    return localObject;
  }
  
  private static void c(DataLayer paramDataLayer, c.d paramd)
  {
    c.c[] arrayOfc = paramd.eT;
    int i = arrayOfc.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      c.c localc = arrayOfc[j];
      if (localc.eM != null)
      {
        Object localObject2 = paramDataLayer.get(localc.eM);
        Long localLong;
        if ((localObject2 instanceof Number)) {
          localLong = Long.valueOf(((Number)localObject2).longValue());
        } else {
          localLong = null;
        }
        long l2 = localc.eN;
        long l1 = localc.eO;
        if ((!localc.eP) || (localLong == null) || (localLong.longValue() < l2) || (localLong.longValue() > l1))
        {
          if (l2 > l1) {
            bh.D("GaExperimentRandom: random range invalid");
          } else {
            localObject2 = Long.valueOf(Math.round(Math.random() * (l1 - l2) + l2));
          }
        }
        else
        {
          paramDataLayer.bN(localc.eM);
          Map localMap = paramDataLayer.c(localc.eM, localObject2);
          if (localc.eQ > 0L)
          {
            Object localObject1;
            if (localMap.containsKey("gtm"))
            {
              localObject1 = localMap.get("gtm");
              if (!(localObject1 instanceof Map)) {
                bh.D("GaExperimentRandom: gtm not a map");
              } else {
                ((Map)localObject1).put("lifetime", Long.valueOf(localc.eQ));
              }
            }
            else
            {
              localObject1 = new Object[2];
              localObject1[0] = "lifetime";
              localObject1[1] = Long.valueOf(localc.eQ);
              localMap.put("gtm", DataLayer.mapOf((Object[])localObject1));
            }
          }
          paramDataLayer.push(localMap);
        }
      }
      else
      {
        bh.D("GaExperimentRandom: No key");
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ai
 * JD-Core Version:    0.7.0.1
 */