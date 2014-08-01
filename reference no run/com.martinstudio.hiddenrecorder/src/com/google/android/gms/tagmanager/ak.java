package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import java.io.File;

class ak
{
  static boolean N(String paramString)
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
        bh.A("Invalid version number: " + Build.VERSION.SDK);
        int i = 0;
      }
    }
    return i;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ak
 * JD-Core Version:    0.7.0.1
 */