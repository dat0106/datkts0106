package com.sonyericsson.extras.liveware.actions;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public abstract class ActionService
  extends IntentService
{
  private static final String TAG = "ActionService";
  protected Intent mIntent;
  
  public ActionService()
  {
    super("ActionService");
  }
  
  public abstract int executeAction(Context paramContext, String paramString1, String paramString2);
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Dbg.d("onHandleIntent");
    this.mIntent = paramIntent;
    String str2 = paramIntent.getStringExtra("id");
    String str1 = paramIntent.getStringExtra("setting_raw");
    int i = 1;
    if (str1 != null) {
      i = executeAction(this, str2, str1);
    }
    ActionUtils.sendExecuteReplyIntent(this, str2, i);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ActionService
 * JD-Core Version:    0.7.0.1
 */