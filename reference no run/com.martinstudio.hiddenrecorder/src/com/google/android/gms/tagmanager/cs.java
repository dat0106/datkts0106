package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs
{
  private static final by<d.a> ahj = new by(dh.mY(), true);
  private final DataLayer aer;
  private final cq.c ahk;
  private final ag ahl;
  private final Map<String, aj> ahm;
  private final Map<String, aj> ahn;
  private final Map<String, aj> aho;
  private final k<cq.a, by<d.a>> ahp;
  private final k<String, b> ahq;
  private final Set<cq.e> ahr;
  private final Map<String, c> ahs;
  private volatile String aht;
  private int ahu;
  
  public cs(Context paramContext, cq.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, ag paramag)
  {
    if (paramc != null)
    {
      this.ahk = paramc;
      this.ahr = new HashSet(paramc.mn());
      this.aer = paramDataLayer;
      this.ahl = paramag;
      Object localObject1 = new l.a()
      {
        public int a(cq.a paramAnonymousa, by<d.a> paramAnonymousby)
        {
          return ((d.a)paramAnonymousby.getObject()).nU();
        }
      };
      this.ahp = new l().a(1048576, (l.a)localObject1);
      localObject1 = new l.a()
      {
        public int a(String paramAnonymousString, cs.b paramAnonymousb)
        {
          return paramAnonymousString.length() + paramAnonymousb.getSize();
        }
      };
      this.ahq = new l().a(1048576, (l.a)localObject1);
      this.ahm = new HashMap();
      b(new i(paramContext));
      b(new s(parama2));
      b(new w(paramDataLayer));
      b(new di(paramContext, paramDataLayer));
      this.ahn = new HashMap();
      c(new q());
      c(new ad());
      c(new ae());
      c(new al());
      c(new am());
      c(new bd());
      c(new be());
      c(new ch());
      c(new db());
      this.aho = new HashMap();
      a(new b(paramContext));
      a(new c(paramContext));
      a(new e(paramContext));
      a(new f(paramContext));
      a(new g(paramContext));
      a(new h(paramContext));
      a(new m());
      a(new p(this.ahk.getVersion()));
      a(new s(parama1));
      a(new u(paramDataLayer));
      a(new z(paramContext));
      a(new aa());
      a(new ac());
      a(new ah(this));
      a(new an());
      a(new ao());
      a(new ax(paramContext));
      a(new az());
      a(new bc());
      a(new bk(paramContext));
      a(new bz());
      a(new cb());
      a(new ce());
      a(new cg());
      a(new ci(paramContext));
      a(new ct());
      a(new cu());
      a(new dd());
      this.ahs = new HashMap();
      Iterator localIterator = this.ahr.iterator();
      Object localObject2;
      if (!localIterator.hasNext())
      {
        localIterator = this.ahk.mo().entrySet().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            return;
          }
          localObject2 = (Map.Entry)localIterator.next();
          localObject1 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            cq.a locala1 = (cq.a)((Iterator)localObject1).next();
            if (!dh.n((d.a)locala1.mj().get(com.google.android.gms.internal.b.dh.toString())).booleanValue()) {
              d(this.ahs, (String)((Map.Entry)localObject2).getKey()).i(locala1);
            }
          }
        }
      }
      localObject1 = (cq.e)localIterator.next();
      if (paramag.lF())
      {
        a(((cq.e)localObject1).mv(), ((cq.e)localObject1).mw(), "add macro");
        a(((cq.e)localObject1).mA(), ((cq.e)localObject1).mx(), "remove macro");
        a(((cq.e)localObject1).mt(), ((cq.e)localObject1).my(), "add tag");
        a(((cq.e)localObject1).mu(), ((cq.e)localObject1).mz(), "remove tag");
      }
      String str;
      for (int j = 0;; str++)
      {
        if (j >= ((cq.e)localObject1).mv().size())
        {
          for (int i = 0; i < ((cq.e)localObject1).mA().size(); i++)
          {
            localObject2 = (cq.a)((cq.e)localObject1).mA().get(i);
            str = "Unknown";
            if ((paramag.lF()) && (i < ((cq.e)localObject1).mx().size())) {
              str = (String)((cq.e)localObject1).mx().get(i);
            }
            localObject3 = d(this.ahs, h((cq.a)localObject2));
            ((c)localObject3).b((cq.e)localObject1);
            ((c)localObject3).b((cq.e)localObject1, (cq.a)localObject2);
            ((c)localObject3).b((cq.e)localObject1, str);
          }
          break;
        }
        cq.a locala2 = (cq.a)((cq.e)localObject1).mv().get(str);
        Object localObject3 = "Unknown";
        if ((paramag.lF()) && (str < ((cq.e)localObject1).mw().size())) {
          localObject3 = (String)((cq.e)localObject1).mw().get(str);
        }
        localObject2 = d(this.ahs, h(locala2));
        ((c)localObject2).b((cq.e)localObject1);
        ((c)localObject2).a((cq.e)localObject1, locala2);
        ((c)localObject2).a((cq.e)localObject1, (String)localObject3);
      }
    }
    throw new NullPointerException("resource cannot be null");
  }
  
  private by<d.a> a(d.a parama, Set<String> paramSet, dj paramdj)
  {
    by localby2;
    if (parama.fX)
    {
      Object localObject;
      int j;
      switch (parama.type)
      {
      case 5: 
      case 6: 
      default: 
        bh.A("Unknown type: " + parama.type);
        by localby1 = ahj;
        break;
      case 2: 
        d.a locala = cq.g(parama);
        locala.fO = new d.a[parama.fO.length];
        for (int i = 0;; localby2++)
        {
          if (i >= parama.fO.length)
          {
            localby2 = new by(locala, false);
            break label641;
          }
          localObject = a(parama.fO[localby2], paramSet, paramdj.dq(localby2));
          if (localObject == ahj) {
            break;
          }
          locala.fO[localby2] = ((d.a)((by)localObject).getObject());
        }
        localby2 = ahj;
        break;
      case 3: 
        localObject = cq.g(parama);
        if (parama.fP.length == parama.fQ.length)
        {
          ((d.a)localObject).fP = new d.a[parama.fP.length];
          ((d.a)localObject).fQ = new d.a[parama.fP.length];
          for (j = 0;; j++)
          {
            if (j >= parama.fP.length)
            {
              localby2 = new by(localObject, false);
              break label641;
            }
            localby2 = a(parama.fP[j], paramSet, paramdj.dr(j));
            by localby3 = a(parama.fQ[j], paramSet, paramdj.ds(j));
            if ((localby2 == ahj) || (localby3 == ahj)) {
              break;
            }
            ((d.a)localObject).fP[j] = ((d.a)localby2.getObject());
            ((d.a)localObject).fQ[j] = ((d.a)localby3.getObject());
          }
          localby2 = ahj;
        }
        else
        {
          bh.A("Invalid serving value: " + parama.toString());
          localby2 = ahj;
        }
        break;
      case 4: 
        if (!paramSet.contains(parama.fR))
        {
          paramSet.add(parama.fR);
          localby2 = dk.a(a(parama.fR, paramSet, paramdj.lU()), parama.fW);
          paramSet.remove(parama.fR);
        }
        else
        {
          bh.A("Macro cycle detected.  Current macro reference: " + parama.fR + "." + "  Previous macro references: " + paramSet.toString() + ".");
          localby2 = ahj;
        }
        break;
      case 7: 
        localObject = cq.g(parama);
        ((d.a)localObject).fV = new d.a[parama.fV.length];
        for (j = 0;; j++)
        {
          if (j >= parama.fV.length)
          {
            localby2 = new by(localObject, false);
            break label641;
          }
          localby2 = a(parama.fV[j], paramSet, paramdj.dt(j));
          if (localby2 == ahj) {
            break;
          }
          ((d.a)localObject).fV[j] = ((d.a)localby2.getObject());
        }
        localby2 = ahj;
        break;
      }
    }
    else
    {
      localby2 = new by(parama, true);
    }
    label641:
    return localby2;
  }
  
  private by<d.a> a(String paramString, Set<String> paramSet, bj parambj)
  {
    this.ahu = (1 + this.ahu);
    Object localObject = (b)this.ahq.get(paramString);
    by localby2;
    if ((localObject == null) || (this.ahl.lF()))
    {
      localObject = (c)this.ahs.get(paramString);
      if (localObject != null)
      {
        by localby1 = a(paramString, ((c)localObject).mF(), ((c)localObject).mG(), ((c)localObject).mH(), ((c)localObject).mJ(), ((c)localObject).mI(), paramSet, parambj.lw());
        if (!((Set)localby1.getObject()).isEmpty())
        {
          if (((Set)localby1.getObject()).size() > 1) {
            bh.D(mD() + "Multiple macros active for macroName " + paramString);
          }
          localObject = (cq.a)((Set)localby1.getObject()).iterator().next();
        }
        else
        {
          localObject = ((c)localObject).mK();
        }
        if (localObject != null)
        {
          by localby3 = a(this.aho, (cq.a)localObject, paramSet, parambj.lL());
          boolean bool;
          if ((!localby1.lV()) || (!localby3.lV())) {
            bool = false;
          } else {
            bool = true;
          }
          if (localby3 != ahj) {
            localby2 = new by(localby3.getObject(), bool);
          } else {
            localby2 = ahj;
          }
          localObject = ((cq.a)localObject).mk();
          if (localby2.lV()) {
            this.ahq.e(paramString, new b(localby2, (d.a)localObject));
          }
          a((d.a)localObject, paramSet);
          this.ahu = (-1 + this.ahu);
        }
        else
        {
          this.ahu = (-1 + this.ahu);
          localby2 = ahj;
        }
      }
      else
      {
        bh.A(mD() + "Invalid macro: " + paramString);
        this.ahu = (-1 + this.ahu);
        localby2 = ahj;
      }
    }
    else
    {
      a(((b)localObject).mk(), paramSet);
      this.ahu = (-1 + this.ahu);
      localby2 = ((b)localObject).mE();
    }
    return localby2;
  }
  
  private by<d.a> a(Map<String, aj> paramMap, cq.a parama, Set<String> paramSet, cj paramcj)
  {
    boolean bool1 = true;
    Object localObject1 = (d.a)parama.mj().get(com.google.android.gms.internal.b.cx.toString());
    Object localObject2;
    if (localObject1 != null)
    {
      String str = ((d.a)localObject1).fS;
      localObject1 = (aj)paramMap.get(str);
      if (localObject1 != null)
      {
        localObject2 = (by)this.ahp.get(parama);
        if ((localObject2 == null) || (this.ahl.lF()))
        {
          HashMap localHashMap = new HashMap();
          localObject2 = parama.mj().entrySet().iterator();
          for (boolean bool2 = bool1;; bool2 = bool2)
          {
            if (!((Iterator)localObject2).hasNext())
            {
              if (((aj)localObject1).a(localHashMap.keySet()))
              {
                if ((!bool2) || (!((aj)localObject1).lc())) {
                  bool1 = false;
                }
                localObject2 = new by(((aj)localObject1).w(localHashMap), bool1);
                if (bool1) {
                  this.ahp.e(parama, localObject2);
                }
                paramcj.d((d.a)((by)localObject2).getObject());
                break label461;
              }
              bh.A("Incorrect keys for function " + str + " required " + ((aj)localObject1).lH() + " had " + localHashMap.keySet());
              localObject2 = ahj;
              break label461;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            Object localObject3 = paramcj.bZ((String)localEntry.getKey());
            localObject3 = a((d.a)localEntry.getValue(), paramSet, ((cl)localObject3).e((d.a)localEntry.getValue()));
            if (localObject3 == ahj) {
              break;
            }
            if (!((by)localObject3).lV())
            {
              bool2 = false;
            }
            else
            {
              parama.a((String)localEntry.getKey(), (d.a)((by)localObject3).getObject());
              bool2 = bool2;
            }
            localHashMap.put(localEntry.getKey(), ((by)localObject3).getObject());
          }
          localObject2 = ahj;
        }
      }
      else
      {
        bh.A(str + " has no backing implementation.");
        localObject2 = ahj;
      }
    }
    else
    {
      bh.A("No function id in properties");
      localObject2 = ahj;
    }
    label461:
    return localObject2;
  }
  
  private by<Set<cq.a>> a(Set<cq.e> paramSet, Set<String> paramSet1, a parama, cr paramcr)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Iterator localIterator = paramSet.iterator();
    boolean bool1;
    for (boolean bool2 = true;; bool2 = bool1)
    {
      if (!localIterator.hasNext())
      {
        localHashSet1.removeAll(localHashSet2);
        paramcr.b(localHashSet1);
        return new by(localHashSet1, bool2);
      }
      cq.e locale = (cq.e)localIterator.next();
      cm localcm = paramcr.lT();
      by localby = a(locale, paramSet1, localcm);
      if (((Boolean)localby.getObject()).booleanValue()) {
        parama.a(locale, localHashSet1, localHashSet2, localcm);
      }
      if ((!bool2) || (!localby.lV())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
  }
  
  private void a(d.a parama, Set<String> paramSet)
  {
    if (parama != null)
    {
      Object localObject1 = a(parama, paramSet, new bw());
      if (localObject1 != ahj)
      {
        localObject1 = dh.o((d.a)((by)localObject1).getObject());
        if (!(localObject1 instanceof Map))
        {
          if (!(localObject1 instanceof List))
          {
            bh.D("pushAfterEvaluate: value not a Map or List");
          }
          else
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = ((Iterator)localObject1).next();
              if (!(localObject2 instanceof Map))
              {
                bh.D("pushAfterEvaluate: value not a Map");
              }
              else
              {
                localObject2 = (Map)localObject2;
                this.aer.push((Map)localObject2);
              }
            }
          }
        }
        else
        {
          localObject1 = (Map)localObject1;
          this.aer.push((Map)localObject1);
        }
      }
    }
  }
  
  private static void a(List<cq.a> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      bh.B("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void a(Map<String, aj> paramMap, aj paramaj)
  {
    if (!paramMap.containsKey(paramaj.lG()))
    {
      paramMap.put(paramaj.lG(), paramaj);
      return;
    }
    throw new IllegalArgumentException("Duplicate function type name: " + paramaj.lG());
  }
  
  private static c d(Map<String, c> paramMap, String paramString)
  {
    c localc = (c)paramMap.get(paramString);
    if (localc == null)
    {
      localc = new c();
      paramMap.put(paramString, localc);
    }
    return localc;
  }
  
  private static String h(cq.a parama)
  {
    return dh.j((d.a)parama.mj().get(com.google.android.gms.internal.b.cI.toString()));
  }
  
  private String mD()
  {
    if (this.ahu > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Integer.toString(this.ahu));
      for (int i = 2;; i++)
      {
        if (i >= this.ahu)
        {
          ((StringBuilder)localObject).append(": ");
          localObject = ((StringBuilder)localObject).toString();
          break;
        }
        ((StringBuilder)localObject).append(' ');
      }
    }
    Object localObject = "";
    return localObject;
  }
  
  by<Boolean> a(cq.a parama, Set<String> paramSet, cj paramcj)
  {
    by localby = a(this.ahn, parama, paramSet, paramcj);
    Boolean localBoolean = dh.n((d.a)localby.getObject());
    paramcj.d(dh.r(localBoolean));
    return new by(localBoolean, localby.lV());
  }
  
  by<Boolean> a(cq.e parame, Set<String> paramSet, cm paramcm)
  {
    Object localObject1 = parame.ms().iterator();
    Object localObject2;
    int j;
    for (boolean bool = true;; j = j)
    {
      by localby2;
      if (!((Iterator)localObject1).hasNext())
      {
        localObject2 = parame.mr().iterator();
        for (;;)
        {
          by localby1;
          if (!((Iterator)localObject2).hasNext())
          {
            paramcm.f(dh.r(Boolean.valueOf(true)));
            localby1 = new by(Boolean.valueOf(true), bool);
            break label269;
          }
          localObject1 = a((cq.a)((Iterator)localObject2).next(), paramSet, paramcm.lO());
          if (!((Boolean)((by)localObject1).getObject()).booleanValue()) {
            break;
          }
          int i;
          if ((localby1 == 0) || (!((by)localObject1).lV())) {
            i = 0;
          } else {
            i = 1;
          }
        }
        paramcm.f(dh.r(Boolean.valueOf(false)));
        localby2 = new by(Boolean.valueOf(false), ((by)localObject1).lV());
        break label269;
      }
      localObject2 = a((cq.a)((Iterator)localObject1).next(), paramSet, paramcm.lN());
      if (((Boolean)((by)localObject2).getObject()).booleanValue()) {
        break;
      }
      if ((localby2 == 0) || (!((by)localObject2).lV())) {
        j = 0;
      } else {
        j = 1;
      }
    }
    paramcm.f(dh.r(Boolean.valueOf(false)));
    by localby3 = new by(Boolean.valueOf(false), ((by)localObject2).lV());
    label269:
    return localby3;
  }
  
  by<Set<cq.a>> a(String paramString, Set<cq.e> paramSet, final Map<cq.e, List<cq.a>> paramMap1, final Map<cq.e, List<String>> paramMap2, final Map<cq.e, List<cq.a>> paramMap3, final Map<cq.e, List<String>> paramMap4, Set<String> paramSet1, cr paramcr)
  {
    a(paramSet, paramSet1, new a()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouse);
        List localList2 = (List)paramMap2.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouscm.lP().b(localList1, localList2);
        }
        localList1 = (List)paramMap3.get(paramAnonymouse);
        localList2 = (List)paramMap4.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet2.addAll(localList1);
          paramAnonymouscm.lQ().b(localList1, localList2);
        }
      }
    }, paramcr);
  }
  
  by<Set<cq.a>> a(Set<cq.e> paramSet, cr paramcr)
  {
    a(paramSet, new HashSet(), new a()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm)
      {
        paramAnonymousSet1.addAll(paramAnonymouse.mt());
        paramAnonymousSet2.addAll(paramAnonymouse.mu());
        paramAnonymouscm.lR().b(paramAnonymouse.mt(), paramAnonymouse.my());
        paramAnonymouscm.lS().b(paramAnonymouse.mu(), paramAnonymouse.mz());
      }
    }, paramcr);
  }
  
  void a(aj paramaj)
  {
    a(this.aho, paramaj);
  }
  
  void b(aj paramaj)
  {
    a(this.ahm, paramaj);
  }
  
  /**
   * @deprecated
   */
  public void bH(String paramString)
  {
    try
    {
      ck(paramString);
      af localaf = this.ahl.bT(paramString);
      t localt = localaf.lD();
      Iterator localIterator = ((Set)a(this.ahr, localt.lw()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        cq.a locala = (cq.a)localIterator.next();
        a(this.ahm, locala, new HashSet(), localt.lv());
      }
      localaf.lE();
    }
    finally {}
    ck(null);
  }
  
  void c(aj paramaj)
  {
    a(this.ahn, paramaj);
  }
  
  public by<d.a> cj(String paramString)
  {
    this.ahu = 0;
    af localaf = this.ahl.bS(paramString);
    by localby = a(paramString, new HashSet(), localaf.lC());
    localaf.lE();
    return localby;
  }
  
  /**
   * @deprecated
   */
  void ck(String paramString)
  {
    try
    {
      this.aht = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void h(List<c.i> paramList)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        c.i locali1 = (c.i)localIterator.next();
        if ((locali1.name == null) || (!locali1.name.startsWith("gaExperiment:"))) {
          bh.C("Ignored supplemental: " + locali1);
        } else {
          ai.a(this.aer, locali2);
        }
      }
      finally {}
    }
  }
  
  /**
   * @deprecated
   */
  String mC()
  {
    try
    {
      String str = this.aht;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static class b
  {
    private d.a agV;
    private by<d.a> ahA;
    
    public b(by<d.a> paramby, d.a parama)
    {
      this.ahA = paramby;
      this.agV = parama;
    }
    
    public int getSize()
    {
      int j = ((d.a)this.ahA.getObject()).nU();
      int i;
      if (this.agV != null) {
        i = this.agV.nU();
      } else {
        i = 0;
      }
      return i + j;
    }
    
    public by<d.a> mE()
    {
      return this.ahA;
    }
    
    public d.a mk()
    {
      return this.agV;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(cq.e parame, Set<cq.a> paramSet1, Set<cq.a> paramSet2, cm paramcm);
  }
  
  private static class c
  {
    private final Map<cq.e, List<cq.a>> ahB = new HashMap();
    private final Map<cq.e, List<cq.a>> ahC = new HashMap();
    private final Map<cq.e, List<String>> ahD = new HashMap();
    private final Map<cq.e, List<String>> ahE = new HashMap();
    private cq.a ahF;
    private final Set<cq.e> ahr = new HashSet();
    
    public void a(cq.e parame, cq.a parama)
    {
      Object localObject = (List)this.ahB.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.ahB.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void a(cq.e parame, String paramString)
    {
      Object localObject = (List)this.ahD.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.ahD.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void b(cq.e parame)
    {
      this.ahr.add(parame);
    }
    
    public void b(cq.e parame, cq.a parama)
    {
      Object localObject = (List)this.ahC.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.ahC.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void b(cq.e parame, String paramString)
    {
      Object localObject = (List)this.ahE.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.ahE.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void i(cq.a parama)
    {
      this.ahF = parama;
    }
    
    public Set<cq.e> mF()
    {
      return this.ahr;
    }
    
    public Map<cq.e, List<cq.a>> mG()
    {
      return this.ahB;
    }
    
    public Map<cq.e, List<String>> mH()
    {
      return this.ahD;
    }
    
    public Map<cq.e, List<String>> mI()
    {
      return this.ahE;
    }
    
    public Map<cq.e, List<cq.a>> mJ()
    {
      return this.ahC;
    }
    
    public cq.a mK()
    {
      return this.ahF;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cs
 * JD-Core Version:    0.7.0.1
 */