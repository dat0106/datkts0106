package com.google.android.gms.internal;

import java.io.IOException;

public abstract class mf
{
  protected volatile int amY = -1;
  
  public static final <T extends mf> T a(T paramT, byte[] paramArrayOfByte)
    throws me
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(mf parammf, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      ma localma = ma.b(paramArrayOfByte, paramInt1, paramInt2);
      parammf.a(localma);
      localma.nM();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public static final <T extends mf> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws me
  {
    try
    {
      lz locallz = lz.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(locallz);
      locallz.eu(0);
      return paramT;
    }
    catch (me localme)
    {
      throw localme;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] d(mf parammf)
  {
    byte[] arrayOfByte = new byte[parammf.nV()];
    a(parammf, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(ma paramma)
    throws IOException
  {}
  
  public abstract mf b(lz paramlz)
    throws IOException;
  
  protected int c()
  {
    return 0;
  }
  
  public int nU()
  {
    if (this.amY < 0) {
      nV();
    }
    return this.amY;
  }
  
  public int nV()
  {
    int i = c();
    this.amY = i;
    return i;
  }
  
  public String toString()
  {
    return mg.e(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mf
 * JD-Core Version:    0.7.0.1
 */