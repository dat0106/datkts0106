package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker
{
  private Context mContext;
  private final TrackerHandler xb;
  private final Map<String, String> xc = new HashMap();
  private ad xd;
  private final h xe;
  private final ae xf;
  private final g xg;
  private boolean xh;
  private a xi;
  private aj xj;
  private ExceptionReporter xk;
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, Context paramContext)
  {
    this(paramString, paramTrackerHandler, h.cq(), ae.dq(), g.cp(), new z("tracking"), paramContext);
  }
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler, h paramh, ae paramae, g paramg, ad paramad, Context paramContext)
  {
    this.xb = paramTrackerHandler;
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
    }
    if (paramString != null) {
      this.xc.put("&tid", paramString);
    }
    this.xc.put("useSecure", "1");
    this.xe = paramh;
    this.xf = paramae;
    this.xg = paramg;
    this.xc.put("&a", Integer.toString(1 + new Random().nextInt(2147483647)));
    this.xd = paramad;
    this.xi = new a();
    enableAdvertisingIdCollection(false);
  }
  
  void a(aj paramaj)
  {
    aa.C("Loading Tracker config values.");
    this.xj = paramaj;
    String str;
    if (this.xj.dz())
    {
      str = this.xj.dA();
      set("&tid", str);
      aa.C("[Tracker] trackingId loaded: " + str);
    }
    if (this.xj.dB())
    {
      str = Double.toString(this.xj.dC());
      set("&sf", str);
      aa.C("[Tracker] sample frequency loaded: " + str);
    }
    if (this.xj.dD())
    {
      setSessionTimeout(this.xj.getSessionTimeout());
      aa.C("[Tracker] session timeout loaded: " + dt());
    }
    if (this.xj.dE())
    {
      enableAutoActivityTracking(this.xj.dF());
      aa.C("[Tracker] auto activity tracking loaded: " + du());
    }
    if (this.xj.dG())
    {
      if (this.xj.dH())
      {
        set("&aip", "1");
        aa.C("[Tracker] anonymize ip loaded: true");
      }
      aa.C("[Tracker] anonymize ip loaded: false");
    }
    enableExceptionReporting(this.xj.dI());
  }
  
  long dt()
  {
    return this.xi.dt();
  }
  
  boolean du()
  {
    return this.xi.du();
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.xc.containsKey("&ate")) {
        this.xc.remove("&ate");
      }
      if (this.xc.containsKey("&adid")) {
        this.xc.remove("&adid");
      }
    }
    else
    {
      this.xc.put("&ate", null);
      this.xc.put("&adid", null);
    }
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.xi.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    if (this.xh != paramBoolean)
    {
      this.xh = paramBoolean;
      if (!paramBoolean)
      {
        if (this.xk == null) {
          Thread.setDefaultUncaughtExceptionHandler(null);
        } else {
          Thread.setDefaultUncaughtExceptionHandler(this.xk.cy());
        }
        aa.C("Uncaught exceptions will not be reported to Google Analytics.");
      }
      else
      {
        this.xk = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
        Thread.setDefaultUncaughtExceptionHandler(this.xk);
        aa.C("Uncaught exceptions will be reported to Google Analytics.");
      }
    }
  }
  
  public String get(String paramString)
  {
    String str = null;
    u.cP().a(u.a.vc);
    if (!TextUtils.isEmpty(paramString)) {
      if (!this.xc.containsKey(paramString))
      {
        if (!paramString.equals("&ul"))
        {
          if ((this.xe == null) || (!this.xe.J(paramString)))
          {
            if ((this.xf == null) || (!this.xf.J(paramString)))
            {
              if ((this.xg != null) && (this.xg.J(paramString))) {
                str = this.xg.getValue(paramString);
              }
            }
            else {
              str = this.xf.getValue(paramString);
            }
          }
          else {
            str = this.xe.getValue(paramString);
          }
        }
        else {
          str = ak.a(Locale.getDefault());
        }
      }
      else {
        str = (String)this.xc.get(paramString);
      }
    }
    return str;
  }
  
  public void send(Map<String, String> paramMap)
  {
    u.cP().a(u.a.ve);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.xc);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid")))
    {
      localObject = new Object[1];
      localObject[0] = "&tid";
      aa.D(String.format("Missing tracking id (%s) parameter.", (Object[])localObject));
    }
    Object localObject = (String)localHashMap.get("&t");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Object[1];
      localObject[0] = "&t";
      aa.D(String.format("Missing hit type (%s) parameter.", (Object[])localObject));
      localObject = "";
    }
    if (this.xi.dv()) {
      localHashMap.put("&sc", "start");
    }
    localObject = ((String)localObject).toLowerCase();
    if (("screenview".equals(localObject)) || ("pageview".equals(localObject)) || ("appview".equals(localObject)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      int i = 1 + Integer.parseInt((String)this.xc.get("&a"));
      if (i >= 2147483647) {
        i = 1;
      }
      this.xc.put("&a", Integer.toString(i));
    }
    if ((((String)localObject).equals("transaction")) || (((String)localObject).equals("item")) || (this.xd.dj())) {
      this.xb.p(localHashMap);
    } else {
      aa.D("Too many hits sent too quickly, rate limiting invoked.");
    }
  }
  
  public void set(String paramString1, String paramString2)
  {
    hn.b(paramString1, "Key should be non-null");
    u.cP().a(u.a.vd);
    this.xc.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", ak.v(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toHexString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) || (paramInt2 >= 0)) {
      set("&sr", paramInt1 + "x" + paramInt2);
    } else {
      aa.D("Invalid width or height. The values should be non-negative.");
    }
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.xi.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", ak.v(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  private class a
    implements GoogleAnalytics.a
  {
    private i ur = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    private boolean xl = false;
    private int xm = 0;
    private long xn = -1L;
    private boolean xo = false;
    private long xp;
    
    public a() {}
    
    private void dw()
    {
      GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.dd();
      if (localGoogleAnalytics != null)
      {
        if ((this.xn < 0L) && (!this.xl)) {
          localGoogleAnalytics.b(Tracker.b(Tracker.this));
        } else {
          localGoogleAnalytics.a(Tracker.b(Tracker.this));
        }
      }
      else {
        aa.A("GoogleAnalytics isn't initialized for the Tracker!");
      }
    }
    
    public long dt()
    {
      return this.xn;
    }
    
    public boolean du()
    {
      return this.xl;
    }
    
    public boolean dv()
    {
      boolean bool = this.xo;
      this.xo = false;
      return bool;
    }
    
    boolean dx()
    {
      boolean bool;
      if (this.ur.currentTimeMillis() < this.xp + Math.max(1000L, this.xn)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.xl = paramBoolean;
      dw();
    }
    
    public void h(Activity paramActivity)
    {
      u.cP().a(u.a.wb);
      if ((this.xm == 0) && (dx())) {
        this.xo = true;
      }
      this.xm = (1 + this.xm);
      if (this.xl)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        u.cP().u(true);
        Tracker localTracker = Tracker.this;
        String str;
        if (Tracker.c(Tracker.this) == null) {
          str = paramActivity.getClass().getCanonicalName();
        } else {
          str = Tracker.c(Tracker.this).j(paramActivity);
        }
        localTracker.set("&cd", str);
        Tracker.this.send(localHashMap);
        u.cP().u(false);
      }
    }
    
    public void i(Activity paramActivity)
    {
      u.cP().a(u.a.wc);
      this.xm = (-1 + this.xm);
      this.xm = Math.max(0, this.xm);
      if (this.xm == 0) {
        this.xp = this.ur.currentTimeMillis();
      }
    }
    
    public void setSessionTimeout(long paramLong)
    {
      this.xn = paramLong;
      dw();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.Tracker
 * JD-Core Version:    0.7.0.1
 */