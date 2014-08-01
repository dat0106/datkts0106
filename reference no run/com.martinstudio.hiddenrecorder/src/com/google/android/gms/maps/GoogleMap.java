package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.a;
import com.google.android.gms.maps.internal.b.a;
import com.google.android.gms.maps.internal.d.a;
import com.google.android.gms.maps.internal.e.a;
import com.google.android.gms.maps.internal.f.a;
import com.google.android.gms.maps.internal.g.a;
import com.google.android.gms.maps.internal.h;
import com.google.android.gms.maps.internal.i.a;
import com.google.android.gms.maps.internal.j.a;
import com.google.android.gms.maps.internal.k.a;
import com.google.android.gms.maps.internal.l.a;
import com.google.android.gms.maps.internal.m.a;
import com.google.android.gms.maps.internal.n.a;
import com.google.android.gms.maps.internal.o.a;
import com.google.android.gms.maps.internal.s.a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.f;

public final class GoogleMap
{
  public static final int MAP_TYPE_HYBRID = 4;
  public static final int MAP_TYPE_NONE = 0;
  public static final int MAP_TYPE_NORMAL = 1;
  public static final int MAP_TYPE_SATELLITE = 2;
  public static final int MAP_TYPE_TERRAIN = 3;
  private final IGoogleMapDelegate YW;
  private UiSettings YX;
  
  protected GoogleMap(IGoogleMapDelegate paramIGoogleMapDelegate)
  {
    this.YW = ((IGoogleMapDelegate)hn.f(paramIGoogleMapDelegate));
  }
  
  public final Circle addCircle(CircleOptions paramCircleOptions)
  {
    try
    {
      Circle localCircle = new Circle(this.YW.addCircle(paramCircleOptions));
      return localCircle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  /* Error */
  public final com.google.android.gms.maps.model.GroundOverlay addGroundOverlay(com.google.android.gms.maps.model.GroundOverlayOptions paramGroundOverlayOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: aload_1
    //   5: invokeinterface 124 2 0
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +14 -> 26
    //   15: new 126	com/google/android/gms/maps/model/GroundOverlay
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 129	com/google/android/gms/maps/model/GroundOverlay:<init>	(Lcom/google/android/gms/maps/model/internal/c;)V
    //   23: astore_2
    //   24: aload_2
    //   25: areturn
    //   26: aconst_null
    //   27: astore_2
    //   28: goto -4 -> 24
    //   31: astore_2
    //   32: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	GoogleMap
    //   0	41	1	paramGroundOverlayOptions	com.google.android.gms.maps.model.GroundOverlayOptions
    //   10	18	2	localObject	Object
    //   31	6	2	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   0	24	31	android/os/RemoteException
  }
  
  /* Error */
  public final Marker addMarker(com.google.android.gms.maps.model.MarkerOptions paramMarkerOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: aload_1
    //   5: invokeinterface 134 2 0
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +14 -> 26
    //   15: new 136	com/google/android/gms/maps/model/Marker
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 139	com/google/android/gms/maps/model/Marker:<init>	(Lcom/google/android/gms/maps/model/internal/f;)V
    //   23: astore_2
    //   24: aload_2
    //   25: areturn
    //   26: aconst_null
    //   27: astore_2
    //   28: goto -4 -> 24
    //   31: astore_2
    //   32: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	GoogleMap
    //   0	41	1	paramMarkerOptions	com.google.android.gms.maps.model.MarkerOptions
    //   10	18	2	localObject	Object
    //   31	6	2	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   0	24	31	android/os/RemoteException
  }
  
  public final Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    try
    {
      Polygon localPolygon = new Polygon(this.YW.addPolygon(paramPolygonOptions));
      return localPolygon;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    try
    {
      Polyline localPolyline = new Polyline(this.YW.addPolyline(paramPolylineOptions));
      return localPolyline;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  /* Error */
  public final com.google.android.gms.maps.model.TileOverlay addTileOverlay(com.google.android.gms.maps.model.TileOverlayOptions paramTileOverlayOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: aload_1
    //   5: invokeinterface 164 2 0
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +14 -> 26
    //   15: new 166	com/google/android/gms/maps/model/TileOverlay
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 169	com/google/android/gms/maps/model/TileOverlay:<init>	(Lcom/google/android/gms/maps/model/internal/h;)V
    //   23: astore_2
    //   24: aload_2
    //   25: areturn
    //   26: aconst_null
    //   27: astore_2
    //   28: goto -4 -> 24
    //   31: astore_2
    //   32: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	GoogleMap
    //   0	41	1	paramTileOverlayOptions	com.google.android.gms.maps.model.TileOverlayOptions
    //   10	18	2	localObject	Object
    //   31	6	2	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   0	24	31	android/os/RemoteException
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.YW.animateCamera(paramCameraUpdate.ji());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  /* Error */
  public final void animateCamera(CameraUpdate paramCameraUpdate, int paramInt, CancelableCallback paramCancelableCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: astore 5
    //   6: aload_1
    //   7: invokevirtual 177	com/google/android/gms/maps/CameraUpdate:ji	()Lcom/google/android/gms/dynamic/d;
    //   10: astore 6
    //   12: aload_3
    //   13: ifnonnull +19 -> 32
    //   16: aconst_null
    //   17: astore 4
    //   19: aload 5
    //   21: aload 6
    //   23: iload_2
    //   24: aload 4
    //   26: invokeinterface 185 4 0
    //   31: return
    //   32: new 32	com/google/android/gms/maps/GoogleMap$a
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 188	com/google/android/gms/maps/GoogleMap$a:<init>	(Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V
    //   40: astore 4
    //   42: goto -23 -> 19
    //   45: astore 4
    //   47: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	GoogleMap
    //   0	57	1	paramCameraUpdate	CameraUpdate
    //   0	57	2	paramInt	int
    //   0	57	3	paramCancelableCallback	CancelableCallback
    //   17	24	4	localObject	Object
    //   45	7	4	localRemoteException	RemoteException
    //   4	16	5	localIGoogleMapDelegate	IGoogleMapDelegate
    //   10	12	6	locald	com.google.android.gms.dynamic.d
    // Exception table:
    //   from	to	target	type
    //   0	42	45	android/os/RemoteException
  }
  
  /* Error */
  public final void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: astore 5
    //   6: aload_1
    //   7: invokevirtual 177	com/google/android/gms/maps/CameraUpdate:ji	()Lcom/google/android/gms/dynamic/d;
    //   10: astore 4
    //   12: aload_2
    //   13: ifnonnull +16 -> 29
    //   16: aconst_null
    //   17: astore_3
    //   18: aload 5
    //   20: aload 4
    //   22: aload_3
    //   23: invokeinterface 193 3 0
    //   28: return
    //   29: new 32	com/google/android/gms/maps/GoogleMap$a
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 188	com/google/android/gms/maps/GoogleMap$a:<init>	(Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;)V
    //   37: astore_3
    //   38: goto -20 -> 18
    //   41: astore_3
    //   42: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	GoogleMap
    //   0	51	1	paramCameraUpdate	CameraUpdate
    //   0	51	2	paramCancelableCallback	CancelableCallback
    //   17	21	3	localObject	Object
    //   41	6	3	localRemoteException	RemoteException
    //   10	11	4	locald	com.google.android.gms.dynamic.d
    //   4	15	5	localIGoogleMapDelegate	IGoogleMapDelegate
    // Exception table:
    //   from	to	target	type
    //   0	38	41	android/os/RemoteException
  }
  
  public final void clear()
  {
    try
    {
      this.YW.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final CameraPosition getCameraPosition()
  {
    try
    {
      CameraPosition localCameraPosition = this.YW.getCameraPosition();
      return localCameraPosition;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  /* Error */
  public IndoorBuilding getFocusedBuilding()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/google/android/gms/maps/GoogleMap:YW	Lcom/google/android/gms/maps/internal/IGoogleMapDelegate;
    //   4: invokeinterface 205 1 0
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +14 -> 25
    //   14: new 207	com/google/android/gms/maps/model/IndoorBuilding
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 210	com/google/android/gms/maps/model/IndoorBuilding:<init>	(Lcom/google/android/gms/maps/model/internal/d;)V
    //   22: astore_1
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -4 -> 23
    //   30: astore_1
    //   31: new 116	com/google/android/gms/maps/model/RuntimeRemoteException
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 119	com/google/android/gms/maps/model/RuntimeRemoteException:<init>	(Landroid/os/RemoteException;)V
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	GoogleMap
    //   9	18	1	localObject	Object
    //   30	6	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   0	23	30	android/os/RemoteException
  }
  
  public final int getMapType()
  {
    try
    {
      int i = this.YW.getMapType();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final float getMaxZoomLevel()
  {
    try
    {
      float f = this.YW.getMaxZoomLevel();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final float getMinZoomLevel()
  {
    try
    {
      float f = this.YW.getMinZoomLevel();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  @Deprecated
  public final Location getMyLocation()
  {
    try
    {
      Location localLocation = this.YW.getMyLocation();
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final Projection getProjection()
  {
    try
    {
      Projection localProjection = new Projection(this.YW.getProjection());
      return localProjection;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final UiSettings getUiSettings()
  {
    try
    {
      if (this.YX == null) {
        this.YX = new UiSettings(this.YW.getUiSettings());
      }
      UiSettings localUiSettings = this.YX;
      return localUiSettings;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final boolean isBuildingsEnabled()
  {
    try
    {
      boolean bool = this.YW.isBuildingsEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final boolean isIndoorEnabled()
  {
    try
    {
      boolean bool = this.YW.isIndoorEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final boolean isMyLocationEnabled()
  {
    try
    {
      boolean bool = this.YW.isMyLocationEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final boolean isTrafficEnabled()
  {
    try
    {
      boolean bool = this.YW.isTrafficEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  IGoogleMapDelegate jk()
  {
    return this.YW;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.YW.moveCamera(paramCameraUpdate.ji());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setBuildingsEnabled(boolean paramBoolean)
  {
    try
    {
      this.YW.setBuildingsEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final boolean setIndoorEnabled(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.YW.setIndoorEnabled(paramBoolean);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setInfoWindowAdapter(final InfoWindowAdapter paramInfoWindowAdapter)
  {
    if (paramInfoWindowAdapter == null) {}
    try
    {
      this.YW.setInfoWindowAdapter(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setInfoWindowAdapter(new d.a()
    {
      public com.google.android.gms.dynamic.d f(f paramAnonymousf)
      {
        return e.h(paramInfoWindowAdapter.getInfoWindow(new Marker(paramAnonymousf)));
      }
      
      public com.google.android.gms.dynamic.d g(f paramAnonymousf)
      {
        return e.h(paramInfoWindowAdapter.getInfoContents(new Marker(paramAnonymousf)));
      }
    });
  }
  
  public final void setLocationSource(final LocationSource paramLocationSource)
  {
    if (paramLocationSource == null) {}
    try
    {
      this.YW.setLocationSource(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setLocationSource(new ILocationSourceDelegate.a()
    {
      public void activate(final h paramAnonymoush)
      {
        paramLocationSource.activate(new LocationSource.OnLocationChangedListener()
        {
          public void onLocationChanged(Location paramAnonymous2Location)
          {
            try
            {
              paramAnonymoush.k(e.h(paramAnonymous2Location));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              throw new RuntimeRemoteException(localRemoteException);
            }
          }
        });
      }
      
      public void deactivate()
      {
        paramLocationSource.deactivate();
      }
    });
  }
  
  public final void setMapType(int paramInt)
  {
    try
    {
      this.YW.setMapType(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    try
    {
      this.YW.setMyLocationEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setOnCameraChangeListener(final OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (paramOnCameraChangeListener == null) {}
    try
    {
      this.YW.setOnCameraChangeListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnCameraChangeListener(new e.a()
    {
      public void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        paramOnCameraChangeListener.onCameraChange(paramAnonymousCameraPosition);
      }
    });
  }
  
  public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    if (paramOnIndoorStateChangeListener == null) {}
    try
    {
      this.YW.setOnIndoorStateChangeListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnIndoorStateChangeListener(new f.a()
    {
      public void a(com.google.android.gms.maps.model.internal.d paramAnonymousd)
      {
        paramOnIndoorStateChangeListener.onIndoorLevelActivated(new IndoorBuilding(paramAnonymousd));
      }
      
      public void onIndoorBuildingFocused()
      {
        paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
      }
    });
  }
  
  public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if (paramOnInfoWindowClickListener == null) {}
    try
    {
      this.YW.setOnInfoWindowClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnInfoWindowClickListener(new g.a()
    {
      public void e(f paramAnonymousf)
      {
        paramOnInfoWindowClickListener.onInfoWindowClick(new Marker(paramAnonymousf));
      }
    });
  }
  
  public final void setOnMapClickListener(final OnMapClickListener paramOnMapClickListener)
  {
    if (paramOnMapClickListener == null) {}
    try
    {
      this.YW.setOnMapClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMapClickListener(new i.a()
    {
      public void onMapClick(LatLng paramAnonymousLatLng)
      {
        paramOnMapClickListener.onMapClick(paramAnonymousLatLng);
      }
    });
  }
  
  public void setOnMapLoadedCallback(final OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    if (paramOnMapLoadedCallback == null) {}
    try
    {
      this.YW.setOnMapLoadedCallback(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMapLoadedCallback(new j.a()
    {
      public void onMapLoaded()
        throws RemoteException
      {
        paramOnMapLoadedCallback.onMapLoaded();
      }
    });
  }
  
  public final void setOnMapLongClickListener(final OnMapLongClickListener paramOnMapLongClickListener)
  {
    if (paramOnMapLongClickListener == null) {}
    try
    {
      this.YW.setOnMapLongClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMapLongClickListener(new k.a()
    {
      public void onMapLongClick(LatLng paramAnonymousLatLng)
      {
        paramOnMapLongClickListener.onMapLongClick(paramAnonymousLatLng);
      }
    });
  }
  
  public final void setOnMarkerClickListener(final OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (paramOnMarkerClickListener == null) {}
    try
    {
      this.YW.setOnMarkerClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMarkerClickListener(new l.a()
    {
      public boolean a(f paramAnonymousf)
      {
        return paramOnMarkerClickListener.onMarkerClick(new Marker(paramAnonymousf));
      }
    });
  }
  
  public final void setOnMarkerDragListener(final OnMarkerDragListener paramOnMarkerDragListener)
  {
    if (paramOnMarkerDragListener == null) {}
    try
    {
      this.YW.setOnMarkerDragListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMarkerDragListener(new m.a()
    {
      public void b(f paramAnonymousf)
      {
        paramOnMarkerDragListener.onMarkerDragStart(new Marker(paramAnonymousf));
      }
      
      public void c(f paramAnonymousf)
      {
        paramOnMarkerDragListener.onMarkerDragEnd(new Marker(paramAnonymousf));
      }
      
      public void d(f paramAnonymousf)
      {
        paramOnMarkerDragListener.onMarkerDrag(new Marker(paramAnonymousf));
      }
    });
  }
  
  public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener paramOnMyLocationButtonClickListener)
  {
    if (paramOnMyLocationButtonClickListener == null) {}
    try
    {
      this.YW.setOnMyLocationButtonClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMyLocationButtonClickListener(new n.a()
    {
      public boolean onMyLocationButtonClick()
        throws RemoteException
      {
        return paramOnMyLocationButtonClickListener.onMyLocationButtonClick();
      }
    });
  }
  
  @Deprecated
  public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    if (paramOnMyLocationChangeListener == null) {}
    try
    {
      this.YW.setOnMyLocationChangeListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.YW.setOnMyLocationChangeListener(new o.a()
    {
      public void f(com.google.android.gms.dynamic.d paramAnonymousd)
      {
        paramOnMyLocationChangeListener.onMyLocationChange((Location)e.e(paramAnonymousd));
      }
    });
  }
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.YW.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    try
    {
      this.YW.setTrafficEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    snapshot(paramSnapshotReadyCallback, null);
  }
  
  public final void snapshot(final SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    for (Object localObject = e.h(paramBitmap);; localObject = null)
    {
      localObject = (e)localObject;
      try
      {
        this.YW.snapshot(new s.a()
        {
          public void g(com.google.android.gms.dynamic.d paramAnonymousd)
            throws RemoteException
          {
            paramSnapshotReadyCallback.onSnapshotReady((Bitmap)e.e(paramAnonymousd));
          }
          
          public void onSnapshotReady(Bitmap paramAnonymousBitmap)
            throws RemoteException
          {
            paramSnapshotReadyCallback.onSnapshotReady(paramAnonymousBitmap);
          }
        }, (com.google.android.gms.dynamic.d)localObject);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public final void stopAnimation()
  {
    try
    {
      this.YW.stopAnimation();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  private static final class a
    extends b.a
  {
    private final GoogleMap.CancelableCallback Zo;
    
    a(GoogleMap.CancelableCallback paramCancelableCallback)
    {
      this.Zo = paramCancelableCallback;
    }
    
    public void onCancel()
    {
      this.Zo.onCancel();
    }
    
    public void onFinish()
    {
      this.Zo.onFinish();
    }
  }
  
  public static abstract interface OnMapLoadedCallback
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMyLocationButtonClickListener
  {
    public abstract boolean onMyLocationButtonClick();
  }
  
  @Deprecated
  public static abstract interface OnMyLocationChangeListener
  {
    public abstract void onMyLocationChange(Location paramLocation);
  }
  
  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoContents(Marker paramMarker);
    
    public abstract View getInfoWindow(Marker paramMarker);
  }
  
  public static abstract interface SnapshotReadyCallback
  {
    public abstract void onSnapshotReady(Bitmap paramBitmap);
  }
  
  public static abstract interface CancelableCallback
  {
    public abstract void onCancel();
    
    public abstract void onFinish();
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }
  
  public static abstract interface OnCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnIndoorStateChangeListener
  {
    public abstract void onIndoorBuildingFocused();
    
    public abstract void onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMap
 * JD-Core Version:    0.7.0.1
 */