package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class aj
  implements Parcelable.Creator<OnEventResponse>
{
  static void a(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnEventResponse.xJ);
    b.c(paramParcel, 2, paramOnEventResponse.In);
    b.a(paramParcel, 3, paramOnEventResponse.Jv, paramInt, false);
    b.a(paramParcel, 4, paramOnEventResponse.Jw, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnEventResponse ak(Parcel paramParcel)
  {
    Object localObject1 = null;
    Object localObject3 = 0;
    int i = a.B(paramParcel);
    Object localObject2 = null;
    Object localObject4 = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OnEventResponse(localObject4, localObject3, (ChangeEvent)localObject2, (FileConflictEvent)localObject1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      Object localObject6;
      Object localObject8;
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      case 1: 
        localObject4 = a.g(paramParcel, localObject6);
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject6 = localObject6;
        break;
      case 2: 
        Object localObject7 = a.g(paramParcel, localObject6);
        localObject3 = localObject4;
        localObject5 = localObject2;
        localObject2 = localObject7;
        localObject8 = localObject1;
        localObject1 = localObject5;
        break;
      case 3: 
        localObject8 = (ChangeEvent)a.a(paramParcel, localObject8, ChangeEvent.CREATOR);
        localObject2 = localObject3;
        localObject3 = localObject5;
        localObject5 = localObject1;
        localObject1 = localObject8;
        localObject8 = localObject5;
        break;
      case 4: 
        localObject8 = (FileConflictEvent)a.a(paramParcel, localObject8, FileConflictEvent.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject5;
      }
      Object localObject5 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject8;
    }
  }
  
  public OnEventResponse[] bg(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aj
 * JD-Core Version:    0.7.0.1
 */