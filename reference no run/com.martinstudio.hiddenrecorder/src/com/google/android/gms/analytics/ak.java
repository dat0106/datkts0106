package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class ak
{
  private static final char[] xB;
  
  static
  {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    arrayOfChar[10] = 65;
    arrayOfChar[11] = 66;
    arrayOfChar[12] = 67;
    arrayOfChar[13] = 68;
    arrayOfChar[14] = 69;
    arrayOfChar[15] = 70;
    xB = arrayOfChar;
  }
  
  public static Map<String, String> U(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int i = arrayOfString1.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localHashMap;
      }
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length <= 1)
      {
        if ((arrayOfString2.length == 1) && (arrayOfString2[0].length() != 0)) {
          localHashMap.put(arrayOfString2[0], null);
        }
      }
      else {
        localHashMap.put(arrayOfString2[0], arrayOfString2[1]);
      }
    }
  }
  
  public static String V(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (paramString.contains("?"))
      {
        localObject = paramString.split("[\\?]");
        if (localObject.length > 1) {
          paramString = localObject[1];
        }
      }
      if (paramString.contains("%3D")) {}
      StringBuilder localStringBuilder;
      while (paramString.contains("=")) {
        try
        {
          localObject = URLDecoder.decode(paramString, "UTF-8");
          paramString = (String)localObject;
          Map localMap = U(paramString);
          String[] arrayOfString = new String[9];
          arrayOfString[0] = "dclid";
          arrayOfString[1] = "utm_source";
          arrayOfString[2] = "gclid";
          arrayOfString[3] = "utm_campaign";
          arrayOfString[4] = "utm_medium";
          arrayOfString[5] = "utm_term";
          arrayOfString[6] = "utm_content";
          arrayOfString[7] = "utm_id";
          arrayOfString[8] = "gmob_t";
          localStringBuilder = new StringBuilder();
          for (int i = 0; i < arrayOfString.length; i++) {
            if (!TextUtils.isEmpty((CharSequence)localMap.get(arrayOfString[i])))
            {
              if (localStringBuilder.length() > 0) {
                localStringBuilder.append("&");
              }
              localStringBuilder.append(arrayOfString[i]).append("=").append((String)localMap.get(arrayOfString[i]));
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          str = null;
        }
      }
      String str = null;
      continue;
      str = localStringBuilder.toString();
    }
  }
  
  public static MessageDigest W(String paramString)
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      try
      {
        localMessageDigest = MessageDigest.getInstance(paramString);
        localMessageDigest = localMessageDigest;
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
      break;
      MessageDigest localMessageDigest = null;
    }
  }
  
  public static double a(String paramString, double paramDouble)
  {
    if (paramString == null) {}
    for (;;)
    {
      return paramDouble;
      try
      {
        double d = Double.parseDouble(paramString);
        paramDouble = d;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  static String a(Locale paramLocale)
  {
    Object localObject = null;
    if ((paramLocale != null) && (!TextUtils.isEmpty(paramLocale.getLanguage())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLocale.getLanguage().toLowerCase());
      if (!TextUtils.isEmpty(paramLocale.getCountry())) {
        ((StringBuilder)localObject).append("-").append(paramLocale.getCountry().toLowerCase());
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean d(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("true")) && (!paramString.equalsIgnoreCase("yes")) && (!paramString.equalsIgnoreCase("1")))
      {
        if ((paramString.equalsIgnoreCase("false")) || (paramString.equalsIgnoreCase("no")) || (paramString.equalsIgnoreCase("0"))) {
          paramBoolean = false;
        }
      }
      else {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  static String v(boolean paramBoolean)
  {
    String str;
    if (!paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ak
 * JD-Core Version:    0.7.0.1
 */