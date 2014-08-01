package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.ji;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String Oy = null;
    private int UX = 0;
    private long UY = -9223372036854775808L;
    private short UZ = -1;
    private double Va;
    private double Vb;
    private float Vc;
    private int Vd = 0;
    private int Ve = -1;
    
    public Geofence build()
    {
      if (this.Oy != null)
      {
        if (this.UX != 0)
        {
          if (((0x4 & this.UX) == 0) || (this.Ve >= 0))
          {
            if (this.UY != -9223372036854775808L)
            {
              if (this.UZ != -1)
              {
                if (this.Vd >= 0) {
                  return new ji(this.Oy, this.UX, (short)1, this.Va, this.Vb, this.Vc, this.UY, this.Vd, this.Ve);
                }
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
              }
              throw new IllegalArgumentException("Geofence region not set.");
            }
            throw new IllegalArgumentException("Expiration not set.");
          }
          throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
        throw new IllegalArgumentException("Transitions types not set.");
      }
      throw new IllegalArgumentException("Request ID not set.");
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.UZ = 1;
      this.Va = paramDouble1;
      this.Vb = paramDouble2;
      this.Vc = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong >= 0L) {
        this.UY = (paramLong + SystemClock.elapsedRealtime());
      } else {
        this.UY = -1L;
      }
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.Ve = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.Vd = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.Oy = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.UX = paramInt;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.Geofence
 * JD-Core Version:    0.7.0.1
 */