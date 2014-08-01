package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator
  implements Parcelable.Creator<ZInvitationCluster>
{
  static void a(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.b(paramParcel, 1, paramZInvitationCluster.ie(), false);
    b.c(paramParcel, 1000, paramZInvitationCluster.getVersionCode());
    b.G(paramParcel, i);
  }
  
  public ZInvitationCluster bi(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int k = 0;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ZInvitationCluster(k, localArrayList);
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
        localArrayList = a.c(paramParcel, j, InvitationEntity.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, j);
      }
    }
  }
  
  public ZInvitationCluster[] cs(int paramInt)
  {
    return new ZInvitationCluster[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator
 * JD-Core Version:    0.7.0.1
 */