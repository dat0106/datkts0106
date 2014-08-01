package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface bv
  extends IInterface
{
  public abstract void a(d paramd, aj paramaj, String paramString, bw parambw)
    throws RemoteException;
  
  public abstract void a(d paramd, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException;
  
  public abstract void a(d paramd, am paramam, aj paramaj, String paramString, bw parambw)
    throws RemoteException;
  
  public abstract void a(d paramd, am paramam, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException;
  
  public abstract void destroy()
    throws RemoteException;
  
  public abstract d getView()
    throws RemoteException;
  
  public abstract void pause()
    throws RemoteException;
  
  public abstract void resume()
    throws RemoteException;
  
  public abstract void showInterstitial()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements bv
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }
    
    public static bv j(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        if ((localObject == null) || (!(localObject instanceof bv))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (bv)localObject;
        }
      }
      else
      {
        localObject = null;
      }
      return localObject;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject1 = null;
      Object localObject3;
      Object localObject2;
      int k;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald1 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = am.CREATOR.c(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = aj.CREATOR.b(paramParcel1);
        }
        a(locald1, (am)localObject3, (aj)localObject2, paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        localObject2 = getView();
        paramParcel2.writeNoException();
        IBinder localIBinder;
        if (localObject2 != null) {
          localIBinder = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        localObject2 = d.a.ag(paramParcel1.readStrongBinder());
        aj localaj1;
        if (paramParcel1.readInt() != 0) {
          localaj1 = aj.CREATOR.b(paramParcel1);
        }
        a((d)localObject2, localaj1, paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        showInterstitial();
        paramParcel2.writeNoException();
        k = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        destroy();
        paramParcel2.writeNoException();
        k = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        d locald2 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = am.CREATOR.c(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = aj.CREATOR.b(paramParcel1);
        }
        a(locald2, (am)localObject2, (aj)localObject3, paramParcel1.readString(), paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int m = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        localObject2 = d.a.ag(paramParcel1.readStrongBinder());
        aj localaj2;
        if (paramParcel1.readInt() == 0) {
          localaj2 = null;
        } else {
          localaj2 = aj.CREATOR.b(paramParcel1);
        }
        a((d)localObject2, localaj2, paramParcel1.readString(), paramParcel1.readString(), bw.a.k(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        pause();
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        resume();
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements bv
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(d paramd, aj paramaj, String paramString, bw parambw)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +94 -> 115
        //   24: aload_1
        //   25: invokeinterface 39 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +81 -> 121
        //   43: aload 5
        //   45: iconst_1
        //   46: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   49: aload_2
        //   50: aload 5
        //   52: iconst_0
        //   53: invokevirtual 52	com/google/android/gms/internal/aj:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload 5
        //   58: aload_3
        //   59: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload 4
        //   64: ifnull +12 -> 76
        //   67: aload 4
        //   69: invokeinterface 58 1 0
        //   74: astore 7
        //   76: aload 5
        //   78: aload 7
        //   80: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   83: aload_0
        //   84: getfield 18	com/google/android/gms/internal/bv$a$a:ko	Landroid/os/IBinder;
        //   87: iconst_3
        //   88: aload 5
        //   90: aload 6
        //   92: iconst_0
        //   93: invokeinterface 64 5 0
        //   98: pop
        //   99: aload 6
        //   101: invokevirtual 67	android/os/Parcel:readException	()V
        //   104: aload 6
        //   106: invokevirtual 70	android/os/Parcel:recycle	()V
        //   109: aload 5
        //   111: invokevirtual 70	android/os/Parcel:recycle	()V
        //   114: return
        //   115: aconst_null
        //   116: astore 8
        //   118: goto -86 -> 32
        //   121: aload 5
        //   123: iconst_0
        //   124: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   127: goto -71 -> 56
        //   130: astore 7
        //   132: aload 6
        //   134: invokevirtual 70	android/os/Parcel:recycle	()V
        //   137: aload 5
        //   139: invokevirtual 70	android/os/Parcel:recycle	()V
        //   142: aload 7
        //   144: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	a
        //   0	145	1	paramd	d
        //   0	145	2	paramaj	aj
        //   0	145	3	paramString	String
        //   0	145	4	parambw	bw
        //   6	132	5	localParcel1	Parcel
        //   11	122	6	localParcel2	Parcel
        //   1	78	7	localIBinder1	IBinder
        //   130	13	7	localObject	Object
        //   30	87	8	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	104	130	finally
        //   121	127	130	finally
      }
      
      /* Error */
      public void a(d paramd, aj paramaj, String paramString1, String paramString2, bw parambw)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 8
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +102 -> 123
        //   24: aload_1
        //   25: invokeinterface 39 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +89 -> 129
        //   43: aload 6
        //   45: iconst_1
        //   46: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   49: aload_2
        //   50: aload 6
        //   52: iconst_0
        //   53: invokevirtual 52	com/google/android/gms/internal/aj:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload 6
        //   58: aload_3
        //   59: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload 6
        //   64: aload 4
        //   66: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   69: aload 5
        //   71: ifnull +12 -> 83
        //   74: aload 5
        //   76: invokeinterface 58 1 0
        //   81: astore 8
        //   83: aload 6
        //   85: aload 8
        //   87: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   90: aload_0
        //   91: getfield 18	com/google/android/gms/internal/bv$a$a:ko	Landroid/os/IBinder;
        //   94: bipush 7
        //   96: aload 6
        //   98: aload 7
        //   100: iconst_0
        //   101: invokeinterface 64 5 0
        //   106: pop
        //   107: aload 7
        //   109: invokevirtual 67	android/os/Parcel:readException	()V
        //   112: aload 7
        //   114: invokevirtual 70	android/os/Parcel:recycle	()V
        //   117: aload 6
        //   119: invokevirtual 70	android/os/Parcel:recycle	()V
        //   122: return
        //   123: aconst_null
        //   124: astore 9
        //   126: goto -94 -> 32
        //   129: aload 6
        //   131: iconst_0
        //   132: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   135: goto -79 -> 56
        //   138: astore 8
        //   140: aload 7
        //   142: invokevirtual 70	android/os/Parcel:recycle	()V
        //   145: aload 6
        //   147: invokevirtual 70	android/os/Parcel:recycle	()V
        //   150: aload 8
        //   152: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	153	0	this	a
        //   0	153	1	paramd	d
        //   0	153	2	paramaj	aj
        //   0	153	3	paramString1	String
        //   0	153	4	paramString2	String
        //   0	153	5	parambw	bw
        //   6	140	6	localParcel1	Parcel
        //   11	130	7	localParcel2	Parcel
        //   1	85	8	localIBinder1	IBinder
        //   138	13	8	localObject	Object
        //   30	95	9	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	112	138	finally
        //   129	135	138	finally
      }
      
      public void a(d paramd, am paramam, aj paramaj, String paramString, bw parambw)
        throws RemoteException
      {
        IBinder localIBinder1 = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label163:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder localIBinder2;
            if (paramd != null)
            {
              localIBinder2 = paramd.asBinder();
              localParcel1.writeStrongBinder(localIBinder2);
              if (paramam != null)
              {
                localParcel1.writeInt(1);
                paramam.writeToParcel(localParcel1, 0);
                if (paramaj == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramaj.writeToParcel(localParcel1, 0);
                localParcel1.writeString(paramString);
                if (parambw != null) {
                  localIBinder1 = parambw.asBinder();
                }
                localParcel1.writeStrongBinder(localIBinder1);
                this.ko.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder2 = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(d paramd, am paramam, aj paramaj, String paramString1, String paramString2, bw parambw)
        throws RemoteException
      {
        IBinder localIBinder1 = null;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        label171:
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            IBinder localIBinder2;
            if (paramd != null)
            {
              localIBinder2 = paramd.asBinder();
              localParcel2.writeStrongBinder(localIBinder2);
              if (paramam != null)
              {
                localParcel2.writeInt(1);
                paramam.writeToParcel(localParcel2, 0);
                if (paramaj == null) {
                  break label171;
                }
                localParcel2.writeInt(1);
                paramaj.writeToParcel(localParcel2, 0);
                localParcel2.writeString(paramString1);
                localParcel2.writeString(paramString2);
                if (parambw != null) {
                  localIBinder1 = parambw.asBinder();
                }
                localParcel2.writeStrongBinder(localIBinder1);
                this.ko.transact(6, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localIBinder2 = null;
              continue;
            }
            localParcel2.writeInt(0);
            continue;
            localParcel2.writeInt(0);
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void destroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.ko.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public d getView()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.ko.transact(2, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void pause()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.ko.transact(8, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void resume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.ko.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void showInterstitial()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bv
 * JD-Core Version:    0.7.0.1
 */