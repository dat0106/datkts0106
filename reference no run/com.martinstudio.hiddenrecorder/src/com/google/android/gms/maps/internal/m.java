package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.f;
import com.google.android.gms.maps.model.internal.f.a;

public abstract interface m
  extends IInterface
{
  public abstract void b(f paramf)
    throws RemoteException;
  
  public abstract void c(f paramf)
    throws RemoteException;
  
  public abstract void d(f paramf)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements m
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }
    
    public static m aL(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
        if ((localObject == null) || (!(localObject instanceof m))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (m)localObject;
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
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
        b(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
        d(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
        c(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
      }
      return bool;
    }
    
    private static class a
      implements m
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
      public void b(f paramf)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/m$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramf	f
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public void c(f paramf)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/m$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_3
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramf	f
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public void d(f paramf)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/m$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramf	f
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.m
 * JD-Core Version:    0.7.0.1
 */