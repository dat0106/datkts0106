package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IUiSettingsDelegate
  extends IInterface
{
  public abstract boolean isCompassEnabled()
    throws RemoteException;
  
  public abstract boolean isIndoorLevelPickerEnabled()
    throws RemoteException;
  
  public abstract boolean isMyLocationButtonEnabled()
    throws RemoteException;
  
  public abstract boolean isRotateGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isScrollGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isTiltGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomControlsEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomGesturesEnabled()
    throws RemoteException;
  
  public abstract void setAllGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setCompassEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setIndoorLevelPickerEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMyLocationButtonEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setScrollGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomControlsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomGesturesEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IUiSettingsDelegate
  {
    public static IUiSettingsDelegate aW(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if ((localObject == null) || (!(localObject instanceof IUiSettingsDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IUiSettingsDelegate)localObject;
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
      int j = 0;
      int i = 1;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setZoomControlsEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setCompassEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setMyLocationButtonEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setScrollGesturesEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setZoomGesturesEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setTiltGesturesEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setRotateGesturesEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setAllGesturesEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isZoomControlsEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isCompassEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isMyLocationButtonEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isScrollGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isZoomGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isTiltGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isRotateGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        setIndoorLevelPickerEnabled(j);
        paramParcel2.writeNoException();
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        bool = isIndoorLevelPickerEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
      }
      return i;
    }
    
    private static class a
      implements IUiSettingsDelegate
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
      
      public boolean isCompassEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(10, localParcel2, localParcel1, 0);
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
      
      public boolean isIndoorLevelPickerEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(17, localParcel2, localParcel1, 0);
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
      
      public boolean isMyLocationButtonEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(11, localParcel1, localParcel2, 0);
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
      
      public boolean isRotateGesturesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(15, localParcel1, localParcel2, 0);
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
      
      public boolean isScrollGesturesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(12, localParcel1, localParcel2, 0);
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
      
      public boolean isTiltGesturesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(14, localParcel2, localParcel1, 0);
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
      
      public boolean isZoomControlsEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(9, localParcel2, localParcel1, 0);
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
      
      public boolean isZoomGesturesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          this.ko.transact(13, localParcel2, localParcel1, 0);
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
      
      public void setAllGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(8, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setCompassEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
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
      
      public void setIndoorLevelPickerEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(16, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setMyLocationButtonEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(3, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setRotateGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setScrollGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setTiltGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
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
      
      /* Error */
      public void setZoomControlsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +36 -> 54
        //   21: aload_2
        //   22: iload 4
        //   24: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   27: aload_0
        //   28: getfield 18	com/google/android/gms/maps/internal/IUiSettingsDelegate$a$a:ko	Landroid/os/IBinder;
        //   31: iconst_1
        //   32: aload_2
        //   33: aload_3
        //   34: iconst_0
        //   35: invokeinterface 42 5 0
        //   40: pop
        //   41: aload_3
        //   42: invokevirtual 45	android/os/Parcel:readException	()V
        //   45: aload_3
        //   46: invokevirtual 52	android/os/Parcel:recycle	()V
        //   49: aload_2
        //   50: invokevirtual 52	android/os/Parcel:recycle	()V
        //   53: return
        //   54: iconst_0
        //   55: istore 4
        //   57: goto -36 -> 21
        //   60: astore 4
        //   62: aload_3
        //   63: invokevirtual 52	android/os/Parcel:recycle	()V
        //   66: aload_2
        //   67: invokevirtual 52	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramBoolean	boolean
        //   6	61	2	localParcel1	Parcel
        //   10	53	3	localParcel2	Parcel
        //   1	55	4	i	int
        //   60	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	45	60	finally
      }
      
      public void setZoomGesturesEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(5, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.maps.internal.IUiSettingsDelegate
 * JD-Core Version:    0.7.0.1
 */