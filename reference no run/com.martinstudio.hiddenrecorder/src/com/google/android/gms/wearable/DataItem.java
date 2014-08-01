package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

public abstract interface DataItem
  extends Freezable<DataItem>
{
  public abstract Map<String, DataItemAsset> getAssets();
  
  public abstract byte[] getData();
  
  public abstract Uri getUri();
  
  public abstract DataItem setData(byte[] paramArrayOfByte);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItem
 * JD-Core Version:    0.7.0.1
 */