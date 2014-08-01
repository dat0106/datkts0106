package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
  implements DataItem
{
  private byte[] TC;
  private Map<String, DataItemAsset> alH;
  private Uri mUri;
  
  public l(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.TC = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.alH = Collections.unmodifiableMap(localHashMap);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getKey() != null) {
        localHashMap.put(localEntry.getKey(), ((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.alH;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItem nm()
  {
    return this;
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("DataItemEntity[");
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    Object localObject3 = new StringBuilder().append(",dataSz=");
    Object localObject2;
    if (this.TC != null) {
      localObject2 = Integer.valueOf(this.TC.length);
    } else {
      localObject2 = "null";
    }
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).append(", numAssets=" + this.alH.size());
    ((StringBuilder)localObject1).append(", uri=" + this.mUri);
    if (paramBoolean)
    {
      ((StringBuilder)localObject1).append("]\n  assets: ");
      localObject2 = this.alH.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject1).append("\n  ]");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("\n    " + (String)localObject3 + ": " + this.alH.get(localObject3));
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.l
 * JD-Core Version:    0.7.0.1
 */