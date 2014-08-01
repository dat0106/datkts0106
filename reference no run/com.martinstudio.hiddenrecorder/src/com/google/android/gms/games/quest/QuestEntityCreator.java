package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator
  implements Parcelable.Creator<QuestEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(QuestEntity paramQuestEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramQuestEntity.getGame(), paramInt, false);
    b.a(paramParcel, 2, paramQuestEntity.getQuestId(), false);
    b.a(paramParcel, 3, paramQuestEntity.getAcceptedTimestamp());
    b.a(paramParcel, 4, paramQuestEntity.getBannerImageUri(), paramInt, false);
    b.a(paramParcel, 5, paramQuestEntity.getBannerImageUrl(), false);
    b.a(paramParcel, 6, paramQuestEntity.getDescription(), false);
    b.a(paramParcel, 7, paramQuestEntity.getEndTimestamp());
    b.a(paramParcel, 8, paramQuestEntity.getLastUpdatedTimestamp());
    b.a(paramParcel, 9, paramQuestEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 10, paramQuestEntity.getIconImageUrl(), false);
    b.a(paramParcel, 12, paramQuestEntity.getName(), false);
    b.a(paramParcel, 13, paramQuestEntity.iF());
    b.a(paramParcel, 14, paramQuestEntity.getStartTimestamp());
    b.c(paramParcel, 15, paramQuestEntity.getState());
    b.b(paramParcel, 17, paramQuestEntity.iE(), false);
    b.c(paramParcel, 16, paramQuestEntity.getType());
    b.c(paramParcel, 1000, paramQuestEntity.getVersionCode());
    b.G(paramParcel, i);
  }
  
  public QuestEntity createFromParcel(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int n = 0;
    GameEntity localGameEntity = null;
    String str5 = null;
    long l2 = 0L;
    Uri localUri1 = null;
    String str3 = null;
    String str4 = null;
    long l4 = 0L;
    long l3 = 0L;
    Uri localUri2 = null;
    String str2 = null;
    String str1 = null;
    long l1 = 0L;
    long l5 = 0L;
    int k = 0;
    int m = 0;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new QuestEntity(n, localGameEntity, str5, l2, localUri1, str3, str4, l4, l3, localUri2, str2, str1, l1, l5, k, m, localArrayList);
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
        localGameEntity = (GameEntity)a.a(paramParcel, j, GameEntity.CREATOR);
        break;
      case 2: 
        str5 = a.o(paramParcel, j);
        break;
      case 3: 
        l2 = a.i(paramParcel, j);
        break;
      case 4: 
        localUri1 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 5: 
        str3 = a.o(paramParcel, j);
        break;
      case 6: 
        str4 = a.o(paramParcel, j);
        break;
      case 7: 
        l4 = a.i(paramParcel, j);
        break;
      case 8: 
        l3 = a.i(paramParcel, j);
        break;
      case 9: 
        localUri2 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 10: 
        str2 = a.o(paramParcel, j);
        break;
      case 12: 
        str1 = a.o(paramParcel, j);
        break;
      case 13: 
        l1 = a.i(paramParcel, j);
        break;
      case 14: 
        l5 = a.i(paramParcel, j);
        break;
      case 15: 
        k = a.g(paramParcel, j);
        break;
      case 16: 
        m = a.g(paramParcel, j);
        break;
      case 17: 
        localArrayList = a.c(paramParcel, j, MilestoneEntity.CREATOR);
        break;
      case 1000: 
        n = a.g(paramParcel, j);
      }
    }
  }
  
  public QuestEntity[] newArray(int paramInt)
  {
    return new QuestEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestEntityCreator
 * JD-Core Version:    0.7.0.1
 */