package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class v
  extends ar.a
  implements bb, be, bg, bo, cj, cm, dn.a, ek, u
{
  private final c kA;
  private final z kB;
  private final ac kC;
  private boolean kD;
  private final ComponentCallbacks kE = new ComponentCallbacks()
  {
    public void onConfigurationChanged(Configuration paramAnonymousConfiguration)
    {
      if ((v.a(v.this) != null) && (v.a(v.this).kS != null) && (v.a(v.this).kS.ow != null)) {
        v.a(v.this).kS.ow.bS();
      }
    }
    
    public void onLowMemory() {}
  };
  private final bu kz;
  
  public v(Context paramContext, am paramam, String paramString, bu parambu, ew paramew)
  {
    this.kA = new c(paramContext, paramam, paramString, paramew);
    this.kz = parambu;
    this.kB = new z(this);
    this.kC = new ac();
    ep.k(paramContext);
    R();
  }
  
  private void R()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kA != null) && (this.kA.kM != null)) {
      this.kA.kM.registerComponentCallbacks(this.kE);
    }
  }
  
  private void S()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.kA != null) && (this.kA.kM != null)) {
      this.kA.kM.unregisterComponentCallbacks(this.kE);
    }
  }
  
  private void a(int paramInt)
  {
    ev.D("Failed to load ad: " + paramInt);
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
      }
    }
  }
  
  private void ac()
  {
    ev.B("Ad closing.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call AdListener.onAdClosed().", localRemoteException);
      }
    }
  }
  
  private void ad()
  {
    ev.B("Ad leaving application.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call AdListener.onAdLeftApplication().", localRemoteException);
      }
    }
  }
  
  private void ae()
  {
    ev.B("Ad opening.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call AdListener.onAdOpened().", localRemoteException);
      }
    }
  }
  
  private void af()
  {
    ev.B("Ad finished loading.");
    if (this.kA.kP != null) {}
    try
    {
      this.kA.kP.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call AdListener.onAdLoaded().", localRemoteException);
      }
    }
  }
  
  private boolean ag()
  {
    boolean bool = true;
    if (!ep.a(this.kA.kM.getPackageManager(), this.kA.kM.getPackageName(), "android.permission.INTERNET"))
    {
      if (!this.kA.kR.md) {
        eu.a(this.kA.kK, this.kA.kR, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      }
      bool = false;
    }
    if (!ep.j(this.kA.kM))
    {
      if (!this.kA.kR.md) {
        eu.a(this.kA.kK, this.kA.kR, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      }
      bool = false;
    }
    if ((!bool) && (!this.kA.kR.md)) {
      this.kA.kK.setVisibility(0);
    }
    return bool;
  }
  
  private void ah()
  {
    if (this.kA.kS != null)
    {
      ev.z("Pinging click URLs.");
      this.kA.kT.bx();
      if (this.kA.kS.nr != null) {
        ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.nr);
      }
      if ((this.kA.kS.rw != null) && (this.kA.kS.rw.nr != null)) {
        bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, false, this.kA.kS.rw.nr);
      }
    }
    else
    {
      ev.D("Ad state was null when trying to ping click URLs.");
    }
  }
  
  private void ai()
  {
    if (this.kA.kS != null)
    {
      this.kA.kS.ow.destroy();
      this.kA.kS = null;
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.kA.kK.addView(paramView, localLayoutParams);
  }
  
  /* Error */
  private boolean b(eg parameg)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	com/google/android/gms/internal/eg:qd	Z
    //   4: ifeq +192 -> 196
    //   7: aload_1
    //   8: getfield 308	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   11: invokeinterface 314 1 0
    //   16: invokestatic 320	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   19: checkcast 322	android/view/View
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   27: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   30: invokevirtual 326	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +14 -> 49
    //   38: aload_0
    //   39: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   42: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   45: aload_2
    //   46: invokevirtual 329	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   49: aload_0
    //   50: aload_3
    //   51: invokespecial 331	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   58: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   61: invokevirtual 335	com/google/android/gms/internal/v$a:getChildCount	()I
    //   64: iconst_1
    //   65: if_icmple +13 -> 78
    //   68: aload_0
    //   69: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   72: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   75: invokevirtual 338	com/google/android/gms/internal/v$a:showNext	()V
    //   78: aload_0
    //   79: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   82: getfield 228	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   85: ifnull +70 -> 155
    //   88: aload_0
    //   89: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   92: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   95: invokevirtual 326	com/google/android/gms/internal/v$a:getNextView	()Landroid/view/View;
    //   98: astore_2
    //   99: aload_2
    //   100: instanceof 285
    //   103: ifeq +166 -> 269
    //   106: aload_2
    //   107: checkcast 285	com/google/android/gms/internal/ey
    //   110: aload_0
    //   111: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   114: getfield 91	com/google/android/gms/internal/v$c:kM	Landroid/content/Context;
    //   117: aload_0
    //   118: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   121: getfield 194	com/google/android/gms/internal/v$c:kR	Lcom/google/android/gms/internal/am;
    //   124: invokevirtual 341	com/google/android/gms/internal/ey:a	(Landroid/content/Context;Lcom/google/android/gms/internal/am;)V
    //   127: aload_0
    //   128: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   131: getfield 228	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   134: getfield 308	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   137: ifnull +18 -> 155
    //   140: aload_0
    //   141: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   144: getfield 228	com/google/android/gms/internal/v$c:kS	Lcom/google/android/gms/internal/eg;
    //   147: getfield 308	com/google/android/gms/internal/eg:nL	Lcom/google/android/gms/internal/bv;
    //   150: invokeinterface 342 1 0
    //   155: aload_0
    //   156: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   159: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   162: iconst_0
    //   163: invokevirtual 223	com/google/android/gms/internal/v$a:setVisibility	(I)V
    //   166: iconst_1
    //   167: istore_2
    //   168: iload_2
    //   169: ireturn
    //   170: astore_2
    //   171: ldc_w 344
    //   174: aload_2
    //   175: invokestatic 141	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: iconst_0
    //   179: istore_2
    //   180: goto -12 -> 168
    //   183: astore_2
    //   184: ldc_w 346
    //   187: aload_2
    //   188: invokestatic 141	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: iconst_0
    //   192: istore_2
    //   193: goto -25 -> 168
    //   196: aload_1
    //   197: getfield 349	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   200: ifnull -146 -> 54
    //   203: aload_1
    //   204: getfield 283	com/google/android/gms/internal/eg:ow	Lcom/google/android/gms/internal/ey;
    //   207: aload_1
    //   208: getfield 349	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   211: invokevirtual 352	com/google/android/gms/internal/ey:a	(Lcom/google/android/gms/internal/am;)V
    //   214: aload_0
    //   215: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   218: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   221: invokevirtual 355	com/google/android/gms/internal/v$a:removeAllViews	()V
    //   224: aload_0
    //   225: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   228: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   231: aload_1
    //   232: getfield 349	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   235: getfield 358	com/google/android/gms/internal/am:widthPixels	I
    //   238: invokevirtual 361	com/google/android/gms/internal/v$a:setMinimumWidth	(I)V
    //   241: aload_0
    //   242: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   245: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   248: aload_1
    //   249: getfield 349	com/google/android/gms/internal/eg:rx	Lcom/google/android/gms/internal/am;
    //   252: getfield 364	com/google/android/gms/internal/am:heightPixels	I
    //   255: invokevirtual 367	com/google/android/gms/internal/v$a:setMinimumHeight	(I)V
    //   258: aload_0
    //   259: aload_1
    //   260: getfield 283	com/google/android/gms/internal/eg:ow	Lcom/google/android/gms/internal/ey;
    //   263: invokespecial 331	com/google/android/gms/internal/v:b	(Landroid/view/View;)V
    //   266: goto -212 -> 54
    //   269: aload_2
    //   270: ifnull -143 -> 127
    //   273: aload_0
    //   274: getfield 60	com/google/android/gms/internal/v:kA	Lcom/google/android/gms/internal/v$c;
    //   277: getfield 203	com/google/android/gms/internal/v$c:kK	Lcom/google/android/gms/internal/v$a;
    //   280: aload_2
    //   281: invokevirtual 329	com/google/android/gms/internal/v$a:removeView	(Landroid/view/View;)V
    //   284: goto -157 -> 127
    //   287: pop
    //   288: ldc_w 369
    //   291: invokestatic 127	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   294: goto -139 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	v
    //   0	297	1	parameg	eg
    //   33	74	2	localView1	View
    //   167	2	2	bool	boolean
    //   170	5	2	localRemoteException1	RemoteException
    //   179	1	2	i	int
    //   183	5	2	localThrowable	java.lang.Throwable
    //   192	89	2	j	int
    //   22	29	3	localView2	View
    //   287	1	9	localRemoteException2	RemoteException
    // Exception table:
    //   from	to	target	type
    //   7	23	170	android/os/RemoteException
    //   49	54	183	java/lang/Throwable
    //   140	155	287	android/os/RemoteException
  }
  
  private dt.a c(aj paramaj)
  {
    ApplicationInfo localApplicationInfo = this.kA.kM.getApplicationInfo();
    try
    {
      localPackageInfo = this.kA.kM.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo = localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int i;
        int k;
        int m;
        int j;
        String str;
        Bundle localBundle;
        PackageInfo localPackageInfo = null;
        continue;
        int n = 0;
        continue;
        Object localObject = null;
      }
    }
    if ((!this.kA.kR.md) && (this.kA.kK.getParent() != null))
    {
      localObject = new int[2];
      this.kA.kK.getLocationOnScreen((int[])localObject);
      i = localObject[0];
      k = localObject[1];
      localObject = this.kA.kM.getResources().getDisplayMetrics();
      m = this.kA.kK.getWidth();
      j = this.kA.kK.getHeight();
      if ((this.kA.kK.isShown()) && (i + m > 0) && (k + j > 0) && (i <= ((DisplayMetrics)localObject).widthPixels) && (k <= ((DisplayMetrics)localObject).heightPixels))
      {
        n = 1;
        localObject = new Bundle(5);
        ((Bundle)localObject).putInt("x", i);
        ((Bundle)localObject).putInt("y", k);
        ((Bundle)localObject).putInt("width", m);
        ((Bundle)localObject).putInt("height", j);
        ((Bundle)localObject).putInt("visible", n);
        str = ei.bD();
        this.kA.kT = new eh(str, this.kA.kL);
        this.kA.kT.f(paramaj);
        localBundle = ei.a(this.kA.kM, this, str);
        return new dt.a((Bundle)localObject, paramaj, this.kA.kR, this.kA.kL, localApplicationInfo, localPackageInfo, str, ei.rN, this.kA.kO, localBundle);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.kA.kS != null)
    {
      ev.z("Pinging Impression URLs.");
      this.kA.kT.bw();
      if (this.kA.kS.ns != null) {
        ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.ns);
      }
      if ((this.kA.kS.rw != null) && (this.kA.kS.rw.ns != null)) {
        bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, paramBoolean, this.kA.kS.rw.ns);
      }
      if ((this.kA.kS.nK != null) && (this.kA.kS.nK.nn != null)) {
        bs.a(this.kA.kM, this.kA.kO.st, this.kA.kS, this.kA.kL, paramBoolean, this.kA.kS.nK.nn);
      }
    }
    else
    {
      ev.D("Ad state was null when trying to ping impression URLs.");
    }
  }
  
  public d P()
  {
    hn.ay("getAdFrame must be called on the main UI thread.");
    return e.h(this.kA.kK);
  }
  
  public am Q()
  {
    hn.ay("getAdSize must be called on the main UI thread.");
    return this.kA.kR;
  }
  
  public void T()
  {
    ad();
  }
  
  public void U()
  {
    this.kC.d(this.kA.kS);
    if (this.kA.kR.md) {
      ai();
    }
    this.kD = false;
    ac();
    this.kA.kT.by();
  }
  
  public void V()
  {
    if (this.kA.kR.md) {
      c(false);
    }
    this.kD = true;
    ae();
  }
  
  public void W()
  {
    onAdClicked();
  }
  
  public void X()
  {
    U();
  }
  
  public void Y()
  {
    T();
  }
  
  public void Z()
  {
    V();
  }
  
  public void a(am paramam)
  {
    hn.ay("setAdSize must be called on the main UI thread.");
    this.kA.kR = paramam;
    if (this.kA.kS != null) {
      this.kA.kS.ow.a(paramam);
    }
    if (this.kA.kK.getChildCount() > 1) {
      this.kA.kK.removeView(this.kA.kK.getNextView());
    }
    this.kA.kK.setMinimumWidth(paramam.widthPixels);
    this.kA.kK.setMinimumHeight(paramam.heightPixels);
    this.kA.kK.requestLayout();
  }
  
  public void a(aq paramaq)
  {
    hn.ay("setAdListener must be called on the main UI thread.");
    this.kA.kP = paramaq;
  }
  
  public void a(at paramat)
  {
    hn.ay("setAppEventListener must be called on the main UI thread.");
    this.kA.kU = paramat;
  }
  
  public void a(dd paramdd)
  {
    hn.ay("setInAppPurchaseListener must be called on the main UI thread.");
    this.kA.kW = paramdd;
  }
  
  public void a(dh paramdh, String paramString)
  {
    hn.ay("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.kA.kX = new da(paramString);
    this.kA.kV = paramdh;
    if ((!ei.bH()) && (paramdh != null)) {
      new ct(this.kA.kM, this.kA.kV, this.kA.kX).start();
    }
  }
  
  public void a(eg parameg)
  {
    int i = 0;
    this.kA.kQ = null;
    if ((parameg.errorCode != -2) && (parameg.errorCode != 3)) {
      ei.b(this.kA.al());
    }
    if (parameg.errorCode != -1)
    {
      boolean bool;
      if (parameg.pV.extras == null) {
        bool = false;
      } else {
        bool = parameg.pV.extras.getBoolean("_noRefresh", false);
      }
      if (!this.kA.kR.md)
      {
        if (!bool) {
          if (parameg.nv <= 0L)
          {
            if ((parameg.rw == null) || (parameg.rw.nv <= 0L))
            {
              if ((!parameg.qd) && (parameg.errorCode == 2)) {
                this.kB.d(parameg.pV);
              }
            }
            else {
              this.kB.a(parameg.pV, parameg.rw.nv);
            }
          }
          else {
            this.kB.a(parameg.pV, parameg.nv);
          }
        }
      }
      else {
        ep.a(parameg.ow);
      }
      if ((parameg.errorCode == 3) && (parameg.rw != null) && (parameg.rw.nt != null))
      {
        ev.z("Pinging no fill URLs.");
        bs.a(this.kA.kM, this.kA.kO.st, parameg, this.kA.kL, false, parameg.rw.nt);
      }
      if (parameg.errorCode == -2)
      {
        if (!this.kA.kR.md)
        {
          if (!b(parameg)) {
            break label681;
          }
          if (this.kA.kK != null) {
            a.a(this.kA.kK).x(parameg.qi);
          }
        }
        if ((this.kA.kS != null) && (this.kA.kS.nN != null)) {
          this.kA.kS.nN.a(null);
        }
        if (parameg.nN != null) {
          parameg.nN.a(this);
        }
        this.kC.d(this.kA.kS);
        this.kA.kS = parameg;
        if (parameg.rx != null) {
          this.kA.kR = parameg.rx;
        }
        this.kA.kT.j(parameg.ry);
        this.kA.kT.k(parameg.rz);
        this.kA.kT.n(this.kA.kR.md);
        this.kA.kT.o(parameg.qd);
        if (!this.kA.kR.md) {
          c(false);
        }
        if (this.kA.kY == null) {
          this.kA.kY = new el(this.kA.kL);
        }
        int j;
        if (parameg.rw == null)
        {
          bool = false;
        }
        else
        {
          j = parameg.rw.nw;
          i = parameg.rw.nx;
        }
        this.kA.kY.a(j, i);
        if ((!this.kA.kR.md) && (parameg.ow != null) && ((parameg.ow.bW().ce()) || (parameg.rv != null)))
        {
          ad localad = this.kC.a(this.kA.kR, this.kA.kS);
          if ((parameg.ow.bW().ce()) && (localad != null)) {
            localad.a(new y(parameg.ow));
          }
        }
        this.kA.kS.ow.bS();
        af();
        return;
        label681:
        a(0);
      }
      else
      {
        a(parameg.errorCode);
      }
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    cu localcu = new cu(paramString, paramArrayList, this.kA.kM, this.kA.kO.st);
    if (this.kA.kW == null)
    {
      ev.D("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.kA.kM) != 0) {
        ev.D("Google Play Service unavailable, cannot launch default purchase flow.");
      }
    }
    for (;;)
    {
      return;
      if (this.kA.kV == null)
      {
        ev.D("PlayStorePurchaseListener is not set.");
      }
      else if (this.kA.kX == null)
      {
        ev.D("PlayStorePurchaseVerifier is not initialized.");
      }
      else
      {
        try
        {
          boolean bool = this.kA.kV.isValidPurchase(paramString);
          if (!bool) {
            continue;
          }
        }
        catch (RemoteException localRemoteException1)
        {
          for (;;)
          {
            ev.D("Could not start In-App purchase.");
          }
        }
        cv.a(this.kA.kM, this.kA.kO.sw, new cr(localcu, this.kA.kV, this.kA.kX, this.kA.kM));
        continue;
        try
        {
          this.kA.kW.a(localcu);
        }
        catch (RemoteException localRemoteException2)
        {
          ev.D("Could not start In-App purchase.");
        }
      }
    }
  }
  
  public void a(HashSet<eh> paramHashSet)
  {
    this.kA.a(paramHashSet);
  }
  
  public boolean a(aj paramaj)
  {
    int i = 0;
    hn.ay("loadAd must be called on the main UI thread.");
    boolean bool;
    if (this.kA.kQ == null)
    {
      if ((!this.kA.kR.md) || (this.kA.kS == null))
      {
        if (ag())
        {
          ev.B("Starting ad request.");
          if (!paramaj.lT) {
            ev.B("Use AdRequest.Builder.addTestDevice(\"" + eu.o(this.kA.kM) + "\") to get test ads on this device.");
          }
          this.kB.cancel();
          this.kA.kZ = false;
          dt.a locala = c(paramaj);
          Object localObject;
          if (!this.kA.kR.md)
          {
            localObject = this.kA.kK.getNextView();
            if (!(localObject instanceof ey))
            {
              if (localObject != null) {
                this.kA.kK.removeView((View)localObject);
              }
              localObject = ey.a(this.kA.kM, this.kA.kR, false, false, this.kA.kN, this.kA.kO);
              if (this.kA.kR.me == null) {
                b((View)localObject);
              }
            }
            else
            {
              localObject = (ey)localObject;
              ((ey)localObject).a(this.kA.kM, this.kA.kR);
            }
            ((ey)localObject).bW().a(this, this, this, this, false, this);
            localObject = localObject;
          }
          else
          {
            localObject = ey.a(this.kA.kM, this.kA.kR, false, false, this.kA.kN, this.kA.kO);
            ((ey)localObject).bW().a(this, null, this, this, true, this, this);
            localObject = localObject;
          }
          this.kA.kQ = dn.a(this.kA.kM, locala, this.kA.kN, (ey)localObject, this.kz, this);
          bool = true;
        }
      }
      else {
        ev.D("An interstitial is already loading. Aborting.");
      }
    }
    else {
      ev.D("An ad request is already in progress. Aborting.");
    }
    return bool;
  }
  
  public void aa()
  {
    if (this.kA.kS != null) {
      ev.D("Mediation adapter " + this.kA.kS.nM + " refreshed, but mediation adapters should never refresh.");
    }
    c(true);
    af();
  }
  
  public void ab()
  {
    hn.ay("recordManualImpression must be called on the main UI thread.");
    if (this.kA.kS != null)
    {
      ev.z("Pinging manual tracking URLs.");
      if (this.kA.kS.qf != null) {
        ep.a(this.kA.kM, this.kA.kO.st, this.kA.kS.qf);
      }
    }
    else
    {
      ev.D("Ad state was null when trying to ping manual tracking URLs.");
    }
  }
  
  public void b(aj paramaj)
  {
    ViewParent localViewParent = this.kA.kK.getParent();
    if ((!(localViewParent instanceof View)) || (!((View)localViewParent).isShown()) || (!ep.bL()) || (this.kD))
    {
      ev.B("Ad is not visible. Not refreshing ad.");
      this.kB.d(paramaj);
    }
    else
    {
      a(paramaj);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.kA.kZ = paramBoolean;
  }
  
  public void destroy()
  {
    hn.ay("destroy must be called on the main UI thread.");
    S();
    this.kA.kP = null;
    this.kA.kU = null;
    this.kB.cancel();
    this.kC.stop();
    stopLoading();
    if (this.kA.kK != null) {
      this.kA.kK.removeAllViews();
    }
    if ((this.kA.kS != null) && (this.kA.kS.ow != null)) {
      this.kA.kS.ow.destroy();
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Could not destroy mediation adapter.");
      }
    }
  }
  
  public boolean isReady()
  {
    hn.ay("isLoaded must be called on the main UI thread.");
    boolean bool;
    if ((this.kA.kQ != null) || (this.kA.kS == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onAdClicked()
  {
    ah();
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.kA.kU != null) {}
    try
    {
      this.kA.kU.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call the AppEventListener.", localRemoteException);
      }
    }
  }
  
  public void pause()
  {
    hn.ay("pause must be called on the main UI thread.");
    if (this.kA.kS != null) {
      ep.a(this.kA.kS.ow);
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.pause();
      this.kC.pause();
      this.kB.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    hn.ay("resume must be called on the main UI thread.");
    if (this.kA.kS != null) {
      ep.b(this.kA.kS.ow);
    }
    if ((this.kA.kS != null) && (this.kA.kS.nL != null)) {}
    try
    {
      this.kA.kS.nL.resume();
      this.kB.resume();
      this.kC.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    hn.ay("showInterstitial must be called on the main UI thread.");
    if (!this.kA.kR.md) {
      ev.D("Cannot call showInterstitial on a banner ad.");
    }
    for (;;)
    {
      return;
      if (this.kA.kS == null)
      {
        ev.D("The interstitial has not loaded.");
      }
      else if (this.kA.kS.ow.bZ())
      {
        ev.D("The interstitial is already showing.");
      }
      else
      {
        this.kA.kS.ow.q(true);
        if ((this.kA.kS.ow.bW().ce()) || (this.kA.kS.rv != null))
        {
          ad localad = this.kC.a(this.kA.kR, this.kA.kS);
          if ((this.kA.kS.ow.bW().ce()) && (localad != null)) {
            localad.a(new y(this.kA.kS.ow));
          }
        }
        if (!this.kA.kS.qd) {
          break;
        }
        try
        {
          this.kA.kS.nL.showInterstitial();
        }
        catch (RemoteException localRemoteException)
        {
          ev.c("Could not show interstitial.", localRemoteException);
          ai();
        }
      }
    }
    w localw = new w(this.kA.kZ, false);
    boolean bool2;
    if ((this.kA.kM instanceof Activity))
    {
      Window localWindow = ((Activity)this.kA.kM).getWindow();
      Rect localRect2 = new Rect();
      Rect localRect1 = new Rect();
      localWindow.getDecorView().getGlobalVisibleRect(localRect2);
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect1);
      if ((localRect2.bottom != 0) && (localRect1.bottom != 0))
      {
        bool2 = this.kA.kZ;
        if (localRect2.top != localRect1.top) {
          break label415;
        }
      }
    }
    label415:
    int i;
    for (boolean bool1 = true;; i = 0)
    {
      localw = new w(bool2, bool1);
      ci localci = new ci(this, this, this, this.kA.kS.ow, this.kA.kS.orientation, this.kA.kO, this.kA.kS.qi, localw);
      cg.a(this.kA.kM, localci);
      break;
    }
  }
  
  public void stopLoading()
  {
    hn.ay("stopLoading must be called on the main UI thread.");
    if (this.kA.kS != null)
    {
      this.kA.kS.ow.stopLoading();
      this.kA.kS = null;
    }
    if (this.kA.kQ != null) {
      this.kA.kQ.cancel();
    }
  }
  
  private static final class c
  {
    public final v.a kK;
    public final String kL;
    public final Context kM;
    public final l kN;
    public final ew kO;
    public aq kP;
    public en kQ;
    public am kR;
    public eg kS;
    public eh kT;
    public at kU;
    public dh kV;
    public dd kW;
    public da kX;
    public el kY = null;
    public boolean kZ = false;
    private HashSet<eh> la = null;
    
    public c(Context paramContext, am paramam, String paramString, ew paramew)
    {
      if (!paramam.md)
      {
        this.kK = new v.a(paramContext);
        this.kK.setMinimumWidth(paramam.widthPixels);
        this.kK.setMinimumHeight(paramam.heightPixels);
        this.kK.setVisibility(4);
      }
      else
      {
        this.kK = null;
      }
      this.kR = paramam;
      this.kL = paramString;
      this.kM = paramContext;
      this.kO = paramew;
      this.kN = new l(new v.b(this));
    }
    
    public void a(HashSet<eh> paramHashSet)
    {
      this.la = paramHashSet;
    }
    
    public HashSet<eh> al()
    {
      return this.la;
    }
  }
  
  private static final class b
    implements h, Runnable
  {
    private v.c kA;
    private final List<Object[]> kH = new Vector();
    private final CountDownLatch kI = new CountDownLatch(1);
    private final AtomicReference<h> kJ = new AtomicReference();
    
    public b(v.c paramc)
    {
      this.kA = paramc;
      if (!eu.bR()) {
        run();
      } else {
        eo.execute(this);
      }
    }
    
    private void aj()
    {
      try
      {
        this.kI.await();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ev.c("Interrupted during GADSignals creation.", localInterruptedException);
        }
      }
    }
    
    private void ak()
    {
      Iterator localIterator;
      if (!this.kH.isEmpty()) {
        localIterator = this.kH.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        Object[] arrayOfObject = (Object[])localIterator.next();
        if (arrayOfObject.length != 1)
        {
          if (arrayOfObject.length == 3) {
            ((h)this.kJ.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
          }
        }
        else {
          ((h)this.kJ.get()).a((MotionEvent)arrayOfObject[0]);
        }
      }
    }
    
    public String a(Context paramContext)
    {
      aj();
      ak();
      return ((h)this.kJ.get()).a(paramContext);
    }
    
    public String a(Context paramContext, String paramString)
    {
      aj();
      ak();
      return ((h)this.kJ.get()).a(paramContext, paramString);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject = (h)this.kJ.get();
      if (localObject == null)
      {
        localObject = this.kH;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        arrayOfObject[2] = Integer.valueOf(paramInt3);
        ((List)localObject).add(arrayOfObject);
      }
      else
      {
        ak();
        ((h)localObject).a(paramInt1, paramInt2, paramInt3);
      }
    }
    
    public void a(MotionEvent paramMotionEvent)
    {
      Object localObject = (h)this.kJ.get();
      if (localObject == null)
      {
        List localList = this.kH;
        localObject = new Object[1];
        localObject[0] = paramMotionEvent;
        localList.add(localObject);
      }
      else
      {
        ak();
        ((h)localObject).a(paramMotionEvent);
      }
    }
    
    public void run()
    {
      try
      {
        this.kJ.set(k.a(this.kA.kO.st, this.kA.kM));
        return;
      }
      finally
      {
        this.kI.countDown();
        this.kA = null;
      }
    }
  }
  
  private static final class a
    extends ViewSwitcher
  {
    private final eq kG;
    
    public a(Context paramContext)
    {
      super();
      this.kG = new eq(paramContext);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.kG.c(paramMotionEvent);
      return false;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.7.0.1
 */