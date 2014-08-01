package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.c.b;
import com.google.android.gms.internal.c.e;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.g;
import com.google.android.gms.internal.c.h;
import com.google.android.gms.internal.d.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq
{
  private static d.a a(int paramInt, c.f paramf, d.a[] paramArrayOfa, Set<Integer> paramSet)
    throws cq.g
  {
    int i = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      cd("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    d.a locala2 = (d.a)a(paramf.eX, paramInt, "values");
    if (paramArrayOfa[paramInt] == null)
    {
      d.a locala1 = null;
      paramSet.add(Integer.valueOf(paramInt));
      int[] arrayOfInt1;
      int j;
      int i5;
      Object localObject2;
      int i3;
      switch (locala2.type)
      {
      case 1: 
      case 5: 
      case 6: 
      case 8: 
        locala1 = locala2;
        break;
      case 2: 
        c.h localh1 = h(locala2);
        locala1 = g(locala2);
        locala1.fO = new d.a[localh1.fz.length];
        arrayOfInt1 = localh1.fz;
        j = arrayOfInt1.length;
        i5 = 0;
      case 3: 
      case 4: 
      case 7: 
        while (i < j)
        {
          int i4 = arrayOfInt1[i];
          d.a[] arrayOfa1 = locala1.fO;
          int i2 = i5 + 1;
          arrayOfa1[i5] = a(i4, paramf, paramArrayOfa, paramSet);
          i++;
          i5 = i2;
          continue;
          locala1 = g(locala2);
          localObject2 = h(locala2);
          if (((c.h)localObject2).fA.length != ((c.h)localObject2).fB.length) {
            cd("Uneven map keys (" + ((c.h)localObject2).fA.length + ") and map values (" + ((c.h)localObject2).fB.length + ")");
          }
          locala1.fP = new d.a[((c.h)localObject2).fA.length];
          locala1.fQ = new d.a[((c.h)localObject2).fA.length];
          int[] arrayOfInt3 = ((c.h)localObject2).fA;
          j = arrayOfInt3.length;
          i2 = 0;
          int i6;
          for (m = 0;; m = i6)
          {
            int[] arrayOfInt2;
            if (i2 >= j)
            {
              arrayOfInt2 = ((c.h)localObject2).fB;
              i5 = arrayOfInt2.length;
              int n;
              for (j = 0; i < i5; j = n)
              {
                m = arrayOfInt2[i];
                localObject2 = locala1.fQ;
                n = j + 1;
                localObject2[j] = a(m, paramf, paramArrayOfa, paramSet);
                i++;
              }
            }
            i5 = arrayOfInt3[arrayOfInt2];
            d.a[] arrayOfa2 = locala1.fP;
            i6 = m + 1;
            arrayOfa2[m] = a(i5, paramf, paramArrayOfa, paramSet);
            arrayOfInt2++;
          }
          locala1 = g(locala2);
          locala1.fR = dh.j(a(h(locala2).fE, paramf, paramArrayOfa, paramSet));
          break;
          locala1 = g(locala2);
          c.h localh2 = h(locala2);
          locala1.fV = new d.a[localh2.fD.length];
          localObject2 = localh2.fD;
          i3 = localObject2.length;
        }
      }
      int i1;
      for (int m = 0;; m = i1)
      {
        if (i >= i3)
        {
          if (locala1 == null) {
            cd("Invalid value: " + locala2);
          }
          paramArrayOfa[paramInt] = locala1;
          paramSet.remove(Integer.valueOf(paramInt));
          localObject1 = locala1;
          break;
        }
        int k = localObject2[localObject1];
        d.a[] arrayOfa3 = locala1.fV;
        i1 = m + 1;
        arrayOfa3[m] = a(k, paramf, paramArrayOfa, paramSet);
        localObject1++;
      }
    }
    Object localObject1 = paramArrayOfa[paramInt];
    return localObject1;
  }
  
  private static a a(c.b paramb, c.f paramf, d.a[] paramArrayOfa, int paramInt)
    throws cq.g
  {
    b localb = a.mi();
    int[] arrayOfInt = paramb.eH;
    int j = arrayOfInt.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return localb.ml();
      }
      Object localObject1 = Integer.valueOf(arrayOfInt[i]);
      Object localObject2 = (c.e)a(paramf.eY, ((Integer)localObject1).intValue(), "properties");
      localObject1 = (String)a(paramf.eW, ((c.e)localObject2).key, "keys");
      localObject2 = (d.a)a(paramArrayOfa, ((c.e)localObject2).value, "values");
      if (!b.dB.toString().equals(localObject1)) {
        localb.b((String)localObject1, (d.a)localObject2);
      } else {
        localb.i((d.a)localObject2);
      }
    }
  }
  
  private static e a(c.g paramg, List<a> paramList1, List<a> paramList2, List<a> paramList3, c.f paramf)
  {
    f localf = e.mq();
    int[] arrayOfInt3 = paramg.fn;
    int i = arrayOfInt3.length;
    Integer localInteger2;
    for (int i1 = 0;; localInteger2++)
    {
      Integer localInteger1;
      if (i1 >= i)
      {
        int[] arrayOfInt5 = paramg.fo;
        i = arrayOfInt5.length;
        for (int m = 0;; localInteger1++)
        {
          if (m >= i)
          {
            int[] arrayOfInt1 = paramg.fp;
            m = arrayOfInt1.length;
            for (int i2 = 0;; localInteger2++)
            {
              int k;
              if (i2 >= m)
              {
                arrayOfInt1 = paramg.fr;
                i2 = arrayOfInt1.length;
                for (m = 0;; localInteger1++)
                {
                  if (m >= i2)
                  {
                    int[] arrayOfInt6 = paramg.fq;
                    m = arrayOfInt6.length;
                    for (int j = 0;; k++)
                    {
                      if (j >= m)
                      {
                        int[] arrayOfInt2 = paramg.fs;
                        m = arrayOfInt2.length;
                        for (int i4 = 0;; localObject++)
                        {
                          if (i4 >= m)
                          {
                            arrayOfInt2 = paramg.ft;
                            int i3 = arrayOfInt2.length;
                            for (m = 0;; localInteger1++)
                            {
                              if (m >= i3)
                              {
                                localObject = paramg.fv;
                                i3 = localObject.length;
                                for (k = 0;; k++)
                                {
                                  if (k >= i3)
                                  {
                                    int[] arrayOfInt4 = paramg.fu;
                                    i3 = arrayOfInt4.length;
                                    for (k = 0;; k++)
                                    {
                                      int n;
                                      if (k >= i3)
                                      {
                                        localObject = paramg.fw;
                                        k = localObject.length;
                                        for (n = 0;; n++)
                                        {
                                          if (n >= k) {
                                            return localf.mB();
                                          }
                                          localInteger2 = Integer.valueOf(localObject[n]);
                                          localf.ci(paramf.eX[localInteger2.intValue()].fN);
                                        }
                                      }
                                      localf.g((a)paramList2.get(Integer.valueOf(n[k]).intValue()));
                                    }
                                  }
                                  localInteger1 = Integer.valueOf(localObject[k]);
                                  localf.ch(paramf.eX[localInteger1.intValue()].fN);
                                }
                              }
                              localf.f((a)paramList2.get(Integer.valueOf(k[localInteger1]).intValue()));
                            }
                          }
                          localInteger2 = Integer.valueOf(k[localObject]);
                          localf.cg(paramf.eX[localInteger2.intValue()].fN);
                        }
                      }
                      localf.e((a)paramList1.get(Integer.valueOf(localInteger2[k]).intValue()));
                    }
                  }
                  Object localObject = Integer.valueOf(k[localInteger1]);
                  localf.cf(paramf.eX[localObject.intValue()].fN);
                }
              }
              localf.d((a)paramList1.get(Integer.valueOf(k[localInteger2]).intValue()));
            }
          }
          localf.c((a)paramList3.get(Integer.valueOf(localInteger2[localInteger1]).intValue()));
        }
      }
      localf.b((a)paramList3.get(Integer.valueOf(localInteger1[localInteger2]).intValue()));
    }
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
    throws cq.g
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      cd("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static c b(c.f paramf)
    throws cq.g
  {
    int i = 0;
    d.a[] arrayOfa = new d.a[paramf.eX.length];
    d locald;
    for (int j = 0;; locald++)
    {
      int k;
      if (j >= paramf.eX.length)
      {
        locald = c.mm();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2;
        for (int m = 0;; localArrayList2++)
        {
          if (m >= paramf.fa.length)
          {
            localArrayList2 = new ArrayList();
            ArrayList localArrayList3;
            for (int n = 0;; localArrayList3++)
            {
              if (n >= paramf.fb.length)
              {
                localArrayList3 = new ArrayList();
                for (int i1 = 0;; i1++)
                {
                  if (i1 >= paramf.eZ.length)
                  {
                    localObject = paramf.fc;
                    k = localObject.length;
                    for (;;)
                    {
                      if (i >= k)
                      {
                        locald.ce(paramf.fg);
                        locald.du(paramf.fl);
                        return locald.mp();
                      }
                      locald.a(a(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramf));
                      i++;
                    }
                  }
                  Object localObject = a(paramf.eZ[i1], paramf, k, i1);
                  locald.a((a)localObject);
                  localArrayList3.add(localObject);
                }
              }
              localArrayList2.add(a(paramf.fb[localArrayList3], paramf, k, localArrayList3));
            }
          }
          localArrayList1.add(a(paramf.fa[localArrayList2], paramf, k, localArrayList2));
        }
      }
      a(locald, paramf, k, new HashSet(0));
    }
  }
  
  public static void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void cd(String paramString)
    throws cq.g
  {
    bh.A(paramString);
    throw new g(paramString);
  }
  
  public static d.a g(d.a parama)
  {
    d.a locala = new d.a();
    locala.type = parama.type;
    locala.fW = ((int[])parama.fW.clone());
    if (parama.fX) {
      locala.fX = parama.fX;
    }
    return locala;
  }
  
  private static c.h h(d.a parama)
    throws cq.g
  {
    if ((c.h)parama.a(c.h.fx) == null) {
      cd("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.fx);
  }
  
  public static class c
  {
    private final String aeR;
    private final List<cq.e> agW;
    private final Map<String, List<cq.a>> agX;
    private final int agY;
    
    private c(List<cq.e> paramList, Map<String, List<cq.a>> paramMap, String paramString, int paramInt)
    {
      this.agW = Collections.unmodifiableList(paramList);
      this.agX = Collections.unmodifiableMap(paramMap);
      this.aeR = paramString;
      this.agY = paramInt;
    }
    
    public static cq.d mm()
    {
      return new cq.d(null);
    }
    
    public String getVersion()
    {
      return this.aeR;
    }
    
    public List<cq.e> mn()
    {
      return this.agW;
    }
    
    public Map<String, List<cq.a>> mo()
    {
      return this.agX;
    }
    
    public String toString()
    {
      return "Rules: " + mn() + "  Macros: " + this.agX;
    }
  }
  
  public static class d
  {
    private String aeR = "";
    private final List<cq.e> agW = new ArrayList();
    private final Map<String, List<cq.a>> agX = new HashMap();
    private int agY = 0;
    
    public d a(cq.a parama)
    {
      String str = dh.j((d.a)parama.mj().get(b.cI.toString()));
      Object localObject = (List)this.agX.get(str);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.agX.put(str, localObject);
      }
      ((List)localObject).add(parama);
      return this;
    }
    
    public d a(cq.e parame)
    {
      this.agW.add(parame);
      return this;
    }
    
    public d ce(String paramString)
    {
      this.aeR = paramString;
      return this;
    }
    
    public d du(int paramInt)
    {
      this.agY = paramInt;
      return this;
    }
    
    public cq.c mp()
    {
      return new cq.c(this.agW, this.agX, this.aeR, this.agY, null);
    }
  }
  
  public static class e
  {
    private final List<cq.a> agZ;
    private final List<cq.a> aha;
    private final List<cq.a> ahb;
    private final List<cq.a> ahc;
    private final List<cq.a> ahd;
    private final List<cq.a> ahe;
    private final List<String> ahf;
    private final List<String> ahg;
    private final List<String> ahh;
    private final List<String> ahi;
    
    private e(List<cq.a> paramList1, List<cq.a> paramList2, List<cq.a> paramList3, List<cq.a> paramList4, List<cq.a> paramList5, List<cq.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.agZ = Collections.unmodifiableList(paramList1);
      this.aha = Collections.unmodifiableList(paramList2);
      this.ahb = Collections.unmodifiableList(paramList3);
      this.ahc = Collections.unmodifiableList(paramList4);
      this.ahd = Collections.unmodifiableList(paramList5);
      this.ahe = Collections.unmodifiableList(paramList6);
      this.ahf = Collections.unmodifiableList(paramList7);
      this.ahg = Collections.unmodifiableList(paramList8);
      this.ahh = Collections.unmodifiableList(paramList9);
      this.ahi = Collections.unmodifiableList(paramList10);
    }
    
    public static cq.f mq()
    {
      return new cq.f(null);
    }
    
    public List<cq.a> mA()
    {
      return this.ahe;
    }
    
    public List<cq.a> mr()
    {
      return this.agZ;
    }
    
    public List<cq.a> ms()
    {
      return this.aha;
    }
    
    public List<cq.a> mt()
    {
      return this.ahb;
    }
    
    public List<cq.a> mu()
    {
      return this.ahc;
    }
    
    public List<cq.a> mv()
    {
      return this.ahd;
    }
    
    public List<String> mw()
    {
      return this.ahf;
    }
    
    public List<String> mx()
    {
      return this.ahg;
    }
    
    public List<String> my()
    {
      return this.ahh;
    }
    
    public List<String> mz()
    {
      return this.ahi;
    }
    
    public String toString()
    {
      return "Positive predicates: " + mr() + "  Negative predicates: " + ms() + "  Add tags: " + mt() + "  Remove tags: " + mu() + "  Add macros: " + mv() + "  Remove macros: " + mA();
    }
  }
  
  public static class f
  {
    private final List<cq.a> agZ = new ArrayList();
    private final List<cq.a> aha = new ArrayList();
    private final List<cq.a> ahb = new ArrayList();
    private final List<cq.a> ahc = new ArrayList();
    private final List<cq.a> ahd = new ArrayList();
    private final List<cq.a> ahe = new ArrayList();
    private final List<String> ahf = new ArrayList();
    private final List<String> ahg = new ArrayList();
    private final List<String> ahh = new ArrayList();
    private final List<String> ahi = new ArrayList();
    
    public f b(cq.a parama)
    {
      this.agZ.add(parama);
      return this;
    }
    
    public f c(cq.a parama)
    {
      this.aha.add(parama);
      return this;
    }
    
    public f cf(String paramString)
    {
      this.ahh.add(paramString);
      return this;
    }
    
    public f cg(String paramString)
    {
      this.ahi.add(paramString);
      return this;
    }
    
    public f ch(String paramString)
    {
      this.ahf.add(paramString);
      return this;
    }
    
    public f ci(String paramString)
    {
      this.ahg.add(paramString);
      return this;
    }
    
    public f d(cq.a parama)
    {
      this.ahb.add(parama);
      return this;
    }
    
    public f e(cq.a parama)
    {
      this.ahc.add(parama);
      return this;
    }
    
    public f f(cq.a parama)
    {
      this.ahd.add(parama);
      return this;
    }
    
    public f g(cq.a parama)
    {
      this.ahe.add(parama);
      return this;
    }
    
    public cq.e mB()
    {
      return new cq.e(this.agZ, this.aha, this.ahb, this.ahc, this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi, null);
    }
  }
  
  public static class a
  {
    private final Map<String, d.a> agU;
    private final d.a agV;
    
    private a(Map<String, d.a> paramMap, d.a parama)
    {
      this.agU = paramMap;
      this.agV = parama;
    }
    
    public static cq.b mi()
    {
      return new cq.b(null);
    }
    
    public void a(String paramString, d.a parama)
    {
      this.agU.put(paramString, parama);
    }
    
    public Map<String, d.a> mj()
    {
      return Collections.unmodifiableMap(this.agU);
    }
    
    public d.a mk()
    {
      return this.agV;
    }
    
    public String toString()
    {
      return "Properties: " + mj() + " pushAfterEvaluate: " + this.agV;
    }
  }
  
  public static class b
  {
    private final Map<String, d.a> agU = new HashMap();
    private d.a agV;
    
    public b b(String paramString, d.a parama)
    {
      this.agU.put(paramString, parama);
      return this;
    }
    
    public b i(d.a parama)
    {
      this.agV = parama;
      return this;
    }
    
    public cq.a ml()
    {
      return new cq.a(this.agU, this.agV, null);
    }
  }
  
  public static class g
    extends Exception
  {
    public g(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cq
 * JD-Core Version:    0.7.0.1
 */