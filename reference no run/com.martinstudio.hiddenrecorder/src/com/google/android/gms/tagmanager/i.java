package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class i
  extends df
{
  private static final String ID = a.ap.toString();
  private static final String URL = b.eo.toString();
  private static final String aej = b.aX.toString();
  private static final String aek = b.en.toString();
  static final String ael = "gtm_" + ID + "_unrepeatable";
  private static final Set<String> aem = new HashSet();
  private final a aen;
  private final Context mContext;
  
  public i(Context paramContext)
  {
    this(paramContext, new a()
    {
      public aq ld()
      {
        return y.K(i.this);
      }
    });
  }
  
  i(Context paramContext, a parama)
  {
    super(str, arrayOfString);
    this.aen = parama;
    this.mContext = paramContext;
  }
  
  /**
   * @deprecated
   */
  private boolean bB(String paramString)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        boolean bool1 = bD(paramString);
        if (bool1) {
          return bool2;
        }
        if (bC(paramString)) {
          aem.add(paramString);
        } else {
          bool2 = false;
        }
      }
      finally {}
    }
  }
  
  boolean bC(String paramString)
  {
    return this.mContext.getSharedPreferences(ael, 0).contains(paramString);
  }
  
  boolean bD(String paramString)
  {
    return aem.contains(paramString);
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    String str;
    if (paramMap.get(aek) != null)
    {
      str = dh.j((d.a)paramMap.get(aek));
      if ((str == null) || (!bB(str))) {
        break label46;
      }
    }
    for (;;)
    {
      return;
      str = null;
      break;
      label46:
      Object localObject2 = Uri.parse(dh.j((d.a)paramMap.get(URL))).buildUpon();
      Object localObject3 = (d.a)paramMap.get(aej);
      if (localObject3 != null)
      {
        localObject3 = dh.o((d.a)localObject3);
        if (!(localObject3 instanceof List))
        {
          bh.A("ArbitraryPixel: additional params not a list: not sending partial hit: " + ((Uri.Builder)localObject2).build().toString());
          continue;
        }
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label270;
          }
          Object localObject4 = ((Iterator)localObject3).next();
          if (!(localObject4 instanceof Map))
          {
            bh.A("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + ((Uri.Builder)localObject2).build().toString());
            break;
          }
          Iterator localIterator = ((Map)localObject4).entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject4 = (Map.Entry)localIterator.next();
            ((Uri.Builder)localObject2).appendQueryParameter(((Map.Entry)localObject4).getKey().toString(), ((Map.Entry)localObject4).getValue().toString());
          }
        }
      }
      label270:
      localObject2 = ((Uri.Builder)localObject2).build().toString();
      this.aen.ld().bR((String)localObject2);
      bh.C("ArbitraryPixel: url = " + (String)localObject2);
      if (str == null) {
        continue;
      }
      try
      {
        aem.add(str);
        cy.a(this.mContext, ael, str, "true");
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract aq ld();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.i
 * JD-Core Version:    0.7.0.1
 */