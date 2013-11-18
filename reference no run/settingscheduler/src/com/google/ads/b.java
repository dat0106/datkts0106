package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class b
{
  private static b c = null;
  private final BigInteger a = d();
  private BigInteger b = BigInteger.ONE;
  
  /**
   * @deprecated
   */
  public static b a()
  {
    try
    {
      if (c == null) {
        c = new b();
      }
      b localb = c;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static byte[] a(long paramLong)
  {
    return BigInteger.valueOf(paramLong).toByteArray();
  }
  
  private static BigInteger d()
  {
    try
    {
      Object localObject1 = MessageDigest.getInstance("MD5");
      Object localObject2 = UUID.randomUUID();
      ((MessageDigest)localObject1).update(a(((UUID)localObject2).getLeastSignificantBits()));
      ((MessageDigest)localObject1).update(a(((UUID)localObject2).getMostSignificantBits()));
      localObject2 = new byte[9];
      localObject2[0] = 0;
      System.arraycopy(((MessageDigest)localObject1).digest(), 0, localObject2, 1, 8);
      localObject1 = new BigInteger((byte[])localObject2);
      return localObject1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Cannot find MD5 message digest algorithm.");
    }
  }
  
  /**
   * @deprecated
   */
  public BigInteger b()
  {
    try
    {
      BigInteger localBigInteger = this.a;
      return localBigInteger;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public BigInteger c()
  {
    try
    {
      BigInteger localBigInteger = this.b;
      this.b = this.b.add(BigInteger.ONE);
      return localBigInteger;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.b
 * JD-Core Version:    0.7.0.1
 */