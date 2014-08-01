package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface h
  extends IInterface
{
  public abstract boolean a(h paramh)
    throws RemoteException;
  
  public abstract void clearTileCache()
    throws RemoteException;
  
  public abstract boolean getFadeIn()
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract float getZIndex()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void remove()
    throws RemoteException;
  
  public abstract void setFadeIn(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZIndex(float paramFloat)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements h
  {
    public static h bf(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        if ((localObject == null) || (!(localObject instanceof h))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (h)localObject;
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
      int i = 0;
      float f1 = 1;
      float f2;
      boolean bool;
      int j;
      switch (paramInt1)
      {
      default: 
        f1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        remove();
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        clearTileCache();
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        String str = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        setZIndex(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        f2 = getZIndex();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        if (paramParcel1.readInt() != 0) {
          f2 = f1;
        }
        setVisible(f2);
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        bool = isVisible();
        paramParcel2.writeNoException();
        if (bool) {
          f2 = f1;
        }
        paramParcel2.writeInt(f2);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        bool = a(bf(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {
          f2 = f1;
        }
        paramParcel2.writeInt(f2);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        j = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        if (paramParcel1.readInt() != 0) {
          j = f1;
        }
        setFadeIn(j);
        paramParcel2.writeNoException();
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        bool = getFadeIn();
        paramParcel2.writeNoException();
        if (bool) {
          j = f1;
        }
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      }
      return f1;
    }
    
    private static class a
      implements h
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public boolean a(h paramh)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +61 -> 79
        //   21: aload_1
        //   22: invokeinterface 37 1 0
        //   27: astore 5
        //   29: aload_3
        //   30: aload 5
        //   32: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/h$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 8
        //   41: aload_3
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 46 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 49	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 53	android/os/Parcel:readInt	()I
        //   58: istore 5
        //   60: iload 5
        //   62: ifeq +6 -> 68
        //   65: iconst_1
        //   66: istore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: iload 4
        //   78: ireturn
        //   79: aconst_null
        //   80: astore 5
        //   82: goto -53 -> 29
        //   85: astore 4
        //   87: aload_2
        //   88: invokevirtual 56	android/os/Parcel:recycle	()V
        //   91: aload_3
        //   92: invokevirtual 56	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	a
        //   0	98	1	paramh	h
        //   10	78	2	localParcel1	Parcel
        //   6	86	3	localParcel2	Parcel
        //   1	76	4	bool	boolean
        //   85	11	4	localObject1	Object
        //   27	4	5	localIBinder	IBinder
        //   58	3	5	i	int
        //   80	1	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   11	60	85	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void clearTileCache()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean getFadeIn()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(11, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getZIndex()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int hashCodeRemote()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isVisible()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          this.ko.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void remove()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
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
      
      public void setFadeIn(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(10, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setVisible(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setZIndex(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
          localParcel2.writeFloat(paramFloat);
          this.ko.transact(4, localParcel2, localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.h
 * JD-Core Version:    0.7.0.1
 */