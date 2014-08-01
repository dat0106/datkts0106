package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator<c> CREATOR = new d();
  private final int AQ;
  private final String YI;
  private final int alf;
  private final boolean alg;
  private final String mName;
  final int xJ;
  
  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.mName = paramString1;
    this.YI = paramString2;
    this.AQ = paramInt2;
    this.alf = paramInt3;
    this.alg = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof c))
    {
      c localc = (c)paramObject;
      if ((hl.equal(Integer.valueOf(this.xJ), Integer.valueOf(localc.xJ))) && (hl.equal(this.mName, localc.mName)) && (hl.equal(this.YI, localc.YI)) && (hl.equal(Integer.valueOf(this.AQ), Integer.valueOf(localc.AQ))) && (hl.equal(Integer.valueOf(this.alf), Integer.valueOf(localc.alf))) && (hl.equal(Boolean.valueOf(this.alg), Boolean.valueOf(localc.alg)))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public String getAddress()
  {
    return this.YI;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRole()
  {
    return this.alf;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.xJ);
    arrayOfObject[1] = this.mName;
    arrayOfObject[2] = this.YI;
    arrayOfObject[3] = Integer.valueOf(this.AQ);
    arrayOfObject[4] = Integer.valueOf(this.alf);
    arrayOfObject[5] = Boolean.valueOf(this.alg);
    return hl.hashCode(arrayOfObject);
  }
  
  public boolean isEnabled()
  {
    return this.alg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.YI);
    localStringBuilder.append(", mType=" + this.AQ);
    localStringBuilder.append(", mRole=" + this.alf);
    localStringBuilder.append(", mEnabled=" + this.alg);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.c
 * JD-Core Version:    0.7.0.1
 */