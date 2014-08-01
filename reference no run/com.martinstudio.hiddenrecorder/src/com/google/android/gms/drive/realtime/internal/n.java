package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface n
  extends IInterface
{
  public abstract void aP(String paramString)
    throws RemoteException;
  
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements n
  {
    public static n ad(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
        if ((localObject == null) || (!(localObject instanceof n))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (n)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
        aP(paramParcel1.readString());
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
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
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IStringCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements n
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void aP(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IStringCallback");
          localParcel2.writeString(paramString);
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
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void o(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 62	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/realtime/internal/n$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_2
        //   38: aload 4
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 42 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 45	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 48	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 48	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 48	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 48	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramStatus	Status
        //   8	65	2	localParcel1	Parcel
        //   71	11	3	localObject	Object
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
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.n
 * JD-Core Version:    0.7.0.1
 */