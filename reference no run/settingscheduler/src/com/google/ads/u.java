package com.google.ads;

import android.content.Context;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class u
  implements n
{
  protected Runnable a(String paramString, WebView paramWebView)
  {
    return new ac(paramString, paramWebView.getContext().getApplicationContext());
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("u");
    if (str != null) {
      new Thread(a(str, paramWebView)).start();
    } else {
      b.e("Could not get URL from click gmsg.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.u
 * JD-Core Version:    0.7.0.1
 */