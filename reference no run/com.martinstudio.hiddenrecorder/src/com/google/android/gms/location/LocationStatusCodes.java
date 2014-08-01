package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class LocationStatusCodes
{
  public static final int ERROR = 1;
  public static final int GEOFENCE_NOT_AVAILABLE = 1000;
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
  public static final int SUCCESS;
  
  public static int cJ(int paramInt)
  {
    if (((paramInt < 0) || (paramInt > 1)) && ((1000 > paramInt) || (paramInt > 1002))) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  public static Status cK(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
      paramInt = 13;
    }
    return new Status(paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationStatusCodes
 * JD-Core Version:    0.7.0.1
 */