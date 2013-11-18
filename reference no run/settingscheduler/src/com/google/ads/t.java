package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

public class t
  implements n
{
  private static final a a = (a)a.a.b();
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("js");
    if (str != null)
    {
      if (!(paramWebView instanceof AdWebView))
      {
        b.b("Trying to evaluate JS in a WebView that isn't an AdWebView");
      }
      else
      {
        Object localObject = ((AdWebView)paramWebView).d();
        if (localObject != null)
        {
          localObject = ((AdActivity)localObject).getOpeningAdWebView();
          if (localObject != null) {
            a.a((WebView)localObject, str);
          } else {
            b.b("Could not get the opening WebView.");
          }
        }
        else
        {
          b.b("Could not get the AdActivity from the AdWebView.");
        }
      }
    }
    else {
      b.b("Could not get the JS to evaluate.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.t
 * JD-Core Version:    0.7.0.1
 */