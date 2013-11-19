package com.sonyericsson.extras.liveware.actions.brightness;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class BrightnessAction
  extends ActionService
{
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 != null) && (paramString1.length() > 0) && (!TextUtils.isEmpty(paramString2))) {}
    try
    {
      int k = Integer.parseInt(paramString2);
      Dbg.d("BrightnessAction: executeAction, brightness=" + k);
      if ((k < 20) || (k > 255)) {
        break label147;
      }
      if (!Settings.System.putInt(getContentResolver(), "screen_brightness", k)) {
        break label138;
      }
      Intent localIntent = new Intent(paramContext, ChangeBrightnessActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("brightness", k);
      startActivity(localIntent);
      j = 0;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Dbg.e(localNumberFormatException);
        int j = j;
        continue;
        Dbg.w("BrightnessAction: executeAction, failed to set brightness");
        continue;
        Dbg.w("BrightnessAction: executeAction, no settings found");
      }
    }
    j = j;
    return j;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.brightness.BrightnessAction
 * JD-Core Version:    0.7.0.1
 */