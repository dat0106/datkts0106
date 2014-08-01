package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class p
{
  private final n jQ;
  private final SecureRandom kj;
  
  public p(n paramn, SecureRandom paramSecureRandom)
  {
    this.jQ = paramn;
    this.kj = paramSecureRandom;
  }
  
  static void c(byte[] paramArrayOfByte)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfByte.length) {
        return;
      }
      paramArrayOfByte[i] = ((byte)(0x44 ^ paramArrayOfByte[i]));
    }
  }
  
  public byte[] b(String paramString)
    throws p.a
  {
    try
    {
      byte[] arrayOfByte1 = this.jQ.a(paramString, false);
      if (arrayOfByte1.length != 32) {
        throw new a();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new a(localIllegalArgumentException);
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(localIllegalArgumentException, 4, 16);
    byte[] arrayOfByte2 = new byte[16];
    localByteBuffer.get(arrayOfByte2);
    c(arrayOfByte2);
    return arrayOfByte2;
  }
  
  public byte[] c(byte[] paramArrayOfByte, String paramString)
    throws p.a
  {
    if (paramArrayOfByte.length != 16) {
      throw new a();
    }
    try
    {
      arrayOfByte2 = this.jQ.a(paramString, false);
      if (arrayOfByte2.length <= 16) {
        throw new a();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new a(localNoSuchAlgorithmException);
      Object localObject = ByteBuffer.allocate(arrayOfByte2.length);
      ((ByteBuffer)localObject).put(arrayOfByte2);
      ((ByteBuffer)localObject).flip();
      byte[] arrayOfByte1 = new byte[16];
      byte[] arrayOfByte2 = new byte[-16 + arrayOfByte2.length];
      ((ByteBuffer)localObject).get(arrayOfByte1);
      ((ByteBuffer)localObject).get(arrayOfByte2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
      localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(2, localSecretKeySpec, new IvParameterSpec(arrayOfByte1));
      arrayOfByte1 = ((Cipher)localObject).doFinal(arrayOfByte2);
      return arrayOfByte1;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new a(localInvalidKeyException);
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new a(localIllegalBlockSizeException);
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      throw new a(localNoSuchPaddingException);
    }
    catch (BadPaddingException localBadPaddingException)
    {
      throw new a(localBadPaddingException);
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      throw new a(localInvalidAlgorithmParameterException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new a(localIllegalArgumentException);
    }
  }
  
  public class a
    extends Exception
  {
    public a() {}
    
    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.p
 * JD-Core Version:    0.7.0.1
 */