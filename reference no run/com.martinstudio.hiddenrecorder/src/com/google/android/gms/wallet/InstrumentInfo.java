package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<InstrumentInfo> CREATOR = new h();
  private String aiZ;
  private String aja;
  private final int xJ;
  
  InstrumentInfo(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.aiZ = paramString1;
    this.aja = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getInstrumentDetails()
  {
    return this.aja;
  }
  
  public String getInstrumentType()
  {
    return this.aiZ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.InstrumentInfo
 * JD-Core Version:    0.7.0.1
 */