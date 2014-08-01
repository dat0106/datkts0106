package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ez
  extends WebViewClient
{
  protected final ey lL;
  private final Object lq = new Object();
  private bb mQ;
  private bg na;
  private be nb;
  private a pL;
  private final HashMap<String, bd> sE = new HashMap();
  private u sF;
  private cj sG;
  private boolean sH = false;
  private boolean sI;
  private cm sJ;
  
  public ez(ey paramey, boolean paramBoolean)
  {
    this.lL = paramey;
    this.sI = paramBoolean;
  }
  
  private static boolean c(Uri paramUri)
  {
    String str = paramUri.getScheme();
    boolean bool;
    if ((!"http".equalsIgnoreCase(str)) && (!"https".equalsIgnoreCase(str))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void d(Uri paramUri)
  {
    Object localObject = paramUri.getPath();
    bd localbd = (bd)this.sE.get(localObject);
    Map localMap;
    if (localbd == null)
    {
      ev.C("No GMSG handler found for GMSG: " + paramUri);
    }
    else
    {
      localMap = ep.b(paramUri);
      if (ev.p(2))
      {
        ev.C("Received GMSG: " + (String)localObject);
        localObject = localMap.keySet().iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localbd.b(this.lL, localMap);
        return;
      }
      String str = (String)((Iterator)localObject).next();
      ev.C("  " + str + ": " + (String)localMap.get(str));
    }
  }
  
  public final void a(cf paramcf)
  {
    cj localcj = null;
    boolean bool = this.lL.bZ();
    u localu;
    if ((!bool) || (this.lL.Q().md)) {
      localu = this.sF;
    } else {
      localu = null;
    }
    if (!bool) {
      localcj = this.sG;
    }
    a(new ci(paramcf, localu, localcj, this.sJ, this.lL.bY()));
  }
  
  protected void a(ci paramci)
  {
    cg.a(this.lL.getContext(), paramci);
  }
  
  public final void a(a parama)
  {
    this.pL = parama;
  }
  
  public void a(u paramu, cj paramcj, bb parambb, cm paramcm, boolean paramBoolean, be parambe)
  {
    a("/appEvent", new ba(parambb));
    a("/canOpenURLs", bc.mS);
    a("/click", bc.mT);
    a("/close", bc.mU);
    a("/customClose", bc.mV);
    a("/httpTrack", bc.mW);
    a("/log", bc.mX);
    a("/open", new bh(parambe));
    a("/touch", bc.mY);
    a("/video", bc.mZ);
    this.sF = paramu;
    this.sG = paramcj;
    this.mQ = parambb;
    this.nb = parambe;
    this.sJ = paramcm;
    r(paramBoolean);
  }
  
  public void a(u paramu, cj paramcj, bb parambb, cm paramcm, boolean paramBoolean, be parambe, bg parambg)
  {
    a(paramu, paramcj, parambb, paramcm, paramBoolean, parambe);
    a("/setInterstitialProperties", new bf(parambg));
    this.na = parambg;
  }
  
  public final void a(String paramString, bd parambd)
  {
    this.sE.put(paramString, parambd);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    u localu;
    if ((!this.lL.bZ()) || (this.lL.Q().md)) {
      localu = this.sF;
    } else {
      localu = null;
    }
    a(new ci(localu, this.sG, this.sJ, this.lL, paramBoolean, paramInt, this.lL.bY()));
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    cj localcj = null;
    boolean bool = this.lL.bZ();
    u localu;
    if ((!bool) || (this.lL.Q().md)) {
      localu = this.sF;
    } else {
      localu = null;
    }
    if (!bool) {
      localcj = this.sG;
    }
    a(new ci(localu, localcj, this.mQ, this.sJ, this.lL, paramBoolean, paramInt, paramString, this.lL.bY(), this.nb));
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.lL.bZ();
    u localu;
    if ((!bool) || (this.lL.Q().md)) {
      localu = this.sF;
    } else {
      localu = null;
    }
    cj localcj;
    if (!bool) {
      localcj = this.sG;
    } else {
      localcj = null;
    }
    a(new ci(localu, localcj, this.mQ, this.sJ, this.lL, paramBoolean, paramInt, paramString1, paramString2, this.lL.bY(), this.nb));
  }
  
  public final void aN()
  {
    synchronized (this.lq)
    {
      this.sH = false;
      this.sI = true;
      final cg localcg = this.lL.bV();
      if (localcg != null)
      {
        if (!eu.bR()) {
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              localcg.aN();
            }
          });
        }
      }
      else {
        return;
      }
      localcg.aN();
    }
  }
  
  public boolean ce()
  {
    synchronized (this.lq)
    {
      boolean bool = this.sI;
      return bool;
    }
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    ev.C("Loading resource: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      d(localUri);
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.pL != null)
    {
      this.pL.a(this.lL);
      this.pL = null;
    }
  }
  
  public final void r(boolean paramBoolean)
  {
    this.sH = paramBoolean;
  }
  
  public final void reset()
  {
    synchronized (this.lq)
    {
      this.sE.clear();
      this.sF = null;
      this.sG = null;
      this.pL = null;
      this.mQ = null;
      this.sH = false;
      this.sI = false;
      this.nb = null;
      this.sJ = null;
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ev.C("AdWebView shouldOverrideUrlLoading: " + paramString);
    Object localObject2 = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(((Uri)localObject2).getScheme())) && ("mobileads.google.com".equalsIgnoreCase(((Uri)localObject2).getHost()))) {
      d((Uri)localObject2);
    }
    for (;;)
    {
      for (boolean bool = true;; bool = super.shouldOverrideUrlLoading(paramWebView, paramString))
      {
        return bool;
        if ((!this.sH) || (paramWebView != this.lL) || (!c((Uri)localObject2))) {
          break;
        }
      }
      if (!this.lL.willNotDraw())
      {
        try
        {
          localObject1 = this.lL.bX();
          if ((localObject1 != null) && (((l)localObject1).a((Uri)localObject2)))
          {
            localObject1 = ((l)localObject1).a((Uri)localObject2, this.lL.getContext());
            localObject2 = localObject1;
          }
          localObject1 = localObject2;
        }
        catch (m localm)
        {
          for (;;)
          {
            ev.D("Unable to append parameter to URL: " + paramString);
            Object localObject1 = localObject2;
          }
        }
        a(new cf("android.intent.action.VIEW", ((Uri)localObject1).toString(), null, null, null, null, null));
        continue;
      }
      ev.D("AdWebView unable to handle URL: " + paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ey paramey);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ez
 * JD-Core Version:    0.7.0.1
 */