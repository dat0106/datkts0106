package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T>
  extends c<T>
{
  private T ET;
  
  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (hasNext())
    {
      this.Ey = (1 + this.Ey);
      if (this.Ey != 0)
      {
        ((d)this.ET).ac(this.Ey);
      }
      else
      {
        this.ET = this.Ex.get(0);
        if (!(this.ET instanceof d)) {
          break label68;
        }
      }
      return this.ET;
      label68:
      throw new IllegalStateException("DataBuffer reference of type " + this.ET.getClass() + " is not movable");
    }
    throw new NoSuchElementException("Cannot advance the iterator beyond " + this.Ey);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.h
 * JD-Core Version:    0.7.0.1
 */