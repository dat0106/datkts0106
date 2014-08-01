package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface s
  extends IInterface
{
  public abstract void g(d paramd)
    throws RemoteException;
  
  public abstract void onSnapshotReady(Bitmap paramBitmap)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements s
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }
    
    public static s aS(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        if ((localObject == null) || (!(localObject instanceof s))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (s)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        Bitmap localBitmap;
        if (paramParcel1.readInt() == 0) {
          localBitmap = null;
        } else {
          localBitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);
        }
        onSnapshotReady(localBitmap);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        g(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements s
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
      public void g(d paramd)
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
        //   33: getfield 18	com/google/android/gms/maps/internal/s$a$a:ko	Landroid/os/IBinder;
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
        //   0	78	1	paramd	d
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public void onSnapshotReady(Bitmap paramBitmap)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 32
        //   13: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 61	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 67	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/maps/internal/s$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_1
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 49 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 52	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 55	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 61	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 55	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramBitmap	Bitmap
        //   71	11	2	localObject	Object
        //   8	65	3	localParcel1	Parcel
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.s
 * JD-Core Version:    0.7.0.1
 */