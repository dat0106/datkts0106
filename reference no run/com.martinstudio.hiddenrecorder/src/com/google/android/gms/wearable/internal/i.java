package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class i
  implements DataItemAsset
{
  private final String JI;
  private final String xD;
  
  public i(DataItemAsset paramDataItemAsset)
  {
    this.xD = paramDataItemAsset.getId();
    this.JI = paramDataItemAsset.getDataItemKey();
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
    localStringBuilder.append("DataItemAssetEntity[");
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
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.i
 * JD-Core Version:    0.7.0.1
 */