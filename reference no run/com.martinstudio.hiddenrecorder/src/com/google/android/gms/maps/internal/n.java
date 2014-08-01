package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface n
  extends IInterface
{
  public abstract boolean onMyLocationButtonClick()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements n
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }
    
    public static n aM(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
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
      int i = 1;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
        int j = onMyLocationButtonClick();
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
      }
      return i;
    }
    
    private static class a
      implements n
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
      public boolean onMyLocationButtonClick()
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_2
        //   6: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore_1
        //   10: aload_2
        //   11: ldc 32
        //   13: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_0
        //   17: getfield 18	com/google/android/gms/maps/internal/n$a$a:ko	Landroid/os/IBinder;
        //   20: iconst_1
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 42 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 45	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 49	android/os/Parcel:readInt	()I
        //   38: istore 4
        //   40: iload 4
        //   42: ifeq +13 -> 55
        //   45: aload_1
        //   46: invokevirtual 52	android/os/Parcel:recycle	()V
        //   49: aload_2
        //   50: invokevirtual 52	android/os/Parcel:recycle	()V
        //   53: iload_3
        //   54: ireturn
        //   55: iconst_0
        //   56: istore_3
        //   57: goto -12 -> 45
        //   60: astore_3
        //   61: aload_1
        //   62: invokevirtual 52	android/os/Parcel:recycle	()V
        //   65: aload_2
        //   66: invokevirtual 52	android/os/Parcel:recycle	()V
        //   69: aload_3
        //   70: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	71	0	this	a
        //   9	53	1	localParcel1	Parcel
        //   5	61	2	localParcel2	Parcel
        //   1	56	3	bool	boolean
        //   60	10	3	localObject	Object
        //   38	3	4	i	int
        // Exception table:
        //   from	to	target	type
        //   10	40	60	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.n
 * JD-Core Version:    0.7.0.1
 */