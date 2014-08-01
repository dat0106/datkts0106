package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new a();
  final boolean Lg;
  final String mName;
  final int xJ;
  
  BeginCompoundOperationRequest(int paramInt, boolean paramBoolean, String paramString)
  {
    this.xJ = paramInt;
    this.Lg = paramBoolean;
    this.mName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest
 * JD-Core Version:    0.7.0.1
 */