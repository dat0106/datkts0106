package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<WebImage>
{
  static void a(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramWebImage.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramWebImage.getUrl(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramWebImage.getWidth());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 4, paramWebImage.getHeight());
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public WebImage[] ak(int paramInt)
  {
    return new WebImage[paramInt];
  }
  
  public WebImage y(Parcel paramParcel)
  {
    Object localObject1 = 0;
    int i = a.B(paramParcel);
    Object localObject4 = null;
    Object localObject2 = 0;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new WebImage(j, (Uri)localObject4, localObject2, localObject1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      Object localObject5 = a.A(paramParcel);
      switch (a.ar(localObject5))
      {
      default: 
        a.b(paramParcel, localObject5);
        localObject5 = localObject1;
        localObject1 = localObject2;
        localObject3 = localObject4;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, localObject5);
        localObject5 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        j = j;
        localObject5 = localObject5;
        break;
      case 2: 
        localObject4 = (Uri)a.a(paramParcel, localObject5, Uri.CREATOR);
        j = j;
        Object localObject6 = localObject3;
        localObject3 = localObject4;
        localObject5 = localObject1;
        localObject1 = localObject6;
        break;
      case 3: 
        localObject5 = a.g(paramParcel, localObject5);
        localObject3 = localObject4;
        j = j;
        localObject4 = localObject1;
        localObject1 = localObject5;
        localObject5 = localObject4;
        break;
      case 4: 
        localObject5 = a.g(paramParcel, localObject5);
        localObject1 = localObject3;
        localObject3 = localObject4;
        j = j;
      }
      j = j;
      localObject4 = localObject3;
      Object localObject3 = localObject1;
      localObject1 = localObject5;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.b
 * JD-Core Version:    0.7.0.1
 */