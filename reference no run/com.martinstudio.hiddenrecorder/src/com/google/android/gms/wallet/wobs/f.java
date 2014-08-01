package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class f
  implements SafeParcelable
{
  public static final Parcelable.Creator<f> CREATOR = new i();
  l ajp;
  g akP;
  String label;
  String type;
  private final int xJ;
  
  f()
  {
    this.xJ = 1;
  }
  
  f(int paramInt, String paramString1, g paramg, String paramString2, l paraml)
  {
    this.xJ = paramInt;
    this.label = paramString1;
    this.akP = paramg;
    this.type = paramString2;
    this.ajp = paraml;
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
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.f
 * JD-Core Version:    0.7.0.1
 */