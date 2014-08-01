package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ih;
import java.util.ArrayList;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  String akM;
  String akN;
  ArrayList<b> akO;
  private final int xJ;
  
  d()
  {
    this.xJ = 1;
    this.akO = ih.fV();
  }
  
  d(int paramInt, String paramString1, String paramString2, ArrayList<b> paramArrayList)
  {
    this.xJ = paramInt;
    this.akM = paramString1;
    this.akN = paramString2;
    this.akO = paramArrayList;
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
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.d
 * JD-Core Version:    0.7.0.1
 */