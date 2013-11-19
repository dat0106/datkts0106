package com.sonyericsson.extras.liveware.actions.clearaudio;

import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ReflectionUtils;

public class ClearAudioAction
  extends ActionForResultService
{
  private boolean isClearAudioOn()
  {
    return ReflectionUtils.getResultFromMethod("com.sonymobile.audioeffect.ClearAudioPlus", "getCurrentState", getBaseContext());
  }
  
  private void sendClearAudioIntent(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    Intent localIntent = new Intent("com.sonymobile.audioeffect.intent.action.CLEARAUDIO_PLUS_REQUEST");
    localIntent.putExtra("com.sonymobile.audioeffect.intent.extra.CLEARAUDIO_PLUS_STATUS", i);
    sendBroadcast(localIntent);
    waitForStateChange("com.sonymobile.audioeffect.intent.action.CLEARAUDIO_PLUS_STATUS");
    replyAndStop(0);
  }
  
  protected void disable()
  {
    if (isClearAudioOn()) {
      sendClearAudioIntent(false);
    } else {
      replyAndStop(0);
    }
  }
  
  protected void enable()
  {
    if (!isClearAudioOn()) {
      sendClearAudioIntent(true);
    } else {
      replyAndStop(0);
    }
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    Dbg.d("Got something back, be content for now.");
    replyAndStop(0);
  }
  
  protected void toggle()
  {
    boolean bool;
    if (!isClearAudioOn()) {
      bool = true;
    } else {
      bool = false;
    }
    sendClearAudioIntent(bool);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.clearaudio.ClearAudioAction
 * JD-Core Version:    0.7.0.1
 */