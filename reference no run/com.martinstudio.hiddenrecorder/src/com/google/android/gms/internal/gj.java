package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class gj
{
  public static <T> boolean a(T paramT1, T paramT2)
  {
    boolean bool;
    if (((paramT1 != null) || (paramT2 != null)) && ((paramT1 == null) || (paramT2 == null) || (!paramT1.equals(paramT2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void ak(String paramString)
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() <= 128)
      {
        if (paramString.startsWith("urn:x-cast:"))
        {
          if (paramString.length() != "urn:x-cast:".length()) {
            return;
          }
          throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
        throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
      }
      throw new IllegalArgumentException("Invalid namespace length");
    }
    throw new IllegalArgumentException("Namespace cannot be null or empty");
  }
  
  public static String al(String paramString)
  {
    return "urn:x-cast:" + paramString;
  }
  
  public static long b(double paramDouble)
  {
    return (1000.0D * paramDouble);
  }
  
  public static String b(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append('-').append(str);
    }
    str = paramLocale.getVariant();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append('-').append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static double o(long paramLong)
  {
    return paramLong / 1000.0D;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gj
 * JD-Core Version:    0.7.0.1
 */