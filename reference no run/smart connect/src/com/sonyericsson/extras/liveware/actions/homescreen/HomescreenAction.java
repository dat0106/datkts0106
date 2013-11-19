package com.sonyericsson.extras.liveware.actions.homescreen;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class HomescreenAction
  extends ActionService
{
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      i = 0;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i;
        Dbg.e(localRuntimeException);
        int j = 1;
      }
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.homescreen.HomescreenAction
 * JD-Core Version:    0.7.0.1
 */