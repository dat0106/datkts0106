package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ey
  extends WebView
  implements DownloadListener
{
  private final WindowManager lA;
  private final Object lq = new Object();
  private am nD;
  private final ew nE;
  private final l py;
  private boolean sA;
  private boolean sB;
  private boolean sC;
  private final ez sx;
  private final a sy;
  private cg sz;
  
  private ey(a parama, am paramam, boolean paramBoolean1, boolean paramBoolean2, l paraml, ew paramew)
  {
    super(parama);
    this.sy = parama;
    this.nD = paramam;
    this.sA = paramBoolean1;
    this.py = paraml;
    this.nE = paramew;
    this.lA = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    ep.a(parama, paramew.st, localWebSettings);
    if (Build.VERSION.SDK_INT < 17)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        er.a(getContext(), localWebSettings);
      }
    }
    else {
      es.a(getContext(), localWebSettings);
    }
    setDownloadListener(this);
    if (Build.VERSION.SDK_INT < 11) {
      this.sx = new ez(this, paramBoolean2);
    } else {
      this.sx = new fb(this, paramBoolean2);
    }
    setWebViewClient(this.sx);
    if (Build.VERSION.SDK_INT < 14)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        setWebChromeClient(new fa(this));
      }
    }
    else {
      setWebChromeClient(new fc(this));
    }
    cb();
  }
  
  public static ey a(Context paramContext, am paramam, boolean paramBoolean1, boolean paramBoolean2, l paraml, ew paramew)
  {
    return new ey(new a(paramContext), paramam, paramBoolean1, paramBoolean2, paraml, paramew);
  }
  
  /* Error */
  private void cb()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gms/internal/ey:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 47	com/google/android/gms/internal/ey:sA	Z
    //   11: ifne +13 -> 24
    //   14: aload_0
    //   15: getfield 45	com/google/android/gms/internal/ey:nD	Lcom/google/android/gms/internal/am;
    //   18: getfield 157	com/google/android/gms/internal/am:md	Z
    //   21: ifeq +40 -> 61
    //   24: getstatic 107	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 14
    //   29: if_icmpge +15 -> 44
    //   32: ldc 159
    //   34: invokestatic 165	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: invokespecial 168	com/google/android/gms/internal/ey:cc	()V
    //   41: aload_1
    //   42: monitorexit
    //   43: return
    //   44: ldc 170
    //   46: invokestatic 165	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: invokespecial 173	com/google/android/gms/internal/ey:cd	()V
    //   53: goto -12 -> 41
    //   56: astore_2
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: getstatic 107	android/os/Build$VERSION:SDK_INT	I
    //   64: bipush 18
    //   66: if_icmpge +15 -> 81
    //   69: ldc 175
    //   71: invokestatic 165	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: invokespecial 168	com/google/android/gms/internal/ey:cc	()V
    //   78: goto -37 -> 41
    //   81: ldc 177
    //   83: invokestatic 165	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokespecial 173	com/google/android/gms/internal/ey:cd	()V
    //   90: goto -49 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	ey
    //   4	54	1	localObject1	Object
    //   56	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	59	56	finally
    //   61	90	56	finally
  }
  
  private void cc()
  {
    synchronized (this.lq)
    {
      if ((!this.sB) && (Build.VERSION.SDK_INT >= 11)) {
        er.d(this);
      }
      this.sB = true;
      return;
    }
  }
  
  private void cd()
  {
    synchronized (this.lq)
    {
      if ((this.sB) && (Build.VERSION.SDK_INT >= 11)) {
        er.e(this);
      }
      this.sB = false;
      return;
    }
  }
  
  protected void E(String paramString)
  {
    synchronized (this.lq)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      ev.D("The webview is destroyed. Ignoring action.");
    }
  }
  
  public am Q()
  {
    synchronized (this.lq)
    {
      am localam = this.nD;
      return localam;
    }
  }
  
  public void a(Context paramContext, am paramam)
  {
    synchronized (this.lq)
    {
      this.sy.setBaseContext(paramContext);
      this.sz = null;
      this.nD = paramam;
      this.sA = false;
      ep.b(this);
      loadUrl("about:blank");
      this.sx.reset();
      return;
    }
  }
  
  public void a(am paramam)
  {
    synchronized (this.lq)
    {
      this.nD = paramam;
      requestLayout();
      return;
    }
  }
  
  public void a(cg paramcg)
  {
    synchronized (this.lq)
    {
      this.sz = paramcg;
      return;
    }
  }
  
  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      JSONObject localJSONObject = ep.o(paramMap);
      b(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ev.D("Could not convert parameters to JSON.");
      }
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:" + paramString + "(");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    E(localStringBuilder.toString());
  }
  
  public void b(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:AFMA_ReceiveMessage('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    localStringBuilder.append(",");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    ev.C("Dispatching AFMA event: " + localStringBuilder);
    E(localStringBuilder.toString());
  }
  
  public void bS()
  {
    if (!bW().ce()) {}
    for (;;)
    {
      return;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      Display localDisplay = this.lA.getDefaultDisplay();
      localDisplay.getMetrics(localDisplayMetrics);
      int j = ep.m(getContext());
      float f = 160.0F / localDisplayMetrics.densityDpi;
      int i = (int)(f * localDisplayMetrics.widthPixels);
      j = (int)(f * (localDisplayMetrics.heightPixels - j));
      try
      {
        b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", j).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      }
      catch (JSONException localJSONException)
      {
        ev.b("Error occured while obtaining screen information.", localJSONException);
      }
    }
  }
  
  public void bT()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nE.st);
    a("onhide", localHashMap);
  }
  
  public void bU()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.nE.st);
    a("onshow", localHashMap);
  }
  
  public cg bV()
  {
    synchronized (this.lq)
    {
      cg localcg = this.sz;
      return localcg;
    }
  }
  
  public ez bW()
  {
    return this.sx;
  }
  
  public l bX()
  {
    return this.py;
  }
  
  public ew bY()
  {
    return this.nE;
  }
  
  public boolean bZ()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sA;
      return bool;
    }
  }
  
  public Context ca()
  {
    return this.sy.ca();
  }
  
  public void destroy()
  {
    synchronized (this.lq)
    {
      super.destroy();
      this.sC = true;
      return;
    }
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sC;
      return bool;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramString1), paramString4);
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        ev.z("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f;
    for (int k = 2147483647;; f = localObject2)
    {
      int m;
      label287:
      do
      {
        int j;
        synchronized (this.lq)
        {
          if ((isInEditMode()) || (this.sA))
          {
            super.onMeasure(paramInt1, paramInt2);
          }
          else
          {
            int n = View.MeasureSpec.getMode(paramInt1);
            j = View.MeasureSpec.getSize(paramInt1);
            m = View.MeasureSpec.getMode(paramInt2);
            int i = View.MeasureSpec.getSize(paramInt2);
            if (n == -2147483648) {
              break label287;
            }
            if (n == 1073741824)
            {
              break label287;
              if ((this.nD.widthPixels > n) || (this.nD.heightPixels > k))
              {
                f = this.sy.getResources().getDisplayMetrics().density;
                ev.D("Not enough space to show ad. Needs " + (int)(this.nD.widthPixels / f) + "x" + (int)(this.nD.heightPixels / f) + " dp, but only has " + (int)(j / f) + "x" + (int)(i / f) + " dp.");
                if (getVisibility() != 8) {
                  setVisibility(4);
                }
                setMeasuredDimension(0, 0);
              }
            }
          }
        }
        int i1 = j;
      } while ((m != -2147483648) && (m != 1073741824));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.py != null) {
      this.py.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void q(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      this.sA = paramBoolean;
      cb();
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.sy.setBaseContext(paramContext);
  }
  
  private static class a
    extends MutableContextWrapper
  {
    private Context lx;
    private Activity sD;
    
    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Context ca()
    {
      return this.sD;
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.lx = paramContext.getApplicationContext();
      Activity localActivity;
      if (!(paramContext instanceof Activity)) {
        localActivity = null;
      } else {
        localActivity = (Activity)paramContext;
      }
      this.sD = localActivity;
      super.setBaseContext(this.lx);
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (this.sD == null)
      {
        paramIntent.setFlags(268435456);
        this.lx.startActivity(paramIntent);
      }
      else
      {
        this.sD.startActivity(paramIntent);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ey
 * JD-Core Version:    0.7.0.1
 */