package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

public class a
{
  private static boolean a = Log.isLoggable("GoogleAdsAssertion", 3);
  
  public static void a(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, "Assertion that an object is null failed.");
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 != paramObject2) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, "Assertion that 'a' and 'b' refer to the same object failed.a: " + paramObject1 + ", b: " + paramObject2);
  }
  
  public static void a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, "Expected a non empty string, got: " + paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    c(paramBoolean, "Assertion failed.");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    c(paramBoolean, paramString);
  }
  
  public static void b(Object paramObject)
  {
    boolean bool;
    if (paramObject == null) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, "Assertion that an object is not null failed.");
  }
  
  public static void b(boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, "Assertion failed.");
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    boolean bool;
    if (paramBoolean) {
      bool = false;
    } else {
      bool = true;
    }
    c(bool, paramString);
  }
  
  private static void c(boolean paramBoolean, String paramString)
  {
    if (((!Log.isLoggable("GoogleAdsAssertion", 3)) && (!a)) || (paramBoolean)) {
      return;
    }
    a locala = new a(paramString);
    Log.d("GoogleAdsAssertion", paramString, locala);
    throw locala;
  }
  
  public static class a
    extends Error
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.util.a
 * JD-Core Version:    0.7.0.1
 */