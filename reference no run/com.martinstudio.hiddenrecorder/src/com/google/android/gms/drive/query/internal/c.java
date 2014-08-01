package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<FieldWithSortOrder>
{
  static void a(FieldWithSortOrder paramFieldWithSortOrder, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramFieldWithSortOrder.xJ);
    b.a(paramParcel, 1, paramFieldWithSortOrder.JE, false);
    b.a(paramParcel, 2, paramFieldWithSortOrder.KL);
    b.G(paramParcel, i);
  }
  
  public FieldWithSortOrder aH(Parcel paramParcel)
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
          return new FieldWithSortOrder(k, str, bool);
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
        str = a.o(paramParcel, i);
        break;
      case 2: 
        bool = a.c(paramParcel, i);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public FieldWithSortOrder[] bD(int paramInt)
  {
    return new FieldWithSortOrder[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.c
 * JD-Core Version:    0.7.0.1
 */