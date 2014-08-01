package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.f;
import com.google.android.gms.maps.model.internal.f.a;

public abstract interface d
  extends IInterface
{
  public abstract com.google.android.gms.dynamic.d f(f paramf)
    throws RemoteException;
  
  public abstract com.google.android.gms.dynamic.d g(f paramf)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }
    
    public static d az(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if ((localObject == null) || (!(localObject instanceof d))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (d)localObject;
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
      Object localObject = null;
      com.google.android.gms.dynamic.d locald;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        locald = f(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (locald != null) {
          localIBinder1 = locald.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        locald = g(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (locald != null) {
          localIBinder2 = locald.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements d
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public com.google.android.gms.dynamic.d f(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +55 -> 70
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/d$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   54: invokestatic 61	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   57: astore 4
        //   59: aload_2
        //   60: invokevirtual 64	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 64	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: areturn
        //   70: aconst_null
        //   71: astore 4
        //   73: goto -47 -> 26
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 64	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 64	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramf	f
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   24	48	4	localObject1	Object
        //   76	11	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	59	76	finally
      }
      
      /* Error */
      public com.google.android.gms.dynamic.d g(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +55 -> 70
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/d$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   54: invokestatic 61	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   57: astore 4
        //   59: aload_3
        //   60: invokevirtual 64	android/os/Parcel:recycle	()V
        //   63: aload_2
        //   64: invokevirtual 64	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: areturn
        //   70: aconst_null
        //   71: astore 4
        //   73: goto -47 -> 26
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 64	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 64	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramf	f
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   24	48	4	localObject1	Object
        //   76	11	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	59	76	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.d
 * JD-Core Version:    0.7.0.1
 */