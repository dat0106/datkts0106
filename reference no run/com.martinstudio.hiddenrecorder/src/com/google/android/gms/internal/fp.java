package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class fp
{
  private static final String[] xW;
  private static final Map<String, Integer> xX = new HashMap(xW.length);
  
  static
  {
    int i = 0;
    String[] arrayOfString = new String[9];
    arrayOfString[i] = "text1";
    arrayOfString[1] = "text2";
    arrayOfString[2] = "icon";
    arrayOfString[3] = "intent_action";
    arrayOfString[4] = "intent_data";
    arrayOfString[5] = "intent_data_id";
    arrayOfString[6] = "intent_extra_data";
    arrayOfString[7] = "suggest_large_icon";
    arrayOfString[8] = "intent_activity";
    xW = arrayOfString;
    for (;;)
    {
      if (i >= xW.length) {
        return;
      }
      xX.put(xW[i], Integer.valueOf(i));
      i++;
    }
  }
  
  public static String H(int paramInt)
  {
    String str;
    if ((paramInt >= 0) && (paramInt < xW.length)) {
      str = xW[paramInt];
    } else {
      str = null;
    }
    return str;
  }
  
  public static int Y(String paramString)
  {
    Integer localInteger = (Integer)xX.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
  }
  
  public static int dK()
  {
    return xW.length;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fp
 * JD-Core Version:    0.7.0.1
 */