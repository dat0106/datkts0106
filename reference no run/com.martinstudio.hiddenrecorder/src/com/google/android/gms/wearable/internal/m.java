package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m
  implements SafeParcelable, DataItem
{
  public static final Parcelable.Creator<m> CREATOR = new n();
  private byte[] TC;
  private final Map<String, DataItemAsset> alH;
  private final Uri mUri;
  final int xJ;
  
  m(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.xJ = paramInt;
    this.mUri = paramUri;
    HashMap localHashMap = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.alH = localHashMap;
        this.TC = paramArrayOfByte;
        return;
      }
      String str = (String)localIterator.next();
      localHashMap.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
  }
  
  public int describeContents()
  {
    return 0;
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
  
  public m m(byte[] paramArrayOfByte)
  {
    this.TC = paramArrayOfByte;
    return this;
  }
  
  public Bundle nh()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = this.alH.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localBundle;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((DataItemAsset)localEntry.getValue()));
    }
  }
  
  public m nn()
  {
    return this;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("DataItemParcelable[");
    ((StringBuilder)localObject1).append("@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    Object localObject2 = new StringBuilder().append(",dataSz=");
    Object localObject3;
    if (this.TC != null) {
      localObject3 = Integer.valueOf(this.TC.length);
    } else {
      localObject3 = "null";
    }
    ((StringBuilder)localObject1).append(localObject3);
    ((StringBuilder)localObject1).append(", numAssets=" + this.alH.size());
    ((StringBuilder)localObject1).append(", uri=" + this.mUri);
    if (paramBoolean)
    {
      ((StringBuilder)localObject1).append("]\n  assets: ");
      localObject3 = this.alH.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext())
        {
          ((StringBuilder)localObject1).append("\n  ]");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        }
        localObject2 = (String)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append("\n    " + (String)localObject2 + ": " + this.alH.get(localObject2));
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.m
 * JD-Core Version:    0.7.0.1
 */