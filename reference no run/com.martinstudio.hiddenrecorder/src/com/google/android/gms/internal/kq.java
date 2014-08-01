package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class kq
  extends hz
  implements SafeParcelable, Moment
{
  public static final kr CREATOR = new kr();
  private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
  private final Set<Integer> acp;
  private String adc;
  private ko adk;
  private ko adl;
  private String qU;
  private String xD;
  private final int xJ;
  
  static
  {
    aco.put("id", hz.a.j("id", 2));
    aco.put("result", hz.a.a("result", 4, ko.class));
    aco.put("startDate", hz.a.j("startDate", 5));
    aco.put("target", hz.a.a("target", 6, ko.class));
    aco.put("type", hz.a.j("type", 7));
  }
  
  public kq()
  {
    this.xJ = 1;
    this.acp = new HashSet();
  }
  
  kq(Set<Integer> paramSet, int paramInt, String paramString1, ko paramko1, String paramString2, ko paramko2, String paramString3)
  {
    this.acp = paramSet;
    this.xJ = paramInt;
    this.xD = paramString1;
    this.adk = paramko1;
    this.adc = paramString2;
    this.adl = paramko2;
    this.qU = paramString3;
  }
  
  public kq(Set<Integer> paramSet, String paramString1, ko paramko1, String paramString2, ko paramko2, String paramString3)
  {
    this.acp = paramSet;
    this.xJ = 1;
    this.xD = paramString1;
    this.adk = paramko1;
    this.adc = paramString2;
    this.adl = paramko2;
    this.qU = paramString3;
  }
  
  protected boolean a(hz.a parama)
  {
    return this.acp.contains(Integer.valueOf(parama.fI()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hz.a parama)
  {
    Object localObject;
    switch (parama.fI())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
    case 2: 
      localObject = this.xD;
      break;
    case 4: 
      localObject = this.adk;
      break;
    case 5: 
      localObject = this.adc;
      break;
    case 6: 
      localObject = this.adl;
      break;
    case 7: 
      localObject = this.qU;
    }
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof kq))
    {
      if (this != paramObject)
      {
        kq localkq = (kq)paramObject;
        Iterator localIterator = aco.values().iterator();
        do
        {
          hz.a locala;
          do
          {
            if (!localIterator.hasNext())
            {
              int i = 1;
              return ???;
            }
            locala = (hz.a)localIterator.next();
            if (a(locala)) {
              break;
            }
          } while (!localkq.a(locala));
          bool = false;
          break;
          if (!localkq.a(bool))
          {
            bool = false;
            break;
          }
        } while (b(bool).equals(localkq.b(bool)));
        bool = false;
      }
      else
      {
        bool = true;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    return aco;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public ItemScope getResult()
  {
    return this.adk;
  }
  
  public String getStartDate()
  {
    return this.adc;
  }
  
  public ItemScope getTarget()
  {
    return this.adl;
  }
  
  public String getType()
  {
    return this.qU;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasId()
  {
    return this.acp.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.acp.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.acp.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.acp.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.acp.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aco.values().iterator();
    hz.a locala2;
    for (hz.a locala3 = 0;; locala3 = locala2)
    {
      if (!localIterator.hasNext()) {
        return locala3;
      }
      hz.a locala1 = (hz.a)localIterator.next();
      if (!a(locala1)) {
        locala1 = locala3;
      } else {
        locala2 = locala3 + locala1.fI() + b(locala1).hashCode();
      }
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  Set<Integer> kf()
  {
    return this.acp;
  }
  
  ko kw()
  {
    return this.adk;
  }
  
  ko kx()
  {
    return this.adl;
  }
  
  public kq ky()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kr.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kq
 * JD-Core Version:    0.7.0.1
 */