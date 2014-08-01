package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ji
  implements SafeParcelable, Geofence
{
  public static final jj CREATOR = new jj();
  private final String Oy;
  private final int UX;
  private final short UZ;
  private final long VW;
  private final double Va;
  private final double Vb;
  private final float Vc;
  private final int Vd;
  private final int Ve;
  private final int xJ;
  
  public ji(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    bq(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    int i = cM(paramInt2);
    this.xJ = paramInt1;
    this.UZ = paramShort;
    this.Oy = paramString;
    this.Va = paramDouble1;
    this.Vb = paramDouble2;
    this.Vc = paramFloat;
    this.VW = paramLong;
    this.UX = i;
    this.Vd = paramInt3;
    this.Ve = paramInt4;
  }
  
  public ji(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= 90.0D) && (paramDouble1 >= -90.0D))
    {
      if ((paramDouble2 <= 180.0D) && (paramDouble2 >= -180.0D)) {
        return;
      }
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
    throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
  }
  
  private static void b(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    throw new IllegalArgumentException("invalid radius: " + paramFloat);
  }
  
  private static void bq(String paramString)
  {
    if ((paramString != null) && (paramString.length() <= 100)) {
      return;
    }
    throw new IllegalArgumentException("requestId is null or too long: " + paramString);
  }
  
  private static int cM(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i != 0) {
      return i;
    }
    throw new IllegalArgumentException("No supported transition specified: " + paramInt);
  }
  
  private static String cN(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      break;
    case 1: 
      str = "CIRCLE";
    }
    return str;
  }
  
  public static ji h(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    ji localji = CREATOR.bt(localParcel);
    localParcel.recycle();
    return localji;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if (paramObject != null)
      {
        if ((paramObject instanceof ji))
        {
          ji localji = (ji)paramObject;
          if (this.Vc == localji.Vc)
          {
            if (this.Va == localji.Va)
            {
              if (this.Vb == localji.Vb)
              {
                if (this.UZ != localji.UZ) {
                  bool = false;
                }
              }
              else {
                bool = false;
              }
            }
            else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
        }
        else
        {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
    return bool;
  }
  
  public long getExpirationTime()
  {
    return this.VW;
  }
  
  public double getLatitude()
  {
    return this.Va;
  }
  
  public double getLongitude()
  {
    return this.Vb;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.Vd;
  }
  
  public String getRequestId()
  {
    return this.Oy;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.Va);
    int i = 31 + (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.Vb);
    return 31 * (31 * (31 * (i * 31 + (int)(l ^ l >>> 32)) + Float.floatToIntBits(this.Vc)) + this.UZ) + this.UX;
  }
  
  public short iV()
  {
    return this.UZ;
  }
  
  public float iW()
  {
    return this.Vc;
  }
  
  public int iX()
  {
    return this.UX;
  }
  
  public int iY()
  {
    return this.Ve;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = cN(this.UZ);
    arrayOfObject[1] = this.Oy;
    arrayOfObject[2] = Integer.valueOf(this.UX);
    arrayOfObject[3] = Double.valueOf(this.Va);
    arrayOfObject[4] = Double.valueOf(this.Vb);
    arrayOfObject[5] = Float.valueOf(this.Vc);
    arrayOfObject[6] = Integer.valueOf(this.Vd / 1000);
    arrayOfObject[7] = Integer.valueOf(this.Ve);
    arrayOfObject[8] = Long.valueOf(this.VW);
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jj.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ji
 * JD-Core Version:    0.7.0.1
 */