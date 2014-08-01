package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ParticipantResultCreator
  implements Parcelable.Creator<ParticipantResult>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(ParticipantResult paramParticipantResult, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramParticipantResult.getParticipantId(), false);
    b.c(paramParcel, 1000, paramParticipantResult.getVersionCode());
    b.c(paramParcel, 2, paramParticipantResult.getResult());
    b.c(paramParcel, 3, paramParticipantResult.getPlacing());
    b.G(paramParcel, i);
  }
  
  public ParticipantResult createFromParcel(Parcel paramParcel)
  {
    int j = 0;
    int i = a.B(paramParcel);
    String str = null;
    int m = 0;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ParticipantResult(k, str, m, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        str = a.o(paramParcel, n);
        break;
      case 2: 
        m = a.g(paramParcel, n);
        break;
      case 3: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
      }
    }
  }
  
  public ParticipantResult[] newArray(int paramInt)
  {
    return new ParticipantResult[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantResultCreator
 * JD-Core Version:    0.7.0.1
 */