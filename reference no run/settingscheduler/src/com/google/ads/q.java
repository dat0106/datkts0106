package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Locale;

public class q
  extends u
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("u");
    if (str != null)
    {
      g localg = paramd.m();
      if (localg != null)
      {
        Object localObject = Uri.parse(str);
        str = ((Uri)localObject).getHost();
        if ((str != null) && (str.toLowerCase(Locale.US).endsWith(".admob.com")))
        {
          str = null;
          localObject = ((Uri)localObject).getPath();
          if (localObject != null)
          {
            localObject = ((String)localObject).split("/");
            if (localObject.length >= 4) {
              str = localObject[2] + "/" + localObject[3];
            }
          }
          localg.a(str);
        }
      }
      super.a(paramd, paramHashMap, paramWebView);
    }
    else
    {
      b.e("Could not get URL from click gmsg.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.q
 * JD-Core Version:    0.7.0.1
 */