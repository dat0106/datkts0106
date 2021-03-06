package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new i();
  final int LC;
  final int LD;
  final String LM;
  final int LN;
  final int mIndex;
  final int xJ;
  
  ValuesRemovedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this.xJ = paramInt1;
    this.mIndex = paramInt2;
    this.LC = paramInt3;
    this.LD = paramInt4;
    this.LM = paramString;
    this.LN = paramInt5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
 * JD-Core Version:    0.7.0.1
 */