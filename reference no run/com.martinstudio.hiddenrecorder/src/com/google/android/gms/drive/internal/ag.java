package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class ag
  implements Parcelable.Creator<OnContentsResponse>
{
  static void a(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnContentsResponse.xJ);
    b.a(paramParcel, 2, paramOnContentsResponse.HD, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnContentsResponse ah(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int k = 0;
    Contents localContents = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OnContentsResponse(k, localContents);
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
        k = a.g(paramParcel, j);
        break;
      case 2: 
        localContents = (Contents)a.a(paramParcel, j, Contents.CREATOR);
      }
    }
  }
  
  public OnContentsResponse[] bd(int paramInt)
  {
    return new OnContentsResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ag
 * JD-Core Version:    0.7.0.1
 */