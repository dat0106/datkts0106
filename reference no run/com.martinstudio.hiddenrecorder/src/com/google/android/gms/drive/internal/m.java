package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class m
  implements Parcelable.Creator<DeleteCustomPropertyRequest>
{
  static void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDeleteCustomPropertyRequest.xJ);
    b.a(paramParcel, 2, paramDeleteCustomPropertyRequest.Hw, paramInt, false);
    b.a(paramParcel, 3, paramDeleteCustomPropertyRequest.IG, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public DeleteCustomPropertyRequest[] aW(int paramInt)
  {
    return new DeleteCustomPropertyRequest[paramInt];
  }
  
  public DeleteCustomPropertyRequest aa(Parcel paramParcel)
  {
    CustomPropertyKey localCustomPropertyKey = null;
    int i = a.B(paramParcel);
    int j = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new DeleteCustomPropertyRequest(j, localDriveId, localCustomPropertyKey);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localCustomPropertyKey = localCustomPropertyKey;
        localDriveId = localDriveId;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        localCustomPropertyKey = localCustomPropertyKey;
        localDriveId = localDriveId;
        j = j;
        localCustomPropertyKey = localCustomPropertyKey;
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        j = j;
        localCustomPropertyKey = localCustomPropertyKey;
        localDriveId = localDriveId;
        break;
      case 3: 
        localCustomPropertyKey = (CustomPropertyKey)a.a(paramParcel, k, CustomPropertyKey.CREATOR);
        localDriveId = localDriveId;
        j = j;
      }
      j = j;
      localDriveId = localDriveId;
      localCustomPropertyKey = localCustomPropertyKey;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.m
 * JD-Core Version:    0.7.0.1
 */