package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ah
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnDownloadProgressResponse.xJ);
    b.a(paramParcel, 2, paramOnDownloadProgressResponse.Jt);
    b.a(paramParcel, 3, paramOnDownloadProgressResponse.Ju);
    b.G(paramParcel, i);
  }
  
  public OnDownloadProgressResponse ai(Parcel paramParcel)
  {
    long l2 = 0L;
    int k = a.B(paramParcel);
    int i = 0;
    long l1 = l2;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new OnDownloadProgressResponse(i, l1, l2);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        i = a.g(paramParcel, j);
        break;
      case 2: 
        l1 = a.i(paramParcel, j);
        break;
      case 3: 
        l2 = a.i(paramParcel, j);
      }
    }
  }
  
  public OnDownloadProgressResponse[] be(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ah
 * JD-Core Version:    0.7.0.1
 */