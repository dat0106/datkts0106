package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;

public class at
  implements Parcelable.Creator<QueryRequest>
{
  static void a(QueryRequest paramQueryRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramQueryRequest.xJ);
    b.a(paramParcel, 2, paramQueryRequest.JB, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public QueryRequest au(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int k = 0;
    Query localQuery = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new QueryRequest(k, localQuery);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        k = a.g(paramParcel, j);
        break;
      case 2: 
        localQuery = (Query)a.a(paramParcel, j, Query.CREATOR);
      }
    }
  }
  
  public QueryRequest[] bq(int paramInt)
  {
    return new QueryRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.at
 * JD-Core Version:    0.7.0.1
 */