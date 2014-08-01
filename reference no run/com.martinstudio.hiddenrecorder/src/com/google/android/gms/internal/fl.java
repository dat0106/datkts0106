package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fl
  implements SafeParcelable
{
  public static final fm CREATOR = new fm();
  public static final int xQ = Integer.parseInt("-1");
  final int xJ;
  public final String xR;
  final fq xS;
  public final int xT;
  public final byte[] xU;
  
  fl(int paramInt1, String paramString, fq paramfq, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((paramInt2 != xQ) && (fp.H(paramInt2) == null)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "Invalid section type " + paramInt2);
    this.xJ = paramInt1;
    this.xR = paramString;
    this.xS = paramfq;
    this.xT = paramInt2;
    this.xU = paramArrayOfByte;
    String str = dJ();
    if (str == null) {
      return;
    }
    throw new IllegalArgumentException(str);
  }
  
  public fl(String paramString, fq paramfq)
  {
    this(1, paramString, paramfq, xQ, null);
  }
  
  public fl(String paramString1, fq paramfq, String paramString2)
  {
    this(1, paramString1, paramfq, fp.Y(paramString2), null);
  }
  
  public fl(byte[] paramArrayOfByte, fq paramfq)
  {
    this(1, null, paramfq, xQ, paramArrayOfByte);
  }
  
  public String dJ()
  {
    String str;
    if ((this.xT == xQ) || (fp.H(this.xT) != null))
    {
      if ((this.xR == null) || (this.xU == null)) {
        str = null;
      } else {
        str = "Both content and blobContent set";
      }
    }
    else {
      str = "Invalid section type " + this.xT;
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fm.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fl
 * JD-Core Version:    0.7.0.1
 */