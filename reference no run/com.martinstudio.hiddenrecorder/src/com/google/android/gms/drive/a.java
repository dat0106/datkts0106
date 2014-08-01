package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<Contents>
{
  static void a(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramContents.xJ);
    b.a(paramParcel, 2, paramContents.Fg, paramInt, false);
    b.c(paramParcel, 3, paramContents.qX);
    b.c(paramParcel, 4, paramContents.Hv);
    b.a(paramParcel, 5, paramContents.Hw, paramInt, false);
    b.a(paramParcel, 6, paramContents.Hx, false);
    b.a(paramParcel, 7, paramContents.Hy);
    b.G(paramParcel, i);
  }
  
  public Contents M(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int m = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    DriveId localDriveId = null;
    int n = 0;
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new Contents(k, localParcelFileDescriptor, i, n, localDriveId, str, bool);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int j = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(j))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, j);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, j, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 4: 
        n = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 5: 
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, j, DriveId.CREATOR);
        break;
      case 6: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, j);
        break;
      case 7: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, j);
      }
    }
  }
  
  public Contents[] aG(int paramInt)
  {
    return new Contents[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.a
 * JD-Core Version:    0.7.0.1
 */