package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class hq
{
  public static String a(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    String str1;
    if (paramAttributeSet == null) {
      str1 = null;
    }
    for (;;)
    {
      String str3;
      String str2;
      TypedValue localTypedValue;
      if ((str1 != null) && (str1.startsWith("@string/")) && (paramBoolean1))
      {
        str3 = str1.substring("@string/".length());
        str2 = paramContext.getPackageName();
        localTypedValue = new TypedValue();
      }
      try
      {
        paramContext.getResources().getValue(str2 + ":string/" + str3, localTypedValue, true);
        if (localTypedValue.string != null)
        {
          str1 = localTypedValue.string.toString();
          if ((paramBoolean2) && (str1 == null)) {
            Log.w(paramString3, "Required XML attribute \"" + paramString2 + "\" missing");
          }
          return str1;
          str1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          Log.w(paramString3, "Could not find resource for " + paramString2 + ": " + str1);
          continue;
          Log.w(paramString3, "Resource " + paramString2 + " was not a string: " + localTypedValue);
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hq
 * JD-Core Version:    0.7.0.1
 */