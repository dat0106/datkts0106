package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramNotifyTransactionStatusRequest.xJ);
    b.a(paramParcel, 2, paramNotifyTransactionStatusRequest.aiN, false);
    b.c(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
    b.a(paramParcel, 4, paramNotifyTransactionStatusRequest.ajO, false);
    b.G(paramParcel, i);
  }
  
  public NotifyTransactionStatusRequest cb(Parcel paramParcel)
  {
    String str1 = null;
    int m = 0;
    int i = a.B(paramParcel);
    String str2 = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new NotifyTransactionStatusRequest(k, str2, m, str1);
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
        str2 = a.o(paramParcel, j);
        break;
      case 3: 
        m = a.g(paramParcel, j);
        break;
      case 4: 
        str1 = a.o(paramParcel, j);
      }
    }
  }
  
  public NotifyTransactionStatusRequest[] dH(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.m
 * JD-Core Version:    0.7.0.1
 */