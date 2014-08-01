package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MilestoneEntityCreator
  implements Parcelable.Creator<MilestoneEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(MilestoneEntity paramMilestoneEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramMilestoneEntity.getMilestoneId(), false);
    b.c(paramParcel, 1000, paramMilestoneEntity.getVersionCode());
    b.a(paramParcel, 2, paramMilestoneEntity.getCurrentProgress());
    b.a(paramParcel, 3, paramMilestoneEntity.getTargetProgress());
    b.a(paramParcel, 4, paramMilestoneEntity.getCompletionRewardData(), false);
    b.c(paramParcel, 5, paramMilestoneEntity.getState());
    b.a(paramParcel, 6, paramMilestoneEntity.getEventId(), false);
    b.G(paramParcel, i);
  }
  
  public MilestoneEntity createFromParcel(Parcel paramParcel)
  {
    long l2 = 0L;
    int i = 0;
    String str2 = null;
    int m = a.B(paramParcel);
    byte[] arrayOfByte = null;
    long l1 = l2;
    String str1 = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new MilestoneEntity(j, str1, l1, l2, arrayOfByte, i, str2);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.o(paramParcel, k);
        break;
      case 2: 
        l1 = a.i(paramParcel, k);
        break;
      case 3: 
        l2 = a.i(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 5: 
        i = a.g(paramParcel, k);
        break;
      case 6: 
        str2 = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
  
  public MilestoneEntity[] newArray(int paramInt)
  {
    return new MilestoneEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneEntityCreator
 * JD-Core Version:    0.7.0.1
 */