package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class gi
  extends hc<gm>
{
  private static final go BD = new go("CastClientImpl");
  private static final Object BX = new Object();
  private static final Object BY = new Object();
  private double AM;
  private boolean AN;
  private final Cast.Listener Ab;
  private ApplicationMetadata BE;
  private final CastDevice BF;
  private final gn BG;
  private final Map<String, Cast.MessageReceivedCallback> BH;
  private final long BI;
  private String BJ;
  private boolean BK;
  private boolean BL;
  private boolean BM;
  private AtomicBoolean BN;
  private int BO;
  private final AtomicLong BP;
  private String BQ;
  private String BR;
  private Bundle BS;
  private Map<Long, a.d<Status>> BT;
  private b BU;
  private a.d<Cast.ApplicationConnectionResult> BV;
  private a.d<Status> BW;
  private final Handler mHandler;
  
  public gi(Context paramContext, Looper paramLooper, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
    this.BF = paramCastDevice;
    this.Ab = paramListener;
    this.BI = paramLong;
    this.mHandler = new Handler(paramLooper);
    this.BH = new HashMap();
    this.BM = false;
    this.BO = -1;
    this.BE = null;
    this.BJ = null;
    this.BN = new AtomicBoolean(false);
    this.AM = 0.0D;
    this.AN = false;
    this.BP = new AtomicLong(0L);
    this.BT = new HashMap();
    this.BU = new b(null);
    registerConnectionFailedListener(this.BU);
    this.BG = new gn.a()
    {
      private boolean X(int paramAnonymousInt)
      {
        synchronized ()
        {
          int i;
          if (gi.i(gi.this) != null)
          {
            gi.i(gi.this).a(new Status(paramAnonymousInt));
            gi.b(gi.this, null);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        return localObject2;
      }
      
      private void b(long paramAnonymousLong, int paramAnonymousInt)
      {
        synchronized (gi.h(gi.this))
        {
          a.d locald = (a.d)gi.h(gi.this).remove(Long.valueOf(paramAnonymousLong));
          if (locald != null) {
            locald.a(new Status(paramAnonymousInt));
          }
          return;
        }
      }
      
      public void T(int paramAnonymousInt)
      {
        go localgo = gi.ef();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramAnonymousInt);
        localgo.b("ICastDeviceControllerListener.onDisconnected: %d", arrayOfObject);
        gi.a(gi.this, false);
        gi.b(gi.this).set(false);
        gi.a(gi.this, null);
        if (paramAnonymousInt != 0) {
          gi.this.an(2);
        }
      }
      
      public void U(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (gi.c(gi.this) != null)
          {
            gi.c(gi.this).a(new gi.a(new Status(paramAnonymousInt)));
            gi.a(gi.this, null);
          }
          return;
        }
      }
      
      public void V(int paramAnonymousInt)
      {
        X(paramAnonymousInt);
      }
      
      public void W(int paramAnonymousInt)
      {
        X(paramAnonymousInt);
      }
      
      public void a(ApplicationMetadata paramAnonymousApplicationMetadata, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        gi.a(gi.this, paramAnonymousApplicationMetadata);
        gi.a(gi.this, paramAnonymousApplicationMetadata.getApplicationId());
        gi.b(gi.this, paramAnonymousString2);
        synchronized (gi.eg())
        {
          if (gi.c(gi.this) != null)
          {
            gi.c(gi.this).a(new gi.a(new Status(0), paramAnonymousApplicationMetadata, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean));
            gi.a(gi.this, null);
          }
          return;
        }
      }
      
      public void a(String paramAnonymousString, double paramAnonymousDouble, boolean paramAnonymousBoolean)
      {
        gi.ef().b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        b(paramAnonymousLong, 0);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        b(paramAnonymousLong, paramAnonymousInt);
      }
      
      public void b(final gf paramAnonymousgf)
      {
        gi.ef().b("onApplicationStatusChanged", new Object[0]);
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            gi.a(gi.this, paramAnonymousgf);
          }
        });
      }
      
      public void b(final gk paramAnonymousgk)
      {
        gi.ef().b("onDeviceStatusChanged", new Object[0]);
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            gi.a(gi.this, paramAnonymousgk);
          }
        });
      }
      
      public void b(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        go localgo = gi.ef();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousString;
        arrayOfObject[1] = Integer.valueOf(paramAnonymousArrayOfByte.length);
        localgo.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", arrayOfObject);
      }
      
      public void g(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        go localgo = gi.ef();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousString1;
        arrayOfObject[1] = paramAnonymousString2;
        localgo.b("Receive (type=text, ns=%s) %s", arrayOfObject);
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            for (;;)
            {
              synchronized (gi.f(gi.this))
              {
                Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)gi.f(gi.this).get(paramAnonymousString1);
                if (localMessageReceivedCallback != null)
                {
                  localMessageReceivedCallback.onMessageReceived(gi.g(gi.this), paramAnonymousString1, paramAnonymousString2);
                  return;
                }
              }
              go localgo = gi.ef();
              ??? = new Object[1];
              ???[0] = paramAnonymousString1;
              localgo.b("Discarded message for unknown namespace '%s'", (Object[])???);
            }
          }
        });
      }
      
      public void onApplicationDisconnected(final int paramAnonymousInt)
      {
        gi.a(gi.this, null);
        gi.b(gi.this, null);
        X(paramAnonymousInt);
        if (gi.d(gi.this) != null) {
          gi.e(gi.this).post(new Runnable()
          {
            public void run()
            {
              if (gi.d(gi.this) != null) {
                gi.d(gi.this).onApplicationDisconnected(paramAnonymousInt);
              }
            }
          });
        }
      }
    };
  }
  
  private void a(gf paramgf)
  {
    Object localObject = paramgf.dX();
    boolean bool;
    if (gj.a(localObject, this.BJ))
    {
      bool = false;
    }
    else
    {
      this.BJ = ((String)localObject);
      bool = true;
    }
    localObject = BD;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(bool);
    arrayOfObject[1] = Boolean.valueOf(this.BK);
    ((go)localObject).b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", arrayOfObject);
    if ((this.Ab != null) && ((bool) || (this.BK))) {
      this.Ab.onApplicationStatusChanged();
    }
    this.BK = false;
  }
  
  private void a(gk paramgk)
  {
    double d = paramgk.ec();
    boolean bool1;
    if ((d == (0.0D / 0.0D)) || (d == this.AM))
    {
      bool1 = false;
    }
    else
    {
      this.AM = bool1;
      bool1 = true;
    }
    boolean bool2 = paramgk.ei();
    if (bool2 != this.AN)
    {
      this.AN = bool2;
      bool1 = true;
    }
    Object localObject = BD;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(bool1);
    arrayOfObject[1] = Boolean.valueOf(this.BL);
    ((go)localObject).b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", arrayOfObject);
    if ((this.Ab != null) && ((bool1) || (this.BL))) {
      this.Ab.onVolumeChanged();
    }
    int i = paramgk.ej();
    boolean bool3;
    if (i == this.BO)
    {
      bool3 = false;
    }
    else
    {
      this.BO = i;
      bool3 = true;
    }
    go localgo = BD;
    localObject = new Object[2];
    localObject[0] = Boolean.valueOf(bool3);
    localObject[1] = Boolean.valueOf(this.BL);
    localgo.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", (Object[])localObject);
    if ((this.Ab != null) && ((bool3) || (this.BL))) {
      this.Ab.O(this.BO);
    }
    this.BL = false;
  }
  
  private void c(a.d<Cast.ApplicationConnectionResult> paramd)
  {
    synchronized (BX)
    {
      if (this.BV != null) {
        this.BV.a(new a(new Status(2002)));
      }
      this.BV = paramd;
      return;
    }
  }
  
  private void e(a.d<Status> paramd)
  {
    synchronized (BY)
    {
      if (this.BW != null) {
        paramd.a(new Status(2001));
      } else {
        this.BW = paramd;
      }
    }
  }
  
  private void ed()
  {
    BD.b("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.BH)
    {
      this.BH.clear();
      return;
    }
  }
  
  private void ee()
    throws IllegalStateException
  {
    if ((this.BM) && (!this.BN.get())) {
      return;
    }
    throw new IllegalStateException("Not connected to a device");
  }
  
  protected gm G(IBinder paramIBinder)
  {
    return gm.a.H(paramIBinder);
  }
  
  public void a(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble)))
    {
      ((gm)fo()).a(paramDouble, this.AM, this.AN);
      return;
    }
    throw new IllegalArgumentException("Volume cannot be " + paramDouble);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    go localgo = BD;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localgo.b("in onPostInitHandler; statusCode=%d", arrayOfObject);
    if ((paramInt != 0) && (paramInt != 1001))
    {
      this.BM = false;
    }
    else
    {
      this.BM = true;
      this.BK = true;
      this.BL = true;
    }
    if (paramInt == 1001)
    {
      this.BS = new Bundle();
      this.BS.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
      paramInt = 0;
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    go localgo = BD;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.BQ;
    arrayOfObject[1] = this.BR;
    localgo.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", arrayOfObject);
    this.BF.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BI);
    if (this.BQ != null)
    {
      localBundle.putString("last_application_id", this.BQ);
      if (this.BR != null) {
        localBundle.putString("last_session_id", this.BR);
      }
    }
    paramhj.a(parame, 5077000, getContext().getPackageName(), this.BG.asBinder(), localBundle);
  }
  
  public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    gj.ak(paramString);
    aj(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.BH)
    {
      this.BH.put(paramString, paramMessageReceivedCallback);
      ((gm)fo()).an(paramString);
      return;
    }
  }
  
  public void a(String paramString, LaunchOptions paramLaunchOptions, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).a(paramString, paramLaunchOptions);
  }
  
  public void a(String paramString, a.d<Status> paramd)
    throws IllegalStateException, RemoteException
  {
    e(paramd);
    ((gm)fo()).am(paramString);
  }
  
  public void a(String paramString1, String paramString2, a.d<Status> paramd)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.length() <= 65536)
      {
        gj.ak(paramString1);
        ee();
        long l = this.BP.incrementAndGet();
        ((gm)fo()).a(paramString1, paramString2, l);
        this.BT.put(Long.valueOf(l), paramd);
        return;
      }
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    throw new IllegalArgumentException("The message payload cannot be null or empty");
  }
  
  public void a(String paramString, boolean paramBoolean, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).e(paramString, paramBoolean);
  }
  
  public void aj(String paramString)
    throws IllegalArgumentException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.BH)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.BH.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
    try
    {
      ((gm)fo()).ao(paramString);
      return;
      localObject = finally;
      throw localObject;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        go localgo = BD;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = localIllegalStateException.getMessage();
        localgo.a(localIllegalStateException, "Error unregistering namespace (%s): %s", arrayOfObject);
      }
    }
  }
  
  public void b(String paramString1, String paramString2, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).h(paramString1, paramString2);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  public void d(a.d<Status> paramd)
    throws IllegalStateException, RemoteException
  {
    e(paramd);
    ((gm)fo()).ek();
  }
  
  public void disconnect()
  {
    go localgo = BD;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.BN.get());
    arrayOfObject[1] = Boolean.valueOf(isConnected());
    localgo.b("disconnect(); mDisconnecting=%b, isConnected=%b", arrayOfObject);
    if (this.BN.getAndSet(true)) {
      BD.b("mDisconnecting is set, so short-circuiting", new Object[0]);
    }
    for (;;)
    {
      return;
      ed();
      try
      {
        if ((isConnected()) || (isConnecting())) {
          ((gm)fo()).disconnect();
        }
        super.disconnect();
      }
      catch (RemoteException localRemoteException)
      {
        localgo = BD;
        arrayOfObject = new Object[1];
        arrayOfObject[0] = localRemoteException.getMessage();
        localgo.a(localRemoteException, "Error while disconnecting the controller interface: %s", arrayOfObject);
        super.disconnect();
      }
      finally
      {
        super.disconnect();
      }
    }
  }
  
  public Bundle ea()
  {
    Bundle localBundle;
    if (this.BS == null)
    {
      localBundle = super.ea();
    }
    else
    {
      localBundle = this.BS;
      this.BS = null;
    }
    return localBundle;
  }
  
  public void eb()
    throws IllegalStateException, RemoteException
  {
    ((gm)fo()).eb();
  }
  
  public double ec()
    throws IllegalStateException
  {
    ee();
    return this.AM;
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    ee();
    return this.BE;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    ee();
    return this.BJ;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    ee();
    return this.AN;
  }
  
  public void y(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((gm)fo()).a(paramBoolean, this.AM, this.AN);
  }
  
  private class b
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private b() {}
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      gi.j(gi.this);
    }
  }
  
  private static final class a
    implements Cast.ApplicationConnectionResult
  {
    private final ApplicationMetadata Cf;
    private final String Cg;
    private final boolean Ch;
    private final String rO;
    private final Status yw;
    
    public a(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public a(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.yw = paramStatus;
      this.Cf = paramApplicationMetadata;
      this.Cg = paramString1;
      this.rO = paramString2;
      this.Ch = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.Cf;
    }
    
    public String getApplicationStatus()
    {
      return this.Cg;
    }
    
    public String getSessionId()
    {
      return this.rO;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public boolean getWasLaunched()
    {
      return this.Ch;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gi
 * JD-Core Version:    0.7.0.1
 */