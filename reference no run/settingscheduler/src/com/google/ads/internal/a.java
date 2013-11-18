package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.aa;
import com.google.ads.ab;
import com.google.ads.ai;
import com.google.ads.n;
import com.google.ads.o;
import com.google.ads.p;
import com.google.ads.q;
import com.google.ads.r;
import com.google.ads.s;
import com.google.ads.t;
import com.google.ads.u;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.v;
import com.google.ads.w;
import com.google.ads.x;
import com.google.ads.y;
import com.google.ads.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
{
  public static final f<a> a = new f()
  {
    public a a()
    {
      return a.a();
    }
  };
  public static final Map<String, n> b = Collections.unmodifiableMap(new HashMap() {});
  public static final Map<String, n> c = Collections.unmodifiableMap(new HashMap() {});
  private static final a d = new a();
  
  public String a(Uri paramUri, HashMap<String, String> paramHashMap)
  {
    String str1 = null;
    if (!c(paramUri))
    {
      if (!b(paramUri)) {
        b.e("Message was neither a GMSG nor an AMSG.");
      } else {
        str1 = paramUri.getPath();
      }
    }
    else
    {
      String str2 = paramUri.getHost();
      if (str2 != null)
      {
        if (!str2.equals("launch"))
        {
          if (!str2.equals("closecanvas"))
          {
            if (!str2.equals("log")) {
              b.e("An error occurred while parsing the AMSG: " + paramUri.toString());
            } else {
              str1 = "/log";
            }
          }
          else {
            str1 = "/close";
          }
        }
        else
        {
          paramHashMap.put("a", "intent");
          paramHashMap.put("u", paramHashMap.get("url"));
          paramHashMap.remove("url");
          str1 = "/open";
        }
      }
      else {
        b.e("An error occurred while parsing the AMSG parameters.");
      }
    }
    return str1;
  }
  
  public void a(WebView paramWebView)
  {
    a(paramWebView, "onshow", "{'version': 'afma-sdk-a-v6.2.1'}");
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    b.a("Sending JS to a WebView: " + paramString);
    paramWebView.loadUrl("javascript:" + paramString);
  }
  
  public void a(WebView paramWebView, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      a(paramWebView, "AFMA_ReceiveMessage" + "('" + paramString1 + "');");
    } else {
      a(paramWebView, "AFMA_ReceiveMessage" + "('" + paramString1 + "', " + paramString2 + ");");
    }
  }
  
  public void a(WebView paramWebView, Map<String, Boolean> paramMap)
  {
    a(paramWebView, "openableURLs", new JSONObject(paramMap).toString());
  }
  
  public void a(d paramd, Map<String, n> paramMap, Uri paramUri, WebView paramWebView)
  {
    HashMap localHashMap = AdUtil.b(paramUri);
    if (localHashMap != null)
    {
      String str = a(paramUri, localHashMap);
      if (str != null)
      {
        n localn = (n)paramMap.get(str);
        if (localn != null) {
          localn.a(paramd, localHashMap, paramWebView);
        } else {
          b.e("No AdResponse found, <message: " + str + ">");
        }
      }
      else
      {
        b.e("An error occurred while parsing the message.");
      }
    }
    else
    {
      b.e("An error occurred while parsing the message parameters.");
    }
  }
  
  public boolean a(Uri paramUri)
  {
    boolean bool = false;
    if ((paramUri != null) && (paramUri.isHierarchical()) && ((b(paramUri)) || (c(paramUri)))) {
      bool = true;
    }
    return bool;
  }
  
  public void b(WebView paramWebView)
  {
    a(paramWebView, "onhide", null);
  }
  
  public boolean b(Uri paramUri)
  {
    boolean bool = false;
    String str = paramUri.getScheme();
    if ((str != null) && (str.equals("gmsg")))
    {
      str = paramUri.getAuthority();
      if ((str != null) && (str.equals("mobileads.google.com"))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public boolean c(Uri paramUri)
  {
    String str = paramUri.getScheme();
    boolean bool;
    if ((str != null) && (str.equals("admob"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.internal.a
 * JD-Core Version:    0.7.0.1
 */