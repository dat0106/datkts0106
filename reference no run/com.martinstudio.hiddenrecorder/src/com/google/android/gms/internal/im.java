package com.google.android.gms.internal;

public final class im
  implements ik
{
  private static im Hs;
  
  /**
   * @deprecated
   */
  public static ik fW()
  {
    try
    {
      if (Hs == null) {
        Hs = new im();
      }
      im localim = Hs;
      return localim;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.im
 * JD-Core Version:    0.7.0.1
 */