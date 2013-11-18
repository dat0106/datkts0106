package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.l;
import com.google.ads.l.a;
import com.google.ads.m;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.AdUtil.a;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

public class c
  implements Runnable
{
  boolean a;
  private String b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  private f g;
  private d h;
  private AdRequest i;
  private WebView j;
  private String k;
  private LinkedList<String> l;
  private String m;
  private AdSize n;
  private volatile boolean o;
  private boolean p;
  private AdRequest.ErrorCode q;
  private boolean r;
  private int s;
  private Thread t;
  private boolean u;
  private d v = d.b;
  
  protected c() {}
  
  public c(d paramd)
  {
    this.h = paramd;
    this.k = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.l = new LinkedList();
    this.q = null;
    this.r = false;
    this.s = -1;
    this.f = false;
    this.p = false;
    this.m = null;
    this.n = null;
    if ((Activity)paramd.h().e.a() == null)
    {
      this.j = null;
      this.g = null;
      com.google.ads.util.b.e("activity was null while trying to create an AdLoader.");
    }
    else
    {
      this.j = new AdWebView(paramd.h(), null);
      this.j.setWebViewClient(i.a(paramd, a.b, false, false));
      this.j.setVisibility(8);
      this.j.setWillNotDraw(true);
      this.g = new f(this, paramd);
    }
  }
  
  static void a(String paramString, com.google.ads.c paramc, com.google.ads.d paramd)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      if ((!paramString.contains("no-store")) && (!paramString.contains("no-cache")))
      {
        Matcher localMatcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(paramString);
        if (localMatcher.find()) {
          try
          {
            int i1 = Integer.parseInt(localMatcher.group(1));
            paramd.a(paramc, i1);
            Locale localLocale = Locale.US;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(i1);
            com.google.ads.util.b.c(String.format(localLocale, "Caching gWhirl configuration for: %d seconds", arrayOfObject));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            com.google.ads.util.b.b("Caught exception trying to parse cache control directive. Overflow?", localNumberFormatException);
          }
        } else {
          com.google.ads.util.b.c("Unrecognized cacheControlDirective: '" + paramString + "'. Not caching configuration.");
        }
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.h.a(new c(this.j, paramString2, paramString1));
  }
  
  private String d()
  {
    String str;
    if (!(this.i instanceof SearchAdRequest)) {
      str = "AFMA_buildAdURL";
    } else {
      str = "AFMA_buildAdURL";
    }
    return str;
  }
  
  private String e()
  {
    String str;
    if (!(this.i instanceof SearchAdRequest)) {
      str = "AFMA_getSdkConstants();";
    } else {
      str = "AFMA_getSdkConstants();";
    }
    return str;
  }
  
  private String f()
  {
    String str;
    if (!(this.i instanceof SearchAdRequest)) {
      str = "http://media.admob.com/";
    } else {
      str = "http://www.gstatic.com/safa/";
    }
    return str;
  }
  
  private String g()
  {
    String str;
    if (!(this.i instanceof SearchAdRequest)) {
      str = "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    } else {
      str = "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
    }
    return str;
  }
  
  private String h()
  {
    String str;
    if (!(this.i instanceof SearchAdRequest)) {
      str = "</script></head><body></body></html>";
    } else {
      str = "</script></head><body></body></html>";
    }
    return str;
  }
  
  private void i()
  {
    AdWebView localAdWebView = this.h.k();
    this.h.l().c(true);
    this.h.m().h();
    this.h.a(new c(localAdWebView, this.b, this.c));
  }
  
  private void j()
  {
    this.h.a(new e(this.h, this.j, this.l, this.s, this.p, this.m, this.n));
  }
  
  public String a(Map<String, Object> paramMap, Activity paramActivity)
    throws c.b
  {
    int i1 = 0;
    Context localContext = paramActivity.getApplicationContext();
    Object localObject2 = this.h.m();
    long l1 = ((g)localObject2).m();
    if (l1 > 0L) {
      paramMap.put("prl", Long.valueOf(l1));
    }
    l1 = ((g)localObject2).n();
    if (l1 > 0L) {
      paramMap.put("prnl", Long.valueOf(l1));
    }
    String str1 = ((g)localObject2).l();
    if (str1 != null) {
      paramMap.put("ppcl", str1);
    }
    str1 = ((g)localObject2).k();
    if (str1 != null) {
      paramMap.put("pcl", str1);
    }
    long l2 = ((g)localObject2).j();
    if (l2 > 0L) {
      paramMap.put("pcc", Long.valueOf(l2));
    }
    paramMap.put("preqs", Long.valueOf(((g)localObject2).o()));
    paramMap.put("oar", Long.valueOf(((g)localObject2).p()));
    paramMap.put("bas_on", Long.valueOf(((g)localObject2).s()));
    paramMap.put("bas_off", Long.valueOf(((g)localObject2).v()));
    if (((g)localObject2).y()) {
      paramMap.put("aoi_timeout", "true");
    }
    if (((g)localObject2).A()) {
      paramMap.put("aoi_nofill", "true");
    }
    String str2 = ((g)localObject2).D();
    if (str2 != null) {
      paramMap.put("pit", str2);
    }
    paramMap.put("ptime", Long.valueOf(g.E()));
    ((g)localObject2).a();
    ((g)localObject2).i();
    if (this.h.h().b())
    {
      paramMap.put("format", "interstitial_mb");
      paramMap.put("slotname", this.h.h().d.a());
      paramMap.put("js", "afma-sdk-a-v6.2.1");
      localObject2 = localContext.getPackageName();
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = localContext.getPackageManager().getPackageInfo((String)localObject2, 0);
        int i3 = ((PackageInfo)localObject2).versionCode;
        localObject2 = AdUtil.f(localContext);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMap.put("mv", localObject2);
        }
        paramMap.put("msid", localContext.getPackageName());
        paramMap.put("app_name", i3 + ".android." + localContext.getPackageName());
        paramMap.put("isu", AdUtil.a(localContext));
        localObject2 = AdUtil.d(localContext);
        if (localObject2 == null) {
          localObject2 = "null";
        }
        paramMap.put("net", localObject2);
        localObject2 = AdUtil.e(localContext);
        if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
          paramMap.put("cap", localObject2);
        }
        paramMap.put("u_audio", Integer.valueOf(AdUtil.g(localContext).ordinal()));
        localObject2 = AdUtil.a(paramActivity);
        paramMap.put("u_sd", Float.valueOf(((DisplayMetrics)localObject2).density));
        paramMap.put("u_h", Integer.valueOf(AdUtil.a(localContext, (DisplayMetrics)localObject2)));
        paramMap.put("u_w", Integer.valueOf(AdUtil.b(localContext, (DisplayMetrics)localObject2)));
        paramMap.put("hl", Locale.getDefault().getLanguage());
        if ((this.h.h().i != null) && (this.h.h().i.a() != null))
        {
          localObject2 = (AdView)this.h.h().i.a();
          if (((AdView)localObject2).getParent() != null)
          {
            int[] arrayOfInt = new int[2];
            ((AdView)localObject2).getLocationOnScreen(arrayOfInt);
            i3 = arrayOfInt[0];
            int i4 = arrayOfInt[1];
            DisplayMetrics localDisplayMetrics = ((Context)this.h.h().f.a()).getResources().getDisplayMetrics();
            int i5 = localDisplayMetrics.widthPixels;
            int i7 = localDisplayMetrics.heightPixels;
            if ((!((AdView)localObject2).isShown()) || (i3 + ((AdView)localObject2).getWidth() <= 0) || (i4 + ((AdView)localObject2).getHeight() <= 0) || (i3 > i5) || (i4 > i7)) {
              break label1506;
            }
            i5 = 1;
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("x", Integer.valueOf(i3));
            localHashMap2.put("y", Integer.valueOf(i4));
            localHashMap2.put("width", Integer.valueOf(((AdView)localObject2).getWidth()));
            localHashMap2.put("height", Integer.valueOf(((AdView)localObject2).getHeight()));
            localHashMap2.put("visible", Integer.valueOf(i5));
            paramMap.put("ad_pos", localHashMap2);
          }
        }
        localObject3 = new StringBuilder();
        AdSize[] arrayOfAdSize = (AdSize[])this.h.h().l.a();
        if (arrayOfAdSize == null) {
          break label1229;
        }
        int i2 = arrayOfAdSize.length;
        if (i1 < i2)
        {
          AdSize localAdSize = arrayOfAdSize[i1];
          if (((StringBuilder)localObject3).length() != 0) {
            ((StringBuilder)localObject3).append("|");
          }
          ((StringBuilder)localObject3).append(localAdSize.getWidth() + "x" + localAdSize.getHeight());
          i1++;
          continue;
          localObject3 = ((h)this.h.h().k.a()).b();
          if (((AdSize)localObject3).isFullWidth()) {
            paramMap.put("smart_w", "full");
          }
          if (((AdSize)localObject3).isAutoHeight()) {
            paramMap.put("smart_h", "auto");
          }
          if (!((AdSize)localObject3).isCustomAdSize())
          {
            paramMap.put("format", ((AdSize)localObject3).toString());
            break;
          }
          HashMap localHashMap1 = new HashMap();
          localHashMap1.put("w", Integer.valueOf(((AdSize)localObject3).getWidth()));
          localHashMap1.put("h", Integer.valueOf(((AdSize)localObject3).getHeight()));
          paramMap.put("ad_frame", localHashMap1);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        throw new b("NameNotFoundException");
      }
      paramMap.put("sz", ((StringBuilder)localObject3).toString());
      label1229:
      Object localObject1 = (TelephonyManager)localContext.getSystemService("phone");
      paramMap.put("carrier", ((TelephonyManager)localObject1).getNetworkOperator());
      paramMap.put("gnt", Integer.valueOf(((TelephonyManager)localObject1).getNetworkType()));
      if (AdUtil.c()) {
        paramMap.put("simulator", Integer.valueOf(1));
      }
      paramMap.put("session_id", com.google.ads.b.a().b().toString());
      paramMap.put("seq_num", com.google.ads.b.a().c().toString());
      localObject1 = AdUtil.a(paramMap);
      if (((Boolean)((l.a)((l)this.h.h().a.a()).a.a()).l.a()).booleanValue()) {}
      for (localObject1 = g() + d() + "(" + (String)localObject1 + ");" + h();; localObject1 = g() + e() + d() + "(" + (String)localObject1 + ");" + h())
      {
        com.google.ads.util.b.c("adRequestUrlHtml: " + (String)localObject1);
        return localObject1;
      }
      label1506:
      int i6 = 0;
    }
  }
  
  protected void a()
  {
    com.google.ads.util.b.a("AdLoader cancelled.");
    if (this.j != null)
    {
      this.j.stopLoading();
      this.j.destroy();
    }
    if (this.t != null)
    {
      this.t.interrupt();
      this.t = null;
    }
    if (this.g != null) {
      this.g.a();
    }
    this.o = true;
  }
  
  /**
   * @deprecated
   */
  public void a(int paramInt)
  {
    try
    {
      this.s = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void a(AdRequest.ErrorCode paramErrorCode)
  {
    try
    {
      this.q = paramErrorCode;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(AdRequest.ErrorCode paramErrorCode, boolean paramBoolean)
  {
    this.h.a(new a(this.h, this.j, this.g, paramErrorCode, paramBoolean));
  }
  
  protected void a(AdRequest paramAdRequest)
  {
    this.i = paramAdRequest;
    this.o = false;
    this.t = new Thread(this);
    this.t.start();
  }
  
  /**
   * @deprecated
   */
  public void a(AdSize paramAdSize)
  {
    try
    {
      this.n = paramAdSize;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void a(d paramd)
  {
    try
    {
      this.v = paramd;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  protected void a(String paramString)
  {
    try
    {
      this.l.add(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  protected void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = paramString2;
      this.c = paramString1;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  protected void a(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b()
  {
    try
    {
      if (TextUtils.isEmpty(this.e))
      {
        com.google.ads.util.b.b("Got a mediation response with no content type. Aborting mediation.");
        a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
      }
      else if (!this.e.startsWith("application/json"))
      {
        com.google.ads.util.b.b("Got a mediation response with a content type: '" + this.e + "'. Expected something starting with 'application/json'. Aborting mediation.");
        a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
      }
    }
    catch (JSONException localJSONException)
    {
      com.google.ads.util.b.b("AdLoader can't parse gWhirl server configuration.", localJSONException);
      a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
    }
    final com.google.ads.c localc = com.google.ads.c.a(this.c);
    a(this.d, localc, this.h.i());
    this.h.a(new Runnable()
    {
      public void run()
      {
        if (c.a(c.this) != null)
        {
          c.a(c.this).stopLoading();
          c.a(c.this).destroy();
        }
        c.c(c.this).a(c.b(c.this));
        if (c.d(c.this) != null) {
          ((h)c.c(c.this).h().k.a()).b(c.d(c.this));
        }
        c.c(c.this).a(localc);
      }
    });
  }
  
  /**
   * @deprecated
   */
  protected void b(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void b(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  protected void c()
  {
    try
    {
      this.r = true;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  protected void c(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void c(boolean paramBoolean)
  {
    try
    {
      this.u = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void d(String paramString)
  {
    try
    {
      this.k = paramString;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void d(boolean paramBoolean)
  {
    try
    {
      this.a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void e(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/google/ads/internal/c:j	Landroid/webkit/WebView;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 114	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   13: ifnonnull +20 -> 33
    //   16: ldc_w 754
    //   19: invokestatic 121	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   26: iconst_0
    //   27: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   37: invokevirtual 98	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   40: getfield 103	com/google/ads/m:e	Lcom/google/ads/util/i$d;
    //   43: invokevirtual 108	com/google/ads/util/i$d:a	()Ljava/lang/Object;
    //   46: checkcast 110	android/app/Activity
    //   49: astore 6
    //   51: aload 6
    //   53: ifnonnull +27 -> 80
    //   56: ldc_w 756
    //   59: invokestatic 121	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   66: iconst_0
    //   67: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   70: aload_0
    //   71: monitorexit
    //   72: goto -40 -> 32
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: aload_0
    //   81: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   84: invokevirtual 757	com/google/ads/internal/d:o	()J
    //   87: lstore_1
    //   88: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   91: lstore_3
    //   92: aload_0
    //   93: getfield 252	com/google/ads/internal/c:i	Lcom/google/ads/AdRequest;
    //   96: aload_0
    //   97: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   100: invokevirtual 98	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   103: getfield 503	com/google/ads/m:f	Lcom/google/ads/util/i$b;
    //   106: invokevirtual 382	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   109: checkcast 388	android/content/Context
    //   112: invokevirtual 768	com/google/ads/AdRequest:getRequestMap	(Landroid/content/Context;)Ljava/util/Map;
    //   115: astore 5
    //   117: aload 5
    //   119: ldc_w 770
    //   122: invokeinterface 774 2 0
    //   127: astore 7
    //   129: aload 7
    //   131: instanceof 307
    //   134: ifeq +142 -> 276
    //   137: aload 7
    //   139: checkcast 307	java/util/Map
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 776
    //   149: invokeinterface 774 2 0
    //   154: astore 8
    //   156: aload 8
    //   158: instanceof 163
    //   161: ifeq +12 -> 173
    //   164: aload_0
    //   165: aload 8
    //   167: checkcast 163	java/lang/String
    //   170: putfield 70	com/google/ads/internal/c:b	Ljava/lang/String;
    //   173: aload 7
    //   175: ldc_w 778
    //   178: invokeinterface 774 2 0
    //   183: astore 8
    //   185: aload 8
    //   187: instanceof 163
    //   190: ifeq +12 -> 202
    //   193: aload_0
    //   194: aload 8
    //   196: checkcast 163	java/lang/String
    //   199: putfield 68	com/google/ads/internal/c:k	Ljava/lang/String;
    //   202: aload 7
    //   204: ldc_w 780
    //   207: invokeinterface 774 2 0
    //   212: astore 8
    //   214: aload 8
    //   216: instanceof 163
    //   219: ifeq +19 -> 238
    //   222: aload 8
    //   224: ldc_w 781
    //   227: invokevirtual 784	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +128 -> 358
    //   233: aload_0
    //   234: iconst_1
    //   235: putfield 85	com/google/ads/internal/c:s	I
    //   238: aload 7
    //   240: ldc_w 786
    //   243: invokeinterface 774 2 0
    //   248: astore 7
    //   250: aload 7
    //   252: instanceof 163
    //   255: ifeq +21 -> 276
    //   258: aload 7
    //   260: ldc_w 787
    //   263: invokevirtual 784	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +10 -> 276
    //   269: aload_0
    //   270: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   273: invokevirtual 789	com/google/ads/internal/d:d	()V
    //   276: aload_0
    //   277: getfield 70	com/google/ads/internal/c:b	Ljava/lang/String;
    //   280: ifnonnull +603 -> 883
    //   283: aload_0
    //   284: getfield 68	com/google/ads/internal/c:k	Ljava/lang/String;
    //   287: astore 7
    //   289: aload 7
    //   291: ifnonnull +243 -> 534
    //   294: aload_0
    //   295: aload 5
    //   297: aload 6
    //   299: invokevirtual 791	com/google/ads/internal/c:a	(Ljava/util/Map;Landroid/app/Activity;)Ljava/lang/String;
    //   302: astore 5
    //   304: aload_0
    //   305: aload 5
    //   307: aload_0
    //   308: invokespecial 793	com/google/ads/internal/c:f	()Ljava/lang/String;
    //   311: invokespecial 795	com/google/ads/internal/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   317: lstore 5
    //   319: lload_1
    //   320: lload 5
    //   322: lload_3
    //   323: lsub
    //   324: lsub
    //   325: lstore 5
    //   327: lload 5
    //   329: ldc2_w 297
    //   332: lcmp
    //   333: ifle +9 -> 342
    //   336: aload_0
    //   337: lload 5
    //   339: invokevirtual 799	java/lang/Object:wait	(J)V
    //   342: aload_0
    //   343: getfield 683	com/google/ads/internal/c:o	Z
    //   346: istore 5
    //   348: iload 5
    //   350: ifeq +114 -> 464
    //   353: aload_0
    //   354: monitorexit
    //   355: goto -323 -> 32
    //   358: aload 8
    //   360: ldc_w 800
    //   363: invokevirtual 784	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   366: ifeq -128 -> 238
    //   369: aload_0
    //   370: iconst_0
    //   371: putfield 85	com/google/ads/internal/c:s	I
    //   374: goto -136 -> 238
    //   377: astore_1
    //   378: ldc_w 802
    //   381: aload_1
    //   382: invokestatic 225	com/google/ads/util/b:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   385: aload_0
    //   386: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   389: iconst_1
    //   390: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   393: aload_0
    //   394: monitorexit
    //   395: goto -363 -> 32
    //   398: astore_1
    //   399: new 227	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 804
    //   409: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   422: aload_0
    //   423: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   426: iconst_0
    //   427: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   430: aload_0
    //   431: monitorexit
    //   432: goto -400 -> 32
    //   435: astore_1
    //   436: new 227	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 809
    //   446: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_1
    //   450: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 667	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   459: aload_0
    //   460: monitorexit
    //   461: goto -429 -> 32
    //   464: aload_0
    //   465: getfield 81	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   468: ifnull +17 -> 485
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 81	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   476: iconst_0
    //   477: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   480: aload_0
    //   481: monitorexit
    //   482: goto -450 -> 32
    //   485: aload_0
    //   486: getfield 68	com/google/ads/internal/c:k	Ljava/lang/String;
    //   489: ifnonnull +45 -> 534
    //   492: new 227	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 811
    //   502: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: lload_1
    //   506: invokevirtual 814	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: ldc_w 816
    //   512: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   521: aload_0
    //   522: getstatic 819	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   525: iconst_0
    //   526: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   529: aload_0
    //   530: monitorexit
    //   531: goto -499 -> 32
    //   534: aload_0
    //   535: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   538: invokevirtual 279	com/google/ads/internal/d:m	()Lcom/google/ads/internal/g;
    //   541: astore 5
    //   543: getstatic 822	com/google/ads/internal/c$2:a	[I
    //   546: aload_0
    //   547: getfield 63	com/google/ads/internal/c:v	Lcom/google/ads/internal/c$d;
    //   550: invokevirtual 823	com/google/ads/internal/c$d:ordinal	()I
    //   553: iaload
    //   554: tableswitch	default:+30 -> 584, 1:+109->663, 2:+133->687, 3:+147->701, 4:+166->720
    //   585: getfield 747	com/google/ads/internal/c:a	Z
    //   588: ifne +261 -> 849
    //   591: ldc_w 825
    //   594: invokestatic 667	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   597: aload_0
    //   598: getfield 114	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   601: aload_0
    //   602: getfield 745	com/google/ads/internal/c:u	Z
    //   605: invokevirtual 827	com/google/ads/internal/f:a	(Z)V
    //   608: aload_0
    //   609: getfield 114	com/google/ads/internal/c:g	Lcom/google/ads/internal/f;
    //   612: aload_0
    //   613: getfield 68	com/google/ads/internal/c:k	Ljava/lang/String;
    //   616: invokevirtual 828	com/google/ads/internal/f:a	(Ljava/lang/String;)V
    //   619: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   622: lstore 5
    //   624: lload_1
    //   625: lload 5
    //   627: lload_3
    //   628: lsub
    //   629: lsub
    //   630: lstore 5
    //   632: lload 5
    //   634: ldc2_w 297
    //   637: lcmp
    //   638: ifle +9 -> 647
    //   641: aload_0
    //   642: lload 5
    //   644: invokevirtual 799	java/lang/Object:wait	(J)V
    //   647: aload_0
    //   648: getfield 683	com/google/ads/internal/c:o	Z
    //   651: istore 5
    //   653: iload 5
    //   655: ifeq +124 -> 779
    //   658: aload_0
    //   659: monitorexit
    //   660: goto -628 -> 32
    //   663: aload 5
    //   665: invokevirtual 830	com/google/ads/internal/g:r	()V
    //   668: aload 5
    //   670: invokevirtual 832	com/google/ads/internal/g:u	()V
    //   673: aload 5
    //   675: invokevirtual 834	com/google/ads/internal/g:x	()V
    //   678: ldc_w 836
    //   681: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   684: goto -100 -> 584
    //   687: aload 5
    //   689: invokevirtual 838	com/google/ads/internal/g:t	()V
    //   692: ldc_w 840
    //   695: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   698: goto -114 -> 584
    //   701: aload 5
    //   703: invokevirtual 842	com/google/ads/internal/g:w	()V
    //   706: aload 5
    //   708: invokevirtual 844	com/google/ads/internal/g:q	()V
    //   711: ldc_w 846
    //   714: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   717: goto -133 -> 584
    //   720: aload 5
    //   722: invokevirtual 844	com/google/ads/internal/g:q	()V
    //   725: ldc_w 848
    //   728: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   731: ldc_w 850
    //   734: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   737: aload_0
    //   738: getstatic 819	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   741: iconst_0
    //   742: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   745: aload_0
    //   746: monitorexit
    //   747: goto -715 -> 32
    //   750: astore_1
    //   751: new 227	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 852
    //   761: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_1
    //   765: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   768: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 667	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   774: aload_0
    //   775: monitorexit
    //   776: goto -744 -> 32
    //   779: aload_0
    //   780: getfield 81	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   783: ifnull +17 -> 800
    //   786: aload_0
    //   787: aload_0
    //   788: getfield 81	com/google/ads/internal/c:q	Lcom/google/ads/AdRequest$ErrorCode;
    //   791: iconst_0
    //   792: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   795: aload_0
    //   796: monitorexit
    //   797: goto -765 -> 32
    //   800: aload_0
    //   801: getfield 72	com/google/ads/internal/c:c	Ljava/lang/String;
    //   804: ifnonnull +79 -> 883
    //   807: new 227	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 811
    //   817: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: lload_1
    //   821: invokevirtual 814	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   824: ldc_w 854
    //   827: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   836: aload_0
    //   837: getstatic 819	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   840: iconst_0
    //   841: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   844: aload_0
    //   845: monitorexit
    //   846: goto -814 -> 32
    //   849: aload_0
    //   850: aload_0
    //   851: getfield 68	com/google/ads/internal/c:k	Ljava/lang/String;
    //   854: putfield 70	com/google/ads/internal/c:b	Ljava/lang/String;
    //   857: new 227	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 856
    //   867: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload_0
    //   871: getfield 70	com/google/ads/internal/c:b	Ljava/lang/String;
    //   874: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 667	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   883: aload_0
    //   884: getfield 747	com/google/ads/internal/c:a	Z
    //   887: ifne +235 -> 1122
    //   890: aload_0
    //   891: getfield 87	com/google/ads/internal/c:f	Z
    //   894: ifeq +20 -> 914
    //   897: aload_0
    //   898: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   901: iconst_1
    //   902: invokevirtual 858	com/google/ads/internal/d:b	(Z)V
    //   905: aload_0
    //   906: invokevirtual 860	com/google/ads/internal/c:b	()V
    //   909: aload_0
    //   910: monitorexit
    //   911: goto -879 -> 32
    //   914: aload_0
    //   915: getfield 707	com/google/ads/internal/c:e	Ljava/lang/String;
    //   918: ifnull +74 -> 992
    //   921: aload_0
    //   922: getfield 707	com/google/ads/internal/c:e	Ljava/lang/String;
    //   925: ldc_w 720
    //   928: invokevirtual 724	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   931: ifne +16 -> 947
    //   934: aload_0
    //   935: getfield 707	com/google/ads/internal/c:e	Ljava/lang/String;
    //   938: ldc_w 862
    //   941: invokevirtual 724	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   944: ifeq +48 -> 992
    //   947: new 227	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   954: ldc_w 864
    //   957: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload_0
    //   961: getfield 707	com/google/ads/internal/c:e	Ljava/lang/String;
    //   964: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 866
    //   970: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 711	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   979: aload_0
    //   980: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   983: iconst_0
    //   984: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   987: aload_0
    //   988: monitorexit
    //   989: goto -957 -> 32
    //   992: aload_0
    //   993: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   996: invokevirtual 98	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   999: getfield 545	com/google/ads/m:l	Lcom/google/ads/util/i$c;
    //   1002: invokevirtual 548	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   1005: ifnull +99 -> 1104
    //   1008: aload_0
    //   1009: getfield 93	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1012: ifnonnull +22 -> 1034
    //   1015: ldc_w 868
    //   1018: invokestatic 711	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   1021: aload_0
    //   1022: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1025: iconst_0
    //   1026: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1029: aload_0
    //   1030: monitorexit
    //   1031: goto -999 -> 32
    //   1034: aload_0
    //   1035: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   1038: invokevirtual 98	com/google/ads/internal/d:h	()Lcom/google/ads/m;
    //   1041: getfield 545	com/google/ads/m:l	Lcom/google/ads/util/i$c;
    //   1044: invokevirtual 548	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   1047: checkcast 870	[Ljava/lang/Object;
    //   1050: invokestatic 876	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1053: aload_0
    //   1054: getfield 93	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1057: invokeinterface 880 2 0
    //   1062: ifne +60 -> 1122
    //   1065: new 227	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1072: ldc_w 882
    //   1075: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload_0
    //   1079: getfield 93	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1082: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokestatic 711	com/google/ads/util/b:b	(Ljava/lang/String;)V
    //   1091: aload_0
    //   1092: getstatic 716	com/google/ads/AdRequest$ErrorCode:INTERNAL_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1095: iconst_0
    //   1096: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1099: aload_0
    //   1100: monitorexit
    //   1101: goto -1069 -> 32
    //   1104: aload_0
    //   1105: getfield 93	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1108: ifnull +14 -> 1122
    //   1111: ldc_w 884
    //   1114: invokestatic 121	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   1117: aload_0
    //   1118: aconst_null
    //   1119: putfield 93	com/google/ads/internal/c:n	Lcom/google/ads/AdSize;
    //   1122: aload_0
    //   1123: getfield 66	com/google/ads/internal/c:h	Lcom/google/ads/internal/d;
    //   1126: iconst_0
    //   1127: invokevirtual 858	com/google/ads/internal/d:b	(Z)V
    //   1130: aload_0
    //   1131: invokespecial 885	com/google/ads/internal/c:i	()V
    //   1134: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   1137: lstore 5
    //   1139: lload_1
    //   1140: lload 5
    //   1142: lload_3
    //   1143: lsub
    //   1144: lsub
    //   1145: lstore_3
    //   1146: lload_3
    //   1147: ldc2_w 297
    //   1150: lcmp
    //   1151: ifle +8 -> 1159
    //   1154: aload_0
    //   1155: lload_3
    //   1156: invokevirtual 799	java/lang/Object:wait	(J)V
    //   1159: aload_0
    //   1160: getfield 83	com/google/ads/internal/c:r	Z
    //   1163: ifeq +39 -> 1202
    //   1166: aload_0
    //   1167: invokespecial 887	com/google/ads/internal/c:j	()V
    //   1170: goto -777 -> 393
    //   1173: astore_1
    //   1174: new 227	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1181: ldc_w 889
    //   1184: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: aload_1
    //   1188: invokevirtual 807	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 667	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   1197: aload_0
    //   1198: monitorexit
    //   1199: goto -1167 -> 32
    //   1202: new 227	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 811
    //   1212: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: lload_1
    //   1216: invokevirtual 814	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1219: ldc_w 891
    //   1222: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 220	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   1231: aload_0
    //   1232: getstatic 819	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   1235: iconst_1
    //   1236: invokevirtual 718	com/google/ads/internal/c:a	(Lcom/google/ads/AdRequest$ErrorCode;Z)V
    //   1239: goto -846 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1242	0	this	c
    //   75	4	1	localObject1	Object
    //   87	233	1	l1	long
    //   377	5	1	localThrowable	java.lang.Throwable
    //   398	15	1	localb	b
    //   435	190	1	localInterruptedException1	java.lang.InterruptedException
    //   750	390	1	localInterruptedException2	java.lang.InterruptedException
    //   1173	43	1	localInterruptedException3	java.lang.InterruptedException
    //   91	1065	3	l2	long
    //   115	191	5	localObject2	Object
    //   317	21	5	l3	long
    //   346	3	5	bool1	boolean
    //   541	1	5	localg	g
    //   622	21	5	l4	long
    //   651	70	5	bool2	boolean
    //   1137	4	5	l5	long
    //   49	249	6	localActivity	Activity
    //   127	163	7	localObject3	Object
    //   154	205	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	75	finally
    //   30	32	75	finally
    //   33	70	75	finally
    //   70	78	75	finally
    //   80	289	75	finally
    //   294	304	75	finally
    //   304	319	75	finally
    //   336	342	75	finally
    //   342	348	75	finally
    //   353	355	75	finally
    //   358	374	75	finally
    //   378	395	75	finally
    //   399	430	75	finally
    //   430	432	75	finally
    //   436	459	75	finally
    //   459	461	75	finally
    //   464	480	75	finally
    //   480	482	75	finally
    //   485	529	75	finally
    //   529	531	75	finally
    //   534	624	75	finally
    //   641	647	75	finally
    //   647	653	75	finally
    //   658	660	75	finally
    //   663	745	75	finally
    //   745	747	75	finally
    //   751	774	75	finally
    //   774	776	75	finally
    //   779	795	75	finally
    //   795	797	75	finally
    //   800	844	75	finally
    //   844	846	75	finally
    //   849	909	75	finally
    //   909	911	75	finally
    //   914	987	75	finally
    //   987	989	75	finally
    //   992	1029	75	finally
    //   1029	1031	75	finally
    //   1034	1099	75	finally
    //   1099	1101	75	finally
    //   1104	1139	75	finally
    //   1154	1159	75	finally
    //   1159	1197	75	finally
    //   1197	1199	75	finally
    //   1202	1239	75	finally
    //   2	30	377	java/lang/Throwable
    //   33	70	377	java/lang/Throwable
    //   80	289	377	java/lang/Throwable
    //   294	304	377	java/lang/Throwable
    //   304	319	377	java/lang/Throwable
    //   336	342	377	java/lang/Throwable
    //   342	348	377	java/lang/Throwable
    //   358	374	377	java/lang/Throwable
    //   399	430	377	java/lang/Throwable
    //   436	459	377	java/lang/Throwable
    //   464	480	377	java/lang/Throwable
    //   485	529	377	java/lang/Throwable
    //   534	624	377	java/lang/Throwable
    //   641	647	377	java/lang/Throwable
    //   647	653	377	java/lang/Throwable
    //   663	745	377	java/lang/Throwable
    //   751	774	377	java/lang/Throwable
    //   779	795	377	java/lang/Throwable
    //   800	844	377	java/lang/Throwable
    //   849	909	377	java/lang/Throwable
    //   914	987	377	java/lang/Throwable
    //   992	1029	377	java/lang/Throwable
    //   1034	1099	377	java/lang/Throwable
    //   1104	1139	377	java/lang/Throwable
    //   1154	1159	377	java/lang/Throwable
    //   1159	1197	377	java/lang/Throwable
    //   1202	1239	377	java/lang/Throwable
    //   294	304	398	com/google/ads/internal/c$b
    //   336	342	435	java/lang/InterruptedException
    //   641	647	750	java/lang/InterruptedException
    //   1154	1159	1173	java/lang/InterruptedException
  }
  
  public static enum d
  {
    public String e;
    
    static
    {
      d[] arrayOfd = new d[4];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
      f = arrayOfd;
    }
    
    private d(String paramString)
    {
      this.e = paramString;
    }
  }
  
  private static class e
    implements Runnable
  {
    private final d a;
    private final WebView b;
    private final LinkedList<String> c;
    private final int d;
    private final boolean e;
    private final String f;
    private final AdSize g;
    
    public e(d paramd, WebView paramWebView, LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean, String paramString, AdSize paramAdSize)
    {
      this.a = paramd;
      this.b = paramWebView;
      this.c = paramLinkedList;
      this.d = paramInt;
      this.e = paramBoolean;
      this.f = paramString;
      this.g = paramAdSize;
    }
    
    public void run()
    {
      if (this.b != null)
      {
        this.b.stopLoading();
        this.b.destroy();
      }
      this.a.a(this.c);
      this.a.a(this.d);
      this.a.a(this.e);
      this.a.a(this.f);
      if (this.g != null)
      {
        ((h)this.a.h().k.a()).b(this.g);
        this.a.k().setAdSize(this.g);
      }
      this.a.C();
    }
  }
  
  private class c
    implements Runnable
  {
    private final String b;
    private final String c;
    private final WebView d;
    
    public c(WebView paramWebView, String paramString1, String paramString2)
    {
      this.d = paramWebView;
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public void run()
    {
      if (this.c == null) {
        this.d.loadUrl(this.b);
      } else {
        this.d.loadDataWithBaseURL(this.b, this.c, "text/html", "utf-8", null);
      }
    }
  }
  
  private static class a
    implements Runnable
  {
    private final d a;
    private final WebView b;
    private final f c;
    private final AdRequest.ErrorCode d;
    private final boolean e;
    
    public a(d paramd, WebView paramWebView, f paramf, AdRequest.ErrorCode paramErrorCode, boolean paramBoolean)
    {
      this.a = paramd;
      this.b = paramWebView;
      this.c = paramf;
      this.d = paramErrorCode;
      this.e = paramBoolean;
    }
    
    public void run()
    {
      if (this.b != null)
      {
        this.b.stopLoading();
        this.b.destroy();
      }
      if (this.c != null) {
        this.c.a();
      }
      if (this.e)
      {
        AdWebView localAdWebView = this.a.k();
        localAdWebView.stopLoading();
        localAdWebView.setVisibility(8);
      }
      this.a.a(this.d);
    }
  }
  
  private class b
    extends Exception
  {
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.internal.c
 * JD-Core Version:    0.7.0.1
 */