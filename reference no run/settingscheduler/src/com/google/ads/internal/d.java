package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.Ad;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.InterstitialAd;
import com.google.ads.ac;
import com.google.ads.ae;
import com.google.ads.ag;
import com.google.ads.f;
import com.google.ads.l;
import com.google.ads.l.a;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class d
{
  private static final Object a = new Object();
  private final m b;
  private c c;
  private AdRequest d;
  private g e;
  private AdWebView f;
  private i g;
  private Handler h;
  private long i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private SharedPreferences o;
  private long p;
  private ae q;
  private boolean r;
  private LinkedList<String> s;
  private LinkedList<String> t;
  private int u = -1;
  private Boolean v;
  private com.google.ads.d w;
  private com.google.ads.e x;
  private f y;
  private String z = null;
  
  public d(Ad paramAd, Activity paramActivity, AdSize paramAdSize, String paramString, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.e = new g();
    this.c = null;
    this.d = null;
    this.k = false;
    this.h = new Handler();
    this.p = 60000L;
    this.l = false;
    this.n = false;
    this.m = true;
    Object localObject4;
    Object localObject5;
    if (paramActivity == null)
    {
      localObject4 = l.a();
      AdView localAdView;
      if ((paramAd instanceof AdView))
      {
        localAdView = (AdView)paramAd;
        if (!(paramAd instanceof InterstitialAd)) {
          break label157;
        }
        localObject5 = (InterstitialAd)paramAd;
        label115:
        if (paramAdSize != null) {
          break label163;
        }
      }
      label157:
      label163:
      for (??? = h.a;; ??? = h.a(paramAdSize))
      {
        this.b = new m((l)localObject4, paramAd, localAdView, (InterstitialAd)localObject5, paramString, null, null, paramViewGroup, (h)???);
        return;
        localAdView = null;
        break;
        localObject5 = null;
        break label115;
      }
    }
    for (;;)
    {
      synchronized (a)
      {
        this.o = paramActivity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
        if (paramBoolean)
        {
          long l1 = this.o.getLong("Timeout" + paramString, -1L);
          InterstitialAd localInterstitialAd;
          if (l1 < 0L)
          {
            this.i = 5000L;
            ??? = l.a();
            if (!(paramAd instanceof AdView)) {
              break label442;
            }
            localObject5 = (AdView)paramAd;
            if (!(paramAd instanceof InterstitialAd)) {
              break label448;
            }
            localInterstitialAd = (InterstitialAd)paramAd;
            Context localContext = paramActivity.getApplicationContext();
            if (paramAdSize != null) {
              break label454;
            }
            localObject4 = h.a;
            this.b = new m((l)???, paramAd, (AdView)localObject5, localInterstitialAd, paramString, paramActivity, localContext, paramViewGroup, (h)localObject4);
            this.q = new ae(this);
            this.s = new LinkedList();
            this.t = new LinkedList();
            a();
            AdUtil.h((Context)this.b.f.a());
            this.w = new com.google.ads.d();
            this.x = new com.google.ads.e(this);
            this.v = null;
            this.y = null;
            break;
          }
          this.i = localInterstitialAd;
        }
      }
      this.i = 60000L;
      continue;
      label442:
      localObject5 = null;
      continue;
      label448:
      Object localObject3 = null;
      continue;
      label454:
      localObject4 = h.a(paramAdSize, paramActivity.getApplicationContext());
    }
  }
  
  private void a(f paramf, Boolean paramBoolean)
  {
    Object localObject = paramf.d();
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
    }
    String str = paramf.b();
    a((List)localObject, paramf.a(), str, paramf.c(), paramBoolean, this.e.d(), this.e.e());
  }
  
  private void a(List<String> paramList, String paramString)
  {
    Object localObject;
    if (paramList != null)
    {
      localObject = paramList;
    }
    else
    {
      localObject = new ArrayList();
      ((List)localObject).add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
    }
    a((List)localObject, null, null, paramString, null, this.e.d(), this.e.e());
  }
  
  private void a(List<String> paramList, String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, String paramString5)
  {
    String str1 = AdUtil.a((Context)this.b.f.a());
    Object localObject = com.google.ads.b.a();
    String str2 = ((com.google.ads.b)localObject).b().toString();
    String str3 = ((com.google.ads.b)localObject).c().toString();
    localObject = paramList.iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        this.e.b();
        return;
      }
      new Thread(new ac(com.google.ads.g.a((String)((Iterator)localObject).next(), (String)this.b.d.a(), paramBoolean, str1, paramString1, paramString2, paramString3, str2, str3, paramString4, paramString5), (Context)this.b.f.a())).start();
    }
  }
  
  private void b(f paramf, Boolean paramBoolean)
  {
    Object localObject = paramf.e();
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
    }
    String str = paramf.b();
    a((List)localObject, paramf.a(), str, paramf.c(), paramBoolean, null, null);
  }
  
  /**
   * @deprecated
   */
  public void A()
  {
    try
    {
      if (this.c != null)
      {
        this.c.a();
        this.c = null;
      }
      if (this.f != null) {
        this.f.stopLoading();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  protected void B()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/google/ads/internal/d:b	Lcom/google/ads/m;
    //   6: getfield 308	com/google/ads/m:e	Lcom/google/ads/util/i$d;
    //   9: invokevirtual 311	com/google/ads/util/i$d:a	()Ljava/lang/Object;
    //   12: checkcast 116	android/app/Activity
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: ldc_w 313
    //   23: invokestatic 318	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 171	com/google/ads/internal/d:t	Ljava/util/LinkedList;
    //   33: invokevirtual 319	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   36: astore_2
    //   37: aload_2
    //   38: invokeinterface 262 1 0
    //   43: ifeq -17 -> 26
    //   46: new 266	java/lang/Thread
    //   49: dup
    //   50: new 268	com/google/ads/ac
    //   53: dup
    //   54: aload_2
    //   55: invokeinterface 271 1 0
    //   60: checkcast 273	java/lang/String
    //   63: aload_1
    //   64: invokevirtual 120	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   67: invokespecial 283	com/google/ads/ac:<init>	(Ljava/lang/String;Landroid/content/Context;)V
    //   70: invokespecial 286	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   73: invokevirtual 289	java/lang/Thread:start	()V
    //   76: goto -39 -> 37
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   15	49	1	localActivity	Activity
    //   79	4	1	localObject	Object
    //   36	19	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	26	79	finally
    //   29	76	79	finally
  }
  
  /**
   * @deprecated
   */
  protected void C()
  {
    try
    {
      this.c = null;
      this.k = true;
      this.f.setVisibility(0);
      if (this.b.a()) {
        a(this.f);
      }
      this.e.g();
      if (this.b.a()) {
        x();
      }
      com.google.ads.util.b.c("onReceiveAd()");
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onReceiveAd((Ad)this.b.h.a());
      }
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
  public void a()
  {
    try
    {
      this.f = new AdWebView(this.b, ((h)this.b.k.a()).b());
      this.f.setVisibility(8);
      this.g = i.a(this, a.c, true, this.b.b());
      this.f.setWebViewClient(this.g);
      l.a locala = (l.a)((l)this.b.a.a()).a.a();
      if ((AdUtil.a < ((Integer)locala.a.a()).intValue()) && (!((h)this.b.k.a()).a()))
      {
        com.google.ads.util.b.a("Disabling hardware acceleration for a banner.");
        this.f.b();
      }
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
  public void a(float paramFloat)
  {
    try
    {
      long l1 = this.p;
      this.p = ((1000.0F * paramFloat));
      if ((s()) && (this.p != l1))
      {
        e();
        f();
      }
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
  public void a(int paramInt)
  {
    try
    {
      this.u = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (a)
    {
      SharedPreferences.Editor localEditor = this.o.edit();
      localEditor.putLong("Timeout" + this.b.d, paramLong);
      localEditor.commit();
      if (this.r) {
        this.i = paramLong;
      }
      return;
    }
  }
  
  public void a(View paramView)
  {
    ((ViewGroup)this.b.g.a()).removeAllViews();
    ((ViewGroup)this.b.g.a()).addView(paramView);
  }
  
  /**
   * @deprecated
   */
  public void a(View paramView, com.google.ads.h paramh, f paramf, boolean paramBoolean)
  {
    try
    {
      com.google.ads.util.b.a("AdManager.onReceiveGWhirlAd() called.");
      this.k = true;
      this.y = paramf;
      if (this.b.a())
      {
        a(paramView);
        a(paramf, Boolean.valueOf(paramBoolean));
      }
      this.x.d(paramh);
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onReceiveAd((Ad)this.b.h.a());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void a(AdRequest.ErrorCode paramErrorCode)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 71	com/google/ads/internal/d:c	Lcom/google/ads/internal/c;
    //   7: aload_1
    //   8: getstatic 456	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   11: if_acmpne +21 -> 32
    //   14: aload_0
    //   15: ldc_w 457
    //   18: invokevirtual 459	com/google/ads/internal/d:a	(F)V
    //   21: aload_0
    //   22: invokevirtual 404	com/google/ads/internal/d:s	()Z
    //   25: ifne +7 -> 32
    //   28: aload_0
    //   29: invokevirtual 460	com/google/ads/internal/d:g	()V
    //   32: aload_0
    //   33: getfield 111	com/google/ads/internal/d:b	Lcom/google/ads/m;
    //   36: invokevirtual 368	com/google/ads/m:b	()Z
    //   39: ifeq +17 -> 56
    //   42: aload_1
    //   43: getstatic 463	com/google/ads/AdRequest$ErrorCode:NO_FILL	Lcom/google/ads/AdRequest$ErrorCode;
    //   46: if_acmpne +80 -> 126
    //   49: aload_0
    //   50: getfield 69	com/google/ads/internal/d:e	Lcom/google/ads/internal/g;
    //   53: invokevirtual 465	com/google/ads/internal/g:B	()V
    //   56: new 132	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 467
    //   66: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: ldc_w 469
    //   76: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 337	com/google/ads/util/b:c	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 111	com/google/ads/internal/d:b	Lcom/google/ads/m;
    //   89: getfield 340	com/google/ads/m:m	Lcom/google/ads/util/i$c;
    //   92: invokevirtual 343	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   95: checkcast 345	com/google/ads/AdListener
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +23 -> 123
    //   103: aload_2
    //   104: aload_0
    //   105: getfield 111	com/google/ads/internal/d:b	Lcom/google/ads/m;
    //   108: getfield 347	com/google/ads/m:h	Lcom/google/ads/util/i$b;
    //   111: invokevirtual 181	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   114: checkcast 349	com/google/ads/Ad
    //   117: aload_1
    //   118: invokeinterface 473 3 0
    //   123: aload_0
    //   124: monitorexit
    //   125: return
    //   126: aload_1
    //   127: getstatic 456	com/google/ads/AdRequest$ErrorCode:NETWORK_ERROR	Lcom/google/ads/AdRequest$ErrorCode;
    //   130: if_acmpne -74 -> 56
    //   133: aload_0
    //   134: getfield 69	com/google/ads/internal/d:e	Lcom/google/ads/internal/g;
    //   137: invokevirtual 475	com/google/ads/internal/g:z	()V
    //   140: goto -84 -> 56
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	d
    //   0	148	1	paramErrorCode	AdRequest.ErrorCode
    //   98	6	2	localAdListener	AdListener
    //   143	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	123	143	finally
    //   126	140	143	finally
  }
  
  /**
   * @deprecated
   */
  public void a(AdRequest paramAdRequest)
  {
    for (;;)
    {
      try
      {
        if (p())
        {
          com.google.ads.util.b.e("loadAd called while the ad is already loading, so aborting.");
          return;
        }
        if (AdActivity.isShowing())
        {
          com.google.ads.util.b.e("loadAd called while an interstitial or landing page is displayed, so aborting");
          continue;
        }
        if (!AdUtil.c((Context)this.b.f.a())) {
          continue;
        }
      }
      finally {}
      if (AdUtil.b((Context)this.b.f.a()))
      {
        long l1 = this.o.getLong("GoogleAdMobDoritosLife", 60000L);
        if (ag.a((Context)this.b.f.a(), l1)) {
          ag.a((Activity)this.b.e.a());
        }
        this.k = false;
        this.s.clear();
        this.d = paramAdRequest;
        if (this.w.a())
        {
          this.x.a(this.w.b(), paramAdRequest);
        }
        else
        {
          this.c = new c(this);
          this.c.a(paramAdRequest);
        }
      }
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void a(com.google.ads.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 71	com/google/ads/internal/d:c	Lcom/google/ads/internal/c;
    //   7: aload_1
    //   8: invokevirtual 520	com/google/ads/c:d	()Z
    //   11: ifeq +38 -> 49
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 522	com/google/ads/c:e	()I
    //   19: i2f
    //   20: invokevirtual 459	com/google/ads/internal/d:a	(F)V
    //   23: aload_0
    //   24: getfield 86	com/google/ads/internal/d:l	Z
    //   27: ifne +7 -> 34
    //   30: aload_0
    //   31: invokevirtual 408	com/google/ads/internal/d:f	()V
    //   34: aload_0
    //   35: getfield 196	com/google/ads/internal/d:x	Lcom/google/ads/e;
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 73	com/google/ads/internal/d:d	Lcom/google/ads/AdRequest;
    //   43: invokevirtual 512	com/google/ads/e:a	(Lcom/google/ads/c;Lcom/google/ads/AdRequest;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 86	com/google/ads/internal/d:l	Z
    //   53: ifeq -19 -> 34
    //   56: aload_0
    //   57: invokevirtual 406	com/google/ads/internal/d:e	()V
    //   60: goto -26 -> 34
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	d
    //   0	68	1	paramc	com.google.ads.c
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	63	finally
    //   49	60	63	finally
  }
  
  /**
   * @deprecated
   */
  public void a(f paramf, boolean paramBoolean)
  {
    try
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      com.google.ads.util.b.a(String.format(localLocale, "AdManager.onGWhirlAdClicked(%b) called.", arrayOfObject));
      b(paramf, Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.h.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    Object localObject = new Uri.Builder().encodedQuery(paramString).build();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = AdUtil.b((Uri)localObject);
    Iterator localIterator = ((Map)localObject).keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.z = localStringBuilder.toString().trim();
        if (TextUtils.isEmpty(this.z)) {
          this.z = null;
        }
        return;
      }
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(" = ").append((String)((Map)localObject).get(str)).append("\n");
    }
  }
  
  /**
   * @deprecated
   */
  public void a(String paramString1, String paramString2)
  {
    try
    {
      AppEventListener localAppEventListener = (AppEventListener)this.b.n.a();
      if (localAppEventListener != null) {
        localAppEventListener.onAppEvent((Ad)this.b.h.a(), paramString1, paramString2);
      }
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
  protected void a(LinkedList<String> paramLinkedList)
  {
    try
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        com.google.ads.util.b.a("Adding a click tracking URL: " + str);
      }
      this.t = paramLinkedList;
    }
    finally {}
  }
  
  /**
   * @deprecated
   */
  public void a(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
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
  public void b()
  {
    try
    {
      if (this.x != null) {
        this.x.b();
      }
      this.b.m.a(null);
      this.b.n.a(null);
      A();
      if (this.f != null) {
        this.f.destroy();
      }
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
  public void b(long paramLong)
  {
    if (paramLong > 0L) {}
    try
    {
      this.o.edit().putLong("GoogleAdMobDoritosLife", paramLong).commit();
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
  public void b(com.google.ads.c paramc)
  {
    try
    {
      com.google.ads.util.b.a("AdManager.onGWhirlNoFill() called.");
      a(paramc.i(), paramc.c());
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onFailedToReceiveAd((Ad)this.b.h.a(), AdRequest.ErrorCode.NO_FILL);
      }
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
  protected void b(String paramString)
  {
    try
    {
      com.google.ads.util.b.a("Adding a tracking URL: " + paramString);
      this.s.add(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = Boolean.valueOf(paramBoolean);
  }
  
  public String c()
  {
    return this.z;
  }
  
  /**
   * @deprecated
   */
  public void d()
  {
    try
    {
      this.m = false;
      com.google.ads.util.b.a("Refreshing is no longer allowed on this AdView.");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/google/ads/internal/d:l	Z
    //   6: ifeq +28 -> 34
    //   9: ldc_w 619
    //   12: invokestatic 399	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 80	com/google/ads/internal/d:h	Landroid/os/Handler;
    //   19: aload_0
    //   20: getfield 164	com/google/ads/internal/d:q	Lcom/google/ads/ae;
    //   23: invokevirtual 622	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 86	com/google/ads/internal/d:l	Z
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: ldc_w 624
    //   37: invokestatic 399	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   40: goto -9 -> 31
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	d
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	43	finally
    //   34	40	43	finally
  }
  
  /**
   * @deprecated
   */
  public void f()
  {
    for (;;)
    {
      try
      {
        this.n = false;
        if (!this.b.a()) {
          break label110;
        }
        if (this.m)
        {
          if (!this.l)
          {
            com.google.ads.util.b.a("Enabling refreshing every " + this.p + " milliseconds.");
            this.h.postDelayed(this.q, this.p);
            this.l = true;
            return;
          }
          com.google.ads.util.b.a("Refreshing is already enabled.");
          continue;
        }
        com.google.ads.util.b.a("Refreshing disabled on this AdView");
      }
      finally {}
      continue;
      label110:
      com.google.ads.util.b.a("Tried to enable refreshing on something other than an AdView.");
    }
  }
  
  public void g()
  {
    f();
    this.n = true;
  }
  
  public m h()
  {
    return this.b;
  }
  
  /**
   * @deprecated
   */
  public com.google.ads.d i()
  {
    try
    {
      com.google.ads.d locald = this.w;
      return locald;
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
  public c j()
  {
    try
    {
      c localc = this.c;
      return localc;
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
  public AdWebView k()
  {
    try
    {
      AdWebView localAdWebView = this.f;
      return localAdWebView;
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
  public i l()
  {
    try
    {
      i locali = this.g;
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public g m()
  {
    return this.e;
  }
  
  /**
   * @deprecated
   */
  public int n()
  {
    try
    {
      int i1 = this.u;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long o()
  {
    return this.i;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public boolean p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/ads/internal/d:c	Lcom/google/ads/internal/c;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	d
    //   6	2	1	localc	c
    //   12	7	1	bool	boolean
    //   22	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  /**
   * @deprecated
   */
  public boolean q()
  {
    try
    {
      boolean bool = this.j;
      return bool;
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
  public boolean r()
  {
    try
    {
      boolean bool = this.k;
      return bool;
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
  public boolean s()
  {
    try
    {
      boolean bool = this.l;
      return bool;
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
  public void t()
  {
    try
    {
      this.e.C();
      com.google.ads.util.b.c("onDismissScreen()");
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onDismissScreen((Ad)this.b.h.a());
      }
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
  public void u()
  {
    try
    {
      com.google.ads.util.b.c("onPresentScreen()");
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onPresentScreen((Ad)this.b.h.a());
      }
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
  public void v()
  {
    try
    {
      com.google.ads.util.b.c("onLeaveApplication()");
      AdListener localAdListener = (AdListener)this.b.m.a();
      if (localAdListener != null) {
        localAdListener.onLeaveApplication((Ad)this.b.h.a());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void w()
  {
    this.e.f();
    B();
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void x()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/google/ads/internal/d:b	Lcom/google/ads/m;
    //   6: getfield 308	com/google/ads/m:e	Lcom/google/ads/util/i$d;
    //   9: invokevirtual 311	com/google/ads/util/i$d:a	()Ljava/lang/Object;
    //   12: checkcast 116	android/app/Activity
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: ldc_w 669
    //   23: invokestatic 318	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 169	com/google/ads/internal/d:s	Ljava/util/LinkedList;
    //   33: invokevirtual 319	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   36: astore_2
    //   37: aload_2
    //   38: invokeinterface 262 1 0
    //   43: ifeq -17 -> 26
    //   46: new 266	java/lang/Thread
    //   49: dup
    //   50: new 268	com/google/ads/ac
    //   53: dup
    //   54: aload_2
    //   55: invokeinterface 271 1 0
    //   60: checkcast 273	java/lang/String
    //   63: aload_1
    //   64: invokevirtual 120	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   67: invokespecial 283	com/google/ads/ac:<init>	(Ljava/lang/String;Landroid/content/Context;)V
    //   70: invokespecial 286	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   73: invokevirtual 289	java/lang/Thread:start	()V
    //   76: goto -39 -> 37
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   15	49	1	localActivity	Activity
    //   79	4	1	localObject	Object
    //   36	19	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	26	79	finally
    //   29	76	79	finally
  }
  
  /**
   * @deprecated
   */
  public void y()
  {
    for (;;)
    {
      try
      {
        if (this.d == null) {
          break label114;
        }
        if (!this.b.a()) {
          break label105;
        }
        if ((((AdView)this.b.i.a()).isShown()) && (AdUtil.d()))
        {
          com.google.ads.util.b.c("Refreshing ad.");
          a(this.d);
          if (this.n) {
            e();
          }
        }
        else
        {
          com.google.ads.util.b.a("Not refreshing because the ad is not visible.");
          continue;
        }
        this.h.postDelayed(this.q, this.p);
      }
      finally {}
      continue;
      label105:
      com.google.ads.util.b.a("Tried to refresh an ad that wasn't an AdView.");
      continue;
      label114:
      com.google.ads.util.b.a("Tried to refresh before calling loadAd().");
    }
  }
  
  /**
   * @deprecated
   */
  public void z()
  {
    for (;;)
    {
      try
      {
        com.google.ads.util.a.a(this.b.b());
        if (!this.k) {
          break label101;
        }
        this.k = false;
        if (this.v == null)
        {
          com.google.ads.util.b.b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
          return;
        }
        if (this.v.booleanValue())
        {
          if (!this.x.c()) {
            continue;
          }
          a(this.y, Boolean.valueOf(false));
          continue;
        }
        AdActivity.launchAdActivity(this, new e("interstitial"));
      }
      finally {}
      x();
      continue;
      label101:
      com.google.ads.util.b.c("Cannot show interstitial because it is not loaded and ready.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.internal.d
 * JD-Core Version:    0.7.0.1
 */