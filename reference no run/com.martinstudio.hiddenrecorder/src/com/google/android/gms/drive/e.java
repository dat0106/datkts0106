package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<StorageStats>
{
  static void a(StorageStats paramStorageStats, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStorageStats.xJ);
    b.a(paramParcel, 2, paramStorageStats.HY);
    b.a(paramParcel, 3, paramStorageStats.HZ);
    b.a(paramParcel, 4, paramStorageStats.Ia);
    b.a(paramParcel, 5, paramStorageStats.Ib);
    b.c(paramParcel, 6, paramStorageStats.Ic);
    b.G(paramParcel, i);
  }
  
  public StorageStats O(Parcel paramParcel)
  {
    int i = 0;
    long l1 = 0L;
    int j = a.B(paramParcel);
    long l4 = l1;
    long l2 = l1;
    long l3 = l1;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new StorageStats(m, l3, l2, l4, l1, i);
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
        m = a.g(paramParcel, k);
        break;
      case 2: 
        l3 = a.i(paramParcel, k);
        break;
      case 3: 
        l2 = a.i(paramParcel, k);
        break;
      case 4: 
        l4 = a.i(paramParcel, k);
        break;
      case 5: 
        l1 = a.i(paramParcel, k);
        break;
      case 6: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public StorageStats[] aI(int paramInt)
  {
    return new StorageStats[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.e
 * JD-Core Version:    0.7.0.1
 */