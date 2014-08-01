package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ew
  implements SafeParcelable
{
  public static final ex CREATOR = new ex();
  public String st;
  public int su;
  public int sv;
  public boolean sw;
  public final int versionCode;
  
  public ew(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(1, str, paramInt1, paramInt2, paramBoolean);
  }
  
  ew(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.st = paramString;
    this.su = paramInt2;
    this.sv = paramInt3;
    this.sw = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ex.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ew
 * JD-Core Version:    0.7.0.1
 */