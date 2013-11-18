package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class o
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("name");
    if (str != null) {
      paramd.a(str, (String)paramHashMap.get("info"));
    } else {
      b.b("Error: App event with no name parameter.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.o
 * JD-Core Version:    0.7.0.1
 */