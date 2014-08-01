package com.google.android.gms.common.data;

import com.google.android.gms.internal.hn;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> Ex;
  protected int Ey;
  
  public c(DataBuffer<T> paramDataBuffer)
  {
    this.Ex = ((DataBuffer)hn.f(paramDataBuffer));
    this.Ey = -1;
  }
  
  public boolean hasNext()
  {
    boolean bool;
    if (this.Ey >= -1 + this.Ex.getCount()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public T next()
  {
    if (hasNext())
    {
      DataBuffer localDataBuffer = this.Ex;
      int i = 1 + this.Ey;
      this.Ey = i;
      return localDataBuffer.get(i);
    }
    throw new NoSuchElementException("Cannot advance the iterator beyond " + this.Ey);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.c
 * JD-Core Version:    0.7.0.1
 */