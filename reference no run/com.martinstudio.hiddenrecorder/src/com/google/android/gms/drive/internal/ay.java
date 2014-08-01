package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ay
  implements Parcelable.Creator<UpdateMetadataRequest>
{
  static void a(UpdateMetadataRequest paramUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramUpdateMetadataRequest.xJ);
    b.a(paramParcel, 2, paramUpdateMetadataRequest.Ir, paramInt, false);
    b.a(paramParcel, 3, paramUpdateMetadataRequest.Is, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public UpdateMetadataRequest ay(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int i = a.B(paramParcel);
    Object localObject2 = 0;
    Object localObject1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new UpdateMetadataRequest(localObject2, (DriveId)localObject1, localMetadataBundle);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      Object localObject3;
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        localMetadataBundle = localMetadataBundle;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject2 = a.g(paramParcel, localObject3);
        localMetadataBundle = localMetadataBundle;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localMetadataBundle = localMetadataBundle;
        break;
      case 2: 
        localObject3 = (DriveId)a.a(paramParcel, localObject3, DriveId.CREATOR);
        localObject1 = localObject2;
        localMetadataBundle = localMetadataBundle;
        localObject3 = localObject3;
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, localObject3, MetadataBundle.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      localMetadataBundle = localMetadataBundle;
    }
  }
  
  public UpdateMetadataRequest[] bu(int paramInt)
  {
    return new UpdateMetadataRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ay
 * JD-Core Version:    0.7.0.1
 */