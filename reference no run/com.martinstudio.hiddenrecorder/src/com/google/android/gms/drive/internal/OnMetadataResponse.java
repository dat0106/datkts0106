package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new am();
  final MetadataBundle IA;
  final int xJ;
  
  OnMetadataResponse(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.xJ = paramInt;
    this.IA = paramMetadataBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MetadataBundle gw()
  {
    return this.IA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    am.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnMetadataResponse
 * JD-Core Version:    0.7.0.1
 */