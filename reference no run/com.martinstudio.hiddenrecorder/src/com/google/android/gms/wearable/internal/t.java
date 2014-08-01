package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class t
  implements SafeParcelable
{
  public static final Parcelable.Creator<t> CREATOR = new u();
  public final List<ai> alK;
  public final int statusCode;
  public final int versionCode;
  
  t(int paramInt1, int paramInt2, List<ai> paramList)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.alK = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.t
 * JD-Core Version:    0.7.0.1
 */