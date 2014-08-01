package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory
{
  private static ICameraUpdateFactoryDelegate YV;
  
  static void a(ICameraUpdateFactoryDelegate paramICameraUpdateFactoryDelegate)
  {
    if (YV == null) {
      YV = (ICameraUpdateFactoryDelegate)hn.f(paramICameraUpdateFactoryDelegate);
    }
  }
  
  private static ICameraUpdateFactoryDelegate jj()
  {
    return (ICameraUpdateFactoryDelegate)hn.b(YV, "CameraUpdateFactory is not initialized");
  }
  
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().newCameraPosition(paramCameraPosition));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().newLatLng(paramLatLng));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().newLatLngBounds(paramLatLngBounds, paramInt));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().newLatLngBoundsWithSize(paramLatLngBounds, paramInt1, paramInt2, paramInt3));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().newLatLngZoom(paramLatLng, paramFloat));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().scrollBy(paramFloat1, paramFloat2));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().zoomBy(paramFloat));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().zoomByWithFocus(paramFloat, paramPoint.x, paramPoint.y));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomIn()
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().zoomIn());
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomOut()
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().zoomOut());
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(jj().zoomTo(paramFloat));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */