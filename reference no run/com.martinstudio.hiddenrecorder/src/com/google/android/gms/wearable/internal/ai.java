package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class ai
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<ai> CREATOR = new aj();
  private final String Lk;
  private final String xD;
  final int xJ;
  
  ai(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.xD = paramString1;
    this.Lk = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof ai))
    {
      ai localai = (ai)paramObject;
      if ((localai.xD.equals(this.xD)) && (localai.Lk.equals(this.Lk))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public int hashCode()
  {
    return 37 * (629 + this.xD.hashCode()) + this.Lk.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.xD + "," + this.Lk + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ai
 * JD-Core Version:    0.7.0.1
 */