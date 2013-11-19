package com.sonyericsson.extras.liveware.utils;

public class SyncedProperty<T>
{
  private T mValue;
  
  public SyncedProperty(T paramT)
  {
    this.mValue = paramT;
  }
  
  /**
   * @deprecated
   */
  public T get()
  {
    try
    {
      Object localObject1 = this.mValue;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public void set(T paramT)
  {
    try
    {
      this.mValue = paramT;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.SyncedProperty
 * JD-Core Version:    0.7.0.1
 */