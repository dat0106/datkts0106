package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface gc
  extends IInterface
{
  public abstract void L(int paramInt)
    throws RemoteException;
  
  public abstract void a(int paramInt, DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void b(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void dO()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements gc
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
    }
    
    public static gc E(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        if ((localObject == null) || (!(localObject instanceof gc))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (gc)localObject;
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
      DataHolder localDataHolder = null;
      int i;
      switch (paramInt1)
      {
      default: 
        boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localDataHolder = DataHolder.CREATOR.x(paramParcel1);
        }
        a(i, localDataHolder);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        if (paramParcel1.readInt() != 0) {
          localDataHolder = DataHolder.CREATOR.x(paramParcel1);
        }
        a(localDataHolder);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        b(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        dO();
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        L(paramParcel1.readInt());
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        i = 1;
      }
      return i;
    }
    
    private static class a
      implements gc
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void L(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
          localParcel1.writeInt(paramInt);
          this.ko.transact(5005, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void a(int paramInt, DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload 4
        //   18: iload_1
        //   19: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   22: aload_2
        //   23: ifnull +47 -> 70
        //   26: aload 4
        //   28: iconst_1
        //   29: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   32: aload_2
        //   33: aload 4
        //   35: iconst_0
        //   36: invokevirtual 56	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/internal/gc$a$a:ko	Landroid/os/IBinder;
        //   43: sipush 5001
        //   46: aload 4
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 43 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 46	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 49	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: invokevirtual 49	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 4
        //   72: iconst_0
        //   73: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   76: goto -37 -> 39
        //   79: astore 5
        //   81: aload_3
        //   82: invokevirtual 49	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: invokevirtual 49	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	a
        //   0	93	1	paramInt	int
        //   0	93	2	paramDataHolder	DataHolder
        //   8	74	3	localParcel1	Parcel
        //   3	83	4	localParcel2	Parcel
        //   79	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	79	finally
        //   70	76	79	finally
      }
      
      /* Error */
      public void a(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 56	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/gc$a$a:ko	Landroid/os/IBinder;
        //   33: sipush 5002
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 43 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 46	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 49	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 49	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 49	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
          localParcel2.writeInt(paramInt1);
          localParcel2.writeInt(paramInt2);
          this.ko.transact(5003, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void dO()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
          this.ko.transact(5004, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.internal.gc
 * JD-Core Version:    0.7.0.1
 */