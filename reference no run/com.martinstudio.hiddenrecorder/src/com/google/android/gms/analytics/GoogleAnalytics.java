package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GoogleAnalytics
  extends TrackerHandler
{
  private static boolean wj;
  private static GoogleAnalytics wq;
  private Context mContext;
  private String tA;
  private f tS;
  private String tz;
  private boolean wk;
  private af wl;
  private volatile Boolean wm = Boolean.valueOf(false);
  private Logger wn;
  private Set<a> wo;
  private boolean wp = false;
  
  protected GoogleAnalytics(Context paramContext)
  {
    this(paramContext, t.u(paramContext), r.cz());
  }
  
  private GoogleAnalytics(Context paramContext, f paramf, af paramaf)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext.getApplicationContext();
      this.tS = paramf;
      this.wl = paramaf;
      g.r(this.mContext);
      ae.r(this.mContext);
      h.r(this.mContext);
      this.wn = new l();
      this.wo = new HashSet();
      de();
      return;
    }
    throw new IllegalArgumentException("context cannot be null");
  }
  
  private int P(String paramString)
  {
    String str = paramString.toLowerCase();
    int i;
    if (!"verbose".equals(str))
    {
      if (!"info".equals(str))
      {
        if (!"warning".equals(str))
        {
          if (!"error".equals(str)) {
            i = -1;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
  
  private Tracker a(Tracker paramTracker)
  {
    if (this.tz != null) {
      paramTracker.set("&an", this.tz);
    }
    if (this.tA != null) {
      paramTracker.set("&av", this.tA);
    }
    return paramTracker;
  }
  
  static GoogleAnalytics dd()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = wq;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void de()
  {
    if (wj) {}
    for (;;)
    {
      return;
      try
      {
        localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
        localApplicationInfo = localApplicationInfo;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          ApplicationInfo localApplicationInfo;
          aa.C("PackageManager doesn't know about package: " + localNameNotFoundException);
          localBundle = null;
        }
        localBundle = localBundle.metaData;
      }
      if (localApplicationInfo == null)
      {
        aa.D("Couldn't get ApplicationInfo to load gloabl config.");
      }
      else
      {
        Bundle localBundle;
        if (localBundle != null)
        {
          int i = localBundle.getInt("com.google.android.gms.analytics.globalConfigResource");
          if (i > 0)
          {
            w localw = (w)new v(this.mContext).r(i);
            if (localw != null) {
              a(localw);
            }
          }
        }
      }
    }
  }
  
  private void f(Activity paramActivity)
  {
    Iterator localIterator = this.wo.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((a)localIterator.next()).h(paramActivity);
    }
  }
  
  private void g(Activity paramActivity)
  {
    Iterator localIterator = this.wo.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((a)localIterator.next()).i(paramActivity);
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (wq == null) {
        wq = new GoogleAnalytics(paramContext);
      }
      GoogleAnalytics localGoogleAnalytics = wq;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(a parama)
  {
    this.wo.add(parama);
  }
  
  void a(w paramw)
  {
    aa.C("Loading global config values.");
    if (paramw.cT())
    {
      this.tz = paramw.cU();
      aa.C("app name loaded: " + this.tz);
    }
    if (paramw.cV())
    {
      this.tA = paramw.cW();
      aa.C("app version loaded: " + this.tA);
    }
    if (paramw.cX())
    {
      int i = P(paramw.cY());
      if (i >= 0)
      {
        aa.C("log level loaded: " + i);
        getLogger().setLogLevel(i);
      }
    }
    if (paramw.cZ()) {
      this.wl.setLocalDispatchPeriod(paramw.da());
    }
    if (paramw.db()) {
      setDryRun(paramw.dc());
    }
  }
  
  void b(a parama)
  {
    this.wo.remove(parama);
  }
  
  @Deprecated
  public void dispatchLocalHits()
  {
    this.wl.dispatchLocalHits();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.wp))
    {
      paramApplication.registerActivityLifecycleCallbacks(new b());
      this.wp = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    u.cP().a(u.a.vK);
    return this.wm.booleanValue();
  }
  
  public Logger getLogger()
  {
    return this.wn;
  }
  
  public boolean isDryRunEnabled()
  {
    u.cP().a(u.a.vW);
    return this.wk;
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      u.cP().a(u.a.vG);
      Tracker localTracker = new Tracker(null, this, this.mContext);
      if (paramInt > 0)
      {
        aj localaj = (aj)new ai(this.mContext).r(paramInt);
        if (localaj != null) {
          localTracker.a(localaj);
        }
      }
      localTracker = a(localTracker);
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      u.cP().a(u.a.vG);
      Tracker localTracker = a(new Tracker(paramString, this, this.mContext));
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void p(java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +19 -> 22
    //   6: new 100	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc_w 384
    //   13: invokespecial 105	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    //   22: aload_1
    //   23: ldc_w 386
    //   26: invokestatic 392	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   29: invokestatic 397	com/google/android/gms/analytics/ak:a	(Ljava/util/Locale;)Ljava/lang/String;
    //   32: invokestatic 400	com/google/android/gms/analytics/ak:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc_w 402
    //   39: invokestatic 406	com/google/android/gms/analytics/ae:dq	()Lcom/google/android/gms/analytics/ae;
    //   42: ldc_w 402
    //   45: invokevirtual 410	com/google/android/gms/analytics/ae:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 400	com/google/android/gms/analytics/ak:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_1
    //   52: ldc_w 412
    //   55: invokestatic 342	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   58: invokevirtual 415	com/google/android/gms/analytics/u:cR	()Ljava/lang/String;
    //   61: invokeinterface 421 3 0
    //   66: pop
    //   67: invokestatic 342	com/google/android/gms/analytics/u:cP	()Lcom/google/android/gms/analytics/u;
    //   70: invokevirtual 424	com/google/android/gms/analytics/u:cQ	()Ljava/lang/String;
    //   73: pop
    //   74: aload_0
    //   75: getfield 72	com/google/android/gms/analytics/GoogleAnalytics:tS	Lcom/google/android/gms/analytics/f;
    //   78: aload_1
    //   79: invokeinterface 428 2 0
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	GoogleAnalytics
    //   0	87	1	paramMap	java.util.Map<String, String>
    //   17	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	20	17	finally
    //   22	86	17	finally
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.wp) {
      f(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.wp) {
      g(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    u.cP().a(u.a.vJ);
    this.wm = Boolean.valueOf(paramBoolean);
    if (this.wm.booleanValue()) {
      this.tS.cg();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    u.cP().a(u.a.vV);
    this.wk = paramBoolean;
  }
  
  @Deprecated
  public void setLocalDispatchPeriod(int paramInt)
  {
    this.wl.setLocalDispatchPeriod(paramInt);
  }
  
  public void setLogger(Logger paramLogger)
  {
    u.cP().a(u.a.vX);
    this.wn = paramLogger;
  }
  
  class b
    implements Application.ActivityLifecycleCallbacks
  {
    b() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.a(GoogleAnalytics.this, paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.b(GoogleAnalytics.this, paramActivity);
    }
  }
  
  static abstract interface a
  {
    public abstract void h(Activity paramActivity);
    
    public abstract void i(Activity paramActivity);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.GoogleAnalytics
 * JD-Core Version:    0.7.0.1
 */