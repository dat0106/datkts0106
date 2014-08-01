package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class h
  extends d
  implements DataEvent
{
  private final int RD;
  
  public h(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.RD = paramInt2;
  }
  
  public DataItem getDataItem()
  {
    return new o(this.DD, this.Ez, this.RD);
  }
  
  public int getType()
  {
    return getInteger("event_type");
  }
  
  public DataEvent nk()
  {
    return new g(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.h
 * JD-Core Version:    0.7.0.1
 */