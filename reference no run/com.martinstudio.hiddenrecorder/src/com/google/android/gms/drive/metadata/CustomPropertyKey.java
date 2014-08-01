package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new c();
  final String JI;
  final int JJ;
  final int xJ;
  
  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    this.xJ = paramInt1;
    hn.b(paramString, "key");
    if ((paramInt2 != 0) && (paramInt2 != i)) {
      i = 0;
    }
    hn.a(i, "visibility must be either PUBLIC or PRIVATE");
    this.JI = paramString;
    this.JJ = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    CustomPropertyKey localCustomPropertyKey1 = 1;
    int i = 0;
    CustomPropertyKey localCustomPropertyKey2;
    if (paramObject != null) {
      if (paramObject != this)
      {
        if ((paramObject instanceof CustomPropertyKey))
        {
          localCustomPropertyKey2 = (CustomPropertyKey)paramObject;
          if ((!localCustomPropertyKey2.getKey().equals(this.JI)) || (localCustomPropertyKey2.getVisibility() != this.JJ)) {
            localCustomPropertyKey1 = 0;
          }
          localCustomPropertyKey2 = localCustomPropertyKey1;
        }
      }
      else {
        localCustomPropertyKey2 = localCustomPropertyKey1;
      }
    }
    return localCustomPropertyKey2;
  }
  
  public String getKey()
  {
    return this.JI;
  }
  
  public int getVisibility()
  {
    return this.JJ;
  }
  
  public int hashCode()
  {
    return (this.JI + this.JJ).hashCode();
  }
  
  public String toString()
  {
    return "CustomPropertyKey(" + this.JI + "," + this.JJ + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.CustomPropertyKey
 * JD-Core Version:    0.7.0.1
 */