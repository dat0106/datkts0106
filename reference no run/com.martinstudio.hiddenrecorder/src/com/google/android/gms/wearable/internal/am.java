package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class am
  implements SafeParcelable
{
  public static final Parcelable.Creator<am> CREATOR = new an();
  public final m alL;
  public final int statusCode;
  public final int versionCode;
  
  am(int paramInt1, int paramInt2, m paramm)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.alL = paramm;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.am
 * JD-Core Version:    0.7.0.1
 */