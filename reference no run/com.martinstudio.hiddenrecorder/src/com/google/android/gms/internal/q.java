package com.google.android.gms.internal;

import java.io.IOException;

class q
  implements o
{
  private ma kl;
  private byte[] km;
  private final int kn;
  
  public q(int paramInt)
  {
    this.kn = paramInt;
    reset();
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    this.kl.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    this.kl.b(paramInt, paramString);
  }
  
  public void reset()
  {
    this.km = new byte[this.kn];
    this.kl = ma.q(this.km);
  }
  
  public byte[] z()
    throws IOException
  {
    int i = this.kl.nL();
    if (i >= 0)
    {
      byte[] arrayOfByte;
      if (i != 0)
      {
        arrayOfByte = new byte[this.km.length - i];
        System.arraycopy(this.km, 0, arrayOfByte, 0, arrayOfByte.length);
      }
      else
      {
        arrayOfByte = this.km;
      }
      return arrayOfByte;
    }
    throw new IOException();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.q
 * JD-Core Version:    0.7.0.1
 */