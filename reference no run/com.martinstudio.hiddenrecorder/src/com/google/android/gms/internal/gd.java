package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface gd
  extends IInterface
{
  public abstract void a(gc paramgc)
    throws RemoteException;
  
  public abstract void a(gc paramgc, int paramInt)
    throws RemoteException;
  
  public abstract void a(gc paramgc, int paramInt, String paramString, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void a(gc paramgc, int paramInt, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void b(gc paramgc)
    throws RemoteException;
  
  public abstract void b(gc paramgc, int paramInt)
    throws RemoteException;
  
  public abstract void c(gc paramgc)
    throws RemoteException;
  
  public abstract int dP()
    throws RemoteException;
  
  public abstract int dQ()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements gd
  {
    public static gd F(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
        if ((localObject == null) || (!(localObject instanceof gd))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (gd)localObject;
        }
      }
      else
      {
        localObject = null;
      }
      return localObject;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = true;
      int i;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        i = dP();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        i = dQ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        a(gc.a.E(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        a(gc.a.E(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        a(gc.a.E(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5006: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        a(gc.a.E(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        break;
      case 5007: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        b(gc.a.E(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5008: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        b(gc.a.E(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5009: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
        c(gc.a.E(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
      }
      return bool;
    }
    
    private static class a
      implements gd
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(gc paramgc)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   36: sipush 5005
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 48 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 51	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 54	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 54	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 54	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 54	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramgc	gc
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void a(gc paramgc, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 39 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: iload_2
        //   35: invokevirtual 59	android/os/Parcel:writeInt	(I)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   42: sipush 5004
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 48 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 51	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 54	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 54	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 54	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 54	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramgc	gc
        //   0	90	2	paramInt	int
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void a(gc paramgc, int paramInt, String paramString, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: iload_2
        //   39: invokevirtual 59	android/os/Parcel:writeInt	(I)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 63	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 67	android/os/Parcel:writeByteArray	([B)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   59: sipush 5006
        //   62: aload 6
        //   64: aload 5
        //   66: iconst_0
        //   67: invokeinterface 48 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 51	android/os/Parcel:readException	()V
        //   78: aload 5
        //   80: invokevirtual 54	android/os/Parcel:recycle	()V
        //   83: aload 6
        //   85: invokevirtual 54	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 5
        //   99: invokevirtual 54	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 54	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	a
        //   0	110	1	paramgc	gc
        //   0	110	2	paramInt	int
        //   0	110	3	paramString	String
        //   0	110	4	paramArrayOfByte	byte[]
        //   8	90	5	localParcel1	Parcel
        //   3	100	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(gc paramgc, int paramInt, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: iload_2
        //   39: invokevirtual 59	android/os/Parcel:writeInt	(I)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 67	android/os/Parcel:writeByteArray	([B)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   52: sipush 5003
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 48 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 51	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 54	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 54	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 54	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 54	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	a
        //   0	103	1	paramgc	gc
        //   0	103	2	paramInt	int
        //   0	103	3	paramArrayOfByte	byte[]
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void b(gc paramgc)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   36: sipush 5008
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 48 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 51	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 54	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 54	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 54	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 54	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramgc	gc
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void b(gc paramgc, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 39 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: iload_2
        //   35: invokevirtual 59	android/os/Parcel:writeInt	(I)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   42: sipush 5007
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 48 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 51	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 54	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 54	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 54	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 54	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramgc	gc
        //   0	90	2	paramInt	int
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void c(gc paramgc)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/gd$a$a:ko	Landroid/os/IBinder;
        //   36: sipush 5009
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 48 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 51	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 54	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 54	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 54	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 54	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramgc	gc
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public int dP()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
          this.ko.transact(5001, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int dQ()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
          this.ko.transact(5002, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
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
 * Qualified Name:     com.google.android.gms.internal.gd
 * JD-Core Version:    0.7.0.1
 */