package com.google.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;
import java.util.Map;

public class p
  implements n
{
  private static final a a = (a)a.a.b();
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    Object localObject1 = (String)paramHashMap.get("urls");
    if (localObject1 != null)
    {
      String[] arrayOfString = ((String)localObject1).split(",");
      localObject1 = new HashMap();
      PackageManager localPackageManager = paramWebView.getContext().getPackageManager();
      int j = arrayOfString.length;
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          a.a(paramWebView, (Map)localObject1);
          break;
        }
        String str1 = arrayOfString[i];
        Object localObject2 = str1.split(";", 2);
        String str2 = localObject2[0];
        if (localObject2.length < 2) {
          localObject2 = "android.intent.action.VIEW";
        } else {
          localObject2 = localObject2[1];
        }
        boolean bool;
        if (localPackageManager.resolveActivity(new Intent((String)localObject2, Uri.parse(str2)), 65536) == null) {
          bool = false;
        } else {
          bool = true;
        }
        ((HashMap)localObject1).put(str1, Boolean.valueOf(bool));
      }
    }
    b.e("Could not get the urls param from canOpenURLs gmsg.");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.p
 * JD-Core Version:    0.7.0.1
 */