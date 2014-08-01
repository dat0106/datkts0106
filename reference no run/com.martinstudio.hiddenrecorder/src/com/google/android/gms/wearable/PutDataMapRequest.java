package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.lw.a;
import com.google.android.gms.internal.mf;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap ali;
  private final PutDataRequest alj;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.alj = paramPutDataRequest;
    this.ali = new DataMap();
    if (paramDataMap != null) {
      this.ali.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.j(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    lw.a locala = lw.a(this.ali);
    this.alj.setData(mf.d(locala.amm));
    int i = locala.amn.size();
    String str;
    Asset localAsset;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return this.alj;
      }
      str = Integer.toString(j);
      localAsset = (Asset)locala.amn.get(j);
      if (str == null) {
        break label164;
      }
      if (localAsset == null) {
        break;
      }
      if (Log.isLoggable("DataMap", 3)) {
        Log.d("DataMap", "asPutDataRequest: adding asset: " + str + " " + localAsset);
      }
      this.alj.putAsset(str, localAsset);
    }
    throw new IllegalStateException("asset cannot be null: key=" + str);
    label164:
    throw new IllegalStateException("asset key cannot be null: " + localAsset);
  }
  
  public DataMap getDataMap()
  {
    return this.ali;
  }
  
  public Uri getUri()
  {
    return this.alj.getUri();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataMapRequest
 * JD-Core Version:    0.7.0.1
 */