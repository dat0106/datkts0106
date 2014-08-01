package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class cc
  extends aj
{
  private static final String afv = b.bi.toString();
  private static final String ags = b.bj.toString();
  
  public cc(String paramString)
  {
    super(paramString, arrayOfString);
  }
  
  protected abstract boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap);
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = (d.a)paramMap.get(afv);
        d.a locala2 = (d.a)paramMap.get(ags);
        boolean bool;
        if ((localObject != null) && (locala2 != null)) {
          bool = a((d.a)localObject, locala2, paramMap);
        } else {
          bool = false;
        }
        locala1 = dh.r(Boolean.valueOf(bool));
        break;
      }
    } while ((d.a)locala1.next() != dh.mY());
    d.a locala1 = dh.r(Boolean.valueOf(false));
    return locala1;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cc
 * JD-Core Version:    0.7.0.1
 */