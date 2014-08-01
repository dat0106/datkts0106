package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";
  
  public static String getStorageState(File paramFile)
  {
    String str1;
    if (Build.VERSION.SDK_INT >= 19) {
      str1 = EnvironmentCompatKitKat.getStorageState(paramFile);
    }
    for (;;)
    {
      return str1;
      try
      {
        if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
        {
          str1 = Environment.getExternalStorageState();
          str1 = str1;
        }
      }
      catch (IOException localIOException)
      {
        Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + localIOException);
        String str2 = "unknown";
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.os.EnvironmentCompat
 * JD-Core Version:    0.7.0.1
 */