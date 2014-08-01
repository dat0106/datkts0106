package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnContentsResponse> CREATOR = new ag();
  final Contents HD;
  final int xJ;
  
  OnContentsResponse(int paramInt, Contents paramContents)
  {
    this.xJ = paramInt;
    this.HD = paramContents;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Contents go()
  {
    return this.HD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnContentsResponse
 * JD-Core Version:    0.7.0.1
 */