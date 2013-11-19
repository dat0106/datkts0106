package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class BaseDialogActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    if (!AsfUtils.isSonyDevice()) {
      setTheme(2131361941);
    }
    super.onCreate(paramBundle);
    UIUtils.applyDirectionalityToDecorWindow(this);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.BaseDialogActivity
 * JD-Core Version:    0.7.0.1
 */