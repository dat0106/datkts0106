package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface cp
  extends IInterface
{
  public abstract IBinder a(d paramd)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements cp
  {
    public static cp n(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if ((localObject == null) || (!(localObject instanceof cp))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (cp)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        IBinder localIBinder = a(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(localIBinder);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
      }
      return bool;
    }
    
    private static class a
      implements cp
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public IBinder a(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +52 -> 67
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/cp$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 48 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 51	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   54: astore 4
        //   56: aload_3
        //   57: invokevirtual 57	android/os/Parcel:recycle	()V
        //   60: aload_2
        //   61: invokevirtual 57	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: areturn
        //   67: aconst_null
        //   68: astore 4
        //   70: goto -44 -> 26
        //   73: astore 4
        //   75: aload_3
        //   76: invokevirtual 57	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 57	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramd	d
        //   3	77	2	localParcel1	Parcel
        //   7	69	3	localParcel2	Parcel
        //   24	45	4	localIBinder	IBinder
        //   73	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	56	73	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cp
 * JD-Core Version:    0.7.0.1
 */