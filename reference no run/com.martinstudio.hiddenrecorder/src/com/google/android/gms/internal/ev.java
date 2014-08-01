package com.google.android.gms.internal;

import android.util.Log;

public final class ev
{
  public static void A(String paramString)
  {
    if (p(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void B(String paramString)
  {
    if (p(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void C(String paramString)
  {
    if (p(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static void D(String paramString)
  {
    if (p(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (p(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (p(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (p(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean p(int paramInt)
  {
    boolean bool;
    if (((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && (paramInt != 2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void z(String paramString)
  {
    if (p(3)) {
      Log.d("Ads", paramString);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ev
 * JD-Core Version:    0.7.0.1
 */