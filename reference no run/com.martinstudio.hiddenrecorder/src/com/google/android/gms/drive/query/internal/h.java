package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class h
  implements Parcelable.Creator<LogicalFilter>
{
  static void a(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramLogicalFilter.xJ);
    b.a(paramParcel, 1, paramLogicalFilter.KI, paramInt, false);
    b.b(paramParcel, 2, paramLogicalFilter.KV, false);
    b.G(paramParcel, i);
  }
  
  public LogicalFilter aL(Parcel paramParcel)
  {
    Object localObject = null;
    int i = a.B(paramParcel);
    int j = 0;
    Operator localOperator = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new LogicalFilter(j, localOperator, (List)localObject);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject = localObject;
        localOperator = localOperator;
        j = j;
        break;
      case 1: 
        localOperator = (Operator)a.a(paramParcel, k, Operator.CREATOR);
        j = j;
        localObject = localObject;
        localOperator = localOperator;
        break;
      case 2: 
        localObject = a.c(paramParcel, k, FilterHolder.CREATOR);
        localOperator = localOperator;
        j = j;
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        localObject = localObject;
        localOperator = localOperator;
        j = j;
        localObject = localObject;
      }
      j = j;
      localOperator = localOperator;
      localObject = localObject;
    }
  }
  
  public LogicalFilter[] bH(int paramInt)
  {
    return new LogicalFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.h
 * JD-Core Version:    0.7.0.1
 */