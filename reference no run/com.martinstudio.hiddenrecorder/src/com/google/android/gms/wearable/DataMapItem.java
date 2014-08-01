package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.lw.a;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final DataMap ali;
  private final Uri mUri;
  
  private DataMapItem(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.ali = a((DataItem)paramDataItem.freeze());
  }
  
  private DataMap a(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {}
    for (Object localObject = new DataMap();; localObject = localObject)
    {
      return localObject;
      ArrayList localArrayList;
      for (;;)
      {
        int j;
        try
        {
          localArrayList = new ArrayList();
          int i = paramDataItem.getAssets().size();
          j = 0;
          if (j >= i) {
            break;
          }
          localObject = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(j));
          if (localObject == null) {
            throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + j + " for " + paramDataItem);
          }
        }
        catch (me localme)
        {
          throw new IllegalStateException("Unable to parse. Not a DataItem.");
        }
        localArrayList.add(Asset.createFromRef(((DataItemAsset)localObject).getId()));
        j++;
      }
      localObject = lw.a(new lw.a(lx.n(paramDataItem.getData()), localArrayList));
    }
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem != null) {
      return new DataMapItem(paramDataItem);
    }
    throw new IllegalStateException("provided dataItem is null");
  }
  
  public DataMap getDataMap()
  {
    return this.ali;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * JD-Core Version:    0.7.0.1
 */