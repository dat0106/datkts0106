package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;

public class ActivityCompat
  extends ContextCompat
{
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11)
    {
      bool = false;
    }
    else
    {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */