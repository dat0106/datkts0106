package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
  implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest>
{
  static void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.xJ);
    b.a(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.Jm, false);
    b.a(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.Jn);
    b.G(paramParcel, i);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest[] aZ(int paramInt)
  {
    return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
  }
  
  public GetDriveIdFromUniqueIdentifierRequest ad(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    String str = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new GetDriveIdFromUniqueIdentifierRequest(k, str, bool);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        k = a.g(paramParcel, i);
        break;
      case 2: 
        str = a.o(paramParcel, i);
        break;
      case 3: 
        bool = a.c(paramParcel, i);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.y
 * JD-Core Version:    0.7.0.1
 */