package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface a
  extends IInterface
{
  public abstract d b(Bitmap paramBitmap)
    throws RemoteException;
  
  public abstract d bs(String paramString)
    throws RemoteException;
  
  public abstract d bt(String paramString)
    throws RemoteException;
  
  public abstract d bu(String paramString)
    throws RemoteException;
  
  public abstract d c(float paramFloat)
    throws RemoteException;
  
  public abstract d cX(int paramInt)
    throws RemoteException;
  
  public abstract d jM()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a aX(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        if ((localObject == null) || (!(localObject instanceof a))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (a)localObject;
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
      Object localObject1 = null;
      Object localObject3;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        Object localObject2 = cX(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        localObject3 = bs(paramParcel1.readString());
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (localObject3 != null) {
          localIBinder1 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        localObject3 = bt(paramParcel1.readString());
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (localObject3 != null) {
          localIBinder2 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        int k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        localObject3 = jM();
        paramParcel2.writeNoException();
        IBinder localIBinder3;
        if (localObject3 != null) {
          localIBinder3 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder3);
        int m = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        localObject3 = c(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder4;
        if (localObject3 != null) {
          localIBinder4 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder4);
        int n = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = b((Bitmap)localObject3);
        paramParcel2.writeNoException();
        IBinder localIBinder5;
        if (localObject3 != null) {
          localIBinder5 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder5);
        int i1 = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        localObject3 = bu(paramParcel1.readString());
        paramParcel2.writeNoException();
        IBinder localIBinder6;
        if (localObject3 != null) {
          localIBinder6 = ((d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder6);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements a
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
      public d b(Bitmap paramBitmap)
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
        //   15: ifnull +53 -> 68
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 46	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/model/internal/a$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 52 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 55	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   55: astore 4
        //   57: aload_2
        //   58: invokevirtual 67	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 67	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 67	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 67	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramBitmap	Bitmap
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   55	11	4	locald	d
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      public d bs(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          localParcel1.writeString(paramString);
          this.ko.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public d bt(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          localParcel2.writeString(paramString);
          this.ko.transact(3, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public d bu(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          localParcel2.writeString(paramString);
          this.ko.transact(7, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public d c(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public d cX(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          localParcel2.writeInt(paramInt);
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public d jM()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.a
 * JD-Core Version:    0.7.0.1
 */