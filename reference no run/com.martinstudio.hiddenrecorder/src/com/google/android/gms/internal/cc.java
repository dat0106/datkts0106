package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

public final class cc
{
  public static int a(AdRequest.ErrorCode paramErrorCode)
  {
    int i;
    switch (1.nX[paramErrorCode.ordinal()])
    {
    default: 
      i = 0;
      break;
    case 2: 
      i = 1;
      break;
    case 3: 
      i = 2;
      break;
    case 4: 
      i = 3;
    }
    return i;
  }
  
  public static AdSize b(am paramam)
  {
    int i = 0;
    Object localObject = new AdSize[6];
    localObject[i] = AdSize.SMART_BANNER;
    localObject[1] = AdSize.BANNER;
    localObject[2] = AdSize.IAB_MRECT;
    localObject[3] = AdSize.IAB_BANNER;
    localObject[4] = AdSize.IAB_LEADERBOARD;
    localObject[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    for (;;)
    {
      if (i >= localObject.length) {
        return new AdSize(a.a(paramam.width, paramam.height, paramam.mc));
      }
      if ((localObject[i].getWidth() == paramam.width) && (localObject[i].getHeight() == paramam.height)) {
        break;
      }
      i++;
    }
    localObject = localObject[i];
    return localObject;
  }
  
  public static MediationAdRequest e(aj paramaj)
  {
    HashSet localHashSet;
    if (paramaj.lS == null) {
      localHashSet = null;
    } else {
      localHashSet = new HashSet(paramaj.lS);
    }
    return new MediationAdRequest(new Date(paramaj.lQ), h(paramaj.lR), localHashSet, paramaj.lT, paramaj.lY);
  }
  
  public static AdRequest.Gender h(int paramInt)
  {
    AdRequest.Gender localGender;
    switch (paramInt)
    {
    default: 
      localGender = AdRequest.Gender.UNKNOWN;
      break;
    case 1: 
      localGender = AdRequest.Gender.MALE;
      break;
    case 2: 
      localGender = AdRequest.Gender.FEMALE;
    }
    return localGender;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cc
 * JD-Core Version:    0.7.0.1
 */