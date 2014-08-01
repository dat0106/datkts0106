package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class em
{
  private static final Object qm = new Object();
  private static String sb;
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (qm)
    {
      if ((sb == null) && (!TextUtils.isEmpty(paramString1))) {
        b(paramContext, paramString1, paramString2);
      }
      String str = sb;
      return str;
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1;
    BigInteger localBigInteger;
    Object localObject2;
    try
    {
      localObject1 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, (ClassLoader)localObject1);
      localBigInteger = new BigInteger(new byte[1]);
      localObject2 = paramString1.split(",");
      localBigInteger = localBigInteger;
      int i = 0;
      while (i < localObject2.length)
      {
        if (ep.a((ClassLoader)localObject1, localClass, localObject2[i])) {
          localBigInteger = localBigInteger.setBit(i);
        }
        i++;
        continue;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      sb = "err";
    }
    for (;;)
    {
      localObject1 = Locale.US;
      localObject2 = new Object[1];
      localObject2[0] = localBigInteger;
      sb = String.format((Locale)localObject1, "%X", (Object[])localObject2);
    }
  }
  
  public static String bK()
  {
    synchronized (qm)
    {
      String str = sb;
      return str;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.em
 * JD-Core Version:    0.7.0.1
 */