package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ac
  extends IInterface
{
  public abstract void a(OnEventResponse paramOnEventResponse)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ac
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
    }
    
    public static ac R(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
        if ((localObject == null) || (!(localObject instanceof ac))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ac)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
        OnEventResponse localOnEventResponse;
        if (paramParcel1.readInt() == 0) {
          localOnEventResponse = null;
        } else {
          localOnEventResponse = (OnEventResponse)OnEventResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnEventResponse);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.internal.IEventCallback");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ac
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(OnEventResponse paramOnEventResponse)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 43	com/google/android/gms/drive/internal/OnEventResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/drive/internal/ac$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_3
        //   35: aload_2
        //   36: iconst_0
        //   37: invokeinterface 49 5 0
        //   42: pop
        //   43: aload_2
        //   44: invokevirtual 52	android/os/Parcel:readException	()V
        //   47: aload_2
        //   48: invokevirtual 55	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_3
        //   57: iconst_0
        //   58: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_2
        //   67: invokevirtual 55	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramOnEventResponse	OnEventResponse
        //   7	60	2	localParcel1	Parcel
        //   3	68	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ac
 * JD-Core Version:    0.7.0.1
 */