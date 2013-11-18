package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.internal.i;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.util.g;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.util.HashMap;
import java.util.Map;

public class AdActivity
  extends Activity
  implements View.OnClickListener
{
  public static final String BASE_URL_PARAM = "baseurl";
  public static final String CUSTOM_CLOSE_PARAM = "custom_close";
  public static final String HTML_PARAM = "html";
  public static final String INTENT_ACTION_PARAM = "i";
  public static final String ORIENTATION_PARAM = "o";
  public static final String TYPE_PARAM = "m";
  public static final String URL_PARAM = "u";
  private static final a a = (a)a.a.b();
  private static final Object b = new Object();
  private static AdActivity c = null;
  private static d d = null;
  private static AdActivity e = null;
  private static AdActivity f = null;
  private static final StaticMethodWrapper g = new StaticMethodWrapper();
  private AdWebView h;
  private FrameLayout i;
  private int j;
  private ViewGroup k = null;
  private boolean l;
  private long m;
  private RelativeLayout n;
  private AdActivity o = null;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private AdVideoView t;
  
  private RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  private void a(String paramString)
  {
    b.b(paramString);
    finish();
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    b.b(paramString, paramThrowable);
    finish();
  }
  
  private void d()
  {
    if (!this.l) {
      if (this.h != null)
      {
        a.b(this.h);
        this.h.setAdActivity(null);
        this.h.setIsExpandedMraid(false);
        if ((!this.q) && (this.n != null) && (this.k != null))
        {
          if ((!this.r) || (this.s)) {
            break label238;
          }
          b.a("Disabling hardware acceleration on collapsing MRAID WebView.");
          this.h.b();
        }
      }
    }
    for (;;)
    {
      this.n.removeView(this.h);
      this.k.addView(this.h);
      if (this.t != null)
      {
        this.t.e();
        this.t = null;
      }
      if (this == c) {
        c = null;
      }
      f = this.o;
      synchronized (b)
      {
        if ((d != null) && (this.q) && (this.h != null))
        {
          if (this.h == d.k()) {
            d.a();
          }
          this.h.stopLoading();
        }
        if (this == e)
        {
          e = null;
          if (d != null)
          {
            d.t();
            d = null;
          }
        }
        else
        {
          this.l = true;
          b.a("AdActivity is closing.");
          return;
          label238:
          if ((this.r) || (!this.s)) {
            continue;
          }
          b.a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
          this.h.c();
          continue;
        }
        b.e("currentAdManager is null while trying to destroy AdActivity.");
      }
    }
  }
  
  public static boolean isShowing()
  {
    return g.isShowing();
  }
  
  public static void launchAdActivity(d paramd, e parame)
  {
    g.launchAdActivity(paramd, parame);
  }
  
  protected View a(int paramInt, boolean paramBoolean)
  {
    this.j = ((int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics()));
    this.i = new FrameLayout(getApplicationContext());
    this.i.setMinimumWidth(this.j);
    this.i.setMinimumHeight(this.j);
    this.i.setOnClickListener(this);
    setCustomClose(paramBoolean);
    return this.i;
  }
  
  protected AdVideoView a(Activity paramActivity)
  {
    return new AdVideoView(paramActivity, this.h);
  }
  
  protected void a(AdWebView paramAdWebView, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    requestWindowFeature(1);
    Object localObject = getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    if (AdUtil.a >= 11) {
      if (!this.r)
      {
        b.a("Disabling hardware acceleration on the AdActivity WebView.");
        paramAdWebView.b();
      }
      else
      {
        b.a("Enabling hardware acceleration on the AdActivity window.");
        g.a((Window)localObject);
      }
    }
    localObject = paramAdWebView.getParent();
    if (localObject != null)
    {
      if (!paramBoolean2)
      {
        a("Interstitial created with an AdWebView that has a parent.");
      }
      else if (!(localObject instanceof ViewGroup))
      {
        a("MRAID banner was not a child of a ViewGroup.");
      }
      else
      {
        this.k = ((ViewGroup)localObject);
        this.k.removeView(paramAdWebView);
      }
    }
    else if (paramAdWebView.d() == null)
    {
      setRequestedOrientation(paramInt);
      paramAdWebView.setAdActivity(this);
      int i1;
      if (!paramBoolean2) {
        i1 = 32;
      } else {
        i1 = 50;
      }
      View localView = a(i1, paramBoolean3);
      this.n.addView(paramAdWebView, -1, -1);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramBoolean2)
      {
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(9);
      }
      else
      {
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(11);
      }
      this.n.addView(localView, localLayoutParams);
      this.n.setKeepScreenOn(true);
      setContentView(this.n);
      this.n.getRootView().setBackgroundColor(-16777216);
      if (paramBoolean1) {
        a.a(paramAdWebView);
      }
    }
    else
    {
      a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
    }
  }
  
  protected void a(d paramd)
  {
    this.h = null;
    this.m = SystemClock.elapsedRealtime();
    this.p = true;
    synchronized (b)
    {
      if (c == null)
      {
        c = this;
        paramd.v();
      }
      return;
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, d paramd)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtras(getIntent().getExtras());
    localIntent.putExtra("com.google.circles.platform.intent.extra.ENTITY", (String)paramHashMap.get("u"));
    localIntent.putExtra("com.google.circles.platform.intent.extra.ENTITY_TYPE", ai.b.a.c);
    localIntent.putExtra("com.google.circles.platform.intent.extra.ACTION", (String)paramHashMap.get("a"));
    a(paramd);
    try
    {
      b.a("Launching Google+ intent from AdActivity.");
      startActivityForResult(localIntent, 0);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        a(localActivityNotFoundException.getMessage(), localActivityNotFoundException);
      }
    }
  }
  
  protected void b(HashMap<String, String> paramHashMap, d paramd)
  {
    if (paramHashMap == null) {
      a("Could not get the paramMap in launchIntent()");
    }
    for (;;)
    {
      return;
      localObject1 = (String)paramHashMap.get("u");
      if (localObject1 != null) {
        break;
      }
      a("Could not get the URL parameter in launchIntent().");
    }
    Object localObject2 = (String)paramHashMap.get("i");
    String str = (String)paramHashMap.get("m");
    Object localObject1 = Uri.parse((String)localObject1);
    if (localObject2 == null) {}
    for (localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);; localObject2 = new Intent((String)localObject2, (Uri)localObject1))
    {
      for (;;)
      {
        if (str != null) {
          ((Intent)localObject2).setDataAndType((Uri)localObject1, str);
        }
        a(paramd);
        try
        {
          b.a("Launching an intent from AdActivity: " + ((Intent)localObject2).getAction() + " - " + localObject1);
          startActivity((Intent)localObject2);
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          a(localActivityNotFoundException.getMessage(), localActivityNotFoundException);
        }
      }
      break;
    }
  }
  
  public AdVideoView getAdVideoView()
  {
    return this.t;
  }
  
  /* Error */
  public AdWebView getOpeningAdWebView()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 98	com/google/ads/AdActivity:o	Lcom/google/ads/AdActivity;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 98	com/google/ads/AdActivity:o	Lcom/google/ads/AdActivity;
    //   13: getfield 130	com/google/ads/AdActivity:h	Lcom/google/ads/internal/AdWebView;
    //   16: astore_3
    //   17: aload_3
    //   18: areturn
    //   19: getstatic 82	com/google/ads/AdActivity:b	Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: getstatic 86	com/google/ads/AdActivity:d	Lcom/google/ads/internal/d;
    //   28: ifnonnull +19 -> 47
    //   31: ldc_w 460
    //   34: invokestatic 196	com/google/ads/util/b:e	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: monitorexit
    //   39: goto -22 -> 17
    //   42: astore_2
    //   43: aload_1
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    //   47: getstatic 86	com/google/ads/AdActivity:d	Lcom/google/ads/internal/d;
    //   50: invokevirtual 179	com/google/ads/internal/d:k	()Lcom/google/ads/internal/AdWebView;
    //   53: astore_2
    //   54: aload_2
    //   55: aload_0
    //   56: getfield 130	com/google/ads/AdActivity:h	Lcom/google/ads/internal/AdWebView;
    //   59: if_acmpeq +10 -> 69
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: astore_3
    //   66: goto -49 -> 17
    //   69: aload_1
    //   70: monitorexit
    //   71: goto -54 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	AdActivity
    //   22	48	1	localObject1	Object
    //   42	4	2	localObject2	Object
    //   53	12	2	localAdWebView	AdWebView
    //   1	65	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	45	42	finally
    //   47	71	42	finally
  }
  
  public void moveAdVideoView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.t != null)
    {
      this.t.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
      this.t.requestLayout();
    }
  }
  
  public void newAdVideoView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.t == null)
    {
      this.t = a(this);
      this.n.addView(this.t, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
      synchronized (b)
      {
        if (d == null) {
          b.e("currentAdManager was null while trying to get the opening AdWebView.");
        } else {
          d.l().b(false);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((getOpeningAdWebView() != null) && (paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION") != null) && (paramIntent.getExtras().getString("com.google.circles.platform.result.extra.ACTION") != null))
    {
      String str1 = paramIntent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION");
      String str2 = paramIntent.getExtras().getString("com.google.circles.platform.result.extra.ACTION");
      if (str1.equals("yes")) {
        if (!str2.equals("insert"))
        {
          if (str2.equals("delete")) {
            ag.a(getOpeningAdWebView(), false);
          }
        }
        else {
          ag.a(getOpeningAdWebView(), true);
        }
      }
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool3 = false;
    super.onCreate(paramBundle);
    this.l = false;
    d locald;
    label270:
    label276:
    Object localObject4;
    for (;;)
    {
      synchronized (b)
      {
        if (d != null)
        {
          locald = d;
          if (e == null)
          {
            e = this;
            locald.u();
          }
          if ((this.o == null) && (f != null)) {
            this.o = f;
          }
          f = this;
          if (((locald.h().a()) && (e == this)) || ((locald.h().b()) && (this.o == e))) {
            locald.w();
          }
          boolean bool1 = locald.q();
          l.a locala = (l.a)((l)locald.h().a.a()).a.a();
          if (AdUtil.a >= ((Integer)locala.a.a()).intValue())
          {
            bool6 = true;
            this.s = bool6;
            if (AdUtil.a < ((Integer)locala.b.a()).intValue()) {
              break label270;
            }
            bool5 = true;
            this.r = bool5;
            this.n = null;
            this.p = false;
            this.q = true;
            this.t = null;
            ??? = getIntent().getBundleExtra("com.google.ads.AdOpener");
            if (??? != null) {
              break label276;
            }
            a("Could not get the Bundle used to create AdActivity.");
          }
        }
        else
        {
          a("Could not get currentAdManager.");
        }
      }
      boolean bool6 = false;
      continue;
      boolean bool5 = false;
      continue;
      ??? = new e((Bundle)???);
      localObject4 = ((e)???).b();
      ??? = ((e)???).c();
      if (((String)localObject4).equals("plusone"))
      {
        a((HashMap)???, locald);
      }
      else
      {
        if (!((String)localObject4).equals("intent")) {
          break;
        }
        b((HashMap)???, locald);
      }
    }
    this.n = new RelativeLayout(getApplicationContext());
    label397:
    label483:
    int i1;
    label510:
    boolean bool2;
    boolean bool4;
    if (((String)localObject4).equals("webapp"))
    {
      this.h = new AdWebView(locald.h(), null);
      localObject4 = a.c;
      Object localObject3;
      String str;
      if (localObject1 == 0)
      {
        bool3 = true;
        localObject3 = i.a(locald, (Map)localObject4, true, bool3);
        ((i)localObject3).d(true);
        if (localObject1 != 0) {
          ((i)localObject3).a(true);
        }
        this.h.setWebViewClient((WebViewClient)localObject3);
        localObject3 = (String)((HashMap)???).get("u");
        localObject4 = (String)((HashMap)???).get("baseurl");
        str = (String)((HashMap)???).get("html");
        if (localObject3 == null) {
          break label560;
        }
        this.h.loadUrl((String)localObject3);
        localObject3 = (String)((HashMap)???).get("o");
        if (!"p".equals(localObject3)) {
          break label596;
        }
        i1 = AdUtil.b();
        localObject3 = this.h;
        if ((??? == null) || (!"1".equals(((HashMap)???).get("custom_close")))) {
          break label635;
        }
      }
      label560:
      label596:
      label635:
      for (bool2 = true;; bool2 = false)
      {
        a((AdWebView)localObject3, false, i1, localObject1, bool2);
        break;
        bool4 = false;
        break label397;
        if (str != null)
        {
          this.h.loadDataWithBaseURL((String)localObject4, str, "text/html", "utf-8", null);
          break label483;
        }
        a("Could not get the URL or HTML parameter to show a web app.");
        break;
        if ("l".equals(bool4))
        {
          i1 = AdUtil.a();
          break label510;
        }
        if (this == e)
        {
          i1 = i1.n();
          break label510;
        }
        i1 = -1;
        break label510;
      }
    }
    if ((((String)localObject4).equals("interstitial")) || (((String)localObject4).equals("expand")))
    {
      this.h = i1.k();
      i1 = i1.n();
      if (((String)localObject4).equals("expand"))
      {
        this.h.setIsExpandedMraid(true);
        this.q = false;
        if ((bool2 != null) && ("1".equals(bool2.get("custom_close")))) {
          bool4 = true;
        }
        if ((!this.r) || (this.s)) {
          break label817;
        }
        b.a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        this.h.c();
        bool2 = bool4;
      }
    }
    for (;;)
    {
      a(this.h, true, i1, localObject1, bool2);
      break;
      bool2 = this.h.e();
      continue;
      a("Unknown AdOpener, <action: " + (String)localObject4 + ">");
      break;
      label817:
      bool2 = bool4;
    }
  }
  
  public void onDestroy()
  {
    if (this.n != null) {
      this.n.removeAllViews();
    }
    if (isFinishing())
    {
      d();
      if ((this.q) && (this.h != null))
      {
        this.h.stopLoading();
        this.h.destroy();
        this.h = null;
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (isFinishing()) {
      d();
    }
    super.onPause();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((this.p) && (paramBoolean) && (SystemClock.elapsedRealtime() - this.m > 250L))
    {
      b.d("Launcher AdActivity got focus and is closing.");
      finish();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.removeAllViews();
      if (!paramBoolean)
      {
        ImageButton localImageButton = new ImageButton(this);
        localImageButton.setImageResource(17301527);
        localImageButton.setBackgroundColor(0);
        localImageButton.setOnClickListener(this);
        localImageButton.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.j, this.j, 17);
        this.i.addView(localImageButton, localLayoutParams);
      }
    }
  }
  
  public static class StaticMethodWrapper
  {
    public boolean isShowing()
    {
      for (;;)
      {
        synchronized ()
        {
          if (AdActivity.b() != null)
          {
            boolean bool = true;
            return bool;
          }
        }
        int i = 0;
      }
    }
    
    public void launchAdActivity(d paramd, e parame)
    {
      for (;;)
      {
        synchronized ()
        {
          if (AdActivity.c() == null)
          {
            AdActivity.b(paramd);
            ??? = (Activity)paramd.h().e.a();
            if (??? == null) {
              b.e("activity was null while launching an AdActivity.");
            }
          }
          else
          {
            if (AdActivity.c() == paramd) {
              continue;
            }
            b.b("Tried to launch a new AdActivity with a different AdManager.");
          }
        }
        Intent localIntent = new Intent(((Activity)???).getApplicationContext(), AdActivity.class);
        localIntent.putExtra("com.google.ads.AdOpener", parame.a());
        try
        {
          b.a("Launching AdActivity.");
          ((Activity)???).startActivity(localIntent);
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          b.b("Activity not found.", localActivityNotFoundException);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdActivity
 * JD-Core Version:    0.7.0.1
 */