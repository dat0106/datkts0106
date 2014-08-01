package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class d
  implements DataLayer.b
{
  private final Context kM;
  
  public d(Context paramContext)
  {
    this.kM = paramContext;
  }
  
  public void x(Map<String, Object> paramMap)
  {
    Object localObject1 = paramMap.get("gtm.url");
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = paramMap.get("gtm");
      if ((localObject2 != null) && ((localObject2 instanceof Map))) {}
    }
    else
    {
      localObject1 = localObject1;
      break label50;
    }
    localObject1 = ((Map)localObject2).get("url");
    label50:
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localObject1 = Uri.parse((String)localObject1).getQueryParameter("referrer");
      if (localObject1 != null) {
        ay.f(this.kM, (String)localObject1);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.d
 * JD-Core Version:    0.7.0.1
 */