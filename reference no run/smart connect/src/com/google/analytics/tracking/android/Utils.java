package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{
  private static final char[] HEXBYTES;
  
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
    HEXBYTES = arrayOfChar;
  }
  
  public static String filterCampaign(String paramString)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localObject1;
      Object localObject2 = paramString;
      if (paramString.contains("?")) {
        localObject2 = paramString.split("[\\?]")[1];
      }
      if (((String)localObject2).contains("%3D")) {}
      int i;
      while (i.contains("=")) {
        try
        {
          localObject1 = URLDecoder.decode((String)localObject2, "UTF-8");
          localObject2 = localObject1;
          Map localMap = parseURLParameters((String)localObject2);
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
          localObject1 = new StringBuilder();
          for (i = 0; i < arrayOfString.length; i++) {
            if (!TextUtils.isEmpty((CharSequence)localMap.get(arrayOfString[i])))
            {
              if (((StringBuilder)localObject1).length() > 0) {
                ((StringBuilder)localObject1).append("&");
              }
              ((StringBuilder)localObject1).append(arrayOfString[i]).append("=").append((String)localMap.get(arrayOfString[i]));
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      }
      continue;
      localObject1 = ((StringBuilder)localObject1).toString();
    }
  }
  
  static int fromHexDigit(char paramChar)
  {
    int i = paramChar + '￐';
    if (i > 9) {
      i += -7;
    }
    return i;
  }
  
  static String getLanguage(Locale paramLocale)
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
  
  static String getSlottedModelField(String paramString, int paramInt)
  {
    return paramString + "*" + paramInt;
  }
  
  static byte[] hexDecode(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0;; i++)
    {
      if (i >= arrayOfByte.length) {
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)(fromHexDigit(paramString.charAt(i * 2)) << 4 | fromHexDigit(paramString.charAt(1 + i * 2))));
    }
  }
  
  static String hexEncode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfByte.length) {
        return new String(arrayOfChar);
      }
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = HEXBYTES[(j >> 4)];
      arrayOfChar[(1 + i * 2)] = HEXBYTES[(j & 0xF)];
    }
  }
  
  public static Map<String, String> parseURLParameters(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString2 = paramString.split("&");
    int i = arrayOfString2.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localHashMap;
      }
      String[] arrayOfString1 = arrayOfString2[j].split("=");
      if (arrayOfString1.length <= 1)
      {
        if ((arrayOfString1.length == 1) && (arrayOfString1[0].length() != 0)) {
          localHashMap.put(arrayOfString1[0], null);
        }
      }
      else {
        localHashMap.put(arrayOfString1[0], arrayOfString1[1]);
      }
    }
  }
  
  public static boolean safeParseBoolean(String paramString)
  {
    return Boolean.parseBoolean(paramString);
  }
  
  public static double safeParseDouble(String paramString)
  {
    double d = 0.0D;
    if (paramString == null) {}
    for (;;)
    {
      return d;
      try
      {
        d = Double.parseDouble(paramString);
        d = d;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
  
  public static long safeParseLong(String paramString)
  {
    long l = 0L;
    if (paramString == null) {}
    for (;;)
    {
      return l;
      try
      {
        l = Long.parseLong(paramString);
        l = l;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Utils
 * JD-Core Version:    0.7.0.1
 */