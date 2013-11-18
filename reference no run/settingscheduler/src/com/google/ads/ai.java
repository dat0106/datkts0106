package com.google.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.i.b;
import com.google.ads.util.i.d;
import java.util.HashMap;

public class ai
  implements n
{
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    Object localObject1 = (Context)paramd.h().f.a();
    Object localObject2 = (String)paramHashMap.get("a");
    if (localObject2 != null)
    {
      if (((String)localObject2).equals("resize")) {
        break label313;
      }
      if (((String)localObject2).equals("state")) {}
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
      if (ah.a((Intent)localObject2, (Context)localObject1))
      {
        AdActivity.launchAdActivity(paramd, new e("plusone", paramHashMap));
        return;
      }
      if (!ah.a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.plus")), (Context)localObject1)) {
        return;
      }
      if ((TextUtils.isEmpty((CharSequence)paramHashMap.get("d"))) || (TextUtils.isEmpty((CharSequence)paramHashMap.get("o"))) || (TextUtils.isEmpty((CharSequence)paramHashMap.get("c"))))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("u", "market://details?id=com.google.android.apps.plus");
        AdActivity.launchAdActivity(paramd, new e("intent", (HashMap)localObject1));
        return;
      }
      localObject1 = new AlertDialog.Builder((Context)localObject1);
      ((AlertDialog.Builder)localObject1).setMessage((CharSequence)paramHashMap.get("d")).setPositiveButton((CharSequence)paramHashMap.get("o"), new c(paramd)).setNegativeButton((CharSequence)paramHashMap.get("c"), new a());
      ((AlertDialog.Builder)localObject1).create().show();
      return;
    }
    ag.a((Activity)paramd.h().e.a(), paramWebView, (String)paramHashMap.get("u"));
    return;
    label313:
    ag.a(paramWebView, (String)paramHashMap.get("u"));
  }
  
  private static class a
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
  
  private static class c
    implements DialogInterface.OnClickListener
  {
    private d a;
    
    public c(d paramd)
    {
      this.a = paramd;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("u", "market://details?id=com.google.android.apps.plus");
      AdActivity.launchAdActivity(this.a, new e("intent", localHashMap));
    }
  }
  
  public static enum b
  {
    public String c;
    
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      d = arrayOfb;
    }
    
    private b(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.ai
 * JD-Core Version:    0.7.0.1
 */