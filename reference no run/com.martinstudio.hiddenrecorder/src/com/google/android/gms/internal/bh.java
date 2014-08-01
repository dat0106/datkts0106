package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bh
  implements bd
{
  private final be nb;
  
  public bh(be parambe)
  {
    this.nb = parambe;
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int b(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str)) {
        break label47;
      }
      if ("l".equalsIgnoreCase(str)) {}
    }
    else
    {
      return -1;
    }
    int i = ep.bM();
    return i;
    label47:
    i = ep.bN();
    return i;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    Object localObject2 = (String)paramMap.get("a");
    if (localObject2 != null)
    {
      Object localObject1 = paramey.bW();
      if (!"expand".equalsIgnoreCase((String)localObject2))
      {
        if (!"webapp".equalsIgnoreCase((String)localObject2))
        {
          if (!"in_app_purchase".equalsIgnoreCase((String)localObject2))
          {
            ((ez)localObject1).a(new cf((String)paramMap.get("i"), (String)paramMap.get("u"), (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
          }
          else
          {
            localObject1 = (String)paramMap.get("product_id");
            localObject2 = (String)paramMap.get("report_urls");
            if (this.nb != null) {
              if ((localObject2 == null) || (((String)localObject2).isEmpty()))
              {
                this.nb.a((String)localObject1, new ArrayList());
              }
              else
              {
                localObject2 = ((String)localObject2).split(" ");
                this.nb.a((String)localObject1, new ArrayList(Arrays.asList((Object[])localObject2)));
              }
            }
          }
        }
        else
        {
          localObject2 = (String)paramMap.get("u");
          if (localObject2 == null) {
            ((ez)localObject1).a(a(paramMap), b(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
          } else {
            ((ez)localObject1).a(a(paramMap), b(paramMap), (String)localObject2);
          }
        }
      }
      else if (!paramey.bZ()) {
        ((ez)localObject1).a(a(paramMap), b(paramMap));
      } else {
        ev.D("Cannot expand WebView that is already expanded.");
      }
    }
    else
    {
      ev.D("Action missing from an open GMSG.");
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bh
 * JD-Core Version:    0.7.0.1
 */