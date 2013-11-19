package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

public class Log
{
  @VisibleForTesting
  static final String LOG_TAG = "GAV2";
  private static boolean sDebug;
  
  public static int d(String paramString)
  {
    return android.util.Log.d("GAV2", formatMessage(paramString));
  }
  
  public static int dDebug(String paramString)
  {
    int i;
    if (!sDebug) {
      i = 0;
    } else {
      i = d(paramString);
    }
    return i;
  }
  
  public static int e(String paramString)
  {
    return android.util.Log.e("GAV2", formatMessage(paramString));
  }
  
  public static int eDebug(String paramString)
  {
    int i;
    if (!sDebug) {
      i = 0;
    } else {
      i = e(paramString);
    }
    return i;
  }
  
  private static String formatMessage(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }
  
  public static int i(String paramString)
  {
    return android.util.Log.i("GAV2", formatMessage(paramString));
  }
  
  public static int iDebug(String paramString)
  {
    int i;
    if (!sDebug) {
      i = 0;
    } else {
      i = i(paramString);
    }
    return i;
  }
  
  public static boolean isDebugEnabled()
  {
    return sDebug;
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    sDebug = paramBoolean;
  }
  
  public static int v(String paramString)
  {
    return android.util.Log.v("GAV2", formatMessage(paramString));
  }
  
  public static int vDebug(String paramString)
  {
    int i;
    if (!sDebug) {
      i = 0;
    } else {
      i = v(paramString);
    }
    return i;
  }
  
  public static int w(String paramString)
  {
    return android.util.Log.w("GAV2", formatMessage(paramString));
  }
  
  public static int wDebug(String paramString)
  {
    int i;
    if (!sDebug) {
      i = 0;
    } else {
      i = w(paramString);
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Log
 * JD-Core Version:    0.7.0.1
 */