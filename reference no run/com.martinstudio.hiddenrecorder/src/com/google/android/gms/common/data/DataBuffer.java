package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder DD;
  
  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.DD = paramDataHolder;
    if (this.DD != null) {
      this.DD.b(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle eP()
  {
    return this.DD.eP();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    int i;
    if (this.DD != null) {
      i = this.DD.getCount();
    } else {
      i = 0;
    }
    return i;
  }
  
  @Deprecated
  public boolean isClosed()
  {
    boolean bool;
    if (this.DD != null) {
      bool = this.DD.isClosed();
    } else {
      bool = true;
    }
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    return new c(this);
  }
  
  public void release()
  {
    if (this.DD != null) {
      this.DD.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * JD-Core Version:    0.7.0.1
 */