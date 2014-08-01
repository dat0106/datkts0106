package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface jz
  extends IInterface
{
  public abstract void V(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void W(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void X(DataHolder paramDataHolder)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements jz
  {
    public static jz au(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        if ((localObject == null) || (!(localObject instanceof jz))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (jz)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        DataHolder localDataHolder1;
        if (paramParcel1.readInt() != 0) {
          localDataHolder1 = DataHolder.CREATOR.x(paramParcel1);
        }
        V(localDataHolder1);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        DataHolder localDataHolder2;
        if (paramParcel1.readInt() != 0) {
          localDataHolder2 = DataHolder.CREATOR.x(paramParcel1);
        }
        W(localDataHolder2);
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        DataHolder localDataHolder3;
        if (paramParcel1.readInt() != 0) {
          localDataHolder3 = DataHolder.CREATOR.x(paramParcel1);
        }
        X(localDataHolder3);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements jz
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void V(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 30
        //   7: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/jz$a$a:ko	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload_3
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 50 5 0
        //   38: pop
        //   39: aload_3
        //   40: invokevirtual 53	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_3
        //   45: iconst_0
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_2
        //   53: aload_3
        //   54: invokevirtual 53	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramDataHolder	DataHolder
        //   52	6	2	localObject	Object
        //   3	51	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	39	52	finally
        //   44	49	52	finally
      }
      
      /* Error */
      public void W(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 30
        //   7: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/jz$a$a:ko	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_3
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 50 5 0
        //   38: pop
        //   39: aload_3
        //   40: invokevirtual 53	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_3
        //   45: iconst_0
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_2
        //   53: aload_3
        //   54: invokevirtual 53	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramDataHolder	DataHolder
        //   52	6	2	localObject	Object
        //   3	51	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	39	52	finally
        //   44	49	52	finally
      }
      
      /* Error */
      public void X(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 30
        //   7: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/jz$a$a:ko	Landroid/os/IBinder;
        //   29: iconst_3
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 50 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 53	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_3
        //   53: aload_2
        //   54: invokevirtual 53	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramDataHolder	DataHolder
        //   3	51	2	localParcel	Parcel
        //   52	6	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	39	52	finally
        //   44	49	52	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jz
 * JD-Core Version:    0.7.0.1
 */