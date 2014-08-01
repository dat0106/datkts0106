package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection
{
  private final IProjectionDelegate ZJ;
  
  Projection(IProjectionDelegate paramIProjectionDelegate)
  {
    this.ZJ = paramIProjectionDelegate;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    try
    {
      LatLng localLatLng = this.ZJ.fromScreenLocation(e.h(paramPoint));
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public VisibleRegion getVisibleRegion()
  {
    try
    {
      VisibleRegion localVisibleRegion = this.ZJ.getVisibleRegion();
      return localVisibleRegion;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    try
    {
      Point localPoint = (Point)e.e(this.ZJ.toScreenLocation(paramLatLng));
      return localPoint;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.Projection
 * JD-Core Version:    0.7.0.1
 */