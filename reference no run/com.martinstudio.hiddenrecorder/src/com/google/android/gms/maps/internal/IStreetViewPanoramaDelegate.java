package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaCameraCreator;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientationCreator;

public abstract interface IStreetViewPanoramaDelegate
  extends IInterface
{
  public abstract void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
    throws RemoteException;
  
  public abstract void enablePanning(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void enableStreetNames(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void enableUserNavigation(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void enableZoom(boolean paramBoolean)
    throws RemoteException;
  
  public abstract StreetViewPanoramaCamera getPanoramaCamera()
    throws RemoteException;
  
  public abstract StreetViewPanoramaLocation getStreetViewPanoramaLocation()
    throws RemoteException;
  
  public abstract boolean isPanningGesturesEnabled()
    throws RemoteException;
  
  public abstract boolean isStreetNamesEnabled()
    throws RemoteException;
  
  public abstract boolean isUserNavigationEnabled()
    throws RemoteException;
  
  public abstract boolean isZoomGesturesEnabled()
    throws RemoteException;
  
  public abstract d orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    throws RemoteException;
  
  public abstract StreetViewPanoramaOrientation pointToOrientation(d paramd)
    throws RemoteException;
  
  public abstract void setOnStreetViewPanoramaCameraChangeListener(p paramp)
    throws RemoteException;
  
  public abstract void setOnStreetViewPanoramaChangeListener(q paramq)
    throws RemoteException;
  
  public abstract void setOnStreetViewPanoramaClickListener(r paramr)
    throws RemoteException;
  
  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract void setPositionWithID(String paramString)
    throws RemoteException;
  
  public abstract void setPositionWithRadius(LatLng paramLatLng, int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IStreetViewPanoramaDelegate
  {
    public static IStreetViewPanoramaDelegate aT(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if ((localObject == null) || (!(localObject instanceof IStreetViewPanoramaDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IStreetViewPanoramaDelegate)localObject;
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
      int j = 0;
      int i = 1;
      boolean bool;
      Object localObject1;
      Object localObject3;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        enableZoom(j);
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        enablePanning(j);
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        enableUserNavigation(j);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          j = i;
        }
        enableStreetNames(j);
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        bool = isZoomGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        bool = isPanningGesturesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        bool = isUserNavigationEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        bool = isStreetNamesEnabled();
        paramParcel2.writeNoException();
        if (bool) {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = StreetViewPanoramaCamera.CREATOR.createFromParcel(paramParcel1);
        }
        animateTo((StreetViewPanoramaCamera)localObject1, paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        localObject1 = getPanoramaCamera();
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          ((StreetViewPanoramaCamera)localObject1).writeToParcel(paramParcel2, i);
        }
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        setPositionWithID(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        setPosition((LatLng)localObject3);
        paramParcel2.writeNoException();
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        setPositionWithRadius((LatLng)localObject3, paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        localObject1 = getStreetViewPanoramaLocation();
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          ((StreetViewPanoramaLocation)localObject1).writeToParcel(paramParcel2, i);
        }
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        setOnStreetViewPanoramaChangeListener(q.a.aP(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        setOnStreetViewPanoramaCameraChangeListener(p.a.aO(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        setOnStreetViewPanoramaClickListener(r.a.aQ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        localObject1 = pointToOrientation(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          ((StreetViewPanoramaOrientation)localObject1).writeToParcel(paramParcel2, i);
        }
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = StreetViewPanoramaOrientation.CREATOR.createFromParcel(paramParcel1);
        }
        localObject1 = orientationToPoint((StreetViewPanoramaOrientation)localObject1);
        paramParcel2.writeNoException();
        if (localObject1 != null) {
          localObject3 = ((d)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject3);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
      }
      return i;
    }
    
    private static class a
      implements IStreetViewPanoramaDelegate
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 4
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +55 -> 73
        //   21: aload 4
        //   23: iconst_1
        //   24: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 4
        //   30: iconst_0
        //   31: invokevirtual 44	com/google/android/gms/maps/model/StreetViewPanoramaCamera:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 4
        //   36: lload_2
        //   37: invokevirtual 48	android/os/Parcel:writeLong	(J)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   44: bipush 9
        //   46: aload 4
        //   48: aload 6
        //   50: iconst_0
        //   51: invokeinterface 54 5 0
        //   56: pop
        //   57: aload 6
        //   59: invokevirtual 57	android/os/Parcel:readException	()V
        //   62: aload 6
        //   64: invokevirtual 60	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aload 4
        //   75: iconst_0
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: goto -45 -> 34
        //   82: astore 5
        //   84: aload 6
        //   86: invokevirtual 60	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 60	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramStreetViewPanoramaCamera	StreetViewPanoramaCamera
        //   0	97	2	paramLong	long
        //   3	87	4	localParcel1	Parcel
        //   82	13	5	localObject	Object
        //   8	77	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	62	82	finally
        //   73	79	82	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void enablePanning(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(2, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void enableStreetNames(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
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
      
      public void enableUserNavigation(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
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
      
      /* Error */
      public void enableZoom(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +36 -> 54
        //   21: aload_3
        //   22: iload 4
        //   24: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   27: aload_0
        //   28: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   31: iconst_1
        //   32: aload_3
        //   33: aload_2
        //   34: iconst_0
        //   35: invokeinterface 54 5 0
        //   40: pop
        //   41: aload_2
        //   42: invokevirtual 57	android/os/Parcel:readException	()V
        //   45: aload_2
        //   46: invokevirtual 60	android/os/Parcel:recycle	()V
        //   49: aload_3
        //   50: invokevirtual 60	android/os/Parcel:recycle	()V
        //   53: return
        //   54: iconst_0
        //   55: istore 4
        //   57: goto -36 -> 21
        //   60: astore 4
        //   62: aload_2
        //   63: invokevirtual 60	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramBoolean	boolean
        //   10	53	2	localParcel1	Parcel
        //   6	61	3	localParcel2	Parcel
        //   1	55	4	i	int
        //   60	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	45	60	finally
      }
      
      /* Error */
      public StreetViewPanoramaCamera getPanoramaCamera()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   18: bipush 10
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 54 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 57	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 73	android/os/Parcel:readInt	()I
        //   37: ifeq +23 -> 60
        //   40: getstatic 77	com/google/android/gms/maps/model/StreetViewPanoramaCamera:CREATOR	Lcom/google/android/gms/maps/model/StreetViewPanoramaCameraCreator;
        //   43: aload_2
        //   44: invokevirtual 83	com/google/android/gms/maps/model/StreetViewPanoramaCameraCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/StreetViewPanoramaCamera;
        //   47: astore_3
        //   48: aload_3
        //   49: astore_3
        //   50: aload_2
        //   51: invokevirtual 60	android/os/Parcel:recycle	()V
        //   54: aload_1
        //   55: invokevirtual 60	android/os/Parcel:recycle	()V
        //   58: aload_3
        //   59: areturn
        //   60: aconst_null
        //   61: astore_3
        //   62: goto -12 -> 50
        //   65: astore_3
        //   66: aload_2
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_1
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   3	68	1	localParcel1	Parcel
        //   7	60	2	localParcel2	Parcel
        //   47	15	3	localStreetViewPanoramaCamera	StreetViewPanoramaCamera
        //   65	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
      }
      
      /* Error */
      public StreetViewPanoramaLocation getStreetViewPanoramaLocation()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   18: bipush 14
        //   20: aload_2
        //   21: aload_1
        //   22: iconst_0
        //   23: invokeinterface 54 5 0
        //   28: pop
        //   29: aload_1
        //   30: invokevirtual 57	android/os/Parcel:readException	()V
        //   33: aload_1
        //   34: invokevirtual 73	android/os/Parcel:readInt	()I
        //   37: ifeq +23 -> 60
        //   40: getstatic 90	com/google/android/gms/maps/model/StreetViewPanoramaLocation:CREATOR	Lcom/google/android/gms/maps/model/StreetViewPanoramaLocationCreator;
        //   43: aload_1
        //   44: invokevirtual 95	com/google/android/gms/maps/model/StreetViewPanoramaLocationCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/StreetViewPanoramaLocation;
        //   47: astore_3
        //   48: aload_3
        //   49: astore_3
        //   50: aload_1
        //   51: invokevirtual 60	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 60	android/os/Parcel:recycle	()V
        //   58: aload_3
        //   59: areturn
        //   60: aconst_null
        //   61: astore_3
        //   62: goto -12 -> 50
        //   65: astore_3
        //   66: aload_1
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   7	60	1	localParcel1	Parcel
        //   3	68	2	localParcel2	Parcel
        //   47	15	3	localStreetViewPanoramaLocation	StreetViewPanoramaLocation
        //   65	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
      }
      
      public boolean isPanningGesturesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          this.ko.transact(6, localParcel1, localParcel2, 0);
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
      
      public boolean isStreetNamesEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
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
      
      public boolean isUserNavigationEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          this.ko.transact(7, localParcel2, localParcel1, 0);
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
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          this.ko.transact(5, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public d orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 105	com/google/android/gms/maps/model/StreetViewPanoramaOrientation:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 19
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 54 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 57	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 108	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 114	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   55: astore 4
        //   57: aload_2
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 60	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 60	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramStreetViewPanoramaOrientation	StreetViewPanoramaOrientation
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
      public StreetViewPanoramaOrientation pointToOrientation(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +67 -> 85
        //   21: aload_1
        //   22: invokeinterface 120 1 0
        //   27: astore 4
        //   29: aload_3
        //   30: aload 4
        //   32: invokevirtual 123	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 18
        //   41: aload_3
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 54 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 57	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 73	android/os/Parcel:readInt	()I
        //   58: ifeq +16 -> 74
        //   61: getstatic 126	com/google/android/gms/maps/model/StreetViewPanoramaOrientation:CREATOR	Lcom/google/android/gms/maps/model/StreetViewPanoramaOrientationCreator;
        //   64: aload_2
        //   65: invokevirtual 131	com/google/android/gms/maps/model/StreetViewPanoramaOrientationCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/StreetViewPanoramaOrientation;
        //   68: astore 4
        //   70: aload 4
        //   72: astore 5
        //   74: aload_2
        //   75: invokevirtual 60	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload 5
        //   84: areturn
        //   85: aconst_null
        //   86: astore 4
        //   88: goto -59 -> 29
        //   91: astore 4
        //   93: aload_2
        //   94: invokevirtual 60	android/os/Parcel:recycle	()V
        //   97: aload_3
        //   98: invokevirtual 60	android/os/Parcel:recycle	()V
        //   101: aload 4
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	a
        //   0	104	1	paramd	d
        //   10	84	2	localParcel1	Parcel
        //   6	92	3	localParcel2	Parcel
        //   27	60	4	localObject1	Object
        //   91	11	4	localObject2	Object
        //   1	82	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   11	70	91	finally
      }
      
      /* Error */
      public void setOnStreetViewPanoramaCameraChangeListener(p paramp)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 136 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 123	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 16
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 54 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 57	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 60	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 60	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 60	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramp	p
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnStreetViewPanoramaChangeListener(q paramq)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 141 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 123	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 15
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 54 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 57	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 60	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 60	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 60	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramq	q
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnStreetViewPanoramaClickListener(r paramr)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 146 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 123	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 17
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 54 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 57	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 60	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 60	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 60	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramr	r
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setPosition(LatLng paramLatLng)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 151	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 12
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 54 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 57	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 60	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_3
        //   58: iconst_0
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 60	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 60	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramLatLng	LatLng
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      public void setPositionWithID(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
          localParcel2.writeString(paramString);
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
      
      /* Error */
      public void setPositionWithRadius(LatLng paramLatLng, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 5
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 151	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: iload_2
        //   32: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 13
        //   41: aload_3
        //   42: aload 5
        //   44: iconst_0
        //   45: invokeinterface 54 5 0
        //   50: pop
        //   51: aload 5
        //   53: invokevirtual 57	android/os/Parcel:readException	()V
        //   56: aload 5
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 60	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   71: goto -41 -> 30
        //   74: astore 4
        //   76: aload 5
        //   78: invokevirtual 60	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 60	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramLatLng	LatLng
        //   0	88	2	paramInt	int
        //   3	79	3	localParcel1	Parcel
        //   74	12	4	localObject	Object
        //   7	70	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	56	74	finally
        //   66	71	74	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
 * JD-Core Version:    0.7.0.1
 */