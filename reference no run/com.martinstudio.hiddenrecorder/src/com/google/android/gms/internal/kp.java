package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kp
  implements Parcelable.Creator<ko>
{
  static void a(ko paramko, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramko.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramko.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramko.kg(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramko.getAdditionalName(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramko.kh(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramko.getAddressCountry(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramko.getAddressLocality(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramko.getAddressRegion(), true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.b(paramParcel, 8, paramko.ki(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.c(paramParcel, 9, paramko.getAttendeeCount());
    }
    if (localSet.contains(Integer.valueOf(10))) {
      b.b(paramParcel, 10, paramko.kj(), true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      b.a(paramParcel, 11, paramko.kk(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.b(paramParcel, 12, paramko.kl(), true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      b.a(paramParcel, 13, paramko.getBestRating(), true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, paramko.getBirthDate(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, paramko.km(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(17))) {
      b.a(paramParcel, 17, paramko.getContentSize(), true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, paramko.getCaption(), true);
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.b(paramParcel, 19, paramko.kn(), true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, paramko.getContentUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.a(paramParcel, 21, paramko.getDateModified(), true);
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, paramko.getDateCreated(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.a(paramParcel, 23, paramko.getDescription(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.a(paramParcel, 22, paramko.getDatePublished(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.a(paramParcel, 25, paramko.getEmbedUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.a(paramParcel, 24, paramko.getDuration(), true);
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, paramko.getFamilyName(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, paramko.getEndDate(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, paramko.ko(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.a(paramParcel, 28, paramko.getGender(), true);
    }
    if (localSet.contains(Integer.valueOf(31))) {
      b.a(paramParcel, 31, paramko.getHeight(), true);
    }
    if (localSet.contains(Integer.valueOf(30))) {
      b.a(paramParcel, 30, paramko.getGivenName(), true);
    }
    if (localSet.contains(Integer.valueOf(34))) {
      b.a(paramParcel, 34, paramko.kp(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(32))) {
      b.a(paramParcel, 32, paramko.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(33))) {
      b.a(paramParcel, 33, paramko.getImage(), true);
    }
    if (localSet.contains(Integer.valueOf(38))) {
      b.a(paramParcel, 38, paramko.getLongitude());
    }
    if (localSet.contains(Integer.valueOf(39))) {
      b.a(paramParcel, 39, paramko.getName(), true);
    }
    if (localSet.contains(Integer.valueOf(36))) {
      b.a(paramParcel, 36, paramko.getLatitude());
    }
    if (localSet.contains(Integer.valueOf(37))) {
      b.a(paramParcel, 37, paramko.kq(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(42))) {
      b.a(paramParcel, 42, paramko.getPlayerType(), true);
    }
    if (localSet.contains(Integer.valueOf(43))) {
      b.a(paramParcel, 43, paramko.getPostOfficeBoxNumber(), true);
    }
    if (localSet.contains(Integer.valueOf(40))) {
      b.a(paramParcel, 40, paramko.kr(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(41))) {
      b.b(paramParcel, 41, paramko.ks(), true);
    }
    if (localSet.contains(Integer.valueOf(46))) {
      b.a(paramParcel, 46, paramko.kt(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(47))) {
      b.a(paramParcel, 47, paramko.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(44))) {
      b.a(paramParcel, 44, paramko.getPostalCode(), true);
    }
    if (localSet.contains(Integer.valueOf(45))) {
      b.a(paramParcel, 45, paramko.getRatingValue(), true);
    }
    if (localSet.contains(Integer.valueOf(51))) {
      b.a(paramParcel, 51, paramko.getThumbnailUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(50))) {
      b.a(paramParcel, 50, paramko.ku(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(49))) {
      b.a(paramParcel, 49, paramko.getText(), true);
    }
    if (localSet.contains(Integer.valueOf(48))) {
      b.a(paramParcel, 48, paramko.getStreetAddress(), true);
    }
    if (localSet.contains(Integer.valueOf(55))) {
      b.a(paramParcel, 55, paramko.getWidth(), true);
    }
    if (localSet.contains(Integer.valueOf(54))) {
      b.a(paramParcel, 54, paramko.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(53))) {
      b.a(paramParcel, 53, paramko.getType(), true);
    }
    if (localSet.contains(Integer.valueOf(52))) {
      b.a(paramParcel, 52, paramko.getTickerSymbol(), true);
    }
    if (localSet.contains(Integer.valueOf(56))) {
      b.a(paramParcel, 56, paramko.getWorstRating(), true);
    }
    b.G(paramParcel, i);
  }
  
  public ko bE(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    ko localko3 = null;
    Object localObject4 = null;
    ko localko7 = null;
    String str29 = null;
    String str25 = null;
    String str33 = null;
    Object localObject6 = null;
    int k = 0;
    Object localObject3 = null;
    ko localko5 = null;
    Object localObject5 = null;
    String str5 = null;
    String str16 = null;
    ko localko1 = null;
    String str30 = null;
    String str31 = null;
    String str11 = null;
    Object localObject2 = null;
    String str13 = null;
    String str12 = null;
    String str20 = null;
    String str34 = null;
    String str19 = null;
    String str7 = null;
    String str8 = null;
    String str1 = null;
    String str24 = null;
    ko localko6 = null;
    String str22 = null;
    String str32 = null;
    String str28 = null;
    String str26 = null;
    ko localko10 = null;
    double d2 = 0.0D;
    ko localko8 = null;
    double d1 = 0.0D;
    String str9 = null;
    ko localko9 = null;
    Object localObject1 = null;
    String str15 = null;
    String str23 = null;
    String str10 = null;
    String str2 = null;
    ko localko2 = null;
    String str21 = null;
    String str27 = null;
    String str14 = null;
    ko localko4 = null;
    String str35 = null;
    String str4 = null;
    String str17 = null;
    String str6 = null;
    String str3 = null;
    String str18 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ko(localHashSet, j, localko3, (List)localObject4, localko7, str29, str25, str33, (List)localObject6, k, (List)localObject3, localko5, (List)localObject5, str5, str16, localko1, str30, str31, str11, (List)localObject2, str13, str12, str20, str34, str19, str7, str8, str1, str24, localko6, str22, str32, str28, str26, localko10, d2, localko8, d1, str9, localko9, (List)localObject1, str15, str23, str10, str2, localko2, str21, str27, str14, localko4, str35, str4, str17, str6, str3, str18);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      case 35: 
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        localko3 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        localko3 = localko3;
        break;
      case 3: 
        localObject4 = a.B(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        localko7 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        localko7 = localko7;
        break;
      case 5: 
        str29 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str25 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str33 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        localObject6 = a.c(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        localObject3 = a.c(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(10));
        break;
      case 11: 
        localko5 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(11));
        localko5 = localko5;
        break;
      case 12: 
        localObject5 = a.c(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 13: 
        str5 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(13));
        break;
      case 14: 
        str16 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localko1 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localko1 = localko1;
        break;
      case 16: 
        str30 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 17: 
        str31 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(17));
        break;
      case 18: 
        str11 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 19: 
        localObject2 = a.c(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        break;
      case 20: 
        str13 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 21: 
        str12 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 22: 
        str20 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 23: 
        str34 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 24: 
        str19 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 25: 
        str7 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 26: 
        str8 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 27: 
        str1 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 28: 
        str24 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 29: 
        localko6 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(29));
        localko6 = localko6;
        break;
      case 30: 
        str22 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(30));
        break;
      case 31: 
        str32 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(31));
        break;
      case 32: 
        str28 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(32));
        break;
      case 33: 
        str26 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(33));
        break;
      case 34: 
        localko10 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(34));
        localko10 = localko10;
        break;
      case 36: 
        d2 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(36));
        break;
      case 37: 
        localko8 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(37));
        localko8 = localko8;
        break;
      case 38: 
        d1 = a.m(paramParcel, m);
        localHashSet.add(Integer.valueOf(38));
        break;
      case 39: 
        str9 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(39));
        break;
      case 40: 
        localko9 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(40));
        localko9 = localko9;
        break;
      case 41: 
        localObject1 = a.c(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(41));
        break;
      case 42: 
        str15 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(42));
        break;
      case 43: 
        str23 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(43));
        break;
      case 44: 
        str10 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(44));
        break;
      case 45: 
        str2 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(45));
        break;
      case 46: 
        localko2 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(46));
        localko2 = localko2;
        break;
      case 47: 
        str21 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(47));
        break;
      case 48: 
        str27 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(48));
        break;
      case 49: 
        str14 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(49));
        break;
      case 50: 
        localko4 = (ko)a.a(paramParcel, m, ko.CREATOR);
        localHashSet.add(Integer.valueOf(50));
        localko4 = localko4;
        break;
      case 51: 
        str35 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(51));
        break;
      case 52: 
        str4 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(52));
        break;
      case 53: 
        str17 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(53));
        break;
      case 54: 
        str6 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(54));
        break;
      case 55: 
        str3 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(55));
        break;
      case 56: 
        str18 = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(56));
      }
    }
  }
  
  public ko[] db(int paramInt)
  {
    return new ko[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kp
 * JD-Core Version:    0.7.0.1
 */