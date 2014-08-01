package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class DetectedActivityCreator
  implements Parcelable.Creator<DetectedActivity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(DetectedActivity paramDetectedActivity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDetectedActivity.UV);
    b.c(paramParcel, 1000, paramDetectedActivity.getVersionCode());
    b.c(paramParcel, 2, paramDetectedActivity.UW);
    b.G(paramParcel, i);
  }
  
  public DetectedActivity createFromParcel(Parcel paramParcel)
  {
    int n = 0;
    int m = a.B(paramParcel);
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new DetectedActivity(i, k, n);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        k = a.g(paramParcel, j);
        break;
      case 2: 
        n = a.g(paramParcel, j);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public DetectedActivity[] newArray(int paramInt)
  {
    return new DetectedActivity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.DetectedActivityCreator
 * JD-Core Version:    0.7.0.1
 */