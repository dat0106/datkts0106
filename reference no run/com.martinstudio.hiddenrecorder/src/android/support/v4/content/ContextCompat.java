package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_CACHE = "cache";
  private static final String DIR_DATA = "data";
  private static final String DIR_FILES = "files";
  private static final String DIR_OBB = "obb";
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    Object localObject1;
    for (Object localObject2 = paramFile;; localObject2 = localObject1)
    {
      if (j >= i) {
        return localObject2;
      }
      localObject1 = paramVarArgs[j];
      if (localObject2 != null)
      {
        if (localObject1 == null) {
          localObject1 = localObject2;
        } else {
          localObject1 = new File((File)localObject2, (String)localObject1);
        }
      }
      else {
        localObject1 = new File((String)localObject1);
      }
      j++;
    }
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2;
    if (i < 19)
    {
      Object localObject1;
      if (i < 8)
      {
        localObject2 = Environment.getExternalStorageDirectory();
        localObject1 = new String[4];
        localObject1[0] = "Android";
        localObject1[1] = "data";
        localObject1[2] = paramContext.getPackageName();
        localObject1[3] = "cache";
        localObject1 = buildPath((File)localObject2, (String[])localObject1);
      }
      else
      {
        localObject1 = ContextCompatFroyo.getExternalCacheDir(paramContext);
      }
      localObject2 = new File[1];
      localObject2[0] = localObject1;
    }
    else
    {
      localObject2 = ContextCompatKitKat.getExternalCacheDirs(paramContext);
    }
    return localObject2;
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i < 19)
    {
      File localFile;
      if (i < 8)
      {
        localFile = Environment.getExternalStorageDirectory();
        localObject = new String[5];
        localObject[0] = "Android";
        localObject[1] = "data";
        localObject[2] = paramContext.getPackageName();
        localObject[3] = "files";
        localObject[4] = paramString;
        localFile = buildPath(localFile, (String[])localObject);
      }
      else
      {
        localFile = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString);
      }
      localObject = new File[1];
      localObject[0] = localFile;
    }
    else
    {
      localObject = ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
    }
    return localObject;
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i < 19)
    {
      File localFile;
      if (i < 11)
      {
        localFile = Environment.getExternalStorageDirectory();
        localObject = new String[3];
        localObject[0] = "Android";
        localObject[1] = "obb";
        localObject[2] = paramContext.getPackageName();
        localFile = buildPath(localFile, (String[])localObject);
      }
      else
      {
        localFile = ContextCompatHoneycomb.getObbDir(paramContext);
      }
      localObject = new File[1];
      localObject[0] = localFile;
    }
    else
    {
      localObject = ContextCompatKitKat.getObbDirs(paramContext);
    }
    return localObject;
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i < 16)
    {
      if (i < 11) {
        bool = false;
      } else {
        ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      }
    }
    else {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.7.0.1
 */