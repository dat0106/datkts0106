package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListParentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new al();
  final DataHolder Jy;
  final int xJ;
  
  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    this.xJ = paramInt;
    this.Jy = paramDataHolder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder gv()
  {
    return this.Jy;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    al.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnListParentsResponse
 * JD-Core Version:    0.7.0.1
 */