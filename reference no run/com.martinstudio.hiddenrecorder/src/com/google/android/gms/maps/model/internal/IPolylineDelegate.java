package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public abstract interface IPolylineDelegate
  extends IInterface
{
  public abstract boolean equalsRemote(IPolylineDelegate paramIPolylineDelegate)
    throws RemoteException;
  
  public abstract int getColor()
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract List<LatLng> getPoints()
    throws RemoteException;
  
  public abstract float getWidth()
    throws RemoteException;
  
  public abstract float getZIndex()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract boolean isGeodesic()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void remove()
    throws RemoteException;
  
  public abstract void setColor(int paramInt)
    throws RemoteException;
  
  public abstract void setGeodesic(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setPoints(List<LatLng> paramList)
    throws RemoteException;
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setWidth(float paramFloat)
    throws RemoteException;
  
  public abstract void setZIndex(float paramFloat)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IPolylineDelegate
  {
    public static IPolylineDelegate be(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if ((localObject == null) || (!(localObject instanceof IPolylineDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IPolylineDelegate)localObject;
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
      Object localObject;
      float f3;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        f1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        remove();
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        localObject = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        setPoints(paramParcel1.createTypedArrayList(LatLng.CREATOR));
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        localObject = getPoints();
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList((List)localObject);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        setWidth(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        float f2 = getWidth();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        setColor(paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        int j = getColor();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        setZIndex(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        f3 = getZIndex();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f3);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if (paramParcel1.readInt() != 0) {
          f3 = f1;
        }
        setVisible(f3);
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        bool = isVisible();
        paramParcel2.writeNoException();
        if (bool) {
          f3 = f1;
        }
        paramParcel2.writeInt(f3);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if (paramParcel1.readInt() != 0) {
          f3 = f1;
        }
        setGeodesic(f3);
        paramParcel2.writeNoException();
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        bool = isGeodesic();
        paramParcel2.writeNoException();
        if (bool) {
          f3 = f1;
        }
        paramParcel2.writeInt(f3);
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        bool = equalsRemote(be(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {
          f3 = f1;
        }
        paramParcel2.writeInt(f3);
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        int k = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
      }
      return f1;
    }
    
    private static class a
      implements IPolylineDelegate
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
      public boolean equalsRemote(IPolylineDelegate paramIPolylineDelegate)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +61 -> 79
        //   21: aload_1
        //   22: invokeinterface 38 1 0
        //   27: astore 5
        //   29: aload_2
        //   30: aload 5
        //   32: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/IPolylineDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 15
        //   41: aload_2
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 47 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 50	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 54	android/os/Parcel:readInt	()I
        //   58: istore 5
        //   60: iload 5
        //   62: ifeq +6 -> 68
        //   65: iconst_1
        //   66: istore 4
        //   68: aload_3
        //   69: invokevirtual 57	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 57	android/os/Parcel:recycle	()V
        //   76: iload 4
        //   78: ireturn
        //   79: aconst_null
        //   80: astore 5
        //   82: goto -53 -> 29
        //   85: astore 4
        //   87: aload_3
        //   88: invokevirtual 57	android/os/Parcel:recycle	()V
        //   91: aload_2
        //   92: invokevirtual 57	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	a
        //   0	98	1	paramIPolylineDelegate	IPolylineDelegate
        //   6	86	2	localParcel1	Parcel
        //   10	78	3	localParcel2	Parcel
        //   1	76	4	bool	boolean
        //   85	11	4	localObject1	Object
        //   27	4	5	localIBinder	IBinder
        //   58	3	5	i	int
        //   80	1	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   11	60	85	finally
      }
      
      public int getColor()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(8, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          return i;
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
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(2, localParcel1, localParcel2, 0);
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
      
      public List<LatLng> getPoints()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.createTypedArrayList(LatLng.CREATOR);
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getWidth()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(6, localParcel2, localParcel1, 0);
          localParcel1.readException();
          float f = localParcel1.readFloat();
          return f;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public float getZIndex()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(10, localParcel2, localParcel1, 0);
          localParcel1.readException();
          float f = localParcel1.readFloat();
          return f;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public int hashCodeRemote()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(16, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          return i;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public boolean isGeodesic()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(14, localParcel1, localParcel2, 0);
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
      
      public boolean isVisible()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          this.ko.transact(12, localParcel2, localParcel1, 0);
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
      
      public void remove()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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
      
      public void setColor(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          localParcel2.writeInt(paramInt);
          this.ko.transact(7, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setGeodesic(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(13, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setPoints(List<LatLng> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          localParcel1.writeTypedList(paramList);
          this.ko.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setVisible(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(11, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setWidth(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          localParcel1.writeFloat(paramFloat);
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
      
      public void setZIndex(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(9, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.IPolylineDelegate
 * JD-Core Version:    0.7.0.1
 */