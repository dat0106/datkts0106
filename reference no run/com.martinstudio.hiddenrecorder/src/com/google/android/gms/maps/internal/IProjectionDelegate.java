package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;
import com.google.android.gms.maps.model.VisibleRegion;

public abstract interface IProjectionDelegate
  extends IInterface
{
  public abstract LatLng fromScreenLocation(d paramd)
    throws RemoteException;
  
  public abstract VisibleRegion getVisibleRegion()
    throws RemoteException;
  
  public abstract d toScreenLocation(LatLng paramLatLng)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IProjectionDelegate
  {
    public static IProjectionDelegate aR(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        if ((localObject == null) || (!(localObject instanceof IProjectionDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IProjectionDelegate)localObject;
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
      Object localObject1 = null;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        LatLng localLatLng = fromScreenLocation(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (localLatLng == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          localLatLng.writeToParcel(paramParcel2, 1);
        }
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        Object localObject2 = toScreenLocation((LatLng)localObject2);
        paramParcel2.writeNoException();
        IBinder localIBinder;
        if (localObject2 != null) {
          localIBinder = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        VisibleRegion localVisibleRegion = getVisibleRegion();
        paramParcel2.writeNoException();
        if (localVisibleRegion == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          localVisibleRegion.writeToParcel(paramParcel2, 1);
        }
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements IProjectionDelegate
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
      public LatLng fromScreenLocation(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +66 -> 84
        //   21: aload_1
        //   22: invokeinterface 40 1 0
        //   27: astore 4
        //   29: aload_3
        //   30: aload 4
        //   32: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_1
        //   40: aload_3
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:readInt	()I
        //   57: ifeq +16 -> 73
        //   60: getstatic 62	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/LatLngCreator;
        //   63: aload_2
        //   64: invokevirtual 68	com/google/android/gms/maps/model/LatLngCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
        //   67: astore 4
        //   69: aload 4
        //   71: astore 5
        //   73: aload_2
        //   74: invokevirtual 71	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 71	android/os/Parcel:recycle	()V
        //   81: aload 5
        //   83: areturn
        //   84: aconst_null
        //   85: astore 4
        //   87: goto -58 -> 29
        //   90: astore 4
        //   92: aload_2
        //   93: invokevirtual 71	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 71	android/os/Parcel:recycle	()V
        //   100: aload 4
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	a
        //   0	103	1	paramd	d
        //   10	83	2	localParcel1	Parcel
        //   6	91	3	localParcel2	Parcel
        //   27	59	4	localObject1	Object
        //   90	11	4	localObject2	Object
        //   1	81	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   11	69	90	finally
      }
      
      /* Error */
      public VisibleRegion getVisibleRegion()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_3
        //   19: aload_2
        //   20: aload_1
        //   21: iconst_0
        //   22: invokeinterface 49 5 0
        //   27: pop
        //   28: aload_1
        //   29: invokevirtual 52	android/os/Parcel:readException	()V
        //   32: aload_1
        //   33: invokevirtual 56	android/os/Parcel:readInt	()I
        //   36: ifeq +23 -> 59
        //   39: getstatic 78	com/google/android/gms/maps/model/VisibleRegion:CREATOR	Lcom/google/android/gms/maps/model/VisibleRegionCreator;
        //   42: aload_1
        //   43: invokevirtual 83	com/google/android/gms/maps/model/VisibleRegionCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/VisibleRegion;
        //   46: astore_3
        //   47: aload_3
        //   48: astore_3
        //   49: aload_1
        //   50: invokevirtual 71	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 71	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: areturn
        //   59: aconst_null
        //   60: astore_3
        //   61: goto -12 -> 49
        //   64: astore_3
        //   65: aload_1
        //   66: invokevirtual 71	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 71	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   7	59	1	localParcel1	Parcel
        //   3	67	2	localParcel2	Parcel
        //   46	15	3	localVisibleRegion	VisibleRegion
        //   64	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
      }
      
      /* Error */
      public d toScreenLocation(LatLng paramLatLng)
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
        //   15: ifnull +52 -> 67
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 93	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IProjectionDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_3
        //   35: aload_2
        //   36: iconst_0
        //   37: invokeinterface 49 5 0
        //   42: pop
        //   43: aload_2
        //   44: invokevirtual 52	android/os/Parcel:readException	()V
        //   47: aload_2
        //   48: invokevirtual 96	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   51: invokestatic 102	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   54: astore 4
        //   56: aload_2
        //   57: invokevirtual 71	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 71	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: areturn
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   72: goto -43 -> 29
        //   75: astore 4
        //   77: aload_2
        //   78: invokevirtual 71	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 71	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramLatLng	LatLng
        //   7	71	2	localParcel1	Parcel
        //   3	79	3	localParcel2	Parcel
        //   54	11	4	locald	d
        //   75	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	56	75	finally
        //   67	72	75	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IProjectionDelegate
 * JD-Core Version:    0.7.0.1
 */