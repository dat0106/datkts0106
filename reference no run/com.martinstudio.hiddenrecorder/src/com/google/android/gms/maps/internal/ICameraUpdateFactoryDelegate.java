package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPositionCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;

public abstract interface ICameraUpdateFactoryDelegate
  extends IInterface
{
  public abstract d newCameraPosition(CameraPosition paramCameraPosition)
    throws RemoteException;
  
  public abstract d newLatLng(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract d newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
    throws RemoteException;
  
  public abstract d newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract d newLatLngZoom(LatLng paramLatLng, float paramFloat)
    throws RemoteException;
  
  public abstract d scrollBy(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract d zoomBy(float paramFloat)
    throws RemoteException;
  
  public abstract d zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract d zoomIn()
    throws RemoteException;
  
  public abstract d zoomOut()
    throws RemoteException;
  
  public abstract d zoomTo(float paramFloat)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ICameraUpdateFactoryDelegate
  {
    public static ICameraUpdateFactoryDelegate av(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if ((localObject == null) || (!(localObject instanceof ICameraUpdateFactoryDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ICameraUpdateFactoryDelegate)localObject;
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
      Object localObject2;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = zoomIn();
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (localObject2 != null) {
          localIBinder1 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = zoomOut();
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (localObject2 != null) {
          localIBinder2 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = scrollBy(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder3;
        if (localObject2 != null) {
          localIBinder3 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder3);
        int k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = zoomTo(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder4;
        if (localObject2 != null) {
          localIBinder4 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder4);
        int m = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = zoomBy(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder5;
        if (localObject2 != null) {
          localIBinder5 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder5);
        int n = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        localObject2 = zoomByWithFocus(paramParcel1.readFloat(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        IBinder localIBinder6;
        if (localObject2 != null) {
          localIBinder6 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder6);
        int i1 = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = CameraPosition.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = newCameraPosition((CameraPosition)localObject2);
        paramParcel2.writeNoException();
        IBinder localIBinder7;
        if (localObject2 != null) {
          localIBinder7 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder7);
        int i2 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = newLatLng((LatLng)localObject2);
        paramParcel2.writeNoException();
        IBinder localIBinder8;
        if (localObject2 != null) {
          localIBinder8 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder8);
        int i3 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = newLatLngZoom((LatLng)localObject2, paramParcel1.readFloat());
        paramParcel2.writeNoException();
        IBinder localIBinder9;
        if (localObject2 != null) {
          localIBinder9 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder9);
        int i4 = 1;
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = newLatLngBounds((LatLngBounds)localObject2, paramParcel1.readInt());
        paramParcel2.writeNoException();
        IBinder localIBinder10;
        if (localObject2 != null) {
          localIBinder10 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder10);
        int i5 = 1;
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = newLatLngBoundsWithSize((LatLngBounds)localObject2, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        IBinder localIBinder11;
        if (localObject2 != null) {
          localIBinder11 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder11);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ICameraUpdateFactoryDelegate
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
      public d newCameraPosition(CameraPosition paramCameraPosition)
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
        //   26: invokevirtual 46	com/google/android/gms/maps/model/CameraPosition:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 7
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
        //   0	89	1	paramCameraPosition	CameraPosition
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   55	11	4	locald	d
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public d newLatLng(LatLng paramLatLng)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 72	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 8
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 52 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 55	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   55: astore 4
        //   57: aload_3
        //   58: invokevirtual 67	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 67	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 67	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 67	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramLatLng	LatLng
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   55	11	4	locald	d
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public d newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +62 -> 78
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 77	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: iload_2
        //   32: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 10
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 52 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 55	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   61: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   64: astore 5
        //   66: aload 4
        //   68: invokevirtual 67	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 67	android/os/Parcel:recycle	()V
        //   75: aload 5
        //   77: areturn
        //   78: aload_3
        //   79: iconst_0
        //   80: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   83: goto -53 -> 30
        //   86: astore 5
        //   88: aload 4
        //   90: invokevirtual 67	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: invokevirtual 67	android/os/Parcel:recycle	()V
        //   97: aload 5
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramLatLngBounds	LatLngBounds
        //   0	100	2	paramInt	int
        //   3	91	3	localParcel1	Parcel
        //   7	82	4	localParcel2	Parcel
        //   64	12	5	locald	d
        //   86	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	66	86	finally
        //   78	83	86	finally
      }
      
      /* Error */
      public d newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +80 -> 98
        //   21: aload 5
        //   23: iconst_1
        //   24: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 5
        //   30: iconst_0
        //   31: invokevirtual 77	com/google/android/gms/maps/model/LatLngBounds:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 5
        //   36: iload_2
        //   37: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   40: aload 5
        //   42: iload_3
        //   43: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   46: aload 5
        //   48: iload 4
        //   50: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   53: aload_0
        //   54: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$a$a:ko	Landroid/os/IBinder;
        //   57: bipush 11
        //   59: aload 5
        //   61: aload 6
        //   63: iconst_0
        //   64: invokeinterface 52 5 0
        //   69: pop
        //   70: aload 6
        //   72: invokevirtual 55	android/os/Parcel:readException	()V
        //   75: aload 6
        //   77: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   80: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   83: astore 7
        //   85: aload 6
        //   87: invokevirtual 67	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: invokevirtual 67	android/os/Parcel:recycle	()V
        //   95: aload 7
        //   97: areturn
        //   98: aload 5
        //   100: iconst_0
        //   101: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   104: goto -70 -> 34
        //   107: astore 7
        //   109: aload 6
        //   111: invokevirtual 67	android/os/Parcel:recycle	()V
        //   114: aload 5
        //   116: invokevirtual 67	android/os/Parcel:recycle	()V
        //   119: aload 7
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	a
        //   0	122	1	paramLatLngBounds	LatLngBounds
        //   0	122	2	paramInt1	int
        //   0	122	3	paramInt2	int
        //   0	122	4	paramInt3	int
        //   3	112	5	localParcel1	Parcel
        //   8	102	6	localParcel2	Parcel
        //   83	13	7	locald	d
        //   107	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	85	107	finally
        //   98	104	107	finally
      }
      
      /* Error */
      public d newLatLngZoom(LatLng paramLatLng, float paramFloat)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +62 -> 78
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 72	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: fload_2
        //   32: invokevirtual 85	android/os/Parcel:writeFloat	(F)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 9
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 52 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 55	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 58	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   61: invokestatic 64	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   64: astore 5
        //   66: aload 4
        //   68: invokevirtual 67	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 67	android/os/Parcel:recycle	()V
        //   75: aload 5
        //   77: areturn
        //   78: aload_3
        //   79: iconst_0
        //   80: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   83: goto -53 -> 30
        //   86: astore 5
        //   88: aload 4
        //   90: invokevirtual 67	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: invokevirtual 67	android/os/Parcel:recycle	()V
        //   97: aload 5
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramLatLng	LatLng
        //   0	100	2	paramFloat	float
        //   3	91	3	localParcel1	Parcel
        //   7	82	4	localParcel2	Parcel
        //   64	12	5	locald	d
        //   86	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	66	86	finally
        //   78	83	86	finally
      }
      
      public d scrollBy(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel2.writeFloat(paramFloat1);
          localParcel2.writeFloat(paramFloat2);
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
      
      public d zoomBy(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
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
      
      public d zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel1.writeFloat(paramFloat);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.ko.transact(6, localParcel1, localParcel2, 0);
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
      
      public d zoomIn()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
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
      
      public d zoomOut()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
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
      
      public d zoomTo(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
          localParcel2.writeFloat(paramFloat);
          this.ko.transact(4, localParcel2, localParcel1, 0);
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
 * JD-Core Version:    0.7.0.1
 */