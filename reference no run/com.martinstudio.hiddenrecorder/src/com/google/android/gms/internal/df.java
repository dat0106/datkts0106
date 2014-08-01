package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface df
  extends IInterface
{
  public abstract IBinder b(d paramd)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements df
  {
    public static df s(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        if ((localObject == null) || (!(localObject instanceof df))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (df)localObject;
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
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        IBinder localIBinder = b(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(localIBinder);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
      }
      return bool;
    }
    
    private static class a
      implements df
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
      public IBinder b(d paramd)
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
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/df$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   54: astore 4
        //   56: aload_2
        //   57: invokevirtual 58	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 58	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: areturn
        //   67: aconst_null
        //   68: astore 4
        //   70: goto -44 -> 26
        //   73: astore 4
        //   75: aload_2
        //   76: invokevirtual 58	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: invokevirtual 58	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramd	d
        //   7	69	2	localParcel1	Parcel
        //   3	77	3	localParcel2	Parcel
        //   24	45	4	localIBinder	IBinder
        //   73	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	56	73	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.df
 * JD-Core Version:    0.7.0.1
 */