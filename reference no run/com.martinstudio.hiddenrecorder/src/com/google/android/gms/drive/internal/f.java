package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class f
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCloseContentsRequest.xJ);
    b.a(paramParcel, 2, paramCloseContentsRequest.It, paramInt, false);
    b.a(paramParcel, 3, paramCloseContentsRequest.Iw, false);
    b.G(paramParcel, i);
  }
  
  public CloseContentsRequest V(Parcel paramParcel)
  {
    Boolean localBoolean = null;
    int i = a.B(paramParcel);
    int j = 0;
    Contents localContents = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CloseContentsRequest(j, localContents, localBoolean);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localBoolean = localBoolean;
        localContents = localContents;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        localBoolean = localBoolean;
        localContents = localContents;
        j = j;
        localBoolean = localBoolean;
        break;
      case 2: 
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        j = j;
        localBoolean = localBoolean;
        localContents = localContents;
        break;
      case 3: 
        localBoolean = a.d(paramParcel, k);
        localContents = localContents;
        j = j;
      }
      j = j;
      localContents = localContents;
      localBoolean = localBoolean;
    }
  }
  
  public CloseContentsRequest[] aQ(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.f
 * JD-Core Version:    0.7.0.1
 */