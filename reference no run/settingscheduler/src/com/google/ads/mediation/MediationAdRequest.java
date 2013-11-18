package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest
{
  private AdRequest a;
  private boolean b;
  private boolean c;
  
  public MediationAdRequest(AdRequest paramAdRequest, Context paramContext, boolean paramBoolean)
  {
    this.a = paramAdRequest;
    this.c = paramBoolean;
    if (paramContext != null) {
      this.b = paramAdRequest.isTestDevice(paramContext);
    } else {
      this.b = true;
    }
  }
  
  public Integer getAgeInYears()
  {
    Integer localInteger;
    if (this.a.getBirthday() == null)
    {
      localInteger = null;
    }
    else
    {
      Calendar localCalendar2 = Calendar.getInstance();
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar2.setTime(this.a.getBirthday());
      localInteger = Integer.valueOf(localCalendar1.get(1) - localCalendar2.get(1));
      if (localCalendar1.get(6) < localCalendar2.get(6)) {
        localInteger = Integer.valueOf(-1 + localInteger.intValue());
      }
    }
    return localInteger;
  }
  
  public Date getBirthday()
  {
    return this.a.getBirthday();
  }
  
  public AdRequest.Gender getGender()
  {
    return this.a.getGender();
  }
  
  public Set<String> getKeywords()
  {
    Set localSet;
    if (this.a.getKeywords() != null) {
      localSet = Collections.unmodifiableSet(this.a.getKeywords());
    } else {
      localSet = null;
    }
    return localSet;
  }
  
  public Location getLocation()
  {
    Location localLocation;
    if ((this.a.getLocation() != null) && (this.c)) {
      localLocation = new Location(this.a.getLocation());
    } else {
      localLocation = null;
    }
    return localLocation;
  }
  
  public boolean isTesting()
  {
    return this.b;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationAdRequest
 * JD-Core Version:    0.7.0.1
 */