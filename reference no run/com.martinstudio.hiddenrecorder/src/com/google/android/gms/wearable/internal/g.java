package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g
  implements DataEvent
{
  private int AQ;
  private DataItem alE;
  
  public g(DataEvent paramDataEvent)
  {
    this.AQ = paramDataEvent.getType();
    this.alE = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.alE;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataEvent nk()
  {
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.g
 * JD-Core Version:    0.7.0.1
 */