package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fj
  implements SafeParcelable
{
  public static final fk CREATOR = new fk();
  final int xJ;
  final String xN;
  final String xO;
  final String xP;
  
  fj(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.xJ = paramInt;
    this.xN = paramString1;
    this.xO = paramString2;
    this.xP = paramString3;
  }
  
  public fj(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.xN;
    arrayOfObject[1] = this.xO;
    arrayOfObject[2] = this.xP;
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fk.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fj
 * JD-Core Version:    0.7.0.1
 */