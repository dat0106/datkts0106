package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fn
  implements SafeParcelable
{
  public static final fo CREATOR = new fo();
  public final int id;
  final int xJ;
  final Bundle xV;
  
  fn(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.xJ = paramInt1;
    this.id = paramInt2;
    this.xV = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fo.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fn
 * JD-Core Version:    0.7.0.1
 */