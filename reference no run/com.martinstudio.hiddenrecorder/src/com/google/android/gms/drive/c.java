package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<DriveId>
{
  static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDriveId.xJ);
    b.a(paramParcel, 2, paramDriveId.HK, false);
    b.a(paramParcel, 3, paramDriveId.HL);
    b.a(paramParcel, 4, paramDriveId.HM);
    b.G(paramParcel, i);
  }
  
  public DriveId N(Parcel paramParcel)
  {
    long l1 = 0L;
    int k = a.B(paramParcel);
    int i = 0;
    String str = null;
    long l2 = l1;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new DriveId(i, str, l2, l1);
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
        str = a.o(paramParcel, j);
        break;
      case 3: 
        l2 = a.i(paramParcel, j);
        break;
      case 4: 
        l1 = a.i(paramParcel, j);
      }
    }
  }
  
  public DriveId[] aH(int paramInt)
  {
    return new DriveId[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.c
 * JD-Core Version:    0.7.0.1
 */