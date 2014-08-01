package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
  implements Parcelable.Creator<ParcelableCollaborator>
{
  static void a(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableCollaborator.xJ);
    b.a(paramParcel, 2, paramParcelableCollaborator.Lh);
    b.a(paramParcel, 3, paramParcelableCollaborator.Li);
    b.a(paramParcel, 4, paramParcelableCollaborator.rO, false);
    b.a(paramParcel, 5, paramParcelableCollaborator.Lj, false);
    b.a(paramParcel, 6, paramParcelableCollaborator.Lk, false);
    b.a(paramParcel, 7, paramParcelableCollaborator.Ll, false);
    b.a(paramParcel, 8, paramParcelableCollaborator.Lm, false);
    b.G(paramParcel, i);
  }
  
  public ParcelableCollaborator aR(Parcel paramParcel)
  {
    boolean bool2 = false;
    String str1 = null;
    int j = a.B(paramParcel);
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str5 = null;
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ParcelableCollaborator(i, bool1, bool2, str5, str2, str3, str4, str1);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        bool1 = a.c(paramParcel, k);
        break;
      case 3: 
        bool2 = a.c(paramParcel, k);
        break;
      case 4: 
        str5 = a.o(paramParcel, k);
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str4 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
  }
  
  public ParcelableCollaborator[] bO(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.p
 * JD-Core Version:    0.7.0.1
 */