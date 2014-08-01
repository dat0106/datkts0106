package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.DriveId;

public class b
  implements Parcelable.Creator<AuthorizeAccessRequest>
{
  static void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramAuthorizeAccessRequest.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramAuthorizeAccessRequest.Ip);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramAuthorizeAccessRequest.Hw, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public AuthorizeAccessRequest S(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    long l = 0L;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new AuthorizeAccessRequest(i, l, localDriveId);
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
        l = a.i(paramParcel, j);
        break;
      case 3: 
        localDriveId = (DriveId)a.a(paramParcel, j, DriveId.CREATOR);
      }
    }
  }
  
  public AuthorizeAccessRequest[] aN(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.b
 * JD-Core Version:    0.7.0.1
 */