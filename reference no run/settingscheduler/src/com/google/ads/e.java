package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import com.google.ads.util.i.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e
{
  private final d a;
  private h b = null;
  private Object c = new Object();
  private Thread d = null;
  private Object e = new Object();
  private boolean f = false;
  private Object g = new Object();
  
  protected e()
  {
    this.a = null;
  }
  
  public e(d paramd)
  {
    com.google.ads.util.a.b(paramd);
    this.a = paramd;
  }
  
  public static boolean a(c paramc, d paramd)
  {
    boolean bool;
    if (paramc.j() != null)
    {
      if (!paramd.h().b())
      {
        AdSize localAdSize1 = ((com.google.ads.internal.h)paramd.h().k.a()).b();
        if (!paramc.j().a())
        {
          AdSize localAdSize2 = paramc.j().b();
          if (localAdSize2 == localAdSize1)
          {
            bool = true;
          }
          else
          {
            b.e("Mediation server returned ad size: '" + localAdSize2 + "', while the AdView was created with ad size: '" + bool + "'. Using the ad-size passed to the AdView on creation.");
            bool = false;
          }
        }
        else
        {
          b.e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + bool + ") in the ad-type field in the mediation UI.");
          bool = false;
        }
      }
      else if (paramc.j().a())
      {
        bool = true;
      }
      else
      {
        b.e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
        bool = false;
      }
    }
    else {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(h paramh, String paramString)
  {
    boolean bool;
    if (e() == paramh)
    {
      bool = true;
    }
    else
    {
      b.c("GWController: ignoring callback to " + paramString + " from non showing ambassador with adapter class: '" + paramh.h() + "'.");
      bool = false;
    }
    return bool;
  }
  
  private boolean a(String paramString, Activity paramActivity, AdRequest paramAdRequest, final f paramf, HashMap<String, String> paramHashMap, long paramLong)
  {
    synchronized (new h(this, (com.google.ads.internal.h)this.a.h().k.a(), paramf, paramString, paramAdRequest, paramHashMap))
    {
      ???.a(paramActivity);
      try
      {
        while ((!???.c()) && (paramLong > 0L))
        {
          long l1 = SystemClock.elapsedRealtime();
          ???.wait(paramLong);
          long l2 = SystemClock.elapsedRealtime();
          paramLong -= l2 - l1;
        }
        final View localView1;
        int i;
        View localView2;
        int j;
        localObject = finally;
      }
      catch (InterruptedException localInterruptedException)
      {
        b.a("Interrupted while waiting for ad network to load ad using adapter class: " + paramString);
        this.a.m().a(???.e());
        if ((???.c()) && (???.d()))
        {
          if (this.a.h().b()) {}
          for (localView1 = null;; localView2 = ???.f())
          {
            this.a.a(new Runnable()
            {
              public void run()
              {
                if (!e.a(e.this, localh)) {
                  e.b(e.this).a(localView1, localh, paramf, false);
                } else {
                  b.a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
                }
              }
            });
            i = 1;
            break;
          }
        }
        ???.b();
        j = 0;
      }
    }
    return localObject;
  }
  
  private void b(final c paramc, AdRequest paramAdRequest)
  {
    for (;;)
    {
      Object localObject4;
      HashMap localHashMap;
      Object localObject5;
      synchronized (this.e)
      {
        com.google.ads.util.a.a(Thread.currentThread(), this.d);
        Object localObject3 = paramc.f();
        if (paramc.a())
        {
          long l1 = paramc.b();
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label295;
          }
          Object localObject7 = (a)((Iterator)localObject3).next();
          b.a("Looking to fetch ads from network: " + ((a)localObject7).b());
          localObject4 = ((a)localObject7).c();
          localHashMap = ((a)localObject7).e();
          localObject6 = ((a)localObject7).d();
          localObject5 = ((a)localObject7).a();
          localObject7 = ((a)localObject7).b();
          String str = paramc.c();
          if (localObject6 == null) {
            break label243;
          }
          localObject5 = new f((String)localObject5, (String)localObject7, str, (List)localObject6, paramc.h(), paramc.i());
          localObject7 = ((List)localObject4).iterator();
          if (!((Iterator)localObject7).hasNext()) {
            continue;
          }
          localObject4 = (String)((Iterator)localObject7).next();
          localObject6 = (Activity)this.a.h().e.a();
          if (localObject6 != null) {
            break label252;
          }
          b.a("Activity is null while mediating.  Terminating mediation thread.");
          return;
        }
      }
      long l2 = 10000L;
      continue;
      label243:
      Object localObject6 = paramc.g();
      continue;
      label252:
      this.a.m().c();
      if (!a((String)localObject4, (Activity)localObject6, paramAdRequest, (f)localObject5, localHashMap, l2)) {
        if (d())
        {
          b.a("GWController.destroy() called. Terminating mediation thread.");
          continue;
          label295:
          this.a.a(new Runnable()
          {
            public void run()
            {
              e.b(e.this).b(paramc);
            }
          });
        }
      }
    }
  }
  
  private boolean d()
  {
    synchronized (this.g)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  private h e()
  {
    synchronized (this.c)
    {
      h localh = this.b;
      return localh;
    }
  }
  
  private boolean e(h paramh)
  {
    synchronized (this.g)
    {
      int i;
      if (d())
      {
        paramh.b();
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    return localObject2;
  }
  
  public void a(final c paramc, final AdRequest paramAdRequest)
  {
    synchronized (this.e)
    {
      if (a())
      {
        b.c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
      }
      else
      {
        a(paramc, this.a);
        this.d = new Thread(new Runnable()
        {
          public void run()
          {
            e.a(e.this, paramc, paramAdRequest);
            synchronized (e.a(e.this))
            {
              e.a(e.this, null);
              return;
            }
          }
        });
        this.d.start();
      }
    }
  }
  
  public void a(h paramh)
  {
    if (a(paramh, "onPresentScreen")) {
      this.a.a(new Runnable()
      {
        public void run()
        {
          e.b(e.this).u();
        }
      });
    }
  }
  
  public void a(h paramh, final View paramView)
  {
    if (e() == paramh)
    {
      this.a.m().a(g.a.a);
      final f localf = this.b.a();
      this.a.a(new Runnable()
      {
        public void run()
        {
          e.b(e.this).a(paramView, e.c(e.this), localf, true);
        }
      });
    }
    else
    {
      b.c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + paramh.h() + "').");
    }
  }
  
  public void a(h paramh, final boolean paramBoolean)
  {
    if (a(paramh, "onAdClicked()"))
    {
      final f localf = paramh.a();
      this.a.a(new Runnable()
      {
        public void run()
        {
          e.b(e.this).a(localf, paramBoolean);
        }
      });
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.d != null)
        {
          boolean bool = true;
          return bool;
        }
      }
      int i = 0;
    }
  }
  
  public void b()
  {
    synchronized (this.g)
    {
      this.f = true;
      d(null);
      synchronized (this.e)
      {
        if (this.d != null) {
          this.d.interrupt();
        }
        return;
      }
    }
  }
  
  public void b(h paramh)
  {
    if (a(paramh, "onDismissScreen")) {
      this.a.a(new Runnable()
      {
        public void run()
        {
          e.b(e.this).t();
        }
      });
    }
  }
  
  public void c(h paramh)
  {
    if (a(paramh, "onLeaveApplication")) {
      this.a.a(new Runnable()
      {
        public void run()
        {
          e.b(e.this).v();
        }
      });
    }
  }
  
  public boolean c()
  {
    com.google.ads.util.a.a(this.a.h().b());
    h localh = e();
    boolean bool;
    if (localh == null)
    {
      b.b("There is no ad ready to show.");
      bool = false;
    }
    else
    {
      bool.g();
      bool = true;
    }
    return bool;
  }
  
  public void d(h paramh)
  {
    synchronized (this.c)
    {
      if (this.b != paramh)
      {
        if (this.b != null) {
          this.b.b();
        }
        this.b = paramh;
      }
      return;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.e
 * JD-Core Version:    0.7.0.1
 */