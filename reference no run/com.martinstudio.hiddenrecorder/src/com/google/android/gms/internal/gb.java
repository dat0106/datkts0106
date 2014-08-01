package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;

public final class gb
  extends hc<gd>
{
  private final String yN;
  
  public gb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yN = ((String)hn.f(paramString));
  }
  
  protected gd D(IBinder paramIBinder)
  {
    return gd.a.F(paramIBinder);
  }
  
  public void a(a.d<AppStateManager.StateListResult> paramd)
  {
    try
    {
      ((gd)fo()).a(new c(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  public void a(a.d<AppStateManager.StateDeletedResult> paramd, int paramInt)
  {
    try
    {
      ((gd)fo()).b(new a(paramd), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      ((gd)fo()).a(new e(paramd), paramInt, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = localObject)
    {
      try
      {
        ((gd)fo()).a((gc)localObject, paramInt, paramArrayOfByte);
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("AppStateClient", "service died");
      }
      localObject = new e(paramd);
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.a(parame, 5077000, getContext().getPackageName(), this.yN, fn());
  }
  
  public void b(a.d<Status> paramd)
  {
    try
    {
      ((gd)fo()).b(new g(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  public void b(a.d<AppStateManager.StateResult> paramd, int paramInt)
  {
    try
    {
      ((gd)fo()).a(new e(paramd), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  protected void b(String... paramVarArgs)
  {
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      Object[] arrayOfObject;
      if (i >= paramVarArgs.length)
      {
        arrayOfObject = new Object[1];
        arrayOfObject[0] = "https://www.googleapis.com/auth/appstate";
        hn.a(bool, String.format("App State APIs requires %s to function.", arrayOfObject));
        return;
      }
      if (paramVarArgs[arrayOfObject].equals("https://www.googleapis.com/auth/appstate")) {
        bool = true;
      }
      arrayOfObject++;
    }
  }
  
  protected String bp()
  {
    return "com.google.android.gms.appstate.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.appstate.internal.IAppStateService";
  }
  
  public int dP()
  {
    try
    {
      i = ((gd)fo()).dP();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
        int i = 2;
      }
    }
    return i;
  }
  
  public int dQ()
  {
    try
    {
      i = ((gd)fo()).dQ();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("AppStateClient", "service died");
        int i = 2;
      }
    }
    return i;
  }
  
  private static final class b
    implements AppStateManager.StateDeletedResult
  {
    private final int yP;
    private final Status yw;
    
    public b(Status paramStatus, int paramInt)
    {
      this.yw = paramStatus;
      this.yP = paramInt;
    }
    
    public int getStateKey()
    {
      return this.yP;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class d
    extends b
    implements AppStateManager.StateListResult
  {
    private final AppStateBuffer yQ;
    
    public d(DataHolder paramDataHolder)
    {
      super();
      this.yQ = new AppStateBuffer(paramDataHolder);
    }
    
    public AppStateBuffer getStateBuffer()
    {
      return this.yQ;
    }
  }
  
  private static final class f
    extends b
    implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult
  {
    private final int yP;
    private final AppStateBuffer yQ;
    
    public f(int paramInt, DataHolder paramDataHolder)
    {
      super();
      this.yP = paramInt;
      this.yQ = new AppStateBuffer(paramDataHolder);
    }
    
    private boolean dR()
    {
      boolean bool;
      if (this.yw.getStatusCode() != 2000) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public AppStateManager.StateConflictResult getConflictResult()
    {
      if (!dR()) {
        this = null;
      }
      return this;
    }
    
    public AppStateManager.StateLoadedResult getLoadedResult()
    {
      if (dR()) {
        this = null;
      }
      return this;
    }
    
    public byte[] getLocalData()
    {
      byte[] arrayOfByte;
      if (this.yQ.getCount() != 0) {
        arrayOfByte = this.yQ.get(0).getLocalData();
      } else {
        arrayOfByte = null;
      }
      return arrayOfByte;
    }
    
    public String getResolvedVersion()
    {
      String str;
      if (this.yQ.getCount() != 0) {
        str = this.yQ.get(0).getConflictVersion();
      } else {
        str = null;
      }
      return str;
    }
    
    public byte[] getServerData()
    {
      byte[] arrayOfByte;
      if (this.yQ.getCount() != 0) {
        arrayOfByte = this.yQ.get(0).getConflictData();
      } else {
        arrayOfByte = null;
      }
      return arrayOfByte;
    }
    
    public int getStateKey()
    {
      return this.yP;
    }
    
    public void release()
    {
      this.yQ.close();
    }
  }
  
  private static final class g
    extends ga
  {
    private final a.d<Status> yO;
    
    public g(a.d<Status> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Holder must not be null"));
    }
    
    public void dO()
    {
      Status localStatus = new Status(0);
      this.yO.a(localStatus);
    }
  }
  
  private static final class a
    extends ga
  {
    private final a.d<AppStateManager.StateDeletedResult> yO;
    
    public a(a.d<AppStateManager.StateDeletedResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      Status localStatus = new Status(paramInt1);
      this.yO.a(new gb.b(localStatus, paramInt2));
    }
  }
  
  private static final class c
    extends ga
  {
    private final a.d<AppStateManager.StateListResult> yO;
    
    public c(a.d<AppStateManager.StateListResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder)
    {
      this.yO.a(new gb.d(paramDataHolder));
    }
  }
  
  private static final class e
    extends ga
  {
    private final a.d<AppStateManager.StateResult> yO;
    
    public e(a.d<AppStateManager.StateResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void a(int paramInt, DataHolder paramDataHolder)
    {
      this.yO.a(new gb.f(paramInt, paramDataHolder));
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gb
 * JD-Core Version:    0.7.0.1
 */