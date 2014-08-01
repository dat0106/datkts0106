package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay
{
  private static String afP;
  static Map<String, String> afQ = new HashMap();
  
  static void bX(String paramString)
  {
    try
    {
      afP = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String d(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = (String)afQ.get(paramString1);
    if (localObject == null)
    {
      localObject = paramContext.getSharedPreferences("gtm_click_referrers", 0);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((SharedPreferences)localObject).getString(paramString1, "");
      }
      afQ.put(paramString1, localObject);
    }
    return p((String)localObject, paramString2);
  }
  
  static void d(Context paramContext, String paramString)
  {
    cy.a(paramContext, "gtm_install_referrer", "referrer", paramString);
    f(paramContext, paramString);
  }
  
  /* Error */
  static String e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 23	com/google/android/gms/tagmanager/ay:afP	Ljava/lang/String;
    //   3: ifnonnull +40 -> 43
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 23	com/google/android/gms/tagmanager/ay:afP	Ljava/lang/String;
    //   12: ifnonnull +28 -> 40
    //   15: aload_0
    //   16: ldc 59
    //   18: iconst_0
    //   19: invokevirtual 41	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +27 -> 51
    //   27: aload_2
    //   28: ldc 61
    //   30: ldc 43
    //   32: invokeinterface 49 3 0
    //   37: putstatic 23	com/google/android/gms/tagmanager/ay:afP	Ljava/lang/String;
    //   40: ldc 2
    //   42: monitorexit
    //   43: getstatic 23	com/google/android/gms/tagmanager/ay:afP	Ljava/lang/String;
    //   46: aload_1
    //   47: invokestatic 56	com/google/android/gms/tagmanager/ay:p	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: areturn
    //   51: ldc 43
    //   53: putstatic 23	com/google/android/gms/tagmanager/ay:afP	Ljava/lang/String;
    //   56: goto -16 -> 40
    //   59: astore_2
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   0	65	1	paramString	String
    //   22	6	2	localSharedPreferences	SharedPreferences
    //   59	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	43	59	finally
    //   51	63	59	finally
  }
  
  static void f(Context paramContext, String paramString)
  {
    String str = p(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      afQ.put(str, paramString);
      cy.a(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  static String p(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramString1 = Uri.parse("http://hostname/?" + paramString1).getQueryParameter(paramString2);
    } else if (paramString1.length() <= 0) {
      paramString1 = null;
    }
    return paramString1;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ay
 * JD-Core Version:    0.7.0.1
 */