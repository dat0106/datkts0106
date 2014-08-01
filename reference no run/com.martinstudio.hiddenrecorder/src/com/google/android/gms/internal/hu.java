package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hu
  implements SafeParcelable
{
  public static final hv CREATOR = new hv();
  private final hw GS;
  private final int xJ;
  
  hu(int paramInt, hw paramhw)
  {
    this.xJ = paramInt;
    this.GS = paramhw;
  }
  
  private hu(hw paramhw)
  {
    this.xJ = 1;
    this.GS = paramhw;
  }
  
  public static hu a(hz.b<?, ?> paramb)
  {
    if (!(paramb instanceof hw)) {
      throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    return new hu((hw)paramb);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  hw fw()
  {
    return this.GS;
  }
  
  public hz.b<?, ?> fx()
  {
    if (this.GS == null) {
      throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
    return this.GS;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hv.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hu
 * JD-Core Version:    0.7.0.1
 */