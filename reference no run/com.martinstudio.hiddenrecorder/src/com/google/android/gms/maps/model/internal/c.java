package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;

public abstract interface c
  extends IInterface
{
  public abstract void a(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract boolean a(c paramc)
    throws RemoteException;
  
  public abstract float getBearing()
    throws RemoteException;
  
  public abstract LatLngBounds getBounds()
    throws RemoteException;
  
  public abstract float getHeight()
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract LatLng getPosition()
    throws RemoteException;
  
  public abstract float getTransparency()
    throws RemoteException;
  
  public abstract float getWidth()
    throws RemoteException;
  
  public abstract float getZIndex()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void l(d paramd)
    throws RemoteException;
  
  public abstract void remove()
    throws RemoteException;
  
  public abstract void setBearing(float paramFloat)
    throws RemoteException;
  
  public abstract void setDimensions(float paramFloat)
    throws RemoteException;
  
  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract void setPositionFromBounds(LatLngBounds paramLatLngBounds)
    throws RemoteException;
  
  public abstract void setTransparency(float paramFloat)
    throws RemoteException;
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZIndex(float paramFloat)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c aZ(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if ((localObject == null) || (!(localObject instanceof c))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (c)localObject;
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
      Object localObject2 = null;
      int i = 0;
      float f1 = 1;
      Object localObject1;
      float f2;
      float f3;
      int j;
      boolean bool;
      float f4;
      switch (paramInt1)
      {
      default: 
        f1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        remove();
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        localObject1 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject1);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject2 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        setPosition((LatLng)localObject2);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        localObject1 = getPosition();
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(f1);
          ((LatLng)localObject1).writeToParcel(paramParcel2, f1);
        }
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        setDimensions(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        a(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        f2 = getWidth();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        f2 = getHeight();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject2 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        setPositionFromBounds((LatLngBounds)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        LatLngBounds localLatLngBounds = getBounds();
        paramParcel2.writeNoException();
        if (localLatLngBounds == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(f1);
          localLatLngBounds.writeToParcel(paramParcel2, f1);
        }
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        setBearing(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        f3 = getBearing();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f3);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        setZIndex(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        f3 = getZIndex();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f3);
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if (paramParcel1.readInt() == 0) {
          j = 0;
        } else {
          j = f1;
        }
        setVisible(j);
        paramParcel2.writeNoException();
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        bool = isVisible();
        paramParcel2.writeNoException();
        if (bool) {
          j = f1;
        }
        paramParcel2.writeInt(j);
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        setTransparency(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        f4 = getTransparency();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f4);
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        bool = a(aZ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {
          f4 = f1;
        }
        paramParcel2.writeInt(f4);
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        int k = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        l(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
      }
      return f1;
    }
    
    private static class a
      implements c
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          localParcel2.writeFloat(paramFloat1);
          localParcel2.writeFloat(paramFloat2);
          this.ko.transact(6, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      /* Error */
      public boolean a(c paramc)
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
        //   22: invokeinterface 54 1 0
        //   27: astore 5
        //   29: aload_3
        //   30: aload 5
        //   32: invokevirtual 57	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 19
        //   41: aload_3
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 43 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 46	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 61	android/os/Parcel:readInt	()I
        //   58: istore 5
        //   60: iload 5
        //   62: ifeq +6 -> 68
        //   65: iconst_1
        //   66: istore 4
        //   68: aload_2
        //   69: invokevirtual 49	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 49	android/os/Parcel:recycle	()V
        //   76: iload 4
        //   78: ireturn
        //   79: aconst_null
        //   80: astore 5
        //   82: goto -53 -> 29
        //   85: astore 4
        //   87: aload_2
        //   88: invokevirtual 49	android/os/Parcel:recycle	()V
        //   91: aload_3
        //   92: invokevirtual 49	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	a
        //   0	98	1	paramc	c
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
      
      public float getBearing()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(12, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public LatLngBounds getBounds()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   18: bipush 10
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 43 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 46	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 61	android/os/Parcel:readInt	()I
        //   37: ifeq +23 -> 60
        //   40: getstatic 74	com/google/android/gms/maps/model/LatLngBounds:CREATOR	Lcom/google/android/gms/maps/model/LatLngBoundsCreator;
        //   43: aload_2
        //   44: invokevirtual 80	com/google/android/gms/maps/model/LatLngBoundsCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLngBounds;
        //   47: astore_3
        //   48: aload_3
        //   49: astore_3
        //   50: aload_2
        //   51: invokevirtual 49	android/os/Parcel:recycle	()V
        //   54: aload_1
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_3
        //   59: areturn
        //   60: aconst_null
        //   61: astore_3
        //   62: goto -12 -> 50
        //   65: astore_3
        //   66: aload_2
        //   67: invokevirtual 49	android/os/Parcel:recycle	()V
        //   70: aload_1
        //   71: invokevirtual 49	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   3	68	1	localParcel1	Parcel
        //   7	60	2	localParcel2	Parcel
        //   47	15	3	localLatLngBounds	LatLngBounds
        //   65	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
      }
      
      public float getHeight()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
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
      
      public String getId()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(2, localParcel2, localParcel1, 0);
          localParcel1.readException();
          String str = localParcel1.readString();
          return str;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      /* Error */
      public LatLng getPosition()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_4
        //   19: aload_2
        //   20: aload_1
        //   21: iconst_0
        //   22: invokeinterface 43 5 0
        //   27: pop
        //   28: aload_1
        //   29: invokevirtual 46	android/os/Parcel:readException	()V
        //   32: aload_1
        //   33: invokevirtual 61	android/os/Parcel:readInt	()I
        //   36: ifeq +23 -> 59
        //   39: getstatic 93	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/LatLngCreator;
        //   42: aload_1
        //   43: invokevirtual 98	com/google/android/gms/maps/model/LatLngCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
        //   46: astore_3
        //   47: aload_3
        //   48: astore_3
        //   49: aload_1
        //   50: invokevirtual 49	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: areturn
        //   59: aconst_null
        //   60: astore_3
        //   61: goto -12 -> 49
        //   64: astore_3
        //   65: aload_1
        //   66: invokevirtual 49	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 49	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   7	59	1	localParcel1	Parcel
        //   3	67	2	localParcel2	Parcel
        //   46	15	3	localLatLng	LatLng
        //   64	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
      }
      
      public float getTransparency()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(18, localParcel1, localParcel2, 0);
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
      
      public float getWidth()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(7, localParcel1, localParcel2, 0);
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
      
      public float getZIndex()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(14, localParcel2, localParcel1, 0);
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
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(20, localParcel2, localParcel1, 0);
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
      
      public boolean isVisible()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          this.ko.transact(16, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public void l(d paramd)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 109 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 57	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 21
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 43 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 46	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 49	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 49	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 49	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 49	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramd	d
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public void remove()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
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
      
      public void setBearing(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setDimensions(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
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
      
      /* Error */
      public void setPosition(LatLng paramLatLng)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 118	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 122	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_3
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 43 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 46	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 49	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 49	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 118	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 49	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 49	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramLatLng	LatLng
        //   71	11	2	localObject	Object
        //   8	65	3	localParcel1	Parcel
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 118	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 125	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/maps/model/internal/c$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 9
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 43 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 46	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 49	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 118	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 49	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 49	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramLatLngBounds	LatLngBounds
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      public void setTransparency(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(17, localParcel1, localParcel2, 0);
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
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(15, localParcel1, localParcel2, 0);
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
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(13, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.c
 * JD-Core Version:    0.7.0.1
 */