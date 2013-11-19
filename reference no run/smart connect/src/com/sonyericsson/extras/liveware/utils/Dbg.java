package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class Dbg
{
  private static final String DEBUG_FILE = "lwm_debug";
  private static final String LOG_TAG = "LiveWare - ";
  private static boolean sDebug = false;
  
  public static boolean d()
  {
    return sDebug;
  }
  
  public static boolean d(String paramString)
  {
    if (sDebug) {
      Log.d("LiveWare - ", paramString);
    }
    return sDebug;
  }
  
  public static boolean d(String paramString, Throwable paramThrowable)
  {
    if (sDebug) {
      Log.d("LiveWare - ", paramString, paramThrowable);
    }
    return sDebug;
  }
  
  public static boolean e()
  {
    return sDebug;
  }
  
  public static boolean e(String paramString)
  {
    if (sDebug) {
      Log.e("LiveWare - ", paramString);
    }
    return sDebug;
  }
  
  public static boolean e(String paramString, Throwable paramThrowable)
  {
    if (sDebug) {
      Log.e("LiveWare - ", paramString, paramThrowable);
    }
    return sDebug;
  }
  
  public static boolean e(Throwable paramThrowable)
  {
    if (sDebug) {
      Log.e("LiveWare - ", "", paramThrowable);
    }
    return sDebug;
  }
  
  public static void initDebugFlag(Context paramContext)
  {
    sDebug = false;
    try
    {
      paramContext.openFileInput("lwm_debug").close();
      sDebug = true;
      Log.v("LiveWare - ", "Found lwm_debug in application directory");
      return;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        File localFile = new File(Environment.getExternalStorageDirectory(), "lwm_debug");
        try
        {
          new FileInputStream(localFile).close();
          sDebug = true;
          Log.v("LiveWare - ", "Found lwm_debug in " + localFile.getAbsolutePath());
        }
        catch (IOException localIOException2) {}
      }
    }
  }
  
  public static boolean isDebugMode()
  {
    return sDebug;
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    sDebug = paramBoolean;
  }
  
  public static boolean v()
  {
    return sDebug;
  }
  
  public static boolean v(String paramString)
  {
    if (sDebug) {
      Log.v("LiveWare - ", paramString);
    }
    return sDebug;
  }
  
  public static boolean w()
  {
    return sDebug;
  }
  
  public static boolean w(String paramString)
  {
    if (sDebug) {
      Log.w("LiveWare - ", paramString);
    }
    return sDebug;
  }
  
  public static boolean w(String paramString, Throwable paramThrowable)
  {
    if (sDebug) {
      Log.w("LiveWare - ", paramString, paramThrowable);
    }
    return sDebug;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.Dbg
 * JD-Core Version:    0.7.0.1
 */