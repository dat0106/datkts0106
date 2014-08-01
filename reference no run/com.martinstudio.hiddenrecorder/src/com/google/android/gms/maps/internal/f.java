package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.d.a;

public abstract interface f
  extends IInterface
{
  public abstract void a(d paramd)
    throws RemoteException;
  
  public abstract void onIndoorBuildingFocused()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }
    
    public static f aE(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        if ((localObject == null) || (!(localObject instanceof f))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (f)localObject;
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
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        onIndoorBuildingFocused();
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        a(d.a.ba(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      }
      return bool;
    }
    
    private static class a
      implements f
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(d paramd)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/f$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 48 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 51	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 54	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 54	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	d
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void onIndoorBuildingFocused()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.f
 * JD-Core Version:    0.7.0.1
 */