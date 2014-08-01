package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.CircleOptionsCreator;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.GroundOverlayOptionsCreator;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MarkerOptionsCreator;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolygonOptionsCreator;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.PolylineOptionsCreator;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileOverlayOptionsCreator;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.h;

public abstract interface IGoogleMapDelegate
  extends IInterface
{
  public abstract com.google.android.gms.maps.model.internal.b addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;
  
  public abstract c addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.f addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.g addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;
  
  public abstract IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;
  
  public abstract h addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;
  
  public abstract void animateCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
    throws RemoteException;
  
  public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
    throws RemoteException;
  
  public abstract void clear()
    throws RemoteException;
  
  public abstract CameraPosition getCameraPosition()
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.d getFocusedBuilding()
    throws RemoteException;
  
  public abstract int getMapType()
    throws RemoteException;
  
  public abstract float getMaxZoomLevel()
    throws RemoteException;
  
  public abstract float getMinZoomLevel()
    throws RemoteException;
  
  public abstract Location getMyLocation()
    throws RemoteException;
  
  public abstract IProjectionDelegate getProjection()
    throws RemoteException;
  
  public abstract com.google.android.gms.dynamic.d getTestingHelper()
    throws RemoteException;
  
  public abstract IUiSettingsDelegate getUiSettings()
    throws RemoteException;
  
  public abstract boolean isBuildingsEnabled()
    throws RemoteException;
  
  public abstract boolean isIndoorEnabled()
    throws RemoteException;
  
  public abstract boolean isMyLocationEnabled()
    throws RemoteException;
  
  public abstract boolean isTrafficEnabled()
    throws RemoteException;
  
  public abstract void moveCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setInfoWindowAdapter(d paramd)
    throws RemoteException;
  
  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException;
  
  public abstract void setMapType(int paramInt)
    throws RemoteException;
  
  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setOnCameraChangeListener(e parame)
    throws RemoteException;
  
  public abstract void setOnIndoorStateChangeListener(f paramf)
    throws RemoteException;
  
  public abstract void setOnInfoWindowClickListener(g paramg)
    throws RemoteException;
  
  public abstract void setOnMapClickListener(i parami)
    throws RemoteException;
  
  public abstract void setOnMapLoadedCallback(j paramj)
    throws RemoteException;
  
  public abstract void setOnMapLongClickListener(k paramk)
    throws RemoteException;
  
  public abstract void setOnMarkerClickListener(l paraml)
    throws RemoteException;
  
  public abstract void setOnMarkerDragListener(m paramm)
    throws RemoteException;
  
  public abstract void setOnMyLocationButtonClickListener(n paramn)
    throws RemoteException;
  
  public abstract void setOnMyLocationChangeListener(o paramo)
    throws RemoteException;
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;
  
  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setWatermarkEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void snapshot(s params, com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void stopAnimation()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IGoogleMapDelegate
  {
    public static IGoogleMapDelegate ay(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if ((localObject == null) || (!(localObject instanceof IGoogleMapDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IGoogleMapDelegate)localObject;
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
      CameraPosition localCameraPosition = null;
      Object localObject1 = 1;
      float f;
      Object localObject3;
      IBinder localIBinder1;
      boolean bool1;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        localObject1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localCameraPosition = getCameraPosition();
        paramParcel2.writeNoException();
        if (localCameraPosition == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localCameraPosition.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        f = getMaxZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        f = getMinZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        moveCamera(com.google.android.gms.dynamic.d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCamera(com.google.android.gms.dynamic.d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithCallback(com.google.android.gms.dynamic.d.a.ag(paramParcel1.readStrongBinder()), b.a.aw(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d.a.ag(paramParcel1.readStrongBinder()), paramParcel1.readInt(), b.a.aw(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        stopAnimation();
        paramParcel2.writeNoException();
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = PolylineOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addPolyline((PolylineOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((IPolylineDelegate)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = PolygonOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addPolygon((PolygonOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((com.google.android.gms.maps.model.internal.g)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = MarkerOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addMarker((MarkerOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((com.google.android.gms.maps.model.internal.f)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = GroundOverlayOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addGroundOverlay((GroundOverlayOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((c)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = TileOverlayOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addTileOverlay((TileOverlayOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((h)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        clear();
        paramParcel2.writeNoException();
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i = getMapType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setMapType(paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        bool1 = isTrafficEnabled();
        paramParcel2.writeNoException();
        if (bool1) {
          localObject3 = localObject1;
        }
        paramParcel2.writeInt(localObject3);
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = localObject1;
        }
        setTrafficEnabled(localObject3);
        paramParcel2.writeNoException();
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        bool1 = isIndoorEnabled();
        paramParcel2.writeNoException();
        if (bool1) {
          localObject3 = localObject1;
        }
        paramParcel2.writeInt(localObject3);
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          bool1 = false;
        } else {
          bool1 = localObject1;
        }
        bool1 = setIndoorEnabled(bool1);
        paramParcel2.writeNoException();
        if (bool1) {
          localObject3 = localObject1;
        }
        paramParcel2.writeInt(localObject3);
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        bool1 = isMyLocationEnabled();
        paramParcel2.writeNoException();
        if (bool1) {
          localObject3 = localObject1;
        }
        paramParcel2.writeInt(localObject3);
        break;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = localObject1;
        }
        setMyLocationEnabled(localObject3);
        paramParcel2.writeNoException();
        break;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localObject2 = getMyLocation();
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Location)localObject2).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setLocationSource(ILocationSourceDelegate.a.aA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localObject3 = getUiSettings();
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localObject2 = ((IUiSettingsDelegate)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        break;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localObject3 = getProjection();
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localObject2 = ((IProjectionDelegate)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        break;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnCameraChangeListener(e.a.aD(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapClickListener(i.a.aH(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLongClickListener(k.a.aJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerClickListener(l.a.aK(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerDragListener(m.a.aL(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnInfoWindowClickListener(g.a.aF(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 33: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowAdapter(d.a.az(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localObject3 = getTestingHelper();
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localObject2 = ((com.google.android.gms.dynamic.d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        break;
      case 35: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = CircleOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject3 = addCircle((CircleOptions)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localObject2 = ((com.google.android.gms.maps.model.internal.b)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        break;
      case 36: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationChangeListener(o.a.aN(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 37: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationButtonClickListener(n.a.aM(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 38: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        snapshot(s.a.aS(paramParcel1.readStrongBinder()), com.google.android.gms.dynamic.d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 39: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setPadding(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool2 = isBuildingsEnabled();
        paramParcel2.writeNoException();
        if (bool2) {
          localObject3 = localObject1;
        }
        paramParcel2.writeInt(localObject3);
        break;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = localObject1;
        }
        setBuildingsEnabled(localObject3);
        paramParcel2.writeNoException();
        break;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLoadedCallback(j.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 44: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        localObject3 = getFocusedBuilding();
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (localObject3 != null) {
          localIBinder2 = ((com.google.android.gms.maps.model.internal.d)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        break;
      case 45: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnIndoorStateChangeListener(f.a.aE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 51: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject3 = localObject1;
        }
        setWatermarkEnabled(localObject3);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      }
      return localObject1;
    }
    
    private static class a
      implements IGoogleMapDelegate
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.b addCircle(CircleOptions paramCircleOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/maps/model/CircleOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 35
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 63	com/google/android/gms/maps/model/internal/b$a:aY	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/b;
        //   55: astore 4
        //   57: aload_3
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramCircleOptions	CircleOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   55	11	4	localb	com.google.android.gms.maps.model.internal.b
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public c addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 71	com/google/android/gms/maps/model/GroundOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 12
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 77	com/google/android/gms/maps/model/internal/c$a:aZ	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/c;
        //   55: astore 4
        //   57: aload_3
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramGroundOverlayOptions	GroundOverlayOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   55	11	4	localc	c
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.f addMarker(MarkerOptions paramMarkerOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 82	com/google/android/gms/maps/model/MarkerOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 11
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 88	com/google/android/gms/maps/model/internal/f$a:bc	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/f;
        //   55: astore 4
        //   57: aload_3
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramMarkerOptions	MarkerOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   55	11	4	localf	com.google.android.gms.maps.model.internal.f
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.g addPolygon(PolygonOptions paramPolygonOptions)
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
        //   26: invokevirtual 93	com/google/android/gms/maps/model/PolygonOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 10
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 99	com/google/android/gms/maps/model/internal/g$a:bd	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/g;
        //   55: astore 4
        //   57: aload_2
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramPolygonOptions	PolygonOptions
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   55	11	4	localg	com.google.android.gms.maps.model.internal.g
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
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
        //   26: invokevirtual 104	com/google/android/gms/maps/model/PolylineOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 9
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 110	com/google/android/gms/maps/model/internal/IPolylineDelegate$a:be	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/IPolylineDelegate;
        //   55: astore 4
        //   57: aload_2
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramPolylineOptions	PolylineOptions
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   55	11	4	localIPolylineDelegate	IPolylineDelegate
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public h addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
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
        //   26: invokevirtual 115	com/google/android/gms/maps/model/TileOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 13
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 121	com/google/android/gms/maps/model/internal/h$a:bf	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/h;
        //   55: astore 4
        //   57: aload_2
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: areturn
        //   68: aload_3
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramTileOverlayOptions	TileOverlayOptions
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   55	11	4	localh	h
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public void animateCamera(com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 128 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_5
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 53	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 66	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 66	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 66	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 66	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	com.google.android.gms.dynamic.d
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +66 -> 85
        //   22: aload_1
        //   23: invokeinterface 128 1 0
        //   28: astore 6
        //   30: aload_3
        //   31: aload 6
        //   33: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_2
        //   37: ifnull +11 -> 48
        //   40: aload_2
        //   41: invokeinterface 136 1 0
        //   46: astore 5
        //   48: aload_3
        //   49: aload 5
        //   51: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   58: bipush 6
        //   60: aload_3
        //   61: aload 4
        //   63: iconst_0
        //   64: invokeinterface 50 5 0
        //   69: pop
        //   70: aload 4
        //   72: invokevirtual 53	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 66	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 66	android/os/Parcel:recycle	()V
        //   84: return
        //   85: aconst_null
        //   86: astore 6
        //   88: goto -58 -> 30
        //   91: astore 5
        //   93: aload 4
        //   95: invokevirtual 66	android/os/Parcel:recycle	()V
        //   98: aload_3
        //   99: invokevirtual 66	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramd	com.google.android.gms.dynamic.d
        //   0	105	2	paramb	b
        //   6	93	3	localParcel1	Parcel
        //   10	84	4	localParcel2	Parcel
        //   1	49	5	localIBinder1	IBinder
        //   91	12	5	localObject	Object
        //   28	59	6	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	75	91	finally
      }
      
      /* Error */
      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +76 -> 97
        //   24: aload_1
        //   25: invokeinterface 128 1 0
        //   30: astore 7
        //   32: aload 4
        //   34: aload 7
        //   36: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: aload_3
        //   46: ifnull +11 -> 57
        //   49: aload_3
        //   50: invokeinterface 136 1 0
        //   55: astore 6
        //   57: aload 4
        //   59: aload 6
        //   61: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   64: aload_0
        //   65: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   68: bipush 7
        //   70: aload 4
        //   72: aload 5
        //   74: iconst_0
        //   75: invokeinterface 50 5 0
        //   80: pop
        //   81: aload 5
        //   83: invokevirtual 53	android/os/Parcel:readException	()V
        //   86: aload 5
        //   88: invokevirtual 66	android/os/Parcel:recycle	()V
        //   91: aload 4
        //   93: invokevirtual 66	android/os/Parcel:recycle	()V
        //   96: return
        //   97: aconst_null
        //   98: astore 7
        //   100: goto -68 -> 32
        //   103: astore 6
        //   105: aload 5
        //   107: invokevirtual 66	android/os/Parcel:recycle	()V
        //   110: aload 4
        //   112: invokevirtual 66	android/os/Parcel:recycle	()V
        //   115: aload 6
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramd	com.google.android.gms.dynamic.d
        //   0	118	2	paramInt	int
        //   0	118	3	paramb	b
        //   6	105	4	localParcel1	Parcel
        //   11	95	5	localParcel2	Parcel
        //   1	59	6	localIBinder1	IBinder
        //   103	13	6	localObject	Object
        //   30	69	7	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	86	103	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void clear()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(14, localParcel1, localParcel2, 0);
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
      public CameraPosition getCameraPosition()
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
        //   15: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_2
        //   20: aload_1
        //   21: iconst_0
        //   22: invokeinterface 50 5 0
        //   27: pop
        //   28: aload_1
        //   29: invokevirtual 53	android/os/Parcel:readException	()V
        //   32: aload_1
        //   33: invokevirtual 145	android/os/Parcel:readInt	()I
        //   36: ifeq +23 -> 59
        //   39: getstatic 151	com/google/android/gms/maps/model/CameraPosition:CREATOR	Lcom/google/android/gms/maps/model/CameraPositionCreator;
        //   42: aload_1
        //   43: invokevirtual 157	com/google/android/gms/maps/model/CameraPositionCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/CameraPosition;
        //   46: astore_3
        //   47: aload_3
        //   48: astore_3
        //   49: aload_1
        //   50: invokevirtual 66	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 66	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: areturn
        //   59: aconst_null
        //   60: astore_3
        //   61: goto -12 -> 49
        //   64: astore_3
        //   65: aload_1
        //   66: invokevirtual 66	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 66	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   7	59	1	localParcel1	Parcel
        //   3	67	2	localParcel2	Parcel
        //   46	15	3	localCameraPosition	CameraPosition
        //   64	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
      }
      
      public com.google.android.gms.maps.model.internal.d getFocusedBuilding()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(44, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.maps.model.internal.d locald = com.google.android.gms.maps.model.internal.d.a.ba(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getMapType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(15, localParcel1, localParcel2, 0);
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
      
      public float getMaxZoomLevel()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(2, localParcel2, localParcel1, 0);
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
      
      public float getMinZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(3, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public Location getMyLocation()
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
        //   15: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   18: bipush 23
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 50 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 53	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 145	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 179	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_2
        //   44: invokeinterface 184 2 0
        //   49: checkcast 176	android/location/Location
        //   52: astore_3
        //   53: aload_2
        //   54: invokevirtual 66	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: areturn
        //   63: aconst_null
        //   64: astore_3
        //   65: goto -12 -> 53
        //   68: astore_3
        //   69: aload_2
        //   70: invokevirtual 66	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: invokevirtual 66	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   3	71	1	localParcel1	Parcel
        //   7	63	2	localParcel2	Parcel
        //   52	13	3	localLocation	Location
        //   68	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public IProjectionDelegate getProjection()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(26, localParcel2, localParcel1, 0);
          localParcel1.readException();
          IProjectionDelegate localIProjectionDelegate = IProjectionDelegate.a.aR(localParcel1.readStrongBinder());
          return localIProjectionDelegate;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public com.google.android.gms.dynamic.d getTestingHelper()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(34, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.dynamic.d locald = com.google.android.gms.dynamic.d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IUiSettingsDelegate getUiSettings()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IUiSettingsDelegate localIUiSettingsDelegate = IUiSettingsDelegate.a.aW(localParcel2.readStrongBinder());
          return localIUiSettingsDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isBuildingsEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(40, localParcel1, localParcel2, 0);
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
      
      public boolean isIndoorEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(19, localParcel2, localParcel1, 0);
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
      
      public boolean isMyLocationEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(21, localParcel2, localParcel1, 0);
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
      
      public boolean isTrafficEnabled()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(17, localParcel1, localParcel2, 0);
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
      public void moveCamera(com.google.android.gms.dynamic.d paramd)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 128 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_4
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 53	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 66	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 66	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 66	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 66	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	com.google.android.gms.dynamic.d
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      public void setBuildingsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(41, localParcel1, localParcel2, 0);
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
      public boolean setIndoorEnabled(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +54 -> 72
        //   21: iload 4
        //   23: istore 5
        //   25: aload_2
        //   26: iload 5
        //   28: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   31: aload_0
        //   32: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   35: bipush 20
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 53	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 145	android/os/Parcel:readInt	()I
        //   54: istore 5
        //   56: iload 5
        //   58: ifeq +20 -> 78
        //   61: aload_3
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: aload_2
        //   66: invokevirtual 66	android/os/Parcel:recycle	()V
        //   69: iload 4
        //   71: ireturn
        //   72: iconst_0
        //   73: istore 5
        //   75: goto -50 -> 25
        //   78: iconst_0
        //   79: istore 4
        //   81: goto -20 -> 61
        //   84: astore 4
        //   86: aload_3
        //   87: invokevirtual 66	android/os/Parcel:recycle	()V
        //   90: aload_2
        //   91: invokevirtual 66	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramBoolean	boolean
        //   6	85	2	localParcel1	Parcel
        //   10	77	3	localParcel2	Parcel
        //   1	79	4	i	int
        //   84	11	4	localObject	Object
        //   23	4	5	j	int
        //   54	20	5	k	int
        // Exception table:
        //   from	to	target	type
        //   11	56	84	finally
      }
      
      /* Error */
      public void setInfoWindowAdapter(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 223 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 33
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramd	d
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 228 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 24
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramILocationSourceDelegate	ILocationSourceDelegate
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public void setMapType(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt);
          this.ko.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setMyLocationEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(22, localParcel2, localParcel1, 0);
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
      public void setOnCameraChangeListener(e parame)
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
        //   19: invokeinterface 235 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 27
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	parame	e
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnIndoorStateChangeListener(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 240 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 45
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramf	f
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnInfoWindowClickListener(g paramg)
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
        //   19: invokeinterface 245 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 32
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramg	g
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMapClickListener(i parami)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 250 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 28
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	parami	i
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMapLoadedCallback(j paramj)
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
        //   19: invokeinterface 255 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 42
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramj	j
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMapLongClickListener(k paramk)
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
        //   19: invokeinterface 260 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 29
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramk	k
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMarkerClickListener(l paraml)
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
        //   19: invokeinterface 265 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 30
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paraml	l
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMarkerDragListener(m paramm)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 270 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 31
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramm	m
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMyLocationButtonClickListener(n paramn)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 275 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 37
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramn	n
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void setOnMyLocationChangeListener(o paramo)
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
        //   19: invokeinterface 280 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 36
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 66	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 66	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 66	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramo	o
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          this.ko.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setTrafficEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setWatermarkEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(51, localParcel1, localParcel2, 0);
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
      public void snapshot(s params, com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +66 -> 85
        //   22: aload_1
        //   23: invokeinterface 289 1 0
        //   28: astore 6
        //   30: aload_3
        //   31: aload 6
        //   33: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_2
        //   37: ifnull +11 -> 48
        //   40: aload_2
        //   41: invokeinterface 128 1 0
        //   46: astore 5
        //   48: aload_3
        //   49: aload 5
        //   51: invokevirtual 131	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 18	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:ko	Landroid/os/IBinder;
        //   58: bipush 38
        //   60: aload_3
        //   61: aload 4
        //   63: iconst_0
        //   64: invokeinterface 50 5 0
        //   69: pop
        //   70: aload 4
        //   72: invokevirtual 53	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 66	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 66	android/os/Parcel:recycle	()V
        //   84: return
        //   85: aconst_null
        //   86: astore 6
        //   88: goto -58 -> 30
        //   91: astore 5
        //   93: aload 4
        //   95: invokevirtual 66	android/os/Parcel:recycle	()V
        //   98: aload_3
        //   99: invokevirtual 66	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	params	s
        //   0	105	2	paramd	com.google.android.gms.dynamic.d
        //   6	93	3	localParcel1	Parcel
        //   10	84	4	localParcel2	Parcel
        //   1	49	5	localIBinder1	IBinder
        //   91	12	5	localObject	Object
        //   28	59	6	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	75	91	finally
      }
      
      public void stopAnimation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.maps.internal.IGoogleMapDelegate
 * JD-Core Version:    0.7.0.1
 */