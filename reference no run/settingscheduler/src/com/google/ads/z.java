package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.b;
import java.util.HashMap;

public class z
  implements n
{
  private AdActivity.StaticMethodWrapper a;
  
  public z()
  {
    this(new AdActivity.StaticMethodWrapper());
  }
  
  public z(AdActivity.StaticMethodWrapper paramStaticMethodWrapper)
  {
    this.a = paramStaticMethodWrapper;
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("a");
    if (str != null)
    {
      if (!str.equals("webapp"))
      {
        if (!str.equals("expand")) {
          this.a.launchAdActivity(paramd, new e("intent", paramHashMap));
        } else {
          this.a.launchAdActivity(paramd, new e("expand", paramHashMap));
        }
      }
      else {
        this.a.launchAdActivity(paramd, new e("webapp", paramHashMap));
      }
    }
    else {
      b.a("Could not get the action parameter for open GMSG.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.z
 * JD-Core Version:    0.7.0.1
 */