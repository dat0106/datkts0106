package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class ActivityRecognitionResultCreator
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.b(paramParcel, 1, paramActivityRecognitionResult.US, false);
    b.c(paramParcel, 1000, paramActivityRecognitionResult.getVersionCode());
    b.a(paramParcel, 2, paramActivityRecognitionResult.UT);
    b.a(paramParcel, 3, paramActivityRecognitionResult.UU);
    b.G(paramParcel, i);
  }
  
  public ActivityRecognitionResult createFromParcel(Parcel paramParcel)
  {
    long l2 = 0L;
    int i = a.B(paramParcel);
    int k = 0;
    Object localObject = null;
    long l1 = l2;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ActivityRecognitionResult(k, (List)localObject, l1, l2);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        localObject = a.c(paramParcel, j, DetectedActivity.CREATOR);
        break;
      case 2: 
        l1 = a.i(paramParcel, j);
        break;
      case 3: 
        l2 = a.i(paramParcel, j);
        break;
      case 1000: 
        k = a.g(paramParcel, j);
      }
    }
  }
  
  public ActivityRecognitionResult[] newArray(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResultCreator
 * JD-Core Version:    0.7.0.1
 */