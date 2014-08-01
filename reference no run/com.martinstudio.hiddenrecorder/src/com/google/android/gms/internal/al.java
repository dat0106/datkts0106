package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class al
{
  public static final al mb = new al();
  
  public static al aA()
  {
    return mb;
  }
  
  public aj a(Context paramContext, au paramau)
  {
    Date localDate = paramau.getBirthday();
    long l;
    if (localDate == null) {
      l = -1L;
    } else {
      l = l.getTime();
    }
    String str = paramau.getContentUrl();
    int i = paramau.getGender();
    Object localObject1 = paramau.getKeywords();
    List localList;
    if (((Set)localObject1).isEmpty()) {
      localList = null;
    } else {
      localList = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
    }
    boolean bool1 = paramau.isTestDevice(paramContext);
    int j = paramau.aF();
    Location localLocation = paramau.getLocation();
    Bundle localBundle = paramau.getNetworkExtrasBundle(AdMobAdapter.class);
    boolean bool2 = paramau.getManualImpressionsEnabled();
    localObject1 = paramau.getPublisherProvidedId();
    Object localObject2 = paramau.aC();
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = new ax((SearchAdRequest)localObject2);
    }
    return new aj(4, l, localBundle, i, localList, bool1, j, bool2, (String)localObject1, (ax)localObject2, localLocation, str, paramau.aE());
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.al
 * JD-Core Version:    0.7.0.1
 */