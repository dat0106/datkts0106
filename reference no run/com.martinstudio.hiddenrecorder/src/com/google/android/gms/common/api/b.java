package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class b
  implements Releasable, Result
{
  protected final DataHolder DD;
  protected final Status yw;
  
  protected b(DataHolder paramDataHolder)
  {
    this.yw = new Status(paramDataHolder.getStatusCode());
    this.DD = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  public void release()
  {
    if (this.DD != null) {
      this.DD.close();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.b
 * JD-Core Version:    0.7.0.1
 */