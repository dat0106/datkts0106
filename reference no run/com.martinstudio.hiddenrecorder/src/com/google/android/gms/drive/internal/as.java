package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class as
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOpenFileIntentSenderRequest.xJ);
    b.a(paramParcel, 2, paramOpenFileIntentSenderRequest.HV, false);
    b.a(paramParcel, 3, paramOpenFileIntentSenderRequest.HW, false);
    b.a(paramParcel, 4, paramOpenFileIntentSenderRequest.HX, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OpenFileIntentSenderRequest at(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int i = a.B(paramParcel);
    int k = 0;
    String[] arrayOfString = null;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OpenFileIntentSenderRequest(k, str, arrayOfString, localDriveId);
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
        str = a.o(paramParcel, j);
        break;
      case 3: 
        arrayOfString = a.A(paramParcel, j);
        break;
      case 4: 
        localDriveId = (DriveId)a.a(paramParcel, j, DriveId.CREATOR);
      }
    }
  }
  
  public OpenFileIntentSenderRequest[] bp(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.as
 * JD-Core Version:    0.7.0.1
 */