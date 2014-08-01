package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;

public class b
  implements Parcelable.Creator<SortOrder>
{
  static void a(SortOrder paramSortOrder, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramSortOrder.xJ);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 1, paramSortOrder.KH, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public SortOrder aE(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new SortOrder(k, (List)localObject);
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
        localObject = a.c(paramParcel, i, FieldWithSortOrder.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public SortOrder[] bA(int paramInt)
  {
    return new SortOrder[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.b
 * JD-Core Version:    0.7.0.1
 */