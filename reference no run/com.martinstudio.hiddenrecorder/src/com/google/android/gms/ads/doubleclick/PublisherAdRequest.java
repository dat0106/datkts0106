package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.au.a;
import com.google.android.gms.internal.hn;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest
{
  public static final String DEVICE_ID_EMULATOR = au.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN;
  private final au kq;
  
  private PublisherAdRequest(Builder paramBuilder)
  {
    this.kq = new au(Builder.a(paramBuilder));
  }
  
  au O()
  {
    return this.kq;
  }
  
  public Date getBirthday()
  {
    return this.kq.getBirthday();
  }
  
  public String getContentUrl()
  {
    return this.kq.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.kq.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getGender()
  {
    return this.kq.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return this.kq.getKeywords();
  }
  
  public Location getLocation()
  {
    return this.kq.getLocation();
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.kq.getManualImpressionsEnabled();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.kq.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.kq.getNetworkExtrasBundle(paramClass);
  }
  
  public String getPublisherProvidedId()
  {
    return this.kq.getPublisherProvidedId();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.kq.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final au.a kr = new au.a();
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.kr.b(paramClass, paramBundle);
      return this;
    }
    
    public Builder addKeyword(String paramString)
    {
      this.kr.g(paramString);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.kr.a(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.kr.a(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.kr.h(paramString);
      return this;
    }
    
    public PublisherAdRequest build()
    {
      return new PublisherAdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      this.kr.a(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      hn.b(paramString, "Content URL must be non-null.");
      hn.b(paramString, "Content URL must be non-empty.");
      boolean bool;
      if (paramString.length() > 512) {
        bool = false;
      } else {
        bool = true;
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(512);
      arrayOfObject[1] = Integer.valueOf(paramString.length());
      hn.b(bool, "Content URL must not exceed %d in length.  Provided length was %d.", arrayOfObject);
      this.kr.i(paramString);
      return this;
    }
    
    public Builder setGender(int paramInt)
    {
      this.kr.e(paramInt);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.kr.a(paramLocation);
      return this;
    }
    
    public Builder setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.kr.g(paramBoolean);
      return this;
    }
    
    public Builder setPublisherProvidedId(String paramString)
    {
      this.kr.j(paramString);
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.kr.h(paramBoolean);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdRequest
 * JD-Core Version:    0.7.0.1
 */