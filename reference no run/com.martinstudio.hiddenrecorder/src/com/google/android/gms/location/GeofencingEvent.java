package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent
{
  private final int Vf;
  private final List<Geofence> Vg;
  private final Location Vh;
  private final int pH;
  
  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    this.pH = paramInt1;
    this.Vf = paramInt2;
    this.Vg = paramList;
    this.Vh = paramLocation;
  }
  
  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    GeofencingEvent localGeofencingEvent;
    if (paramIntent != null) {
      localGeofencingEvent = new GeofencingEvent(paramIntent.getIntExtra("gms_error_code", -1), getGeofenceTransition(paramIntent), getTriggeringGeofences(paramIntent), (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    } else {
      localGeofencingEvent = null;
    }
    return localGeofencingEvent;
  }
  
  private static int getGeofenceTransition(Intent paramIntent)
  {
    int j = -1;
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", j);
    if ((i != j) && ((i == 1) || (i == 2) || (i == 4))) {
      j = i;
    }
    return j;
  }
  
  private static List<Geofence> getTriggeringGeofences(Intent paramIntent)
  {
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localObject != null)
    {
      localArrayList = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          localArrayList = localArrayList;
          break;
        }
        localArrayList.add(ji.h((byte[])((Iterator)localObject).next()));
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }
  
  public int getErrorCode()
  {
    return this.pH;
  }
  
  public int getGeofenceTransition()
  {
    return this.Vf;
  }
  
  public List<Geofence> getTriggeringGeofences()
  {
    return this.Vg;
  }
  
  public Location getTriggeringLocation()
  {
    return this.Vh;
  }
  
  public boolean hasError()
  {
    boolean bool;
    if (this.pH == -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.GeofencingEvent
 * JD-Core Version:    0.7.0.1
 */