package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.p.a;
import com.google.android.gms.maps.internal.q.a;
import com.google.android.gms.maps.internal.r.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{
  private final IStreetViewPanoramaDelegate ZK;
  
  protected StreetViewPanorama(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate)
  {
    this.ZK = ((IStreetViewPanoramaDelegate)hn.f(paramIStreetViewPanoramaDelegate));
  }
  
  public void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
  {
    try
    {
      this.ZK.animateTo(paramStreetViewPanoramaCamera, paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public StreetViewPanoramaLocation getLocation()
  {
    try
    {
      StreetViewPanoramaLocation localStreetViewPanoramaLocation = this.ZK.getStreetViewPanoramaLocation();
      return localStreetViewPanoramaLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public StreetViewPanoramaCamera getPanoramaCamera()
  {
    try
    {
      StreetViewPanoramaCamera localStreetViewPanoramaCamera = this.ZK.getPanoramaCamera();
      return localStreetViewPanoramaCamera;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isPanningGesturesEnabled()
  {
    try
    {
      boolean bool = this.ZK.isPanningGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isStreetNamesEnabled()
  {
    try
    {
      boolean bool = this.ZK.isStreetNamesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isUserNavigationEnabled()
  {
    try
    {
      boolean bool = this.ZK.isUserNavigationEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.ZK.isZoomGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  IStreetViewPanoramaDelegate jw()
  {
    return this.ZK;
  }
  
  public Point orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    try
    {
      Point localPoint = (Point)e.e(this.ZK.orientationToPoint(paramStreetViewPanoramaOrientation));
      return localPoint;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public StreetViewPanoramaOrientation pointToOrientation(Point paramPoint)
  {
    try
    {
      StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = this.ZK.pointToOrientation(e.h(paramPoint));
      return localStreetViewPanoramaOrientation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener paramOnStreetViewPanoramaCameraChangeListener)
  {
    if (paramOnStreetViewPanoramaCameraChangeListener == null) {}
    try
    {
      this.ZK.setOnStreetViewPanoramaCameraChangeListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.ZK.setOnStreetViewPanoramaCameraChangeListener(new p.a()
    {
      public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramAnonymousStreetViewPanoramaCamera)
      {
        paramOnStreetViewPanoramaCameraChangeListener.onStreetViewPanoramaCameraChange(paramAnonymousStreetViewPanoramaCamera);
      }
    });
  }
  
  public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener paramOnStreetViewPanoramaChangeListener)
  {
    if (paramOnStreetViewPanoramaChangeListener == null) {}
    try
    {
      this.ZK.setOnStreetViewPanoramaChangeListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.ZK.setOnStreetViewPanoramaChangeListener(new q.a()
    {
      public void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramAnonymousStreetViewPanoramaLocation)
      {
        paramOnStreetViewPanoramaChangeListener.onStreetViewPanoramaChange(paramAnonymousStreetViewPanoramaLocation);
      }
    });
  }
  
  public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener paramOnStreetViewPanoramaClickListener)
  {
    if (paramOnStreetViewPanoramaClickListener == null) {}
    try
    {
      this.ZK.setOnStreetViewPanoramaClickListener(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
    this.ZK.setOnStreetViewPanoramaClickListener(new r.a()
    {
      public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramAnonymousStreetViewPanoramaOrientation)
      {
        paramOnStreetViewPanoramaClickListener.onStreetViewPanoramaClick(paramAnonymousStreetViewPanoramaOrientation);
      }
    });
  }
  
  public void setPanningGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ZK.enablePanning(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.ZK.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setPosition(LatLng paramLatLng, int paramInt)
  {
    try
    {
      this.ZK.setPositionWithRadius(paramLatLng, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setPosition(String paramString)
  {
    try
    {
      this.ZK.setPositionWithID(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setStreetNamesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ZK.enableStreetNames(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setUserNavigationEnabled(boolean paramBoolean)
  {
    try
    {
      this.ZK.enableUserNavigation(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.ZK.enableZoom(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static abstract interface OnStreetViewPanoramaClickListener
  {
    public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
  
  public static abstract interface OnStreetViewPanoramaCameraChangeListener
  {
    public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramStreetViewPanoramaCamera);
  }
  
  public static abstract interface OnStreetViewPanoramaChangeListener
  {
    public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramStreetViewPanoramaLocation);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanorama
 * JD-Core Version:    0.7.0.1
 */