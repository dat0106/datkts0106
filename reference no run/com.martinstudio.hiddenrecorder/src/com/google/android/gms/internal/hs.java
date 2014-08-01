package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hs
  implements SafeParcelable
{
  public static final ht CREATOR = new ht();
  public final String GQ;
  public final int GR;
  final int xJ;
  
  public hs(int paramInt1, String paramString, int paramInt2)
  {
    this.xJ = paramInt1;
    this.GQ = paramString;
    this.GR = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ht.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hs
 * JD-Core Version:    0.7.0.1
 */