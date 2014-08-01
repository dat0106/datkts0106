package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import java.io.IOException;

class a
{
  private static a aee;
  private static Object tn = new Object();
  private volatile long adZ = 900000L;
  private volatile long aea = 30000L;
  private volatile long aeb;
  private final ik aec;
  private a aed = new a()
  {
    public AdvertisingIdClient.Info lb()
    {
      AdvertisingIdClient.Info localInfo = null;
      try
      {
        localInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.a(a.this));
        localInfo = localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          bh.D("IllegalStateException getting Advertising Id Info");
        }
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        for (;;)
        {
          bh.D("GooglePlayServicesRepairableException getting Advertising Id Info");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          bh.D("IOException getting Ad Id Info");
        }
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        for (;;)
        {
          bh.D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bh.D("Unknown exception. Could not get the Advertising Id Info.");
        }
      }
      return localInfo;
    }
  };
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread sc;
  private volatile AdvertisingIdClient.Info tp;
  
  private a(Context paramContext)
  {
    this(paramContext, null, im.fW());
  }
  
  a(Context paramContext, a parama, ik paramik)
  {
    this.aec = paramik;
    if (paramContext == null) {
      this.mContext = paramContext;
    } else {
      this.mContext = paramContext.getApplicationContext();
    }
    if (parama != null) {
      this.aed = parama;
    }
    this.sc = new Thread(new Runnable()
    {
      public void run()
      {
        a.b(a.this);
      }
    });
  }
  
  static a J(Context paramContext)
  {
    if (aee == null) {}
    synchronized (tn)
    {
      if (aee == null)
      {
        aee = new a(paramContext);
        aee.start();
      }
      return aee;
    }
  }
  
  private void kZ()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed) {
      try
      {
        this.tp = this.aed.lb();
        Thread.sleep(this.adZ);
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.B("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void la()
  {
    if (this.aec.currentTimeMillis() - this.aeb >= this.aea)
    {
      interrupt();
      this.aeb = this.aec.currentTimeMillis();
    }
  }
  
  void interrupt()
  {
    this.sc.interrupt();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    la();
    boolean bool;
    if (this.tp != null) {
      bool = this.tp.isLimitAdTrackingEnabled();
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String kY()
  {
    la();
    String str;
    if (this.tp != null) {
      str = this.tp.getId();
    } else {
      str = null;
    }
    return str;
  }
  
  void start()
  {
    this.sc.start();
  }
  
  public static abstract interface a
  {
    public abstract AdvertisingIdClient.Info lb();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.a
 * JD-Core Version:    0.7.0.1
 */