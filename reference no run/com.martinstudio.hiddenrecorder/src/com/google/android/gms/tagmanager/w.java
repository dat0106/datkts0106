package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class w
  extends df
{
  private static final String ID = a.af.toString();
  private static final String VALUE = b.ew.toString();
  private static final String afq = b.bD.toString();
  private final DataLayer aer;
  
  public w(DataLayer paramDataLayer)
  {
    super(str, arrayOfString);
    this.aer = paramDataLayer;
  }
  
  private void a(d.a parama)
  {
    if ((parama != null) && (parama != dh.mS()))
    {
      String str = dh.j(parama);
      if (str != dh.mX()) {
        this.aer.bN(str);
      }
    }
  }
  
  private void b(d.a parama)
  {
    Object localObject1;
    if ((parama != null) && (parama != dh.mS()))
    {
      localObject1 = dh.o(parama);
      if ((localObject1 instanceof List)) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof Map))
      {
        localObject2 = (Map)localObject2;
        this.aer.push((Map)localObject2);
      }
    }
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    b((d.a)paramMap.get(VALUE));
    a((d.a)paramMap.get(afq));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.w
 * JD-Core Version:    0.7.0.1
 */