package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class if
  extends hz
  implements SafeParcelable
{
  public static final ig CREATOR = new ig();
  private final ic Hg;
  private final Parcel Hn;
  private final int Ho;
  private int Hp;
  private int Hq;
  private final String mClassName;
  private final int xJ;
  
  if(int paramInt, Parcel paramParcel, ic paramic)
  {
    this.xJ = paramInt;
    this.Hn = ((Parcel)hn.f(paramParcel));
    this.Ho = 2;
    this.Hg = paramic;
    if (this.Hg != null) {
      this.mClassName = this.Hg.fR();
    } else {
      this.mClassName = null;
    }
    this.Hp = 2;
  }
  
  private if(SafeParcelable paramSafeParcelable, ic paramic, String paramString)
  {
    this.xJ = 1;
    this.Hn = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.Hn, 0);
    this.Ho = 1;
    this.Hg = ((ic)hn.f(paramic));
    this.mClassName = ((String)hn.f(paramString));
    this.Hp = 2;
  }
  
  public static <T extends hz,  extends SafeParcelable> if a(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    ic localic = b(paramT);
    return new if((SafeParcelable)paramT, localic, str);
  }
  
  private static void a(ic paramic, hz paramhz)
  {
    Object localObject = paramhz.getClass();
    if (!paramic.b((Class)localObject))
    {
      HashMap localHashMap = paramhz.fB();
      paramic.a((Class)localObject, paramhz.fB());
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (hz.a)localHashMap.get((String)localIterator.next());
        Class localClass = ((hz.a)localObject).fJ();
        if (localClass != null) {
          try
          {
            a(paramic, (hz)localClass.newInstance());
          }
          catch (InstantiationException localInstantiationException)
          {
            throw new IllegalStateException("Could not instantiate an object of type " + ((hz.a)localObject).fJ().getCanonicalName(), localInstantiationException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new IllegalStateException("Could not access object of type " + ((hz.a)localObject).fJ().getCanonicalName(), localIllegalAccessException);
          }
        }
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      break;
    case 7: 
      paramStringBuilder.append("\"").append(io.aK(paramObject.toString())).append("\"");
      break;
    case 8: 
      paramStringBuilder.append("\"").append(ii.d((byte[])paramObject)).append("\"");
      break;
    case 9: 
      paramStringBuilder.append("\"").append(ii.e((byte[])paramObject));
      paramStringBuilder.append("\"");
      break;
    case 10: 
      ip.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.fA())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.fA());
    case 0: 
      b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
      break;
    case 1: 
      b(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
      break;
    case 2: 
      b(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
      break;
    case 3: 
      b(paramStringBuilder, parama, a(parama, Float.valueOf(a.l(paramParcel, paramInt))));
      break;
    case 4: 
      b(paramStringBuilder, parama, a(parama, Double.valueOf(a.m(paramParcel, paramInt))));
      break;
    case 5: 
      b(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
      break;
    case 6: 
      b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      break;
    case 7: 
      b(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
      break;
    case 8: 
    case 9: 
      b(paramStringBuilder, parama, a(parama, a.r(paramParcel, paramInt)));
      break;
    case 10: 
      b(paramStringBuilder, parama, a(parama, d(a.q(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (!parama.fL()) {
      b(paramStringBuilder, parama, paramParcel, paramInt);
    } else {
      a(paramStringBuilder, parama, paramParcel, paramInt);
    }
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap<String, hz.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    HashMap localHashMap = b(paramHashMap);
    paramStringBuilder.append('{');
    int j = a.B(paramParcel);
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j)
        {
          paramStringBuilder.append('}');
          return;
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = a.A(paramParcel);
      Map.Entry localEntry = (Map.Entry)localHashMap.get(Integer.valueOf(a.ar(i)));
      if (localEntry != null)
      {
        if (k != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (hz.a)localEntry.getValue(), paramParcel, i);
        k = 1;
      }
    }
  }
  
  private static ic b(hz paramhz)
  {
    ic localic = new ic(paramhz.getClass());
    a(localic, paramhz);
    localic.fP();
    localic.fO();
    return localic;
  }
  
  private static HashMap<Integer, Map.Entry<String, hz.a<?, ?>>> b(HashMap<String, hz.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(Integer.valueOf(((hz.a)localEntry.getValue()).fI()), localEntry);
    }
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    Object localObject1;
    int j;
    if (!parama.fG())
    {
      switch (parama.fA())
      {
      default: 
        throw new IllegalStateException("Unknown field type out");
      case 0: 
        paramStringBuilder.append(a.g(paramParcel, paramInt));
        break;
      case 1: 
        paramStringBuilder.append(a.k(paramParcel, paramInt));
        break;
      case 2: 
        paramStringBuilder.append(a.i(paramParcel, paramInt));
        break;
      case 3: 
        paramStringBuilder.append(a.l(paramParcel, paramInt));
        break;
      case 4: 
        paramStringBuilder.append(a.m(paramParcel, paramInt));
        break;
      case 5: 
        paramStringBuilder.append(a.n(paramParcel, paramInt));
        break;
      case 6: 
        paramStringBuilder.append(a.c(paramParcel, paramInt));
        break;
      case 7: 
        localObject1 = a.o(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(io.aK((String)localObject1)).append("\"");
        break;
      case 8: 
        localObject1 = a.r(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(ii.d((byte[])localObject1)).append("\"");
        break;
      case 9: 
        localObject1 = a.r(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(ii.e((byte[])localObject1));
        paramStringBuilder.append("\"");
        break;
      case 10: 
        localObject1 = a.q(paramParcel, paramInt);
        Object localObject2 = ((Bundle)localObject1).keySet();
        ((Set)localObject2).size();
        paramStringBuilder.append("{");
        localObject2 = ((Set)localObject2).iterator();
        for (int k = 1;; k = 0)
        {
          if (!((Iterator)localObject2).hasNext())
          {
            paramStringBuilder.append("}");
            break;
          }
          String str = (String)((Iterator)localObject2).next();
          if (k == 0) {
            paramStringBuilder.append(",");
          }
          paramStringBuilder.append("\"").append(str).append("\"");
          paramStringBuilder.append(":");
          paramStringBuilder.append("\"").append(io.aK(((Bundle)localObject1).getString(str))).append("\"");
        }
      case 11: 
        localObject1 = a.C(paramParcel, paramInt);
        ((Parcel)localObject1).setDataPosition(0);
        a(paramStringBuilder, parama.fN(), (Parcel)localObject1);
        break;
      }
    }
    else
    {
      paramStringBuilder.append("[");
      switch (parama.fA())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        ih.a(paramStringBuilder, a.u(paramParcel, paramInt));
        break;
      case 1: 
        ih.a(paramStringBuilder, a.w(paramParcel, paramInt));
        break;
      case 2: 
        ih.a(paramStringBuilder, a.v(paramParcel, paramInt));
        break;
      case 3: 
        ih.a(paramStringBuilder, a.x(paramParcel, paramInt));
        break;
      case 4: 
        ih.a(paramStringBuilder, a.y(paramParcel, paramInt));
        break;
      case 5: 
        ih.a(paramStringBuilder, a.z(paramParcel, paramInt));
        break;
      case 6: 
        ih.a(paramStringBuilder, a.t(paramParcel, paramInt));
        break;
      case 7: 
        ih.a(paramStringBuilder, a.A(paramParcel, paramInt));
        break;
      case 8: 
      case 9: 
      case 10: 
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
      case 11: 
        localObject1 = a.D(paramParcel, paramInt);
        j = localObject1.length;
      }
    }
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        paramStringBuilder.append("]");
        return;
      }
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      localObject1[i].setDataPosition(0);
      a(paramStringBuilder, parama.fN(), localObject1[i]);
    }
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, Object paramObject)
  {
    if (!parama.fF()) {
      a(paramStringBuilder, parama.fz(), paramObject);
    } else {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
    }
  }
  
  private void b(StringBuilder paramStringBuilder, hz.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        paramStringBuilder.append("]");
        return;
      }
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.fz(), paramArrayList.get(i));
    }
  }
  
  public static HashMap<String, String> d(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
  }
  
  protected Object aF(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected boolean aG(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    HashMap localHashMap;
    if (this.Hg != null) {
      localHashMap = this.Hg.aJ(this.mClassName);
    } else {
      localHashMap = null;
    }
    return localHashMap;
  }
  
  public Parcel fT()
  {
    switch (this.Hp)
    {
    case 0: 
      this.Hq = b.C(this.Hn);
      b.G(this.Hn, this.Hq);
      this.Hp = 2;
      break;
    case 1: 
      b.G(this.Hn, this.Hq);
      this.Hp = 2;
    }
    return this.Hn;
  }
  
  ic fU()
  {
    ic localic;
    switch (this.Ho)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.Ho);
    case 0: 
      localic = null;
      break;
    case 1: 
      localic = this.Hg;
      break;
    case 2: 
      localic = this.Hg;
    }
    return localic;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public String toString()
  {
    hn.b(this.Hg, "Cannot convert to JSON on client side.");
    Parcel localParcel = fT();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.Hg.aJ(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ig.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.if
 * JD-Core Version:    0.7.0.1
 */