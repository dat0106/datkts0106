package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class a
  implements Parcelable.Creator<ApplicationMetadata>
{
  static void a(ApplicationMetadata paramApplicationMetadata, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramApplicationMetadata.getVersionCode());
    b.a(paramParcel, 2, paramApplicationMetadata.getApplicationId(), false);
    b.a(paramParcel, 3, paramApplicationMetadata.getName(), false);
    b.b(paramParcel, 4, paramApplicationMetadata.getImages(), false);
    b.a(paramParcel, 5, paramApplicationMetadata.zO, false);
    b.a(paramParcel, 6, paramApplicationMetadata.getSenderAppIdentifier(), false);
    b.a(paramParcel, 7, paramApplicationMetadata.dS(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ApplicationMetadata[] M(int paramInt)
  {
    return new ApplicationMetadata[paramInt];
  }
  
  public ApplicationMetadata r(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int k = 0;
    String str3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    String str1 = null;
    String str2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ApplicationMetadata(k, str2, str1, (List)localObject2, (List)localObject1, str3, localUri);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(i))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i);
        break;
      case 2: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 3: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 4: 
        localObject2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i, WebImage.CREATOR);
        break;
      case 5: 
        localObject1 = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel, i);
        break;
      case 6: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 7: 
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, Uri.CREATOR);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.a
 * JD-Core Version:    0.7.0.1
 */