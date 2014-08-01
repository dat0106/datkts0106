package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<CastDevice> CREATOR = new b();
  private String Ae;
  String Af;
  private Inet4Address Ag;
  private String Ah;
  private String Ai;
  private String Aj;
  private int Ak;
  private List<WebImage> Al;
  private int Am;
  private final int xJ;
  
  private CastDevice()
  {
    this(2, null, null, null, null, null, -1, new ArrayList(), 0);
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Ae = paramString1;
    this.Af = paramString2;
    if (this.Af != null) {}
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(this.Af);
      if ((localInetAddress instanceof Inet4Address)) {
        this.Ag = ((Inet4Address)localInetAddress);
      }
      this.Ah = paramString3;
      this.Ai = paramString4;
      this.Aj = paramString5;
      this.Ak = paramInt2;
      this.Al = paramList;
      this.Am = paramInt3;
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        this.Ag = null;
      }
    }
  }
  
  public static CastDevice getFromBundle(Bundle paramBundle)
  {
    CastDevice localCastDevice;
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(CastDevice.class.getClassLoader());
      localCastDevice = (CastDevice)paramBundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }
    else
    {
      localCastDevice = null;
    }
    return localCastDevice;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof CastDevice))
      {
        CastDevice localCastDevice = (CastDevice)paramObject;
        if (getDeviceId() != null)
        {
          if ((!gj.a(this.Ae, localCastDevice.Ae)) || (!gj.a(this.Ag, localCastDevice.Ag)) || (!gj.a(this.Ai, localCastDevice.Ai)) || (!gj.a(this.Ah, localCastDevice.Ah)) || (!gj.a(this.Aj, localCastDevice.Aj)) || (this.Ak != localCastDevice.Ak) || (!gj.a(this.Al, localCastDevice.Al)) || (this.Am != localCastDevice.Am)) {
            bool = false;
          }
        }
        else if (localCastDevice.getDeviceId() != null) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public int getCapabilities()
  {
    return this.Am;
  }
  
  public String getDeviceId()
  {
    return this.Ae;
  }
  
  public String getDeviceVersion()
  {
    return this.Aj;
  }
  
  public String getFriendlyName()
  {
    return this.Ah;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject4 = null;
    if (!this.Al.isEmpty())
    {
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        Iterator localIterator = this.Al.iterator();
        Object localObject2 = null;
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            if (localObject2 == null) {
              if (localObject4 == null) {
                localObject2 = (WebImage)this.Al.get(0);
              } else {
                localObject2 = localObject4;
              }
            }
            localObject4 = localObject2;
            break;
          }
          Object localObject1 = (WebImage)localIterator.next();
          int j = ((WebImage)localObject1).getWidth();
          int i = ((WebImage)localObject1).getHeight();
          if ((j < paramInt1) || (i < paramInt2))
          {
            if ((j < paramInt1) && (i < paramInt2) && ((localObject4 == null) || ((((WebImage)localObject4).getWidth() < j) && (((WebImage)localObject4).getHeight() < i))))
            {
              localObject2 = localObject2;
              break label210;
            }
          }
          else {
            if ((localObject2 == null) || ((((WebImage)localObject2).getWidth() > j) && (((WebImage)localObject2).getHeight() > i))) {
              break label200;
            }
          }
          localObject1 = localObject4;
          localObject2 = localObject2;
          break label210;
          label200:
          Object localObject3 = localObject4;
          localObject2 = localObject1;
          localObject1 = localObject3;
          label210:
          localObject2 = localObject2;
          localObject4 = localObject1;
        }
      }
      localObject4 = (WebImage)this.Al.get(0);
    }
    return localObject4;
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.Al);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.Ag;
  }
  
  public String getModelName()
  {
    return this.Ai;
  }
  
  public int getServicePort()
  {
    return this.Ak;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasIcons()
  {
    boolean bool;
    if (this.Al.isEmpty()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i;
    if (this.Ae != null) {
      i = this.Ae.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public boolean isSameDevice(CastDevice paramCastDevice)
  {
    boolean bool = false;
    if (paramCastDevice != null) {
      if (getDeviceId() != null) {
        bool = gj.a(getDeviceId(), paramCastDevice.getDeviceId());
      } else if (paramCastDevice.getDeviceId() == null) {
        bool = true;
      }
    }
    return bool;
  }
  
  public void putInBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Ah;
    arrayOfObject[1] = this.Ae;
    return String.format("\"%s\" (%s)", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.CastDevice
 * JD-Core Version:    0.7.0.1
 */