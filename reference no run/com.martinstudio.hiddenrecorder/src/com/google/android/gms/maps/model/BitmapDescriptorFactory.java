package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.a;

public final class BitmapDescriptorFactory
{
  public static final float HUE_AZURE = 210.0F;
  public static final float HUE_BLUE = 240.0F;
  public static final float HUE_CYAN = 180.0F;
  public static final float HUE_GREEN = 120.0F;
  public static final float HUE_MAGENTA = 300.0F;
  public static final float HUE_ORANGE = 30.0F;
  public static final float HUE_RED = 0.0F;
  public static final float HUE_ROSE = 330.0F;
  public static final float HUE_VIOLET = 270.0F;
  public static final float HUE_YELLOW = 60.0F;
  private static a aaj;
  
  public static void a(a parama)
  {
    if (aaj == null) {
      aaj = (a)hn.f(parama);
    }
  }
  
  public static BitmapDescriptor defaultMarker()
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().jM());
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().c(paramFloat));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().bs(paramString));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().b(paramBitmap));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().bt(paramString));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().bu(paramString));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(jH().cX(paramInt));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  private static a jH()
  {
    return (a)hn.b(aaj, "IBitmapDescriptorFactory is not initialized");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */