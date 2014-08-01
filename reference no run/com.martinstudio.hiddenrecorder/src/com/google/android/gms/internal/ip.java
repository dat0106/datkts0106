package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ip
{
  public static void a(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
    paramStringBuilder.append("{");
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str4;
    String str3;
    for (String str2 = 1;; str3 = str4)
    {
      if (!localIterator.hasNext())
      {
        paramStringBuilder.append("}");
        return;
      }
      String str1 = (String)localIterator.next();
      if (str2 != 0)
      {
        str4 = 0;
      }
      else
      {
        paramStringBuilder.append(",");
        str4 = str2;
      }
      str3 = (String)paramHashMap.get(str1);
      paramStringBuilder.append("\"").append(str1).append("\":");
      if (str3 != null) {
        paramStringBuilder.append("\"").append(str3).append("\"");
      } else {
        paramStringBuilder.append("null");
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ip
 * JD-Core Version:    0.7.0.1
 */