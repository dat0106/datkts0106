package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class v
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    Object localObject = (String)paramHashMap.get("type");
    String str = (String)paramHashMap.get("errors");
    b.e("Invalid " + (String)localObject + " request error: " + str);
    localObject = paramd.j();
    if (localObject != null) {
      ((c)localObject).a(AdRequest.ErrorCode.INVALID_REQUEST);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.v
 * JD-Core Version:    0.7.0.1
 */