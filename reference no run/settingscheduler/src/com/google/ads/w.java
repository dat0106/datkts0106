package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.c.d;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class w
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str1 = (String)paramHashMap.get("url");
    String str2 = (String)paramHashMap.get("type");
    Object localObject1 = (String)paramHashMap.get("afma_notify_dt");
    boolean bool1 = "1".equals(paramHashMap.get("drt_include"));
    Object localObject2 = (String)paramHashMap.get("request_scenario");
    boolean bool2 = "1".equals(paramHashMap.get("use_webview_loadurl"));
    if (!c.d.d.e.equals(localObject2))
    {
      if (!c.d.c.e.equals(localObject2))
      {
        if (!c.d.a.e.equals(localObject2)) {
          localObject2 = c.d.b;
        } else {
          localObject2 = c.d.a;
        }
      }
      else {
        localObject2 = c.d.c;
      }
    }
    else {
      localObject2 = c.d.d;
    }
    b.c("Received ad url: <url: \"" + str1 + "\" type: \"" + str2 + "\" afmaNotifyDt: \"" + (String)localObject1 + "\" useWebViewLoadUrl: \"" + bool2 + "\">");
    localObject1 = paramd.j();
    if (localObject1 != null)
    {
      ((c)localObject1).c(bool1);
      ((c)localObject1).a((c.d)localObject2);
      ((c)localObject1).d(bool2);
      ((c)localObject1).d(str1);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.w
 * JD-Core Version:    0.7.0.1
 */