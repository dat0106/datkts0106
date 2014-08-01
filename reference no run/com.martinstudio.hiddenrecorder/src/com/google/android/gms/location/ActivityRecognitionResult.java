package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
  List<DetectedActivity> US;
  long UT;
  long UU;
  private final int xJ;
  
  public ActivityRecognitionResult(int paramInt, List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this.xJ = 1;
    this.US = paramList;
    this.UT = paramLong1;
    this.UU = paramLong2;
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if ((paramList == null) || (paramList.size() <= 0)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    hn.b(bool2, "Must have at least 1 detected activity");
    if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
      bool1 = true;
    }
    hn.b(bool1, "Must set times");
    this.xJ = 1;
    this.US = paramList;
    this.UT = paramLong1;
    this.UU = paramLong2;
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    ActivityRecognitionResult localActivityRecognitionResult;
    if (hasResult(paramIntent)) {
      localActivityRecognitionResult = (ActivityRecognitionResult)paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    } else {
      localActivityRecognitionResult = null;
    }
    return localActivityRecognitionResult;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent != null) {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.US.iterator();
    DetectedActivity localDetectedActivity;
    do
    {
      if (!localIterator.hasNext())
      {
        i = 0;
        break;
      }
      localDetectedActivity = (DetectedActivity)i.next();
    } while (localDetectedActivity.getType() != paramInt);
    int i = localDetectedActivity.getConfidence();
    return i;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.UU;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.US.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return this.US;
  }
  
  public long getTime()
  {
    return this.UT;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + this.US + ", timeMillis=" + this.UT + ", elapsedRealtimeMillis=" + this.UU + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * JD-Core Version:    0.7.0.1
 */