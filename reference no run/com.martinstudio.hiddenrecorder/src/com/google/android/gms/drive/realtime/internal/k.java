package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface k
  extends IInterface
{
  public abstract void a(ParcelableIndexReference paramParcelableIndexReference)
    throws RemoteException;
  
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements k
  {
    public static k aa(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
        if ((localObject == null) || (!(localObject instanceof k))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (k)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
        ParcelableIndexReference localParcelableIndexReference;
        if (paramParcel1.readInt() != 0) {
          localParcelableIndexReference = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(paramParcel1);
        }
        a(localParcelableIndexReference);
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
        Status localStatus;
        if (paramParcel1.readInt() != 0) {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        o(localStatus);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements k
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(ParcelableIndexReference paramParcelableIndexReference)
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
        //   16: ifnull +44 -> 60
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 43	com/google/android/gms/drive/realtime/internal/ParcelableIndexReference:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/realtime/internal/k$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 49 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_3
        //   61: iconst_0
        //   62: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_2
        //   69: aload 4
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: invokevirtual 55	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramParcelableIndexReference	ParcelableIndexReference
        //   68	11	2	localObject	Object
        //   3	72	3	localParcel1	Parcel
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void o(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 62	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/realtime/internal/k$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_2
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
        //   65: invokevirtual 37	android/os/Parcel:writeInt	(I)V
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
        //   0	83	1	paramStatus	Status
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
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.k
 * JD-Core Version:    0.7.0.1
 */