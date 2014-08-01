package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValueChangedDetails> CREATOR = new g();
  final int LJ;
  final int xJ;
  
  ValueChangedDetails(int paramInt1, int paramInt2)
  {
    this.xJ = paramInt1;
    this.LJ = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
 * JD-Core Version:    0.7.0.1
 */