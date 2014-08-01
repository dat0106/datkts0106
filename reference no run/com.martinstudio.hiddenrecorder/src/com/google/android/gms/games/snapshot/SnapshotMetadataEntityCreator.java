package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator
  implements Parcelable.Creator<SnapshotMetadataEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(SnapshotMetadataEntity paramSnapshotMetadataEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramSnapshotMetadataEntity.getGame(), paramInt, false);
    b.c(paramParcel, 1000, paramSnapshotMetadataEntity.getVersionCode());
    b.a(paramParcel, 2, paramSnapshotMetadataEntity.getOwner(), paramInt, false);
    b.a(paramParcel, 3, paramSnapshotMetadataEntity.getSnapshotId(), false);
    b.a(paramParcel, 5, paramSnapshotMetadataEntity.getCoverImageUri(), paramInt, false);
    b.a(paramParcel, 6, paramSnapshotMetadataEntity.getCoverImageUrl(), false);
    b.a(paramParcel, 7, paramSnapshotMetadataEntity.getTitle(), false);
    b.a(paramParcel, 8, paramSnapshotMetadataEntity.getDescription(), false);
    b.a(paramParcel, 9, paramSnapshotMetadataEntity.getLastModifiedTimestamp());
    b.a(paramParcel, 10, paramSnapshotMetadataEntity.getPlayedTime());
    b.a(paramParcel, 11, paramSnapshotMetadataEntity.getCoverImageAspectRatio());
    b.a(paramParcel, 12, paramSnapshotMetadataEntity.getUniqueName(), false);
    b.G(paramParcel, i);
  }
  
  public SnapshotMetadataEntity createFromParcel(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    String str5 = null;
    Uri localUri = null;
    String str1 = null;
    String str4 = null;
    String str3 = null;
    long l2 = 0L;
    long l1 = 0L;
    float f = 0.0F;
    String str2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new SnapshotMetadataEntity(j, localGameEntity, localPlayerEntity, str5, localUri, str1, str4, str3, l2, l1, f, str2);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, i, GameEntity.CREATOR);
        break;
      case 2: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, i, PlayerEntity.CREATOR);
        break;
      case 3: 
        str5 = a.o(paramParcel, i);
        break;
      case 5: 
        localUri = (Uri)a.a(paramParcel, i, Uri.CREATOR);
        break;
      case 6: 
        str1 = a.o(paramParcel, i);
        break;
      case 7: 
        str4 = a.o(paramParcel, i);
        break;
      case 8: 
        str3 = a.o(paramParcel, i);
        break;
      case 9: 
        l2 = a.i(paramParcel, i);
        break;
      case 10: 
        l1 = a.i(paramParcel, i);
        break;
      case 11: 
        f = a.l(paramParcel, i);
        break;
      case 12: 
        str2 = a.o(paramParcel, i);
        break;
      case 1000: 
        j = a.g(paramParcel, i);
      }
    }
  }
  
  public SnapshotMetadataEntity[] newArray(int paramInt)
  {
    return new SnapshotMetadataEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator
 * JD-Core Version:    0.7.0.1
 */