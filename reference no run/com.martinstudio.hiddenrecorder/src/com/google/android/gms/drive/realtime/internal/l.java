package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface l
  extends IInterface
{
  public abstract void bN(int paramInt)
    throws RemoteException;
  
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements l
  {
    public static l ab(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
        if ((localObject == null) || (!(localObject instanceof l))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (l)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
        bN(paramParcel1.readInt());
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
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
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IIntCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements l
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
      
      public void bN(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIntCallback");
          localParcel2.writeInt(paramInt);
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
      
      /* Error */
      public void o(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +44 -> 60
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 59	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/realtime/internal/l$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_2
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 45 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 48	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 51	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 51	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_2
        //   61: iconst_0
        //   62: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_3
        //   69: aload 4
        //   71: invokevirtual 51	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 51	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramStatus	Status
        //   3	72	2	localParcel1	Parcel
        //   68	11	3	localObject	Object
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.l
 * JD-Core Version:    0.7.0.1
 */