package com.sonyericsson.extras.liveware.actions.facebook;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONObject;

public class FacebookService
  extends ActionService
{
  private static final String RESULT_ACTION = "com.sonyericsson.extras.liveware.FACEBOOK_RESULT_INTENT";
  
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    Dbg.d("executeAction");
    String str = "";
    try
    {
      Object localObject = new JSONObject(paramString2);
      int k = ((JSONObject)localObject).getInt("facebook_audience");
      str = ((JSONObject)localObject).getString("facebook_message");
      localObject = FacebookUtils.getInstance(this);
      Intent localIntent = new Intent("com.sonyericsson.extras.liveware.FACEBOOK_RESULT_INTENT");
      localIntent.putExtra("id", paramString1);
      localIntent.addFlags(268435456);
      i = ((FacebookUtils)localObject).postMessageOnWall(k, str, localIntent);
      if (i == 0) {
        break label127;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (Dbg.e()) {
          Dbg.e("Unable to post to facebook: " + i, localException);
        }
        int j = 1;
      }
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookService
 * JD-Core Version:    0.7.0.1
 */