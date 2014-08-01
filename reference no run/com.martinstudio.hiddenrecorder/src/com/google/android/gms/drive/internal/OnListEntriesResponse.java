package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListEntriesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new ak();
  final boolean IM;
  final DataHolder Jx;
  final int xJ;
  
  OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.Jx = paramDataHolder;
    this.IM = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder gt()
  {
    return this.Jx;
  }
  
  public boolean gu()
  {
    return this.IM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ak.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnListEntriesResponse
 * JD-Core Version:    0.7.0.1
 */