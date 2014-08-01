package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  String label;
  String value;
  private final int xJ;
  
  b()
  {
    this.xJ = 1;
  }
  
  b(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.label = paramString1;
    this.value = paramString2;
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.b
 * JD-Core Version:    0.7.0.1
 */