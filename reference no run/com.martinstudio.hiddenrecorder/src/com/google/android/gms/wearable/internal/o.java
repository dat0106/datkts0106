package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class o
  extends d
  implements DataItem
{
  private final int RD;
  
  public o(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RD = paramInt2;
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    HashMap localHashMap = new HashMap(this.RD);
    for (int i = 0;; i++)
    {
      if (i >= this.RD) {
        return localHashMap;
      }
      k localk = new k(this.DD, i + this.Ez);
      if (localk.getDataItemKey() != null) {
        localHashMap.put(localk.getDataItemKey(), localk);
      }
    }
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public Uri getUri()
  {
    return Uri.parse(getString("path"));
  }
  
  public DataItem nm()
  {
    return new l(this);
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.o
 * JD-Core Version:    0.7.0.1
 */