package com.sonyericsson.extras.liveware.actions.brightness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class ChangeBrightnessActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    float f = getIntent().getIntExtra("brightness", 0);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.screenBrightness = (f / 255.0F);
    Dbg.d("ChangeBrightnessActivity: onCreate, changing window attributes (brightness=" + f / 255.0F + ")");
    getWindow().setAttributes(localLayoutParams);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        ChangeBrightnessActivity.this.finish();
      }
    }, 1000L);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.brightness.ChangeBrightnessActivity
 * JD-Core Version:    0.7.0.1
 */