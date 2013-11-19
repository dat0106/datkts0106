package com.sonyericsson.extras.liveware.asf.event;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.asf.EventReceiver;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class NfcHandlerActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Dbg.v()) {
      Dbg.v("NfcHandlerActivity - onCreate()");
    }
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      localIntent.setComponent(new ComponentName(this, EventReceiver.class));
      sendBroadcast(localIntent);
    }
    finish();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.NfcHandlerActivity
 * JD-Core Version:    0.7.0.1
 */