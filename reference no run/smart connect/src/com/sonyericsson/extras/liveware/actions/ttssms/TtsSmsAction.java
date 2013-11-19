package com.sonyericsson.extras.liveware.actions.ttssms;

import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class TtsSmsAction
  extends ActionForResultService
{
  protected void disable()
  {
    Dbg.d("TtsSmsAction - disable");
    if (TtsSmsUtils.isSpeakSmsEnabled(this)) {
      TtsSmsUtils.enablesSpeakSms(this, false);
    }
    replyAndStop(0);
  }
  
  protected void enable()
  {
    Dbg.d("TtsSmsAction - enable");
    if (!TtsSmsUtils.isSpeakSmsEnabled(this)) {
      TtsSmsUtils.enablesSpeakSms(this, true);
    }
    replyAndStop(0);
  }
  
  protected void onStateChange(Intent paramIntent) {}
  
  protected void toggle()
  {
    Dbg.d("TtsSmsAction - toggle");
    boolean bool;
    if (!TtsSmsUtils.isSpeakSmsEnabled(this)) {
      bool = true;
    } else {
      bool = false;
    }
    TtsSmsUtils.enablesSpeakSms(this, bool);
    replyAndStop(0);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsAction
 * JD-Core Version:    0.7.0.1
 */