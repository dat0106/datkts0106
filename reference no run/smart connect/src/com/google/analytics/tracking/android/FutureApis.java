package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class FutureApis
{
  static boolean setOwnerOnlyReadWrite(String paramString)
  {
    int i = 0;
    boolean bool;
    if (version() >= 9)
    {
      File localFile = new File(paramString);
      localFile.setReadable(false, false);
      localFile.setWritable(false, false);
      localFile.setReadable(true, true);
      localFile.setWritable(true, true);
      bool = true;
    }
    return bool;
  }
  
  public static int version()
  {
    try
    {
      i = Integer.parseInt(Build.VERSION.SDK);
      i = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.e("Invalid version number: " + Build.VERSION.SDK);
        int i = 0;
      }
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.FutureApis
 * JD-Core Version:    0.7.0.1
 */