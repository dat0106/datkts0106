package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long lE = TimeUnit.MILLISECONDS.toNanos(100L);
  private final WindowManager lA;
  private final PowerManager lB;
  private final KeyguardManager lC;
  private ae lD;
  private boolean lF = false;
  private long lG = -9223372036854775808L;
  private boolean lH;
  private BroadcastReceiver lI;
  private HashSet<aa> lJ = new HashSet();
  private boolean lh = false;
  private final Object lq = new Object();
  private final WeakReference<eg> lt;
  private WeakReference<ViewTreeObserver> lu;
  private final WeakReference<View> lv;
  private final ab lw;
  private final Context lx;
  private final af ly;
  private boolean lz;
  
  public ad(am paramam, eg parameg)
  {
    this(paramam, parameg, parameg.ow.bY(), parameg.ow, new ag(parameg.ow.getContext(), parameg.ow.bY()));
  }
  
  public ad(am paramam, eg parameg, ew paramew, View paramView, af paramaf)
  {
    this.lt = new WeakReference(parameg);
    this.lv = new WeakReference(paramView);
    this.lu = new WeakReference(null);
    this.lH = true;
    this.lw = new ab(Integer.toString(parameg.hashCode()), paramew, paramam.mc, parameg.rv);
    this.ly = paramaf;
    this.lA = ((WindowManager)paramView.getContext().getSystemService("window"));
    this.lB = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    this.lC = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    this.lx = paramView.getContext().getApplicationContext();
    a(paramaf);
    this.ly.a(new af.a()
    {
      public void az()
      {
        ad.b(ad.this, true);
        ad.this.e(false);
        ad.this.aq();
      }
    });
    b(this.ly);
    ev.B("Tracking ad unit: " + this.lw.ap());
  }
  
  protected int a(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = paramDisplayMetrics.density;
    return (int)(paramInt / f);
  }
  
  public void a(aa paramaa)
  {
    this.lJ.add(paramaa);
  }
  
  public void a(ae paramae)
  {
    synchronized (this.lq)
    {
      this.lD = paramae;
      return;
    }
  }
  
  protected void a(af paramaf)
  {
    paramaf.d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
  }
  
  protected void a(ey paramey, Map<String, String> paramMap)
  {
    e(false);
  }
  
  protected void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONArray.put(paramJSONObject);
    localJSONObject.put("units", localJSONArray);
    this.ly.a("AFMA_updateActiveView", localJSONObject);
  }
  
  protected boolean a(View paramView, boolean paramBoolean)
  {
    boolean bool;
    if ((paramView.getVisibility() != 0) || (!paramBoolean) || (!paramView.isShown()) || (!this.lB.isScreenOn()) || (this.lC.inKeyguardRestrictedInputMode())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void aq()
  {
    synchronized (this.lq)
    {
      if (this.lI == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.lI = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            ad.this.e(false);
          }
        };
        this.lx.registerReceiver(this.lI, localIntentFilter);
      }
    }
  }
  
  protected void ar()
  {
    synchronized (this.lq)
    {
      if (this.lI != null)
      {
        this.lx.unregisterReceiver(this.lI);
        this.lI = null;
      }
      return;
    }
  }
  
  public void as()
  {
    synchronized (this.lq)
    {
      if (this.lH)
      {
        aw();
        ar();
      }
      try
      {
        a(ay());
        this.lH = false;
        at();
        ev.B("Untracked ad unit: " + this.lw.ap());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ev.b("JSON Failure while processing active view data.", localJSONException);
        }
      }
    }
  }
  
  protected void at()
  {
    if (this.lD != null) {
      this.lD.a(this);
    }
  }
  
  public boolean au()
  {
    synchronized (this.lq)
    {
      boolean bool = this.lH;
      return bool;
    }
  }
  
  protected void av()
  {
    Object localObject = (View)this.lv.get();
    if (localObject != null)
    {
      ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.lu.get();
      localObject = ((View)localObject).getViewTreeObserver();
      if (localObject != localViewTreeObserver)
      {
        this.lu = new WeakReference(localObject);
        ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
      }
    }
  }
  
  protected void aw()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.lu.get();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
    {
      localViewTreeObserver.removeOnScrollChangedListener(this);
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
  
  protected JSONObject ax()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.lw.an()).put("activeViewJSON", this.lw.ao()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.lw.am()).put("hashCode", this.lw.ap());
    return localJSONObject;
  }
  
  protected JSONObject ay()
    throws JSONException
  {
    JSONObject localJSONObject = ax();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected void b(af paramaf)
  {
    paramaf.a("/updateActiveView", new bd()
    {
      public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
      {
        ad.this.a(paramAnonymousey, paramAnonymousMap);
      }
    });
    paramaf.a("/activeViewPingSent", new bd()
    {
      public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
      {
        if ((paramAnonymousMap.containsKey("pingType")) && ("unloadPing".equals(paramAnonymousMap.get("pingType"))))
        {
          ad.this.c(ad.b(ad.this));
          ev.B("Unregistered GMSG handlers for: " + ad.c(ad.this).ap());
        }
      }
    });
    paramaf.a("/visibilityChanged", new bd()
    {
      public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
      {
        if (paramAnonymousMap.containsKey("isVisible"))
        {
          boolean bool;
          if ((!"1".equals(paramAnonymousMap.get("isVisible"))) && (!"true".equals(paramAnonymousMap.get("isVisible")))) {
            bool = false;
          } else {
            bool = true;
          }
          Boolean localBoolean = Boolean.valueOf(bool);
          ad.this.d(localBoolean.booleanValue());
        }
      }
    });
    paramaf.a("/viewabilityChanged", bc.mR);
  }
  
  protected JSONObject c(View paramView)
    throws JSONException
  {
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    paramView.getLocationOnScreen((int[])localObject2);
    paramView.getLocationInWindow((int[])localObject1);
    JSONObject localJSONObject = ax();
    localObject1 = paramView.getContext().getResources().getDisplayMetrics();
    Rect localRect1 = new Rect();
    localRect1.left = localObject2[0];
    localRect1.top = localObject2[1];
    localRect1.right = (localRect1.left + paramView.getWidth());
    localRect1.bottom = (localRect1.top + paramView.getHeight());
    localObject2 = new Rect();
    ((Rect)localObject2).right = this.lA.getDefaultDisplay().getWidth();
    ((Rect)localObject2).bottom = this.lA.getDefaultDisplay().getHeight();
    Rect localRect3 = new Rect();
    boolean bool = paramView.getGlobalVisibleRect(localRect3, null);
    Rect localRect2 = new Rect();
    paramView.getLocalVisibleRect(localRect2);
    localJSONObject.put("viewBox", new JSONObject().put("top", a(((Rect)localObject2).top, (DisplayMetrics)localObject1)).put("bottom", a(((Rect)localObject2).bottom, (DisplayMetrics)localObject1)).put("left", a(((Rect)localObject2).left, (DisplayMetrics)localObject1)).put("right", a(((Rect)localObject2).right, (DisplayMetrics)localObject1))).put("adBox", new JSONObject().put("top", a(localRect1.top, (DisplayMetrics)localObject1)).put("bottom", a(localRect1.bottom, (DisplayMetrics)localObject1)).put("left", a(localRect1.left, (DisplayMetrics)localObject1)).put("right", a(localRect1.right, (DisplayMetrics)localObject1))).put("globalVisibleBox", new JSONObject().put("top", a(localRect3.top, (DisplayMetrics)localObject1)).put("bottom", a(localRect3.bottom, (DisplayMetrics)localObject1)).put("left", a(localRect3.left, (DisplayMetrics)localObject1)).put("right", a(localRect3.right, (DisplayMetrics)localObject1))).put("localVisibleBox", new JSONObject().put("top", a(localRect2.top, (DisplayMetrics)localObject1)).put("bottom", a(localRect2.bottom, (DisplayMetrics)localObject1)).put("left", a(localRect2.left, (DisplayMetrics)localObject1)).put("right", a(localRect2.right, (DisplayMetrics)localObject1))).put("screenDensity", ((DisplayMetrics)localObject1).density).put("isVisible", a(paramView, bool)).put("isStopped", this.lF).put("isPaused", this.lh);
    return localJSONObject;
  }
  
  protected void c(af paramaf)
  {
    paramaf.e("/viewabilityChanged");
    paramaf.e("/visibilityChanged");
    paramaf.e("/activeViewPingSent");
    paramaf.e("/updateActiveView");
  }
  
  protected void d(boolean paramBoolean)
  {
    Iterator localIterator = this.lJ.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((aa)localIterator.next()).a(this, paramBoolean);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    for (;;)
    {
      eg localeg;
      View localView;
      synchronized (this.lq)
      {
        if ((!this.lz) || (this.lH))
        {
          long l = System.nanoTime();
          if ((!paramBoolean) || (this.lG + lE <= l)) {}
        }
      }
      int i = 1;
    }
  }
  
  public void onGlobalLayout()
  {
    e(false);
  }
  
  public void onScrollChanged()
  {
    e(true);
  }
  
  public void pause()
  {
    synchronized (this.lq)
    {
      this.lh = true;
      e(false);
      this.ly.pause();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.lq)
    {
      this.ly.resume();
      this.lh = false;
      e(false);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.lq)
    {
      this.lF = true;
      e(false);
      this.ly.pause();
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ad
 * JD-Core Version:    0.7.0.1
 */