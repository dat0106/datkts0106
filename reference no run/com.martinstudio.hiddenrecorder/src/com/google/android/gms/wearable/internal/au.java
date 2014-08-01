package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hj;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class au
  extends hc<ad>
{
  private final ExecutorService agR = Executors.newCachedThreadPool();
  private final HashMap<DataApi.DataListener, av> amb = new HashMap();
  private final HashMap<MessageApi.MessageListener, av> amc = new HashMap();
  private final HashMap<NodeApi.NodeListener, av> amd = new HashMap();
  
  public au(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
  }
  
  private FutureTask<Boolean> a(final ParcelFileDescriptor paramParcelFileDescriptor, final byte[] paramArrayOfByte)
  {
    new FutureTask(new Callable()
    {
      /* Error */
      public Boolean no()
      {
        // Byte code:
        //   0: ldc 41
        //   2: iconst_3
        //   3: invokestatic 47	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   6: ifeq +31 -> 37
        //   9: ldc 41
        //   11: new 49	java/lang/StringBuilder
        //   14: dup
        //   15: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   18: ldc 52
        //   20: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: aload_0
        //   24: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   27: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   30: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   33: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   36: pop
        //   37: new 69	android/os/ParcelFileDescriptor$AutoCloseOutputStream
        //   40: dup
        //   41: aload_0
        //   42: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   45: invokespecial 72	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
        //   48: astore_1
        //   49: aload_1
        //   50: aload_0
        //   51: getfield 26	com/google/android/gms/wearable/internal/au$11:yI	[B
        //   54: invokevirtual 76	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
        //   57: aload_1
        //   58: invokevirtual 79	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
        //   61: ldc 41
        //   63: iconst_3
        //   64: invokestatic 47	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   67: ifeq +31 -> 98
        //   70: ldc 41
        //   72: new 49	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   79: ldc 81
        //   81: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   84: aload_0
        //   85: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   88: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   91: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   94: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   97: pop
        //   98: iconst_1
        //   99: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   102: astore_2
        //   103: aload_2
        //   104: astore_2
        //   105: ldc 41
        //   107: iconst_3
        //   108: invokestatic 47	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   111: ifeq +31 -> 142
        //   114: ldc 41
        //   116: new 49	java/lang/StringBuilder
        //   119: dup
        //   120: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   123: ldc 89
        //   125: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: aload_0
        //   129: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   132: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   135: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   138: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   141: pop
        //   142: aload_1
        //   143: invokevirtual 92	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   146: aload_2
        //   147: areturn
        //   148: pop
        //   149: ldc 41
        //   151: new 49	java/lang/StringBuilder
        //   154: dup
        //   155: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   158: ldc 94
        //   160: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   163: aload_0
        //   164: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   167: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   170: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   173: invokestatic 97	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
        //   176: pop
        //   177: ldc 41
        //   179: iconst_3
        //   180: invokestatic 47	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   183: ifeq +31 -> 214
        //   186: ldc 41
        //   188: new 49	java/lang/StringBuilder
        //   191: dup
        //   192: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   195: ldc 89
        //   197: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: aload_0
        //   201: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   204: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   207: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   210: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   213: pop
        //   214: aload_1
        //   215: invokevirtual 92	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   218: iconst_0
        //   219: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   222: astore_2
        //   223: goto -77 -> 146
        //   226: astore_2
        //   227: ldc 41
        //   229: iconst_3
        //   230: invokestatic 47	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   233: ifeq +31 -> 264
        //   236: ldc 41
        //   238: new 49	java/lang/StringBuilder
        //   241: dup
        //   242: invokespecial 50	java/lang/StringBuilder:<init>	()V
        //   245: ldc 89
        //   247: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   250: aload_0
        //   251: getfield 24	com/google/android/gms/wearable/internal/au$11:amg	Landroid/os/ParcelFileDescriptor;
        //   254: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   257: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   260: invokestatic 67	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   263: pop
        //   264: aload_1
        //   265: invokevirtual 92	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   268: aload_2
        //   269: athrow
        //   270: pop
        //   271: goto -3 -> 268
        //   274: pop
        //   275: goto -57 -> 218
        //   278: pop
        //   279: goto -133 -> 146
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	282	0	this	11
        //   48	217	1	localAutoCloseOutputStream	android.os.ParcelFileDescriptor.AutoCloseOutputStream
        //   102	121	2	localBoolean	Boolean
        //   226	43	2	localObject	Object
        //   148	1	4	localIOException1	IOException
        //   270	1	5	localIOException2	IOException
        //   274	1	6	localIOException3	IOException
        //   278	1	7	localIOException4	IOException
        // Exception table:
        //   from	to	target	type
        //   49	103	148	java/io/IOException
        //   49	103	226	finally
        //   149	177	226	finally
        //   227	268	270	java/io/IOException
        //   177	218	274	java/io/IOException
        //   105	146	278	java/io/IOException
      }
    });
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", "onPostInitHandler: statusCode " + paramInt);
    }
    ad localad;
    Object localObject1;
    Object localObject2;
    if (paramInt == 0) {
      try
      {
        a local1 = new a()
        {
          public void a(Status paramAnonymousStatus) {}
        };
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: service " + paramIBinder);
        }
        localad = ad.a.by(paramIBinder);
        localObject1 = this.amb.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: adding Data listener " + ((Map.Entry)localObject2).getValue());
          }
          localad.a(local1, new b((av)((Map.Entry)localObject2).getValue()));
          continue;
          Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: done");
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: error while adding listener", localRemoteException);
      }
    }
    for (;;)
    {
      super.a(paramInt, paramIBinder, paramBundle);
      return;
      localObject2 = this.amc.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: adding Message listener " + ((Map.Entry)localObject1).getValue());
        }
        localad.a(localRemoteException, new b((av)((Map.Entry)localObject1).getValue()));
      }
      localObject1 = this.amd.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (Log.isLoggable("WearableClient", 2)) {
          Log.d("WearableClient", "onPostInitHandler: adding Node listener " + ((Map.Entry)localObject2).getValue());
        }
        localad.a(localRemoteException, new b((av)((Map.Entry)localObject2).getValue()));
      }
    }
  }
  
  public void a(final a.d<DataApi.DataItemResult> paramd, Uri paramUri)
    throws RemoteException
  {
    ((ad)fo()).a(new a()
    {
      public void a(v paramAnonymousv)
      {
        paramd.a(new f.a(new Status(paramAnonymousv.statusCode), paramAnonymousv.alL));
      }
    }, paramUri);
  }
  
  public void a(final a.d<DataApi.GetFdForAssetResult> paramd, Asset paramAsset)
    throws RemoteException
  {
    ((ad)fo()).a(new a()
    {
      public void a(x paramAnonymousx)
      {
        paramd.a(new f.c(new Status(paramAnonymousx.statusCode), paramAnonymousx.alM));
      }
    }, paramAsset);
  }
  
  public void a(a.d<Status> paramd, DataApi.DataListener paramDataListener)
    throws RemoteException
  {
    for (;;)
    {
      synchronized (this.amb)
      {
        ac localac1 = (ac)this.amb.remove(paramDataListener);
        if (localac1 == null)
        {
          paramd.a(new Status(4002));
          return;
        }
      }
      a(paramd, localac2);
    }
  }
  
  public void a(final a.d<Status> paramd, final DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    av localav = av.a(paramDataListener, paramArrayOfIntentFilter);
    synchronized (this.amb)
    {
      if (this.amb.get(paramDataListener) != null)
      {
        paramd.a(new Status(4001));
      }
      else
      {
        this.amb.put(paramDataListener, localav);
        ((ad)fo()).a(new a()new b
        {
          public void a(Status paramAnonymousStatus)
          {
            if (!paramAnonymousStatus.isSuccess()) {}
            synchronized (au.b(au.this))
            {
              au.b(au.this).remove(paramDataListener);
              paramd.a(paramAnonymousStatus);
              return;
            }
          }
        }, new b(localav));
      }
    }
  }
  
  public void a(a.d<DataApi.GetFdForAssetResult> paramd, DataItemAsset paramDataItemAsset)
    throws RemoteException
  {
    a(paramd, Asset.createFromRef(paramDataItemAsset.getId()));
  }
  
  public void a(a.d<Status> paramd, MessageApi.MessageListener paramMessageListener)
    throws RemoteException
  {
    synchronized (this.amc)
    {
      ac localac = (ac)this.amc.remove(paramMessageListener);
      if (localac == null)
      {
        paramd.a(new Status(4002));
        return;
      }
      a(paramd, localac);
    }
  }
  
  public void a(final a.d<Status> paramd, final MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    av localav = av.a(paramMessageListener, paramArrayOfIntentFilter);
    synchronized (this.amc)
    {
      if (this.amc.get(paramMessageListener) != null)
      {
        paramd.a(new Status(4001));
      }
      else
      {
        this.amc.put(paramMessageListener, localav);
        ((ad)fo()).a(new a()new b
        {
          public void a(Status paramAnonymousStatus)
          {
            if (!paramAnonymousStatus.isSuccess()) {}
            synchronized (au.c(au.this))
            {
              au.c(au.this).remove(paramMessageListener);
              paramd.a(paramAnonymousStatus);
              return;
            }
          }
        }, new b(localav));
      }
    }
  }
  
  public void a(final a.d<Status> paramd, final NodeApi.NodeListener paramNodeListener)
    throws RemoteException, RemoteException
  {
    av localav = av.a(paramNodeListener);
    synchronized (this.amd)
    {
      if (this.amd.get(paramNodeListener) != null)
      {
        paramd.a(new Status(4001));
      }
      else
      {
        this.amd.put(paramNodeListener, localav);
        ((ad)fo()).a(new a()new b
        {
          public void a(Status paramAnonymousStatus)
          {
            if (!paramAnonymousStatus.isSuccess()) {}
            synchronized (au.d(au.this))
            {
              au.d(au.this).remove(paramNodeListener);
              paramd.a(paramAnonymousStatus);
              return;
            }
          }
        }, new b(localav));
      }
    }
  }
  
  public void a(a.d<DataApi.DataItemResult> paramd, PutDataRequest paramPutDataRequest)
    throws RemoteException
  {
    Iterator localIterator = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Asset)((Map.Entry)localIterator.next()).getValue();
      if ((((Asset)localObject1).getData() == null) && (((Asset)localObject1).getDigest() == null) && (((Asset)localObject1).getFd() == null) && (((Asset)localObject1).getUri() == null)) {
        throw new IllegalArgumentException("Put for " + paramPutDataRequest.getUri() + " contains invalid asset: " + localObject1);
      }
    }
    PutDataRequest localPutDataRequest = PutDataRequest.j(paramPutDataRequest.getUri());
    localPutDataRequest.setData(paramPutDataRequest.getData());
    Object localObject1 = new ArrayList();
    localIterator = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = (Asset)localEntry.getValue();
      if (((Asset)localObject2).getData() == null) {
        localPutDataRequest.putAsset((String)localEntry.getKey(), (Asset)localEntry.getValue());
      } else {
        try
        {
          ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3)) {
            Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + localObject2 + " read:" + arrayOfParcelFileDescriptor[0] + " write:" + arrayOfParcelFileDescriptor[1]);
          }
          localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromFd(arrayOfParcelFileDescriptor[0]));
          localObject2 = a(arrayOfParcelFileDescriptor[1], ((Asset)localObject2).getData());
          ((List)localObject1).add(localObject2);
          this.agR.submit((Runnable)localObject2);
        }
        catch (IOException localIOException)
        {
          throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, localIOException);
        }
      }
    }
    try
    {
      ((ad)fo()).a(new a(paramd, (List)localObject1), localPutDataRequest);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new IllegalStateException("Unable to putDataItem: " + paramPutDataRequest, localNullPointerException);
    }
  }
  
  public void a(final a.d<Status> paramd, ac paramac)
    throws RemoteException
  {
    ((ad)fo()).a(new a()new ao
    {
      public void a(Status paramAnonymousStatus)
      {
        paramd.a(paramAnonymousStatus);
      }
    }, new ao(paramac));
  }
  
  public void a(final a.d<MessageApi.SendMessageResult> paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    ((ad)fo()).a(new a()
    {
      public void a(aq paramAnonymousaq)
      {
        paramd.a(new ae.a(new Status(paramAnonymousaq.statusCode), paramAnonymousaq.alZ));
      }
    }, paramString1, paramString2, paramArrayOfByte);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.e(parame, 5077000, getContext().getPackageName());
  }
  
  public void b(final a.d<DataItemBuffer> paramd, Uri paramUri)
    throws RemoteException
  {
    ((ad)fo()).b(new a()
    {
      public void Z(DataHolder paramAnonymousDataHolder)
      {
        paramd.a(new DataItemBuffer(paramAnonymousDataHolder));
      }
    }, paramUri);
  }
  
  public void b(a.d<Status> paramd, NodeApi.NodeListener paramNodeListener)
    throws RemoteException
  {
    synchronized (this.amd)
    {
      ac localac = (ac)this.amd.remove(paramNodeListener);
      if (localac == null)
      {
        paramd.a(new Status(4002));
        return;
      }
      a(paramd, localac);
    }
  }
  
  protected String bp()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  protected ad bz(IBinder paramIBinder)
  {
    return ad.a.by(paramIBinder);
  }
  
  public void c(final a.d<DataApi.DeleteDataItemsResult> paramd, Uri paramUri)
    throws RemoteException
  {
    ((ad)fo()).c(new a()
    {
      public void a(p paramAnonymousp)
      {
        paramd.a(new f.b(new Status(paramAnonymousp.statusCode), paramAnonymousp.alI));
      }
    }, paramUri);
  }
  
  public void disconnect()
  {
    super.disconnect();
    this.amb.clear();
    this.amc.clear();
    this.amd.clear();
  }
  
  public void o(final a.d<DataItemBuffer> paramd)
    throws RemoteException
  {
    ((ad)fo()).d(new a()
    {
      public void Z(DataHolder paramAnonymousDataHolder)
      {
        paramd.a(new DataItemBuffer(paramAnonymousDataHolder));
      }
    });
  }
  
  public void p(final a.d<NodeApi.GetLocalNodeResult> paramd)
    throws RemoteException
  {
    ((ad)fo()).e(new a()
    {
      public void a(z paramAnonymousz)
      {
        paramd.a(new ah.b(new Status(paramAnonymousz.statusCode), paramAnonymousz.alN));
      }
    });
  }
  
  public void q(final a.d<NodeApi.GetConnectedNodesResult> paramd)
    throws RemoteException
  {
    ((ad)fo()).f(new a()
    {
      public void a(t paramAnonymoust)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(paramAnonymoust.alK);
        paramd.a(new ah.a(new Status(paramAnonymoust.statusCode), localArrayList));
      }
    });
  }
  
  private static class a
    extends a
  {
    private final List<FutureTask<Boolean>> amh;
    private final a.d<DataApi.DataItemResult> yO;
    
    a(a.d<DataApi.DataItemResult> paramd, List<FutureTask<Boolean>> paramList)
    {
      this.yO = paramd;
      this.amh = paramList;
    }
    
    public void a(am paramam)
    {
      this.yO.a(new f.a(new Status(paramam.statusCode), paramam.alL));
      Iterator localIterator;
      if (paramam.statusCode != 0) {
        localIterator = this.amh.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((FutureTask)localIterator.next()).cancel(true);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.au
 * JD-Core Version:    0.7.0.1
 */