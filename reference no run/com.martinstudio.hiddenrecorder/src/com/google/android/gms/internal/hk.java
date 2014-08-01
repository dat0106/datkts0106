package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface hk
  extends IInterface
{
  public abstract d a(d paramd, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements hk
  {
    public static hk M(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if ((localObject == null) || (!(localObject instanceof hk))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (hk)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        Object localObject = a(d.a.ag(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((d)localObject).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements hk
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public d a(d paramd, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +74 -> 92
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: iload_2
        //   39: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   42: aload 4
        //   44: iload_3
        //   45: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/internal/hk$a$a:ko	Landroid/os/IBinder;
        //   52: iconst_1
        //   53: aload 4
        //   55: aload 5
        //   57: iconst_0
        //   58: invokeinterface 52 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 55	android/os/Parcel:readException	()V
        //   69: aload 5
        //   71: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   74: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   77: astore 6
        //   79: aload 5
        //   81: invokevirtual 67	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 67	android/os/Parcel:recycle	()V
        //   89: aload 6
        //   91: areturn
        //   92: aconst_null
        //   93: astore 6
        //   95: goto -66 -> 29
        //   98: astore 6
        //   100: aload 5
        //   102: invokevirtual 67	android/os/Parcel:recycle	()V
        //   105: aload 4
        //   107: invokevirtual 67	android/os/Parcel:recycle	()V
        //   110: aload 6
        //   112: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	113	0	this	a
        //   0	113	1	paramd	d
        //   0	113	2	paramInt1	int
        //   0	113	3	paramInt2	int
        //   3	103	4	localParcel1	Parcel
        //   8	93	5	localParcel2	Parcel
        //   27	67	6	localObject1	Object
        //   98	13	6	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	79	98	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hk
 * JD-Core Version:    0.7.0.1
 */