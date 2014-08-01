package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class hn
{
  public static void A(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void C(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
  
  public static String aE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  public static void ay(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static void az(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static <T> T b(T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static String b(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void b(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  public static <T> T f(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException("null reference");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hn
 * JD-Core Version:    0.7.0.1
 */