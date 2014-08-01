package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
  implements SafeParcelable
{
  public static final Parcelable.Creator<CountrySpecification> CREATOR = new a();
  String rc;
  private final int xJ;
  
  CountrySpecification(int paramInt, String paramString)
  {
    this.xJ = paramInt;
    this.rc = paramString;
  }
  
  public CountrySpecification(String paramString)
  {
    this.xJ = 1;
    this.rc = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCountryCode()
  {
    return this.rc;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.CountrySpecification
 * JD-Core Version:    0.7.0.1
 */