package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new e();
  public static final String WEAR_URI_SCHEME = "wear";
  private static final Random alk = new SecureRandom();
  private byte[] TC;
  private final Bundle all;
  private final Uri mUri;
  final int xJ;
  
  private PutDataRequest(int paramInt, Uri paramUri)
  {
    this(paramInt, paramUri, new Bundle(), null);
  }
  
  PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.xJ = paramInt;
    this.mUri = paramUri;
    this.all = paramBundle;
    this.all.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.TC = paramArrayOfByte;
  }
  
  public static PutDataRequest create(String paramString)
  {
    return j(cx(paramString));
  }
  
  public static PutDataRequest createFromDataItem(DataItem paramDataItem)
  {
    PutDataRequest localPutDataRequest = j(paramDataItem.getUri());
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    Map.Entry localEntry;
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localPutDataRequest.setData(paramDataItem.getData());
        return localPutDataRequest;
      }
      localEntry = (Map.Entry)localIterator.next();
      if (((DataItemAsset)localEntry.getValue()).getId() == null) {
        break;
      }
      localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromRef(((DataItemAsset)localEntry.getValue()).getId()));
    }
    throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + (String)localEntry.getKey());
  }
  
  public static PutDataRequest createWithAutoAppendedId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.endsWith("/")) {
      localStringBuilder.append("/");
    }
    localStringBuilder.append("PN").append(alk.nextLong());
    return new PutDataRequest(1, cx(localStringBuilder.toString()));
  }
  
  private static Uri cx(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("/"))
      {
        if (!paramString.startsWith("//")) {
          return new Uri.Builder().scheme("wear").path(paramString).build();
        }
        throw new IllegalArgumentException("A path must start with a single / .");
      }
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    throw new IllegalArgumentException("An empty path was supplied.");
  }
  
  public static PutDataRequest j(Uri paramUri)
  {
    return new PutDataRequest(1, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Asset getAsset(String paramString)
  {
    return (Asset)this.all.getParcelable(paramString);
  }
  
  public Map<String, Asset> getAssets()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.all.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return Collections.unmodifiableMap(localHashMap);
      }
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)this.all.getParcelable(str));
    }
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean hasAsset(String paramString)
  {
    return this.all.containsKey(paramString);
  }
  
  public Bundle nh()
  {
    return this.all;
  }
  
  public PutDataRequest putAsset(String paramString, Asset paramAsset)
  {
    hn.f(paramString);
    hn.f(paramAsset);
    this.all.putParcelable(paramString, paramAsset);
    return this;
  }
  
  public PutDataRequest removeAsset(String paramString)
  {
    this.all.remove(paramString);
    return this;
  }
  
  public PutDataRequest setData(byte[] paramArrayOfByte)
  {
    this.TC = paramArrayOfByte;
    return this;
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataMap", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("PutDataRequest[");
    Object localObject3 = new StringBuilder().append("dataSz=");
    Object localObject2;
    if (this.TC != null) {
      localObject2 = Integer.valueOf(this.TC.length);
    } else {
      localObject2 = "null";
    }
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).append(", numAssets=" + this.all.size());
    ((StringBuilder)localObject1).append(", uri=" + this.mUri);
    if (paramBoolean)
    {
      ((StringBuilder)localObject1).append("]\n  assets: ");
      localObject3 = this.all.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext())
        {
          ((StringBuilder)localObject1).append("\n  ]");
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        }
        localObject2 = (String)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append("\n    " + (String)localObject2 + ": " + this.all.getParcelable((String)localObject2));
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.7.0.1
 */