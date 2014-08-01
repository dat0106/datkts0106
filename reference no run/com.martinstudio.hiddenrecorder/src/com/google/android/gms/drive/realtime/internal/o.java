package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface o
  extends IInterface
{
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public abstract void onSuccess()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements o
  {
    public static o ae(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
        if ((localObject == null) || (!(localObject instanceof o))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (o)localObject;
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
      boolean bool1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
        onSuccess();
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
        Status localStatus;
        if (paramParcel1.readInt() == 0) {
          localStatus = null;
        } else {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        o(localStatus);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements o
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
      public void o(Status paramStatus)
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
        //   23: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 46	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/realtime/internal/o$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_2
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 52 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 55	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 58	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 58	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 58	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 58	android/os/Parcel:recycle	()V
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
      
      public void onSuccess()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.o
 * JD-Core Version:    0.7.0.1
 */