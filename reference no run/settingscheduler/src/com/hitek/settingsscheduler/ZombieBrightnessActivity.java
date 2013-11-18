package com.hitek.settingsscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class ZombieBrightnessActivity
  extends Activity
{
  private void setBrightness()
  {
    try
    {
      Intent localIntent = getIntent();
      Object localObject = localIntent.getStringExtra("taskType");
      if (((String)localObject).equals("level"))
      {
        float f = Float.parseFloat(localIntent.getStringExtra("value"));
        localObject = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).screenBrightness = (f / 255.0F);
        getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      }
      for (;;)
      {
        new Thread()
        {
          public void run()
          {
            try
            {
              sleep(500L);
              label6:
              jdField_this.finish();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              break label6;
            }
          }
        }.start();
        return;
        if (((String)localObject).equals("mode"))
        {
          WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
          localLayoutParams.screenBrightness = Settings.System.getInt(getContentResolver(), "screen_brightness");
          getWindow().setAttributes(localLayoutParams);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("Bright", "setBrightness: " + localException);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    setBrightness();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230722, paramMenu);
    return true;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.ZombieBrightnessActivity
 * JD-Core Version:    0.7.0.1
 */