package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lh
  implements SafeParcelable
{
  public static final Parcelable.Creator<lh> CREATOR = new li();
  int[] aka;
  private final int xJ;
  
  lh()
  {
    this(1, null);
  }
  
  lh(int paramInt, int[] paramArrayOfInt)
  {
    this.xJ = paramInt;
    this.aka = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    li.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lh
 * JD-Core Version:    0.7.0.1
 */