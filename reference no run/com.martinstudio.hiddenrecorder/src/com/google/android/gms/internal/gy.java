package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class gy
{
  public static void A(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void ay(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      return;
    }
    Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
    throw new IllegalStateException(paramString);
  }
  
  public static void az(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      return;
    }
    Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
    throw new IllegalStateException(paramString);
  }
  
  public static void c(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException("null reference");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gy
 * JD-Core Version:    0.7.0.1
 */