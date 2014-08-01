package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable
  implements SafeParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new j();
  private final String JI;
  private final String xD;
  final int xJ;
  
  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.xD = paramString1;
    this.JI = paramString2;
  }
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    this.xJ = 1;
    this.xD = ((String)hn.f(paramDataItemAsset.getId()));
    this.JI = ((String)hn.f(paramDataItemAsset.getDataItemKey()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDataItemKey()
  {
    return this.JI;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItemAsset nl()
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.xD != null)
    {
      localStringBuilder.append(",");
      localStringBuilder.append(this.xD);
    }
    else
    {
      localStringBuilder.append(",noid");
    }
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.JI);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */