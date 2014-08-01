package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new k();
  public static final Operator KX = new Operator("=");
  public static final Operator KY = new Operator("<");
  public static final Operator KZ = new Operator("<=");
  public static final Operator La = new Operator(">");
  public static final Operator Lb = new Operator(">=");
  public static final Operator Lc = new Operator("and");
  public static final Operator Ld = new Operator("or");
  public static final Operator Le = new Operator("not");
  public static final Operator Lf = new Operator("contains");
  final String mTag;
  final int xJ;
  
  Operator(int paramInt, String paramString)
  {
    this.xJ = paramInt;
    this.mTag = paramString;
  }
  
  private Operator(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if (paramObject != null)
      {
        if (getClass() == paramObject.getClass())
        {
          Operator localOperator = (Operator)paramObject;
          if (this.mTag != null)
          {
            if (!this.mTag.equals(localOperator.mTag)) {
              bool = false;
            }
          }
          else if (localOperator.mTag != null) {
            bool = false;
          }
        }
        else
        {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i;
    if (this.mTag != null) {
      i = this.mTag.hashCode();
    } else {
      i = 0;
    }
    return i + 31;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.Operator
 * JD-Core Version:    0.7.0.1
 */