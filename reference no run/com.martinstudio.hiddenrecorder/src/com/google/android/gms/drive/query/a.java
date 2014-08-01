package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class a
  implements Parcelable.Creator<Query>
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramQuery.xJ);
    b.a(paramParcel, 1, paramQuery.KB, paramInt, false);
    b.a(paramParcel, 3, paramQuery.KC, false);
    b.a(paramParcel, 4, paramQuery.KD, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public Query aD(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
    Object localObject2 = null;
    LogicalFilter localLogicalFilter = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new Query(j, localLogicalFilter, (String)localObject2, (SortOrder)localObject1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localLogicalFilter = localLogicalFilter;
        j = j;
        break;
      case 1: 
        localLogicalFilter = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, localObject3, LogicalFilter.CREATOR);
        j = j;
        localObject2 = localObject2;
        localLogicalFilter = localLogicalFilter;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, localObject3);
        localLogicalFilter = localLogicalFilter;
        j = j;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject3 = localObject3;
        break;
      case 4: 
        localObject3 = (SortOrder)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, localObject3, SortOrder.CREATOR);
        localObject1 = localObject2;
        localLogicalFilter = localLogicalFilter;
        j = j;
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, localObject3);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localLogicalFilter = localLogicalFilter;
        j = j;
        localObject3 = localObject3;
      }
      j = j;
      localLogicalFilter = localLogicalFilter;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public Query[] bz(int paramInt)
  {
    return new Query[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.a
 * JD-Core Version:    0.7.0.1
 */