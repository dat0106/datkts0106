package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator
  implements Parcelable.Creator<GameRequestCluster>
{
  static void a(GameRequestCluster paramGameRequestCluster, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.b(paramParcel, 1, paramGameRequestCluster.ir(), false);
    b.c(paramParcel, 1000, paramGameRequestCluster.getVersionCode());
    b.G(paramParcel, i);
  }
  
  public GameRequestCluster bk(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new GameRequestCluster(i, localArrayList);
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
        localArrayList = a.c(paramParcel, k, GameRequestEntity.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public GameRequestCluster[] cv(int paramInt)
  {
    return new GameRequestCluster[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestClusterCreator
 * JD-Core Version:    0.7.0.1
 */