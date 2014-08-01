package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.events.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Map;

public class r
  extends hc<aa>
{
  private final String IN;
  private final Bundle IO;
  private DriveId IP;
  private DriveId IQ;
  final GoogleApiClient.ConnectionCallbacks IR;
  Map<DriveId, Map<DriveEvent.Listener<?>, x<?>>> IS = new HashMap();
  private final String yN;
  
  public r(Context paramContext, Looper paramLooper, gz paramgz, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yN = ((String)hn.b(paramgz.fe(), "Must call Api.ClientBuilder.setAccountName()"));
    this.IN = paramgz.fi();
    this.IR = paramConnectionCallbacks;
    this.IO = paramBundle;
  }
  
  protected aa O(IBinder paramIBinder)
  {
    return aa.a.P(paramIBinder);
  }
  
  <C extends DriveEvent> PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, DriveEvent.Listener<C> paramListener)
  {
    hn.b(b.a(paramInt, paramDriveId), "id");
    hn.b(paramListener, "listener");
    hn.a(isConnected(), "Client must be connected");
    synchronized (this.IS)
    {
      Object localObject2 = (Map)this.IS.get(paramDriveId);
      if (localObject2 == null)
      {
        localObject2 = new HashMap();
        this.IS.put(paramDriveId, localObject2);
      }
      Object localObject1;
      if (((Map)localObject2).containsKey(paramListener))
      {
        localObject1 = new p.k(paramGoogleApiClient, Status.Ek);
      }
      else
      {
        localObject1 = new x(getLooper(), paramInt, paramListener);
        ((Map)localObject2).put(paramListener, localObject1);
        localObject1 = paramGoogleApiClient.b(new p.j()
        {
          protected void a(r paramAnonymousr)
            throws RemoteException
          {
            paramAnonymousr.gk().a(new AddEventListenerRequest(paramDriveId, paramInt, null), this.IV, null, new aw(this));
          }
        });
      }
    }
    return localPendingResult;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.IP = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.IQ = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    hn.f(parame);
    hn.f(str);
    hn.f(fn());
    Bundle localBundle = new Bundle();
    localBundle.putString("proxy_package_name", this.IN);
    localBundle.putAll(this.IO);
    paramhj.a(parame, 5077000, str, fn(), this.yN, localBundle);
  }
  
  /* Error */
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, DriveEvent.Listener<?> paramListener)
  {
    // Byte code:
    //   0: iload_3
    //   1: aload_2
    //   2: invokestatic 75	com/google/android/gms/drive/events/b:a	(ILcom/google/android/gms/drive/DriveId;)Z
    //   5: ldc 77
    //   7: invokestatic 80	com/google/android/gms/internal/hn:b	(ZLjava/lang/Object;)V
    //   10: aload_0
    //   11: invokevirtual 86	com/google/android/gms/drive/internal/r:isConnected	()Z
    //   14: ldc 88
    //   16: invokestatic 90	com/google/android/gms/internal/hn:a	(ZLjava/lang/Object;)V
    //   19: aload 4
    //   21: ldc 82
    //   23: invokestatic 48	com/google/android/gms/internal/hn:b	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: aload_0
    //   28: getfield 34	com/google/android/gms/drive/internal/r:IS	Ljava/util/Map;
    //   31: astore 5
    //   33: aload 5
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 34	com/google/android/gms/drive/internal/r:IS	Ljava/util/Map;
    //   40: aload_2
    //   41: invokeinterface 96 2 0
    //   46: checkcast 92	java/util/Map
    //   49: astore 7
    //   51: aload 7
    //   53: ifnonnull +22 -> 75
    //   56: new 105	com/google/android/gms/drive/internal/p$k
    //   59: dup
    //   60: aload_1
    //   61: getstatic 111	com/google/android/gms/common/api/Status:Ek	Lcom/google/android/gms/common/api/Status;
    //   64: invokespecial 114	com/google/android/gms/drive/internal/p$k:<init>	(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/common/api/Status;)V
    //   67: astore 6
    //   69: aload 5
    //   71: monitorexit
    //   72: goto +93 -> 165
    //   75: aload 7
    //   77: aload 4
    //   79: invokeinterface 205 2 0
    //   84: checkcast 116	com/google/android/gms/drive/internal/x
    //   87: astore 6
    //   89: aload 6
    //   91: ifnonnull +30 -> 121
    //   94: new 105	com/google/android/gms/drive/internal/p$k
    //   97: dup
    //   98: aload_1
    //   99: getstatic 111	com/google/android/gms/common/api/Status:Ek	Lcom/google/android/gms/common/api/Status;
    //   102: invokespecial 114	com/google/android/gms/drive/internal/p$k:<init>	(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/common/api/Status;)V
    //   105: astore 6
    //   107: aload 5
    //   109: monitorexit
    //   110: goto +55 -> 165
    //   113: astore 6
    //   115: aload 5
    //   117: monitorexit
    //   118: aload 6
    //   120: athrow
    //   121: aload 7
    //   123: invokeinterface 208 1 0
    //   128: ifeq +14 -> 142
    //   131: aload_0
    //   132: getfield 34	com/google/android/gms/drive/internal/r:IS	Ljava/util/Map;
    //   135: aload_2
    //   136: invokeinterface 205 2 0
    //   141: pop
    //   142: aload_1
    //   143: new 9	com/google/android/gms/drive/internal/r$2
    //   146: dup
    //   147: aload_0
    //   148: aload_2
    //   149: iload_3
    //   150: aload 6
    //   152: invokespecial 209	com/google/android/gms/drive/internal/r$2:<init>	(Lcom/google/android/gms/drive/internal/r;Lcom/google/android/gms/drive/DriveId;ILcom/google/android/gms/drive/internal/x;)V
    //   155: invokeinterface 131 2 0
    //   160: astore 6
    //   162: aload 5
    //   164: monitorexit
    //   165: aload 6
    //   167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	r
    //   0	168	1	paramGoogleApiClient	GoogleApiClient
    //   0	168	2	paramDriveId	DriveId
    //   0	168	3	paramInt	int
    //   0	168	4	paramListener	DriveEvent.Listener<?>
    //   31	132	5	localMap1	Map
    //   67	39	6	localObject	Object
    //   113	38	6	localx	x
    //   160	6	6	localb	com.google.android.gms.common.api.a.b
    //   49	73	7	localMap2	Map
    // Exception table:
    //   from	to	target	type
    //   36	118	113	finally
    //   121	165	113	finally
  }
  
  protected String bp()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public void disconnect()
  {
    aa localaa = (aa)fo();
    if (localaa != null) {}
    try
    {
      localaa.a(new DisconnectRequest());
      label25:
      super.disconnect();
      this.IS.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label25;
    }
  }
  
  public aa gk()
  {
    return (aa)fo();
  }
  
  public DriveId gl()
  {
    return this.IP;
  }
  
  public DriveId gm()
  {
    return this.IQ;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.r
 * JD-Core Version:    0.7.0.1
 */