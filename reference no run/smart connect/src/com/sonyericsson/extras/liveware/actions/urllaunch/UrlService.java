package com.sonyericsson.extras.liveware.actions.urllaunch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class UrlService
  extends ActionService
{
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString2));
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        i = 0;
      }
      else
      {
        Dbg.d("No URL setting.");
        label60:
        i = 1;
      }
    }
    catch (Exception localException)
    {
      break label60;
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.urllaunch.UrlService
 * JD-Core Version:    0.7.0.1
 */