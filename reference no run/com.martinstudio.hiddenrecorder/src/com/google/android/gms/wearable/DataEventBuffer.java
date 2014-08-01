package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.h;

public class DataEventBuffer
  extends g<DataEvent>
  implements Result
{
  private final Status yw;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.yw = new Status(paramDataHolder.getStatusCode());
  }
  
  protected String eU()
  {
    return "path";
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  protected DataEvent m(int paramInt1, int paramInt2)
  {
    return new h(this.DD, paramInt1, paramInt2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataEventBuffer
 * JD-Core Version:    0.7.0.1
 */