package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class SnapshotEntityCreator
  implements Parcelable.Creator<SnapshotEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(SnapshotEntity paramSnapshotEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramSnapshotEntity.getMetadata(), paramInt, false);
    b.c(paramParcel, 1000, paramSnapshotEntity.getVersionCode());
    b.a(paramParcel, 2, paramSnapshotEntity.getContents(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public SnapshotEntity createFromParcel(Parcel paramParcel)
  {
    Contents localContents = null;
    int i = a.B(paramParcel);
    int j = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new SnapshotEntity(j, (SnapshotMetadata)localObject, localContents);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localContents = localContents;
        localObject = localObject;
        j = j;
        break;
      case 1: 
        localObject = (SnapshotMetadataEntity)a.a(paramParcel, k, SnapshotMetadataEntity.CREATOR);
        j = j;
        localContents = localContents;
        localObject = localObject;
        break;
      case 2: 
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        localObject = localObject;
        j = j;
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        localContents = localContents;
        localObject = localObject;
        j = j;
        localContents = localContents;
      }
      j = j;
      localObject = localObject;
      localContents = localContents;
    }
  }
  
  public SnapshotEntity[] newArray(int paramInt)
  {
    return new SnapshotEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotEntityCreator
 * JD-Core Version:    0.7.0.1
 */