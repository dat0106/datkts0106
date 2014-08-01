package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class db
{
  public static boolean a(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2, 0))) {
        ev.A("Signature verification failed.");
      }
      for (;;)
      {
        return bool;
        bool = true;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        ev.A("NoSuchAlgorithmException.");
      }
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      for (;;)
      {
        ev.A("Invalid key specification.");
      }
    }
    catch (SignatureException localSignatureException)
    {
      for (;;)
      {
        ev.A("Signature exception.");
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      bool = a(r(paramString1), paramString2, paramString3);
    }
    else
    {
      ev.A("Purchase verification failed: missing data.");
      bool = false;
    }
    return bool;
  }
  
  public static PublicKey r(String paramString)
  {
    try
    {
      Object localObject = Base64.decode(paramString, 0);
      localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      ev.A("Invalid key specification.");
      throw new IllegalArgumentException(localInvalidKeySpecException);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.db
 * JD-Core Version:    0.7.0.1
 */